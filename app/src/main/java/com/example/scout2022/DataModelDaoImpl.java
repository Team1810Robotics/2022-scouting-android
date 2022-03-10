package com.example.scout2022;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.BooleanUtils;
//import org.usd232.robotics.matchscouting2020.data.AllianceColor;
//import org.usd232.robotics.matchscouting2020.data.DataModelKey;
//import org.usd232.robotics.matchscouting2020.data.Stage;
//import org.usd232.robotics.matchscouting2020.data.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * DAO implementation that reads from and/or writes to a CSV file as its storage medium.
 *
 * @author Michael Sheehan
 */
public final class DataModelDaoImpl implements DataModelDao {
    private static final CSVFormat csvFormat
            = CSVFormat.DEFAULT.withHeader(HeaderEnum.class).withTrim().withIgnoreEmptyLines();
    private final File csvFileLocation;

    /**
     * Constructor.
     *
     * @param fileLocation File to read/write location.
     */
    public DataModelDaoImpl(final File fileLocation) {
        super();
        this.csvFileLocation = fileLocation;
    }

    private static void printDataModel(final DataModel data, final CSVPrinter csvPrinter) throws IOException {
        csvPrinter.printRecord(
                data.getMatchID(),
                data.getTeamID() == null ? "null" : Integer.parseInt(data.getTeamID().toString()),
                data.getAllianceColor() == null ? "null" : data.getAllianceColor().toString(),
                data.getAutoNumCargoLower(),
                data.getAutoNumCargoUpper(),
                data.getAutoNumCargoHeld(),
                data.getAutoCanMove(),
                data.getTeleopNumCargoLower(),
                data.getTeleopNumCargoUpper(),
                BooleanUtils.toStringTrueFalse(data.isTeleopColorCorrect()),
                //BooleanUtils.toStringTrueFalse(data.isTeleopBallPickupCorrect()),
                //data.getTeleopStageReached() == null ? "null" : data.getTeleopStageReached().getLabel(),
                data.getEndgameBarGrabPosition() == null ? "null" : data.getEndgameBarGrabPosition().getLabel(),
                BooleanUtils.toStringTrueFalse(data.isEndgameWon()));
                data.getEndNotes();
    }

    private static DataModel readDataModel(final CSVRecord rec) {
        final DataModel data = new DataModel();
        int pos = 0;
        //Basic
        data.setMatchID(Utils.toInt(rec.get(pos++)));
        data.setTeamID(TeamNumbers.fromValue(rec.get(pos++)));
        data.setAllianceColor(TeamColors.forLabel(rec.get(pos++)));
        //Auto
        data.setAutoNumCargoLower(Utils.toInt(rec.get(pos++)));
        data.setAutoNumCargoUpper(Utils.toInt(rec.get(pos++)));
        data.setAutoNumCargoHeld(Utils.toInt(rec.get(pos++)));
        data.setAutoCanMove(BooleanUtils.toBoolean(rec.get(pos++)));
        //TeleOp
        data.setTeleopNumCargoUpper(Utils.toInt(rec.get(pos++)));
        data.setTeleopNumCargoLower(Utils.toInt(rec.get(pos++)));
        data.setTeleopColorCorrect(BooleanUtils.toBoolean(rec.get(pos++)));
        data.setEndgameBarGrabPosition(BarGrabPosition.fromValue(rec.get(pos++)));
        //Final
        data.setEndgameWon(BooleanUtils.toBoolean(rec.get(pos++)));
        data.setEndNotes(rec.get(pos++));
        return data;
    }

    @Override
    public Map<DataModelKey, DataModel> readDataModels() throws IOException {
        if (!csvFileLocation.exists() && !csvFileLocation.createNewFile()) {
            throw new IOException("Could not create file '" + csvFileLocation.getAbsolutePath() + "'.");
        }

        final Map<DataModelKey, DataModel> rVal = new LinkedHashMap<>();
        try (final Reader reader = new FileReader(csvFileLocation);
             final CSVParser csvParser = new CSVParser(reader, csvFormat.withSkipHeaderRecord())) {
            for (final CSVRecord rec : csvParser) {
                final DataModelKey key = new DataModelKey();
                key.setMatchID(Utils.toInt(rec.get(0)));
                key.setTeamID(Utils.toInt(rec.get(1)));
                final DataModel data = readDataModel(rec);
                rVal.put(key, data);
            }
        }

        return rVal;
    }

    @Override
    public void appendDataModel(final DataModel data) throws IOException {
        System.out.println("data equals" + data);
        final Map<DataModelKey, DataModel> datas = readDataModels();
        final DataModelKey newKey = new DataModelKey();
        newKey.setTeamID(Integer.parseInt(data.getTeamID().getLabel()));
        newKey.setMatchID(data.getMatchID());
        if (datas.containsKey(newKey)) {
            throw new IOException("Data with key '" + newKey + "' already exists.");
        }

        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileLocation));
             final CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat)) {
            for (final DataModel dataOld : datas.values()) {
                printDataModel(dataOld, csvPrinter);
            }

            printDataModel(data, csvPrinter);
            csvPrinter.flush();
        }
    }

    @Override
    public void deleteAllDataModels() throws IOException {
        if (csvFileLocation.exists() && !csvFileLocation.delete()) {
            throw new IOException("Could not delete file '" + csvFileLocation.getAbsolutePath() + "'.");
        }
    }
}

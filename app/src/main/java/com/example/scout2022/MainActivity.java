package com.example.scout2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * min and max can be adjusted to yearly rules as needed
 */
public class MainActivity extends AppCompatActivity {
    private Utils Util = new Utils();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }
    public void CheckBoxUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        boolean variable;
        CheckBox CheckboxUpdate = findViewById(id); //find checkbox
        variable = CheckboxUpdate.isChecked() ? true : false;
        bundle.putBoolean(bundleLocation.toString(), variable); //update bundle value
        i.putExtras(bundle);
    }

    public void TextBoxUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        TextView TextViewUpdate = findViewById(id); //find textview (text input)
        String StringUpdate = TextViewUpdate.getText().toString(); //convert textview to string
        bundle.putString(bundleLocation.toString(), StringUpdate); //update bundle value
        i.putExtras(bundle);
    }

    public void NumBoxUpdate(int id, BundleValues bundleLocation) {
        final Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        TextView NumViewUpdate = findViewById(id); //find textview (text input)
        String StringToIntUpdate = NumViewUpdate.getText().toString(); //convert textview to string
        int variable =Integer.parseInt(StringToIntUpdate);
        bundle.putInt(bundleLocation.toString(), variable); //update bundle value
        i.putExtras(bundle);
    }

    public void MainActivityChange(View view) {
        final Intent i = new Intent(getApplicationContext(), page_Basic.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.putExtras(bundle);
        startActivity(i);
    }
}

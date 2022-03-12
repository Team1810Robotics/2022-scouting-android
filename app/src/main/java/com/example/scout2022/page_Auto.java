package com.example.scout2022;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * creates page
 */
public class page_Auto extends Activity {
    @Nullable
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page2);

    }


    public void AutoActivityChange(View view) {
        final Intent i = new Intent(getApplicationContext(), page_TeleOp.class);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }

        i.putExtras(bundle);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        final Intent i = new Intent(getApplicationContext(), page_Basic.class);
        Bundle bundle = getIntent().getExtras();
        i.putExtras(bundle);
        startActivity(i);
    }
}

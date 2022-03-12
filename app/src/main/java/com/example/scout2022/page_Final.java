package com.example.scout2022;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * creates page
 */
public class page_Final extends Activity {
    @Nullable
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page4);
    }

    @Override
    public void onBackPressed() {
        final Intent i = new Intent(getApplicationContext(), page_TeleOp.class);
        Bundle bundle = getIntent().getExtras();
        i.putExtras(bundle);
        startActivity(i);
    }
}
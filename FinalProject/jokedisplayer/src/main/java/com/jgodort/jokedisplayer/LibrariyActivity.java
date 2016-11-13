package com.jgodort.jokedisplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Javier Godino on 05/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class LibrariyActivity extends AppCompatActivity {

    public static final String JOKE_BUNDLE="JOKE_BUNDLE_CONTENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity);
    }

}

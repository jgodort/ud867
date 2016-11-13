package com.jgodort.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Javier Godino on 06/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class LibraryFragment extends Fragment {

    public LibraryFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.library_fragment, container, false);

        TextView textDisplayer = (TextView) rootView.findViewById(R.id.textDisplayer);
        Intent obtainedIntent = getActivity().getIntent();
        if (null != obtainedIntent) {
            String joke = obtainedIntent.getStringExtra(LibrariyActivity.JOKE_BUNDLE);

            textDisplayer.setText(joke);
        }
        return rootView;
    }
}


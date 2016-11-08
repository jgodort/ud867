package com.jgodort.tellingjokeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.JokeSmith;
import com.example.JokeWizard;

/**
 * Created by Javier Godino on 01/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        TextView textJoke = (TextView) rootView.findViewById(R.id.handcraftedJokeTextView);
        JokeSmith jokeSmith = new JokeSmith();

        textJoke.setText(jokeSmith.getJoke());

        TextView textWizard = (TextView) rootView.findViewById(R.id.wizardJokeTextView);
        JokeWizard jokeWizard = new JokeWizard();
        textWizard.setText(jokeWizard.getJoke());

        return rootView;

    }
}

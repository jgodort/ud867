package com.jgodort.builditbigger.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.jgodort.builditbigger.R;
import com.jgodort.builditbigger.async.EndpointAsyncTask;
import com.jgodort.jokedisplayer.LibrariyActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements EndpointAsyncTask.AsyncResponse {

    private ProgressBar spinner;
    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        Button button = (Button) root.findViewById(R.id.buttonJokes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                callToEndpoint();
            }
        });
        return root;
    }

    private void callToEndpoint() {
        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(getContext(), this);
        endpointAsyncTask.execute();
    }

    @Override
    public void getOnbtainedJoke(String joke) {

        if (null != joke) {

            Intent intentToLibrary = new Intent(getContext(), LibrariyActivity.class);
            intentToLibrary.putExtra(LibrariyActivity.JOKE_BUNDLE, joke);
            spinner.setVisibility(View.GONE);
            startActivity(intentToLibrary);
        }
    }
}

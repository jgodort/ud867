package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jgodort.jokesdisplayer.LibrariyActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.async.EndpointAsyncTask;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointAsyncTask.AsyncResponse {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) root.findViewById(R.id.buttonJokes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            startActivity(intentToLibrary);
        }
    }
}

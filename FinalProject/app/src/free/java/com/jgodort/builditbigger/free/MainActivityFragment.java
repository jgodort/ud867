package com.jgodort.builditbigger.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jgodort.builditbigger.R;
import com.jgodort.builditbigger.async.EndpointAsyncTask;
import com.jgodort.jokedisplayer.LibrariyActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements EndpointAsyncTask.AsyncResponse {


    InterstitialAd mInterstitialAd;
    private ProgressBar spinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                callToEndpoint();
            }
        });

        requestNewInterstitial();

        Button button = (Button) root.findViewById(R.id.buttonJokes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    callToEndpoint();
                }

            }
        });
        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
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

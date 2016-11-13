package com.jgodort.builditbigger.async;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jgodort.builtitbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Javier Godino on 07/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private AsyncResponse mDelegate;
    private static MyApi mApi;
    private Context mContext;

    public EndpointAsyncTask(Context context, AsyncResponse asyncResponse) {
        mContext = context;
        mDelegate=asyncResponse;
    }

    @Override
    protected String doInBackground(Void... params) {
        String retrievedJoke;
        if (null == mApi) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            mApi = builder.build();
        }

        try {
            retrievedJoke = mApi.getJokeFromBackend().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }

        return retrievedJoke;
    }

    @Override
    protected void onPostExecute(String s) {
        mDelegate.getOnbtainedJoke(s);
        super.onPostExecute(s);
    }

    public interface AsyncResponse {
        void getOnbtainedJoke(String joke);
    }
}

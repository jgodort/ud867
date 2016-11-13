package com.jgodort.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.jgodort.builditbigger.async.EndpointAsyncTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Javier Godino on 12/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class AsyncTaskJoke extends ApplicationTestCase<Application> implements EndpointAsyncTask.AsyncResponse {
    private CountDownLatch mcCountDownLatch;
    private String obtainedJoke;

    public AsyncTaskJoke() {
        super(Application.class);
    }


    public void testAsyncTaskJoke() throws Exception {
        mcCountDownLatch = new CountDownLatch(1);
        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(getContext(), this);
        endpointAsyncTask.execute();
        mcCountDownLatch.await();

        assertFalse("The obtained joke is empty", obtainedJoke == null || obtainedJoke.isEmpty());
        assertTrue("The obtained joke is not null", !obtainedJoke.isEmpty());

    }


    @Override
    public void getOnbtainedJoke(String joke) {
        this.obtainedJoke = joke;
        mcCountDownLatch.countDown();
    }
}

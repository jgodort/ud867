package com.example.android.clickcounter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Javier Godino on 03/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class CountTest {


    private ClickCounter clickCounter;

    @Before
    public void configureClickCounter() {
        clickCounter = new ClickCounter();
    }

    @Test
    public void testInitialValue() {
        Assert.assertEquals(clickCounter.getCount(), 0);

    }

    @Test
    public void testIncrementCounter() {
        int actualValue = clickCounter.getCount();
        clickCounter.increment();
        Assert.assertTrue(actualValue < clickCounter.getCount());
    }
}

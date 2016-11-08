package com.example.android.clickcounter;

import android.support.test.filters.MediumTest;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;

/**
 * Created by Javier Godino on 03/11/2016.
 * Email: jgodort.software@gmail.com
 */

public class ButtonClickTest extends ActivityInstrumentationTestCase2<ClickActivity> {

    private ClickActivity mClickActvity;
    private Button mButton;
    private TextView mTextView;

    public ButtonClickTest() {
        super(ClickActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mClickActvity = getActivity();
        mButton = (Button) mClickActvity.findViewById(R.id.click_button);
        mTextView = (TextView) mClickActvity.findViewById(R.id.click_count_text_view);
    }

    @MediumTest
    public void testInitValue() {

        int initialValue = Integer.valueOf(mTextView.getText().toString());
        TouchUtils.clickView(this, mButton);
        int actualValue = Integer.valueOf(mTextView.getText().toString());
        Assert.assertEquals(initialValue + 1, actualValue);

    }


}

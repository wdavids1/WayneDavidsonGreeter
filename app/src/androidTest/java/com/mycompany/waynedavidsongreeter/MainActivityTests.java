package com.mycompany.waynedavidsongreeter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Wayne on 2/21/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}

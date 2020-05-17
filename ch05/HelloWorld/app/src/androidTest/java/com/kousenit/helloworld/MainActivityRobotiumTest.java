package com.kousenit.helloworld;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class MainActivityRobotiumTest
    extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityRobotiumTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testMyActivity() {
        solo.assertCurrentActivity("MainActivity", MainActivity.class);
    }

    public void testSayHello() {
        solo.enterText(0, "Dolly");
        solo.clickOnButton(getActivity().getString(R.string.hello_button_label));
        solo.assertCurrentActivity("WelcomeActivity", WelcomeActivity.class);
        solo.searchText("Hello, Dolly!");
    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

}

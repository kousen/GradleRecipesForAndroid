package com.kousenit.helloworld;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 *
 * InstrumentationRegistry
 * https://stackoverflow.com/questions/38308041/applicationtestcase-deprecated-in-api-level-24
 *
 * Application
 * https://stackoverflow.com/questions/52924431/androidx-test-instrumentationregistry-is-deprecated
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        String fullPackageName = appContext.getPackageName();
        String rootPackageName = fullPackageName.substring(0, fullPackageName.lastIndexOf('.'));
        rootPackageName = rootPackageName.substring(0, rootPackageName.lastIndexOf('.'));
        assertEquals("com.kousenit.helloworld", rootPackageName);
    }
}
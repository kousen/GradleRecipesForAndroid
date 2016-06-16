package com.kousenit.helloworld;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class MainActivityLayoutTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private TextView textView;
    private EditText editText;
    private Button helloButton;

    public MainActivityLayoutTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();

        textView = (TextView) activity.findViewById(R.id.name_text_view);
        editText = (EditText) activity.findViewById(R.id.name_edit_text);
        helloButton = (Button) activity.findViewById(R.id.hello_button);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testPreconditions() {
        assertNotNull("Activity is null", activity);
        assertNotNull("TextView is null", textView);
        assertNotNull("EditText is null", editText);
        assertNotNull("HelloButton is null", helloButton);
    }

    @Test
    public void textView_label() {
        final String expected = activity.getString(R.string.hello_world);
        final String actual = textView.getText().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void editText_hint() {
        final String expected = activity.getString(R.string.name_hint);
        final String actual = editText.getHint().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void helloButton_label() {
        final String expected = activity.getString(R.string.hello_button_label);
        final String actual = helloButton.getText().toString();
        assertEquals(expected, actual);
    }
}

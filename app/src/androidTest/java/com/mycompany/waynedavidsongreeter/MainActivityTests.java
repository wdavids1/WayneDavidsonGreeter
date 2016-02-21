package com.mycompany.waynedavidsongreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    public void testGreet() {
        MainActivity activity = getActivity();

        final EditText namedEditText = (EditText) activity.findViewById(R.id.greet_edit_text);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                namedEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");

        Button greetButton = (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);

        TextView greetMessage =
                (TextView) activity.findViewById(R.id.message_text_view);

        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);
    }

    public void testReverseButtonDisabled() {
        MainActivity activity = getActivity();

        final Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        assertEquals(false,reverseButton.isEnabled());
    }

    public void testReverseButtonEnabled() {
        MainActivity activity = getActivity();

        this.helperAddNameAndClickButton();
        
        final Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        assertEquals(true,reverseButton.isEnabled());
    }



    private void helperAddNameAndClickButton() {
        MainActivity activity = getActivity();

        final EditText namedEditText = (EditText) activity.findViewById(R.id.greet_edit_text);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                namedEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");

        Button greetButton = (Button) activity.findViewById(R.id.greet_button);

        TouchUtils.clickView(this, greetButton);
    }
}

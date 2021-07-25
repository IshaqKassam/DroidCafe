package com.kassam.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //get the intent sent from the main activity
        Intent i = getIntent();
        String displayMessage = i.getStringExtra(MainActivity.EXTRA_ORDER_KEY);
        //create a Textview variable to connect to the textview in the layout
        TextView orderDisplay = findViewById(R.id.display_order);
        orderDisplay.setText(displayMessage);
    }

//this method will handle checked radio buttons
    public void onRadioButtonClicked(View view) {
        //define what to do with checked radio button
        //create a variable boolean and use the method checked to determine if a radio button is checked
        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.same_day:
                if(checked){
                    displayToast(getString(R.string.same_day_messenger_service));
                }
                break;
            case R.id.next_day:
                if (checked){
                    displayToast(getString(R.string.next_day_ground_delivery));
                }
                break;
            case R.id.pick_up:
                if(checked){
                    displayToast(getString(R.string.pick_up));
                }
                break;
            default:
                //do something here
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }
}
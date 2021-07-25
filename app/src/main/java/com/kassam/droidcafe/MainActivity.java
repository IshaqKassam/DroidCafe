package com.kassam.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.kassam.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "MY KEY FOR ORDER MESSAGE";

//    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
//        setSupportActionBar(toolbar);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(MainActivity.this, OrderActivity.class);
                i.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.about_us) {
//            return true;
//        }

        //create a switch case block to handle the clicks on the menue items

        switch(item.getItemId()){
            case R.id.action_order:
                //Open Order Activity
                Intent i = new Intent(MainActivity.this, OrderActivity.class);
                i.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(i);
                return true;
            case R.id.action_call:
                //implement an implicit intent that calls ur number
                Uri myUri = Uri.parse("tel:0703572586");
                Intent intent = new Intent(Intent.ACTION_DIAL, myUri);
                startActivity(intent);
                return true;
            case R.id.location:
                Uri addressUri = Uri.parse("geo:0,0?q=38.81396,-92.34904");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, addressUri);
                startActivity(intent1);
                return true;
                //Add the case for other options
            //ensure the item about us opens a webpage and locate us item opens a google map showing your longitude and latitude
            case R.id.about_us:
                Uri webpage = Uri.parse("https://www.food.com/");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent2);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    //A method for displaying toast messages
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamMessage(View view) {
//        displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showDonutMessage(View view) {
//        displayToast(getString(R.string.donut_order));
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrderMessage(View view) {
//        displayToast(getString(R.string.froyo_order));
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}
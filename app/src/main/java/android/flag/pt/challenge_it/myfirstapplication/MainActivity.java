package android.flag.pt.challenge_it.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener
{
    private TextView txtCounter = null;
    private final static String LOG_TAG ="LOG_TAG";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d(LOG_TAG, "onCreate");

        // Always call the method from the super class!!!
        super.onCreate(savedInstanceState);

        // This line "connects" the layout with this activity.
        setContentView(R.layout.activity_main);

        // Get the text view for update the integer value.
        txtCounter = (TextView)findViewById(R.id.txtCounter);
        txtCounter.setText("0");

        // Get the buttons and set the click listener.
        // In this case, the listener is the "this", so this Activity class
        // have to implements the interface View.OnClickListener.
        Button btnIncr = (Button)findViewById(R.id.btnIncr);
        Button btnDecr = (Button)findViewById(R.id.btnDecr);
        btnIncr.setOnClickListener(this);
        btnDecr.setOnClickListener(this);

        Button btnShow = (Button)findViewById(R.id.btnShow);
        //btnShow.setOnClickListener(this);

        // The next code demonstrates the usage of the anonymous class for define
        // the click listeners for the buttons, instead of use the Activity itself.
        /*
        btnIncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = Integer.parseInt(txtCounter.getText().toString());
                txtCounter.setText((current + 1) + "");
            }
        });
        btnDecr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = Integer.parseInt(txtCounter.getText().toString());
                txtCounter.setText((current - 1) + "");
            }
        });
        */
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "counter: " + txtCounter.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Button btnForSecondActivity = new Button(this);
        btnForSecondActivity.setText("Go to next activity");
        btnForSecondActivity.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT ));

        LinearLayout rootLayout = (LinearLayout)findViewById(R.id.rootLayout);
        rootLayout.addView(btnForSecondActivity);

        btnForSecondActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentToOpenSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                intentToOpenSecondActivity.putExtra(SecondActivity.COUNTER_VALUE_KEY_EXTRA, txtCounter.getText());
                startActivity(intentToOpenSecondActivity);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v)
    {
        // Verify which the button was clicked.
        if(v.getId() == R.id.btnIncr)
        {
            int current = Integer.parseInt(txtCounter.getText().toString());
            txtCounter.setText((current + 1) + "");
        }

        if(v.getId() == R.id.btnDecr)
        {
            int current = Integer.parseInt(txtCounter.getText().toString());
            txtCounter.setText((current - 1) + "");
        }

        /*if(v.getId() == R.id.btnShow)
        {

            Context context = getApplicationContext();
            CharSequence text = txtCounter.getText().toString();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }*/
    }
    @Override
    public void onSaveInstanceState(Bundle outState){

        Log.d(LOG_TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putString("COUNTER_VALUE", txtCounter.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){

        Log.d(LOG_TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        txtCounter.setText(savedInstanceState.getString("COUNTER_VALUE"));
    }

    @Override
    public void onStart(){
        Log.d(LOG_TAG, "onStart");
        super.onStart();

    }

    @Override
    public void onStop(){
        Log.d(LOG_TAG, "onStop");
        super.onStop();
    }
    @Override
    public void onRestart(){
        Log.d(LOG_TAG, "onRestart");
        super.onRestart();
    }
    @Override
    public void onResume(){
        Log.d(LOG_TAG, "onResume");
        super.onResume();

    }

    @Override
    public void onDestroy(){
        Log.d(LOG_TAG, "onDestroy");
        super.onDestroy();

    }





}

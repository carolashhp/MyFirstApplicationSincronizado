package android.flag.pt.challenge_it.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by Formando FLAG on 17-04-2015.
 */
public class SecondActivity extends Activity
{
    public static final String COUNTER_VALUE_KEY_EXTRA = "COUNTER_VALUE_KEY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String counter = getIntent().getStringExtra("COUNTER_VALUE_KEY");

        ((TextView)findViewById(R.id.txtCounterResult)).setText(counter);
    }
}

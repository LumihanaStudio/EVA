package kr.edcan.eva;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {

    TextView convertName, convertNumber, convertComplete, convertCall;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        setAppbarLayout();
        setDefault();
    }

    private void setDefault() {
        convertName = (TextView) findViewById(R.id.convert_name);
        convertNumber = (TextView) findViewById(R.id.convert_number);
        convertComplete = (TextView) findViewById(R.id.convert_complete);
        convertCall = (TextView) findViewById(R.id.convert_call);
    }

    private void setAppbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("EVA와 전환중");
        getSupportActionBar().setElevation(5);
    }
}

package kr.edcan.eva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AuthActivity extends AppCompatActivity {

    TextView login, facebook, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        setDefault();
    }

    private void setDefault() {
        login = (TextView) findViewById(R.id.auth_login);
        facebook = (TextView) findViewById(R.id.auth_facebook);
        email = (TextView) findViewById(R.id.auth_email);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
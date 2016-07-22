package kr.edcan.eva;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText email, password, passwordRe, number, name;

    Toolbar toolbar;
    TextView confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setDefault();
        setAppbarLayout();
    }

    private void setAppbarLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("회원 가입");
        getSupportActionBar().setElevation(5);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable drawable = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        drawable.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setDefault() {
        email = (EditText) findViewById(R.id.register_email);
        password = (EditText) findViewById(R.id.register_password);
        passwordRe = (EditText) findViewById(R.id.register_passwordre);
        number = (EditText) findViewById(R.id.register_number);
        name = (EditText) findViewById(R.id.register_name);
        confirm = (TextView) findViewById(R.id.register_complete);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = email.getText().toString().trim();
                String passwordStr = password.getText().toString().trim();
                String passwordStrRe = passwordRe.getText().toString().trim();
                String numberStr = number.getText().toString().trim();
                String nameStr = name.getText().toString().trim();
                if (isEmpty(new String[]{emailStr, passwordStr, passwordStrRe, numberStr, nameStr})) {
                    Toast.makeText(RegisterActivity.this, "빈칸 없이 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    boolean isEmpty(String[] arr) {
        boolean asdf = false;
        for (String s : arr) {
            if (s.equals("")) asdf = true;
        }
        return asdf;
    }
}

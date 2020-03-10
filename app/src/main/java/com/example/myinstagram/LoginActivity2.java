package com.example.myinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

public class LoginActivity2 extends AppCompatActivity
{

    private EditText etUsername ;
    private EditText etPassword ;
    private Button btnLogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        etUsername = findViewById(R.id.etUsernane) ;
        etPassword = findViewById(R.id.etPassword) ;
        btnLogin = findViewById(R.id.btnLogin) ;

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            String userName = etUsername.getText().toString() ;
            String password = etPassword.getText().toString() ;
            loginUser(userName, password) ;
            }
        });

        private void loginUser(String username, String password) {
            Log.i(TAG, "Attempting to login user " + username) ;
            // todo: navigate to the main avctivity if the user has signed in properly.
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done (ParseUser user, ParseException e) {
                    if (e != null)
                    {
                        Log.e(tag, "issue with login", e);
                        return ;
                    }

                    goMainActivity();
                }
            }) ;
    }
        private void goMainActivity()
        {

        }
    }
}
package com.arash.altafi.mvc.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arash.altafi.mvc.R;
import com.arash.altafi.mvc.controllers.ILoginController;
import com.arash.altafi.mvc.controllers.LoginController;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText email;
    private EditText password;
    private Button loginBtn;
    private ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginb);

        loginController = new LoginController(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController.onLogin(email.getText().toString(), password.getText().toString());
            }
        });

    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
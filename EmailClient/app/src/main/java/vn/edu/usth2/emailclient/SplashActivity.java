package vn.edu.usth2.emailclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ChangeActivity();
            }
        }, 2000);
    }

    private void ChangeActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
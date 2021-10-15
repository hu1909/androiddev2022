package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Spam(View view){
        Intent intent = new Intent(this, SpamActivity.class);
        startActivity(intent);
    }

    public void Sent(View view){
        Intent intent = new Intent(this, SentActivity.class);
        startActivity(intent);
    }

    public void Inbox(View view){
        Intent intent = new Intent(this, InboxActivity.class);
        startActivity(intent);
    }

    public void Compose(View view){
        Intent intent = new Intent(this, Compose.class);
        startActivity(intent);
    }
}
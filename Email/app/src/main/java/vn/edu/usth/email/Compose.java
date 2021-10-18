package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Compose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
    }

    public void SendEmail(View view) {
        Toast.makeText(this, "Email Sent !!", Toast.LENGTH_SHORT).show();
    }
}
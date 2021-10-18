package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void ToastMessage(View view) {
        Toast.makeText(this, "Create Account Successfully ! ", Toast.LENGTH_SHORT).show();
    }
}
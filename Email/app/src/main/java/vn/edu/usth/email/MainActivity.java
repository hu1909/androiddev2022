package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputtext;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputtext = (EditText) findViewById(R.id.editTextTextPersonName);


    }
    public void Login(View view){
        Intent intent = new Intent(this, Login.class);

        string = inputtext.getText().toString();
        intent.putExtra("Value", string);
        startActivity(intent);

        Toast.makeText(this, "Login Successfully !", Toast.LENGTH_SHORT).show();
    }

    public  void SignUp(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}
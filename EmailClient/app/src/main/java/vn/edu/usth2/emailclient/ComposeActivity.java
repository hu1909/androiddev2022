package vn.edu.usth2.emailclient;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ThreadLocalRandom;


public class ComposeActivity extends AppCompatActivity {

    private EditText sender, receiver, title, detail;
    private FirebaseDatabase fd;
    private DatabaseReference ref;
    private FirebaseAuth auth;
    Messages messages;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sender = findViewById(R.id.from_email);
        receiver = findViewById(R.id.to_email);
        title = findViewById(R.id.subject);
        detail = findViewById(R.id.message);

        fd = FirebaseDatabase.getInstance();
        auth  = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        sender.setText(user.getEmail());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_compose, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send:
                onClickSent();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onClickSent() {

        String Sender = sender.getText().toString().trim();
        String Receiver = receiver.getText().toString().trim();
        String Title = title.getText().toString().trim();
        String Detail = detail.getText().toString().trim();



            if (Sender.isEmpty() || Receiver.isEmpty()) {
                Toast.makeText(this, "This field is required", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ComposeActivity.class);
                startActivity(intent);
            } else {
                Messages messages = new Messages(Sender, Receiver, Title, Detail);
                fd = FirebaseDatabase.getInstance();
                ref = fd.getReference().child("sent");
                ref.push().setValue(messages);
                Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();

            }
    }



}
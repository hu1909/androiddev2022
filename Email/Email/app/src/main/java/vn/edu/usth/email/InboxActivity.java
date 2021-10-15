package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InboxActivity extends AppCompatActivity implements EListFragment.Listener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
    }

    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, EDetail.class);
        intent.putExtra(EDetail.EXTRA_CONTENT_ID, (int)id);
        startActivity(intent);


    }
}

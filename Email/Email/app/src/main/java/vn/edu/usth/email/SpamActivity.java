package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SpamActivity extends AppCompatActivity implements SpamListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spam);
    }
    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, SpamDetail.class);
        intent.putExtra(SpamDetail.EXTRA_SPAMCONTENT_ID, (int)id);
        startActivity(intent);


    }
}
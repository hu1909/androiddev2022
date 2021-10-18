package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SpamDetail extends AppCompatActivity {

    public static final String EXTRA_SPAMCONTENT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spam_detail);
        SpamDetailFragment frag = (SpamDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.spam_detail);
        int spamId = (int)getIntent().getExtras().get(EXTRA_SPAMCONTENT_ID);
        frag.setSpamId(spamId);
    }
}
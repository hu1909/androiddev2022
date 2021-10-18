package vn.edu.usth.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EDetail extends AppCompatActivity {
    public static final String EXTRA_CONTENT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edetail);
        EDetailFragment frag = (EDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.e_detail);
        int contentId = (int)getIntent().getExtras().get(EXTRA_CONTENT_ID);
        frag.setContentId(contentId);
    }
}
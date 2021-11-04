package vn.edu.usth.email2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IbDetailActivity extends AppCompatActivity {

    TextView mIbIcon;
    TextView mIbSender;
    TextView mIbTitle;
    TextView mIbDetails;
    TextView mRcvTime;
    ImageView mIbStar;
    int color2 = Color.argb(255,241,181,3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ib_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mIbIcon = findViewById(R.id.ic_sender);
        mIbSender = findViewById(R.id.ib_sender);
        mIbTitle = findViewById(R.id.ib_title);
        mIbDetails = findViewById(R.id.ib_detail);
        mRcvTime = findViewById(R.id.rcv_time);
        mIbStar = findViewById(R.id.starro);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mIbIcon.setText(mBundle.getString("icon"));
            ((GradientDrawable) mIbIcon.getBackground()).setColor(mBundle.getInt("colorIcon"));
            mIbSender.setText(mBundle.getString("sender"));
            mIbTitle.setText(mBundle.getString("title"));
            mIbDetails.setText(mBundle.getString("detail"));
            mRcvTime.setText(mBundle.getString("time"));
        }
        mIbStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mIbStar.getColorFilter() != null) {
                    mIbStar.clearColorFilter();
                } else {
                    mIbStar.setColorFilter(color2);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ib_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.del) {
        }
        return super.onOptionsItemSelected(item);
    }
}
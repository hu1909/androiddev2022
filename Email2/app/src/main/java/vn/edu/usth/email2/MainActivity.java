package vn.edu.usth.email2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.email2.fragment.InboxFragment;
import vn.edu.usth.email2.fragment.SentFragment;
import vn.edu.usth.email2.fragment.SpamFragment;
import vn.edu.usth.email2.fragment.TrashFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private static final int FRAGMENT_INBOX = 0;
    private static final int FRAGMENT_SENT = 1;
    private static final int FRAGMENT_SPAM = 2;
    private static final int FRAGMENT_TRASH = 3;
    private static final int PROFILE = 4;
    private static final int SETTING = 5;
    private static final int HELP = 6;

    private int mCurrentFragment = FRAGMENT_INBOX;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new InboxFragment());
        navigationView.getMenu().findItem(R.id.inbox).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if( id == R.id.inbox){
            if(mCurrentFragment != FRAGMENT_INBOX){
                replaceFragment(new InboxFragment());
                mCurrentFragment = FRAGMENT_INBOX;
            }
        }

        if( id == R.id.sent){
            if(mCurrentFragment != FRAGMENT_SENT){
                replaceFragment(new SentFragment());
                mCurrentFragment = FRAGMENT_SENT;
            }
        }

        if( id == R.id.spam){
            if(mCurrentFragment != FRAGMENT_SPAM){
                replaceFragment(new SpamFragment());
                mCurrentFragment = FRAGMENT_SPAM;
            }
        }

        if( id == R.id.trash){
            if(mCurrentFragment != FRAGMENT_TRASH){
                replaceFragment(new TrashFragment());
                mCurrentFragment = FRAGMENT_TRASH;
            }
        }

        if( id == R.id.profile){
        }

        if( id == R.id.setting){
        }

        if( id == R.id.help){
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void onCompose(View view){
        Intent intent = new Intent(this,ComposeActivity.class);
        startActivity(intent);
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }
}
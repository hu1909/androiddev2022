package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Weather", "onCreate: Create successfully");
        setContentView(R.layout.activity_weather);
        ForecastFragment fd = ForecastFragment.newInstance("","");
        getSupportFragmentManager().beginTransaction().add(
                R.id.container, fd).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather", "onStart: Start successfully");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather", "onStop: It has been stopped ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather", "onDestroy: Destroy successfully");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weather", "onResume: Continue");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weather", "onCreate: Create successfully");
    }
}
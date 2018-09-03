package com.sportsplatform.ab.sportsplatform.startup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.sportsplatform.ab.sportsplatform.HomeActivity;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.startup.setup.FirstSetupActivity;
import com.sportsplatform.ab.sportsplatform.util.Constants;

public class BootUpActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_boot_up);

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
          Boolean isFirstRun = getSharedPreferences(Constants.preferenceKey, MODE_PRIVATE).getBoolean(Constants.preferenceFirstRun, true);
          if (isFirstRun) {
            Intent i = new Intent(getApplicationContext(), StartSignInActivity.class);
            startActivity(i);
            finish();
          } else {
            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(i);
            finish();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}

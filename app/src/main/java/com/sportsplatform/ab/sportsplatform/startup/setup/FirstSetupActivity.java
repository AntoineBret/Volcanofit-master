package com.sportsplatform.ab.sportsplatform.startup.setup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.sportsplatform.ab.sportsplatform.HomeActivity;

public class
FirstSetupActivity extends AppIntro {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setWizardMode(true);

    /* addSlide(new EnableGoogleSynchroFragment());
    addSlide(new EnableNotificationFragment()); */
    addSlide(new SetUpDoneFragment());

    setColorTransitionsEnabled(true);

    showStatusBar(false);
    showSkipButton(false);
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
  }

  @Override
  public void onSkipPressed(Fragment currentFragment) {
    super.onSkipPressed(currentFragment);
  }

  @Override
  public void onDonePressed(Fragment currentFragment) {
    super.onDonePressed(currentFragment);
    //Set 'isfirstrun' to false so app does not go back into the sign in screen again
    //getSharedPreferences(Constants.preferenceKey, MODE_PRIVATE).edit().putBoolean(Constants.preferenceFirstRun, false).commit();
    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
    startActivity(i);
  }

  @Override
  public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
    super.onSlideChanged(oldFragment, newFragment);
    // Do something when the slide changes
  }
}

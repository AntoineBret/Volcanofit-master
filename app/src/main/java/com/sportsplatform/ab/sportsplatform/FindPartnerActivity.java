package com.sportsplatform.ab.sportsplatform;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sportsplatform.ab.sportsplatform.fragment.FindPartnerFragment;

public class FindPartnerActivity extends AppCompatActivity {

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_partner);

    Fragment fragment = new FindPartnerFragment();
    getSupportFragmentManager().beginTransaction()
      .add(R.id.findpartner_fragment_container, fragment, "main")
      .commit();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(0, android.R.anim.slide_out_right);
  }
}

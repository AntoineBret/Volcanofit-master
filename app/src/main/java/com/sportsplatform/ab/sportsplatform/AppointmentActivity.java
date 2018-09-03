package com.sportsplatform.ab.sportsplatform;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sportsplatform.ab.sportsplatform.adapter.ViewPagerAdapter;


public class AppointmentActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

  private ViewPager viewPager;
  private ViewPagerAdapter pagerAdapter;
  private Toolbar toolbar;
  private TabLayout tabLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_appointment);

    toolbar = findViewById(R.id.appointment_toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tabLayout = findViewById(R.id.tabLayout);

    tabLayout.addTab(tabLayout.newTab().setText("Booking"));
    tabLayout.addTab(tabLayout.newTab().setText("All"));
    tabLayout.addTab(tabLayout.newTab().setText("Upcomming"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    viewPager = findViewById(R.id.view_pager_appointment);

    pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
    viewPager.setAdapter(pagerAdapter);

    tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
  }

  @Override
  public void onTabSelected(TabLayout.Tab tab) {
    viewPager.setCurrentItem(tab.getPosition());
  }

  @Override
  public void onTabUnselected(TabLayout.Tab tab) {
  }

  @Override
  public void onTabReselected(TabLayout.Tab tab) {
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

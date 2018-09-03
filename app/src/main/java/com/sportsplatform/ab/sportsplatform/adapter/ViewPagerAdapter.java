package com.sportsplatform.ab.sportsplatform.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sportsplatform.ab.sportsplatform.fragment.AppointmentFragment;
import com.sportsplatform.ab.sportsplatform.fragment.DetailsPartnerFragment;
import com.sportsplatform.ab.sportsplatform.fragment.HomeFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

  int tabCount;

  public ViewPagerAdapter(FragmentManager fm, int tabCount) {
    super(fm);
    this.tabCount= tabCount;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return AppointmentFragment.newInstance();
      case 1:
        return AppointmentFragment.newInstance();
      case 2:
        return AppointmentFragment.newInstance();

      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return tabCount;
  }
}

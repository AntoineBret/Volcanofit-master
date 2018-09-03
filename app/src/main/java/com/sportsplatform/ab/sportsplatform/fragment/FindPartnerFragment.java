package com.sportsplatform.ab.sportsplatform.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.adapter.FindPartnerRecyclerAdapter;
import com.sportsplatform.ab.sportsplatform.adapter.RecyclerItemClickListener;
import com.sportsplatform.ab.sportsplatform.model.FindPartner;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class FindPartnerFragment extends Fragment {

  public RecyclerView recycleView;
  private GridLayoutManager gridLayoutManager;
  public List<FindPartner> findPartnerList = new ArrayList<FindPartner>();
  private FindPartnerRecyclerAdapter adapter;
  private Intent intent;
  private Toolbar toolbar;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_findpartner, container, false);

    toolbar = (Toolbar) rootView.findViewById(R.id.findpartner_toolbar);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

    return rootView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    findPartnerList = new ArrayList<>();

    recycleView = (RecyclerView) getView().findViewById(R.id.findpartner_recycler_view);

    recycleView.setLayoutManager(new GridLayoutManager(getContext(), 1));
    recycleView.setHasFixedSize(true);
    recycleView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {

      public void onItemClick(View view, int position) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        Fragment fragment = new Fragment();
        switch (position) {
          case 0:
            fragment = new DetailsPartnerFragment();
            break;
        }
        fragmentTransaction.replace(R.id.findpartner_fragment_container, fragment);
        getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
      }
    }));

    adapter = new FindPartnerRecyclerAdapter(getContext(), findPartnerList);
    recycleView.setAdapter(adapter);

    initializeData();
  }

  private void initializeData() {
    int[] covers = new int[]{
      R.drawable.partner_thumbnail_test1,
      R.drawable.partner_thumbnail_test2,
      R.drawable.partner_thumbnail_test3,
      R.drawable.partner_thumbnail_test4,
      R.drawable.partner_thumbnail_test5,
      R.drawable.partner_thumbnail_test6,
      R.drawable.partner_thumbnail_test7,
    };

    FindPartner p = new FindPartner("Christophe", "Kinésithérapeute", "Aubière", covers[0]);
    findPartnerList.add(p);

    p = new FindPartner("Jean-Anaël", "Coach Sportif", "Gerzat", covers[1]);
    findPartnerList.add(p);

    p = new FindPartner("Alexis", "Masseur", "Clermont-Ferrand", covers[2]);
    findPartnerList.add(p);

    p = new FindPartner("Cyrielle", "Ostéopathe", "Cebazat", covers[3]);
    findPartnerList.add(p);

    p = new FindPartner("Mathias", "Kinésithérapeute", "Aubière", covers[4]);
    findPartnerList.add(p);

    p = new FindPartner("Marie", "Ostéopathe", "Beaumont", covers[5]);
    findPartnerList.add(p);

    p = new FindPartner("Simon", "Coach Sportif", "Clermont-Ferrand", covers[6]);
    findPartnerList.add(p);

    adapter.notifyDataSetChanged();
  }
}



package com.sportsplatform.ab.sportsplatform.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sportsplatform.ab.sportsplatform.FindActivityActivity;
import com.sportsplatform.ab.sportsplatform.FindPartnerActivity;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.adapter.HomeAdapter;
import com.sportsplatform.ab.sportsplatform.adapter.RecyclerItemClickListener;
import com.sportsplatform.ab.sportsplatform.model.Home;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  public RecyclerView recycleView;
  private StaggeredGridLayoutManager gridLayoutManager;
  public List<Home> homeList = new ArrayList<Home>();
  private HomeAdapter adapter;
  private Intent intent;
  private Toolbar toolbar;
  private TextView header_tv1, header_tv2;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_home, container, false);

    toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
    toolbar.setNavigationIcon(R.drawable.ic_menu_vector);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

    try {
      Glide.with(this).load(R.drawable.splash_background).into((ImageView) rootView.findViewById(R.id.backdrop));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rootView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    homeList = new ArrayList<>();

    recycleView = (RecyclerView) getView().findViewById(R.id.home_recycler_view);
    recycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    recycleView.setHasFixedSize(true);

    recycleView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {
        switch (position) {
          case 0:
            intent = new Intent(getActivity(), FindActivityActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            break;
          case 1:
            intent = new Intent(getActivity(), FindPartnerActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            break;

        }
      }
    }));

    adapter = new HomeAdapter(getContext(), homeList);
    recycleView.setAdapter(adapter);

    initializeData();
  }


  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) getView().findViewById(R.id.collapsing_toolbar);
    collapsingToolbar.setTitle(" ");

    AppBarLayout appBarLayout = (AppBarLayout) getView().findViewById(R.id.home_appbar);
    appBarLayout.setExpanded(true);
    appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
      boolean isShow = false;
      int scrollRange = -1;

      @Override
      public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (scrollRange == -1) {
          scrollRange = appBarLayout.getTotalScrollRange();
        }
        if (scrollRange + verticalOffset == 0) {
          collapsingToolbar.setTitle(getString(R.string.title_home));
          isShow = true;
        } else if (isShow) {
          collapsingToolbar.setTitle(" ");
          isShow = false;
        }
      }
    });
  }

  private void initializeData() {
    int[] covers = new int[]{
      R.drawable.ic_addnew,
      R.drawable.ic_partner,
      R.drawable.ic_group,
      R.drawable.ic_friend,
      R.drawable.ic_discuss,
      R.drawable.ic_share,

    };

    Home h = new Home("Trouver une activité", "", "desc", covers[0]);
    homeList.add(h);
    h = new Home("Trouver un partenaire", "", "desc", covers[1]);
    homeList.add(h);
    h = new Home("Trouver un groupe", "", "desc", covers[2]);
    homeList.add(h);
    h = new Home("Trouver un ami", "", "desc", covers[3]);
    homeList.add(h);
    h = new Home("Trouver une discussion", "", "desc", covers[4]);
    homeList.add(h);
    h = new Home("Partager quelque chose", "", "desc", covers[5]);
    homeList.add(h);


    adapter.notifyDataSetChanged();
  }
}


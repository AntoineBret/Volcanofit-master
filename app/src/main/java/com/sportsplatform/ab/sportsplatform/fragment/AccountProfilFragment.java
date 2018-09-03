package com.sportsplatform.ab.sportsplatform.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportsplatform.ab.sportsplatform.ManagementSignInActivity;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.adapter.ProfilserviceAdapter;
import com.sportsplatform.ab.sportsplatform.adapter.RecyclerItemClickListener;
import com.sportsplatform.ab.sportsplatform.model.Profilservice;

import java.util.ArrayList;
import java.util.List;

public class AccountProfilFragment extends Fragment {

  private Toolbar toolbar;
  private RecyclerView mRecyclerView;
  private ProfilserviceAdapter mAdapter;
  private List<Profilservice> serviceList;
  private Intent intent;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_accountprofil, container, false);

    toolbar = (Toolbar) rootView.findViewById(R.id.profilservice_toolbar);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.profilservice_recyclerview);

    serviceList = new ArrayList<>();
    mAdapter = new ProfilserviceAdapter(getContext(), serviceList);

    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setAdapter(mAdapter);

    mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {
        switch (position) {
          case 0:
            intent = new Intent(getActivity(), ManagementSignInActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            break;
        }
      }
    }));

    prepareService();

    return rootView;
  }

  private void prepareService() {
    int[] covers = new int[]{
      R.drawable.ic_googlelogo,
      R.drawable.ic_test,};

    Profilservice p = new Profilservice("Google", "", "", covers[0]);
    serviceList.add(p);

    p = new Profilservice("Informations personnelles", "", "", covers[1]);
    serviceList.add(p);

    mAdapter.notifyDataSetChanged();
  }
}

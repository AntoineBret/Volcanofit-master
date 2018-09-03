package com.sportsplatform.ab.sportsplatform.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sportsplatform.ab.sportsplatform.AppointmentActivity;
import com.sportsplatform.ab.sportsplatform.FindActivityActivity;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.adapter.DetailsPartnerAdapter;

import static com.sportsplatform.ab.sportsplatform.adapter.PartnerCategoryFactory.partnerCategoryList;

public class DetailsPartnerFragment extends Fragment {

  public RecyclerView recycleView;
  private Toolbar toolbar;
  public DetailsPartnerAdapter adapter;
  private Button appointment;

  @Override

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_detailspartner, container, false);

    toolbar = (Toolbar) rootView.findViewById(R.id.detailspartner_toolbar);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

    recycleView = (RecyclerView) rootView.findViewById(R.id.detailspartner_recycler_view);
    appointment = (Button) rootView.findViewById(R.id.button_appointment);
    appointment.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getContext(), AppointmentActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
      }
    });

    return rootView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    adapter = new DetailsPartnerAdapter(partnerCategoryList());

    recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    recycleView.setAdapter(adapter);
  }
}

package com.sportsplatform.ab.sportsplatform.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.FindPartner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


public class AppointmentFragment extends Fragment {

  private static final String TAG = "Sample";

  private static final String TAG_DATETIME_FRAGMENT = "TAG_DATETIME_FRAGMENT";

  private static final String STATE_TEXTVIEW = "STATE_TEXTVIEW";

  private SwitchDateTimeDialogFragment dateTimeFragment;
  private Toolbar toolbar;
  private ImageButton ib;
  private TextView tv_date;

  public static AppointmentFragment newInstance() {
    return new AppointmentFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_appointment, container, false);

    toolbar = rootView.findViewById(R.id.appointment_toolbar);
    ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

    ib = rootView.findViewById(R.id.appointment_date_ib);
    tv_date = rootView.findViewById(R.id.appointment_date_subtitle);
    if (savedInstanceState != null) {
      tv_date.setText(savedInstanceState.getCharSequence(STATE_TEXTVIEW));
    }

    initializeCalandar();

    return rootView;
  }


  private void initializeCalandar() {

    dateTimeFragment = (SwitchDateTimeDialogFragment) getFragmentManager().findFragmentByTag(TAG_DATETIME_FRAGMENT);
    if (dateTimeFragment == null) {
      dateTimeFragment = SwitchDateTimeDialogFragment.newInstance(
        getString(R.string.label_datetime_dialog),
        getString(android.R.string.ok),
        getString(android.R.string.cancel),
        getString(R.string.clean)
      );
    }

    final SimpleDateFormat myDateFormat = new SimpleDateFormat("d MMM yyyy HH:mm", java.util.Locale.getDefault());
    dateTimeFragment.set24HoursMode(false);
    dateTimeFragment.setMinimumDateTime(new GregorianCalendar(2015, Calendar.JANUARY, 1).getTime());
    dateTimeFragment.setMaximumDateTime(new GregorianCalendar(2025, Calendar.DECEMBER, 31).getTime());

    try {
      dateTimeFragment.setSimpleDateMonthAndDayFormat(new SimpleDateFormat("MMMM dd", Locale.getDefault()));
    } catch (SwitchDateTimeDialogFragment.SimpleDateMonthAndDayFormatException e) {
      Log.e(TAG, e.getMessage());
    }

    dateTimeFragment.setOnButtonClickListener(new SwitchDateTimeDialogFragment.OnButtonWithNeutralClickListener() {
      @Override
      public void onPositiveButtonClick(Date date) {
        tv_date.setText(myDateFormat.format(date));
      }

      @Override
      public void onNegativeButtonClick(Date date) {
      }

      @Override
      public void onNeutralButtonClick(Date date) {
        tv_date.setText("");
      }
    });

    ib.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dateTimeFragment.startAtCalendarView();
        dateTimeFragment.setDefaultDateTime(new GregorianCalendar(2017, Calendar.MARCH, 4, 15, 20).getTime());
        dateTimeFragment.show(getFragmentManager(), TAG_DATETIME_FRAGMENT);
      }
    });
  }

  @Override
  public void onSaveInstanceState(Bundle savedInstanceState) {
    savedInstanceState.putCharSequence(STATE_TEXTVIEW, tv_date.getText());
    super.onSaveInstanceState(savedInstanceState);
  }
}

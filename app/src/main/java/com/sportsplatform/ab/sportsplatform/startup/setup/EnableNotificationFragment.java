package com.sportsplatform.ab.sportsplatform.startup.setup;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.paolorotolo.appintro.ISlideBackgroundColorHolder;
import com.github.paolorotolo.appintro.ISlidePolicy;
import com.sportsplatform.ab.sportsplatform.R;


public class EnableNotificationFragment extends Fragment implements ISlideBackgroundColorHolder, ISlidePolicy {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    return inflater.inflate(R.layout.intro_enable_notify, container, false);
  }

  @Override
  public int getDefaultBackgroundColor() {
    return Color.parseColor("#CBE456");
  }

  @Override
  public void setBackgroundColor(@ColorInt int backgroundColor) {
    View layoutContainer = getView();

    if (layoutContainer != null) {
      layoutContainer.setBackgroundColor(backgroundColor);
    }
  }

  @Override
  public boolean isPolicyRespected() {
    TextView textView = (TextView) getView().findViewById(R.id.enableAccessTxtBt);
    return true;
  }

  @Override
  public void onUserIllegallyRequestedNextPage() {
		/*AlertDialogUtil alertDialogUtil = new AlertDialogUtil();

		alertDialogUtil.showMessageAgreeDisagreeWithTitle(getActivity(), R.string.warnKeepSystemLockOnTitle, R.string.warnKeepSystemLockOn, new AlertDialog.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
					case DialogInterface.BUTTON_POSITIVE:
						isPolicyRespected();
						break;
					case DialogInterface.BUTTON_NEGATIVE:
						TextView text = (TextView) getView().findViewById(R.id.disableLockTxtBt);
						text.callOnClick();
						isPolicyRespected();
						break;
				}
			}
		});*/
  }
}

package com.sportsplatform.ab.sportsplatform.adapter;


import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.PartnerCategory;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class PartnerCategoryViewHolder extends GroupViewHolder {

  private TextView titleCategory;
  private ImageView arrowCategory;
  private ImageView category_icon;

  public PartnerCategoryViewHolder(View itemView) {
    super(itemView);

    titleCategory = (TextView) itemView.findViewById(R.id.list_partnercategory_name);
    arrowCategory = (ImageView) itemView.findViewById(R.id.list_partnercategory_arrow);
    category_icon = (ImageView) itemView.findViewById(R.id.list_partnercategory_icon);

  }

  public void setCategory_title(Context context, ExpandableGroup partnerCategory) {
    if (partnerCategory instanceof PartnerCategory) {
      titleCategory.setText(partnerCategory.getTitle());
      category_icon.setBackgroundResource(((PartnerCategory) partnerCategory).getIconResId());
      }
    }

  @Override
  public void expand() {
    animateExpand();
  }

  @Override
  public void collapse() {
    animateCollapse();
  }

  private void animateExpand() {
    RotateAnimation rotate =
      new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrowCategory.setAnimation(rotate);
  }

  private void animateCollapse() {
    RotateAnimation rotate =
      new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(300);
    rotate.setFillAfter(true);
    arrowCategory.setAnimation(rotate);
  }
}


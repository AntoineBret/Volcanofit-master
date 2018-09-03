package com.sportsplatform.ab.sportsplatform.adapter;

import android.view.View;
import android.widget.TextView;

import com.sportsplatform.ab.sportsplatform.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class PartnerSubCategoryViewHolder extends ChildViewHolder {

  private TextView subCategoryTitle;

  public PartnerSubCategoryViewHolder (View itemView) {
    super(itemView);
    subCategoryTitle = itemView.findViewById(R.id.subcategory_title);
  }

  public void setSubCategoryTitle (String title) {
    subCategoryTitle.setText(title);
  }
}

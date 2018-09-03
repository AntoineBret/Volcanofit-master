package com.sportsplatform.ab.sportsplatform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sportsplatform.ab.sportsplatform.model.PartnerCategory;
import com.sportsplatform.ab.sportsplatform.model.PartnerSubCategory;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.sportsplatform.ab.sportsplatform.R;

import java.util.List;

public class DetailsPartnerAdapter extends ExpandableRecyclerViewAdapter<PartnerCategoryViewHolder, PartnerSubCategoryViewHolder> {

  private Context context;

  public DetailsPartnerAdapter(List<? extends ExpandableGroup> groups) {
    super(groups);
    this.context = context;
  }

  @Override
  public PartnerCategoryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.list_partner_category, parent, false);
    return new PartnerCategoryViewHolder(view);
  }

  @Override
  public PartnerSubCategoryViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.list_partner_subcategory, parent, false);
    return new PartnerSubCategoryViewHolder(view);
  }

  @Override
  public void onBindChildViewHolder(PartnerSubCategoryViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

    final PartnerSubCategory partnerSubCategory = ((PartnerCategory) group).getItems().get(childIndex);
    holder.setSubCategoryTitle(partnerSubCategory.getName());
  }

  @Override
  public void onBindGroupViewHolder(PartnerCategoryViewHolder holder, int flatPosition, ExpandableGroup group) {
    holder.setCategory_title(context, group);
  }
}

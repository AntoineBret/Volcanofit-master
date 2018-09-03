package com.sportsplatform.ab.sportsplatform.model;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class PartnerCategory extends ExpandableGroup<PartnerSubCategory> {

  private int iconResId;

  public PartnerCategory (String partnerCategory, List<PartnerSubCategory> items, int iconResId) {
    super(partnerCategory, items);
    this.iconResId = iconResId;
  }

  public int getIconResId() {
    return iconResId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PartnerCategory)) return false;

    PartnerCategory partnerCategory = (PartnerCategory) o;

    return getIconResId() == partnerCategory.getIconResId();

  }

  @Override
  public int hashCode() {
    return getIconResId();
  }
}

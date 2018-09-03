package com.sportsplatform.ab.sportsplatform.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PartnerSubCategory implements Parcelable {

  private String name;
  private int subicon;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PartnerSubCategory(String name, int subicon) {
    this.name = name;
    this.subicon = subicon;
  }

  public int getSubicon() {
    return subicon;
  }

  @Override
  public boolean equals(Object p) {
    if (this == p) return true;
    if (!(p instanceof PartnerSubCategory)) return false;

    PartnerSubCategory partnerSubCategory = (PartnerSubCategory) p;

    return getSubicon() == partnerSubCategory.getSubicon();

  }

  protected PartnerSubCategory(Parcel in) {
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<PartnerSubCategory> CREATOR = new Creator<PartnerSubCategory>() {
    @Override
    public PartnerSubCategory createFromParcel(Parcel in) {
      return new PartnerSubCategory(in);
    }

    @Override
    public PartnerSubCategory[] newArray(int size) {
      return new PartnerSubCategory[size];
    }
  };
}

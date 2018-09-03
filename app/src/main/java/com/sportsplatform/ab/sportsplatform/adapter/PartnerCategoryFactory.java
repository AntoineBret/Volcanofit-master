package com.sportsplatform.ab.sportsplatform.adapter;

import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.PartnerCategory;
import com.sportsplatform.ab.sportsplatform.model.PartnerSubCategory;

import java.util.Arrays;
import java.util.List;

public class PartnerCategoryFactory {

  public static List<PartnerCategory> partnerCategoryList() {
    return Arrays.asList(makePersonalInformation(),
      makeWorkAddress(),
      makeReviewer());
  }

  public static PartnerCategory makePersonalInformation() {
    return new PartnerCategory("Informations personnelles", makePersonalInformationDetails(), R.drawable.ic_informationsdetails);
  }


  public static List<PartnerSubCategory> makePersonalInformationDetails() {
    PartnerSubCategory email = new PartnerSubCategory("E-mail", R.drawable.ic_addnew);
    PartnerSubCategory phone = new PartnerSubCategory("Téléphone", R.drawable.ic_addnew);
    PartnerSubCategory schedule = new PartnerSubCategory("Horaires", R.drawable.ic_addnew);
    PartnerSubCategory features = new PartnerSubCategory("Prestations", R.drawable.ic_addnew);

    return Arrays.asList(email, phone, schedule, features);
  }

  public static PartnerCategory makeWorkAddress() {
    return new PartnerCategory("Adresse de travail", makeWorkAddressDetails(), R.drawable.ic_workaddress);
  }

  public static List<PartnerSubCategory> makeWorkAddressDetails() {
    PartnerSubCategory address = new PartnerSubCategory("Adresse", R.drawable.ic_addnew);
    PartnerSubCategory test2 = new PartnerSubCategory("test2", R.drawable.ic_addnew);
    PartnerSubCategory test3 = new PartnerSubCategory("test3", R.drawable.ic_addnew);

    return Arrays.asList(address, test2, test3);
  }

  public static PartnerCategory makeReviewer() {
    return new PartnerCategory("Évaluation", makeReviewerDetails(), R.drawable.ic_reviewer);
  }


  public static List<PartnerSubCategory> makeReviewerDetails() {
    PartnerSubCategory test1 = new PartnerSubCategory("test1", R.drawable.ic_addnew);
    PartnerSubCategory test2 = new PartnerSubCategory("test2", R.drawable.ic_addnew);
    PartnerSubCategory test3 = new PartnerSubCategory("test3", R.drawable.ic_addnew);
    PartnerSubCategory test4 = new PartnerSubCategory("test4", R.drawable.ic_addnew);

    return Arrays.asList(test1, test2, test3, test4);
  }
}


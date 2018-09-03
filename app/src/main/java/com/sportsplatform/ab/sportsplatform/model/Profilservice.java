package com.sportsplatform.ab.sportsplatform.model;

public class Profilservice {

  public String profilservicetitle, profilservicesubtitle, profilservicedesc;
  public int profilservicethumbnail;

  public Profilservice(String profilservicetitle, String profilservicesubtitle, String profilservicedesc, int profilservicethumbnail) {
    this.profilservicetitle = profilservicetitle;
    this.profilservicesubtitle = profilservicesubtitle;
    this.profilservicedesc = profilservicedesc;
    this.profilservicethumbnail = profilservicethumbnail;
  }

  public String getProfilserviceTitle() {
    return profilservicetitle;
  }

  public String ProfilserviceSubtitle() {
    return profilservicesubtitle;
  }

  public int getProfilserviceThumbnail() {
    return profilservicethumbnail;
  }

  public String getProfilserviceDesc() {
    return profilservicedesc;
  }
}


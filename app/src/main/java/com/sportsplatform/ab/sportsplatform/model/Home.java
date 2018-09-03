package com.sportsplatform.ab.sportsplatform.model;

  public class Home {

  public String hometitle, homesubtitle,homedesc;
  public int homethumbnail;

  public Home(String hometitle, String homesubtitle, String homedesc, int homethumbnail) {
    this.hometitle = hometitle;
    this.homesubtitle = homesubtitle;
    this.homedesc = homedesc;
    this.homethumbnail = homethumbnail;
  }

  public String getHometitle() {
    return hometitle;
  }

  public String getHomesubtitle() {
    return homesubtitle;
  }

  public String getHomedesc() {
    return homedesc;
  }

  public int getHomethumbnail() {
    return homethumbnail;
  }
}


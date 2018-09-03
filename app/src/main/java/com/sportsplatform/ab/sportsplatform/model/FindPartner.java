package com.sportsplatform.ab.sportsplatform.model;

public class FindPartner {

  public String findpartnertitle, findpartnersubtitle,findpartnerdetail;
  public int findpartnerthumbnail;

  public FindPartner(String findpartnertitle, String findpartnersubtitle, String findpartnerdetail, int findpartnerthumbnail) {
    this.findpartnertitle = findpartnertitle;
    this.findpartnersubtitle =findpartnersubtitle;
    this.findpartnerdetail = findpartnerdetail;
    this.findpartnerthumbnail = findpartnerthumbnail;
  }

  public String getFindpartnertitle() {
    return findpartnertitle;
  }

  public String getFindpartnersubtitle() {
    return findpartnersubtitle;
  }

  public String getFindpartnerdetail() {
    return findpartnerdetail;
  }

  public int getFindpartnerthumbnail() {
    return findpartnerthumbnail;
  }
}


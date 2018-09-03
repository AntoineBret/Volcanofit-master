package com.sportsplatform.ab.sportsplatform.model;

public class CSDesc {

  public String csdesctitle, csdescsubtitle,csdescdetail;
  public int csdescthumbnail;

  public CSDesc(String csdesctitle, String csdescsubtitle, String csdescdetail, int csdescthumbnail) {
    this.csdesctitle = csdesctitle;
    this.csdescsubtitle = csdescsubtitle;
    this.csdescdetail = csdescdetail;
    this.csdescthumbnail = csdescthumbnail;
  }

  public String getCsdesctitle() {
    return csdesctitle;
  }

  public String getCsdescsubtitle() {
    return csdescsubtitle;
  }

  public String getCsdescdetail() {
    return csdescdetail;
  }

  public int getCsdescthumbnail() {
    return csdescthumbnail;
  }
}


package com.sportsplatform.ab.sportsplatform.model;

  public class DetailsPartner {

    public String detailspartnertitle, detailspartnersubtitle,detailspartnerdetail;
    public int detailspartnerthumbnail;

    public DetailsPartner(String detailspartnertitle, String detailspartnersubtitle, String detailspartnerdetail, int detailspartnerthumbnail) {
      this.detailspartnertitle = detailspartnertitle;
      this.detailspartnersubtitle =detailspartnersubtitle;
      this.detailspartnerdetail = detailspartnerdetail;
      this.detailspartnerthumbnail = detailspartnerthumbnail;
    }

    public String getDetailspartnertitle() {
      return detailspartnertitle;
    }

    public String getDetailspartnersubtitle() {
      return detailspartnersubtitle;
    }

    public String getDetailspartnerdetail() {
      return detailspartnerdetail;
    }

    public int getDetailspartnerthumbnail() {
      return detailspartnerthumbnail;
    }
  }


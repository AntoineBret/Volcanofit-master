package com.sportsplatform.ab.sportsplatform.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sportsplatform.ab.sportsplatform.R;

public class WebViewFragment extends Fragment {
  public WebView wv;
  String url;
  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    url = this.getArguments().getString("url");
    wv = (WebView) view.findViewById(R.id.webView);
    callWebClient(url);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.webview_fragment, container, false);
    return rootView;
  }

  private void callWebClient(String url) {
    wv.setWebViewClient(new myWebViewClient());
    wv.getSettings().setLoadsImagesAutomatically(true);
    wv.getSettings().setJavaScriptEnabled(true);
    wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    wv.loadUrl(url);
  }

  public static class myWebViewClient extends WebViewClient {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      view.loadUrl(url);
      return true;
    }
  }
}

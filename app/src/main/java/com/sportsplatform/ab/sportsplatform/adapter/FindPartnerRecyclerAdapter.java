package com.sportsplatform.ab.sportsplatform.adapter;

import android.content.Context;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.FindPartner;

import java.util.List;

public class FindPartnerRecyclerAdapter extends RecyclerView.Adapter<FindPartnerRecyclerAdapter.ViewHolder> {

  private Context context;
  public List<FindPartner> findPartnerList;
  private LayoutInflater inflater = null;

  public FindPartnerRecyclerAdapter(Context context, List<FindPartner> findPartnerList) {
    this.context = context;
    this.findPartnerList = findPartnerList;
    inflater = LayoutInflater.from(context);
  }

  @Override
  public FindPartnerRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    this.context = viewGroup.getContext();
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.findpartner_cardview, viewGroup, false);
    return new FindPartnerRecyclerAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final FindPartnerRecyclerAdapter.ViewHolder holder, final int i) {
    holder.setIsRecyclable(false);
    final FindPartner findPartner = findPartnerList.get(i);
    Glide.with(context).load(findPartner.getFindpartnerthumbnail()).into(holder.findpartnerthumbnail);
    holder.findpartnertitle.setText(findPartner.getFindpartnertitle());
    holder.findpartnersubtitle.setText(findPartner.getFindpartnersubtitle());
    holder.findpartnerdetail.setText(findPartner.getFindpartnerdetail());
  }

  @Override
  public int getItemCount() {
    return findPartnerList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView findpartnertitle;
    public TextView findpartnersubtitle;
    public TextView findpartnerdetail;
    private ImageView findpartnerthumbnail;

    public ViewHolder(View view) {
      super(view);

      findpartnertitle = (TextView) view.findViewById(R.id.findpartner_title);
      findpartnersubtitle = (TextView) view.findViewById(R.id.findpartner_subtitle);
      findpartnerdetail = (TextView) view.findViewById(R.id.findpartner_detail);
      findpartnerthumbnail = (ImageView) view.findViewById(R.id.findpartner_thumbnail);
    }
  }
}

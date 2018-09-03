package com.sportsplatform.ab.sportsplatform.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.CSDesc;

import java.util.List;

public class CSDescRecyclerAdapter extends RecyclerView.Adapter <CSDescRecyclerAdapter.ViewHolder> {

  private Context context;
  public List<CSDesc> csDescList;
  private LayoutInflater inflater = null;

  public CSDescRecyclerAdapter(Context context, List<CSDesc> csDescList) {
    this.context = context;
    this.csDescList = csDescList;
    inflater = LayoutInflater.from(context);
  }

  @Override
  public CSDescRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    this.context = viewGroup.getContext();
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.csdesc_cardview, viewGroup, false);
    return new CSDescRecyclerAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final CSDescRecyclerAdapter.ViewHolder holder, final int i) {
    holder.setIsRecyclable(false);
    final CSDesc csDesc = csDescList.get(i);
    Glide.with(context).load(csDesc.getCsdescthumbnail()).into(holder.csdescthumbnail);
    holder.csdesctitle.setText(csDesc.getCsdesctitle());
    holder.csdescsubtitle.setText(csDesc.getCsdescsubtitle());
    holder.csdescdetail.setText(csDesc.getCsdescdetail());
  }

  @Override
  public int getItemCount() {
    return csDescList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView csdesctitle;
    public TextView csdescsubtitle;
    public TextView csdescdetail;
    private ImageView csdescthumbnail;

    public ViewHolder(View view) {
      super(view);

      csdesctitle = (TextView) view.findViewById(R.id.csdesc_title);
      csdescsubtitle = (TextView) view.findViewById(R.id.csdesc_subtitle);
      csdescdetail = (TextView) view.findViewById(R.id.csdesc_desc);
      csdescthumbnail = (ImageView) view.findViewById(R.id.csdesc_thumbnail);
    }
  }
}

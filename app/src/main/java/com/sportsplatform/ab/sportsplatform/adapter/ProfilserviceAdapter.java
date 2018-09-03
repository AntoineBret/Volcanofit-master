package com.sportsplatform.ab.sportsplatform.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.Profilservice;

import java.util.List;

public class ProfilserviceAdapter extends RecyclerView.Adapter <ProfilserviceAdapter.ViewHolder> {

  private Context context;
  private List<Profilservice> serviceList;

  public ProfilserviceAdapter(Context context, List <Profilservice> serviceList) {
    this.context = context;
    this.serviceList = serviceList;
  }

  @Override
  public ProfilserviceAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    this.context = viewGroup.getContext();
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profilservice_card, viewGroup, false);
    return new ProfilserviceAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    Profilservice service = serviceList.get(position);
    Glide.with(context).load(service.getProfilserviceThumbnail()).into(holder.service_thumbnail);
    holder.service_title.setText(service.getProfilserviceTitle());
    holder.service_subtitle.setText(service.ProfilserviceSubtitle());

    if(position==0)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
    if(position==1)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
    if(position==2)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
    if(position==3)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
    if(position==4)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
    if(position==5)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
    if(position==6)
      holder.relativeLayout.setBackgroundResource(R.color.md_deep_orange_700);
  }

  @Override
  public int getItemCount() {
    return serviceList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView service_title, service_subtitle;
    private ImageView service_thumbnail;
    private RelativeLayout relativeLayout;

    public ViewHolder(View view) {
      super(view);
      relativeLayout = (RelativeLayout) view.findViewById(R.id.ln_service_thumbnail);
      service_title = (TextView) view.findViewById(R.id.mservice_title);
      service_subtitle = (TextView) view.findViewById(R.id.mservice_subtitle);
      service_thumbnail = (ImageView) view.findViewById(R.id.mservice_thumbnail);
    }
  }
}

package com.sportsplatform.ab.sportsplatform.adapter;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sportsplatform.ab.sportsplatform.R;
import com.sportsplatform.ab.sportsplatform.model.Home;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

  private Context context;
  public List<Home> homeList;
  private LayoutInflater inflater = null;
  private AppBarLayout appBarLayout;

  public HomeAdapter(Context context, List<Home> homeList) {
    this.context = context;
    this.homeList = homeList;
    inflater = LayoutInflater.from(context);
  }

  @Override
  public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    this.context = viewGroup.getContext();
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_cardview, viewGroup, false);
    return new HomeAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final HomeAdapter.ViewHolder holder, final int i) {
    holder.setIsRecyclable(false);
    final Home home = homeList.get(i);
    Glide.with(context).load(home.getHomethumbnail()).into(holder.homethumbnail);
    holder.hometitle.setText(home.getHometitle());
    holder.homesubtitle.setText(home.getHomesubtitle());


    if (i == 0) {
      Animation animation = AnimationUtils.loadAnimation(context, R.anim.in_aimation);
      ((ViewHolder) holder).cardView.setAnimation(animation);
      animation.start();
    }
    if (i == 1) {
      Animation animation = AnimationUtils.loadAnimation(context, R.anim.in_aimation);
      ((ViewHolder) holder).cardView.setAnimation(animation);
      animation.start();
    }
    if (i == 2) {
      Animation animation = AnimationUtils.loadAnimation(context, R.anim.in_aimation);
      ((ViewHolder) holder).cardView.setAnimation(animation);
      animation.start();
    }
    if (i == 3) {
      Animation animation = AnimationUtils.loadAnimation(context, R.anim.in_aimation);
      ((ViewHolder) holder).cardView.setAnimation(animation);
      animation.start();
    }
    if (i == 4) {
      Animation animation = AnimationUtils.loadAnimation(context, R.anim.in_aimation);
      ((ViewHolder) holder).cardView.setAnimation(animation);
      animation.start();
    }
    if (i == 5) {
      Animation animation = AnimationUtils.loadAnimation(context, R.anim.in_aimation);
      ((ViewHolder) holder).cardView.setAnimation(animation);
      animation.start();
    }
  }

  @Override
  public int getItemCount() {
    return homeList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView hometitle;
    public TextView homesubtitle;
    private ImageView homethumbnail;
    private CardView cardView;


    public ViewHolder(View view) {
      super(view);

      cardView = (CardView) view.findViewById(R.id.cv);
      hometitle = (TextView) view.findViewById(R.id.home_title);
      homesubtitle = (TextView) view.findViewById(R.id.home_subtitle);
      homethumbnail = (ImageView) view.findViewById(R.id.home_thumbnail);
    }
  }
}

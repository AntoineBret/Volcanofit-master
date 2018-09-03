package com.sportsplatform.ab.sportsplatform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sportsplatform.ab.sportsplatform.adapter.CSDescRecyclerAdapter;
import com.sportsplatform.ab.sportsplatform.adapter.RecyclerItemClickListener;
import com.sportsplatform.ab.sportsplatform.model.CSDesc;

import java.util.ArrayList;
import java.util.List;

public class FindActivityActivity extends AppCompatActivity {

  public RecyclerView recycleView;
  private GridLayoutManager gridLayoutManager;
  public List<CSDesc> csDescList = new ArrayList<CSDesc>();
  private CSDescRecyclerAdapter adapter;
  private Intent intent;
  private Toolbar toolbar;


  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_findactivity);

    toolbar = (Toolbar) findViewById(R.id.find_toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    recycleView = (RecyclerView) findViewById(R.id.find_recycler_view);
    csDescList = new ArrayList<>();

    recycleView.setLayoutManager(new GridLayoutManager(this, 1));
    recycleView.setHasFixedSize(true);
    recycleView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {
        switch (position) {
          case 0:
            intent = new Intent(FindActivityActivity.this, FindActivityActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            break;
        }
      }
    }));

    adapter = new CSDescRecyclerAdapter(this, csDescList);
    recycleView.setAdapter(adapter);

    initializeData();
  }

  private void initializeData() {
    int[] covers = new int[]{
      R.drawable.ic_basketball,
      R.drawable.ic_bodybuilding,
      R.drawable.ic_cycling,
      R.drawable.ic_indoorsport,
      R.drawable.ic_racketsport,
      R.drawable.ic_running,
      R.drawable.ic_skiing,
      R.drawable.ic_walking,
      R.drawable.ic_yoga,
    };

    CSDesc c = new CSDesc("Basketball", "test 1 subtitle", "test 1 detail", covers[0]);
    csDescList.add(c);

    c = new CSDesc("Musculation", "test 2 subtitle", "test 2 detail", covers[1]);
    csDescList.add(c);

    c = new CSDesc("Vélo", "test 3 subtitle", "test 3 detail", covers[2]);
    csDescList.add(c);

    c = new CSDesc("Sports indoor", "test 4 subtitle", "test 4 detail", covers[3]);
    csDescList.add(c);

    c = new CSDesc("Sports de raquette", "test 4 subtitle", "test 4 detail", covers[4]);
    csDescList.add(c);

    c = new CSDesc("Cardio training", "test 4 subtitle", "test 4 detail", covers[5]);
    csDescList.add(c);

    c = new CSDesc("Sports de glisse", "test 4 subtitle", "test 4 detail", covers[6]);
    csDescList.add(c);

    c = new CSDesc("Marche", "test 4 subtitle", "test 4 detail", covers[7]);
    csDescList.add(c);

    c = new CSDesc("Yoga", "test 4 subtitle", "test 4 detail", covers[8]);
    csDescList.add(c);

    adapter.notifyDataSetChanged();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(0, android.R.anim.slide_out_right);
  }
}


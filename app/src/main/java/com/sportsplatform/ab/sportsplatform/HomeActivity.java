package com.sportsplatform.ab.sportsplatform;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.sportsplatform.ab.sportsplatform.fragment.AccountFriendFragment;
import com.sportsplatform.ab.sportsplatform.fragment.AccountGroupFragment;
import com.sportsplatform.ab.sportsplatform.fragment.AccountProfilFragment;
import com.sportsplatform.ab.sportsplatform.fragment.CoachingCompanyFragment;
import com.sportsplatform.ab.sportsplatform.fragment.CoachingHealthFragment;
import com.sportsplatform.ab.sportsplatform.fragment.CommunityDiscussionFragment;
import com.sportsplatform.ab.sportsplatform.fragment.CommunityHomeFragment;
import com.sportsplatform.ab.sportsplatform.fragment.CommunityPartnerFragment;
import com.sportsplatform.ab.sportsplatform.fragment.ContactMainFragment;
import com.sportsplatform.ab.sportsplatform.fragment.DashboardActivityFragment;
import com.sportsplatform.ab.sportsplatform.fragment.HomeFragment;
import com.sportsplatform.ab.sportsplatform.fragment.WebViewFragment;
import com.sportsplatform.ab.sportsplatform.startup.StartSignInActivity;
import com.sportsplatform.ab.sportsplatform.util.AuthManager;
import com.sportsplatform.ab.sportsplatform.util.Constants;
import com.sportsplatform.ab.sportsplatform.util.GoogleSignInSingleton;

public class HomeActivity extends AppCompatActivity {

  private AccountHeader header = null;
  private Drawer result = null;
  private AuthManager authManager;

  GoogleSignInSingleton signInSingleton = GoogleSignInSingleton.getInstance(null);
  GoogleSignInAccount googleAccount = signInSingleton.getGoogleSignIn();

  private IProfile profile = new ProfileDrawerItem()
    .withName(googleAccount.getDisplayName())
    .withEmail(googleAccount.getEmail())
    .withIcon(googleAccount.getPhotoUrl())
    .withIdentifier(Constants.defaultProfile);

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    authManager = AuthManager.getInstance();
    authManager.onCreate(this, null);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    createAccountHeader(googleAccount);
    createDrawer(toolbar);

    if (savedInstanceState == null) {
      Fragment f = HomeFragment.newInstance();
      getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, f).addToBackStack(null).commit();
    }
  }

  private void createAccountHeader(GoogleSignInAccount googleAccount) {

    //initialize and create the image loader logic
    DrawerImageLoader.init(new AbstractDrawerImageLoader() {
      @Override
      public void set(ImageView imageView, Uri uri, Drawable placeholder) {
        Glide.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
      }

      @Override
      public void cancel(ImageView imageView) {
        Glide.clear(imageView);
      }
    });

    header = new AccountHeaderBuilder()
      .withActivity(this)
      .withTranslucentStatusBar(true)
      .withHeaderBackground(R.drawable.splash_background)
      .addProfiles(profile, new ProfileSettingDrawerItem().withName(getString(R.string.navHeaderSignOut)).withIdentifier(Constants.profileRemoveID))
      .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
        @Override
        public boolean onProfileChanged(View view, IProfile profile, boolean current) {
          //if the clicked item has the identifier 1 add a new profile ;)
          if (profile.getIdentifier() == Constants.profileRemoveID) {
            authManager.signOut();
            getSharedPreferences(Constants.preferenceKey, MODE_PRIVATE).edit().putBoolean(Constants.preferenceFirstRun, true).commit();
            Intent i = new Intent(getApplicationContext(), StartSignInActivity.class);
            startActivity(i);
            finish();
            Toast.makeText(getApplicationContext(), R.string.debugSignOut, Toast.LENGTH_LONG).show();
          }

          //false if you have not consumed the event and it should close the drawer
          return false;
        }
      })
      .build();

  }

  private void createDrawer(Toolbar toolbar) {
    result = new DrawerBuilder()
      .withActivity(this)
      .withToolbar(toolbar)
      .withAccountHeader(header)
      .addDrawerItems(
        new PrimaryDrawerItem().withName(R.string.title_home).withDescription(R.string.desc_coaching_sport).withIcon(R.drawable.ic_home).withIdentifier(Constants.Home).withSelectable(true),
        new ExpandableDrawerItem().withName(R.string.SectionDrawer_activity).withSelectable(false).withSubItems(
          new PrimaryDrawerItem().withName(R.string.title_coaching_sport).withDescription(R.string.desc_coaching_sport).withIcon(R.drawable.ic_sport).withIdentifier(Constants.CoachingSport).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_coaching_company).withDescription(R.string.desc_coaching_health).withIcon(R.drawable.ic_teambuilding).withIdentifier(Constants.CoachingCompany).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_coaching_health).withDescription(R.string.desc_coaching_company).withIcon(R.drawable.ic_health).withIdentifier(Constants.CoachingHealth).withSelectable(true)),

        new ExpandableDrawerItem().withName(R.string.SectionDrawer_account).withSelectable(false).withSubItems(
          new PrimaryDrawerItem().withName(R.string.title_account_profil).withDescription(R.string.desc_account_profil).withIcon(R.drawable.ic_profil).withIdentifier(Constants.AccountProfil).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_account_dashboard).withDescription(R.string.desc_account_dashboard).withIcon(R.drawable.ic_dashboard).withIdentifier(Constants.DashboardActivity).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_account_friend).withDescription(R.string.desc_account_friend).withIcon(R.drawable.ic_friend).withIdentifier(Constants.AccountFriend).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_account_group).withDescription(R.string.desc_account_group).withIcon(R.drawable.ic_group).withIdentifier(Constants.AccountGroup).withSelectable(true)),

        new ExpandableDrawerItem().withName(R.string.SectionDrawer_community).withSelectable(false).withSubItems(
          new PrimaryDrawerItem().withName(R.string.title_community_news).withDescription(R.string.desc_community_news).withIcon(R.drawable.ic_news).withIdentifier(Constants.CommunityHome).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_community_discussion).withDescription(R.string.desc_community_discussion).withIcon(R.drawable.ic_discuss).withIdentifier(Constants.CommunityDiscussion).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_community_partner).withDescription(R.string.desc_community_partner).withIcon(R.drawable.ic_partner).withIdentifier(Constants.CommunityPartner).withSelectable(true)),

        new ExpandableDrawerItem().withName(R.string.SectionDrawer_contact).withSelectable(false).withSubItems(
          new PrimaryDrawerItem().withName(R.string.title_contact_main).withDescription(R.string.desc_contact_main).withIcon(R.drawable.ic_contact).withIdentifier(Constants.ContactMain).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_contact_twitter).withIcon(R.drawable.ic_twitter).withIdentifier(Constants.Twitter).withSelectable(true),
          new PrimaryDrawerItem().withName(R.string.title_contact_facebook).withIcon(R.drawable.ic_facebook).withIdentifier(Constants.Facebook).withSelectable(true)))

      .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
          FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
          fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          Fragment fragment = new Fragment();
          Intent intent = null;
          Bundle bundle = new Bundle();

          if (drawerItem.getIdentifier() == Constants.Home) {
            fragment = new HomeFragment();
          } else if (drawerItem.getIdentifier() == Constants.CoachingSport) {
            intent = new Intent(HomeActivity.this, FindActivityActivity.class);
          } else if (drawerItem.getIdentifier() == Constants.CoachingCompany) {
            fragment = new CoachingHealthFragment();
          } else if (drawerItem.getIdentifier() == Constants.CoachingHealth) {
            fragment = new CoachingCompanyFragment();
          } else if (drawerItem.getIdentifier() == Constants.AccountProfil) {
            fragment = new AccountProfilFragment();
          } else if (drawerItem.getIdentifier() == Constants.DashboardActivity) {
            fragment = new DashboardActivityFragment();
          } else if (drawerItem.getIdentifier() == Constants.AccountFriend) {
            fragment = new AccountFriendFragment();
          } else if (drawerItem.getIdentifier() == Constants.AccountGroup) {
            fragment = new AccountGroupFragment();
          } else if (drawerItem.getIdentifier() == Constants.CommunityHome) {
            fragment = new CommunityHomeFragment();
          } else if (drawerItem.getIdentifier() == Constants.CommunityDiscussion) {
            fragment = new CommunityDiscussionFragment();
          } else if (drawerItem.getIdentifier() == Constants.CommunityPartner) {
            fragment = new CommunityPartnerFragment();
          } else if (drawerItem.getIdentifier() == Constants.ContactMain) {
            fragment = new ContactMainFragment();
          } else if (drawerItem.getIdentifier() == Constants.Twitter) {
            bundle.putString("url", "https://twitter.com/hashtag/volcanofit?src=hash");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
          } else if (drawerItem.getIdentifier() == Constants.Facebook) {
            bundle.putString("url", "https://www.facebook.com/VolcanoFit/");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
          }

          fragmentTransaction.replace(R.id.main_settings_container, fragment);
          fragmentTransaction.addToBackStack(null);
          fragmentTransaction.commit();

          if (intent != null) {
            HomeActivity.this.startActivity(intent);
          }
          return false;
        }
      })
      .build();
    result.setSelection(Constants.CoachingSport, true);
  }


  @Override
  public void onBackPressed() {
    if (result != null && result.isDrawerOpen()) {
      result.closeDrawer();
    } else {
      int fragments = getSupportFragmentManager().getBackStackEntryCount();
      if (fragments == 1) {
        finish();
      } else {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
          getFragmentManager().popBackStack();
        } else {
          super.onBackPressed();
        }
      }
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      result.openDrawer();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}

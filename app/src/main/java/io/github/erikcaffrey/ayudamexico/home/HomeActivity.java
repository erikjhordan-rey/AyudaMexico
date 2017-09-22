package io.github.erikcaffrey.ayudamexico.home;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.common.CoreActivity;

public class HomeActivity extends CoreActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override protected int getLayoutResId() {
        return R.layout.home_activity;
    }

    @Override protected void initActivity()
    {
        super.initActivity();
        initActionBarDrawerToggle();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @Override public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody") @Override public boolean onNavigationItemSelected(MenuItem item) {
        final int id = item.getItemId();
        final Fragment fragment = NavigationFragmentFactory.create(id);
        final int title = NavigationFragmentFactory.getTitle();
        toolbar.setTitle(title);
        onReplaceTransaction(fragment);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initActionBarDrawerToggle() {
        ActionBarDrawerToggle toggle =
            new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void onReplaceTransaction(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
    }
}

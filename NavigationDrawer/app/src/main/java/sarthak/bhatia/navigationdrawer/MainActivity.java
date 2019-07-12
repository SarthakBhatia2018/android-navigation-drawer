package sarthak.bhatia.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    FragmentManager manager;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        manager = getSupportFragmentManager();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawable_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null)
        {
            manager.beginTransaction().add(R.id.fragment_container,new fragment_1()).commit();
            navigationView.setCheckedItem(R.id.message1);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (menuItem.getItemId() == R.id.message1) {
            fragment_1 f1 = new fragment_1();
            transaction.replace(R.id.fragment_container, f1, "frag1");
            transaction.commit();
        } else if (menuItem.getItemId() == R.id.chat) {
            fragment_2 f1 = new fragment_2();
            transaction.replace(R.id.fragment_container, f1, "frag2");
            transaction.commit();
        } else if (menuItem.getItemId() == R.id.profile) {
            fragment_3 f1 = new fragment_3();
            transaction.replace(R.id.fragment_container, f1, "frag3");
            transaction.commit();
        } else if (menuItem.getItemId() == R.id.share) {
            Toast.makeText(this, "You clicked share", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You clicked send", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
package com.example.gabbygiordano.marketplace;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gabbygiordano.marketplace.fragments.ItemsPagerAdapter;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ViewPager viewPager;
    ItemsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuitem = menu.getItem(0);
        menuitem.setChecked(true);

        adapter = new ItemsPagerAdapter(getSupportFragmentManager(), this);

        // set up the adapter for the pager
        viewPager.setAdapter(adapter);

        // setup the Tab Layout to use the view pager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        Toast.makeText(HomeActivity.this, "Home Tab Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_search:
                        // Toast.makeText(HomeActivity.this, "Search Tab Selected", Toast.LENGTH_SHORT).show();
                        Intent i_search = new Intent(HomeActivity.this, SearchActivity.class);
                        startActivity(i_search);
                        break;

                    case R.id.action_add:
                        Intent i_add = new Intent(HomeActivity.this, AddItemActivity.class);
                        startActivity(i_add);
                        // Toast.makeText(HomeActivity.this, "Add Tab Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_notifications:
                        Intent i_notifications = new Intent(HomeActivity.this, NotificationsActivity.class);
                        startActivity(i_notifications);
                        // Toast.makeText(HomeActivity.this, "Notifications Tab Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_profile:
                        // Toast.makeText(HomeActivity.this, "Profile Tab Selected", Toast.LENGTH_SHORT).show();
                        onProfileClick();
                        break;
                }

                return false;
            }
        });

    }

<<<<<<< HEAD
=======
    public void onAddItemClick(){
        Intent i = new Intent(this, AddItemActivity.class);
        startActivity(i);
    }

    public void onSearchClick(){
        Intent i = new Intent(this, SearchActivity.class);
        startActivity(i);
    }

    public void onNotificationsClick(){
        Intent i = new Intent(this, NotificationsActivity.class);
        startActivity(i);
    }

    public void onProfileClick(){
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
>>>>>>> master
}

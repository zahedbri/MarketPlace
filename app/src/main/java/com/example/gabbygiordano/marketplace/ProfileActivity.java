package com.example.gabbygiordano.marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseUser;

public class ProfileActivity extends AppCompatActivity {

    ImageView ivProfileImage;
    TextView tvName;
    TextView tvUsername;
    TextView tvCollege;
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // perform find view by id lookups
        ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
        tvName = (TextView) findViewById(R.id.tvName);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvCollege = (TextView) findViewById(R.id.tvCollege);
        tvPhone = (TextView) findViewById(R.id.tvPhone);

        // set text to user info
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            tvName.setText(currentUser.getString("name"));
            tvUsername.setText(currentUser.getUsername());
            tvCollege.setText(currentUser.getString("college"));
            tvPhone.setText(String.valueOf(currentUser.getLong("phone")));
        } else {
            // show the signup or login screen
        }

        BottomNavigationView bottomNavigationView;

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuitem = menu.getItem(4);
        menuitem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        //Toast.makeText(HomeActivity.this, "Home Tab Selected", Toast.LENGTH_SHORT).show();
                        Intent i_home = new Intent(ProfileActivity.this, HomeActivity.class);
                        startActivity(i_home);
                        break;

                    case R.id.action_search:
                        // Toast.makeText(HomeActivity.this, "Search Tab Selected", Toast.LENGTH_SHORT).show();
                        Intent i_search = new Intent(ProfileActivity.this, SearchActivity.class);
                        startActivity(i_search);
                        break;

                    case R.id.action_add:
                        // Toast.makeText(HomeActivity.this, "Add Tab Selected", Toast.LENGTH_SHORT).show();
                        Intent i_add = new Intent(ProfileActivity.this, AddItemActivity.class);
                        startActivity(i_add);
                        break;

                    case R.id.action_notifications:
                        Intent i_notifications = new Intent(ProfileActivity.this, NotificationsActivity.class);
                        startActivity(i_notifications);
                        // Toast.makeText(HomeActivity.this, "Notifications Tab Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_profile:
                        //Toast.makeText(NotificationsActivity.this, "Profile Tab Selected", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }
}

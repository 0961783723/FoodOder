package com.example.oderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private static final String TAG = "Home";
    BottomNavigationView bottomNavigationView;
    ImageView ivTop;

    Food food1, food2, food3, food4, food5, food6, food7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.nav);
        ivTop = findViewById(R.id.ivTop);

        food1 = new Food(0,"Pizza",40000);
        food2 = new Food(1,"Bánh Mỳ",15000);
        food3 = new Food(2,"Kem",15000);
        food4 = new Food(3,"Milo",24000);
        food5 = new Food(4,"KFC",60000);
        food6 = new Food(5,"Cake Cup",10000);
        food7 = new Food(6,"Coca Cola",8000);

        ivTop.setVisibility(View.INVISIBLE);
        getFragment(MenuFragment.newInstance());


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_Home:
                        getFragment(MenuFragment.newInstance());
                        ivTop.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.menu_cart:
                        getFragment(PayFragment.newInstance());
                        ivTop.setVisibility(View.VISIBLE);
                        break;
                    case R.id.menu_Notifications:
                        getFragment(AccountFragment.newInstance());
                        ivTop.setVisibility(View.VISIBLE);
                        break;
                }
                return false;
            }
        });


    }

    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage()); /////////////////////// logd
        }

    }
}

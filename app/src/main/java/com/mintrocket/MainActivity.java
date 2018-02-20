package com.mintrocket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RepositoriesFragment fragment = RepositoriesFragment.newInstance();
        replaceFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

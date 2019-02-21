package com.example.callbackappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.callbackappfromscratch.frag.DisplayFragment;
import com.example.callbackappfromscratch.frag.InputFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputFragment inputFragment = new InputFragment().newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, inputFragment)
                .addToBackStack("input")
                .commit();
    }


    @Override
    public void toNextFragment(String first, String second, String third) {
        DisplayFragment displayFragment = new DisplayFragment().newInstance(first, second, third);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, displayFragment)
                .addToBackStack("display")
                .commit();
    }
}

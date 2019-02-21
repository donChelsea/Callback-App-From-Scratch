package com.example.callbackappfromscratch.frag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.callbackappfromscratch.FragmentInterface;
import com.example.callbackappfromscratch.R;

public class DisplayFragment extends Fragment {
    private static final String FIRST_STRING = "first string";
    private static final String SECOND_STRING = "second string";
    private static final String THIRD_STRING = "third string";
    private String firstString;
    private String secondString;
    private String thirdString;
    private FragmentInterface fragmentInterface;
    private TextView textView;
    private String sillyString;


    public DisplayFragment() {
    }

    public DisplayFragment newInstance(String first, String second, String third) {
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(FIRST_STRING, first);
        args.putString(SECOND_STRING, second);
        args.putString(THIRD_STRING, third);
        displayFragment.setArguments(args);
        return displayFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        assert args != null;
        firstString = args.getString(FIRST_STRING);
        secondString = args.getString(SECOND_STRING);
        thirdString = args.getString(THIRD_STRING);

        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.display_textview);

        sillyString = "I love to eat " + firstString + " while " + secondString + " in the " + thirdString;
        textView.setText(sillyString);
    }
}

package com.example.callbackappfromscratch.frag;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.callbackappfromscratch.FragmentInterface;
import com.example.callbackappfromscratch.R;

public class InputFragment extends Fragment {
    private FragmentInterface fragmentInterface;
    private EditText firstEt;
    private EditText secondEt;
    private EditText thirdEt;
    private Button mainButton;


    public InputFragment() {
    }

    public InputFragment newInstance() {
        return new InputFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstEt = view.findViewById(R.id.first_edittext);
        secondEt = view.findViewById(R.id.second_edittext);
        thirdEt = view.findViewById(R.id.third_edittext);
        mainButton = view.findViewById(R.id.main_button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = firstEt.getText().toString();
                String second = secondEt.getText().toString();
                String third = thirdEt.getText().toString();
                fragmentInterface.toNextFragment(first, second, third);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }
}

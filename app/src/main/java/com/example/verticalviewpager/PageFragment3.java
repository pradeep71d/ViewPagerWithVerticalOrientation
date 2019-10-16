package com.example.verticalviewpager;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment3 extends Fragment {
    public PageFragment3() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     ViewGroup rootView= (ViewGroup) inflater.inflate(R.layout.fragment_page_fragment3, container, false);
     return rootView;
    }

}

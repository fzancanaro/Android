package com.example.matthewc.myviewpagerapplication;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by matthewc on 4/13/2017.
 */
public class TextFragment extends Fragment {

    String text;



    public void setText(String text){
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment_layout, container, false);

        TextView textView = (TextView)view.findViewById(R.id.fragmentText);

        textView.setText(text);

        return view;

    }
}

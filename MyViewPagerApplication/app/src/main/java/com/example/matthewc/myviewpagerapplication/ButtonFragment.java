package com.example.matthewc.myviewpagerapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by matthewc on 4/13/2017.
 */
public class ButtonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_fragment_layout, container, false);

        Button btn = (Button)view.findViewById(R.id.fragmentButton);

        btn.setText("Buy App"); //can change the text to anything, similar to text fragment if you like

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "THANKS FOR BUYING THIS APP!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

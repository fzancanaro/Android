package com.example.matthewc.myviewpagerapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by matthewc on 4/13/2017.
 */
public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment_layout, container, false);

        //get reference to imageView inside of our generated layout
        ImageView img = (ImageView)view.findViewById(R.id.fragmentImage);
        img.setImageResource(R.drawable.lion); //to change image, you reference its name from the drawable folder

        return view;


    }
}

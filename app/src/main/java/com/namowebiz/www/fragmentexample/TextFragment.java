package com.namowebiz.www.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 2015-08-03.
 */
public class TextFragment  extends Fragment {

    private static TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.text_fragment, container, false);

        textview = (TextView)view.findViewById(R.id.textView);

        return view;
    }

    public void changeTextProperties(int fontsize, String text){
        textview.setTextSize(fontsize);
        textview.setText(text);
    }

}

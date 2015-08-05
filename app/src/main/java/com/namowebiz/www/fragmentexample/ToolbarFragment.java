package com.namowebiz.www.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by User on 2015-08-03.
 */
public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private static int seekvalue = 10;
    private static EditText edittext;

    ToolbarListener activityCallback;

    public interface ToolbarListener {
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            activityCallback = (ToolbarListener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.toobar_fragment, container, false);

        edittext =(EditText)view.findViewById(R.id.editText);
        final SeekBar seekbar = (SeekBar)view.findViewById(R.id.seekBar);

        seekbar.setOnSeekBarChangeListener(this);

        final Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                buttonClicked(v);       
            }
        });

        return view;
    }

    public void buttonClicked(View v) {
        activityCallback.onButtonClick(seekvalue, edittext.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekvalue = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}

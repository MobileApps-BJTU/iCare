package com.example.n56.care.View;


import android.os.Bundle;
import android.app.Fragment;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.n56.care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {

    //private TextView back;

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        /*
        back = (TextView)view.findViewById(R.id.Back);
        // Inflate the layout for this fragment
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/
        // Inflate the layout for this fragment
        return view;
    }

}

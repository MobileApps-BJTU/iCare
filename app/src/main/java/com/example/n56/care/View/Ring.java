package com.example.n56.care.View;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.n56.care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ring extends Fragment{

    private ImageView ring;
    public Ring() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_ring, container, false);
        ring = (ImageView)myView.findViewById(R.id.ring);
        return myView;
    }

    @Override
       public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            ring.setOnClickListener(new View.OnClickListener() {

                       public void onClick(View v) {
                          final String[] items = {"110","119","120"};
                          new AlertDialog.Builder(getActivity())
                                  .setTitle("Emergency")
                                  .setItems(items, new DialogInterface.OnClickListener() {
                                      public void onClick(DialogInterface dialog, int item) {
                                          switch (item) {
                                              case 0:

                                                  Toast.makeText(getActivity(), items[item], Toast.LENGTH_LONG).show();
                                                  break;
                                              case 1:
                                                  Toast.makeText(getActivity(), items[item], Toast.LENGTH_LONG).show();
                                                  break;
                                              case 2:
                                                  Toast.makeText(getActivity(), items[item], Toast.LENGTH_LONG).show();
                                                  break;
                                          }
                                      }
                                  }).show();//显示对话框

                      }
                   });
          }


}

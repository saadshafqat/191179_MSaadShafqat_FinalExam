package com.example.a191179_msaadshafqat_mclabfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddHobbey#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddHobbey extends Fragment {
 static EditText txt,txt1;
Button btn;
DBHelper dbHelper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddHobbey() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddHobbey.
     */
    // TODO: Rename and change types and number of parameters
    public static AddHobbey newInstance(String param1, String param2) {
        AddHobbey fragment = new AddHobbey();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private List<HobbeyData> hobbeyDataList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      View view= inflater.inflate(R.layout.fragment_add_hobbey, container, false);
      txt=view.findViewById(R.id.namehobbey);
      txt1=view.findViewById(R.id.timehobbey);
      btn=view.findViewById(R.id.addbtn);
dbHelper=new DBHelper(this);
      String name=txt.getText().toString().trim();
      String time=txt1.getText().toString().trim();

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String name=txt.getText().toString().trim();
              String time=txt1.getText().toString().trim();
              Boolean checkinsertdata = dbHelper.insertData(name, time);
              if(checkinsertdata==true){
                  Toast.makeText(getContext(), "Data Inserted in SQL ", Toast.LENGTH_SHORT).show();
              }

          }
      });





      return view;
    }
}
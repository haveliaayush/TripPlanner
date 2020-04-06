package com.example.tripplanner.ui.hotel;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tripplanner.R;

import java.util.Calendar;

public class HotelFragment extends Fragment {

    ImageButton btn_min_g,btn_add_g,btn_min_r,btn_add_r;
    TextView sel_nog,sel_nor;
    EditText sel_doci, sel_doco;
    Button search;
    AutoCompleteTextView city;

    private DatePickerDialog.OnDateSetListener dateSetListenerI, dateSetListenerO;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_hotel, container, false);

        btn_add_g = root.findViewById(R.id.btn_plus);
        btn_min_g = root.findViewById(R.id.btn_minus);
        btn_add_r = root.findViewById(R.id.btn_plus_2);
        btn_min_r = root.findViewById(R.id.btn_minus_2);
        sel_nog = root.findViewById(R.id.sel_nog);
        sel_nor = root.findViewById(R.id.sel_nor);
        sel_doci = root.findViewById(R.id.sel_doci);
        sel_doco = root.findViewById(R.id.sel_doco);
        search = root.findViewById(R.id.search);
        city = root.findViewById(R.id.city);

        sel_doci.setInputType(0);
        sel_doco.setInputType(0);

        btn_min_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(sel_nog.getText().toString()) == 1) {
                    AlertDialog.Builder alBuilder = new AlertDialog.Builder(getContext());
                    alBuilder.setMessage("Invalid Selection");
                    alBuilder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                }
                            });
                    AlertDialog alertDialog = alBuilder.create();
                    alertDialog.show();
                }
                else
                    sel_nog.setText(String.valueOf(Integer.parseInt(sel_nog.getText().toString())-1));
            }
        });

        btn_min_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(sel_nor.getText().toString()) == 1) {
                    AlertDialog.Builder alBuilder = new AlertDialog.Builder(getContext());
                    alBuilder.setMessage("Invalid Selection");
                    alBuilder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                }
                            });
                    AlertDialog alertDialog = alBuilder.create();
                    alertDialog.show();
                }
                else
                    sel_nor.setText(String.valueOf(Integer.parseInt(sel_nor.getText().toString())-1));
            }
        });

        btn_add_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel_nog.setText(String.valueOf(Integer.parseInt(sel_nog.getText().toString())+1));
            }
        });

        btn_add_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel_nor.setText(String.valueOf(Integer.parseInt(sel_nor.getText().toString())+1));
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(city.getText().toString().length() == 0 || sel_doci.getText().toString().length() == 0 || sel_doco.getText().toString().length() == 0)
                    Toast.makeText(getContext(), "Incomplete details", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Searching Hotels", Toast.LENGTH_SHORT).show();
            }
        });


        sel_doci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal =Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog =new DatePickerDialog(getContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar,dateSetListenerI,year,month,day);
                dialog.show();

            }
        });
        dateSetListenerI=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                String Date=i2+"/"+i1+"/"+i;
                sel_doci.setText(Date);
            }
        };

        sel_doco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal =Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog =new DatePickerDialog(getContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar,dateSetListenerO,year,month,day);
                dialog.show();

            }
        });
        dateSetListenerO=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                String Date=i2+"/"+i1+"/"+i;
                sel_doco.setText(Date);
            }
        };

        return root;
    }
}

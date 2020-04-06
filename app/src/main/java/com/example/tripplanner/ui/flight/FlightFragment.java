package com.example.tripplanner.ui.flight;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tripplanner.R;

import java.util.Calendar;


public class FlightFragment extends Fragment {

    EditText sel_dot;
    TextView sel_nop;
    ImageButton btn_min,btn_add;
    Button search;
    AutoCompleteTextView src_apt,dst_apt;

    private DatePickerDialog.OnDateSetListener dateSetListener;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_flight, container, false);

        sel_dot = root.findViewById(R.id.sel_dot);
        sel_nop = root.findViewById(R.id.sel_nop);
        btn_add = root.findViewById(R.id.btn_plus);
        btn_min = root.findViewById(R.id.btn_minus);
        search = root.findViewById(R.id.search);
        src_apt = root.findViewById(R.id.src_apt);
        dst_apt = root.findViewById(R.id.dst_apt);

        sel_dot.setInputType(0);

        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(sel_nop.getText().toString()) == 1) {
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
                    sel_nop.setText(String.valueOf(Integer.parseInt(sel_nop.getText().toString())-1));
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sel_nop.setText(String.valueOf(Integer.parseInt(sel_nop.getText().toString())+1));
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(src_apt.getText().toString().length() == 0 || dst_apt.getText().toString().length() == 0 || sel_dot.getText().toString().length() == 0)
                    Toast.makeText(getContext(), "Incomplete details", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Searching Flights", Toast.LENGTH_SHORT).show();
            }
        });

        sel_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal =Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog =new DatePickerDialog(getContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar,dateSetListener,year,month,day);
                dialog.show();

            }
        });
        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                String Date=i2+"/"+i1+"/"+i;
                sel_dot.setText(Date);
            }
        };

        return root;
    }

}

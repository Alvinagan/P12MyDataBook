package sg.edu.rp.c346.p11_mydatabook;


import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {


    Button btnEdit;
    TextView tv;
    EditText etEdit;


    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.biofragment, container, false);

        btnEdit = view.findViewById(R.id.btnEdit);
        tv = view.findViewById(R.id.tv);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 = inflater.inflate(R.layout.activity_dialog, null);
                etEdit = view1.findViewById(R.id.etEdit);
                etEdit.setText(tv.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio").setView(view1).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv.setText(etEdit.getText().toString());
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });



        return view;
    }



}

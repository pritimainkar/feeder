package ml.pritimainkar.afinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
public class Donate extends Fragment implements View.OnClickListener{

    View view;
    Context context;
    CheckBox agreed;

    public Donate() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_donate, container, false);
        context= view.getContext();
        agreed = (CheckBox)view.findViewById(R.id.agreed);
        agreed.setOnClickListener(this);
        return  view;

    }

    private void showQR() {
        Intent intent= new Intent(context, qrCode.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        if (agreed.isChecked() == true) {
            showQR();
        }


    }
}
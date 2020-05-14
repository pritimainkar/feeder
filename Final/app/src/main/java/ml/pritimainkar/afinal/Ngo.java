package ml.pritimainkar.afinal;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Ngo extends Fragment implements View.OnClickListener {
    Button ngo;
    View view;
    Context context;
    public Ngo() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_ngo, container, false);
        context= view.getContext();
        ngo = (Button)view.findViewById(R.id.nearby_ngo);
        ngo.setOnClickListener(this);
        return  view;

    }
    @Override
    public void onClick(View v) {
        Intent intent= new Intent(context, map_activity.class);
        startActivity(intent);

    }
}
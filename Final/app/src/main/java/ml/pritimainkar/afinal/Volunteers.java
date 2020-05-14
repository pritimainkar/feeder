package ml.pritimainkar.afinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Volunteers extends Fragment implements View.OnClickListener {
    View view;
    Context context;
    Button beone;
    private ListView mListView;

    public Volunteers() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_volunteers, container, false);
        context= view.getContext();
        beone= (Button)view.findViewById(R.id.be_one);
        beone.setOnClickListener(this);
        mListView = (ListView)view.findViewById(R.id.volunteerList);
        ArrayList<String> listData = new ArrayList<>();
        listData.clear();
        listData.add(0, "There are no volunteers currently in your area. Be One!");
        ArrayAdapter arrayAdapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(arrayAdapter);
        return  view;
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(context, contactus.class);
        startActivity(intent);

    }
}
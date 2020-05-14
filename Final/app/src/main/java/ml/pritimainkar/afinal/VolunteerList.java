

package ml.pritimainkar.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VolunteerList extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_list);

        Button beVolunteer;

        beVolunteer = (Button)findViewById(R.id.beVolunteer);
        beVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beOne();
            }
        });

        mListView = (ListView)findViewById(R.id.volunteerList);

        ArrayList<String> listData = new ArrayList<>();
        listData.clear();
        listData.add(0, "There are no volunteers currently in your area. Be One!");


        ArrayAdapter arrayAdapter = new ArrayAdapter( this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(arrayAdapter);





    }

    private void beOne() {
        Intent intent= new Intent(this, beVolunteer.class);
        startActivity(intent);
    }
}

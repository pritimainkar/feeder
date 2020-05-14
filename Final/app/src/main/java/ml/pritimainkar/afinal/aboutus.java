package ml.pritimainkar.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aboutus extends AppCompatActivity {

    Button donation_spots, nearby_volunteers, donate_thru_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        donation_spots= (Button)findViewById(R.id.donation_spots);
        nearby_volunteers= (Button)findViewById(R.id.volunteers);
        donate_thru_us= (Button)findViewById(R.id.donate_via_us);

        donation_spots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDonationSpots();
            }
        });

        nearby_volunteers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNearbyVolunteers();
            }
        });

        donate_thru_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDonateViaUs();
            }
        });
    }


    public void showDonationSpots(){

        Intent intent= new Intent(this, map_activity.class);
        startActivity(intent);
    }
    public void showNearbyVolunteers(){

        Intent intent= new Intent(this, VolunteerList.class);
        startActivity(intent);
    }
    public void showDonateViaUs(){

        Intent intent= new Intent(this, sorted.class);
        startActivity(intent);
    }

}

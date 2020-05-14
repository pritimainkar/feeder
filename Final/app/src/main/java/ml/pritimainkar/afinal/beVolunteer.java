package ml.pritimainkar.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class beVolunteer extends AppCompatActivity {

    Button contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_volunteer);

        contact = (Button)findViewById(R.id.contact);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showContactUS();


            }
        });


    }

    private void showContactUS() {
        Intent intent = new Intent(this, contactus.class);
        startActivity(intent);
    }
}

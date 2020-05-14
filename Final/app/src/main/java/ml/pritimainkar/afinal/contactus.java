package ml.pritimainkar.afinal;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contactus extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        ((Button) findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String to = "pritimainkar7@gmail.com";
                String sub = "feeder_contact_us";
                String full_name = ((EditText)findViewById(R.id.full_name)).getText().toString();
                String number = ((EditText)findViewById(R.id.number)).getText().toString();
                String ngo_name = ((EditText)findViewById(R.id.ngo_name)).getText().toString();
                String ngo_number = ((EditText)findViewById(R.id.ngo_number)).getText().toString();
                String ngo_email = ((EditText)findViewById(R.id.ngo_email)).getText().toString();

                String mess = ("FullName = "+ full_name+
                        "\n Contact Number = "+ number+
                        "\n NGO name = "+ ngo_name+
                        "\n NGO number = "+ ngo_number+
                        "\n NGO email = "+ ngo_email+
                        "\n \n Please give Identity Proof before Sending Email - " +
                        "\n Attach photos of adharcard, pancard,etc or give link of any active social media handle");

                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT, mess);
                mail.setType("message/rfc822");
                startActivity(mail);
            }
        });
    }
}
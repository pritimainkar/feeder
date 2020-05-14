package ml.pritimainkar.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class sorted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorted);


        final CheckBox agreed;

        agreed = (CheckBox) findViewById(R.id.agreed);

        agreed.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (agreed.isChecked() == true) {
                                              showQR();
                                          } else {
                                              dont();
                                          }


                                      }
                                  }
        );



    }

    private void dont() {
        Toast.makeText(this, "accept terms and conditions", Toast.LENGTH_LONG).show();

    }

    private void showQR() {
        Toast.makeText(this, "accepted", Toast.LENGTH_LONG).show();
        Button qr_code;
        qr_code = (Button)findViewById(R.id.qr_code);
        qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQR();
            }
        });

    }

    private void openQR() {
        Intent intent= new Intent(this, qrCode.class);
        startActivity(intent);
    }
}


package ml.pritimainkar.afinal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class map_activity extends FragmentActivity implements GoogleMap.OnMapLoadedCallback, OnMapReadyCallback {

    Location current;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_activity);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocation();
    }

    private void fetchLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    current = location;
                    Toast.makeText(getApplicationContext(), current.getLatitude() + "" + current.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment)
                            getSupportFragmentManager().findFragmentById(R.id.google_map);
                    supportMapFragment.getMapAsync(map_activity.this);


                }
            }

        });
    }

        @Override
        public void onMapLoaded () {

        }

        @Override
        public void onMapReady (GoogleMap googleMap){
            LatLng latLng = new LatLng(current.getLatitude(), current.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                    .title("you are here");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
            googleMap.addMarker(markerOptions);


            // Markers NGO//
            Marker m1= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(18.975997, 72.813136))
                    .anchor(0.5f, 0.5f)
                    .title("Annamrita")
                    .snippet("no-022 23531530, Time- 9.30-18.30(sundayclosed) ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m2= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.105048, 72.841602))
                    .anchor(0.5f, 0.5f)
                    .title("Akshaya Patra Foundation")
                    .snippet("no-09594951155, Time- 9.30-18.30(saturday, sunday closed) ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m3= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.122328, 72.917804))
                    .anchor(0.5f, 0.5f)
                    .title("Akshaya Patra Foundation")
                    .snippet("no-09967800390, Time- 10.00-19.00 ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m4= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.184799, 72.958548))
                    .anchor(0.5f, 0.5f)
                    .title(" Shree Bhairavnath Charitable Trust")
                    .snippet("no-08652489871, Time- 24 hours) ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m5= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.228528, 72.966948))
                    .anchor(0.5f, 0.5f)
                    .title(" Akshaya Patra Foundation")
                    .snippet("no-09967800390, Time-3.30-18.30(sunday closed) ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m6= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.186952, 72.980014))
                    .anchor(0.5f, 0.5f)
                    .title("Asara Trust")
                    .snippet("no-09820176644, Time- unknown ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m7= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.008861, 73.117064))
                    .anchor(0.5f, 0.5f)
                    .title("Kamal Arnav Charitable Trust")
                    .snippet("no-09870567450, Time- unknown ")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            Marker m8= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.244885, 73.123563))
                    .anchor(0.5f, 0.5f)
                    .title("Suadha NGO")
                    .snippet("no- 02516517678, Time-unknown")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            // end of markers NGO//

            //markers orphanages
            Marker o1= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.063412, 73.007488))
                    .anchor(0.5f, 0.5f)
                    .title("Vatsalya Trust")
                    .snippet(" no-  022 25782958, Time- 11.00-17.00")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Marker o2= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.091933, 73.009918))
                    .anchor(0.5f, 0.5f)
                    .title("Desire Society ")
                    .snippet("no- 09505117777, Time- 24 hours")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Marker o3= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.094962, 73.010889))
                    .anchor(0.5f, 0.5f)
                    .title(" Jan Vikas Society  ")
                    .snippet("no- 08291505789, TIme- 24 hours")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Marker o4= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.220642, 72.961758))
                    .anchor(0.5f, 0.5f)
                    .title("Maa Niketan(girls)")
                    .snippet("no- 022 21730876, Time- 6.00-22.00")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Marker o5= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.213060, 73.107155))
                    .anchor(0.5f, 0.5f)
                    .title("Astitva (deaf) ")
                    .snippet("no- 0251 2471358")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Marker o6= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.215348, 73.101190))
                    .anchor(0.5f, 0.5f)
                    .title(" Janani Ashish Charitable Trust ")
                    .snippet("no- 02512455879, Time- 7.00-21.00")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            Marker o7= googleMap.addMarker( new MarkerOptions()
                    .position(new LatLng(19.212606, 73.174827))
                    .anchor(0.5f, 0.5f)
                    .title("Nila bal sadan ")
                    .snippet("no- 025126046764")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            //end of markers orphanages


        }


    }


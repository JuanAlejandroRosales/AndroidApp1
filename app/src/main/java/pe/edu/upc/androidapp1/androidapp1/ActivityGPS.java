package pe.edu.upc.androidapp1.androidapp1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import pe.edu.upc.androidapp1.util.GPS;

public class ActivityGPS extends Activity implements View.OnClickListener{
    LocationManager locManager;
    Location location = null;
    TextView txvlatitud, txvlong;
    Button btnObtener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygps);

        txvlatitud = (TextView)findViewById(R.id.txtViewGPS_lat);
        txvlong = (TextView)findViewById(R.id.txtViewGPS_lon);
        btnObtener = (Button)findViewById(R.id.obtenerGPS);
        btnObtener.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        //Validamos si es requerido realizar la solicitud de permisos(version 6)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            Toast.makeText(this, "This version is not Android 6 or later " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
            getLocation();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void getLocation(){
        locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                && !locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Toast.makeText(this, "Activar Gps", Toast.LENGTH_SHORT).show();
        } else {
            GPS.startListening(this);
            try {
                if (GPS.isCanGetLocation()) {
                    location = GPS.getLocation();
                    String latitud = String.valueOf(location.getLatitude());
                    String longitud = String.valueOf(location.getLongitude());
                    String proveedor = location.getProvider().toString();

                    txvlatitud.setText("latitud: " + latitud);
                    txvlong.setText("longitud: " + longitud);
                }
            } catch (Exception e) {
                Toast.makeText(this, "ERROR OBTENINENDO GPS",Toast.LENGTH_SHORT).show();
                txvlatitud.setText("latitud: ");
                txvlong.setText("longitud: ");
            }
        }
    }

    @Override
    public void onBackPressed()
    {
        GPS.stopListening();
        super.onBackPressed();  // optional depending on your needs
    }

}

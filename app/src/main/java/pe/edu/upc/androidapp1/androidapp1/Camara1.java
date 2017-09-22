package pe.edu.upc.androidapp1.androidapp1;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camara1 extends Activity implements View.OnClickListener{

    Button btnTomar, btnGrabar;
    ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara1);

        // Las referencias a los elementos con los que queremos interactuar
        imgFoto = (ImageView) this.findViewById(R.id.imgcamara1);
        btnTomar = (Button) this.findViewById(R.id.btn1camara1);
        btnGrabar = (Button) this.findViewById(R.id.btn2camara1);

        btnGrabar.setOnClickListener(this);
        btnTomar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        //Validamos si es requerido realizar la solicitud de permisos(version 6)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            Toast.makeText(this, "This version is not Android 6 or later " + Build.VERSION.SDK_INT, Toast.LENGTH_LONG).show();
        }

    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
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
}

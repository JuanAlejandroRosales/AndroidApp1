package pe.edu.upc.androidapp1.androidapp1;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

    }
}

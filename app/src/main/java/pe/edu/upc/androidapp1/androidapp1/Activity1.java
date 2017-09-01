package pe.edu.upc.androidapp1.androidapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Activity1 extends Activity implements View.OnClickListener{

    EditText txvUsuario;
    EditText txvPassword;
    Button btnIngresar;
    Button btnRecuperar;
    TextView txvValidacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        //las referencias a los elementos con los que queremos interactuar
        txvUsuario = (EditText) this.findViewById(R.id.editText1Act1);
        txvPassword = (EditText) this.findViewById(R.id.editText2Act1);
        btnIngresar = (Button) this.findViewById(R.id.btn1Act1);
        btnRecuperar = (Button) this.findViewById(R.id.btn2Act1);
        txvValidacion = (TextView) this.findViewById(R.id.textView3Act1);

        btnIngresar.setOnClickListener(this);

        btnRecuperar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent Recuperarintent = new Intent(Activity1.this, Activity3.class);
                Activity1.this.startActivity(Recuperarintent);

            }
        });
    }

    @Override
    public void onClick(View view) {

        String usuario = txvUsuario.getText().toString();
        String password = txvPassword.getText().toString();

        if (usuario.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("username", usuario);
            this.startActivity(intent);
        }
        else if (usuario.isEmpty() || password.isEmpty()){
            String message = "LOS DATOS ESTAN INCOMPLETOS";
            txvValidacion.setText(message);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();

        }

    }
}

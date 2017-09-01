package pe.edu.upc.androidapp1.androidapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity {

    TextView txvBienvenida;
    TextView txvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        //las referencias a los elementos con los que queremos interactuar
        txvBienvenida = (TextView) this.findViewById(R.id.textView2Act2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        txvUsername = (TextView) this.findViewById(R.id.textViewUsername);
        txvUsername.setText(username);
    }
}

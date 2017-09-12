package pe.edu.upc.androidapp1.androidapp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.androidapp1.controller.ControladorAsignacion;
import pe.edu.upc.androidapp1.model.Asignacion;


public class Lista1 extends Activity {

    ListView listView;
    List<Asignacion> datos = new ArrayList<Asignacion>();
    Lista1Adapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list1);
        datos = ControladorAsignacion.getdata();

        listView = (ListView) findViewById(R.id.lvlList1);
        listAdapter = new Lista1Adapter(this, R.layout.rowlayout1, datos);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "Posicion " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package pe.edu.upc.androidapp1.androidapp1;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.androidapp1.controller.ControladorContacto;
import pe.edu.upc.androidapp1.model.Contacto;

import static pe.edu.upc.androidapp1.androidapp1.R.id.textView;

public class ListaContactos extends Activity {

    ListView listView;
    List<Contacto> datos = new ArrayList<Contacto>();
    ListaContactosAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcontacts);
        datos = ControladorContacto.getdata();

        listView = (ListView) findViewById(R.id.lvlListContacts);
        listAdapter = new ListaContactosAdapter(this, R.layout.rowlayoutcontact, datos);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "Posicion " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                ObtenerDatos();


                break;
            case R.id.llamadas:

                ObtenerDatosLlamadas();


                break;
            default:
                break;
        }
    }



    public void ObtenerDatos(){

        String[] projeccion = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE };
        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";
        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor c = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                projeccion,
                selectionClause,
                null,
                sortOrder);

        textView.setText("");


        while(c.moveToNext()){
            textView.append("Identificador: " + c.getString(0) + " Nombre: " + c.getString(1) + " Número: " + c.getString(2)+  " Tipo: " + c.getString(3)+"\n");
        }
        c.close();

        /*contactsCursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,   // URI de contenido para los contactos
                projection,                        // Columnas a seleccionar
                selectionClause                    // Condición del WHERE
                selectionArgs,                     // Valores de la condición
                sortOrder);                        // ORDER BY columna [ASC|DESC]*/

    }
}

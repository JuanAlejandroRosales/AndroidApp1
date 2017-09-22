package pe.edu.upc.androidapp1.controller;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.androidapp1.model.Contacto;

import android.database.Cursor;
import android.provider.ContactsContract;


public class ControladorContacto {

    public static List getdata() {

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

        //textView.setText("");

        List datos = new ArrayList();
        while(c.moveToNext()){
            //textView.append("Identificador: " + c.getString(0) + " Nombre: " + c.getString(1) + " Número: " + c.getString(2)+  " Tipo: " + c.getString(3)+"\n");

            datos.add(new Contacto(c.getString(1), c.getString(2)));
        }
        c.close();

        return datos;

        /*contactsCursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,   // URI de contenido para los contactos
                projection,                        // Columnas a seleccionar
                selectionClause                    // Condición del WHERE
                selectionArgs,                     // Valores de la condición
                sortOrder);                        // ORDER BY columna [ASC|DESC]*/


    }


}

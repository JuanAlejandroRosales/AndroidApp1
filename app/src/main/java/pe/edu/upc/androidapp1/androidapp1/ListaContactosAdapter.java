package pe.edu.upc.androidapp1.androidapp1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import pe.edu.upc.androidapp1.model.Contacto;


public class ListaContactosAdapter extends ArrayAdapter<Contacto> {

    private Activity context;
    private int resource;
    private List<Contacto> items;

    public ListaContactosAdapter(Activity mContext, int resource, List<Contacto> items) {
        super(mContext, resource, items);
        this.context = mContext;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final Contacto item = items.get(position);
        LinearLayout rowView;

        if (convertView == null) {
            rowView = new LinearLayout(getContext());
            inflater.inflate(resource, rowView, true);
        } else {
            rowView = (LinearLayout) convertView;
        }

        TextView texto1 = (TextView) rowView.findViewById(R.id.txtName);
        TextView texto2 = (TextView) rowView.findViewById(R.id.txtPhoneNumber);

        texto1.setText(item.getNombre());
        texto2.setText(item.getTelefono());

        return rowView;
    }
}

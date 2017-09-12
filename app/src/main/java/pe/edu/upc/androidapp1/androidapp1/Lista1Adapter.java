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

import pe.edu.upc.androidapp1.model.Asignacion;


public class Lista1Adapter extends ArrayAdapter<Asignacion> {

    private Activity context;
    private int resource;
    private List<Asignacion> items;

    public Lista1Adapter(Activity mContext, int resource, List<Asignacion> items) {
        super(mContext, resource, items);
        this.context = mContext;
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final Asignacion item = items.get(position);
        LinearLayout rowView;

        if (convertView == null) {
            rowView = new LinearLayout(getContext());
            inflater.inflate(resource, rowView, true);
        } else {
            rowView = (LinearLayout) convertView;
        }

        TextView texto1 = (TextView) rowView.findViewById(R.id.txt1RowLay1);
        TextView texto2 = (TextView) rowView.findViewById(R.id.txt2RowLay1);
        TextView texto3 = (TextView) rowView.findViewById(R.id.txt3RowLay1);
        TextView texto4 = (TextView) rowView.findViewById(R.id.txt4RowLay1);

        texto1.setText(item.getAsignatario());
        texto2.setText(item.getFecha());
        texto3.setText(item.getTitulo());
        texto4.setText(item.getContenido());

        return rowView;
    }

}

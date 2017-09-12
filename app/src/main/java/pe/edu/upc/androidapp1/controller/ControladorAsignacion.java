package pe.edu.upc.androidapp1.controller;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.androidapp1.model.Asignacion;

public class ControladorAsignacion {

    public static List getdata() {
        List datos = new ArrayList();
        datos.add(new Asignacion("Cliente 1","Hoy 12:30","Rehabastecimiento","Ofrecer al cliente rehabastecer"));
        datos.add(new Asignacion("Cliente 2","Hoy 11:50","Visita","Ofrecer al cliente rehabastecer"));
        datos.add(new Asignacion("Cliente 3","Hoy 11:30","Cobranza","Ofrecer al cliente rehabastecer"));
        datos.add(new Asignacion("Cliente 4","Hoy 10:45","Visita","Ofrecer al cliente rehabastecer"));
        datos.add(new Asignacion("Cliente 5","Hoy 10:40","Rehabastecimiento","Ofrecer al cliente reha;astecer"));
        datos.add(new Asignacion("Cliente 6","Hoy 10:30","Visita","Ofrecer al cliente rehabastecer"));
        datos.add(new Asignacion("Cliente 7","Hoy 09:54","Prospeccion","Prospectar 2 nuevos productos"));
        datos.add(new Asignacion("Cliente 8","Hoy 09:20","Rehabastecimiento","Ofrecer al cliente rehabastecer"));
        datos.add(new Asignacion("Cliente 9","Hoy 08:30","Prospeccion","Prospectar al cliente"));
        return datos;
    }

}

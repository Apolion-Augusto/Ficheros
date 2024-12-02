package Actividad02.Logica;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Conjunto {
    private Set<Restaurante> conjunto;

    public Conjunto() {
        super();
        conjunto = new HashSet<Restaurante>();
    }

    public void addRestaurante(Restaurante r) {
        conjunto.add(r);
    }



    public Set<Restaurante> getConjunto() {
        return conjunto;
    }

    public List<Restaurante> listaRestaurantes() {
        // TODO Auto-generated method stub
        //System.out.println("Total restaurante :"+conjunto.size());
        //return "";

        List<Restaurante> lista=new LinkedList<Restaurante>();

        for(Restaurante r : conjunto) {
            if(r.getCp().charAt(0)=='6') {
                lista.add(r);
            }
        }
        return lista;
    }
}

package Actividad02.Logica;

import java.util.Objects;

public class Restaurante{
    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String cp;

    public Restaurante(String nombre, String direccion, String ciudad,
                       String provincia, String cp) {
        super();
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.cp = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCp() {
        return cp;
    }

    @Override
    public String toString() {
        return "Restaurante [nombre=" + nombre + ", direccion="
                + direccion + ", ciudad=" + ciudad + ", provincia="
                + provincia + ", cp=" + cp + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurante other = (Restaurante) obj;
        return nombre.compareTo(other.nombre)==0;
    }
}

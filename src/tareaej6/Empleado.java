
package tareaej6;

import objects.Fecha;



/**
 *
 * @author casa
 */
public class Empleado {

    private String nombre;
    private int grupoCotizacion;
    private Fecha fechaAlta;

    /**
     * Crea un objeto empleado
     * @param nombre String con el nombre del empleado
     * @param grupoCotizacion Integer con el grupo de cotizacion
     * @param fechaE Fecha con la fecha de alta del empleado en formato dd/mm/aaaa
     */
    public Empleado(String nombre, int grupoCotizacion, String fechaE) {
        this.nombre = nombre;
        this.grupoCotizacion = grupoCotizacion;
        this.fechaAlta = new Fecha (fechaE);
    }
    
    public Empleado(String nombre, int grupoCotizacion, Fecha fechaE) {
        this.nombre = nombre;
        this.grupoCotizacion = grupoCotizacion;
        this.fechaAlta = fechaE;
    }

    public void inputData(String nombre, short grupoCotizacion) {
        this.nombre = nombre;
        this.grupoCotizacion = grupoCotizacion;
    }

    /**
     * Introduciendo la fecha actual calcula los quinquenios que lleva el
     * empleado
     * @return Retorna el total de aquinquenios que lleva
     */
    public int quinquenios() {
        Fecha today=new Fecha();
        today.setToday();//Fecha actual
        int quinquenios;
        int lastYear = 1; //incluye el ultimo año
        if (today.getMes() > fechaAlta.getMes()) {
            lastYear--;
        } else if (today.getMes() == fechaAlta.getMes() && today.getDia() >= fechaAlta.getDia()) {
            lastYear--;
        }
        
        quinquenios = (today.getAnno() - fechaAlta.getAnno() - lastYear) / 5;
        return quinquenios;
    }

    /**
     * Fecha del alta
     *
     * @return devuelve una fecha completa del alta
     */
    public String getFecha() {
        return fechaAlta.getDia() + "/" + fechaAlta.getMes() + "/" + fechaAlta.getAnno();
    }

    public String getNombre() {
        return nombre;
    }

    public int getGrupoCotizacion() {
        return grupoCotizacion;
    }


}

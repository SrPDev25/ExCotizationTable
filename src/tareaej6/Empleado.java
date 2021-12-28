
package tareaej6;

import numbers.Fecha;

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

    public void inputData(String nombre, short grupoCotizacion) {
        this.nombre = nombre;
        this.grupoCotizacion = grupoCotizacion;
    }

    /**
     * Introduciendo la fecha actual calcula los quinquenios que lleva el
     * empleado
     *
     * @param fechaActual la fecha actual en objeto Fecha
     * @return Retorna el total de aquinquenios que lleva
     */
    public int quinquenios(Fecha fechaActual) {
        int quinquenios;
        int lastYear = 1; //incluye el ultimo año
        if (fechaActual.getMes() > fechaAlta.getMes()) {
            lastYear--;
        } else if (fechaActual.getMes() == fechaAlta.getMes() && fechaActual.getDia() <= fechaAlta.getDia()) {
            lastYear--;
        }
        quinquenios = (fechaActual.getAnno() - fechaAlta.getAnno() - lastYear) / 5;
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

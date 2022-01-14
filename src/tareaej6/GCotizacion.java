
package tareaej6;

/**
 *
 * @author casa
 */

public class GCotizacion {
    private int clave; //el numero indentificativo del grupo, no se le llama pero se mantiene para futuros cambios en la tabla
    private String categoria; // Descripcion de quien pertenece al grupo, no se usa pero se mantiene para futuros cambios en la tabla
    private double baseMinima; // base €/mes del grupo

    /**
     * Constructor con todas los campos de GCotizacion. 
     * Puede que no hiciera esta clase ya que solo se utiliza el campo baseMinima, pero por si una futura implementación
     * de la insercción de empleados se mantiene esta clase y campos
     * @param clave 
     * @param categoria
     * @param baseMinima 
     */
    public GCotizacion(int clave, String categoria, double baseMinima) {
        this.clave = clave;
        this.categoria = categoria;
        this.baseMinima = baseMinima;
    }

    
    public int getClave() {
        return clave;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getBaseMinima() {
        return baseMinima;
    }
    
    

    
}

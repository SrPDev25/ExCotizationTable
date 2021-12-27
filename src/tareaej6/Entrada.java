
package tareaej6;

import java.util.GregorianCalendar;

/**
 *
 * @author casa
 */
public class Entrada {

    
    GCotizacion gruposC[]; //Array tipo GCotizacion donde se guardan los diferentes grupos y sus propiedades
    GCotizacion eje = new GCotizacion(1, "", 2);
    Integer hola=GregorianCalendar.DAY_OF_YEAR;
    Empleado[] empleados;
    GregorianCalendar fechaE=new GregorianCalendar();
    Fecha fechaHoy=new Fecha(fechaE.get(GregorianCalendar.MONTH)+"/"+ fechaE.get(GregorianCalendar.DAY_OF_MONTH)+"/"+fechaE.get(GregorianCalendar.YEAR));

    public Entrada() {
        iniGruposCotizcion();
        datosEmpleadosDefinidos();
    }

    /**
     * Inicializa la tabla de grupos de cotizacion cargada con anterioridad en
     * el código
     */
    private void iniGruposCotizcion() {
        gruposC = new GCotizacion[]{
            new GCotizacion(1, "Ingenieros y licenciados, personal de alta dirección", 1466.40),
            new GCotizacion(2, "Ingenieros Técnicos, Peritos y ayudantes titulados", 1215.90),
            new GCotizacion(3, "Jefes Administrativos y de Taller ", 1057.80),
            new GCotizacion(4, "Ayudantes no Titulados", 1050.00),
            new GCotizacion(5, "Oficiales Administrativos", 1050.00),
            new GCotizacion(6, "Subalternos", 1050.00),
            new GCotizacion(7, "Auxiliares Administrativos", 1050.00)
        };
    }

    /**
     * Inicializa la tabla de empleados predefinida
     */
    private void datosEmpleadosDefinidos() {
        empleados = new Empleado[]{
            new Empleado("Antonio", 1, new Fecha("3/ 6/ 2000")),
            new Empleado("Roberto", 2, new Fecha(" 8/ 2019")),
            new Empleado("Ordo", 4, new Fecha("3/ 6/ 2005")),
            new Empleado("Sara", 6, new Fecha("3/ 6/ 2021")),
            new Empleado("Molly", 2, new Fecha("3/ 6/ 2005")),
            new Empleado("Zelda", 7, new Fecha("3/ 6/ 1993"))
        };
    }
    
    /**
     * Al llamar a este método se crea la tabla de aquellos que reciben cotización
     */
    public void tablaCotizados(){
        System.out.println("\t\t\t\t\tINFORME ANUAL \n"
                + "Nombre\tGrupo de cotización\tFecha de Alta\tQuinquenios\tImporte a percibir");
        for(int pos=0;pos<empleados.length;pos++){
            if(empleados[pos].quinquenios(fechaHoy)>0){
                System.out.println( empleados[pos].getNombre()+"\t\t"+empleados[pos].getGrupoCotizacion()+"\t\t"+empleados[pos].getFecha()+"\t"+empleados[pos].quinquenios(fechaHoy)+"\t\t"+ calculoCuota(empleados[pos].getGrupoCotizacion(), pos)+" €");
            }
        }
        
    }
    
    /**
     * Calculo de la cuota
     * @param grupo se inserta el grupo al que pertenece
     * @param empleado se inserta a que empleado se le hace
     * @return retorna el resultado
     */
    private double calculoCuota(int grupo, int empleado){
        // cuota= Bgrupo*0.5+NQuinquenios*100
        return gruposC[grupo-1].getBaseMinima()*0.5+empleados[empleado].quinquenios(fechaHoy)*100;
    }
}

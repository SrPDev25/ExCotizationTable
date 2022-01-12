
package tareaej6;

import numbers.Fecha;
import java.util.GregorianCalendar;
import numbers.EntradaNumeros;
import string.CharacthersString;

/**
 *
 * @author casa
 */
public class Entrada {

    
    GCotizacion gruposC[]; //Array tipo GCotizacion donde se guardan los diferentes grupos y sus propiedades
    Empleado[] empleados;
    Fecha fechaHoy=new Fecha();
    
    public Entrada() {
        fechaHoy.setToday();
        iniGruposCotizcion();
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
    public void datosEmpleadosDefinidos() {
        empleados = new Empleado[]{
            new Empleado("Antonio", 1, "3/06/2000"),
            new Empleado("Roberto", 2, "28/08/2019"),
            new Empleado("Ordo", 4, "3/06/2005"),
            new Empleado("Sara", 6, "3/06/2021"),
            new Empleado("Molly", 2, "3/06/2005"),
            new Empleado("Zelda", 7, "3/5/1993")
        };
    }
    
    /**
     * Pide introducir todos los empleados de la compañia y todos sus datos
     */
    public void datosEmpleadosInput(){
        int numEmpleados=EntradaNumeros.numIntGrater("¿Cuantos empleados hay en la empresa?: ", 1);
        String nombre, fechaAlta;
        int grupoCot;
        empleados=new Empleado[numEmpleados];
        for(int pos=0;pos<empleados.length;pos++){
            System.out.println("\nEmpleado "+(pos+1));
            nombre=CharacthersString.inputString("Introduzca le nombre del empleado: ");
            printCotizationTable();
            grupoCot=EntradaNumeros.numIntBetween("Introduzca el grupo de cotización al que pertenece: ",1,gruposC.length);
            fechaAlta=CharacthersString.inputString("Introduzca la fecha de alta en formato dd/mm/aaaa: ");
            empleados[pos]=new Empleado(nombre,grupoCot,fechaAlta);
        }
    }
    
    /**
     * Al llamar a este método se crea la tabla de aquellos que reciben cotización
     */
    public void tablaCotizados(){
        
        System.out.println("\t\t\t\t\tINFORME ANUAL \n"
                + "Nombre\tGrupo de cotización\tFecha de Alta\tQuinquenios\tImporte a percibir");
        for(int pos=0;pos<empleados.length;pos++){
            if(empleados[pos].quinquenios(fechaHoy)>0){
                System.out.println(empleados[pos].getNombre()+"\t\t"+empleados[pos].getGrupoCotizacion()+"\t\t"+empleados[pos].getFecha()+"\t"+empleados[pos].quinquenios(fechaHoy)+"\t\t"+ calculoCuota(empleados[pos].getGrupoCotizacion(), pos)+" €");
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
    
    private void printCotizationTable(){
        System.out.println("\t\tTabla de grupos de cotización");
        for(int i=0;i<gruposC.length;i++){
            System.out.println(gruposC[i].getClave()+"."+gruposC[i].getCategoria());
        }
        
    }
}

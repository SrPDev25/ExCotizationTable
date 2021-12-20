/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaej6;

/**
 *
 * @author casa
 */
public class Fecha {

    private int mes, dia, anno;
/**
 * Clase para almacenar fechas
 * @param mes
 * @param dia
 * @param anno 
 */
    public Fecha(int mes, int dia, int anno) {
        this.mes = mes;
        this.dia = dia;
        this.anno = anno;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getAnno() {
        return anno;
    }

    
}

/**
 *Clase: Cliente
 *
 *@version: 0.1
 *
 *Fecha de Creación: 16/05/2020
 *
 *Fecha de Modificación: 
 *
 *@autor: Yanvier
 *
 *Copyright: CECAR
 *
*/
package edu.cecar.modelo;

/**
 * Clase que modela el objeto Usuario
 * 
 */
public class Usuario {
    
    private String ip;
    private int posicion;

    public Usuario() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    

}

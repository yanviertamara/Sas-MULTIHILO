/*
 * Clase: Servidor
 *
 * Version: 1.0
 *
 * Fecha: 2014-10-10
 *
 * Autor: Ing. Jhon Jaime Mendez
 *
 * Copyrigth: JAsoft
 */
package edu.cecar.componentesReutilizables;

/**
 * Servidor FTP
 */
import edu.cecar.controlador.ServidorHilo;
import edu.cecar.modelo.Usuario;
import edu.cecar.vista.ServidorVista;
import java.util.ArrayList;
import java.util.List;

final public class Servidor {

    private static int i = 0;
    private static String ipServer;
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {

        ServerSocketObjeto serverSocketObjeto = new ServerSocketObjeto(7000);
        
        System.out.println("Servidor de FTP montado");
        //Se llama la GUI del servidor
        new ServidorVista().setVisible(true);
        //Se reciben n peticiones
        while (true) {
            Usuario usuario = new Usuario();
            try {

                serverSocketObjeto.esperarConexion();
                //Las conexiones para cada socket se administran sobre un hilo diferente
                i++;
                //Se obtiene la IP
                ipServer = serverSocketObjeto.getIp();

                usuario.setIp(ipServer);

                usuario.setPosicion(i);

                usuarios.add(usuario);

                ServidorHilo socketHilo = new ServidorHilo(serverSocketObjeto.getEntrada(), serverSocketObjeto.getSalida());
                socketHilo.start();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
            }
        }

    }

    public static int getI() {
        return i;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

}

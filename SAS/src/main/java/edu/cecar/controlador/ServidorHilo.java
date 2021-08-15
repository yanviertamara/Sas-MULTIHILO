/**
 *Clase: ServidorHilo
 *
 *@version: 0.1
 *
 *Fecha de Creación: 30/04/2020
 *
 *Fecha de Modificación:
 *
 *@autor: Yanvier
 *
 *Copyright: CECAR
 *
 */
package edu.cecar.controlador;

import edu.cecar.componentesReutilizables.Servidor;
import edu.cecar.modelo.Documento;
import edu.cecar.modelo.Usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que controla el hilo que atiende las conexiones de los diferentes
 * clientes FTP
 *
 */
final public class ServidorHilo extends Thread {

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private List<Usuario> usuariosC;
    private static List<Usuario> usuariosD = new ArrayList<>();
    private static int i = 0;
    private static int size = 0;

    public ServidorHilo(ObjectInputStream entrada, ObjectOutputStream salida) {

        this.entrada = entrada;
        this.salida = salida;
    }

    @Override
    public void run() {
        //Se obtiene el servidor
        usuariosC = Servidor.getUsuarios();

        int j = Servidor.getI();

        size = usuariosC.size();

        try {

            while (true) {

                ControladorDescarga controlDescarga = new ControladorDescarga();

                ControladorApachePOI controlPOI = new ControladorApachePOI();

                ControladorScrapingPdf scrapingPdf = new ControladorScrapingPdf();

                Object object = entrada.readObject();

                Documento documento = (Documento) object;

                String nombreArchivo = documento.getNombreArchivo();

                controlDescarga.descargarArchivo();

                controlPOI.setTextDoc(scrapingPdf.getTextLeft(), scrapingPdf.getTextRight(), nombreArchivo);

                File file = new File("DescargasServidor\\" + documento.getNombreArchivo());

                FileInputStream fileInputStream = new FileInputStream(file);

                byte[] bytes = new byte[(int) file.length()];

                int numerosBytesLeidos = fileInputStream.read(bytes);

                fileInputStream.close();

                documento.setBytesArchivo(bytes);

                documento.setCellsLeft(scrapingPdf.getTextLeft());

                documento.setCellsRight(scrapingPdf.getTextRight());

                salida.writeObject(documento);

            }

        } catch (Exception e) {
            i++;
            Usuario usuario = new Usuario();

            for (int k = 0; k < usuariosC.size(); k++) {
                Usuario user = usuariosC.get(k);
                String dirIp = user.getIp();
                int posicion = user.getPosicion();

                if (j == posicion) {
                    usuario.setPosicion(posicion);
                    usuario.setIp(dirIp);
                    usuariosD.add(usuario);
                    usuariosC.remove(k);
                    size = usuariosC.size();
                }
            }

        }

    }

    public static int getI() {
        return i;
    }

    public static int getSize() {
        return size;
    }

    public static List<Usuario> getUsuariosD() {
        return usuariosD;
    }

}

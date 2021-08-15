/**
 *Clase: ServidorVista
 *
 *@version: 0.1
 *
 *Fecha de Creación: 11/05/2020
 *
 *Fecha de Modificación:
 *
 *@autor: Yanvier
 *
 *Copyright: CECAR
 *
 */
package edu.cecar.vista;

import edu.cecar.componentesReutilizables.Servidor;
import edu.cecar.controlador.ServidorHilo;
import edu.cecar.modelo.Usuario;

import java.awt.event.ActionEvent;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.Timer;

/**
 * Clase que controla el hilo de la vista del servidor
 *
 */
public class ServidorVista extends javax.swing.JFrame {

    public Timer tiempo;

    /**
     * Creates new form ServidorVista
     */
    public ServidorVista() {
        initComponents();

        tiempo = new Timer(3000, null);
        tiempo.start();

        tiempo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Lista que contine Usuarios Conectados
                List<Usuario> usersC = Servidor.getUsuarios();
                //Lista que contiene Usuarios Desconectados
                List<Usuario> usersD = ServidorHilo.getUsuariosD();

                String conectados = String.valueOf(ServidorHilo.getSize());
                
                String desconectados = String.valueOf(ServidorHilo.getI());
                
                String total = String.valueOf(ServidorHilo.getSize() + ServidorHilo.getI());
                
                try {
                    jtfClientesC.setText(conectados);
                    jtfClientesD.setText(desconectados);
                    jtfClientesCD.setText(total);
                    
                    //Llenar Lista de IP Conectados
                    DefaultListModel modelo = new DefaultListModel();
                    jlIpConected.setModel(modelo);

                    for (Usuario usuario : usersC) {
                        int pos = usuario.getPosicion();
                        String ip = usuario.getIp();
                        modelo.addElement("Cliente N°" + pos + " " + ip);

                    }
                    //Llenar Lista de IP Desconectados
                    DefaultListModel modelo1 = new DefaultListModel();
                    jlIpDisconected.setModel(modelo1);

                    for (Usuario usuario : usersD) {
                        int pos = usuario.getPosicion();
                        String ip = usuario.getIp();
                        modelo1.addElement("Cliente N°" + pos + " " + ip);

                    }

                } catch (Exception e) {

                }
            }
        });

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfClientesC = new javax.swing.JTextField();
        jtfClientesD = new javax.swing.JTextField();
        jtfClientesCD = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlIpConected = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlIpDisconected = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor FTP Monitor");

        jtfClientesC.setText("0");
        jtfClientesC.setEnabled(false);

        jtfClientesD.setText("0");
        jtfClientesD.setEnabled(false);

        jtfClientesCD.setText("0");
        jtfClientesCD.setEnabled(false);

        jScrollPane1.setViewportView(jlIpConected);

        jLabel1.setText("Clientes Conectados");

        jLabel2.setText("Clientes desconectados");

        jLabel3.setText("Clientes conectados + desconectados");

        jLabel4.setText("Ip Conectadas");

        jScrollPane2.setViewportView(jlIpDisconected);

        jLabel5.setText("Ip Desconectadas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jtfClientesD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfClientesCD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jtfClientesC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel5)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfClientesC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfClientesD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(jtfClientesCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlIpConected;
    private javax.swing.JList<String> jlIpDisconected;
    private javax.swing.JTextField jtfClientesC;
    private javax.swing.JTextField jtfClientesCD;
    private javax.swing.JTextField jtfClientesD;
    // End of variables declaration//GEN-END:variables

}

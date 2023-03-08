/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mio.server.views;

import com.mio.server.compiler.parser.JsonParserHandle;
import com.mio.server.models.World;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
 *
 * @author mio
 */
public class ServerView extends javax.swing.JFrame {

    /**
     * Creates new form serverView
     */
    public ServerView() {
        initComponents();
        this.setLocationRelativeTo(null);
        initSocket();
    }

    public void initSocket(){
        Executors.newFixedThreadPool(1).execute(() -> {
            ServerSocket server;
            Socket socket;
            DataInputStream scanner;
            DataOutputStream printWriter;

            try {
                server = new ServerSocket(50000);
                System.out.println("Servidor iniciado");
                infoLabel.setText("Servidor esperando...");

                while(true){
                    socket = server.accept();
                    printWriter = new DataOutputStream(socket.getOutputStream());
                    scanner = new DataInputStream(socket.getInputStream());

                    String texto = scanner.readUTF();
                    System.out.println(texto);
                    infoLabel.setText("Petición recibida desde: "+socket.getInetAddress().getHostAddress());

                    jsonArea.setText("Información recibida del cliente:\n"+texto);

                    JsonParserHandle jsonParserHandle = new JsonParserHandle();
                    World world = jsonParserHandle.compile(texto);

                    System.out.println(world);

                    printWriter.writeUTF("Mensaje de regreso del servidor");

                    socket.close();

//                    infoLabel.setText("Servidor esperando...");
//                    jsonArea.setText("");

                    System.out.println("Socket desconectado del servidor");

                }
            } catch (Exception e) {
                System.err.println("Something  went wrong.");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jsonArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        xmlArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        infoLabel.setText("Esperando...");

        jsonArea.setColumns(20);
        jsonArea.setRows(5);
        jsonArea.setEnabled(false);
        jScrollPane1.setViewportView(jsonArea);

        xmlArea.setColumns(20);
        xmlArea.setRows(5);
        xmlArea.setEnabled(false);
        jScrollPane2.setViewportView(xmlArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(infoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel infoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jsonArea;
    private javax.swing.JTextArea xmlArea;
    // End of variables declaration//GEN-END:variables
}

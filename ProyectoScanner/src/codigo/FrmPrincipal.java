package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("Compilador: Analizador Léxico y Sintáctico");
    }
    
    private void analizarLexico() throws IOException{
        AnalizadorLexico analizadorLex = new AnalizadorLexico();
        String resultado = analizadorLex.analizarLexico(txtEntrada.getText());
        String errores = analizadorLex.getStringErrores();
        txtResultado.setEnabled(rootPaneCheckingEnabled);
        txtErrores.setEnabled(rootPaneCheckingEnabled);
        txtResultado.setText(resultado);
        txtErrores.setText(errores);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ScannerTitle = new javax.swing.JLabel();
        cargarCodeBoton = new javax.swing.JButton();
        btnAnalizarSintactico = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textResultadoParseo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("scannerIcon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        ScannerTitle.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        ScannerTitle.setText("Compilador");

        cargarCodeBoton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        cargarCodeBoton.setText("Cargar .txt");
        cargarCodeBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCodeBotonActionPerformed(evt);
            }
        });

        btnAnalizarSintactico.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAnalizarSintactico.setText("Correr código");
        btnAnalizarSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSintacticoActionPerformed(evt);
            }
        });

        btnAnalizar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAnalizar.setText("Escanear tokens");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cargarCodeBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizarSintactico)
                .addGap(10, 10, 10)
                .addComponent(btnAnalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScannerTitle)
                .addGap(406, 406, 406))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ScannerTitle)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar)
                    .addComponent(cargarCodeBoton)
                    .addComponent(btnAnalizarSintactico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setText("Errores de tokens");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("Código");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textResultadoParseo.setEditable(false);
        textResultadoParseo.setColumns(20);
        textResultadoParseo.setRows(5);
        textResultadoParseo.setEnabled(false);
        jScrollPane4.setViewportView(textResultadoParseo);

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setText("Resultado parser");

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setEnabled(false);
        jScrollPane2.setViewportView(txtResultado);

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane3.setViewportView(txtEntrada);

        txtErrores.setColumns(20);
        txtErrores.setRows(5);
        txtErrores.setEnabled(false);
        jScrollPane1.setViewportView(txtErrores);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Tokens");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void cargarCodeBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCodeBotonActionPerformed
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File archivoLeido = new File(chooser.getSelectedFile().getAbsolutePath());
        
            String ST = new String(Files.readAllBytes(archivoLeido.toPath()));
            txtEntrada.setText(ST);
        } catch(NullPointerException e) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cargarCodeBotonActionPerformed

    private void btnAnalizarSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSintacticoActionPerformed
        
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String ST = txtEntrada.getText();
        
        //Esto que sigue se podrá usar una vez que hayamos terminado el LexerCup
        
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        textResultadoParseo.setEnabled(true);
        
        try {
            s.parse();            
            
            textResultadoParseo.setText("Análisis completado correctamente");
            textResultadoParseo.setForeground(new Color(25, 111, 61));
            
            ArrayList<Symbol> listE = s.errores;
            if(s.fatalError){
                textResultadoParseo.setText("Error FATAL capturado. Línea: " + (s.fatalErrorSym.right + 1) + " Columna: "+ (s.fatalErrorSym.left + 1));
                textResultadoParseo.setForeground(Color.red);
                s.fatalError = false;
                s.errores.clear();
            }
            else if(listE.size() > 0){
                String mensaje = "";            
                for(int i = 0;i < listE.size(); i++){                
                    mensaje += "Error de sintaxis. Línea: " + (listE.get(i).right + 1) + " Columna: "+ (listE.get(i).left + 1) + " Texto: \"" + listE.get(i).value + "\"" + "\n";
                }
                s.errores.clear();
                textResultadoParseo.setText(mensaje);
                textResultadoParseo.setForeground(Color.red);
            }
            
        } catch (Exception ex){
            System.err.println(ex);        
        }
        
    }//GEN-LAST:event_btnAnalizarSintacticoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ScannerTitle;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizarSintactico;
    private javax.swing.JButton cargarCodeBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea textResultadoParseo;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtErrores;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}

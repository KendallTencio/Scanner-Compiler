package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.parser;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class FrmPrincipal extends javax.swing.JFrame {

    static TablaSimbolos tabla = new TablaSimbolos();
    
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Compiler: Scanner and Parser");

        //JTextPane textPane = new JTextPane();
        txtEntrada.setEnabled(true);
        TextLineNumber tln = new TextLineNumber(txtEntrada);
        jScrollPane5.setRowHeaderView( tln );

        //TextLineNumber tln = new TextLineNumber(txtEntrada);
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
    
    private void analizarCupListaSimbolos(){
        String ST = txtEntrada.getText();
      
        InputStream inputStream = new ByteArrayInputStream(ST.getBytes(Charset.forName("UTF-8")));
                
        parser parserObj = new parser();
        LexerCup miAnalizadorLexico = new LexerCup(new InputStreamReader(inputStream), tabla);
        
        //Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        Sintax s = new Sintax(miAnalizadorLexico);
        
        parserObj.setScanner(miAnalizadorLexico);
        try{
            s.parse();

        }catch(Exception x){
            x.printStackTrace();
            System.out.println("Error fatal.\n");
        }
    }
    
    public void cargarArchivoASM(){
        String currentDirectory = System.getProperty("user.dir");
        try{
            File archivoLeido = new File(currentDirectory+"/src/codigo/codigo.asm");
        
            String ST = new String(Files.readAllBytes(archivoLeido.toPath()));
            asmTextArea.setEnabled(true);
            asmTextArea.setText(ST);
        } catch(NullPointerException e) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ScannerTitle = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        semanticErrorsText = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        symbolTableText = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        asmTextArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("scannerIcon2.png")).getImage());
        setPreferredSize(new java.awt.Dimension(1340, 710));
        setResizable(false);
        setSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        cargarCodeBoton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        cargarCodeBoton.setText("Load txt file");
        cargarCodeBoton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, new java.awt.Color(0, 0, 0), java.awt.Color.black));
        cargarCodeBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCodeBotonActionPerformed(evt);
            }
        });

        btnAnalizarSintactico.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAnalizarSintactico.setText("Run");
        btnAnalizarSintactico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, new java.awt.Color(0, 0, 0), java.awt.Color.black));
        btnAnalizarSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSintacticoActionPerformed(evt);
            }
        });

        btnAnalizar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnAnalizar.setText("Scan tokens");
        btnAnalizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray, new java.awt.Color(0, 0, 0), java.awt.Color.black));
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
                .addComponent(cargarCodeBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizarSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1052, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargarCodeBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalizarSintactico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setText("Errors (Tokens)");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("Code");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        textResultadoParseo.setEditable(false);
        textResultadoParseo.setColumns(20);
        textResultadoParseo.setRows(5);
        textResultadoParseo.setEnabled(false);
        jScrollPane4.setViewportView(textResultadoParseo);

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel4.setText("Output");
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setEnabled(false);
        jScrollPane2.setViewportView(txtResultado);

        txtErrores.setEditable(false);
        txtErrores.setColumns(20);
        txtErrores.setRows(5);
        txtErrores.setEnabled(false);
        jScrollPane1.setViewportView(txtErrores);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("Tokens");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jLabel5.setText("Versión 3.0");

        ScannerTitle.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        ScannerTitle.setText("COMPILER");

        jScrollPane5.setViewportView(txtEntrada);

        semanticErrorsText.setEditable(false);
        semanticErrorsText.setColumns(20);
        semanticErrorsText.setRows(5);
        semanticErrorsText.setEnabled(false);
        jScrollPane3.setViewportView(semanticErrorsText);

        symbolTableText.setEditable(false);
        symbolTableText.setColumns(20);
        symbolTableText.setRows(5);
        symbolTableText.setEnabled(false);
        jScrollPane6.setViewportView(symbolTableText);

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel6.setText("Symbol Table");
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel7.setText("Semantic errors");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        asmTextArea.setEditable(false);
        asmTextArea.setColumns(20);
        asmTextArea.setRows(5);
        asmTextArea.setEnabled(false);
        jScrollPane7.setViewportView(asmTextArea);

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel8.setText("ASM Code");
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane3))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ScannerTitle)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6)
                                    .addComponent(jScrollPane3)))
                            .addComponent(jScrollPane7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(ScannerTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 57, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
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
        
        // analizarCupListaSimbolos(); Esta era la función que llamaba para hacer análisis semántico
        // tabla.imprimir();
        
           //A este punto la tabla de símbolos está lista
        

        String ST = txtEntrada.getText();
       
        
        InputStream inputStream = new ByteArrayInputStream(ST.getBytes(Charset.forName("UTF-8")));
                
        parser parserObj = new parser();
        LexerCup miAnalizadorLexico = new LexerCup(new InputStreamReader(inputStream), tabla);
        
        //Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        Sintax s = new Sintax(miAnalizadorLexico);
        
        
        textResultadoParseo.setEnabled(true);
        
        try {
            s.parse();            
            
            textResultadoParseo.setText("Análisis completado correctamente");
            textResultadoParseo.setForeground(new Color(25, 111, 61));
            
            ArrayList<Symbol> listE = s.errores;
            ArrayList<String> listEspec = s.erroresEspec;
            String mensaje = "";  
            
            if(s.fatalError){
                textResultadoParseo.setText("Error FATAL capturado. Línea: " + (s.fatalErrorSym.right + 1));
                textResultadoParseo.setForeground(Color.red);
                s.fatalError = false;
                s.errores.clear();
                s.erroresEspec.clear();
            }
            else if(s.erroresEspec.size() > 0 || listE.size() > 0){
                s.specError = false;
                
                for(int i = 0;i < listEspec.size(); i++){                
                    mensaje += listEspec.get(i)+"\n";
                    System.out.println(listEspec.get(i));
                }
                
                for(int i = 0;i < listE.size(); i++){                
                    mensaje += "Error de sintaxis. Línea: " + (listE.get(i).right + 1) + " Capturado en: \"" + listE.get(i).value + "\"" + "\n";
                }
                s.errores.clear();
                s.erroresEspec.clear();
                textResultadoParseo.setText(mensaje);
                textResultadoParseo.setForeground(Color.red);
            }
            symbolTableText.setEnabled(true);
            symbolTableText.setText(tabla.generarString());
            
            
            

            String erroresSemanticos;
            erroresSemanticos = tabla.getErroresDeLex();
            semanticErrorsText.setEnabled(true);
            
            asmTextArea.setEnabled(false);
            asmTextArea.setText("");
            
            if(!erroresSemanticos.equals("")){
                semanticErrorsText.setText(erroresSemanticos);
                semanticErrorsText.setForeground(Color.red);
            }else{
                semanticErrorsText.setText("Análisis semántico completado correctamente");
                semanticErrorsText.setForeground(new Color(25, 111, 61));
                cargarArchivoASM();
            }
               
        
        } catch (Exception ex){
            System.err.println(ex);        
        }
        //Limpiar la tabla de símbolos
        tabla.limpiarTablaSimbolos();
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
    private javax.swing.JTextArea asmTextArea;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizarSintactico;
    private javax.swing.JButton cargarCodeBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea semanticErrorsText;
    private javax.swing.JTextArea symbolTableText;
    private javax.swing.JTextArea textResultadoParseo;
    private javax.swing.JTextPane txtEntrada;
    private javax.swing.JTextArea txtErrores;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}

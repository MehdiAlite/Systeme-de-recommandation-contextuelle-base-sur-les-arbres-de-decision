/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class princ extends javax.swing.JFrame {

  String Sex,Profession;
    public princ() {
        initComponents();
        InscrIdUser.setEnabled(false);
        
        BufferedReader br;
        String cpt = null;
        String FichierEntre="Data/Proffession.txt";
      
        try {
            br = new BufferedReader(new FileReader(FichierEntre));
            String line;
            try {
                while((line=br.readLine())!=null){
                InscripProffession.addItem(line);
                }
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Fichier "+FichierEntre+" Introuvable.");
        }
        
         InscrIdUser.setText(String.valueOf(calculerId()));
              
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        InscrIdUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        InscrpAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        InscripSex = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        InscripProffession = new javax.swing.JComboBox();
        Inscription = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ConexIdUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ConexAge = new javax.swing.JTextField();
        Connexion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Système de Recommandation");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inscription", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Adobe Devanagari", 3, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel3.setText("Id User ");

        jLabel4.setText("Age");

        jLabel5.setText("Sex");

        InscripSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));

        jLabel6.setText("Proffession");

        Inscription.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        Inscription.setText("Inscription");
        Inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InscrpAge)
                    .addComponent(InscrIdUser)
                    .addComponent(InscripSex, 0, 87, Short.MAX_VALUE)
                    .addComponent(InscripProffession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Inscription)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(InscrIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(InscrpAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(InscripSex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(InscripProffession, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(Inscription)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connexion", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Adobe Devanagari", 3, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setText("Id User");

        jLabel2.setText("Age ");

        Connexion.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        Connexion.setText("Connexion");
        Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnexionActionPerformed(evt);
            }
        });
        Connexion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ConnexionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(ConexIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ConexAge, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(Connexion)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConexIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConexAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Connexion))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnexionActionPerformed
String FichierEntre="Data/AllUser.txt";
boolean tr=false;
        if(ConexIdUser.getText().isEmpty()==false)
        try 
        {
            Integer.parseInt(ConexIdUser.getText());
            if(ConexAge.getText().isEmpty()==false) {
                try{
                BufferedReader br = new BufferedReader(new FileReader(FichierEntre));
                 String line;
                 try{
                     
                 while((line=br.readLine())!=null){
                 String[] values=line.split("\\|",-1);
                 if(ConexIdUser.getText().equalsIgnoreCase(values[0]) && ConexAge.getText().equalsIgnoreCase(values[1])) {tr=true;Sex=values[2];Profession=values[3];}
                   }br.close();
                 
                 if(tr) {F2 f2=new F2(this,false,this.ConexIdUser.getText(),this.ConexAge.getText(),this.Sex,this.Profession);f2.setVisible(true);}
                 else JOptionPane.showMessageDialog(null, "IdUser ou Age incorrect");
                 }catch(IOException ex) {JOptionPane.showMessageDialog(null, ex.getMessage());}
                } catch (FileNotFoundException ex){  JOptionPane.showMessageDialog(null, "Fichier "+FichierEntre+" Introuvable."); }
            }
        else JOptionPane.showMessageDialog(null, "Ecrire Age");
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Ecrire un Id Valide");
          
        } 
else JOptionPane.showMessageDialog(null, "Ecrire IdUser");
    }//GEN-LAST:event_ConnexionActionPerformed

    private void InscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscriptionActionPerformed
if(InscrIdUser.getText().isEmpty()==false)
    try{
         Integer.parseInt(InscrIdUser.getText());
        if(InscrpAge.getText().isEmpty()==false){
            try{   
            FileWriter fw=new FileWriter(new File("Data/AllUser.txt"),true);
            fw.write(InscrIdUser.getText()+"|"+InscrpAge.getText()+"|"+InscripSex.getSelectedItem().toString()+"|"+InscripProffession.getSelectedItem().toString()+"\n");
            fw.close();
            JOptionPane.showMessageDialog(null, "Inscription Valide");
            InscrIdUser.setText(String.valueOf(calculerId()));
            InscrpAge.setText(null);
            }catch (IOException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            } else JOptionPane.showMessageDialog(null, "Ecrire Age"); 
    }   catch(Exception e){
        JOptionPane.showMessageDialog(null, "Ecrire un Id Valide");
    }else JOptionPane.showMessageDialog(null, "Ecrire IdUser");
    
    }//GEN-LAST:event_InscriptionActionPerformed

    private void ConnexionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConnexionKeyPressed

    }//GEN-LAST:event_ConnexionKeyPressed

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
            java.util.logging.Logger.getLogger(princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new princ().setVisible(true);
               
            }
        });
    }
    
    int calculerId(){
        String FichierEntre2="Data/AllUser.txt";
        BufferedReader br;
        String cpt = null;
        int cptt=0;
         try {
            br = new BufferedReader(new FileReader(FichierEntre2));
            String line;
            try {
                while((line=br.readLine())!=null){
                String [] values=line.split("\\|",-1);
                cpt=values[0];
                }
                cptt=Integer.parseInt(cpt)+1;
                
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Fichier "+FichierEntre2+" Introuvable.");
        }
        return cptt;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ConexAge;
    public javax.swing.JTextField ConexIdUser;
    public javax.swing.JToggleButton Connexion;
    private javax.swing.JTextField InscrIdUser;
    private javax.swing.JComboBox InscripProffession;
    private javax.swing.JComboBox InscripSex;
    private javax.swing.JToggleButton Inscription;
    private javax.swing.JTextField InscrpAge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}

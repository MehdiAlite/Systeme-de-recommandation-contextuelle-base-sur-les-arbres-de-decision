/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.AlgoID3;
import ca.pfv.spmf.algorithms.classifiers.decisiontree.id3.DecisionTree;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import mamémoirers.CalculeSimil;
import mamémoirers.ConvertAndModifData;
import mamémoirers.DecisionTreeForOneUser;
import mamémoirers.Filme;
import mamémoirers.LongToDateAndClass;
import mamémoirers.QuelleGenreDeFilme;
import mamémoirers.RecherchUserInfo;
import mamémoirers.RechercheFilms;

/**
 *
 * @author Acer
 */
public class F2 extends javax.swing.JDialog {

   princ Parent;
   DecisionTree TreeProfil,TreeHistorique;
   DefaultTableModel InfoTableRecommandation;
   LinkedList<String> l=new LinkedList<String>();
   LinkedList<String> Toutgenre=new LinkedList<>();
    
    public F2(princ parent, boolean modal, String Id,String Age,String Sex,String Profession) throws IOException {
        super(parent, modal);
        initComponents();
        this.Parent=parent;
       // Genre.addItem("Tout");
        
        parent.Connexion.setEnabled(false);
        this.Id.setText(Id);
        this.Age.setText(Age);
        this.Sex.setText(Sex);
        this.Profession.setText(Profession);
        
       BufferedReader br,br2,br3;
       String FichierEntre="Data/ToutGenre.txt";
       String FichierEntre2="Data/u.data";
       String FichierEntre3="Data/Filme.txt";
       
       
       //Pour Connaitre tout les genres
       try {
            br = new BufferedReader(new FileReader(FichierEntre));
            String line;
            try {
                while((line=br.readLine())!=null){
                Genre.addItem(line);
                Toutgenre.addLast(line);
                }
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Fichier "+FichierEntre+" Introuvable.");
        }
        
        // Pour connaitre tout les filmes déja vu par cette utilisateur
       
        try {
            br2 = new BufferedReader(new FileReader(FichierEntre2));
            String line;
            try {
                while((line=br2.readLine())!=null){
               String [] values=line.split("\\t",-1);
               if(values[0].equalsIgnoreCase(this.Id.getText())) l.addLast(values[1]);
                       }
                br2.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Fichier "+FichierEntre2+" Introuvable.");
        }
        
        //Afficher tout les films déja vu
        if(l.isEmpty()==false)
        {
            RechercheFilms RchF=new RechercheFilms();
           LinkedList<Filme> Fil=new LinkedList<Filme>();
        for(int i=0;i<l.size();i++){
           // System.out.println(l.get(i));
           Fil.addLast(new RechercheFilms().RechercheParId(String.valueOf(l.get(i))));
        }    
             DefaultTableModel tablen=new DefaultTableModel();
      tablen.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu"});
              
              for(int i=0;i<Fil.size();i++) {
                        tablen.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note});
              }
        trieTable(tablen);
            FilmeDéjaVu.setModel(tablen);
        
        }
        
         
            
              
        
        }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Id = new javax.swing.JLabel();
        Age = new javax.swing.JLabel();
        Profession = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Sex = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        FilmeDéjaVu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Genre = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        FilmsMieuxNoté = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Historique = new javax.swing.JRadioButton();
        Profil = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Recommandation = new javax.swing.JTable();
        Jour = new javax.swing.JComboBox();
        TypJr = new javax.swing.JComboBox();
        Saison = new javax.swing.JComboBox();
        Temp = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Button1Recommandation = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        DecisionTree = new javax.swing.JMenu();
        SimilUser = new javax.swing.JMenu();
        SimilaItem = new javax.swing.JMenu();
        InfoREcommandation = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recommandations");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setText("Id : ");

        jLabel2.setText("Age : ");

        jLabel3.setText("Profession : ");

        jLabel4.setText("Films déja vu : ");

        Id.setText("..........");

        Age.setText(".........");

        Profession.setText("..........");

        jLabel6.setText("Sex : ");

        Sex.setText(".........");

        FilmeDéjaVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        FilmeDéjaVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilmeDéjaVuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(FilmeDéjaVu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Sex)
                                    .addComponent(Profession)
                                    .addComponent(Age)
                                    .addComponent(Id))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Id))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Age))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Sex))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Profession))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(609, 609, 609))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Films Mieux Noté", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        Genre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                GenreItemStateChanged(evt);
            }
        });

        jLabel5.setText("Catégorie : ");

        FilmsMieuxNoté.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        FilmsMieuxNoté.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilmsMieuxNotéMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(FilmsMieuxNoté);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Genre, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recommandations", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 18), java.awt.Color.black)); // NOI18N

        jLabel7.setText("Recommandation par : ");

        buttonGroup1.add(Historique);
        Historique.setText("Historique");
        Historique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoriqueActionPerformed(evt);
            }
        });

        buttonGroup1.add(Profil);
        Profil.setSelected(true);
        Profil.setText("Profil");
        Profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfilActionPerformed(evt);
            }
        });

        Recommandation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Recommandation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecommandationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Recommandation);

        Jour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "samedi", "dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi" }));

        TypJr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Vacance" }));

        Saison.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hiver", "Printemp", "Automne" }));

        Temp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matin", "ApréMidi", "Nuit", "Soir" }));

        jLabel8.setText("Season : ");

        jLabel9.setText("Jour : ");

        jLabel10.setText("TypeJour :");

        jLabel11.setText("Temp : ");

        Button1Recommandation.setText("Recommandation");
        Button1Recommandation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1RecommandationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(Profil)
                                .addGap(25, 25, 25)
                                .addComponent(Historique)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(TypJr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(Saison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(Temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button1Recommandation)
                .addGap(299, 299, 299))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Historique)
                            .addComponent(Profil))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypJr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Saison, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(Button1Recommandation)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DecisionTree.setText("Decision Tree");
        DecisionTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DecisionTreeMouseClicked(evt);
            }
        });
        jMenuBar1.add(DecisionTree);

        SimilUser.setText("Simil User-User");
        SimilUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SimilUserMouseClicked(evt);
            }
        });
        jMenuBar1.add(SimilUser);

        SimilaItem.setText("Simil Item-Item");
        SimilaItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SimilaItemMouseClicked(evt);
            }
        });
        jMenuBar1.add(SimilaItem);

        InfoREcommandation.setText("Evaluation Systéme");
        InfoREcommandation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfoREcommandationMouseClicked(evt);
            }
        });
        jMenuBar1.add(InfoREcommandation);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
Parent.Connexion.setEnabled(true);
Parent.ConexIdUser.setText("");
Parent.ConexAge.setText("");
    }//GEN-LAST:event_formWindowClosing

    private void GenreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_GenreItemStateChanged

        if(evt.getStateChange()==ItemEvent.SELECTED) {
        if(Genre.getSelectedItem().toString().equalsIgnoreCase("Tout")){
         
      }
      else {
            
          LinkedList<Filme> l=new LinkedList<Filme>();
           DefaultTableModel tablen=new DefaultTableModel();
      tablen.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu"});
  
            try {
                l=new QuelleGenreDeFilme().RecherchParGenre(Genre.getSelectedItem().toString().split("\\|"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            }
          for(int i=0;i<l.size();i++)     
            tablen.addRow(new Object[] 
                     {l.get(i).Id,l.get(i).Nom,l.get(i).Date,l.get(i).Note});
         trieTable(tablen);
            FilmsMieuxNoté.setModel(tablen);
           
         
      }
        }
    }//GEN-LAST:event_GenreItemStateChanged

    private void DecisionTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DecisionTreeMouseClicked
        try {
          //  JOptionPane.showMessageDialog(null, new CalculeSimil().UserSimil(Id.getText()));  
            LinkedList<String> l=new LinkedList<>();
       l=new RechercheFilms().ListDesFilmesLesMieuxNotéDunUser(new CalculeSimil().UserSimil(Id.getText()));
            
            for(int i=0;i<l.size();i++) {
                System.out.println(l.get(i));
            }
            /*AffichageDecisionTree f=new AffichageDecisionTree(this, true,TreeProfil);
                        f.setLocation(100, 200);
                        f.setVisible(true);*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
   
    }//GEN-LAST:event_DecisionTreeMouseClicked

    private void ProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfilActionPerformed
JOptionPane.showMessageDialog(null, "Recommandation Coté Profile");


        //Le Temp de la machine
                    java.util.Date res =new java.util.Date();
                   DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
                   String [] tabDate= fullDateFormat.format(res).toString().split(" ");
                    LongToDateAndClass lg=new LongToDateAndClass();
                    lg.classificationUtilisantUneDate(tabDate);
                    
        //JOptionPane.showMessageDialog(null, "2");
 
        
        LinkedList<String> FilmeId=new LinkedList<String>();
                  LinkedList<String> FilmeGenrePredict=new LinkedList<String>();
                  String prediction =null;
                  
    
           // ********************************Recommandation des filmes a partir du profil**********************************************//
                  for(int i=0;i<Toutgenre.size();i++){
                 String [] instance2={new RecherchUserInfo().IntervalAge(Age.getText()),Sex.getText(),Profession.getText(),Toutgenre.get(i),null,lg.Jour,lg.TypeJr,lg.Saison,lg.TempHeur};
                 System.out.println(new RecherchUserInfo().IntervalAge(Age.getText())+" "+Sex.getText()+" "+Profession.getText()+" "+Toutgenre.get(i)+" "+null+" "+lg.Jour+" "+lg.TypeJr+" "+lg.Saison+" "+lg.TempHeur);
                 prediction=TreeProfil.predictTargetAttributeValue(instance2);
                 System.out.println(prediction);
                      try {
                         if(prediction.equalsIgnoreCase("Yes")){
                             System.out.println(Toutgenre.get(i)+" : "+"Yes");
                             FilmeGenrePredict.addLast(Toutgenre.get(i));
                         
                         }
                         // System.out.println("\n The class that is predicted is: " +prediction);
                      } catch (Exception e) {
                          
                      }
                  }
                  
          // mettre les filmes dans une tables a partir des genres et les triées .
                  
                  LinkedList<Filme> fil=new LinkedList<Filme>();
          
      
      for(int i=0;i<FilmeGenrePredict.size();i++){
           DefaultTableModel table=new DefaultTableModel();
           table.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu"});
      
        try {
                fil=new QuelleGenreDeFilme().RecherchParGenre(FilmeGenrePredict.get(i).split("\\|"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          for(int j=0;j<fil.size();j++)     
            table.addRow(new Object[] 
                     {fil.get(j).Id,fil.get(j).Nom,fil.get(j).Date,fil.get(j).Note});
         trieTable(table);
         
         if(table.getRowCount()<=2) FilmeId.addLast(table.getValueAt(0,0).toString());
         else {FilmeId.addLast(table.getValueAt(0, 0).toString());FilmeId.addLast(table.getValueAt(1, 0).toString());FilmeId.addLast(table.getValueAt(2, 0).toString());};
        
      
      }
                  
                  
                  //Supprime tout les filmes déja vu Par cette utilisateur
              for(int i=0;i<FilmeId.size();i++) 
                  for(int j=0;j<l.size();j++)
                      if(Integer.parseInt(FilmeId.get(i))==Integer.parseInt(l.get(j))){FilmeId.remove(i);}
              
             // for(int i=0;i<FilmeId.size();i++)System.out.println(FilmeId.get(i));
        
              // Tout les filmes dans une listes et les triées     
              
             LinkedList<Filme> Fil=new LinkedList<Filme>();
              for(int i=0;i<FilmeId.size();i++) Fil.addLast(new RechercheFilms().RechercheParId(FilmeId.get(i)));
               InfoTableRecommandation =new DefaultTableModel();
               InfoTableRecommandation.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu","Jour","TypeJr","Season","Temp"});
           
               DefaultTableModel tablen=new DefaultTableModel();
              tablen.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Mieux Noté"});
              
              for(int i=0;i<Fil.size();i++) {
                        tablen.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note});
                         InfoTableRecommandation.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note,lg.Jour,lg.TypeJr,lg.Saison,lg.Saison,lg.TempHeur});
              }
        trieTable(tablen);
            Recommandation.setModel(tablen);
            
    }//GEN-LAST:event_ProfilActionPerformed

    private void HistoriqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoriqueActionPerformed
JOptionPane.showMessageDialog(null, "Recommandation Coté Historique");
        java.util.Date res =new java.util.Date();
                   DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
                   String [] tabDate= fullDateFormat.format(res).toString().split(" ");
                    LongToDateAndClass lg=new LongToDateAndClass();
                    lg.classificationUtilisantUneDate(tabDate);
  LinkedList<String> FilmeId=new LinkedList<String>();
                  LinkedList<String> FilmeGenrePredict=new LinkedList<String>();
                  String prediction =null;
                  
    
           // ********************************Recommandation des filmes a partir du profil**********************************************//
                  for(int i=0;i<Toutgenre.size();i++){
                 String [] instance2={Id.getText(),Toutgenre.get(i),null,lg.Jour,lg.TypeJr,lg.Saison,lg.TempHeur};
                 System.out.println(Id.getText()+" "+Toutgenre.get(i)+" "+null+" "+lg.Jour+" "+lg.TypeJr+" "+lg.Saison+" "+lg.TempHeur);
                 prediction=TreeHistorique.predictTargetAttributeValue(instance2);
                 System.out.println(prediction);
                      try {
                         if(prediction.equalsIgnoreCase("Yes")){
                             System.out.println(Toutgenre.get(i)+" : "+"Yes");
                             FilmeGenrePredict.addLast(Toutgenre.get(i));
                         
                         }
                         // System.out.println("\n The class that is predicted is: " +prediction);
                      } catch (Exception e) {
                          
                      }
                  }
                  
          // mettre les filmes dans une tables a partir des genres et les triées .
                  
                  LinkedList<Filme> fil=new LinkedList<Filme>();
          
      
      for(int i=0;i<FilmeGenrePredict.size();i++){
           DefaultTableModel table=new DefaultTableModel();
           table.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu"});
      
        try {
                fil=new QuelleGenreDeFilme().RecherchParGenre(FilmeGenrePredict.get(i).split("\\|"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          for(int j=0;j<fil.size();j++)     
            table.addRow(new Object[] 
                     {fil.get(j).Id,fil.get(j).Nom,fil.get(j).Date,fil.get(j).Note});
         trieTable(table);
         
         if(table.getRowCount()<=2) FilmeId.addLast(table.getValueAt(0,0).toString());
         else {FilmeId.addLast(table.getValueAt(0, 0).toString());FilmeId.addLast(table.getValueAt(1, 0).toString());FilmeId.addLast(table.getValueAt(2, 0).toString());};
        
      
      }
                  
                  
                  //Supprime tout les filmes déja vu Par cette utilisateur
              for(int i=0;i<FilmeId.size();i++) 
                  for(int j=0;j<l.size();j++)
                      if(Integer.parseInt(FilmeId.get(i))==Integer.parseInt(l.get(j))){FilmeId.remove(i);}
              
             // for(int i=0;i<FilmeId.size();i++)System.out.println(FilmeId.get(i));
        
              // Tout les filmes dans une listes et les triées     
              
             LinkedList<Filme> Fil=new LinkedList<Filme>();
              for(int i=0;i<FilmeId.size();i++) Fil.addLast(new RechercheFilms().RechercheParId(FilmeId.get(i)));
               InfoTableRecommandation =new DefaultTableModel();
               InfoTableRecommandation.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu","Jour","TypeJr","Season","Temp"});
           
               DefaultTableModel tablen=new DefaultTableModel();
              tablen.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Mieux Noté"});
              
              for(int i=0;i<Fil.size();i++) {
                        tablen.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note});
                         InfoTableRecommandation.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note,lg.Jour,lg.TypeJr,lg.Saison,lg.Saison,lg.TempHeur});
              }
        trieTable(tablen);
            Recommandation.setModel(tablen);
       
      
    }//GEN-LAST:event_HistoriqueActionPerformed

    private void FilmsMieuxNotéMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilmsMieuxNotéMouseClicked
int rownumber = -1;
 int buttonclick=evt.getButton();
rownumber=FilmsMieuxNoté.getSelectedRow();
if(rownumber!=-1 && buttonclick==3) JOptionPane.showMessageDialog(null, 
        "Id Film: "+FilmsMieuxNoté.getValueAt(rownumber,0)+"\n"+
        "Nom Films: "+FilmsMieuxNoté.getValueAt(rownumber,1)+"\n"+
        "Genre: "+FilmsMieuxNoté.getValueAt(rownumber,2)+"\n"+
        "Nbr de Vu: "+FilmsMieuxNoté.getValueAt(rownumber,3));
    }//GEN-LAST:event_FilmsMieuxNotéMouseClicked

    private void FilmeDéjaVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilmeDéjaVuMouseClicked
int rownumber = -1;
 int buttonclick=evt.getButton();
rownumber=FilmeDéjaVu.getSelectedRow();
if(rownumber!=-1 && buttonclick==3) JOptionPane.showMessageDialog(null, 
        "Id Film: "+FilmeDéjaVu.getValueAt(rownumber,0)+"\n"+
        "Nom Films: "+FilmeDéjaVu.getValueAt(rownumber,1)+"\n"+
        "Genre: "+FilmeDéjaVu.getValueAt(rownumber,2)+"\n"+
        "Nbr de Vu: "+FilmeDéjaVu.getValueAt(rownumber,3));
    }//GEN-LAST:event_FilmeDéjaVuMouseClicked

    private void RecommandationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecommandationMouseClicked
int rownumber = -1;
 int buttonclick=evt.getButton();
rownumber=Recommandation.getSelectedRow();
if(rownumber!=-1 && buttonclick==3) JOptionPane.showMessageDialog(null, 
        "Id Film: "+Recommandation.getValueAt(rownumber,0)+"\n"+
        "Nom Films: "+Recommandation.getValueAt(rownumber,1)+"\n"+
        "Genre: "+Recommandation.getValueAt(rownumber,2)+"\n"+
        "Nbr de Vu: "+Recommandation.getValueAt(rownumber,3));
    }//GEN-LAST:event_RecommandationMouseClicked

    private void SimilUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimilUserMouseClicked
        try {
          //  JOptionPane.showMessageDialog(null, new CalculeSimil().UserSimil(Id.getText()));  
            LinkedList<String> l=new LinkedList<>();
       l=new RechercheFilms().ListDesFilmesLesMieuxNotéDunUser(new CalculeSimil().UserSimil(Id.getText()));
            
            for(int i=0;i<l.size();i++) {
                System.out.println(l.get(i));
            }
            /*AffichageDecisionTree f=new AffichageDecisionTree(this, true,TreeProfil);
                        f.setLocation(100, 200);
                        f.setVisible(true);*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SimilUserMouseClicked

    private void SimilaItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimilaItemMouseClicked
 try {
          //  JOptionPane.showMessageDialog(null, new CalculeSimil().UserSimil(Id.getText()));  
            LinkedList<String> l=new LinkedList<>();
            for(int i=0;i<FilmeDéjaVu.getRowCount();i++){
       l.addLast(new CalculeSimil().ItemSimil(FilmeDéjaVu.getValueAt(i,0).toString()));
            }
            
            for(int i=0;i<l.size();i++) {
                System.out.println(l.get(i));
            }
            /*AffichageDecisionTree f=new AffichageDecisionTree(this, true,TreeProfil);
                        f.setLocation(100, 200);
                        f.setVisible(true);*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SimilaItemMouseClicked

    private void Button1RecommandationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1RecommandationMouseClicked
 LinkedList<String> FilmeId=new LinkedList<String>();
                  LinkedList<String> FilmeGenrePredict=new LinkedList<String>();
                  String prediction =null;
                  
    
           // ********************************Recommandation des filmes a partir du profil**********************************************//
                  for(int i=0;i<Toutgenre.size();i++){
                 String [] instance2={Id.getText(),Toutgenre.get(i),null,Jour.getSelectedItem().toString(),TypJr.getSelectedItem().toString(),Saison.getSelectedItem().toString(),Temp.getSelectedItem().toString()};
               //  System.out.println(Id.getText()+" "+Toutgenre.get(i)+" "+null+" "+lg.Jour+" "+lg.TypeJr+" "+lg.Saison+" "+lg.TempHeur);
                 prediction=TreeHistorique.predictTargetAttributeValue(instance2);
                 System.out.println(prediction);
                      try {
                         if(prediction.equalsIgnoreCase("Yes")){
                             System.out.println(Toutgenre.get(i)+" : "+"Yes");
                             FilmeGenrePredict.addLast(Toutgenre.get(i));
                         
                         }
                         // System.out.println("\n The class that is predicted is: " +prediction);
                      } catch (Exception e) {
                          
                      }
                  }
                  
          // mettre les filmes dans une tables a partir des genres et les triées .
                  
                  LinkedList<Filme> fil=new LinkedList<Filme>();
          
      
      for(int i=0;i<FilmeGenrePredict.size();i++){
           DefaultTableModel table=new DefaultTableModel();
           table.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu"});
      
        try {
                fil=new QuelleGenreDeFilme().RecherchParGenre(FilmeGenrePredict.get(i).split("\\|"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          for(int j=0;j<fil.size();j++)     
            table.addRow(new Object[] 
                     {fil.get(j).Id,fil.get(j).Nom,fil.get(j).Date,fil.get(j).Note});
         trieTable(table);
         
         if(table.getRowCount()<=2) FilmeId.addLast(table.getValueAt(0,0).toString());
         else {FilmeId.addLast(table.getValueAt(0, 0).toString());FilmeId.addLast(table.getValueAt(1, 0).toString());FilmeId.addLast(table.getValueAt(2, 0).toString());};
        
      
      }
                  
                  
                  //Supprime tout les filmes déja vu Par cette utilisateur
              for(int i=0;i<FilmeId.size();i++) 
                  for(int j=0;j<l.size();j++)
                      if(Integer.parseInt(FilmeId.get(i))==Integer.parseInt(l.get(j))){FilmeId.remove(i);}
              
             // for(int i=0;i<FilmeId.size();i++)System.out.println(FilmeId.get(i));
        
              // Tout les filmes dans une listes et les triées     
              
             LinkedList<Filme> Fil=new LinkedList<Filme>();
              for(int i=0;i<FilmeId.size();i++) Fil.addLast(new RechercheFilms().RechercheParId(FilmeId.get(i)));
               InfoTableRecommandation =new DefaultTableModel();
               InfoTableRecommandation.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu","Jour","TypeJr","Season","Temp"});
           
               DefaultTableModel tablen=new DefaultTableModel();
              tablen.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Mieux Noté"});
              
              for(int i=0;i<Fil.size();i++) {
                        tablen.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note});
                    //     InfoTableRecommandation.addRow(new Object[] 
                    // {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note,lg.Jour,lg.TypeJr,lg.Saison,lg.Saison,lg.TempHeur});
              }
        trieTable(tablen);
            Recommandation.setModel(tablen);
        
                  
    }//GEN-LAST:event_Button1RecommandationMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
JOptionPane.showMessageDialog(null, "Création D'arbre");

// Crée nos Decision Tree
                    java.util.Date res =new java.util.Date();
                   DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
                   String [] tabDate= fullDateFormat.format(res).toString().split(" ");
                    LongToDateAndClass lg=new LongToDateAndClass();
                    lg.classificationUtilisantUneDate(tabDate);
               //  System.out.print("1 "+null+" "+lg.Jour+" "+lg.TypeJr+" "+lg.Saison+" "+lg.TempHeur+"\n");
             
      //******************************************** Création Arbre Coté Profil ***********************************************//              
                    AlgoID3 algo = new AlgoID3();
        try {
            TreeProfil= algo.runAlgorithm("Data/MovieBinaireFinalModfUnSeulGenre.txt", "Like/Dislike", " ");
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
                            algo.printStatistics();
                           TreeProfil.print();
                            
         //****************************************** Création D'arbre Coté historique ********************************************//       
           File f=new File("Data/User"+Id.getText()+".txt");
           if(f.exists()){
        try {
            TreeHistorique= algo.runAlgorithm("Data/User"+Id.getText()+".txt","Like/Dislike", " ");
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
                  algo.printStatistics();
                  // TreeHistorique.print();
           }        
           
           else {
               DecisionTreeForOneUser dc=new DecisionTreeForOneUser();
            try {
                dc.CreationDataOneUser("Data/u.data",Id.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            }
                AlgoID3 algoo = new AlgoID3();
        try {
            TreeHistorique= algoo.runAlgorithm("Data/User"+Id.getText()+".txt", "Like/Dislike", " ");
           // TreeHistorique.print();
            
        } catch (IOException ex) {
            Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
        }
                
           }
    //****************************************************************************************************************//
           
                  LinkedList<String> FilmeId=new LinkedList<String>();
                  LinkedList<String> FilmeGenrePredict=new LinkedList<String>();
                  String prediction =null;
                  
    
           // ********************************Recommandation des filmes a partir du profil**********************************************//
                  for(int i=0;i<Toutgenre.size();i++){
                 String [] instance2={new RecherchUserInfo().IntervalAge(Age.getText()),Sex.getText(),Profession.getText(),Toutgenre.get(i),null,lg.Jour,lg.TypeJr,lg.Saison,lg.TempHeur};
                 System.out.println(new RecherchUserInfo().IntervalAge(Age.getText())+" "+Sex.getText()+" "+Profession.getText()+" "+Toutgenre.get(i)+" "+null+" "+lg.Jour+" "+lg.TypeJr+" "+lg.Saison+" "+lg.TempHeur);
                 prediction=TreeProfil.predictTargetAttributeValue(instance2);
                 System.out.println(prediction);
                      try {
                         if(prediction.equalsIgnoreCase("Yes")){
                             System.out.println(Toutgenre.get(i)+" : "+"Yes");
                             FilmeGenrePredict.addLast(Toutgenre.get(i));
                         
                         }
                         // System.out.println("\n The class that is predicted is: " +prediction);
                      } catch (Exception e) {
                          
                      }
                  }
                  
          // mettre les filmes dans une tables a partir des genres et les triées .
                  
                  LinkedList<Filme> fil=new LinkedList<Filme>();
          
      
      for(int i=0;i<FilmeGenrePredict.size();i++){
           DefaultTableModel table=new DefaultTableModel();
           table.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu"});
      
        try {
                fil=new QuelleGenreDeFilme().RecherchParGenre(FilmeGenrePredict.get(i).split("\\|"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          for(int j=0;j<fil.size();j++)     
            table.addRow(new Object[] 
                     {fil.get(j).Id,fil.get(j).Nom,fil.get(j).Date,fil.get(j).Note});
         trieTable(table);
         
         if(table.getRowCount()<=2) FilmeId.addLast(table.getValueAt(0,0).toString());
         else {FilmeId.addLast(table.getValueAt(0, 0).toString());FilmeId.addLast(table.getValueAt(1, 0).toString());FilmeId.addLast(table.getValueAt(2, 0).toString());};
        
      
      }
                  
                  
                  //Supprime tout les filmes déja vu Par cette utilisateur
              for(int i=0;i<FilmeId.size();i++) 
                  for(int j=0;j<l.size();j++)
                      if(Integer.parseInt(FilmeId.get(i))==Integer.parseInt(l.get(j))){FilmeId.remove(i);}
              
             // for(int i=0;i<FilmeId.size();i++)System.out.println(FilmeId.get(i));
        
              // Tout les filmes dans une listes et les triées     
              
             LinkedList<Filme> Fil=new LinkedList<Filme>();
              for(int i=0;i<FilmeId.size();i++) Fil.addLast(new RechercheFilms().RechercheParId(FilmeId.get(i)));
               InfoTableRecommandation =new DefaultTableModel();
               InfoTableRecommandation.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Nbr de Vu","Jour","TypeJr","Season","Temp"});
           
               DefaultTableModel tablen=new DefaultTableModel();
              tablen.setColumnIdentifiers(new String[]{"Id","Nom Filme","Genre","Mieux Noté"});
              
              for(int i=0;i<Fil.size();i++) {
                        tablen.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note});
                         InfoTableRecommandation.addRow(new Object[] 
                     {Fil.get(i).Id,Fil.get(i).Nom,Fil.get(i).Date,Fil.get(i).Note,lg.Jour,lg.TypeJr,lg.Saison,lg.Saison,lg.TempHeur});
              }
        trieTable(tablen);
            Recommandation.setModel(tablen);
            

    }//GEN-LAST:event_formWindowOpened

    private void InfoREcommandationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoREcommandationMouseClicked
EvaluationSystéme ev=new EvaluationSystéme(this,false);
ev.setLocation(100, 150);
ev.setVisible(true);
    }//GEN-LAST:event_InfoREcommandationMouseClicked

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
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    F2 dialog = new F2(new princ(), true,"","","","");
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(F2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Age;
    private javax.swing.JToggleButton Button1Recommandation;
    private javax.swing.JMenu DecisionTree;
    private javax.swing.JTable FilmeDéjaVu;
    private javax.swing.JTable FilmsMieuxNoté;
    private javax.swing.JComboBox Genre;
    private javax.swing.JRadioButton Historique;
    private javax.swing.JLabel Id;
    private javax.swing.JMenu InfoREcommandation;
    private javax.swing.JComboBox Jour;
    private javax.swing.JLabel Profession;
    private javax.swing.JRadioButton Profil;
    private javax.swing.JTable Recommandation;
    private javax.swing.JComboBox Saison;
    private javax.swing.JLabel Sex;
    private javax.swing.JMenu SimilUser;
    private javax.swing.JMenu SimilaItem;
    private javax.swing.JComboBox Temp;
    private javax.swing.JComboBox TypJr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

public void trieTable(DefaultTableModel tb){
    
    // supprimer tout les filmes  qui on la note 0
  /*    for(int j=0;j<tb.getRowCount();j++){
          if(Integer.parseInt(tb.getValueAt(j, 3).toString())==0)tb.removeRow(j);
      }*/
    

     // trie apré les filmes qui nous réstes
    for(int i=0;i<tb.getRowCount();i++){
      for(int j=i+1;j<tb.getRowCount();j++){
    if(Integer.parseInt(tb.getValueAt(i,3).toString())<Integer.parseInt(tb.getValueAt(j, 3).toString())){
           Object Id=tb.getValueAt(i, 0).toString();
           Object Nom=tb.getValueAt(i,1).toString();
           Object Genre=tb.getValueAt(i, 2).toString();
           Object Nbr=tb.getValueAt(i, 3).toString();
              tb.setValueAt(tb.getValueAt(j, 0), i, 0);
              tb.setValueAt(tb.getValueAt(j, 1), i, 1);
              tb.setValueAt(tb.getValueAt(j, 2), i, 2);
              tb.setValueAt(tb.getValueAt(j, 3), i, 3);
              tb.setValueAt(Id, j, 0);
              tb.setValueAt(Nom, j, 1);
              tb.setValueAt(Genre, j, 2);
              tb.setValueAt(Nbr, j, 3);
          }
      }
}
    
}  
}

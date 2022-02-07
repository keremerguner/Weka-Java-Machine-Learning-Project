package weka;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;

public class wekaGuiDeneme extends javax.swing.JFrame {

    
    public wekaGuiDeneme() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_alanı = new javax.swing.JTextArea();
        YAZDIR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("OUTPUT");

        text_alanı.setColumns(20);
        text_alanı.setRows(5);
        jScrollPane1.setViewportView(text_alanı);

        YAZDIR.setText("ESLESEN ULKEYI GORUNTULE");
        YAZDIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YAZDIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(YAZDIR))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(YAZDIR)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YAZDIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YAZDIRActionPerformed
try {
                    text_alanı.setText("");
                  
            		  
        DataSource source = new DataSource("C:\\Users\\ergun\\Desktop\\originalDataSet.arff");
        Instances trainDataset = source.getDataSet();
        
        trainDataset.setClassIndex(2);
        Evaluation eval = new Evaluation(trainDataset);
        
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(trainDataset);

        
        
        DataSource source1 = new DataSource("C:\\Users\\ergun\\Desktop\\testDataSet.arff");
        Instances testDataset = source1.getDataSet();
        
        testDataset.setClassIndex(2);
        
        System.out.println("================");
        
        for(int i = 0; i < testDataset.numInstances(); i++) {

            Instance newInst = testDataset.instance(i);
            
            double predNB = nb.classifyInstance(newInst);
            
            String predString = testDataset.classAttribute().value((int) predNB);
            text_alanı.setText("\n\n                        OGRENCI ULKESI   -->   "+predString);

        }
                    
                } catch (Exception ex) {
                    text_alanı.setText("Hata olustu\n"+ex.getMessage());
                    }        
    }//GEN-LAST:event_YAZDIRActionPerformed


    public static void main(String args[]) {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(wekaGuiDeneme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(wekaGuiDeneme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(wekaGuiDeneme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(wekaGuiDeneme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wekaGuiDeneme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton YAZDIR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text_alanı;
    // End of variables declaration//GEN-END:variables

    private void setText(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

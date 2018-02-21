/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;
import Mode.dao.AlunoDao;
import Model.bean.Aluno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author RG 295
 */
public class TelaNotas extends javax.swing.JFrame {

    /**
     * Creates new form TelaNotas
     */
    
        public void mostrar(List<Aluno> alu)  { // joga dados da lista na tabela
        DefaultTableModel dfm = (DefaultTableModel) alunos.getModel(); //pega o modelo da tabela
        dfm.setNumRows(0);//setando os dados apartir da coluna zero da Jtable

        for (Aluno a : alu) {
            String[] tx;// cria o vetor de string para receber a splint q he o a string desconcatenada
            tx = a.getNotas().split(";");//desconcatenar a string notas  
        
            armengue(tx.length,dfm,a,tx);

        }  
    }
    
        
        public void armengue(int tamanho,DefaultTableModel dfm, Aluno a, String[] tx){
            switch(tamanho){
                case 0:
                    for(int i = 0 ; i < tamanho;i++){
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

              /*  tx[1],
                tx[2],
                tx[3],
                tx[4],
                tx[5]*/
                });}
                    break;
                case 1:
              for(int i = 0 ; i < tamanho;i++){
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0]
               /* tx[2],
                tx[3],
                tx[4],
                tx[5]*/
                });}
                    break;
                case 2:
                for(int i = 0 ; i < tamanho;i++){
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1]
               /* tx[3],
                tx[4],
                tx[5]*/
                });}
                    break;
                case 3:
               for(int i = 0 ; i < tamanho;i++){
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],
                tx[2]
                /*tx[4],
                tx[5]*/
                });}
                    break;
                case 4:
                for(int i = 0 ; i < tamanho;i++){
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
                tx[1],
                tx[2],
                tx[3]
                /*tx[5]*/
                });}
                    break;
                case 5:
              for(int i = 0 ; i < tamanho;i++){
               
            dfm.addRow(new Object[]{//objeto a ser inserido na tabela alunos  de indice zero
                a.getNome(),
                a.turma.getNome(),
                a.turma.escola.getNome(),

                tx[0],
               tx[1],
                tx[2],
                tx[3],
                tx[4]
                });}
                    break;
        }
        }
    
    public TelaNotas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOTAS");

        jButton1.setText("MOSTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        alunos.setBackground(new java.awt.Color(0, 102, 102));
        alunos.setForeground(new java.awt.Color(255, 255, 255));
        alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME DO ALUNO", "TURMA", "NOME DA ESCOLA", "N01", "N02", "N03", "N04", "N05", "N06", "MÉDIA"
            }
        ));
        alunos.setSelectionBackground(new java.awt.Color(0, 51, 102));
        alunos.setSelectionForeground(new java.awt.Color(0, 204, 255));
        jScrollPane1.setViewportView(alunos);
        if (alunos.getColumnModel().getColumnCount() > 0) {
            alunos.getColumnModel().getColumn(0).setPreferredWidth(200);
            alunos.getColumnModel().getColumn(1).setPreferredWidth(60);
            alunos.getColumnModel().getColumn(2).setPreferredWidth(200);
            alunos.getColumnModel().getColumn(3).setPreferredWidth(40);
            alunos.getColumnModel().getColumn(4).setPreferredWidth(40);
            alunos.getColumnModel().getColumn(5).setPreferredWidth(40);
            alunos.getColumnModel().getColumn(6).setPreferredWidth(40);
            alunos.getColumnModel().getColumn(7).setPreferredWidth(40);
            alunos.getColumnModel().getColumn(8).setPreferredWidth(40);
            alunos.getColumnModel().getColumn(9).setPreferredWidth(55);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AlunoDao aluno = new AlunoDao();
            try {
                mostrar(aluno.pegaNotas());
            } catch (Exception ex) {
                Logger.getLogger(TelaNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alunos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

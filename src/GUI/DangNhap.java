/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import DBEngine.DBEngine;
import CACDULIEU.TaiKhoan;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */

public class DangNhap extends javax.swing.JFrame {
    static ArrayList<TaiKhoan> dstk= new ArrayList<>();
    static String filetk="TaiKhoan.txt";
    static DBEngine DBE=new DBEngine();
    
    public DangNhap() {
        loadarray();
        initComponents();
        jTextTK.setText("");
        this.setLocationRelativeTo(null) ;
    }
    void loadarray(){
        try {
           dstk=(ArrayList<TaiKhoan>) DBE.docFile(filetk);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextTK = new javax.swing.JTextField();
        jBtDangNhap = new javax.swing.JButton();
        jButtonLM = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextMK = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tài Khoản");

        jLabel2.setText("Mật Khẩu");

        jBtDangNhap.setText("Đăng Nhập");
        jBtDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDangNhapActionPerformed(evt);
            }
        });

        jButtonLM.setText("Làm Mới");
        jButtonLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLMActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Phần Mền Đăng Ký Học Phần");

        jTextMK.setText("jPasswordField1");
        jTextMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtDangNhap)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonLM, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextTK, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(jTextMK)))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtDangNhap)
                    .addComponent(jButtonLM))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDangNhapActionPerformed
       if(jTextTK.getText().trim().equals("") == false && jTextMK.getText().trim().equals("")==false){
            String Tk=null;
            for( var it :dstk){
                if(it.getTK().equalsIgnoreCase(jTextTK.getText().trim()) && it.getMK().equals(jTextMK.getText().trim())){
                    Tk=it.getTK();
                    break;
                }   
            } 

            if(Tk!=null){
                if(Tk.trim().toUpperCase().contains("SV")){
                    MeNuSinhVien menusv=new MeNuSinhVien(Tk.trim().toUpperCase());
                    //menusv.setMaSV();
                    menusv.setVisible(true);
                    dispose();
                }
                else{
                     MeNuQuanLy MN= new MeNuQuanLy();
                     MN.setVisible(true);
                     dispose();
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"TK MK ko Chính Xác!");
            }
       }
       else{
           JOptionPane.showMessageDialog(this,"TK MK ko được để trống!"); 
       }
    }//GEN-LAST:event_jBtDangNhapActionPerformed

    private void jButtonLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLMActionPerformed
        // TODO add your handling code here:
        jTextMK.setText("");
        jTextTK.setText("");
    }//GEN-LAST:event_jButtonLMActionPerformed

    private void jTextMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMKActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtDangNhap;
    private javax.swing.JButton jButtonLM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jTextMK;
    private javax.swing.JTextField jTextTK;
    // End of variables declaration//GEN-END:variables
}
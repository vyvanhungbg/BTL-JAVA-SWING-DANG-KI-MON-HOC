/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import CACDULIEU.DangKy;
import CACDULIEU.GiangVien;
import CACDULIEU.HocPhan;
import CACDULIEU.LopHocPhan;
import DAO.DKHocPhanDAO;
import DBEngine.DBEngine;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vyvan
 */
public class DKHocPhan extends javax.swing.JFrame {
    
    
    ArrayList<LopHocPhan> dsLhp = new ArrayList<LopHocPhan>(); // luu tru danh sanh lop hoc phan duoc tao
    ArrayList<HocPhan> dshp = new ArrayList<HocPhan>();      // luu tru danh sach hoc phan
    ArrayList<GiangVien> dsGv = new ArrayList<GiangVien>(); // luu tru danh sach giang vien
    ArrayList<DangKy> dsdk=new ArrayList<>();
    static String filelhp="LopHocPhan.txt";
    static String filehp="HocPhan.txt";
    static String fileGV="GiangVien.txt";
    static String fileDK="DangKy.txt";
    int dong=-1;
    private String maSV;

   
    DangKy dk= new DangKy();
    static DBEngine DBE=new DBEngine();
    
    void loadfieLHP(){
        try {
           dsLhp=(ArrayList<LopHocPhan>) DBE.docFile(filelhp);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadfieHP(){
        try {
           dshp=(ArrayList<HocPhan>) DBE.docFile(filehp);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadfieGV(){
        try {
           dsGv=(ArrayList<GiangVien>) DBE.docFile(fileGV);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadfiedk(){
        try {
           dsdk=(ArrayList<DangKy>) DBE.docFile(fileDK);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void nhapfile(){
        try {
            DBE.LuuFile(fileDK, dsdk);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadtb(){
        jTable1.setModel(new DKHocPhanDAO(dsLhp,dshp,dsGv));
    }
    boolean KTdk(String mahp){
        boolean kq=true;
        for(var it:dsdk){
            if(mahp.equals(it.getMaHocPhan()) && it.getMaSinhVien().equalsIgnoreCase(maSV)){
                kq=false;
            }
        }
        return kq;
    }
    /**
     * Creates new form DKHocPhan
     */
    public DKHocPhan() {
        initComponents();
        loadfieGV();
        loadfieHP();
        loadfiedk();
        loadfieLHP();
        loadtb();
        this.setLocationRelativeTo(null) ;
        
    }
    
     public DKHocPhan(String maSV) {
        this.maSV = maSV;
        initComponents();
        loadfieGV();
        loadfieHP();
        loadfiedk();
        loadfieLHP();
        loadtb();
        this.setLocationRelativeTo(null) ;
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonDK = new javax.swing.JButton();
        jButtonTK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextTK = new javax.swing.JTextField();
        jButtonLM = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_trangChu = new javax.swing.JMenu();
        menu_xem = new javax.swing.JMenu();
        menu_xemTKB = new javax.swing.JMenuItem();
        menu_dangKy = new javax.swing.JMenu();
        menu_dangKiHP = new javax.swing.JMenuItem();
        menu_hoTro = new javax.swing.JMenu();
        menu_rutDangKiHP = new javax.swing.JMenuItem();
        menu_thoat = new javax.swing.JMenu();
        menu_dangXuat = new javax.swing.JMenuItem();
        menu_Thoat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Đăng Ký Học Phần");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButtonDK.setText("Đăng Ký Học");
        jButtonDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDKActionPerformed(evt);
            }
        });

        jButtonTK.setText("Tìm Kiếm");
        jButtonTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTKActionPerformed(evt);
            }
        });

        jLabel2.setText(" TÌm Kiếm Theo Tên Học Phần");

        jButtonLM.setText("Làm Mới");
        jButtonLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLMActionPerformed(evt);
            }
        });

        menu_trangChu.setText("Trang chu");
        jMenuBar1.add(menu_trangChu);

        menu_xem.setText("Xem");
        menu_xem.setToolTipText("");

        menu_xemTKB.setText("Xem thoi khoa bieu");
        menu_xemTKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_xemTKBActionPerformed(evt);
            }
        });
        menu_xem.add(menu_xemTKB);

        jMenuBar1.add(menu_xem);

        menu_dangKy.setText("Đăng kí");
        menu_dangKy.setActionCommand("");

        menu_dangKiHP.setText("Dang ki hoc phan");
        menu_dangKiHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dangKiHPActionPerformed(evt);
            }
        });
        menu_dangKy.add(menu_dangKiHP);

        jMenuBar1.add(menu_dangKy);

        menu_hoTro.setText("Ho tro");

        menu_rutDangKiHP.setText("Rut dang ki hoc phan");
        menu_hoTro.add(menu_rutDangKiHP);

        jMenuBar1.add(menu_hoTro);

        menu_thoat.setText("Thoát");

        menu_dangXuat.setText("Dang xuat");
        menu_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dangXuatActionPerformed(evt);
            }
        });
        menu_thoat.add(menu_dangXuat);

        menu_Thoat.setText("Thoat");
        menu_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ThoatActionPerformed(evt);
            }
        });
        menu_thoat.add(menu_Thoat);

        jMenuBar1.add(menu_thoat);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDK)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonLM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextTK, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTK))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDK)
                    .addComponent(jButtonTK)
                    .addComponent(jTextTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLM))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTKActionPerformed
        // TODO add your handling code here:
        String tenlop=jTextTK.getText().trim().toUpperCase();
        ArrayList<LopHocPhan> dsTK= new ArrayList<>();
        for(var it:dshp){
            if(it.getTenHocPhan().trim().toUpperCase().contains(tenlop)){
                for(var itL :dsLhp){
                    if(it.getMaHocPhan().equals(itL.getMaHocPhan())){
                        dsTK.add(itL);
                    }
                }
            }
        }
        
        jTable1.setModel(new DKHocPhanDAO(dsTK, dshp, dsGv));
    }//GEN-LAST:event_jButtonTKActionPerformed

    private void jButtonLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLMActionPerformed
        // TODO add your handling code here:
        jTextTK.setText("");
        loadtb();
    }//GEN-LAST:event_jButtonLMActionPerformed

    private void jButtonDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDKActionPerformed
        // TODO add your handling code here:
        dong= jTable1.getSelectedRow();
        if(dong!=-1){
            String malhp=(jTable1.getModel().getValueAt(dong, 0).toString());
            String mahp="";
            for(var it :dsLhp){
                if(it.getMaLopHocPhan().equals(malhp)){
                    mahp=it.getMaHocPhan();
                }
            }
            if(KTdk(mahp)){
                try {
                    dk=new DangKy(maSV,malhp,mahp);
                    dsdk.add(dk);
                    nhapfile();
                    JOptionPane.showMessageDialog(this,"Bạn Đã Đang Ký Thành Công Lớp "  +malhp);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,e);
                }
            }
            else{
                String tenhp=(jTable1.getModel().getValueAt(dong, 1).toString());
                JOptionPane.showMessageDialog(this,"Bạn Đã Đang Ký Học Phần: '"  +tenhp+"' Rồi");
            }
            
            
        }
            
    }//GEN-LAST:event_jButtonDKActionPerformed

    private void menu_xemTKBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_xemTKBActionPerformed
        // TODO add your handling code here:
        XemLichHoc xemlh=new XemLichHoc(maSV);
        xemlh.setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_xemTKBActionPerformed

    private void menu_dangKiHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dangKiHPActionPerformed
        // TODO add your handling code here:
        DKHocPhan dkhp=new DKHocPhan(this.maSV);
        dkhp.setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_dangKiHPActionPerformed

    private void menu_dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap DN=new DangNhap();
        DN.setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_dangXuatActionPerformed

    private void menu_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menu_ThoatActionPerformed

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
            java.util.logging.Logger.getLogger(DKHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DKHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DKHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DKHocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DKHocPhan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDK;
    private javax.swing.JButton jButtonLM;
    private javax.swing.JButton jButtonTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextTK;
    private javax.swing.JMenuItem menu_Thoat;
    private javax.swing.JMenuItem menu_dangKiHP;
    private javax.swing.JMenu menu_dangKy;
    private javax.swing.JMenuItem menu_dangXuat;
    private javax.swing.JMenu menu_hoTro;
    private javax.swing.JMenuItem menu_rutDangKiHP;
    private javax.swing.JMenu menu_thoat;
    private javax.swing.JMenu menu_trangChu;
    private javax.swing.JMenu menu_xem;
    private javax.swing.JMenuItem menu_xemTKB;
    // End of variables declaration//GEN-END:variables
}
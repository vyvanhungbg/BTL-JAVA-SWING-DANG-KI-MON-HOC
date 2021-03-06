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
    
    public void checkLogin(){
        if(maSV==null){
            JOptionPane.showMessageDialog(this,"Bạn cần đăng nhập để thực hiện chức năng này");
            dispose(); // close window
            setVisible(false);
            System.exit(0); // stop program
        }
    }
    
    void loadFileLHP(){
        try {
           dsLhp=(ArrayList<LopHocPhan>) DBE.docFile(filelhp);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    
    
    
    void loadFileHP(){
        try {
           dshp=(ArrayList<HocPhan>) DBE.docFile(filehp);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadFileGV(){
        try {
           dsGv=(ArrayList<GiangVien>) DBE.docFile(fileGV);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadFiledk(){
        try {
           dsdk=(ArrayList<DangKy>) DBE.docFile(fileDK);
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,ex);
        }
    }
    void luuFileDSDK(){
        try {
            DBE.LuuFile(fileDK, dsdk);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex);
        }
    }
    void loadTable(){
        jTable1.setModel(new DKHocPhanDAO(dsLhp,dshp,dsGv));
    }
    boolean kiemTraDangKy(String mahp){
        for(var it:dsdk){
            
            if(it.getMaHocPhan()!= null && it.getMaSinhVien()!= null && mahp.equalsIgnoreCase(it.getMaHocPhan()) && it.getMaSinhVien().equalsIgnoreCase(maSV)){
                return false;
            }
        }
        return true;
    }
    /**
     * Creates new form DKHocPhan
     */
    public DKHocPhan() {
        initComponents();
        checkLogin();
        loadFileGV();
        loadFileHP();
        loadFiledk();
        loadFileLHP();
        loadTable();
       
        this.setLocationRelativeTo(null) ;
        
        
        
    }
    
     public DKHocPhan(String maSV) {
        this.maSV = maSV;
        initComponents();
        checkLogin();
        loadFileGV();
        loadFileHP();
        loadFiledk();
        loadFileLHP();
        loadTable();
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
        btn_dangKyHoc = new javax.swing.JButton();
        btn_timKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        btn_LamMoi = new javax.swing.JButton();
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

        btn_dangKyHoc.setText("Đăng Ký Học");
        btn_dangKyHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangKyHocActionPerformed(evt);
            }
        });

        btn_timKiem.setText("Tìm Kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        jLabel2.setText(" TÌm Kiếm Theo Tên Học Phần");

        btn_LamMoi.setText("Làm Mới");
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        menu_trangChu.setText("Trang chủ");
        menu_trangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_trangChuMouseClicked(evt);
            }
        });
        menu_trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_trangChuActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu_trangChu);

        menu_xem.setText("Xem");
        menu_xem.setToolTipText("");

        menu_xemTKB.setText("Thời khóa biểu");
        menu_xemTKB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_xemTKBActionPerformed(evt);
            }
        });
        menu_xem.add(menu_xemTKB);

        jMenuBar1.add(menu_xem);

        menu_dangKy.setText("Đăng kí");
        menu_dangKy.setActionCommand("");

        menu_dangKiHP.setText("Đăng kí học phần");
        menu_dangKiHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dangKiHPActionPerformed(evt);
            }
        });
        menu_dangKy.add(menu_dangKiHP);

        jMenuBar1.add(menu_dangKy);

        menu_hoTro.setText("Hỗ trợ");

        menu_rutDangKiHP.setText("Rút đăng kí học phần");
        menu_hoTro.add(menu_rutDangKiHP);

        jMenuBar1.add(menu_hoTro);

        menu_thoat.setText("Thoát");

        menu_dangXuat.setText("Đăng xuất");
        menu_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dangXuatActionPerformed(evt);
            }
        });
        menu_thoat.add(menu_dangXuat);

        menu_Thoat.setText("Thoát");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_dangKyHoc)
                                .addGap(30, 30, 30)
                                .addComponent(btn_LamMoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_timKiem))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(327, 327, 327))))
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
                    .addComponent(btn_dangKyHoc)
                    .addComponent(btn_timKiem)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LamMoi))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        // TODO add your handling code here:
        String tenlop=txt_timKiem.getText().trim().toUpperCase();
        ArrayList<LopHocPhan> dsTK= new ArrayList<>();
        for(HocPhan it:dshp){
            if(it.getTenHocPhan().trim().toUpperCase().contains(tenlop)){
                for(LopHocPhan itL :dsLhp){
                    if(it.getMaHocPhan().equals(itL.getMaHocPhan())){
                        dsTK.add(itL);
                    }
                }
            }
        }
        
        jTable1.setModel(new DKHocPhanDAO(dsTK, dshp, dsGv));
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        txt_timKiem.setText("");
        loadTable();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_dangKyHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangKyHocActionPerformed
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
            if(kiemTraDangKy(mahp)){
                try {
                    dk=new DangKy(maSV,malhp,mahp);
                    dsdk.add(dk);
                    luuFileDSDK();
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
            
    }//GEN-LAST:event_btn_dangKyHocActionPerformed

    private void menu_trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_trangChuActionPerformed
        
    }//GEN-LAST:event_menu_trangChuActionPerformed

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

    private void menu_trangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_trangChuMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
             MeNuSinhVien menusv=new MeNuSinhVien(maSV);
            //menusv.setMaSV();
            menusv.setVisible(true);
            dispose();
    }//GEN-LAST:event_menu_trangChuMouseClicked

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
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_dangKyHoc;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}

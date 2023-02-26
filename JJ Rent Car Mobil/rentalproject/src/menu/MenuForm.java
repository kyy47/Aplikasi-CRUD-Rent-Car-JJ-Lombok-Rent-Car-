/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import biodata.FormBiodata;
import javax.swing.JOptionPane;
import login.Login;
import login.Session;
import menusewa.SewaForm;
import menuunit.UnitForm;
import menuunitsewa.UnitSewaForm;

/**
 *
 * @author RIZKY
 */
public class MenuForm extends javax.swing.JFrame {
    Login lgn = new Login();

    /**
     * Creates new form MenuForm
     */
    public MenuForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_unit = new javax.swing.JButton();
        btn_Sewa = new javax.swing.JButton();
        btn_unit_sewa = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_unit_sewa1 = new javax.swing.JButton();
        db_menu_utama = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 1000));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        btn_unit.setBackground(new java.awt.Color(0, 102, 204));
        btn_unit.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        btn_unit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/traffic-jam.png"))); // NOI18N
        btn_unit.setText("Unit");
        btn_unit.setBorderPainted(false);
        btn_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unitActionPerformed(evt);
            }
        });

        btn_Sewa.setBackground(new java.awt.Color(0, 102, 204));
        btn_Sewa.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        btn_Sewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/car-rental.png"))); // NOI18N
        btn_Sewa.setText("Sewa");
        btn_Sewa.setBorderPainted(false);
        btn_Sewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SewaActionPerformed(evt);
            }
        });

        btn_unit_sewa.setBackground(new java.awt.Color(0, 102, 204));
        btn_unit_sewa.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        btn_unit_sewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rental-car.png"))); // NOI18N
        btn_unit_sewa.setText("Unit Sewa");
        btn_unit_sewa.setBorderPainted(false);
        btn_unit_sewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unit_sewaActionPerformed(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(0, 102, 204));
        btn_exit.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setBorderPainted(false);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_unit_sewa1.setBackground(new java.awt.Color(0, 102, 204));
        btn_unit_sewa1.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        btn_unit_sewa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/coding.png"))); // NOI18N
        btn_unit_sewa1.setText("Developers");
        btn_unit_sewa1.setBorderPainted(false);
        btn_unit_sewa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unit_sewa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_unit, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_exit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_unit_sewa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_unit_sewa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(btn_Sewa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btn_unit)
                .addGap(51, 51, 51)
                .addComponent(btn_Sewa)
                .addGap(63, 63, 63)
                .addComponent(btn_unit_sewa)
                .addGap(63, 63, 63)
                .addComponent(btn_unit_sewa1)
                .addGap(58, 58, 58)
                .addComponent(btn_exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        db_menu_utama.setPreferredSize(new java.awt.Dimension(1200, 1000));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/welcome.jpeg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(1210, 1005));

        db_menu_utama.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout db_menu_utamaLayout = new javax.swing.GroupLayout(db_menu_utama);
        db_menu_utama.setLayout(db_menu_utamaLayout);
        db_menu_utamaLayout.setHorizontalGroup(
            db_menu_utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(db_menu_utamaLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
        );
        db_menu_utamaLayout.setVerticalGroup(
            db_menu_utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(db_menu_utama, javax.swing.GroupLayout.PREFERRED_SIZE, 1337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(db_menu_utama, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1500, 1000));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
         if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?","Warning", 2)
        == JOptionPane.YES_OPTION) {
             lgn.LogOut(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unitActionPerformed
        db_menu_utama.removeAll();
        db_menu_utama.add(new UnitForm()).setVisible(true);
    }//GEN-LAST:event_btn_unitActionPerformed

    private void btn_SewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SewaActionPerformed
        db_menu_utama.removeAll();
        db_menu_utama.add(new SewaForm()).setVisible(true);
    }//GEN-LAST:event_btn_SewaActionPerformed

    private void btn_unit_sewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unit_sewaActionPerformed
        // TODO add your handling code here:
        UnitSewaForm form = new UnitSewaForm();
        form.setVisible(true);
    }//GEN-LAST:event_btn_unit_sewaActionPerformed

    private void btn_unit_sewa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unit_sewa1ActionPerformed
        db_menu_utama.removeAll();
        db_menu_utama.add(new FormBiodata()).setVisible(true);
    }//GEN-LAST:event_btn_unit_sewa1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sewa;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_unit;
    private javax.swing.JButton btn_unit_sewa;
    private javax.swing.JButton btn_unit_sewa1;
    private javax.swing.JDesktopPane db_menu_utama;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

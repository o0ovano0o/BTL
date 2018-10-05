/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

//import com.darkprograms.speech.synthesiser.SynthesiserV2;
import javax.swing.ImageIcon;
import API.SynthesiserV2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
/**
 *
 * @author Administrator
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    String ki;
    Connection conn = null;
    Dictionary dic= new Dictionary();
    SynthesiserV2 synthesizer = new SynthesiserV2();
    @SuppressWarnings("unchecked")
    public NewJFrame() {
        initComponents();
        initData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public  void speak(String text) throws JavaLayerException {
		try {
                    
                    //Create a JLayer instance
                    AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text));
                    player.play();
                    
                } catch (IOException  e) {
                    
                }
		
	}
    private Connection connect() {
      try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:Dictionaries.db";
                conn = DriverManager.getConnection(url);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return conn;
    }
    public void insertFromDb(){
        String sql = "SELECT idx, word, detail FROM tbl_edict";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                String eng=rs.getString("word");
                String viet=rs.getString("detail");
                int id=rs.getInt("idx");
                Word a= new Word(id,eng,viet);
                dic.words.put(eng, a);
                
//                System.out.println(rs.getInt("idx") +  "\t" + 
//                                 rs.getString("word") + "\t" +
//                                   rs.getString("detail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertFromFile() {
//        File file = new File("English-Vietnamese.txt");
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            br.readLine();
//            int i = 0;
//            String line = "";
//            for (i = 0; (line = br.readLine()) != null; i++) {
//                Word ex = new Word();
//                String[] a = line.split("\\|<", 2);
//                ex.spelling = a[0].substring(3, a[0].length());
//                ex.explain = a[1].substring(2);
//                dic.words.put(ex.spelling,ex.explain);
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    private void initData(){
        insertFromDb();
        DefaultListModel model = new DefaultListModel();
        dic.words.forEach((key,value)->{
            model.addElement(key);
        });
        jList1.setModel(model);
        }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outword = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 100));
        setPreferredSize(new java.awt.Dimension(750, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        outword.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(outword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 537, 1446, -1));

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 126, 430));

        jLabel1.setBackground(new java.awt.Color(255, 204, 153));
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setOpaque(true);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 570, 430));

        jTextField1.setText("Tìm từ");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 208, 30));

        jButton1.setText("Tìm từ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jButton2.setText("Tìm chính xác");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 111, -1));

        jButton3.setText("phát âm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jButton4.setText("thêm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jButton5.setText("sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jButton6.setText("xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jButton8.setText("Dịch văn bản");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cork-board-background-for-photoshop-thumb35.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        if(jList1.getSelectedValue().toString()!=null){
            jLabel1.setText("<HTML>"+dic.words.get(jList1.getSelectedValue()).explain+"</HTML>");
            ki=jList1.getSelectedValue();
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //jLabel1.setText("<HTML>"+dic.words.get(jTextField1.getText()));
//        String w=jTextField1.getText();
//        ArrayList<String> x = new ArrayList<String>();
//        dic.words.forEach((key,value)->{
//            if(w.length()<=key.length()){
//                String a=key.toLowerCase().substring(0,w.length());
//                if(a.equals(w))
//                   x.add(key);
//            }
//        });
//        if(x.size()>=20)
//        {
//            JOptionPane.showMessageDialog(null,"Có quá nhiều từ như vậy. Phiền bạn viết chi tiết hơn.^^", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
//            
//        }
//        else if(x.size()==0){
//            JOptionPane.showMessageDialog(null,"Không có từ nào như vậy đâu.^^", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            
//        
//        }
//        else
//        jLabel1.setText("<HTML>"+x.toString()+"</HTML>");
//        ki="Chose one word, please";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(dic.words.get(jTextField1.getText())
                
                ==null){
            ki="Chose one word, please";
            JOptionPane.showMessageDialog(null,"Không có từ như vậy trong từ điển", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
              jLabel1.setText("<HTML>"+dic.words.get(jTextField1.getText()).explain+"</HTML>");
            ki=jTextField1.getText();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            try {
                speak(ki);
                
           } catch (JavaLayerException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);}
               
                
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        add add = new add();
        add.setVisible(true);
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       JOptionPane.showMessageDialog(null,"Deleted","Message",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        edit edit = new edit();
        edit.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Trans tran = new Trans();
        tran.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel outword;
    // End of variables declaration//GEN-END:variables
}

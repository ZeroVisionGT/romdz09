/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romdz09;

import SevenZip.LzmaAlone;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


/**
 *
 * @author user
 */
public class txt1 extends javax.swing.JFrame {

    /**
     * Creates new form txt1
     */
    public txt1() {
        initComponents();
    }
    public void setlang(int ii){
        if (ii==0){
            jload.setText("load");jload.setToolTipText("load from file");
            jsave.setText("save");jsave.setToolTipText("save to file");
            jtorom.setText("to rom");jtorom.setToolTipText("save to rom from files with extention .b");
            jgetfnames.setText("get file names");jgetfnames.setToolTipText("get file names with extention .b");
            jtxt.setToolTipText("save to rom from files with extention .b from files in text \n"
                    + "if row text begin with '#' - file from this row not save");
            shelp="#uncomment files which you want to save to rom\n";
        }else{
            jload.setText("загрузка");jload.setToolTipText("загрузка из диска");
            jsave.setText("запись");jsave.setToolTipText("запись на диск");
            jtorom.setText("в rom");jtorom.setToolTipText("запись в rom из файлов с расширением .b");
            jgetfnames.setText("получить имена файлов");jgetfnames.setToolTipText("получить имена файлов с расширением .b");
            jtxt.setToolTipText("запись в rom из файлов с расширением .b из фалов в тексте\n"
                    + "если строчка текста начинается с '#' - файл из этой строчки в записи не участвует");
            shelp="#раскомментируйте файлы которые вы хотите записать в rom\n";
        }
    }

    public void setText(String ss) {
        jtxt.setText(ss);
    }

    public void addText(String ss) {
        jtxt.setText(jtxt.getText() + "\n" + ss);
    }

    public void addText2(String ss) {
        jtxt.setText(jtxt.getText() + ss);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JScrollPane();
        jtxt = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jgetfnames = new javax.swing.JButton();
        jtorom = new javax.swing.JButton();
        jload = new javax.swing.JButton();
        jsave = new javax.swing.JButton();

        jtxt.setColumns(20);
        jtxt.setRows(5);
        txt.setViewportView(jtxt);

        jgetfnames.setText("get file names");
        jgetfnames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgetfnamesActionPerformed(evt);
            }
        });

        jtorom.setText("to rom");
        jtorom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtoromActionPerformed(evt);
            }
        });

        jload.setText("load");
        jload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jloadActionPerformed(evt);
            }
        });

        jsave.setText("save");
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jgetfnames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtorom)
                .addGap(18, 18, 18)
                .addComponent(jsave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jload)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jgetfnames)
                    .addComponent(jtorom)
                    .addComponent(jload)
                    .addComponent(jsave))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
NewJFrame fr;
String shelp="";
    private void jgetfnamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgetfnamesActionPerformed
        // TODO add your handling code here:
        File ff = new File(fr.getpath());// + "/_ROM.extracted");
        File[] f2 = ff.listFiles();
        Arrays.sort(f2);
        int n = 0;
        String ss=shelp;
        for (int i = 0; i < f2.length; i++) {
            if (f2[i].getName().endsWith(".b") && f2[i].isFile()) {
                ss+="#"+f2[i].getName()+"\n";
            }
        }
        jtxt.setText(ss);
        jtxt.setCaretPosition(0);
    }//GEN-LAST:event_jgetfnamesActionPerformed

    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed
        // TODO add your handling code here:
        functions.str2file(this.jtxt.getText(), fr.getpath() + "commands.txt");
    }//GEN-LAST:event_jsaveActionPerformed

    private void jloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jloadActionPerformed
        // TODO add your handling code here:
        this.jtxt.setText(functions.file2str(fr.getpath() + "commands.txt"));
    }//GEN-LAST:event_jloadActionPerformed

    private void jtoromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtoromActionPerformed
        // TODO add your handling code here:
        if (fr.bb == null) {
            return;
        }
        String[] s2 = jtxt.getText().split("\n");

        String res = "";
        for (int j = 0; j < s2.length; j++) {

            String ssb = s2[j].split("\t")[0].split(" ")[0];
            if (ssb.startsWith("#")) {
                res += s2[j] + "\n";
                continue;
            }
            if (ssb.equals("")) {
                res += s2[j] + "\n";
                continue;
            }

            try {
                String ff2 = fr.getpath() //+ "/_ROM.extracted/" 
                        + ssb;
                String ff2c = ff2 + "c";
                String ff2ad = ssb.replace(".b", "").trim();
                String ss = "e -lc2 -d22 \"" + ff2 + "\" \"" + ff2c+"\"";
                myLog.Systemoutprintln(ss);
                LzmaAlone.exec(ss);

        //--------------------------------------------------------------
                int add2 = functions.str2int("#" + ff2ad);
                myLog.Systemoutprintln("=====" + ff2ad);
                String stablo = "";
                if (add2 < 0) {
                    stablo = "\terror";
                    return;
                }
                File ffa = new File(fr.getpath() + ff2ad + ".a");
                byte[] tbb = functions.file2byte(ff2c);
                for (int i = 0; i < tbb.length; i++) {
                    if (ffa.exists() && i >= ffa.length()) {
                        break;
                    }
                    fr.bb[add2 + i] = tbb[i];
                }
                if (ffa.exists()) {
                    if (tbb.length > ffa.length()) {
                        stablo = "\tfile is big\tfile=" + tbb.length + "\tplace=" + ffa.length();
                    } else {
                        stablo = "\tfile=" + tbb.length + "\tplace=" + ffa.length();
                    }
                }
                res += ssb + stablo + "\n";
            } catch (Exception e) {
                res += ssb + "\t"+e.toString() + "\n";
            }
        }
        jtxt.setText(res);
    }//GEN-LAST:event_jtoromActionPerformed


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
            java.util.logging.Logger.getLogger(txt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(txt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(txt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(txt1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new txt1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jgetfnames;
    private javax.swing.JButton jload;
    private javax.swing.JButton jsave;
    private javax.swing.JButton jtorom;
    private javax.swing.JTextArea jtxt;
    private javax.swing.JScrollPane txt;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokrocilyPriklad;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.swing.SwingWorker;

/**
 *
 * @author NcFerrari
 */
public class Tamagotchi extends javax.swing.JFrame {

    private TamagotchiModel model = null;
    private Operace operace;

    /**
     * Creates new form Tamagotchi
     */
    public Tamagotchi() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(ImagesEnum.ICON.getImageIcon().getImage());
        setVisible(true);
        model = new TamagotchiModel();

        feedPanel.setImageIcon(ImagesEnum.FEED.getImageIcon());
        feedPanel.setButtonText("NAKRMIT");
        feedPanel.updateProgressBar(model.getFeed());
        sleepPanel.setImageIcon(ImagesEnum.SLEEP.getImageIcon());
        sleepPanel.setButtonText("SPÁT");
        sleepPanel.updateProgressBar(model.getSleep());
        washPanel.setImageIcon(ImagesEnum.WASH.getImageIcon());
        washPanel.setButtonText("OKOUPAT");
        washPanel.updateProgressBar(model.getWash());
        walkPanel.setImageIcon(ImagesEnum.WALK.getImageIcon());
        walkPanel.setButtonText("JÍT SE PROJÍT");
        walkPanel.updateProgressBar(model.getWalk());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                PropertyToolkit.getInstance().put("alive", isPetAlive());
                PropertyToolkit.getInstance().put("feed", model.getFeed());
                PropertyToolkit.getInstance().put("lastFeeded", model.getLastFeed().toInstant(ZoneOffset.UTC).toEpochMilli());
                PropertyToolkit.getInstance().put("sleep", model.getSleep());
                PropertyToolkit.getInstance().put("lastSlept", model.getLastSlept().toInstant(ZoneOffset.UTC).toEpochMilli());
                PropertyToolkit.getInstance().put("wash", model.getWash());
                PropertyToolkit.getInstance().put("lastWashed", model.getLastWashed().toInstant(ZoneOffset.UTC).toEpochMilli());
                PropertyToolkit.getInstance().put("walk", model.getWalk());
                PropertyToolkit.getInstance().put("lastWalked", model.getLastWalked().toInstant(ZoneOffset.UTC).toEpochMilli());
            }
        });

        operace = new Operace();
        operace.execute();
    }

    public boolean isPetAlive() {
        return model.getFeed() > 0 && model.getWash() > 0 && model.getWalk() > 0 && model.getSleep() > 0;
    }

    public TamagotchiModel getModel() {
        return model;
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        feedPanel = new pokrocilyPriklad.Panelek();
        sleepPanel = new pokrocilyPriklad.Panelek();
        washPanel = new pokrocilyPriklad.Panelek();
        walkPanel = new pokrocilyPriklad.Panelek();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAMAGOTCHI");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pokrocilyPriklad/source/pet.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(feedPanel);
        jPanel2.add(sleepPanel);
        jPanel2.add(washPanel);
        jPanel2.add(walkPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tamagotchi();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pokrocilyPriklad.Panelek feedPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private pokrocilyPriklad.Panelek sleepPanel;
    private pokrocilyPriklad.Panelek walkPanel;
    private pokrocilyPriklad.Panelek washPanel;
    // End of variables declaration//GEN-END:variables

    private class Operace extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            while (feedPanel.getjProgressBar1().getValue() > 0) {
//                model.setFeed(100 - (int) Duration.between(model.getLastFeed(), LocalDateTime.now()).toMinutes());
                model.setFeed(100 - (int) Duration.between(model.getLastFeed(), LocalDateTime.now()).toMinutes());
                feedPanel.updateProgressBar(model.getFeed());

//                model.setWalk(100 - (int) Duration.between(model.getLastWalked(), LocalDateTime.now()).toHours());
                model.setWalk(100 - (int) Duration.between(model.getLastWalked(), LocalDateTime.now()).toMinutes());
                walkPanel.updateProgressBar(model.getWalk());

//                model.setWash(100 - (int) Duration.between(model.getLastWashed(), LocalDateTime.now()).toDays());
                model.setWash(100 - (int) Duration.between(model.getLastWashed(), LocalDateTime.now()).toMinutes());
                washPanel.updateProgressBar(model.getWash());

//                model.setSleep(100 - (int) Duration.between(model.getLastSlept(), LocalDateTime.now()).toHours());
                model.setSleep(100 - (int) Duration.between(model.getLastSlept(), LocalDateTime.now()).toMinutes());
                sleepPanel.updateProgressBar(model.getSleep());
                Thread.sleep(1000);
            }
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataloader;
import java.awt.Event;
import javax.swing.*;
/**voldermort
 * 
 *
 * @author vinayak
 */
public class Search_Frame extends javax.swing.JFrame 
{/**
     * Creates new form Search_Frame
     */
    int index;
    boolean string;
    private static final String COLS[]={"MODEL NAME","MANFACTURER NAME","YEAR","CYCLINDERS","DESIGNERS","DRIVE WHEELS","ENGINE COOLANT","ENGINE LAYOUT","ENGINE MANUFACTURER","ENGINE POSITION","ENGINE TYPE","FRONT BRAKE DIAMETER","FUEL SYSTEM","FUEL TANK CAPACITY","GEAR BOX","GROUND CLEARANCE","HEIGHT","LENGHT","MAXIMUM SPEED","MILEAGE","NUMBER OF DOORS","REAR BRAKE DIAMETER","STEERING","TYRES FRONT","TYRES REAR","WEIGHT IN KG","WHEELBASE","WIDTH"};
     private static final String STR[]={"contains","does not contain","starts with","does not start with","ends with","does not end with","is","is not"};
   private static final String NBR[]={"between","not between","greater than","less than","equal to"};
   public String getQuery(String tab){
   String st="SELECT CAR_ID FROM "+tab+" WHERE ";
   String col="",cond="";
   switch((String)jComboBox1.getSelectedItem())
   {
       case "MODEL NAME":
                   col="MODEL_NAME";
                   break;
        case "MANUFACTURER NAME":
                   col="MAN_NAME";
                   break;
         case "YEAR":
                   col="YEAR";
                   break;
        case "CYCLINDERS":
                   col="CYCLINDERS";
                   break;
        case "DESIGNERS":
                   col="DESIGNERS";
                   break;
        case "DRIVE WHEELS":
                   col="DRIVE_WHEELS";
                   break;
         case "ENGINE COOLANT":
                   col="ENGINE_COOLANT";
                   break;
        case "ENGINE LAYOUT":
                   col="ENGINE_LAYOUT";
                   break;
         case "ENGINE MANUFACTURER":
                   col="ENGINE_MAN";
                   break;
        case "ENGINE POSITION":
                   col="ENGINE_POS";
                   break;
        case "ENGINE TYPE":
                   col="ENGINE_TYPE";
                   break;
        case "FRONT BRAKE DIAMETER":
                   col="FRONT_BRAKE_DIA";
                   break;
         case "FUEL SYSTEM":
                   col="FUEL_SYSTEM";
                   break;
        case "FUEL TANK CAPACITY":
                   col="FUEL_TANK_CAP";
                   break;
         case "GEAR BOX":
                   col="GEARBOX";
                   break;
        case "GROUND CLEARANCE":
                   col="GROUND_CLR_IN_MM";
                   break;
        case "HEIGHT":
                   col="HEIGHT_IN_MM";
                   break;
        case "LENGHT":
                   col="LENGHT_IN_MM";
                   break;
         case "MAXIMUM SPEED":
                   col="MAX_SPEED";
                   break;
        case "MILEAGE":
                   col="MILEAGE";
                   break;
         case "NUMBER OF DOORS":
                   col="NOD";
                   break;
        case "REAR BRAKE DIAMETER":
                   col="REAR_BRAKE_DIA";
                   break;
        case "STEERING":
                   col="STEERING";
                   break;
        case "TYRES FRONT":
                   col="TYRES_FRONT";
                   break;
         case "TYRES REAR":
                   col="TYRES_REAR";
                   break;
         case "WEIGHT":
                   col="WEIGHT_IN_KG";
                   break;
          case "WHEELBASE_IN_MM":
                   col="WHEELBASE_IN_MM";
                   break;
          case "WIDTH":
                   col="WIDTH_IN_MM";
                   break;
   
   }
   
   switch((String)jComboBox2.getSelectedItem())
   {
       case "contains":
           cond=" LIKE '%"+jTextField1.getText()+"%'";
           break;
       case "does not contain":
           cond=" NOT LIKE '%"+jTextField1.getText()+"%'";
           break;
       case "starts with":
           cond=" LIKE '"+jTextField1.getText()+"%'";
           break;
       case "does not start with":
           cond=" NOT LIKE '"+jTextField1.getText()+"%'";
           break;
       case "ends with":
           cond=" LIKE '%"+jTextField1.getText()+"'";
           break;
        case "does not end with":
           cond=" NOT LIKE '%"+jTextField1.getText()+"'";
           break;
        case "is":
           cond=" LIKE '"+jTextField1.getText()+"'";
           break;
        case "is not":
           cond=" NOT LIKE '"+jTextField1.getText()+"'";
           break;
        case "between":
            cond=" BETWEEN "+jTextField1.getText()+" AND "+ jTextField2.getText();
            break;
        case "not between":
            cond=" NOT BETWEEN "+jTextField1.getText()+" AND "+ jTextField2.getText();
            break;
        case "greater than":
           cond=" > "+jTextField1.getText()+"";
           break;
        case "less than":
           cond=" < "+jTextField1.getText()+"";
           break;
        case "equal to":
           cond=" < "+jTextField1.getText()+"";
           break;
   }
   st=st+col+cond;
       return st;
   }
     public Search_Frame() {
        
        initComponents();
        
        setAllValuesc();
        setVisible(true);
    }
    
    public void setAllValuesc(){
    jComboBox1.removeItem("Item 1");                        //since we cannot edit the netbeans code we will have to remove items from here
    jComboBox1.removeItem("Item 2");
    jComboBox1.removeItem("Item 3");
    jComboBox1.removeItem("Item 4");
    jComboBox2.removeItem("Item 1");                        //since we cannot edit the netbeans code we will have to remove items from here
    jComboBox2.removeItem("Item 2");
    jComboBox2.removeItem("Item 3");
    jComboBox2.removeItem("Item 4");
    jComboBox2.setEnabled(false);
    jTextField1.setEnabled(false);
    jTextField2.setEnabled(false);
    for(int i=0;i<COLS.length;i++)
    {
    jComboBox1.addItem(COLS[i]);
    
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 26));

        jLabel1.setText("jLabel1");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO afdd your handling code here:
        String t=(String)jComboBox1.getSelectedItem();
       // System.out.println(t);
        jComboBox2.setEnabled(false);
        jComboBox2.removeAllItems();
    jTextField1.setEnabled(false);
    jTextField2.setEnabled(false);
       try{ switch(t){
            case "FRONT BRAKE DIAMETER":
            case "REAR BRAKE DIAMETER":
            case "HEIGHT":
            case "LENGHT":
            case "GROUND CLEARANCE":
            case "MAXIMUM SPEED":
            case "MILEAGE":
            case "NUMBER OF DOORS":
            case "FUEL TANK CAPACITY":
            case "WIDTH":
            case "YEAR":
            case "WEIGHT IN KG":
            case "WHEELBASE":
                string=false;
                for(int i=0;i<NBR.length;i++)
    {
    jComboBox2.addItem(NBR[i]);
    
    }
                jComboBox2.setEnabled(true);
    jTextField1.setEnabled(true);
    jTextField2.setEnabled(true);
                break;
            case "":
                break;
            default:
                string=true;
                for(int i=0;i<STR.length;i++)
    {
    jComboBox2.addItem(STR[i]);
    
    }
                jComboBox2.setEnabled(true);
    jTextField1.setEnabled(true);
    //jTextField2.setEnabled(true);
        }}catch(NullPointerException e){
        
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String t=(String)jComboBox2.getSelectedItem();
        jTextField1.setEnabled(false);
    jTextField2.setEnabled(false);
    //System.out.println(t);
    try{switch(t){
        case "between":
        case "not between":
        jTextField2.setEnabled(true);
        jTextField1.setEnabled(true);
            break;
        default:
            jTextField1.setEnabled(true);
         
    
    }}
    catch(NullPointerException e){
    
    }
    jTextField1.setText("");
    jTextField2.setText("");
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //System.out.println(getQuery("CAR_DATA"));
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
            java.util.logging.Logger.getLogger(Search_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Search_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

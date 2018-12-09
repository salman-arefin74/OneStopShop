import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class TableClass extends javax.swing.JFrame {
Connection connect;
    
    String tableName;
    
    public TableClass(Connection c) {
        this.connect = c;
        initComponents();
        showTable();
        
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableComboBox2 = new javax.swing.JComboBox<>();
        insertBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateBtn = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();
        txtInput2 = new javax.swing.JTextField();
        queryBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tableComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableComboBox2ActionPerformed(evt);
            }
        });

        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        txtInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInput2ActionPerformed(evt);
            }
        });

        queryBtn.setText("QUERY");
        queryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtInput2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insertBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tableComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(queryBtn)
                        .addGap(43, 43, 43)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insertBtn)
                        .addGap(61, 61, 61)
                        .addComponent(deleteBtn)
                        .addGap(33, 33, 33)
                        .addComponent(txtInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(queryBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableComboBox2ActionPerformed
        tableName = tableComboBox2.getSelectedItem().toString();
       
        try{
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from "+tableName);
           
            jTable1.setModel(buildTableModel(rs));

            
            
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_tableComboBox2ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try{
            int row = jTable1.getSelectedRow();
            int col = 0;
            Object value = jTable1.getValueAt( row, col );

            String colName= jTable1.getModel().getColumnName(0);

            String query ="delete from "+tableName+" where "+colName+" = "+ value+"";
            try {
                PreparedStatement preparedStmt = connect.prepareStatement(query);
                preparedStmt.execute();

                JOptionPane.showMessageDialog(null, "Deleted");

                try{
                    tableName = tableComboBox2.getSelectedItem().toString();
                    Statement statement = connect.createStatement();
                    ResultSet rs = statement.executeQuery("select * from "+tableName);
                    jTable1.setModel(buildTableModel(rs));
                }
                catch(Exception e){

                }


            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No Row Selected");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No Row Selected");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        String values = txtInput.getText().toString();

        try{

            String col_name="";

            String query1="SELECT * FROM "+tableComboBox2.getSelectedItem();
            PreparedStatement pStatement =  connect.prepareStatement(query1);
            //Statement pStatement2=(Statement) connection.createStatement();
            ResultSet rs =pStatement.executeQuery();
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int col = md.getColumnCount();
            System.out.println("Number of Column : "+ col);
            System.out.println("Columns Name: ");
            for (int i = 1; i <= col; i++){
                col_name += md.getColumnName(i);
                if(i<col)
                col_name+=",";
            }
           // System.out.println("col name===="+col_name);
            String query2="SET FOREIGN_KEY_CHECKS=0;";
            pStatement =  connect.prepareStatement(query2);
            //Statement pStatement2=(Statement) connection.createStatement();
            rs =pStatement.executeQuery();

            String query = "INSERT INTO "+tableComboBox2.getSelectedItem()+" ("+col_name+") VALUES("+values+");";
            System.out.println(query);
            pStatement =  connect.prepareStatement(query);
            pStatement.executeUpdate();

            System.out.println("Successfully Inserted..");
            JOptionPane.showMessageDialog(null,"Successfully Inserted");
           
            tableName = tableComboBox2.getSelectedItem().toString();
            try{
            Statement statement = connect.createStatement();
                     rs = statement.executeQuery("select * from "+tableName);
                    jTable1.setModel(buildTableModel(rs));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }catch(Exception e){
            System.out.println("Error in inserting.");
            JOptionPane.showMessageDialog(null,"Successfully Inserted");
            e.printStackTrace();
        }
        txtInput.setText(null);
    
       
       
    }//GEN-LAST:event_insertBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        String cname= jTable1.getModel().getColumnName(col);
        System.out.println("row= "+row+" col = "+col+"column name= "+cname);
        Object value = jTable1.getValueAt( row, col );
        System.out.println("value = "+value);
        try{
            String query2="SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement pStatement =  connect.prepareStatement(query2);
            //Statement pStatement2=(Statement) connection.createStatement();
            pStatement.executeQuery();

            String query ="update "+tableComboBox2.getSelectedItem()
            +" set "+cname+"="+ txtInput2.getText().toString()
            +" where "+cname+" = '"+ value+"' ;";
            System.out.println("query= "+query);
            pStatement=connect.prepareStatement(query) ;

            //Statement pStatement2=(Statement) connection.createStatement();
            pStatement.executeUpdate();
            try{
                    tableName = tableComboBox2.getSelectedItem().toString();
                    Statement statement = connect.createStatement();
                    ResultSet rs = statement.executeQuery("select * from "+tableName);
                    jTable1.setModel(buildTableModel(rs));
                    JOptionPane.showMessageDialog(null, "Sucessfully Updated");
                }
                catch(Exception e){

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        txtInput2.setText(null);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void txtInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInput2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInput2ActionPerformed

    private void queryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryBtnActionPerformed
        QueryForm qp = new QueryForm(connect);
       qp.setVisible(true);
       
    }//GEN-LAST:event_queryBtnActionPerformed

   public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    
    ArrayList<String> tbName = new ArrayList<String>();
    public void showTable() {
        try {
            DatabaseMetaData md = connect.getMetaData();
            ResultSet rst = md.getTables(null, null, "%", null);
            while (rst.next()) {
              tbName.add(rst.getString(3));
              System.out.println(rst.getString(3));
              
            }
            
            tableComboBox2.setModel(new DefaultComboBoxModel( tbName.toArray()));
        }
        catch(Exception e){
            e.printStackTrace();
        }       
    }
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
            java.util.logging.Logger.getLogger(TableClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableClass(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton queryBtn;
    private javax.swing.JComboBox<String> tableComboBox2;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtInput2;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

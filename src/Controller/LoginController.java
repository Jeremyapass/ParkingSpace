//proses yang ada di inputan
//manipulasi nilai-nilai yang ada dalam JText,JLabel, dll
package Controller;

import Model.LoginModel;
import View.HomeView;
import View.LoginView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginController {
    Connection con = null;
    Statement st = null;
    
    private LoginModel model;

    public void setModel(LoginModel model) {
        this.model = model;
    }
    
    public void resetCA(LoginView view){
        String CAEmail = view.getCAEmail().getText();
        String CAName = view.getCAName().getText();
        String CAPassword = view.getCAPassword().getText();
        
        if(CAEmail.equals("") && CAName.equals("") && CAPassword.equals("")){           
        }else{
            model.resetCA();
        }
    }
    
//SIGN IN 
    public void SignIn(LoginView view){
        String SIEmail = view.getSIEmail().getText();
        String SIPassword = view.getSIPassword().getText();

        try {
            if (SIEmail.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Email Masih Kosong");
            } else if (SIPassword.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Password Masih Kosong");
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/parkingspace", "root", "");

                // Use a prepared statement with a SELECT query
                String query = "SELECT * FROM createaccount WHERE Email = ? AND Password = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, view.getSIEmail().getText());
                    preparedStatement.setString(2, view.getSIPassword().getText());

                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Check if the result set has any rows
                    if (resultSet.next()) {
                        // Email and password found in the database
                        HomeView homeView = new HomeView(view, true);
                        homeView.setVisible(true);
                        view.dispose();
                    } else {
                        // Email and/or password not found in the database
                        JOptionPane.showMessageDialog(view, "GA ADA DI DB");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
  
    
//SIGN IN
    
    
    
//CREATE ACCOUNT
    public void simpanCA(LoginView view){
        String CAEmail = view.getCAEmail().getText();
        String CAName = view.getCAName().getText();
        String CAPassword = view.getCAPassword().getText();      
        
        try{
            if (CAName.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Nama Masih Kosong");
            } else if (CAEmail.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Email Masih Kosong");
            } else if (CAPassword.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Password Masih Kosong");
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/parkingspace", "root","");
                String query = "insert into createaccount values ('"+view.getCAEmail().getText()+"', "
                        + "'"+view.getCAName().getText()+"', '"+view.getCAPassword().getText()+"')";
                st = con.createStatement();
                int SA = st.executeUpdate(query);
                        
                model.simpanCA();
            }
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
//CREATE ACCOUNT


//FORGOT PASSWORD
    
    
//FORGOT PASSWORD

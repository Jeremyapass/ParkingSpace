package Controller;

import Model.HomeModel;
import View.DCarPlat;
import View.HomeView;
import View.LoginView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class HomeController {
    Connection con = null;
    Statement st = null;
    
    private HomeModel model;

    public void setModel(HomeModel model) {
        this.model = model;
    }
    
    
//CAR PLAT
public void CarPlat(HomeView view){
        LoginView loginView = new LoginView();
        DCarPlat dCarPlatDialog = new DCarPlat(loginView, true); 
        dCarPlatDialog.setVisible(true);
    }
//CAR PLAT    
    
}

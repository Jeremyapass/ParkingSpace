package Model;
//tempat functionnya dibuat
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Event.LoginListener;
/**
 *
 * @author MSI KATANA
 */
public class LoginModel {
    private String CAEmail;    
    private String CAName;
    private String CAPassword;
    private String SIEmail;
    private String SIPassword;
    
    //listener yang dideklarasi
    private LoginListener LoginListener;

    public LoginListener getLoginListener() {
        return LoginListener;
    }
    public void setLoginListener(LoginListener LoginListener) {
        this.LoginListener = LoginListener;
    }
    
    //CA
    public String getCAEmail() {
        return CAEmail;
    }
    public String getCAName() {
        return CAName;
    }
    public String getCAPassword() {
        return CAPassword;
    }
    public void setCAEmail(String CAEmail) {
        this.CAEmail = CAEmail;
        fireOnChange();
    }
    public void setCAName(String CAName) {
        this.CAName = CAName;
        fireOnChange();
    }
     public void setCAPassword(String CAPassword) {
        this.CAPassword = CAPassword;
        fireOnChange();
    }
    //CA
    
    
    //SI
    public String getSIEmail() {
        return SIEmail;
    }
    public String getSIPassword() {
        return SIPassword;
    }    
    public void setSIEmail(String SIEmail) {
        this.SIEmail = SIEmail;
        fireOnChange();
    }
    public void setSIPassword(String SIPassword) {
        this.SIPassword = SIPassword;
        fireOnChange();
    }
    //SI
    
    //validasi perubahan data
    protected void fireOnChange(){
        if(LoginListener != null){
            LoginListener.onChange(this);
        }
    }
    
    //Aksi ketika tombol" dijalankan
    
//SIGN IN
    public void SignIn(){
        
    }


//SIGN IN    
    
    
    
//CREATE ACCOUNT
    public void resetCA(){
        setCAEmail("");    
        setCAName("");
        setCAPassword("");
        ;
    }
    
    public void simpanCA(){
        JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
        resetCA();
    }
}
//CREATE ACCOUNT



//FORGOT PASSWORD


//FORGOT PASSWORD

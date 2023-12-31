package Controller;

import Model.DCarPlatModel;
import View.DCarPlat;
import View.LoginView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DCarPlatController {
    Statement st = null;
    Connection con = null;
    private DCarPlatModel model;
    public void setModel(DCarPlatModel model) {
        this.model = model;
    }
    

   public void DaftarPlat(DCarPlat view) {
    // Menggunakan SIEmail dari LoginView
    String Email = view.getEmail().getText();
    String Plat = view.getPlat().getText();

    try {
        if (Email.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Email masih kosong");
        }else if (Plat.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Plat yang Akan Didaftarkan Tidak Boleh Kosong");
        } else {
            Class.forName("com.mysql.jdbc.Driver");

            // Gunakan try-with-resources untuk koneksi
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/parkingspace", "root", "")) {
                // Gunakan prepared statement dengan UPDATE query
                String query = "UPDATE createaccount SET Plat = ? WHERE Email = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, Plat); // Set nilai Plat yang baru
                    preparedStatement.setString(2, Email); // Gunakan Email sebagai kondisi WHERE

                    // Eksekusi query UPDATE
                    int rowsAffected = preparedStatement.executeUpdate();

                    // Periksa apakah ada baris yang terpengaruh
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(view, "Plat berhasil diupdate");
                        // Tambahkan logika tambahan jika perlu

                        // Menutup JDialog setelah berhasil mendaftar
                        view.dispose();
                    } else {
                        JOptionPane.showMessageDialog(view, "Email tidak ditemukan");
                    }
                }
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}


    
}

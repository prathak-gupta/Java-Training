package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
	
    public void addDoctor(Doctor doc) throws SQLException {
        String query = "INSERT INTO Doctor (name, speciality, contact) VALUES (?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            
            psmt.setString(1, doc.getName());
            psmt.setString(2, doc.getSpeciality());
            psmt.setString(3, doc.getContact());
            psmt.executeUpdate();
        }
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctor";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(query)) {
            
            while (rs.next()) {
                Doctor doc= new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("speciality"),rs.getString("contact"));
                doctors.add(doc);
            }
        }
        return doctors;
    }

    public void updateDoctor(Doctor doc) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed.");
	        return;
	    }
	    String query = "UPDATE Doctor SET name = ?, speciality = ?, contact= ? WHERE id = ?";
	    try {
	        PreparedStatement psmt = conn.prepareStatement(query);
	        psmt.setString(1, doc.getName());
	        psmt.setString(2, doc.getSpeciality());
	        psmt.setString(3, doc.getContact());
	        psmt.setInt(4, doc.getId());
	        psmt.executeUpdate();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
    }
    
    public void deleteDocotr(int id) throws SQLException {
        String query = "DELETE FROM Doctor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }
    }

}

package HMSystem;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO Patient (f_name, l_name, age, gender, contact_number) VALUES (?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            
            psmt.setString(1, patient.getFname());
            psmt.setString(2, patient.getLname());
            psmt.setInt(3, patient.getAge());
            psmt.setString(4, patient.getGender());
            psmt.setString(5, patient.getContactNumber());
            psmt.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patient";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(query)) {
            
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("id"), rs.getString("f_name"), rs.getString("l_name"),
                                              rs.getInt("age"), rs.getString("gender"), rs.getString("contact_number"));
                patients.add(patient);
            }
        }
        return patients;
    }

    public void updatePatient(Patient patient) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed.");
	        return;
	    }
	    String query = "UPDATE Patient SET f_name = ?, l_name = ?, age = ?, gender = ?, contact_number = ? WHERE id = ?";
	    try {
	        PreparedStatement psmt = conn.prepareStatement(query);
	        psmt.setString(1, patient.getFname());
	        psmt.setString(2, patient.getLname());
	        psmt.setInt(3, patient.getAge());
	        psmt.setString(4, patient.getGender());
	        psmt.setString(5, patient.getContactNumber());
	        psmt.setInt(6, patient.getId());
	        psmt.executeUpdate();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
    }
    
    public void deletePatient(int id) throws SQLException {
        String query = "DELETE FROM Patient WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }
    }
}

package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    public void addStaff(Staff staff) throws SQLException {
        String query = "INSERT INTO Staff(name, role, contact_number) VALUES (?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            
            psmt.setString(1, staff.getName());
            psmt.setString(2, staff.getRole());
            psmt.setString(3, staff.getContact());
            psmt.executeUpdate();
        }
    }

    public List<Staff> getAllStaff() throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM Staff";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement smt = conn.createStatement();
             ResultSet rs = smt.executeQuery(query)) {
            
            while (rs.next()) {
                Staff staff= new Staff(rs.getInt("id"), rs.getString("name"), rs.getString("role"), rs.getString("contact_number"));
                staffList.add(staff);
            }
        }
        return staffList;
    }

    public void updateStaff(Staff staff) throws SQLException {
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database Connection Failed.");
	        return;
	    }
	    String query = "UPDATE Staff SET name= ?, role = ?, contact_number = ? WHERE id = ?";
	    try {
	        PreparedStatement psmt = conn.prepareStatement(query);
	        psmt.setString(1, staff.getName());
	        psmt.setString(2, staff.getRole());
	        psmt.setString(3, staff.getContact());
	        psmt.setInt(4, staff.getId());
	        psmt.executeUpdate();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
    }
    
    public void deleteStaff(int id) throws SQLException {
        String query = "DELETE FROM Staff WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }
    }
}

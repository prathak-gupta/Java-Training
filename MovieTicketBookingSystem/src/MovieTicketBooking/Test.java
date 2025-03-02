package MovieTicketBooking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Scanner;

public class Test {

	static void callProcedure1()
	{
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
            cstmt = conn.prepareCall("{CALL GetMovieName2(?, ?)}");
            System.out.print("Enter your movie id: ");
            Scanner scanner = new Scanner(System.in);
            int movieId = scanner.nextInt();
            cstmt.setInt(1, movieId);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.execute();
            String title = cstmt.getString(2);
            System.out.println("Movie Name: " + title);
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	static void callProcedure2()
	{
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
            cstmt = conn.prepareCall("{CALL GetMovieTitleGenre2(?, ?, ?)}");
            System.out.print("Enter your movie Id: ");
            Scanner sc = new Scanner(System.in);
            int movieId = sc.nextInt();
            cstmt.setInt(1, movieId);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);
 
            cstmt.execute();
            String title = cstmt.getString(2);
            String genre = cstmt.getString(3);
            System.out.println("Movie Title: " + title);
            System.out.println("Movie Genre: " + genre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	static void step3CallProcedure()
	{
		Connection conn;
        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }

            CallableStatement cstmt = conn.prepareCall("{CALL Step3(?)}");
            System.out.print("Enter your username: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.next();
            scanner.nextLine();
            cstmt.setString(1, username);
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()) {
            	int bookingId=rs.getInt("booking_id");
				String user=rs.getString("user_name");
				String showId=rs.getString("show_id");
				Timestamp bookingDate=rs.getTimestamp("booking_date");
				int seatsBooked=rs.getInt("seats_booked");
				System.out.println("[Booking ID=" + bookingId + ", User=" + user + 
		                   ", Show ID=" + showId + ", Booking Date=" + bookingDate + 
		                   ", Seats Booked=" + seatsBooked+"]");
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	static void  step4CallProcedure()
	{
    	Connection conn = DatabaseConnection.getConnection();
    	CallableStatement cstmt;
    	Scanner sc = new Scanner(System.in);
        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
        cstmt = conn.prepareCall("{CALL step4(?)}");
        System.out.print("Enter your booking ID to cancel tickets: ");
        int bookingID = sc.nextInt();
        cstmt.setInt(1, bookingID);
        cstmt.execute();
 
        System.out.println("Ticket canceled successfully for booking ID: " + bookingID);
    } catch (SQLException e) {
        e.printStackTrace();
        }
    	
	}
	
	public static void main(String[] args) {
//		callProcedure1();
//		callProcedure2();
//		step3CallProcedure();
		step4CallProcedure();
	}
}

package MovieTicketBooking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StoredProcedureCallable {


	
	public static void testStoredProcedure()
	{
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		String procedure = "CREATE PROCEDURE GetMovieName2(IN movieId INT, OUT name VARCHAR(20))"
	    		+ "BEGIN"
	    		+ " SELECT title into name from movies "
	    		+ "WHERE movie_id = movieId;"
	    		+ "END;";
		try {
			Statement smt = conn.createStatement();
			smt.execute(procedure);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Stored Procedure is created..");
		
	}
	
	public static void testStoredProcedure2()
	{
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed.");
			return;
		}

		try {
			String procedure = "CREATE PROCEDURE GetMovieTitleGenre2(IN movieId INT, OUT movietitle VARCHAR(255), OUT movieGenre VARCHAR(255)) "
                    + "BEGIN "
                    + "SELECT title, genere INTO movietitle, movieGenre FROM movies "
                    + "WHERE movie_id = movieId; "
                    + "END;";
		   Statement stmt = conn.createStatement();
		   stmt.execute(procedure);
		   System.out.println("Stored procedure created successfully.");
		}
		catch(SQLException e) {
		       e.printStackTrace();
		       }
	}

	static void testStoredProcedure3()
	{
		//Fetch bookings..
			Connection conn = DatabaseConnection.getConnection();
			if(conn==null) {
				System.out.println("Database Connection Failed.");
				return;
			}
			try {
				String procedure = "CREATE PROCEDURE Step3(IN user VARCHAR(25)) "
	                    + "BEGIN "
	                    + "     SELECT * from bookings WHERE user_name = user; "
	                    + "END;";
				Statement smt=conn.createStatement();
				smt.execute(procedure);
				System.out.println("procedure created");
			}
			catch(SQLException e) {
			       e.printStackTrace();
	       }
	}


	static void testStoredProcedure4()
	{
		//ticket cancellation..
		Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }

        try {
            String procedure = "CREATE PROCEDURE step4(IN bookingID INT) "
                    + "BEGIN "
                    + "UPDATE shows SET available_seats = available_seats + (SELECT seats_booked FROM bookings WHERE booking_id = bookingID) "
                    + "WHERE show_id = (SELECT show_id FROM bookings WHERE booking_id = bookingID); "
                    + "DELETE FROM bookings WHERE booking_id = bookingID; "
                    + "END;";

			Statement smt=conn.createStatement();
            Statement stmt = conn.createStatement();
            stmt.execute(procedure);
            System.out.println("Stored procedure for Cancelling Ticket (step4) created successfully.");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
	}

	public static void main(String[] args)
	{
		testStoredProcedure4();
	}
}

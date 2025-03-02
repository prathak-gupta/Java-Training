package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingCancellation {

	public static void cancelBookings(String next) {
		// TODO Auto-generated method stub
		String query = "SELECT seats_booked, show_id from bookings where user_name=\'"+next+"\';";
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		try(Statement smt = conn.createStatement())
		{
			ResultSet rs = smt.executeQuery(query);
			rs.next();
			int sb = rs.getInt("seats_booked");
			int sid = rs.getInt("show_id");
			// delete from table and update seats in shows table..
			query = "update shows set available_seats = available_seats +"+sb+" where show_id="+sid+";";
			try(PreparedStatement smt2 = conn.prepareStatement(query))
			{
				smt2.executeUpdate();
				System.out.println("Seats Updated in shows table..");
			}
			
			query = "delete from bookings where user_name=\'"+next+"\';";
			try(PreparedStatement smt2 = conn.prepareStatement(query))
			{
				smt2.executeUpdate();
				System.out.println("Booking deleted in bookings table..");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BOOKING CANCELLED SUCCESSFULLY..");
	}

}

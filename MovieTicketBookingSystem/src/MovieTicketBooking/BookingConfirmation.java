package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class BookingConfirmation {

	public static void checkConfirmation(String next) {
		// TODO Auto-generated method stub
		String query = "SELECT b.user_name, b.booking_id, m.title, s.show_time, b.seats_booked "
                + "FROM bookings b "
                + "INNER JOIN shows s ON b.show_id = s.show_id "
                + "INNER JOIN movies m ON s.movie_id = m.movie_id "
                + "WHERE b.user_name =\'"+next+"\';";

		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		try(Statement smt = conn.createStatement())
		{
			ResultSet rs = smt.executeQuery(query);
			if(rs.next())
			{
				String name = rs.getString("user_name");
				int bid = rs.getInt("booking_id");
				String title = rs.getString("title");
				Time t = rs.getTime("show_time");
				System.out.println("Booking Confirmation Slip:\nName: "+name+"\tBooking ID: "+bid+"\tTitle: "+title+"\tTime: "+t);
			}else
			{
				System.out.println("No Boooking found for "+next);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

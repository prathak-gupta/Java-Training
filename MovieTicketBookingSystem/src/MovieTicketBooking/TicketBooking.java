package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Table;

public class TicketBooking {
	public static void createBooking()
	{
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		ShowAvailableMovies.displayShows();
		System.out.println("Chose show id: ");
		Scanner sc = new Scanner(System.in);
		int sid = sc.nextInt();
		String fetchQuery = "select available_seats from shows where show_id="+sid+";";
		try(Statement smt = conn.createStatement())
		{
			ResultSet rs = smt.executeQuery(fetchQuery);
			rs.next();
			int available_seats = rs.getInt("available_seats");
			System.out.println("Available seats: "+available_seats);System.out.println("How many seats you want to book?");
			int book_seats = sc.nextInt();
			if(book_seats<= available_seats)
			{
				System.out.println("Enter your user name: ");
				String usrnm = sc.next();
				String insertQuery = "insert into bookings(user_name, show_id, seats_booked, booking_date) values(?,?,?,?);";
				try(PreparedStatement psmt = conn.prepareStatement(insertQuery)){
					psmt.setString(1, usrnm);
					psmt.setInt(2, sid);
					psmt.setInt(3, book_seats);
					psmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.of(2025, 2,15, 18,30)));
					psmt.executeUpdate();
					System.out.println("New booking is added in Bookings table..");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String insertQuery2= "update shows set available_seats = available_seats -"+book_seats+" where show_id="+sid+";";
				
				
				try(PreparedStatement psmt = conn.prepareStatement(insertQuery2)){
					psmt.executeUpdate();
					System.out.println("Seats Updated in shows Table..");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
			}
			else
			{
				System.out.println("Can't book seats more than available!!Try agian..");
				return;
			}
//			smt.close();
//			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BOOKING SUCCESSFULL, ENOY YOU SHOW!");
	}

	public static void showBookings() {
		// TODO Auto-generated method stub
		String fetchQuerry = "SELECT * from bookings";
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		
		try(Statement smt = conn.createStatement())
		{
			ResultSet rs = smt.executeQuery(fetchQuerry);
			int i=1;
			while(rs.next()){
				int bookid = rs.getInt("booking_id");
				String usrnm= rs.getString("user_name");
				int showid = rs.getInt("show_id");
				int sb = rs.getInt("seats_booked");
				Time t = rs.getTime("booking_date");
				System.out.println("Booking "+i+":\nBooking Id:"+bookid+"\tUsername: "+usrnm+"\t Seats Booked: "+sb+"\tBooking Date: "+t);
				i++;
			}
//			smt.close();
//			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}

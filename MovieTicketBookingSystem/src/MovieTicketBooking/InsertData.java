package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class InsertData {
	
	public static void insertMovies()
	{
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		
		String insertMoviesSQL = "INSERT into movies(title, genere, duration) values(?,?,?);"; // 1,2,3
		
		try {
			PreparedStatement psmt =conn.prepareStatement(insertMoviesSQL);
			//1 Entry
			psmt.setString(1, "Pushpa 3");
			psmt.setString(2, "Action");
			psmt.setInt(3, 150);
			psmt.executeUpdate();

			// 2 Entry
			psmt.setString(1, "Marco 3");
			psmt.setString(2, "Action");
			psmt.setInt(3, 250);
			psmt.executeUpdate();

			// 3 Entry
			psmt.setString(1, "Haunted 3");
			psmt.setString(2, "Horror");
			psmt.setInt(3, 250);
			psmt.executeUpdate();
			
//			psmt.close();
//			conn.close();
			System.out.println("Moves data inserted into movies table..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void insertShows()
	{
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		
		String insertShowsSQL = "insert into shows(movie_id, show_time, available_seats) values(?,?,?);";
		
		try(PreparedStatement psmt = conn.prepareStatement(insertShowsSQL)){
			
			//1 Entry
			psmt.setInt(1, 1);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025, 2,15, 18,30)));
			psmt.setInt(3, 250);
			psmt.executeUpdate();

			//2 Entry
			psmt.setInt(1, 2);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025, 2,15, 15,30)));
			psmt.setInt(3, 150);
			psmt.executeUpdate();

			//3 Entry
			psmt.setInt(1, 3);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025, 2,15, 12,30)));
			psmt.setInt(3, 100);
			psmt.executeUpdate();

			System.out.println("Shows data inserted into shows table..");
			
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		insertMovies();
		insertShows();
	}

}

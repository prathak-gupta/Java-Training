package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class ShowAvailableMovies {
	
	public static void displayShows()
	{
		String fetchQuerry = "SELECT * FROM movies m \n"
				+ " JOIN shows s \n"
				+ "ON m.movie_id=s.movie_id;";
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		try(Statement smt = conn.createStatement())
		{
			ResultSet rs = smt.executeQuery(fetchQuerry);
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Movie ID\tTitle\tGenre\tDuration\tShow ID\tAvail Seats\t Show time");
			System.out.println("-----------------------------------------------------------------------------------");
			while(rs.next()){
				int movieId = rs.getInt("movie_id");
				String title = rs.getString("title");
				String genere = rs.getString("genere");
				int duration = rs.getInt("duration");
				int show_id = rs.getInt("show_id");
				int av_seats = rs.getInt("available_seats");
				Time t = rs.getTime("show_time");
				
				System.out.println("   "+movieId + "\t\t" + title + "\t" + genere + "\t  " + duration + "m\t\t  " + show_id + "\t  " + av_seats+"\t\t  "+t);
			}
//			smt.close();
//			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		displayShows();
	}
}

package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTables {
	
	public static void createTables()
	{
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null)
		{
			System.out.println("Database Connection Failed!");
			return;
		}
		try {
			Statement smt = conn.createStatement();
			
			//Movies Table..
			String createMoviesTable = "CREATE TABLE IF NOT EXISTS movies ("
					+ "movie_id INT auto_increment PRIMARY KEY,"
					+ "title varchar(60) not null,"
					+ "genere varchar(20),"
					+ "duration INT not null"
					+ ");";
			smt.executeUpdate(createMoviesTable);
			
			//Shows Table..
			String createShowsTable = "CREATE TABLE IF NOT EXISTS shows ("
					+ "show_id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "movie_id INT,"
					+ "show_time DATETIME not null,"
					+ "available_seats int not null,"
					+ "Foreign KEY(movie_id) references movies(movie_id)"
					+");";
			smt.executeUpdate(createShowsTable);

			//Bookings Table..
			String createBookingsTable = "CREATE TABLE if not exists bookings ("
					+"booking_id INT AUTO_INCREMENT PRIMARY KEY,"
					+"user_name varchar(60),"
					+"show_id int not null,"
					+"seats_booked int not null,"
					+"booking_date timestamp default current_timestamp,"
					+"foreign key(show_id) references shows(show_id)"
					+");";
			smt.executeUpdate(createBookingsTable);
			
			smt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		createTables();
	}
}

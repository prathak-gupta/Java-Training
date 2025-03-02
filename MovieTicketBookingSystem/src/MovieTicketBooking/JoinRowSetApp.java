package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DatabaseConnection.getConnection();
		
		try {
	        CachedRowSet movies =RowSetProvider.newFactory().createCachedRowSet();
            CachedRowSet shows = RowSetProvider.newFactory().createCachedRowSet();
            
            movies.setCommand("select * from movies");
            shows.setCommand("select * from shows");
            
            movies.execute(conn);
            shows.execute(conn);
            
            conn.close();
            
            JoinRowSet jrs = RowSetProvider.newFactory().createJoinRowSet();
            movies.setMatchColumn("movie_id");
            shows.setMatchColumn("movie_id");
            jrs.addRowSet(movies);
            jrs.addRowSet(shows);
            
            while(jrs.next())
            {
				System.out.println("Id: "+jrs.getInt("movie_id")+"\tTitle: "+jrs.getString("title")+"\tGenre: "+jrs.getString("genere")+"\tDuration: "+jrs.getInt("duration")+"\tSeats Available: "+jrs.getInt("available_seats"));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

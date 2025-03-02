package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
	 
			
			try {
				Connection conn = DatabaseConnection.getConnection();
		        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		       rowSet.setUrl("jdbc:mysql://localhost:3306/Movie_booking");
		       rowSet.setUsername("root");
		       rowSet.setPassword("Genpact@123456789");
		        rowSet.setCommand("select * from movies");
		        rowSet.execute();
//		        while(rowSet.next())
//		        {
//		        	System.out.println("ID: "+ rowSet.getInt("movie_id"));
//		        }
//		        while(rowSet.previous())
//		        {
//		        	System.out.println("ID: "+ rowSet.getInt("movie_id"));
//		        }

		        rowSet.close();
		        
		        // ----------------------- Cached Row Set -----------------------
		        
		        CachedRowSet ct=RowSetProvider.newFactory().createCachedRowSet();
		        ct.setUrl("jdbc:mysql://localhost:3306/movie_booking");
			      ct.setUsername("root");
			      ct.setPassword("Genpact@123456789");
		        ct.setCommand("select * from movies");
		        
		        ct.execute();
		        
//		        conn.close(); // works after closing connection..
//		        while(ct.next()) {
//					System.out.println("ID: " + ct.getInt("movie_id"));
//				}
//				while(ct.previous()) {
//					System.out.println("ID: " + ct.getInt("movie_id"));
//				}

		        System.out.println("Working till here..");
//		        ct.beforeFirst();
		        while(ct.next()) {
		        	if(ct.getInt("movie_id") == 3) {
		        		ct.updateString("title", "Fighter");
		        		ct.updateRow();
		        	}
		        }

//		        conn = DatabaseConnection.getConnection();
//		        ct.acceptChanges(conn);
//		        conn.close();
		        ct.beforeFirst();
		        while(ct.next())
		        {
		        	System.out.println("ID: "+ ct.getInt("movie_id")+"\tTitle: "+ct.getString("title"));
		        }

				ct.close();
			}

			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	 
}

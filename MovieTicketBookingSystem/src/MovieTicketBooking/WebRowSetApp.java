package MovieTicketBooking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetApp {
	public static void main(String[] args)
	{
		Connection conn = DatabaseConnection.getConnection();
		
		try {
			WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
			
			wrs.setCommand("select * from movies");
			wrs.execute(conn);
			
			conn.close();
			System.out.println("Connection Closed..");
			
			FileWriter writer = new FileWriter("movies.xml");
			wrs.writeXml(writer);
			
			writer.close();
			
			WebRowSet wrs2 = RowSetProvider.newFactory().createWebRowSet();
			FileReader reader = new FileReader("movies.xml");
			wrs2.readXml(reader);
			
			while(wrs2.next())
			{
				System.out.println("Id: "+wrs2.getInt("movie_id")+"\tTitle: "+wrs2.getString("title")+"\tGenre: "+wrs2.getString("genere")+"\tDuration: "+wrs2.getInt("duration"));
			}

		}catch(SQLException e)
		{e.printStackTrace();} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

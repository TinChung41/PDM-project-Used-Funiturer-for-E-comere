


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Access {
	public static void main(String[] args)
	{
	 // connection to database
{	Formquery formquery = new Formquery();
	Formquery.getConnection();
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				formquery.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
}
}
}



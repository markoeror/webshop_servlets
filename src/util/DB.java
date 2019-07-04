package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private static DB instanca;
	private static final int MAX_CON=5;
	private static final Connection[]bafer = new Connection[MAX_CON];
	private int first=0;
	private int last=0;
	private int free=MAX_CON;
	

		private DB() {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				for(int i=0; i<MAX_CON; i++) {
					try {
						bafer[i]= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce2019","root","");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			public static DB getInstanca() {
				if(instanca == null) {
					instanca= new DB();			
				}
				return instanca;
			}
			
			public synchronized Connection getConnection() {  // ovde pravimo konekcije
				if(free == 0) {
					return null;	
				}
				free--;
				Connection con = bafer[first];
				first = (first+1)%MAX_CON;  // ostatak pri deljenju da bi stalno isla petlja od 0 do 4. tj od 1 do 5
				return con;
			 
			}
			
			public synchronized void putConnection(Connection con) { //Vracamo konekciju
				if(con == null) {
					return;
				}
				free++; // na pocetku je 0
				bafer[last] = con;
				last = (last+1)%MAX_CON;
			}
}

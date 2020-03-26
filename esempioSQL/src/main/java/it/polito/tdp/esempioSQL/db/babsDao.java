package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

public class babsDao {

	public List<Station> listStation(){
		String sql = "SELECT station_id, NAME, dockCount, landmark FROM station ORDER BY name";
		
		
		
        //String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root" ;
		
		List<Station> result=new ArrayList<Station>();
		try {
			//Connection conn = DriverManager.getConnection(jdbcURL);
			
			Connection conn = dbConnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res =st.executeQuery();
			
			while(res.next()) {
			Station s= new Station(res.getInt("station_id"),
					res.getString("name"),
					res.getInt("dockCount"),
					res.getString("landmark"));
			
			result.add(s);
			}
			st.close();
		
			conn.close();
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Station> listStationBylandmark(String landmark){                //qui ho specificato la selezione con WHERE
        String sql = "SELECT station_id, NAME, dockCount, landmark FROM station WHERE landmark= ? ORDER BY name";
		
		
        //String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root" ;
		
        List<Station> result=new ArrayList<Station>();
		try {
			//Connection conn = DriverManager.getConnection(jdbcURL);
			
			Connection conn = dbConnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, landmark);
			
			ResultSet res =st.executeQuery();
			
			while(res.next()) {
			Station s= new Station(res.getInt("station_id"),
					res.getString("name"),
					res.getInt("dockCount"),
					res.getString("landmark"));
			
			result.add(s);
			}
			st.close();
		
			conn.close();
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
}

package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import it.polito.tdp.esempioSQL.db.babsDao;

public class LeggiBabs {

	public void run() {
		
		/*String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root" ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			//PARTE 1. lezione
			/*Statement st = conn.createStatement();
			
			String sql="SELECT NAME FROM station ";
			
			ResultSet res =st.executeQuery(sql); //Ha la capacità di scaricare poco alla volta la query con un meccanisco a cursore
			*/
			
			
			//PARTE 2.lezione
			//String sql="SELECT NAME FROM station ";
			/*
			String sql="SELECT NAME FROM station WHERE landmark= ? "; // il ? indica un parametro da inserire
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, "Palo Alto");
			
			ResultSet res =st.executeQuery();
			
			while(res.next()) {
				String nomeStazione = res.getString("name");
				
				System.out.println(nomeStazione);
			}
			st.close(); //chiudo quando ho estratto ciò che mi serviva
			
			//Potrei fare una nuova query utilizzando la stessa connessione
			
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// FACTORY: creazione di una classe senza sapere il tipo di una classe
		//(non posso usare new) -> allora uso un metodo fornito da un'altra classe
		//che internamente farà new w conoscera il tipo della classe effettivo
		*/
		
		babsDao dao = new babsDao();
		
		List<Station> tutte = dao.listStation();
		
		for(Station s: tutte) {
			System.out.println(s.getName());
		}
		System.out.println("-----------");
		
		List<Station> selezionate = dao.listStationBylandmark("Palo Alto");
		
		for(Station s: selezionate) {
			System.out.println(s.getName());
		}
	}
	
	
	public static void main(String[] args) {
		LeggiBabs babs=new LeggiBabs();
		babs.run();
	}

}

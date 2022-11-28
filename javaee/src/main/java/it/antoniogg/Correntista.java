package it.antoniogg;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DICHIARO CORRENTISTA
public class Correntista {

	String nome;
	String cognome;
	String codice_fiscale;

	// METODO COSTRUTTORE
	public Correntista(String nome, String cognome, String codice_fiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codice_fiscale = codice_fiscale;
	}

	
	/*
	Connection connessione() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/banca";
			String name = "anto";
			String password = "gio";
			try {
				conn = DriverManager.getConnection(url, name, password);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	*/
//METODO INSERT GLI PASSIAMO LA CONNESSIONE E LA CLASE CORRENTISTA
	
	static void insert(Connection conn) throws IOException {
// QUERY PER INSERT DATI 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("CREAMO UTENTE ");
		
		System.out.println("ins nome");	
		String nome=br.readLine();
		
		System.out.println("ins cognome");	
		String cognome=br.readLine();
		
		System.out.println("ins codice fiscale");	
		String codice_fiscale=br.readLine();
		
		Correntista c=new Correntista(nome,cognome,codice_fiscale);
		
		String query_in = "INSERT INTO correntista(nome, cognome, codice_fiscale)VALUES(?,?,?)";

		PreparedStatement pstmt;
		// USIAMO TRY E CATCH PER
		try {
			pstmt = conn.prepareStatement(query_in);
/*
 * 
 * 
  */
			pstmt.setString(1, c.nome);

			pstmt.setString(2, c.cognome);

			pstmt.setString(3, c.codice_fiscale);
			
			pstmt.execute();
					

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally 
		       {
					try {
					conn.close();
							}
						catch (SQLException e) 
						{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		}
	}

	
	void stampa_correntista(Connection conn,Correntista cod) {
		
		String query_sel="SELECT * FROM `correntista`"; 
		
		PreparedStatement pstmt;
		// USIAMO TRY E CATCH PER
		try {
			pstmt = conn.prepareStatement(query_sel);
		

			try {

				pstmt.execute();

			} catch (Exception e) {

				System.out.println(e);

			}
			ResultSet result=pstmt.executeQuery();
			
			
			while(result.next())
			{
				System.out.println("ho fatto");
				System.out.println(result.getString(1)+""+result.getString(2)+""+result.getString(3));
			}

							try {
				
								pstmt.execute();
				
							} catch (Exception e) {
				
								System.out.println(e);
				
							}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally 
		       {
					try {
					conn.close();
							}
						catch (SQLException e) 
						{
									// TODO Auto-generated catch block
									e.printStackTrace();
		
						}
					}
	}
	
	
	
	
}




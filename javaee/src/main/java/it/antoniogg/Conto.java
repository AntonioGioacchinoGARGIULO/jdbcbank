package it.antoniogg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conto {
	
	String iban;
	String codice_fiscale_conto;
	String saldo;
	
	
	public Conto(String iban,String saldo,String codice_fiscale_conto) {
		super();
		this.iban=iban;					
		this.saldo=saldo;
		this.codice_fiscale_conto=codice_fiscale_conto;
	}
	


	



		public Conto(String iban1, int saldo2) {
		// TODO Auto-generated constructor stub
	}







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
		void st(Conto co) {

			Connection conn = connessione();
	//RICHIAMO METODO INSERT PASSANDO LA CONNESIONE E LA CLASSE xont
			
			ricerca_conto_stampa(conn, co);
		}	
		
		
	
	
		static void insertc(Connection conn) throws IOException {
			// QUERY PER INSERT DATI 
			// conto
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("CREAMO IL CONTO ");
			
			System.out.println("ins un IBAN per il conto ");	
			String iban=br.readLine();
	
		
		System.out.println("ins saldo");	
		String saldo=br.readLine();
		
		
		System.out.println("IMMETTERE CODICE FISCALE GIA' REGISTRATO");	
		String codice_fiscale_conto=br.readLine();	
		
		Conto cont= new Conto(iban,saldo,codice_fiscale_conto);	
			
						
					String query_in = "INSERT INTO `conto`(`iban`, `saldo`, `codice_fiscale_conto`) VALUES (?,?,?)";
					PreparedStatement pstmt;
					// USIAMO TRY E CATCH PER
					try {
						pstmt = conn.prepareStatement(query_in);
			/*
			 * 
			 * 
			  */
						pstmt.setString(1, cont.iban);
						pstmt.setString(2, cont.saldo);
						pstmt.setString(3, cont.codice_fiscale_conto);

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

		void ricerca_conto_stampa(Connection conn, Conto co) {
			
			String query_sel="SELECT * FROM `conto` WHERE codice_fiscale_conto=(?)  "; 
			
			PreparedStatement pstmt;
			// USIAMO TRY E CATCH PER
			try {
				pstmt = conn.prepareStatement(query_sel);
				pstmt.setString(3, co.codice_fiscale_conto);

				try {
	
					pstmt.execute();
	
				} catch (Exception e) {
	
					System.out.println(e);
	
				}
				ResultSet result=pstmt.executeQuery();
				
				
				while(result.next())
				{
					
					
					
					System.out.println(result.getString(1)+"");
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

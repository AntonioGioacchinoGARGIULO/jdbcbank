package it.antoniogg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movimenti {
	String iban1;
	String importo;
	String tipo_movimento;//PRELEVA DEPOSITA
	

	public Movimenti(String iban12, String importo2, String tipo_movimento2) {
		// TODO Auto-generated constructor stub
	}



	// METODO COSTRUTTORE
	public void Movimenti(String iban1, String importo, String tipo_movimento) {
		
		this.iban1 = iban1;
		this.importo = importo;
		this.tipo_movimento = tipo_movimento;
		
	}


	static void insert_mov(Connection conn) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		 System.out.println("IMMETTERE IBAN CONTO");	
			String 	iban1=br.readLine();
			
		 System.out.println("IMMETTERE IMPORTO");	
			String 	importo=br.readLine();	
			
			
				String 	tipo_movimento="PRELIEVO";
					
			
			Movimenti m=new Movimenti(iban1, importo, tipo_movimento);
		

		String query_in = "INSERT INTO `movimenti`(`iban`, `importo`, `tipo_movimento`) VALUES ('?','?','?')";

		PreparedStatement pstmt;
		// USIAMO TRY E CATCH PER
		try {
			pstmt = conn.prepareStatement(query_in);
			 
			
			pstmt.setString(1, m.iban1);
			pstmt.setString(2, m.importo);
			pstmt.setString(3, m.tipo_movimento);
		
			
			

				pstmt.execute();


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//UPDATE
		
		int saldo=saldo-importo;
		
		Conto u=new Conto(iban1, saldo);
		String query_up = "UPDATE `conto` SET `saldo`=('?') WHERE `iban`=('?') ";

		PreparedStatement prst;
		// USIAMO TRY E CATCH PER
		try {
			prst = conn.prepareStatement(query_up);
			
			
			prst.setString(1, u.iban1);
			prst.setString(2, u.importo);
			prst.setString(3, u.tipo_movimento);
		
			
			

			prst.execute();


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
	}


	void stampa_movimenti(Connection conn,Movimenti movi) throws IOException {
		
		
		
		String query_sel="SELECT * FROM `movimenti` "; 
		
		PreparedStatement pstmt;
		// USIAMO TRY E CATCH PER
		try {
			pstmt = conn.prepareStatement(query_sel);
			
			ResultSet result=pstmt.executeQuery();
			
			
			while(result.next())
			{
				System.out.println("ho fatto");
				System.out.println(result.getString(1)+""+result.getDouble(2)
				+""+result.getString(3)+""+result.getInt(4));
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
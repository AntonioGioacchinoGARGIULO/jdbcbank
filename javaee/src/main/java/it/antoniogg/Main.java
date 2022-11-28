package it.antoniogg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//buffer reader
		
		
		
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

			
		
		
		
		
		
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		/*
		
		System.out.println("ins codice fiscale da ricercare");	
		String cod_fis_ric=br.readLine();
		Correntista cod=new Correntista(null,null,cod_fis_ric);
		cod.inserisciselect(cod);
		*/
		// caricamento degli utenti e del conto
		// CARICARE LA SCELTA
		
		Scanner input=new Scanner(System.in);
		
		int scelta;
		
		System.out.print("RUBRICA \n 1 CREAZIONE UTENTE E CONTO \n 2 Ricerca per nome \n 3 Stampa \n 4 mod");
		scelta=input.nextInt();


		while(scelta!=1)
		{
		System.out.print("RUBRICA \n 1 Caricamento utenti e conto \n 2 Ricerca per nome \n 3 Stampa \n 4 mod");
		scelta=input.nextInt();


		}
		while(scelta!=5)
		{
		switch(scelta)
		{
			case 1:
// CREA IL TUO UTENTE			
				Correntista.insert(conn);				
				// CREA IL TUO CONTO				
			Conto.insertc(conn);
				break;
				
				
			 case 2:
				 //prelievo
				 					
					Movimenti.insert_mov(conn);
				
					
				break;
				
			
				    
				      case 3:
				    	  // MOVIMENTO 
				    	//  System.out.println("QUALE CONTO VUOI UTILIZZARE? \n INSERISCI IBAN DEL CONTO DESIDERATO ");	
						//	String iban_mov=br.readLine();
				    	 			 
				        break;
				        
				        case 4:
				      //STAMPA CONTO 
				        	
				     //   	cont.stampa_conto_(cont);	
				           break;
		}		 
			
		System.out.print("RUBRICA \n 1 Caricamento utenti e conto \n 2 Ricerca per nome \n 3 Stampa \n 4 mod");
		scelta=input.nextInt();

			}

		}

	
			
		
		
		
		
		
		
		
	}



package br.unip.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class ConnectionFactory {
	
	private static Connection con;
	
	public static Connection getConnection() {
//		String URL = "jdbc:sqlserver://localhost:1401;databaseName=dbPim";
		String URL = "jdbc:sqlserver://localhost:1401;databaseName=dbPim";

		con = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(URL, "sa", "Do123456ck");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro na tentativa de conectar com o banco!",
					"Erro",JOptionPane.ERROR_MESSAGE);
			System.out.println("1"+e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro na tentativa de conectar com o banco!",
					"Erro",JOptionPane.ERROR_MESSAGE);
			System.out.println("Não foi possível conectar ao banco "+e.getMessage());
		}
		return con;
	}
	
	public static void closeConnection() {
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Ocorreu um erro na tentativa de fechar a conexão com o banco!",
						"Erro",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}

}

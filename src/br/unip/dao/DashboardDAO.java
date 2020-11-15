package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.unip.jdbc.ConnectionFactory;
import br.unip.model.Dashboard;

public class DashboardDAO {

	private Connection con = ConnectionFactory.getConnection();
	
	public Dashboard getDadosHome(int idUsuario) {
		Dashboard dash = new Dashboard();
		dash.setValorOperacoes("00");
		
		String sqlNome = "SELECT usuario FROM usuarios WHERE id = ?";
		String sqlQtdClientes = "SELECT count(*) as qtdClientes FROM clientes";
		String sqlQtdOperacoes = "SELECT count(*) as qtdOperacoes FROM investimentos";
		String sqlValores = "SELECT sum(valor_corrente) as valor_corrente FROM investimentos";
		
		try (
				PreparedStatement stmNome = con.prepareStatement(sqlNome);
				PreparedStatement stmQtdClientes = con.prepareStatement(sqlQtdClientes);
				PreparedStatement stmQtdOperacoes = con.prepareStatement(sqlQtdOperacoes);
				PreparedStatement stmQtdValores = con.prepareStatement(sqlValores);
			) {
			
			// Dados do usuário			
			stmNome.setInt(1, idUsuario);
			try {				
				ResultSet rsNome = stmNome.executeQuery();
				if(rsNome.next()) {
					dash.setNomeUsuario(rsNome.getString("usuario"));
				}
				rsNome.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			stmNome.close();
			
			// Dados da home - quantidade de clientes
			try {				
				ResultSet rsQtdClientes = stmQtdClientes.executeQuery();
				if(rsQtdClientes.next()) {
					dash.setQtdClientes(rsQtdClientes.getString("qtdClientes"));
				}
				rsQtdClientes.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			stmQtdClientes.close();
			
			// Dados da home - quantidade de opecaoes no mes
			try {				
				ResultSet rsQtdOperacoes = stmQtdOperacoes.executeQuery();
				if(rsQtdOperacoes.next()) {
					dash.setQtdOperacoes(rsQtdOperacoes.getString("qtdOperacoes"));
				}
				rsQtdOperacoes.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			stmQtdOperacoes.close();
			
			// Dados da home - quanto foi operado no mes
			try {				
				ResultSet rsQtdValores = stmQtdValores.executeQuery();
				if(rsQtdValores.next()) {
					dash.setValorOperacoes(rsQtdValores.getString("valor_corrente"));
				}
				rsQtdValores.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmQtdValores.close();
			

			ConnectionFactory.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dash;
	}
}

package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.unip.jdbc.ConnectionFactory;
import br.unip.model.RankkingAtivos;
import br.unip.model.Usuario;

public class RelatoriosDAO {
	private Connection con = ConnectionFactory.getConnection();
	
	public ArrayList<RankkingAtivos> rankingAtivos(){
		ArrayList <RankkingAtivos> ranking = new ArrayList<>();
		
		String sql = "SELECT a.name, count(i.ativo_id) as quantidade "
				+ "FROM investimentos as i "
				+ "INNER JOIN ativos as a on a.id = i.ativo_id "
				+ "GROUP BY i.ativo_id, a.name "
				+ "ORDER BY quantidade DESC";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				RankkingAtivos ativo = new RankkingAtivos();
				ativo.setName(rs.getString("name"));
				ativo.setQuantidade(rs.getInt("quantidade"));
				
				ranking.add(ativo);
			}
			
			ConnectionFactory.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ranking;
	}
}

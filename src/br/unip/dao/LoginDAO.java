package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.unip.jdbc.ConnectionFactory;
import br.unip.model.Login;

public class LoginDAO {
	
	
	public int getLoginSenha(Login login) {
		Connection con = ConnectionFactory.getConnection();
		int id = 0;
		
		String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, login.getEmail());
			stm.setString(2, login.getSenha());
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("id");
			}
			
			if(id != 0) {
				JOptionPane.showMessageDialog(null, "Seja Bem Vindo !!");
			} else {
				JOptionPane.showMessageDialog(null,"E-mail e/ou senha incorretos");
			}
			
			rs.close();
			stm.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao tentar realizar o login");
			e.printStackTrace();
		}
		
		return id;
	}

}

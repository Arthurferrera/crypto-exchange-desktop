package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unip.jdbc.ConnectionFactory;
import br.unip.model.Usuario;

public class UsuarioDAO {
	private Connection con = ConnectionFactory.getConnection();

	public ArrayList<Usuario> listarUsuarios(){
		ArrayList <Usuario> usuarios = new ArrayList<>();
		
		String sql = "SELECT * FROM usuarios";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getString("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
				
				usuarios.add(usuario);
			}
			
			ConnectionFactory.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return usuarios;
	}

	public Usuario getUsuarioById(String id) {
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuarios"
				+"(usuario, email, senha)"
				+"values(?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, usuario.getUsuario());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			
			if(stm.execute()){
				JOptionPane.showMessageDialog(null, "Não foi possivel gravar os dados  \n do usuário!");
			}else{
				JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso!");
			}
			
			ConnectionFactory.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

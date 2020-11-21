package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unip.jdbc.ConnectionFactory;
import br.unip.model.Cliente;

public class ClienteDAO {
	private Connection con = ConnectionFactory.getConnection();

	public ArrayList<Cliente> listarClientes(){
		ArrayList <Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM clientes";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rs.getString("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
			}
			
			ConnectionFactory.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return clientes;
	}

	public Cliente getClienteById(String id) {
		Cliente cliente = new Cliente();
		
		String sql = "SELECT * FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setData_nascimento(rs.getString("data_nascimento"));
				cliente.setCelular(rs.getString("celular"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}

	public void cadastrar(Cliente cliente) {
		String sql = "insert into clientes"
				+"(nome, sobrenome, email, cidade, estado, celular, data_nascimento)"
				+"values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
//			stm.setString(1, cliente.getNome());
//			stm.setString(2, cliente.getEmail());
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getSobrenome());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getCidade());
			stm.setString(5, cliente.getEstado());
			stm.setString(6, cliente.getCelular());
			stm.setString(7, cliente.getData_nascimento());
			
			if(stm.execute()){
				JOptionPane.showMessageDialog(null, "Não foi possivel gravar os dados  \n do cliente!");
			}else{
				JOptionPane.showMessageDialog(null, "Cliente gravado com sucesso!");
			}
			
			ConnectionFactory.closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(Cliente cliente){
		String sql = "UPDATE clientes SET nome = ?, sobrenome = ?, email = ?, cidade = ?, estado = ?, celular = ?, data_nascimento = ? WHERE id = ? ";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getSobrenome());
			stm.setString(3, cliente.getEmail());
			stm.setString(4, cliente.getCidade());
			stm.setString(5, cliente.getEstado());
			stm.setString(6, cliente.getCelular());
			stm.setString(7, cliente.getData_nascimento());
			
			stm.setString(8, cliente.getId());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Não foi possivel editar!");
			} else {
				JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
			}
			ConnectionFactory.closeConnection();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(Cliente cliente){
		String sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getId());
			
			if(stm.execute()) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir o cliente!");
			} else {
				JOptionPane.showMessageDialog(null, "Cliente excluído!");
			}
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

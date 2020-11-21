package br.unip.estrutura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.UsuarioDAO;
import br.unip.model.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FrmUsuarios extends JFrame {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel tabModel;
	private JTable tabUsuarios;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	
	public FrmUsuarios(int idUsuario) {
		setResizable(false);
		setTitle("Crypto Echange");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 532, 94);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/br/unip/imagens/login48.png")));
		panelTitulo.add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("Módulo de Usuários");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panelTitulo.add(lblTitulo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 106, 510, 314);
		contentPane.add(tabbedPane);
		
		JPanel painelLista = new JPanel();
		tabbedPane.addTab("Lista de Usuários", null, painelLista, null);
		painelLista.setLayout(null);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Usuários", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(10, 11, 473, 183);
		painelLista.add(painelTabela);
		painelTabela.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 454, 150);
		painelTabela.add(scrollPane);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(null);
		painelBotoes.setBounds(10, 198, 708, 77);
		painelLista.add(painelBotoes);
		
		JButton btnNovo = new JButton("");
		btnNovo.setToolTipText("Clique para adicionar um usuáio");
		btnNovo.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/br/unip/imagens/add32.png")));
		btnNovo.setBounds(10, 17, 51, 49);
		painelBotoes.add(btnNovo);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Clique para excluir um usuário");
		btnExcluir.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/br/unip/imagens/excluir32.png")));
		btnExcluir.setBounds(75, 17, 51, 49);
		painelBotoes.add(btnExcluir);
		
		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Clique para editar um usuário");
		btnEditar.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/br/unip/imagens/editar32.png")));
		btnEditar.setBounds(144, 17, 51, 49);
		painelBotoes.add(btnEditar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(375, 20, 100, 40);
		painelBotoes.add(btnVoltar);
		
		JPanel painelDetalhes = new JPanel();
		tabbedPane.addTab("Detalhes do Usuário", null, painelDetalhes, null);
		painelDetalhes.setLayout(null);
		
		JPanel painelDados = new JPanel();
		painelDados.setBounds(6, 74, 473, 147);
		painelDetalhes.add(painelDados);
		painelDados.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(17, 25, 61, 16);
		painelDados.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(17, 46, 221, 26);
		painelDados.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(250, 25, 61, 16);
		painelDados.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(250, 46, 217, 26);
		painelDados.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(152, 84, 61, 16);
		painelDados.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(152, 102, 168, 26);
		painelDados.add(txtSenha);
		
		JPanel painelBotoesD = new JPanel();
		painelBotoesD.setBounds(6, 14, 473, 53);
		painelDetalhes.add(painelBotoesD);
		painelBotoesD.setLayout(null);
		
		JLabel lblStatus = new JLabel("Cadastrar");
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBounds(186, 20, 120, 14);
		painelBotoesD.add(lblStatus);
		
		JPanel painelBotoesD_1 = new JPanel();
		painelBotoesD_1.setLayout(null);
		painelBotoesD_1.setBounds(6, 229, 473, 33);
		painelDetalhes.add(painelBotoesD_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(260, 3, 99, 31);
		painelBotoesD_1.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(115, 3, 99, 31);
		painelBotoesD_1.add(btnCancelar);
		
		montarTabela();
		
		// eventos de botoes
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmDashboard dash = new FrmDashboard(idUsuario);
				dash.setVisible(true);
			}
		});
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				lblStatus.setText("Cadastrar");
				limparCampos();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tabUsuarios.getSelectedRow();
				if(linha >=0){
					lblStatus.setText("Atualizar Dados");
					tabbedPane.setSelectedIndex(1);
				}else{
					JOptionPane.showMessageDialog(null, "Por favor, selecione um usuário");
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
				lblStatus.setText("Cadastrar");
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNome.getText().equals("")||
					txtEmail.getText().equals("    ")||
					txtSenha.getText().equals("  :  ")){
					
					JOptionPane.showMessageDialog(null, "Por Favor, preencha todos os campos!");
					
				} else {
					Usuario usuario = new Usuario();
					usuario.setUsuario(txtNome.getText());
					usuario.setEmail(txtEmail.getText());
					usuario.setSenha(txtSenha.getText());
					
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					if(lblStatus.getText() == "Cadastrar"){
						usuarioDAO.cadastrar(usuario);
					} else if(lblStatus.getText() == "Atualizar Dados"){
						usuario.setId(tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0).toString());
						usuarioDAO.editar(usuario);
						lblStatus.setText("Cadastrar");
					}
					tabbedPane.setSelectedIndex(0);
					limparCampos();
					montarTabela();
				}
				
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linha = tabUsuarios.getSelectedRow();
				if(linha >=0){
					Usuario usuario = new Usuario();
					usuario.setId(tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0).toString());
					
					int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este usuário ?");
					
					if(resp == 0){
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						usuarioDAO.excluir(usuario);
					}
					
					
					montarTabela();
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir!");
				}
				
			}
		});
	}

	//M�TODOS  ESSENCIAIS
	public void montarTabela(){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarios = usuarioDAO.listarUsuarios();
		
		tabModel = new DefaultTableModel();
		tabUsuarios = new JTable(tabModel);
		tabUsuarios.setRowSelectionAllowed(false);
		
		tabModel.addColumn("ID");
		tabModel.addColumn("Nome");
		tabModel.addColumn("E-mail");
		
		tabUsuarios.getColumnModel().getColumn(0).setMinWidth(0); 
		tabUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);  
		tabUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
		
		for (Usuario usuario: usuarios){
			System.out.println(usuario.getUsuario());
			tabModel.addRow(new Object[]{usuario.getId(),usuario.getUsuario(), usuario.getEmail()});
		}
		scrollPane.setViewportView(tabUsuarios);
		tabUsuarios.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id;
				id = tabUsuarios.getValueAt(tabUsuarios.getSelectedRow(), 0).toString();
				preencherCampos(id);
			}
		});
	}
	
	public void preencherCampos(String id){
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuario = usuarioDAO.getUsuarioById(id);
		
		txtNome.setText(usuario.getUsuario());
		txtEmail.setText(usuario.getEmail());
		txtSenha.setText("");
	}
	
	public void limparCampos(){
		txtNome.setText("");
		txtEmail.setText("");
		txtSenha.setText("");
	}
}

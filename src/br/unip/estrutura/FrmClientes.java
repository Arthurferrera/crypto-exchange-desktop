package br.unip.estrutura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.ClienteDAO;
import br.unip.model.Cliente;

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

public class FrmClientes extends JFrame {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel tabModel;
	private JTable tabClientes;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtSobrenome;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtDataNascimento;
	private JTextField txtCelular;
	
	public FrmClientes(int idCliente) {
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
		lblNewLabel.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/unip/imagens/login48.png")));
		panelTitulo.add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("Módulo de Clientes");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panelTitulo.add(lblTitulo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 106, 510, 314);
		contentPane.add(tabbedPane);
		
		JPanel painelLista = new JPanel();
		tabbedPane.addTab("Lista de Clientes", null, painelLista, null);
		painelLista.setLayout(null);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
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
		btnNovo.setToolTipText("Clique para adicionar um cliente");
		btnNovo.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/unip/imagens/add32.png")));
		btnNovo.setBounds(10, 17, 51, 49);
		painelBotoes.add(btnNovo);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Clique para excluir um cliente");
		btnExcluir.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/unip/imagens/excluir32.png")));
		btnExcluir.setBounds(75, 17, 51, 49);
		painelBotoes.add(btnExcluir);
		
		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Clique para editar um cliente");
		btnEditar.setIcon(new ImageIcon(FrmClientes.class.getResource("/br/unip/imagens/editar32.png")));
		btnEditar.setBounds(144, 17, 51, 49);
		painelBotoes.add(btnEditar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(375, 20, 100, 40);
		painelBotoes.add(btnVoltar);
		
		JPanel painelDetalhes = new JPanel();
		tabbedPane.addTab("Detalhes do Cliente", null, painelDetalhes, null);
		painelDetalhes.setLayout(null);
		
		JPanel painelDados = new JPanel();
		painelDados.setBounds(6, 74, 473, 147);
		painelDetalhes.add(painelDados);
		painelDados.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(17, 25, 61, 16);
		painelDados.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(17, 46, 118, 26);
		painelDados.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(138, 25, 93, 16);
		painelDados.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(138, 46, 118, 26);
		painelDados.add(txtSobrenome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(260, 25, 61, 16);
		painelDados.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(260, 46, 207, 26);
		painelDados.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(17, 84, 61, 16);
		painelDados.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(17, 103, 118, 26);
		painelDados.add(txtCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(138, 87, 93, 16);
		painelDados.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(138, 103, 118, 26);
		painelDados.add(txtEstado);
		
		JLabel lblDataNasc = new JLabel("Dt. Nasc");
		lblDataNasc.setBounds(260, 84, 61, 16);
		painelDados.add(lblDataNasc);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(260, 103, 90, 26);
		painelDados.add(txtDataNascimento);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(350, 84, 93, 16);
		painelDados.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(350, 103, 118, 26);
		painelDados.add(txtCelular);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBounds(6, 14, 473, 53);
		painelDetalhes.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblStatus = new JLabel("Cadastrar");
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setBounds(186, 20, 120, 14);
		painelTitulo.add(lblStatus);
		
		JPanel painelBotoesTelaCadastro = new JPanel();
		painelBotoesTelaCadastro.setLayout(null);
		painelBotoesTelaCadastro.setBounds(6, 229, 473, 33);
		painelDetalhes.add(painelBotoesTelaCadastro);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(260, 3, 99, 31);
		painelBotoesTelaCadastro.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(115, 3, 99, 31);
		painelBotoesTelaCadastro.add(btnCancelar);
		
		montarTabela();
		
		// eventos de botoes
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmDashboard dash = new FrmDashboard(idCliente);
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
				int linha = tabClientes.getSelectedRow();
				if(linha >=0){
					lblStatus.setText("Atualizar Dados");
					tabbedPane.setSelectedIndex(1);
				}else{
					JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente");
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
					txtSobrenome.getText().equals("") || 
					txtEmail.getText().equals("") || 
					txtCidade.getText().equals("") || 
					txtEstado.getText().equals("") || 
					txtDataNascimento.getText().equals("") || 
					txtCelular.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Por Favor, preencha todos os campos!");
					
				} else {
					Cliente cliente = new Cliente();
					cliente.setNome(txtNome.getText());
					cliente.setSobrenome(txtSobrenome.getText());
					cliente.setEmail(txtEmail.getText());
					cliente.setCelular(txtCelular.getText());
					cliente.setCidade(txtCidade.getText());
					cliente.setEstado(txtEstado.getText());
					cliente.setData_nascimento(txtDataNascimento.getText());
					
					ClienteDAO clienteDAO = new ClienteDAO();
					if(lblStatus.getText() == "Cadastrar"){
						clienteDAO.cadastrar(cliente);
					} else if(lblStatus.getText() == "Atualizar Dados"){
						cliente.setId(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0).toString());
						clienteDAO.editar(cliente);
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
				int linha = tabClientes.getSelectedRow();
				if(linha >=0){
					Cliente cliente = new Cliente();
					cliente.setId(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0).toString());
					
					int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este cliente ?");
					
					if(resp == 0){
						ClienteDAO clienteDAO = new ClienteDAO();
						clienteDAO.excluir(cliente);
					}
					
					
					montarTabela();
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir!");
				}
				
			}
		});
	}

	//M�TODOS  ESSENCIAIS
	public void montarTabela(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		clientes = clienteDAO.listarClientes();
		
		tabModel = new DefaultTableModel();
		tabClientes = new JTable(tabModel);
		tabClientes.setRowSelectionAllowed(false);
		
		tabModel.addColumn("ID");
		tabModel.addColumn("Nome");
		tabModel.addColumn("E-mail");
		
		tabClientes.getColumnModel().getColumn(0).setMinWidth(0); 
		tabClientes.getColumnModel().getColumn(0).setPreferredWidth(0);  
		tabClientes.getColumnModel().getColumn(0).setMaxWidth(0);
		
		for (Cliente cliente: clientes){
			tabModel.addRow(new Object[]{cliente.getId(),cliente.getNome(), cliente.getEmail()});
		}
		scrollPane.setViewportView(tabClientes);
		tabClientes.addMouseListener(new MouseListener() {
			
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
				id = tabClientes.getValueAt(tabClientes.getSelectedRow(), 0).toString();
				preencherCampos(id);
			}
		});
	}
	
	public void preencherCampos(String id){
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente = clienteDAO.getClienteById(id);
		
		txtNome.setText(cliente.getNome());
		txtEmail.setText(cliente.getEmail());
		txtSobrenome.setText(cliente.getSobrenome());
		txtCidade.setText(cliente.getCidade());
		txtEstado.setText(cliente.getEstado());
		txtDataNascimento.setText(cliente.getData_nascimento());
		txtCelular.setText(cliente.getCelular());
	}
	
	public void limparCampos(){
		txtNome.setText("");
		txtEmail.setText("");
		txtSobrenome.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtDataNascimento.setText("");
		txtCelular.setText("");
	}
}

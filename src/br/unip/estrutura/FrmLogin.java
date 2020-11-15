package br.unip.estrutura;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.border.EmptyBorder;

import br.unip.model.Login;
import br.unip.dao.LoginDAO;

public class FrmLogin extends JFrame {
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	public FrmLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Crypto Exchange");
		setBounds(100, 100, 371, 244);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titulo = new JPanel();
		titulo.setBounds(0, 0, 370, 26);
		getContentPane().add(titulo);
		
		JLabel lblTitulo = new JLabel("Login");
		titulo.add(lblTitulo);
		
		JPanel campos = new JPanel();
		campos.setBounds(0, 26, 370, 192);
		FlowLayout flowLayout = (FlowLayout) campos.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setHgap(40);
		flowLayout.setVgap(15);
		getContentPane().add(campos);
		
		JLabel lblTituloPagina = new JLabel("Email");
		lblTituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
		campos.add(lblTituloPagina);
		
		txtEmail = new JTextField();
		lblTituloPagina.setLabelFor(txtEmail);
		campos.add(txtEmail);
		txtEmail.setColumns(15);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		campos.add(lblSenha);
		
		txtSenha = new JPasswordField();
		lblSenha.setLabelFor(txtSenha);
		txtSenha.setColumns(15);
		campos.add(txtSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setEmail(txtEmail.getText());
				login.setSenha(txtSenha.getText());
				
				LoginDAO loginDAO = new LoginDAO();
				int result = loginDAO.getLoginSenha(login);
				
				if(result != 0) {
					setVisible(false);
					FrmDashboard inicial = new FrmDashboard(result);
					
					inicial.setVisible(true);
				}
			}
		});
		btnNewButton.setToolTipText("Entrar");
		campos.add(btnNewButton);
	}


}

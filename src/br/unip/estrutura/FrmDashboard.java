package br.unip.estrutura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.dao.DashboardDAO;
import br.unip.model.Dashboard;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class FrmDashboard extends JFrame {
	
	private JPanel contentPane;
	
	public FrmDashboard(int idUsuario) {
		// Pegando dados que serão mostrados na home
		DashboardDAO dashDAO = new DashboardDAO();
		Dashboard dadosDash = new Dashboard();
		dadosDash = dashDAO.getDadosHome(idUsuario);
		
		setResizable(false);
		setTitle("Crypto Exchange");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 532, 23);
		contentPane.add(menuBar);
		
		JMenu mnMenuUsuarios = new JMenu("Usuários");
		mnMenuUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FrmUsuarios usuarios = new FrmUsuarios(idUsuario);
				usuarios.setVisible(true);
			}
		});
		menuBar.add(mnMenuUsuarios);
		
		JMenu mnMenuClientes = new JMenu("Clientes");
		mnMenuClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				FrmClientes clientes = new FrmClientes(idUsuario);
				clientes.setVisible(true);
			}
		});
		menuBar.add(mnMenuClientes);
		
		JMenu mnLogout = new JMenu("Sair");
		mnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "Sair do sistema", JOptionPane.YES_NO_OPTION);
				
				if(option == 0) {					
					setVisible(false);
					FrmLogin login = new FrmLogin();
					login.setVisible(true);
				}
			}
		});
		
		JMenu mnRelatorios = new JMenu("Relatórios");
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmAtivosMaisOperados = new JMenuItem(new AbstractAction("Ranking de Ativos") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        // Button pressed logic goes here
				setVisible(false);
				RankingAtivos rankingAtivos = new RankingAtivos(idUsuario);
				rankingAtivos.setVisible(true);
		    }
		});
		
		JMenuItem mntmInvestimentosPorRegiao = new JMenuItem(new AbstractAction("Ranking por Região") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        // Button pressed logic goes here
				setVisible(false);
				RankingRegiao rankingRegiao = new RankingRegiao(idUsuario);
				rankingRegiao.setVisible(true);
		    }
		});
		
		JMenuItem mntmInvestimentosPorDia = new JMenuItem(new AbstractAction("Ranking última semana") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        // Button pressed logic goes here
				setVisible(false);
				RankingDia rankingDia = new RankingDia(idUsuario);
				rankingDia.setVisible(true);
		    }
		});
		
		JMenuItem mntmInvestimentosPorMes = new JMenuItem(new AbstractAction("Ranking últimos meses") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        // Button pressed logic goes here
				setVisible(false);
				RankingMes rankingMes = new RankingMes(idUsuario);
				rankingMes.setVisible(true);
		    }
		});
		
		mnRelatorios.add(mntmInvestimentosPorMes);
		mnRelatorios.add(mntmInvestimentosPorDia);
		mnRelatorios.add(mntmAtivosMaisOperados);
		mnRelatorios.add(mntmInvestimentosPorRegiao);
		menuBar.add(mnLogout);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		panel.setBounds(188, 35, 298, 59);
		contentPane.add(panel);
		
		JLabel lblTitulo = new JLabel("Dashboard");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		panel.add(lblTitulo);
		
		JPanel panelDados = new JPanel();
		panelDados.setBounds(43, 101, 443, 182);
		contentPane.add(panelDados);
		panelDados.setLayout(null);
		
		JLabel lblTituloClientes = new JLabel("Clientes Cadastrados");
		lblTituloClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloClientes.setBounds(21, 18, 150, 16);
		panelDados.add(lblTituloClientes);
		
		JLabel lblQtdClientes = new JLabel(dadosDash.getQtdClientes() != null ? dadosDash.getQtdClientes() : "0");
		lblQtdClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblQtdClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdClientes.setBounds(59, 46, 61, 48);
		panelDados.add(lblQtdClientes);
		
		JLabel lblTituloOperacoesMes = new JLabel("Operações no mês");
		lblTituloOperacoesMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloOperacoesMes.setBounds(259, 18, 139, 16);
		panelDados.add(lblTituloOperacoesMes);
		
		JLabel lblQtdOperacoesMes = new JLabel(dadosDash.getQtdOperacoes() != null ? dadosDash.getQtdOperacoes() : "0");
		lblQtdOperacoesMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdOperacoesMes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblQtdOperacoesMes.setBounds(297, 46, 61, 48);
		panelDados.add(lblQtdOperacoesMes);
		
		JLabel lblTituloReaisMes = new JLabel("Operações no mês");
		lblTituloReaisMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloReaisMes.setBounds(149, 106, 139, 16);
		panelDados.add(lblTituloReaisMes);
		
		JLabel lblQtdReaisMes = new JLabel(dadosDash.getValorOperacoes() != null ? "R$ "+dadosDash.getValorOperacoes().toString() : "R$ 0,00");
		lblQtdReaisMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdReaisMes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblQtdReaisMes.setBounds(194, 128, 61, 48);
		panelDados.add(lblQtdReaisMes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(51, 204, 204), 1, true));
		panel_1.setBounds(21, 18, 150, 76);
		panelDados.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(51, 204, 204), 1, true));
		panel_1_1.setBounds(252, 18, 150, 76);
		panelDados.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(51, 204, 204), 1, true));
		panel_1_1_1.setBounds(142, 106, 150, 76);
		panelDados.add(panel_1_1_1);
		
		JLabel lnlNomeUsuario = new JLabel("Olá, " + dadosDash.getNomeUsuario());
		lnlNomeUsuario.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		lnlNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lnlNomeUsuario.setBounds(43, 35, 146, 59);
		contentPane.add(lnlNomeUsuario);
	}
}

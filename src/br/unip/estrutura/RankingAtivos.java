package br.unip.estrutura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.RelatoriosDAO;
import br.unip.model.Cliente;
import br.unip.model.RankkingAtivos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.table.TableModel;

public class RankingAtivos extends JFrame {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel tabModel;
	private JTable tabRanking;
	private JTable table;
	
	public RankingAtivos(int idUsuario) {
		setResizable(false);
		setTitle("Crypto Exchange");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel painelLista = new JPanel();
		painelLista.setLayout(null);
		painelLista.setBounds(20, 60, 489, 200);
		contentPane.add(painelLista);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setLayout(null);
		painelTabela.setBorder(null);
		painelTabela.setBounds(10, 11, 473, 183);
		painelLista.add(painelTabela);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 454, 165);
		painelTabela.add(scrollPane);
		
		tabModel = new DefaultTableModel();
		table = new JTable(tabModel);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		
		tabModel.addColumn("Nome Ativo");
		tabModel.addColumn("Quantidade de investimentos");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(409, 269, 117, 29);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 520, 44);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Ranking de Ativos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		// buscando dados dos relatórios
		RelatoriosDAO rankingDAO = new RelatoriosDAO(); 
		ArrayList<RankkingAtivos> ranking = new ArrayList<>();  
		ranking = rankingDAO.rankingAtivos();
		
		for (RankkingAtivos rank: ranking){
			tabModel.addRow(new Object[]{rank.getName(),rank.getQuantidade()});
		}
		
		scrollPane.setViewportView(table);
		
		// eventos de botoes
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmDashboard dash = new FrmDashboard(idUsuario);
				dash.setVisible(true);
			}
		});
	}
}

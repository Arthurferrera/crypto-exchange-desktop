package br.unip.estrutura;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.RelatoriosDAO;
import br.unip.model.RankkingRegiao;

public class RankingDia extends JFrame {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel tabModel;
	private JTable table;
	
	public RankingDia() {
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
		
		// resgatando valores do dia atual até 6 dias anteriores
		Calendar calendar = new GregorianCalendar();
		RelatoriosDAO rankingDAO = new RelatoriosDAO(); 
		ArrayList<String> ranking = new ArrayList<>();  
		for(int i = 0; i < 7; i++) {
			
			// a cada volta no loop, dimminui um dia, somente a partir da segunda volta
			if(i == 0) {
				calendar.add(Calendar.DAY_OF_MONTH, -0);
			} else {
				calendar.add(Calendar.DAY_OF_MONTH, -1);
			}
			
			String dataMenos = calendar.get(Calendar.DAY_OF_MONTH) + "/" + 
					(calendar.get(Calendar.MONTH) + 1);
			String dataMenosQuery = calendar.get(Calendar.DAY_OF_MONTH) + "/" + 
					(calendar.get(Calendar.MONTH) + 1) + "/" + (calendar.get(Calendar.YEAR));

			tabModel.addColumn(dataMenos);
			
			// na última volta, envia-se segundo parametro como true para fechar a conexão do banco
			if(i == 6) {
				ranking.add(rankingDAO.rankingDia(dataMenosQuery, true));	
			} else {
				ranking.add(rankingDAO.rankingDia(dataMenosQuery, false));
			}
			
		}
		// adicionando os valores
		tabModel.addRow(new Object[]{ranking.get(0), ranking.get(1), ranking.get(2), ranking.get(3), ranking.get(4), ranking.get(5), ranking.get(6)});

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(409, 269, 117, 29);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 520, 44);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Ranking da última semana (por dia)");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		scrollPane.setViewportView(table);
		
		// eventos de botoes
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FrmDashboard dash = new FrmDashboard(0);
				dash.setVisible(true);
			}
		});
	}
	
}

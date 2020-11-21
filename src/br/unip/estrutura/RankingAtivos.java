package br.unip.estrutura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.dao.RelatoriosDAO;
import br.unip.model.Cliente;
import br.unip.model.RankkingAtivos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class RankingAtivos extends JFrame {
	
	private JPanel contentPane;
	
	public RankingAtivos() {
		setResizable(false);
		setTitle("Crypto Exchange");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
//			tabModel.addRow(new Object[]{cliente.getId(),cliente.getNome(), cliente.getEmail()});
			System.out.println(rank);
		}
		
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

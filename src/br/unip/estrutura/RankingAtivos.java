package br.unip.estrutura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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

package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable visaoGeral;


	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDireita = new JPanel();
		contentPane.add(panelDireita, BorderLayout.WEST);
		panelDireita.setLayout(new BorderLayout(0, 0));
		
		JPanel Norte = new JPanel();
		Norte.setBackground(new Color(184, 180, 7));
		panelDireita.add(Norte, BorderLayout.NORTH);
		Norte.setLayout(new BorderLayout(0, 0));
		
		JLabel TituloVisaoGeral = new JLabel("Visão Geral");
		TituloVisaoGeral.setBackground(new Color(184, 180, 7));
		TituloVisaoGeral.setFont(new Font("Times New Roman", Font.BOLD, 40));
		Norte.add(TituloVisaoGeral);
		
		JPanel sul = new JPanel();
		sul.setBackground(new Color(64, 128, 128));
		panelDireita.add(sul, BorderLayout.SOUTH);
		
		JPanel lest = new JPanel();
		lest.setBackground(new Color(64, 128, 128));
		panelDireita.add(lest, BorderLayout.WEST);
		
		JPanel oeste = new JPanel();
		oeste.setBackground(new Color(64, 128, 128));
		panelDireita.add(oeste, BorderLayout.EAST);
		
		JPanel centro = new JPanel();
		panelDireita.add(centro, BorderLayout.CENTER);

		visaoGeral = new JTable();
		visaoGeral.setModel(new DefaultTableModel(
			new Object[][] {
				{"Oracio", "Jorge", "10"},
			},
			new String[] {
				"Paciente", "M\u00E9dico", "Hora"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane();
		centro.add(scrollPane);
		
		scrollPane.add(visaoGeral);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panelCentro.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Painel de controle");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panelCentro.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[71.00][17.00px,grow]", "[][1px][15px,grow][23px][15px,grow][23px][15px,grow][23px][15px]"));
		
		JButton btnNewButton = new JButton("logout");
		panel_1.add(btnNewButton, "cell 1 0,alignx right");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaInicio frame = new TelaInicio();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Cadastros");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1, "flowx,cell 1 2,alignx center,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3, "cell 1 1,alignx center,aligny center");
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 1 3,grow");
		
		JButton btnNewButton_1 = new JButton("Paciente");
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_4 = new JButton("Usuário");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.
			}
		});
		panel_2.add(btnNewButton_4);
			
		JLabel lblNewLabel_7 = new JLabel("               ");
		panel_2.add(lblNewLabel_7);

		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consulta");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2, "cell 1 4,alignx center,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_1.add(lblNewLabel_4, "cell 1 1,alignx center,aligny center");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "cell 1 5,grow");
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_2 = new JButton("Registrar consultas");
		panel_3.add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("            ");
		panel_3.add(lblNewLabel_8);
		
		JButton btnNewButton_5 = new JButton("Listas de consultas");
		panel_3.add(btnNewButton_5);
		
		JLabel lblNewLabel_5 = new JLabel("Listas");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5, "cell 1 6,alignx center,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_1.add(lblNewLabel_6, "cell 1 1,alignx center,aligny center");
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "cell 1 7,grow");
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_3 = new JButton("Listas de Médicos");
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Listas de Pacientes");
		panel_4.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Lista de Secretaria");
		panel_4.add(btnNewButton_7);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "cell 0 8,grow");
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}

package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

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
		panel_1.setLayout(new MigLayout("", "[81px,grow][17.00px][119px,grow]", "[1px][15px,grow][23px,grow][15px,grow][23px,grow][15px,grow][23px,grow][15px,grow][23px,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Médicos:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1, "cell 1 1,alignx center,aligny center");
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(btnNewButton, "cell 0 2,growx,aligny center");
		
		JButton btnNewButton_1 = new JButton("Lista de Médicos");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(btnNewButton_1, "cell 2 2,growx,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3, "cell 1 0,alignx center,aligny center");
		
		JLabel lblNewLabel_2 = new JLabel("Paciente");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2, "cell 1 3,alignx center,aligny center");
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		panel_1.add(btnNewButton_2, "cell 0 4,growx,aligny center");
		
		JButton btnNewButton_3 = new JButton("Lista de Pacientes");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(btnNewButton_3, "cell 2 4,growx,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_1.add(lblNewLabel_4, "cell 1 0,alignx center,aligny center");
		
		JLabel lblNewLabel_5 = new JLabel("Consultas:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_5, "cell 1 5,alignx center,aligny center");
		
		JButton btnNewButton_4 = new JButton("Cadastrar");
		panel_1.add(btnNewButton_4, "cell 0 6,growx,aligny center");
		
		JButton btnNewButton_5 = new JButton("Consultas");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(btnNewButton_5, "cell 2 6,growx,aligny center");
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel_1.add(lblNewLabel_6, "cell 1 0,alignx center,aligny center");
		
		JLabel lblNewLabel_7 = new JLabel("Secretários");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_7, "cell 1 7,alignx center,aligny center");
		
		JButton btnNewButton_6 = new JButton("Cadastrar");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(btnNewButton_6, "cell 0 8,growx,aligny center");
		
		JButton btnNewButton_7 = new JButton("Listar secretários");
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(btnNewButton_7, "cell 2 8,growx,aligny center");
	}

}

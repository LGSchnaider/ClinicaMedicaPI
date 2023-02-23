package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaRegistrarMed extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistrarMed frame = new TelaRegistrarMed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaRegistrarMed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[212.00,grow][443.00,grow][196.00,grow]", "[91.00,grow][48.00][64.00][55.00][60.00][62.00][57.00][67.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Casdastrar Médico");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 2,growx");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Código CRM:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Login:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 5,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Senha:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_5, "cell 0 6,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 1 6,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_1, "cell 0 7,grow");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal frame = new TelaPrincipal();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(75)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		contentPane.add(panel, "cell 1 7,alignx center,aligny center");
		
		JButton btnCad = new JButton("Cadastrar novo médico");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(126)
					.addComponent(btnCad, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(142))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCad, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}

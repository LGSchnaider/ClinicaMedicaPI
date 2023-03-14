package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.MedicoDAO;
import controle.PacienteDAO;
import modelo.Medico;
import modelo.Paciente;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaRegistrarMed extends JPanel {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField txtCRM;
	private JFormattedTextField textField_2;
	private JTextField txtNomeMed;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public TelaRegistrarMed() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 1029, 550);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[212.00,grow][443.00,grow][][196.00,grow]",
				"[70.00,grow][28.00,grow][64.00][55.00][60.00,grow][62.00][57.00][44.00][][grow][67.00,grow]"));

		JLabel lblNewLabel = new JLabel("Casdastrar Médico");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center,aligny center");

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx trailing");

		txtNomeMed = new JTextField();
		txtNomeMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(txtNomeMed, "cell 1 2,growx,aligny center");
		txtNomeMed.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_2, "cell 0 3,alignx trailing");

		textField_2 = new JFormattedTextField();
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		JTextField txtCPFMed = new JFormattedTextField(formatter);
		txtCPFMed.setBounds(165, 190, 174, 20);
		contentPane.add(txtCPFMed);
		txtCPFMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(txtCPFMed, "cell 1 3,growx,aligny center");
		if (txtCPFMed.getText().equals(null) || txtCPFMed.getText() == null) {
			JOptionPane.showMessageDialog(null, "Campo obrigatório: CPF");
		}
		if (txtCPFMed.getText().length() != 14) {
			JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente.");
		}
		txtCPFMed.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Código CRM:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_3, "cell 0 4,alignx trailing");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_2, "cell 1 4,growx,aligny center");

		// TODO completar combobox de estados
		JComboBox<String> cbEstado = new JComboBox<>();
		cbEstado.addItem ("AC");
		cbEstado.addItem ("AL");
		cbEstado.addItem ("AP");
		cbEstado.addItem ("AM");
		cbEstado.addItem ("BA");
		cbEstado.addItem ("CE");
		cbEstado.addItem ("DF");
		cbEstado.addItem ("ES");
		cbEstado.addItem ("GO");
		cbEstado.addItem ("MA");
		cbEstado.addItem ("MT");
		cbEstado.addItem ("MS");
		cbEstado.addItem ("MG");
		cbEstado.addItem ("PA");
		cbEstado.addItem ("PB");
		cbEstado.addItem ("PR");
		cbEstado.addItem ("PE");
		cbEstado.addItem ("PI");
		cbEstado.addItem ("RJ");
		cbEstado.addItem ("RN");
		cbEstado.addItem ("RS");
		cbEstado.addItem ("RO");
		cbEstado.addItem ("RR");
		cbEstado.addItem ("SC");
		cbEstado.addItem ("SP");
		cbEstado.addItem ("SE");
		cbEstado.addItem ("TO");

		try {
			// TODO corrigir a formatacao para CRM
			formatter = new MaskFormatter("######");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		txtCRM = new JFormattedTextField(formatter);
		txtCRM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCRM.setColumns(10);
		textField_2 = new JFormattedTextField();

		if (txtCRM.getText().equals(null) || txtCRM.getText() == null) {
			JOptionPane.showMessageDialog(null, "Campo obrigatório: CRM");
		}
		if (txtCRM.getText().length() != 6) {
			JOptionPane.showMessageDialog(null, "CRM inválido. Tente novamente.");
		}
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCRM, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(14)
					.addComponent(txtCRM)
					.addGap(14))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(16)
					.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);

		JLabel lblNewLabel_4 = new JLabel("Login:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_4, "cell 0 5,alignx trailing");

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(textField, "cell 1 5,growx,aligny center");
		textField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Senha:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_5, "cell 0 6,alignx trailing");

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(passwordField, "cell 1 6,growx,aligny center");

		JLabel lblNewLabel_6 = new JLabel("Confirme Senha:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_6, "cell 0 7,alignx trailing");

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(passwordField_1, "cell 1 7,growx,aligny center");

		JLabel lblNewLabel_7 = new JLabel("Perfil:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_7, "cell 0 8,alignx trailing");

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(comboBox, "cell 1 8,growx,aligny center");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_1, "cell 0 10,grow");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dispose();
				TelaPrincipal frame = new TelaPrincipal();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addGap(75)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(73, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		contentPane.add(panel, "cell 1 10,alignx center,aligny center");

		JButton btnCad = new JButton("Cadastrar novo médico");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 1o passo: pegar o texto dos campos de texto
				String cpf = txtCPFMed.getText(); // regex (expressao regular) tambem seria uma forma
				String crm = txtCPFMed.getText();
				// 2o passo: validar se texto é vazio ou nao
				// se nao for vazio

				// 3o passo: o que tem mascara usar o metodo REPLACE da String
				cpf = cpf.replace(".", ""); // forma feia mas facil
				cpf = cpf.replace("-", "");

				// 4o passo: conversao de tipo pras variaveis que precisa (numeros) --- casting
				// (valueOf)
				Long cpfInt = Long.valueOf(cpf);
				String crmSring = String.valueOf(crm);

				Medico m = new Medico();
				m.setNome("fsfsdfsd");
				m.setCpf(cpfInt);
//				m.setSexo("m");
//				m.setEmail("aadad");

				MedicoDAO mdao = new MedicoDAO();
				boolean validar = mdao.inserir(m);
				if (validar == true) {
					// exibir uma mensagem de cadastro com sucesso
				} else {
					// exibir mensagem de erro ao cadastrar
				}

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(126)
						.addComponent(btnCad, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE).addGap(142)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(btnCad, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(gl_panel);

		setLayout(new BorderLayout());
		add(contentPane, BorderLayout.CENTER);

	}
}

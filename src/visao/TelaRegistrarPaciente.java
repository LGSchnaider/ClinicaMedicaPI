package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.PacienteDAO;
import modelo.Paciente;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class TelaRegistrarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeP;
	private JTextField txtcpfP;
	private JTextField txtTelefoneP;
	private JTextField txtEmailP;

	/**
	 * Launch the application.
	 */

	public TelaRegistrarPaciente() {
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 156, 156));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[28.00,grow][][690px,grow][51.00][29.00,grow]",
				"[44.00,grow][391px,grow][grow][28.00]"));

		JLabel lblNewLabel_5 = new JLabel("Cadastar Paciente");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNewLabel_5, "cell 2 0,alignx center,growy");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 156, 156));
		contentPane.add(panel, "cell 2 1,grow");
		panel.setLayout(new MigLayout("", "[72.00][321.00,grow]",
				"[grow][56.00,grow][68.00,grow][66.00,grow][68.00,grow][80.00,grow]"));

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(lblNewLabel_4, "cell 0 1,alignx trailing");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 156, 156));
		panel.add(panel_1, "cell 1 1,grow");

		txtNomeP = new JTextField();
		txtNomeP.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(txtNomeP, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(txtNomeP).addGap(25)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(lblNewLabel_3, "cell 0 2,alignx trailing");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 156, 156));
		panel.add(panel_2, "flowx,cell 1 2,grow");

		txtcpfP = new JTextField();
		txtcpfP.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(txtcpfP, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(21).addComponent(txtcpfP).addGap(24)));
		panel_2.setLayout(gl_panel_2);

		JLabel lblNewLabel_2 = new JLabel("Telefone para contato:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(lblNewLabel_2, "cell 0 3,alignx trailing");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 156, 156));
		panel.add(panel_3, "flowx,cell 1 3,grow");

		txtTelefoneP = new JTextField();
		txtTelefoneP.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(txtTelefoneP, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(33).addComponent(txtTelefoneP).addGap(26)));
		panel_3.setLayout(gl_panel_3);

		JLabel lblNewLabel_1 = new JLabel("Sexo:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(lblNewLabel_1, "cell 0 4,alignx trailing");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 156, 156));
		panel.add(panel_4, "flowx,cell 1 4,grow");

		JComboBox cbSexo = new JComboBox();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_4.createSequentialGroup().addContainerGap().addComponent(cbSexo, 0, 518, Short.MAX_VALUE)
						.addGap(10)));
		gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4.createSequentialGroup().addGap(27)
						.addComponent(cbSexo, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE).addGap(24)));
		panel_4.setLayout(gl_panel_4);

		JLabel lblNewLabel = new JLabel("E-mail para contato:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(lblNewLabel, "cell 0 5,alignx trailing");

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 156, 156));
		panel.add(panel_5, "flowx,cell 1 5,grow");

		txtEmailP = new JTextField();
		txtEmailP.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
						.addComponent(txtEmailP, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE).addContainerGap()));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_5.createSequentialGroup().addGap(24).addComponent(txtEmailP).addGap(30)));
		panel_5.setLayout(gl_panel_5);

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
		contentPane.add(btnVoltar, "cell 1 2,growx,aligny center");

		JButton btnInserir = new JButton("Cadastrar");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeP = txtNomeP.getText();
				Long CPFp = Long.valueOf(txtcpfP.getText());
				Long TelefoneP = Long.valueOf(txtTelefoneP.getText());
				String EmailP = txtEmailP.getText();

				Paciente paciente = new Paciente();
				paciente.setNome(NomeP);
				paciente.setCpf(CPFp);
				paciente.setTelefone(TelefoneP);
				paciente.setEmail(EmailP);

				PacienteDAO dao = new PacienteDAO();
				boolean validar = dao.inserir(paciente);

				if (validar == true) {
					// TODO realiza teste
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
				}

			}
		});
		contentPane.add(btnInserir, "cell 3 2,growx,aligny center");
	}
}

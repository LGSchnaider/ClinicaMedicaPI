package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controll.CDoctorDAO;
import controll.CPatientDAO;
import controll.CSecretaryDAO;
import controll.CUserDAO;
import model.MPatient;
import model.MSecretary;
import model.MTypeUser;
import model.MTyperGender;
import model.MUser;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VEditPatient extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private MUser usuarioLogado;
	private JComboBox<String> cbSexo = new JComboBox<>();
	private JFormattedTextField txtTelefone;

	/**
	 * Launch the application.
	 */

	public VEditPatient(MUser usuarioLogado, MPatient d) {

		this.usuarioLogado = usuarioLogado;

		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 600);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/main/java/imagens/TelacadPaciente.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		contentPane = new VBackGround(bg);
		contentPane.setBackground(new Color(0, 156, 156));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[42.00,grow][][42.00,grow][690px][][][][][][][51.00,grow][39.00,grow]", "[44.00,grow][391px,grow][grow][28.00]"));

		JLabel lblNewLabel_5 = new JLabel("Atualizar Paciente");
		lblNewLabel_5.setForeground(new Color(19, 59, 93));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNewLabel_5, "cell 3 0,alignx center,growy");

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 156, 156));
		contentPane.add(panel, "cell 3 1,grow");
		panel.setLayout(new MigLayout("", "[pref!][321.00][pref!]", "[grow][117.00][66.00,grow][80.00]"));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0, 156, 156));
		panel.add(panel_1, "cell 1 1,growx,aligny center");

		txtNome = new JTextField();
		txtNome.setForeground(new Color(19, 59, 93));
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNome.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setForeground(new Color(19, 59, 93));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 576,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_4))
										.addGap(19)));
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(lblNewLabel_4).addPreferredGap(ComponentPlacement.RELATED).addComponent(txtNome,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(33)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(0, 156, 156));
		panel.add(panel_3, "flowx,cell 1 2,growx,aligny top");

		try {
			formatter = new MaskFormatter("(##) #####-####");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(formatter);
		txtTelefone.setForeground(new Color(19, 59, 93));
		txtTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTelefone.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setForeground(new Color(19, 59, 93));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_1 = new JLabel("Sexo:");
		lblNewLabel_1.setForeground(new Color(19, 59, 93));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		cbSexo.setForeground(new Color(19, 59, 93));

		cbSexo.setFont(new Font("Times New Roman", Font.PLAIN, 15));

//		cbSexo.addItem("Não Definido");
//		cbSexo.addItem("Masculino");
//		cbSexo.addItem("Feminino");
		cbSexo.setEditable(false);

		JLabel lblNewLabel = new JLabel("E-mail:");
		lblNewLabel.setForeground(new Color(19, 59, 93));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(19, 59, 93));
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3.createSequentialGroup()
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(cbSexo, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup().addComponent(lblNewLabel_2).addGap(198)
								.addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_3
				.setVerticalGroup(
						gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_panel_3.createSequentialGroup()
												.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1))
												.addGap(7)
												.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(cbSexo, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addContainerGap(27, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);
		for (MTyperGender s : MTyperGender.values()) {
			cbSexo.addItem(s.getDescricao());
		}

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBackground(new Color(0, 156, 156));
		panel.add(panel_5, "flowx,cell 1 3,grow");
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5
				.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGap(0, 605, Short.MAX_VALUE));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGap(0, 95, Short.MAX_VALUE));
		panel_5.setLayout(gl_panel_5);
		preencherDados(d);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		contentPane.add(panel_6, "flowx,cell 3 2,growx,aligny center");
		
				JButton btnVoltar = new VModelButton("Voltar");
				btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						VListPatient frame = new VListPatient(usuarioLogado);
						frame.setLocationRelativeTo(null);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
					}
				});
		
				JButton btnInserir = new VModelButton("Atualizar");
				btnInserir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						boolean validarCampoTexto = true;

						// 1o passo: pegar o texto dos campos de texto
						String nome = txtNome.getText();
						String telefone = txtTelefone.getText();
						String sexo = (String) cbSexo.getSelectedItem();
						String email = txtEmail.getText();

						MPatient paciente = new MPatient();

						// 2o passo: validar se texto é vazio ou nao
						// se nao for vazio

						try {
							if (nome != null && !nome.isEmpty()) {
								paciente.setNome(nome);
							} else {
								validarCampoTexto = false;
								JOptionPane.showMessageDialog(null, "O campo NOME precisa ser preenchido");
								txtNome.requestFocus();
								return;
							}

						} catch (Exception e2) {

						}

						try {

							if (telefone != null && !telefone.isEmpty()) {
								String telefones = telefone.replace(")", ""); // forma feia mas facil
								telefones = telefones.replace("(", ""); // forma feia mas facil
								telefones = telefones.replace("-", "");
								telefones = telefones.replace(" ", "");
								telefones = telefones.strip();
								// if (telefone.equalsIgnoreCase("( ) - ")) {
								if (telefones.isEmpty()) {
									JOptionPane.showMessageDialog(null, "O campo TELEFONE precisa ser preenchido");
									txtTelefone.requestFocus();
									return;
								} else {
									// 3o passo: o que tem mascara usar o metodo REPLACE da String

									// 4o passo: conversao de tipo pras variaveis que precisa (numeros) --- casting
									// (valueOf)
									Long telefoneInt = Long.valueOf(telefones);

									// setar no obj
									paciente.setTelefone(telefoneInt);
								}

							} else {
								validarCampoTexto = false;
								JOptionPane.showMessageDialog(null, "O campo TELEFONE precisa ser preenchido");
								txtTelefone.requestFocus();
								return;
							}

						} catch (Exception e2) {
							e2.printStackTrace();
						}

						try {
							if (cbSexo.getSelectedIndex() == 0) {
								validarCampoTexto = false;
								JOptionPane.showMessageDialog(null, "O campo SEXO precisa ser selecionado");
								cbSexo.requestFocus();
								return;
							} else {
								validarCampoTexto = true;
								paciente.setSexo(MTyperGender.obterTipo(sexo));

							}

						} catch (Exception e2) {
							e2.printStackTrace();
						}

						try {
							if (email != null && !email.isEmpty()) {
								paciente.setEmail(email);
							} else {
								validarCampoTexto = false;
								JOptionPane.showMessageDialog(null, "O campo EMAIL precisa ser preenchido");
								txtEmail.requestFocus();
								return;
							}

						} catch (Exception e2) {

						}

						// se passar em todas as validacoes
						try {
							// se passar em todas as validacoes
							if (validarCampoTexto == true) {
								CPatientDAO pdao = new CPatientDAO();

								boolean validar = pdao.atualizar(paciente);
								if (validar == true) {
									// exibir uma mensagem de cadastro com sucesso
									JOptionPane.showMessageDialog(null, "Editado com sucesso");
								} else {
									// exibir mensagem de erro ao cadastrar
									JOptionPane.showMessageDialog(null, "Erro ao editar Paciente");
								}
							}

						} catch (Exception e2) {
							e2.printStackTrace();
						}

					}
				});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(41)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
					.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
	}

	private void preencherDados(MPatient d) {
		if (d != null) {
			txtNome.setText(d.getNome());
			txtTelefone.setText(String.valueOf(d.getTelefone()));
			txtEmail.setText(d.getEmail());
			cbSexo.setSelectedItem(d.getSexo().getDescricao());
		}
	}
}
package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.MedicoDAO;
import controle.UsuarioDAO;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class VRegisterDoctor extends JPanel {

	private JPanel contentPane;
	private JPasswordField pswConfirmarSenha;
	private JTextField txtLogin;
	private JTextField txtCRM;
	private JFormattedTextField textField_2;
	private JTextField txtNomeMed;
	private Usuario usuarioLogado;
	private JPasswordField pswSenha;

	/**
	 * Create the frame.
	 * 
	 * @param telaCadastro
	 * @param formatter
	 */
	public VRegisterDoctor(Usuario usuarioLogado, VRegister telaCadastro) {

		this.usuarioLogado = usuarioLogado;

		BufferedImage bg = null;
		try {
			bg = ImageIO.read(new File("src/imagens/TelacadMédico.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		contentPane = new VBackGround(bg);

		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[212.00,grow][224.00][196.00,grow]",
				"[70.00,grow][59.00,grow][55.00,grow][48.00,grow][55.00,grow][67.00,grow][27.00,grow]"));

		JLabel lblNewLabel = new JLabel("Cadastrar Médico");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center,aligny center");

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, "flowx,cell 1 1");

		txtNomeMed = new JTextField();
		txtNomeMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNomeMed.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));

		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		JTextField txtCPFMed = new JFormattedTextField(formatter);
		txtCPFMed.setBounds(165, 190, 174, 20);
		txtCPFMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtCPFMed.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNomeMed, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtCPFMed, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(5)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtCPFMed, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1)
												.addComponent(txtNomeMed, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_2))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		textField_2 = new JFormattedTextField();

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_2, "cell 1 2,growx,aligny center");

		JComboBox<String> cbEstado = new JComboBox<>();
		cbEstado.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbEstado.addItem("  ");
		cbEstado.addItem("AC");
		cbEstado.addItem("AL");
		cbEstado.addItem("AP");
		cbEstado.addItem("AM");
		cbEstado.addItem("BA");
		cbEstado.addItem("CE");
		cbEstado.addItem("DF");
		cbEstado.addItem("ES");
		cbEstado.addItem("GO");
		cbEstado.addItem("MA");
		cbEstado.addItem("MT");
		cbEstado.addItem("MS");
		cbEstado.addItem("MG");
		cbEstado.addItem("PA");
		cbEstado.addItem("PB");
		cbEstado.addItem("PR");
		cbEstado.addItem("PE");
		cbEstado.addItem("PI");
		cbEstado.addItem("RJ");
		cbEstado.addItem("RN");
		cbEstado.addItem("RS");
		cbEstado.addItem("RO");
		cbEstado.addItem("RR");
		cbEstado.addItem("SC");
		cbEstado.addItem("SP");
		cbEstado.addItem("SE");
		cbEstado.addItem("TO");

		try {
			formatter = new MaskFormatter("######");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtCRM = new JFormattedTextField(formatter);
		txtCRM.setText("");
		txtCRM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCRM.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Código CRM:");

		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel_3)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtCRM, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(16)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(36, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		contentPane.add(panel_3, "cell 1 3,growx,aligny center");

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtLogin.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Login:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_4_1 = new JLabel("Senha:");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		pswSenha = new JPasswordField();
		pswSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE).addGap(33)
						.addComponent(lblNewLabel_4_1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addGap(22)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(11, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		textField_2 = new JFormattedTextField();

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		contentPane.add(panel_4, "flowx,cell 1 4");

		pswConfirmarSenha = new JPasswordField();
		pswConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		JLabel lblNewLabel_6 = new JLabel("Confirme Senha:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
				.createSequentialGroup().addComponent(lblNewLabel_6).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(pswConfirmarSenha, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE).addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
				.createSequentialGroup().addGap(5)
				.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_6).addComponent(
						pswConfirmarSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		contentPane.add(panel_5, "flowx,cell 1 5,alignx right,aligny center");

		JLabel lblNewLabel_7 = new JLabel("Perfil:");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 25));

		// TODO codigo do combobox usando enum
		JComboBox<TipoUsuario> comboBox = new JComboBox<>();
		for (TipoUsuario tipo : TipoUsuario.getTiposMedico()) {
			comboBox.addItem(tipo);
		}
		comboBox.setEditable(false);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_7)
					.addGap(5)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_7))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(7)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 153, 153));
		contentPane.add(panel, "flowx,cell 1 6,alignx center,aligny center");

		JButton btnVoltar = new VModelButton("Voltar");
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastro.dispose();
				VMainWindow frame = new VMainWindow(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});

		JButton btnCad = new VModelButton("Cadastrar novo médico");
		btnCad.setText("Cadastrar");
		btnCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean validarCampoTexto = true;

				// 1o passo: pegar o texto dos campos de texto
				String nome = txtNomeMed.getText();
				String estado = (String) cbEstado.getSelectedItem();
				String senha = String.valueOf(pswConfirmarSenha.getPassword());
				String confirmaSenha = String.valueOf(pswConfirmarSenha.getPassword());
				String login = txtLogin.getText();
				String crm = txtCRM.getText();
				String cpf = txtCPFMed.getText(); // regex (expressao regular) tambem seria uma forma
				int perfil = comboBox.getSelectedIndex();

				Medico medico = new Medico();

				// 2o passo: validar se texto é vazio ou nao
				// se nao for vazio
				try {
					if (nome != null && !nome.isEmpty()) {
						medico.setNome(nome);
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo NOME precisa ser preenchido");
						txtNomeMed.requestFocus();
						return;
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
					if (cpf != null && !cpf.isEmpty()) {

						if (cpf.equalsIgnoreCase("   .   .   -  ")) {
							JOptionPane.showMessageDialog(null, "O campo CPF precisa ser preenchido");
							txtCPFMed.requestFocus();
							return;
						} else {
							// 3o passo: o que tem mascara usar o metodo REPLACE da String
							cpf = cpf.replace(".", ""); // forma feia mas facil
							cpf = cpf.replace("-", "");

							// 4o passo: conversao de tipo pras variaveis que precisa (numeros) --- casting
							// (valueOf)
							Long cpfInt = Long.valueOf(cpf);

							// setar no obj
							medico.setCpf(cpfInt);
						}

					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo CPF precisa ser preenchido");
						txtCPFMed.requestFocus();
						return;
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
					if (crm != null) {
						crm = crm.trim();
						if (!crm.isEmpty() && crm.length() == 6) {
							Long crmLong = Long.valueOf(crm);
							medico.setCrm(crmLong);
						} else {
							validarCampoTexto = false;
							JOptionPane.showMessageDialog(null, "O campo CRM precisa ser preenchido");
							txtCRM.requestFocus();
							return;
						}

					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (login != null && !login.isEmpty()) {
						medico.getUsuario().setLogin(login);
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo LOGIN precisa ser preenchido");
						txtLogin.requestFocus();
						return;
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
					if (!senha.isEmpty() && !confirmaSenha.isEmpty()) {
						if (senha.equals(confirmaSenha)) {
							medico.getUsuario().setSenha(senha);
						} else {
							System.out.println(senha);
							System.out.println(confirmaSenha);
							validarCampoTexto = false;
							JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
							pswConfirmarSenha.requestFocus();
							return;
						}
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo Senha e Confrmar Senha precisam ser preenchido");
						pswConfirmarSenha.requestFocus();
						return;
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				// Fazer a verificação se tem algum estado selecionado se espaço espaço espaço,
				// exibe mensagem

				medico.setUf(estado);

				// try catch

				try {
					TipoUsuario perfilU = (TipoUsuario) comboBox.getSelectedItem();
					if (perfilU.equals(TipoUsuario.MED_COMUM)) {
						medico.getUsuario().setPefil(1);
					} else if (perfilU.equals(TipoUsuario.MED_ADMIN)) {
						medico.getUsuario().setPefil(0);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
					// se passar em todas as validacoes
					if (validarCampoTexto == true) {
						UsuarioDAO udao = new UsuarioDAO();
						udao.inserir(medico.getUsuario());
						// medico.getUsuario().setIdusuario(id);

						MedicoDAO mdao = new MedicoDAO();

						boolean validar = mdao.inserir(medico);
						if (validar == true) {
							// exibir uma mensagem de cadastro com sucesso
							JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						} else {
							// exibir mensagem de erro ao cadastrar
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar Medico");
						}
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 434, Short.MAX_VALUE).addComponent(btnCad,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel.setLayout(gl_panel);

		setLayout(new BorderLayout());
		add(contentPane, BorderLayout.CENTER);

	}
}

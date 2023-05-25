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

import controle.CDoctorDAO;
import controle.CUserDAO;
import modelo.MDoctor;
import modelo.MTypeUser;
import modelo.MUser;
import net.miginfocom.swing.MigLayout;

public class VEditDoctor extends JFrame {

	private JPanel contentPane;
	private JPasswordField pswSenha;
	private JTextField txtLogin;
	private JTextField txtCRM;
	private JFormattedTextField textField_2;
	private JTextField txtNomeMed;
	private JPasswordField pswConfirmarSenha;
	private MUser usuarioLogado;
	private JTextField txtCPFMed;
	private JComboBox<MTypeUser> comboBox = new JComboBox<>();
	private JComboBox<String> cbEstado;

	/**
	 * Create the frame.
	 * 
	 * @param telaCadastro
	 */
	public VEditDoctor(MUser usuarioLogado, VRegister telaCadastro, MDoctor d) {

		this.usuarioLogado = usuarioLogado;

		BufferedImage bg = null;
		try {
			bg = ImageIO.read(new File("src/main/java/imagens/TelacadMédico.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		contentPane = new VBackGround(bg);

		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[212.00,grow][443.00,grow][][196.00,grow]",
				"[70.00,grow][28.00,grow][64.00][55.00][60.00,grow][62.00,grow][57.00][44.00,grow][][grow][67.00,grow]"));

		JLabel lblNewLabel = new JLabel("Editar Médico");
		lblNewLabel.setForeground(new Color(19, 59, 93));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center,aligny bottom");

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(19, 59, 93));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1, "flowy,cell 1 2,alignx left,aligny center");

		txtNomeMed = new JTextField();
		txtNomeMed.setForeground(new Color(19, 59, 93));
		txtNomeMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(txtNomeMed, "cell 1 2,growx,aligny center");
		txtNomeMed.setColumns(10);

		textField_2 = new JFormattedTextField();
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setForeground(new Color(19, 59, 93));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_2, "flowy,cell 1 3,alignx left,aligny center");
		txtCPFMed = new JFormattedTextField(formatter);
		txtCPFMed.setForeground(new Color(19, 59, 93));
		txtCPFMed.setBounds(165, 190, 174, 20);
		contentPane.add(txtCPFMed);
		txtCPFMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(txtCPFMed, "cell 1 3,growx,aligny center");

		txtCPFMed.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_2, "cell 1 4,growx,aligny center");

		cbEstado = new JComboBox<>();
		cbEstado.setForeground(new Color(19, 59, 93));
		cbEstado.setFont(new Font("Times New Roman", Font.PLAIN, 15));
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
		txtCRM.setForeground(new Color(19, 59, 93));
		txtCRM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCRM.setColumns(10);
		textField_2 = new JFormattedTextField();

		JLabel lblNewLabel_3 = new JLabel("Código CRM:");
		lblNewLabel_3.setForeground(new Color(19, 59, 93));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JLabel lblNewLabel_3_1 = new JLabel("UF");
		lblNewLabel_3_1.setForeground(new Color(19, 59, 93));
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel_3).addContainerGap(217,
								Short.MAX_VALUE))
						.addComponent(txtCRM, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JLabel lblNewLabel_4 = new JLabel("Login:");
		lblNewLabel_4.setForeground(new Color(19, 59, 93));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_4, "flowy,cell 1 5,alignx left,aligny center");

		txtLogin = new JTextField();
		txtLogin.setForeground(new Color(19, 59, 93));
		txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(txtLogin, "cell 1 5,growx,aligny center");
		txtLogin.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Senha:");
		lblNewLabel_5.setForeground(new Color(19, 59, 93));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_5, "flowy,cell 1 6,alignx left,aligny center");

		pswSenha = new JPasswordField();
		pswSenha.setForeground(new Color(19, 59, 93));
		pswSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(pswSenha, "cell 1 6,growx,aligny center");

		JLabel lblNewLabel_6 = new JLabel("Confirme Senha:");
		lblNewLabel_6.setForeground(new Color(19, 59, 93));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_6, "flowy,cell 1 7,alignx left,aligny center");

		pswConfirmarSenha = new JPasswordField();
		pswConfirmarSenha.setForeground(new Color(19, 59, 93));
		pswConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(pswConfirmarSenha, "cell 1 7,growx,aligny center");
		comboBox.setForeground(new Color(19, 59, 93));

		// for (TipoUsuario tipo : TipoUsuario.values()) {
		// comboBox.addItem(tipo);
		// }
		comboBox.setEditable(false);
		comboBox.addItem(MTypeUser.MED_ADMIN);
		comboBox.addItem(MTypeUser.MED_COMUM);

		JLabel lblNewLabel_7 = new JLabel("Perfil:");
		lblNewLabel_7.setForeground(new Color(19, 59, 93));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_7, "flowy,cell 1 8,alignx left,aligny center");

		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(comboBox, "cell 1 8,growx,aligny center");

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_1, "cell 0 10,grow");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGap(0, 218, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGap(0, 62, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 153, 153));
		contentPane.add(panel, "cell 1 10,alignx center,aligny center");

		JButton btnCad = new VModelButton("Salvar");
		btnCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean validarCampoTexto = true;

				// 1o passo: pegar o texto dos campos de texto
				String nome = txtNomeMed.getText();
				String senha = String.valueOf(pswSenha.getPassword());
				String confirmaSenha = String.valueOf(pswConfirmarSenha.getPassword());
				String login = txtLogin.getText();
				String crm = txtCRM.getText();
				String uf = (String) cbEstado.getSelectedItem();
				String cpf = txtCPFMed.getText(); // regex (expressao regular) tambem seria uma forma
				int perfil = comboBox.getSelectedIndex();

				MDoctor medico = d;// new Medico();
				medico.setUf(uf);

				// 2o passo: validar se texto é vazio ou nao
				// se nao for vazio

				if (nome != null && !nome.isEmpty()) {
					medico.setNome(nome);
				} else {
					validarCampoTexto = false;
					JOptionPane.showMessageDialog(null, "O campo NOME precisa ser preenchido");
					txtNomeMed.requestFocus();
					return;
				}

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

				if (login != null && !login.isEmpty()) {
					medico.getUsuario().setLogin(login);
				} else {
					validarCampoTexto = false;
					JOptionPane.showMessageDialog(null, "O campo LOGIN precisa ser preenchido");
					txtLogin.requestFocus();
					return;
				}

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
					pswSenha.requestFocus();
					return;
				}

				MTypeUser perfilU = (MTypeUser) comboBox.getSelectedItem();
				if (perfilU.equals(MTypeUser.MED_COMUM)) {
					medico.getUsuario().setPefil(1);
				} else if (perfilU.equals(MTypeUser.MED_ADMIN)) {
					medico.getUsuario().setPefil(0);
				}
//				medico.setId(d.getId());
				// se passar em todas as validacoes
				if (validarCampoTexto == true) {
					CUserDAO udao = new CUserDAO();
					CDoctorDAO mdao = new CDoctorDAO();

					boolean validar = mdao.atualizar(medico);
					if (validar == true) {
						// exibir uma mensagem de atualizado com sucesso
						JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
					} else {
						// exibir mensagem de erro ao atualizar
						JOptionPane.showMessageDialog(null, "Erro ao atualizar Medico");
					}
				}

			}
		});

		JButton btnVoltar = new VModelButton("Cancelar");
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VListDoctor frame = new VListDoctor(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGap(160).addComponent(btnCad, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCad, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
						.addContainerGap()));
		panel.setLayout(gl_panel);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPane, BorderLayout.CENTER);
		preencheDados(d);
	}

	// TODO olhar como fazer a combo box selecionar o valor correto
	private void preencheDados(MDoctor d) {
		if (d != null) {
			txtNomeMed.setText(d.getNome());
			txtCPFMed.setText(String.valueOf(d.getCpf()));
			txtCRM.setText(String.valueOf(d.getCrm()));
			cbEstado.setSelectedItem(d.getUf());

			txtLogin.setText(d.getUsuario().getLogin());
			pswSenha.setText(d.getUsuario().getSenha());
			pswConfirmarSenha.setText(d.getUsuario().getSenha());
			comboBox.setSelectedItem(d.getUsuario().getPerfil());
		}
	}
}

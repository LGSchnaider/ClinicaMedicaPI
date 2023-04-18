package visao;

import java.awt.BorderLayout;
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
import controle.SecretariaDAO;
import controle.UsuarioDAO;
import modelo.Medico;
import modelo.Secretaria;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class TelaRegistrarSecretaria extends JPanel {

	private JPanel contentPane;
	private JTextField txtNome;
	private JButton btnVoltar;
	private JButton btnregistrar;
	private JPasswordField pswConfirmarSenha;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblnome;
	private JLabel lblUser;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPasswordField pswSenha;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField txtLogin;
	private Usuario usuarioLogado;
	private JLabel lblCpf;
	private JPanel panel_6;
	private JTextField txtCPF;
	private JPanel panel_7;
	private JLabel Email;
	private JPanel panel_8;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 * 
	 * @param cadastro
	 * @param s
	 */

	public TelaRegistrarSecretaria(Usuario usuarioLogado, Cadastro cadastro, Secretaria s) {
		this.usuarioLogado = usuarioLogado;

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 699);

		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/imagens/Telacadsecretária.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		contentPane = new PanelFundo(bg);
		contentPane.setOpaque(false);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[56.00,grow][131.00,grow,right][100.00,grow][110.00,grow][51.00,grow]", "[184.00,grow][73.00][][grow][28.00,grow][52.00][58.00,grow][45.00][29.00,grow][45.00][61.00,grow][35.00][70.00,grow]"));

		JLabel lblTitulo = new JLabel("Registrar Secretaria");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblTitulo, "cell 2 0,alignx center");

		lblnome = new JLabel("Nome:");
		lblnome.setForeground(new Color(255, 255, 255));
		lblnome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblnome, "cell 1 1,alignx trailing");

		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		contentPane.add(panel_4, "cell 2 1,growx,aligny center");

		txtNome = new JTextField();
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNome.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
				gl_panel_4.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_4.createSequentialGroup()
						.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE).addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4
						.createSequentialGroup().addGap(23).addComponent(txtNome, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblCpf, "cell 1 3");

		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		contentPane.add(panel_6, "cell 2 3,growx,aligny center");

		txtCPF = new JTextField();
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtCPF = new JFormattedTextField(formatter);
		txtCPF.setColumns(10);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_6.createSequentialGroup().addComponent(txtCPF, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap()
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_6.setLayout(gl_panel_6);

		lblUser = new JLabel("Login:");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblUser, "flowx,cell 1 5,alignx trailing");

		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		contentPane.add(panel_3, "cell 2 5,growx,aligny center");

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogin.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_3.createSequentialGroup()
						.addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(txtLogin,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_3.setLayout(gl_panel_3);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		contentPane.add(panel_7, "cell 1 6,alignx right,aligny center");
		
		Email = new JLabel("Email:");
		Email.setFont(new Font("Times New Roman", Font.BOLD, 25));
		Email.setForeground(new Color(255, 255, 255));
		panel_7.add(Email);
		
		panel_8 = new JPanel();
		panel_8.setOpaque(false);
		contentPane.add(panel_8, "cell 2 6,growx,aligny center");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(5)
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);

		lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_2, "cell 1 7,alignx trailing");

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		contentPane.add(panel_2, "cell 2 7,growx,aligny center");

		pswSenha = new JPasswordField();
		pswSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_2.createSequentialGroup()
						.addComponent(pswSenha, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		lblNewLabel_1 = new JLabel("Confirme Senha:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1, "cell 1 9,alignx trailing");

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, "cell 2 9,growx,aligny center");

		pswConfirmarSenha = new JPasswordField();
		pswConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_1.createSequentialGroup()
						.addComponent(pswConfirmarSenha, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(pswConfirmarSenha, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("Função:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel, "cell 1 10,alignx right,aligny center");

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		contentPane.add(panel_5, "cell 2 10,growx,aligny center");

		JComboBox<TipoUsuario> cbFuncao = new JComboBox<>();
		for (TipoUsuario tipo : TipoUsuario.values()) {
			cbFuncao.addItem(tipo);
		}

		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_5.createSequentialGroup().addComponent(cbFuncao, 0, 514, Short.MAX_VALUE).addContainerGap()));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5
						.createSequentialGroup().addContainerGap(15, Short.MAX_VALUE).addComponent(cbFuncao,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_5.setLayout(gl_panel_5);

		panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 2 11,grow");

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro.dispose();
				TelaPrincipal frame = new TelaPrincipal(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});

		btnregistrar = new JButton();
		btnregistrar.setText("Registrar");
		if (s == null) {
			btnregistrar.setText("Registrar");

		} else {
			btnregistrar.setText("Editar");

		}

		btnregistrar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnregistrar.addActionListener(new ActionListener() {
			// TODO Adicionar Comando de Insert
			public void actionPerformed(ActionEvent e) {

				boolean validarCampoTexto = true;

				// 1o passo: pegar o texto dos campos de texto
				String nome = txtNome.getText();
				String senha = String.valueOf(pswSenha.getPassword());
				String confirmaSenha = String.valueOf(pswConfirmarSenha.getPassword());
				String login = txtLogin.getText();
				String Email = txtEmail.getText();
				String cpf = txtCPF.getText(); // regex (expressao regular) tambem seria uma forma
				int perfil = cbFuncao.getSelectedIndex();

				Secretaria secretaria = new Secretaria();

				// 2o passo: validar se texto é vazio ou nao
				// se nao for vazio

				try {
					if (nome != null && !nome.isEmpty()) {
						secretaria.setNome(nome);
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo NOME precisa ser preenchido");
						txtNome.requestFocus();
						return;
					}

				} catch (Exception e2) {

				}

				try {
					if (cpf != null && !cpf.isEmpty()) {

						if (cpf.equalsIgnoreCase("   .   .   -  ")) {
							JOptionPane.showMessageDialog(null, "O campo CPF precisa ser preenchido");
							txtCPF.requestFocus();
							return;
						} else {
							// 3o passo: o que tem mascara usar o metodo REPLACE da String
							cpf = cpf.replace(".", ""); // forma feia mas facil
							cpf = cpf.replace("-", "");

							// 4o passo: conversao de tipo pras variaveis que precisa (numeros) --- casting
							// (valueOf)
							Long cpfInt = Long.valueOf(cpf);

							// setar no obj
							secretaria.setCpf(cpfInt);
						}

					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo CPF precisa ser preenchido");
						txtCPF.requestFocus();
						return;
					}

				} 
				catch (Exception e2) {
					// TODO: handle exception
				}

				try {
					if (Email != null && !Email.isEmpty()) {
						
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo EMAIL precisa ser preenchido");
						txtEmail.requestFocus();
						return;
					}

				}
				catch (Exception e2) {
					// TODO: handle exception
				}

				try {
					if (login != null && !login.isEmpty()) {
						secretaria.getUsuario().setLogin(login);
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo LOGIN precisa ser preenchido");
						txtLogin.requestFocus();
						return;
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

				try {
					if (!senha.isEmpty() && !confirmaSenha.isEmpty()) {
						if (senha.equals(confirmaSenha)) {
							secretaria.getUsuario().setSenha(senha);
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

				} catch (Exception e2) {
					// TODO: handle exception
				}

				try {
					TipoUsuario perfilU = (TipoUsuario) cbFuncao.getSelectedItem();
					if (perfilU.equals(TipoUsuario.SEC_COMUM)) {
						secretaria.getUsuario().setPefil(3); // TODO ajustar
					} else {
						secretaria.getUsuario().setPefil(2); // TODO ajustar
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

				// se passar em todas as validacoes
				try {
					if (validarCampoTexto == true) {
						UsuarioDAO udao = new UsuarioDAO();
						SecretariaDAO sdao = new SecretariaDAO();
						if (s == null) {
							udao.inserir(secretaria.getUsuario());
							// medico.getUsuario().setIdusuario(id);

							sdao.inserir(secretaria);
						} else {
							// acao de alterar no banco registro - UPDATE
							secretaria.setId(s.getId());
							secretaria.getUsuario().setIdusuario(s.getUsuario().getIdusuario());

							udao.atualizar(secretaria.getUsuario());
							sdao.atualizar(secretaria);
							return;

						}

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(26)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
						.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGap(20)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(27)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		setLayout(new BorderLayout());
		add(contentPane, BorderLayout.CENTER);

	
		//TODO Observar e juntar ao médico.
preencheDados(s);
	}

	private void preencheDados(Secretaria s) {
		if (s != null) {
			txtNome.setText(s.getNome());
			txtCPF.setText(String.valueOf(s.getCpf()));
			txtLogin.setText(s.getUsuario().getLogin());
			txtEmail.setText(s.getEmail());
			pswSenha.setText(s.getUsuario().getSenha());
			pswConfirmarSenha.setText(s.getUsuario().getSenha());
		}

	}
}

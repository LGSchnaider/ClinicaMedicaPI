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
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class VRegisterSecretary extends JPanel {

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
	private JPasswordField pswSenha;
	private JPanel panel_4;
	private JTextField txtLogin;
	private Usuario usuarioLogado;
	private JLabel lblCpf;
	private JTextField txtCPF;
	private JTextField txtCPF_1;
	private JLabel Email;
	private JPanel panel_8;
	private JTextField txtEmail;
	private JLabel lblNewLabel_3;
	private JPanel panel_9;
	private JTextField txtTelefone;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 * 
	 * @param cadastro
	 * @param s
	 */

	public VRegisterSecretary(Usuario usuarioLogado, VRegister cadastro, Secretaria s) {
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

		contentPane = new VBackGround(bg);
		contentPane.setOpaque(false);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[105.00,grow,right][749.00,fill][50,grow,left]", "[170.00,grow][][98.00][58.00][45.00][35.00][70.00,grow]"));
				
				panel_2 = new JPanel();
				panel_2.setOpaque(false);
				contentPane.add(panel_2, "cell 1 0,alignx center,aligny center");
				panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				JLabel lblNewLabel_4 = new JLabel("Cadastrar Secretária");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setForeground(new Color(19, 59, 93));
				lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 40));
				panel_2.add(lblNewLabel_4);

		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		contentPane.add(panel_4, "cell 1 1,growx,aligny center");

		txtNome = new JTextField();
		txtNome.setForeground(new Color(19, 59, 93));
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNome.setColumns(10);

		lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setForeground(new Color(19, 59, 93));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));

		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("(##) #####-####");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(formatter);
		txtTelefone.setForeground(new Color(19, 59, 93));
		txtTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTelefone.setColumns(10);
		
				lblnome = new JLabel("Nome:");
				lblnome.setForeground(new Color(19, 59, 93));
				lblnome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblnome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addGap(99)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
					.addGap(219))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblnome))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);

		panel_9 = new JPanel();
		panel_9.setOpaque(false);
		contentPane.add(panel_9, "cell 1 2,alignx center,aligny center");

		txtCPF = new JTextField();
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtCPF_1 = new JFormattedTextField(formatter);
		txtCPF_1.setForeground(new Color(19, 59, 93));
		txtCPF_1.setHorizontalAlignment(SwingConstants.LEFT);
		txtCPF_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCPF_1.setColumns(10);

		Email = new JLabel("Email:");
		Email.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Email.setForeground(new Color(19, 59, 93));

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(19, 59, 93));
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		
				lblCpf = new JLabel("CPF:");
				lblCpf.setForeground(new Color(19, 59, 93));
				lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(177)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCPF_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf))
					.addGap(93)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(Email)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
					.addGap(217))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(Email)
						.addComponent(lblCpf))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPF_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_9.setLayout(gl_panel_9);

		panel_8 = new JPanel();
		panel_8.setOpaque(false);
		contentPane.add(panel_8, "cell 1 3,growx,aligny center");

		txtLogin = new JTextField();
		txtLogin.setForeground(new Color(19, 59, 93));
		txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtLogin.setColumns(10);

		lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(19, 59, 93));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));

		pswSenha = new JPasswordField();
		pswSenha.setForeground(new Color(19, 59, 93));
		pswSenha.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
				lblUser = new JLabel("Login:");
				lblUser.setForeground(new Color(19, 59, 93));
				lblUser.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(170)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUser)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
					.addGap(219))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblUser))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_8.setLayout(gl_panel_8);

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, "cell 1 4,growx,aligny center");

		pswConfirmarSenha = new JPasswordField();
		pswConfirmarSenha.setForeground(new Color(19, 59, 93));
		pswConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		JLabel lblNewLabel = new JLabel("Perfil:");
		lblNewLabel.setForeground(new Color(19, 59, 93));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JComboBox<TipoUsuario> cbFuncao = new JComboBox<>();
		cbFuncao.setForeground(new Color(19, 59, 93));
		cbFuncao.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbFuncao.setEditable(false);
		
				lblNewLabel_1 = new JLabel("Confirme Senha:");
				lblNewLabel_1.setForeground(new Color(19, 59, 93));
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(174)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(pswConfirmarSenha, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(cbFuncao, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
					.addGap(215))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswConfirmarSenha, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		for (TipoUsuario tipo : TipoUsuario.getTiposSecretarias()) {
			cbFuncao.addItem(tipo);
		}

		panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 1 5,alignx center,growy");

		btnVoltar = new VModelButton("Voltar");
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//esse if pode mudar, mas fica assim por enquanto
				if(s== null) {
				dispose();
				VMainWindow frame = new VMainWindow(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				}else {
				dispose();
				VListSecretary frame = new VListSecretary(usuarioLogado); 
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				}
			}
		});

		btnregistrar = new VModelButton("Registrar");
		btnregistrar.setText("Cadastrar");
		if (s == null) {
			btnregistrar.setText("Registrar");

		} else {
			btnregistrar.setText("Editar");

		}

		btnregistrar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
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
				String telefone = txtTelefone.getText();
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
					String telefones = telefone.replace(")", ""); // forma feia mas facil
					telefones = telefones.replace("(", ""); // forma feia mas facil
					telefones = telefones.replace("-", "");
					telefones = telefones.replace(" ", "");
					telefones = telefones.strip();
					if (!telefones.isEmpty()) {
						Long telefoneInt = Long.valueOf(telefones);
						secretaria.setTelefone(telefoneInt);
					} else {
						System.out.println(telefones);
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo TELEFONE precisa ser preenchido");
						txtTelefone.requestFocus();
						return;
					}

				} catch (Exception e2) {
					e2.printStackTrace();
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

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (Email != null && !Email.isEmpty()) {
						secretaria.setEmail(Email);
					} else {
						validarCampoTexto = false;
						JOptionPane.showMessageDialog(null, "O campo EMAIL precisa ser preenchido");
						txtEmail.requestFocus();
						return;
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
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
					e2.printStackTrace();
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
					e2.printStackTrace();
				}

				try {
					TipoUsuario perfilU = (TipoUsuario) cbFuncao.getSelectedItem();
					if (perfilU.equals(TipoUsuario.SEC_COMUM)) {
						secretaria.getUsuario().setPefil(3);
					} else {
						secretaria.getUsuario().setPefil(2);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				// se passar em todas as validacoes
				try {
					if (validarCampoTexto == true) {
						UsuarioDAO udao = new UsuarioDAO();

						SecretariaDAO sdao = new SecretariaDAO();

						if (s == null) {
							udao.inserir(secretaria.getUsuario());
							// medico.getUsuario().setIdusuario(id);

							boolean validar = sdao.inserir(secretaria);
							if (validar == true) {
								// exibir uma mensagem de cadastro com sucesso
								JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
							} else {
								// exibir mensagem de erro ao cadastrar
								JOptionPane.showMessageDialog(null, "Erro ao cadastrar Secretária");
							}

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
					e2.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(174)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
					.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(211))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		setLayout(new BorderLayout());
		add(contentPane, BorderLayout.CENTER);

		// TODO Observar e juntar ao médico.
		preencheDados(s);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	private void preencheDados(Secretaria s) {
		if (s != null) {
			txtNome.setText(s.getNome());
			txtCPF.setText(String.valueOf(s.getCpf()));
			txtLogin.setText(s.getUsuario().getLogin());
			txtEmail.setText(s.getEmail());
			pswSenha.setText(s.getUsuario().getSenha());
			pswConfirmarSenha.setText(s.getUsuario().getSenha());
			txtTelefone.setText(String.valueOf(s.getTelefone()));
		}

	}
}

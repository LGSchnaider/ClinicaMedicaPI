package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.MedicoDAO;
import controle.PacienteDAO;
import controle.SecretariaDAO;
import controle.UsuarioDAO;
import modelo.Paciente;
import modelo.Secretaria;
import modelo.TipoSexo;
import modelo.TipoUsuario;
import modelo.Usuario;
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

public class VRegisterPatient extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtcpfP;
	private JTextField txtTelefoneP;
	private JTextField txtEmail;
	private Usuario usuarioLogado;

	/**
	 * Launch the application.
	 */

	public VRegisterPatient(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		
//		TelaRegistrarPaciente frame = new TelaRegistrarPaciente();
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximizar
//		frame.setVisible(true);
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 600);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/imagens/TelacadPaciente.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		contentPane = new VBackGround(bg);
		contentPane.setBackground(new Color(0, 156, 156));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[28.00,grow][][690px,grow][51.00][29.00,grow]", "[44.00,grow][391px,grow][][grow][28.00]"));

		JLabel lblNewLabel_5 = new JLabel("Cadastar Paciente");
		lblNewLabel_5.setForeground(new Color(19, 59, 93));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNewLabel_5, "cell 2 0,alignx center,growy");

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 156, 156));
		contentPane.add(panel, "cell 2 1,alignx center,growy");
		panel.setLayout(new MigLayout("", "[72.00][321.00,grow]", "[grow][56.00,grow][68.00,grow][61.00,grow][68.00,grow]"));

		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setForeground(new Color(19, 59, 93));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel_4, "cell 0 1,alignx center,aligny center");

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0, 156, 156));
		panel.add(panel_1, "cell 1 1,alignx center,aligny center");

		txtNome = new JTextField();
		txtNome.setForeground(new Color(19, 59, 93));
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNome.setColumns(10);
		
				JLabel lblNewLabel_3 = new JLabel("CPF:");
				lblNewLabel_3.setForeground(new Color(19, 59, 93));
				lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
				txtcpfP = new JTextField();
				MaskFormatter formatter = null;
				try {
					formatter = new MaskFormatter("###.###.###-##");
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				
		JTextField txtCpf = new JFormattedTextField(formatter);
		txtCpf.setForeground(new Color(19, 59, 93));
		txtCpf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		panel_1.setLayout(gl_panel_1);
		
				JLabel lblNewLabel_2 = new JLabel("Telefone:");
				lblNewLabel_2.setForeground(new Color(19, 59, 93));
				lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
				panel.add(lblNewLabel_2, "cell 0 2,alignx center,aligny center");

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(0, 156, 156));
		panel.add(panel_2, "flowx,cell 1 2,alignx center,aligny center");

		try {
			formatter = new MaskFormatter("(##) #####-####");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		JTextField txtTelefone = new JFormattedTextField(formatter);
		txtTelefone.setForeground(new Color(19, 59, 93));
		txtTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTelefone.setColumns(10);
		txtTelefoneP = new JTextField();
		
				JLabel lblNewLabel_1 = new JLabel("Sexo:");
				lblNewLabel_1.setForeground(new Color(19, 59, 93));
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
				JComboBox <String> cbSexo = new JComboBox<>();
				cbSexo.setForeground(new Color(19, 59, 93));
				cbSexo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				cbSexo.addItem("Não Definido");
				cbSexo.addItem("Masculino");
				cbSexo.addItem("Feminino");
				cbSexo.setEditable(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbSexo, 0, 256, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(7)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1)
						.addComponent(cbSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		panel_2.setLayout(gl_panel_2);
		
				JLabel lblNewLabel = new JLabel("E-mail:");
				lblNewLabel.setForeground(new Color(19, 59, 93));
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
				panel.add(lblNewLabel, "cell 0 3,alignx center,aligny center");

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(0, 156, 156));
		panel.add(panel_3, "flowx,cell 1 3,alignx center,aligny center");
		
				txtEmail = new JTextField();
				txtEmail.setForeground(new Color(19, 59, 93));
				txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				txtEmail.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(27)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBackground(new Color(0, 156, 156));
		panel.add(panel_4, "flowx,cell 1 4,grow");
		
				JButton btnVoltar = new VModelButton("Voltar");
				btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						VMainWindow frame = new VMainWindow(usuarioLogado); 
						frame.setLocationRelativeTo(null);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
					}
				});
		
				JButton btnInserir = new VModelButton("Cadastrar");
				btnInserir.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						boolean validarCampoTexto = true;

						// 1o passo: pegar o texto dos campos de texto
						String nome = txtNome.getText();
						String cpf = txtCpf.getText(); // regex (expressao regular) tambem seria uma forma
						String telefone = txtTelefone.getText();
						String sexo = (String) cbSexo.getSelectedItem();
						
						if(sexo.equals("Masculino")){
							sexo = "M";
						}else if(sexo.equals("Feminino")) {
							sexo = "F";
						}else {
							sexo = "N";
						}
							
						String email = txtEmail.getText();
	
						Paciente paciente = new Paciente();

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
							if (cpf != null && !cpf.isEmpty()) {

								if (cpf.equalsIgnoreCase("   .   .   -  ")) {
									JOptionPane.showMessageDialog(null, "O campo CPF precisa ser preenchido");
									txtCpf.requestFocus();
									return;
								} else {
									// 3o passo: o que tem mascara usar o metodo REPLACE da String
									cpf = cpf.replace(".", ""); // forma feia mas facil
									cpf = cpf.replace("-", "");

									// 4o passo: conversao de tipo pras variaveis que precisa (numeros) --- casting
									// (valueOf)
									Long cpfInt = Long.valueOf(cpf);

									// setar no obj
									paciente.setCpf(cpfInt);
								}

							} else {
								validarCampoTexto = false;
								JOptionPane.showMessageDialog(null, "O campo CPF precisa ser preenchido");
								txtCpf.requestFocus();
								return;
							}

						} catch (Exception e2) {
							e2.printStackTrace();
						}
						try {
							
							if (telefone != null && !telefone.isEmpty()) {
								    String telefones = telefone.replace(")", ""); // forma feia mas facil
									telefones = telefones.replace("(", ""); // forma feia mas facil
									telefones = telefones.replace("-", "");
									telefones = telefones.replace(" ", "");
									telefones = telefones.strip();
									//if (telefone.equalsIgnoreCase("(  )    -    ")) {
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
							if(cbSexo.getSelectedIndex()== 0) {
								validarCampoTexto = false;
								JOptionPane.showMessageDialog(null, "O campo SEXO precisa ser selecionado");
								cbSexo.requestFocus();
								return;
							}else {
								validarCampoTexto = true;
								paciente.setSexo(TipoSexo.obterTipo(sexo));
						
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
								PacienteDAO pdao = new PacienteDAO();
					
								boolean validar = pdao.inserir(paciente);
								if (validar == true) {
									// exibir uma mensagem de cadastro com sucesso
									JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
								} else {
									// exibir mensagem de erro ao cadastrar
									JOptionPane.showMessageDialog(null, "Erro ao cadastrar Paciente");
								}
							}
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
						
						
					}
				});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(102)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
					.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
	}
}

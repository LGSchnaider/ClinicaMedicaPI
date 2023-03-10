package visao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaRegistrarSecretaria extends JPanel {

	private JPanel contentPane;
	private JTextField txtNome;
	private JButton btnVoltar;
	private JButton btnregistrar;
	private JPasswordField passwordField_1;
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

	/**
	 * Launch the application.
	 */
	
	public TelaRegistrarSecretaria() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[56.00,grow][131.00,grow,right][100.00][110.00,grow][51.00,grow]", "[184.00,grow][73.00][28.00,grow][52.00][grow][45.00][29.00,grow][45.00][61.00,grow][35.00][70.00,grow]"));
		
		JLabel lblTitulo = new JLabel("Registrar Secretaria");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 60));
		contentPane.add(lblTitulo, "cell 2 0,alignx center");
		
		lblnome = new JLabel("Nome:");
		lblnome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblnome, "cell 1 1,alignx trailing");
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, "cell 2 1,grow");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(23)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		lblUser = new JLabel("Login:");
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblUser, "flowx,cell 1 3,alignx trailing");
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, "cell 2 3,grow");
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2, "cell 1 5,alignx trailing");
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, "cell 2 5,grow");
		
		pswSenha = new JPasswordField();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addComponent(pswSenha, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		lblNewLabel_1 = new JLabel("Confirme Senha:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1, "cell 1 7,alignx trailing");
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 2 7,grow");
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Fun????o:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, "cell 1 8,alignx right,aligny center");
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, "cell 2 8,growx,aligny center");
		
		JComboBox <String> cbFuncao = new JComboBox();
		cbFuncao.addItem("Junior");
		cbFuncao.addItem("Administradora");
		
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(cbFuncao, 0, 514, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(cbFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		panel = new JPanel();
		contentPane.add(panel, "cell 2 9,grow");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				TelaPrincipal frame = new TelaPrincipal();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		
		btnregistrar = new JButton("Registrar");
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnregistrar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		setLayout(new BorderLayout());
		add(contentPane, BorderLayout.CENTER);
	}
}

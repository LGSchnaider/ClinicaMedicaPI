package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TelaInicio extends JFrame {
	private JTextField textFieldLog;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximizar
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
	public TelaInicio() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setForeground(new Color(3, 152, 158));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 900);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel up = new JPanel();
		getContentPane().add(up, BorderLayout.NORTH);

		JPanel down = new JPanel();
		getContentPane().add(down, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Farmacos");
		down.add(lblNewLabel);

		JPanel center = new JPanel();
		center.setBackground(new Color(0, 128, 128));
		center.setForeground(new Color(0, 128, 128));
		getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new MigLayout("", "[209.00][246.00,grow][][254.00,grow][205.00,grow][330.00]", "[pref!,grow][92.00][133.00][70,grow][83.00][96.00][][38.00,grow]"));

		JLabel lblNewLabel_1 = new JLabel("Clínica Médica");
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		center.add(lblNewLabel_1, "cell 3 1,alignx center");

		JLabel lblNewLabel_2 = new JLabel("INICIO");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		center.add(lblNewLabel_2, "cell 3 2,alignx center");

		JPanel LOG = new JPanel();
		LOG.setBackground(new Color(0, 128, 128));
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// CHAMA A CLASSE LOGIN
				TelaCadastro frame = new TelaCadastro();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				// TERMINA O CHAMADO
			}
		});

		btnCadastrar.setMinimumSize(new Dimension(97, 23));
		btnCadastrar.setMaximumSize(new Dimension(97, 23));

		center.add(LOG, "cell 3 3,alignx center");
		GroupLayout gl_LOG = new GroupLayout(LOG);
		gl_LOG.setHorizontalGroup(gl_LOG.createParallelGroup(Alignment.LEADING).addComponent(btnCadastrar,
				GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE));
		gl_LOG.setVerticalGroup(gl_LOG.createParallelGroup(Alignment.LEADING).addComponent(btnCadastrar,
				GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE));
		LOG.setLayout(gl_LOG);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		center.add(lblLogin, "cell 2 4,alignx trailing");

		textFieldLog = new JTextField();
		center.add(textFieldLog, "cell 3 4,growx,aligny center");
		textFieldLog.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 30));
		center.add(lblSenha, "cell 2 5,alignx trailing");

		textFieldSenha = new JTextField();
		center.add(textFieldSenha, "cell 3 5,growx");
		textFieldSenha.setColumns(10);

		JButton btnLogOff = new JButton("Sair");
//		center.add(btnLogOff, "cell 3 6,alignx center");
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		center.add(panel, "cell 3 6,alignx center,aligny center");
		
		JButton btnLogin = new JButton("Login");

		center.add(btnLogin, "cell 1 4,alignx center");
		btnLogin.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
			});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		JPanel OFF = new JPanel();
		OFF.setBackground(new Color(0, 128, 128));
		center.add(OFF, "flowx,cell 3 7,alignx center");
//		gl_OFF.setHorizontalGroup(gl_OFF.createParallelGroup(Alignment.LEADING).addGap(0, 10, Short.MAX_VALUE));
//		gl_OFF.setVerticalGroup(gl_OFF.createParallelGroup(Alignment.LEADING).addComponent(btnLogOff,
//				GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE));
		OFF.add(btnLogOff);
		GroupLayout gl_OFF = new GroupLayout(OFF);
		gl_OFF.setHorizontalGroup(
			gl_OFF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OFF.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogOff, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_OFF.setVerticalGroup(
			gl_OFF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OFF.createSequentialGroup()
					.addComponent(btnLogOff, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addContainerGap())
		);
		OFF.setLayout(gl_OFF);
	}
}

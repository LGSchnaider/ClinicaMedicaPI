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

public class TelaInicio extends JFrame {

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
		getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new MigLayout("", "[310.00,grow][223.00,grow][330.00,grow]", "[pref!,grow][92.00,grow][40,grow][70,grow][70,grow][70,grow][38.00,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Clínica Médica");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		center.add(lblNewLabel_1, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("INICIO");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		center.add(lblNewLabel_2, "cell 1 2,alignx center");
		
		JPanel LOG = new JPanel();
		LOG.setLayout(new GridLayout(1, 1, 0, 0));
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
		LOG.add(btnCadastrar);
		
		btnCadastrar.setMinimumSize(new Dimension(97, 23));
		btnCadastrar.setMaximumSize(new Dimension(97, 23));
		
		
		center.add(LOG, "cell 1 3,alignx center");
		
		JButton btnLogin = new JButton("Login");
		center.add(btnLogin, "cell 1 4,alignx center");
		btnLogin.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e) {
					dispose();
					// CHAMA A CLASSE LOGIN
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					// TERMINA O CHAMADO
				}
			});
		
		JButton btnLogOff = new JButton("Sair");
		center.add(btnLogOff, "cell 1 5,alignx center");
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

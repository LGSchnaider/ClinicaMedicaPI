package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnVoltar;
	private JButton btnregistrar;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblnome;
	private JLabel lblUser;

	/**
	 * Launch the application.
	 */
	
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][][][grow][][grow][grow]", "[184.00,grow][73.00,grow][72.00,grow][68.00,grow][61.00,grow][47.00,grow][grow]"));
		
		JLabel lblTitulo = new JLabel("Registrar");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblTitulo, "cell 4 0,alignx center");
		
		lblnome = new JLabel("Nome");
		contentPane.add(lblnome, "cell 3 1,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 4 1,growx");
		textField.setColumns(10);
		
		lblUser = new JLabel("Usuario");
		contentPane.add(lblUser, "flowx,cell 3 2,alignx trailing");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 4 2,growx");
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Senha");
		contentPane.add(lblNewLabel_2, "cell 3 3,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 4 3,growx");
		
		lblNewLabel_1 = new JLabel("Confirme Senha");
		contentPane.add(lblNewLabel_1, "cell 3 4,alignx trailing");
		
		passwordField_1 = new JPasswordField();
		contentPane.add(passwordField_1, "cell 4 4,growx");
		
		btnregistrar = new JButton("Registrar");
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnVoltar, "flowx,cell 3 5,alignx center,aligny center");
		contentPane.add(btnregistrar, "cell 5 5,alignx center,aligny center");
	}

}

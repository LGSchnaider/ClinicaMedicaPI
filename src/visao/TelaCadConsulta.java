package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNome;
	private JTextField txtCPFp;
	private JTextField textField_4;
	private final JButton btnNewButton_1 = new JButton("Cadastrar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadConsulta frame = new TelaCadConsulta();
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
	public TelaCadConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,right][][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Consulta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 1 1,growx");
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		contentPane.add(lblNewLabel_2, "cell 0 2");
		
		txtCPFp = new JTextField();
		contentPane.add(txtCPFp, "cell 1 2,growx");
		txtCPFp.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		contentPane.add(lblNewLabel_3, "cell 0 3");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 3,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo:");
		contentPane.add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		JComboBox cbSexo = new JComboBox();
		contentPane.add(cbSexo, "cell 1 5,growx,aligny center");
		
		JLabel lblNewLabel_5 = new JLabel("E-mail");
		contentPane.add(lblNewLabel_5, "cell 0 4,alignx trailing");
		
		textField_4 = new JTextField();
		contentPane.add(textField_4, "cell 1 4,growx");
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal frame = new TelaPrincipal();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton, "cell 0 6,alignx center,aligny baseline");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton_1, "cell 2 6,alignx center,aligny baseline");
	}

}

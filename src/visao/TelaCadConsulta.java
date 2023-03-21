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
import java.awt.Choice;
import java.awt.TextArea;

public class TelaCadConsulta extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton_1 = new JButton("Cadastrar");
	private JTextField textField;
	private JTextField textField_1;

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
		contentPane.setLayout(new MigLayout("", "[grow,right][grow][grow]", "[grow][grow][grow][grow][grow][grow][91.00,grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Consulta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center");
		
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
		
		JLabel lblNewLabel_6 = new JLabel("Paciente");
		contentPane.add(lblNewLabel_6, "cell 0 2");
		
		Choice choice = new Choice();
		contentPane.add(choice, "cell 1 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		contentPane.add(lblNewLabel_1, "cell 0 3");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 3,grow");
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow]"));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 0 0,growx");
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2, "cell 1 0,growx");
		
		JComboBox comboBox_3 = new JComboBox();
		panel.add(comboBox_3, "cell 2 0,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Hora:");
		contentPane.add(lblNewLabel_2, "cell 0 4");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 4,growx");
		panel_1.setLayout(new MigLayout("", "[30px,grow,fill][grow]", "[22px,grow,fill]"));
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1, "cell 0 0");
		
		JComboBox comboBox_4 = new JComboBox();
		panel_1.add(comboBox_4, "cell 1 0,growx");
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "cell 0 5,grow");
		panel_3.setLayout(new MigLayout("", "[46px,grow]", "[grow][14px,grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("Doença:");
		panel_3.add(lblNewLabel_3, "cell 0 0,alignx right,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("Valor:");
		panel_3.add(lblNewLabel_4, "cell 0 1,alignx right,aligny center");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "cell 1 5,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		textField = new JTextField();
		panel_2.add(textField, "cell 0 0,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1, "cell 0 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Descrição:");
		contentPane.add(lblNewLabel_5, "cell 0 6,alignx right,aligny center");
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea, "cell 1 6,growx");
		contentPane.add(btnNewButton, "cell 0 7,alignx center,aligny baseline");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton_1, "cell 2 7,alignx center,aligny baseline");
	}

}

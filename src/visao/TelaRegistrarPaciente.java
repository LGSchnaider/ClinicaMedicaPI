package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaRegistrarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeP;
	private JTextField txtcpfP;
	private JTextField txtTelefoneP;
	private JTextField txtEmailP;

	/**
	 * Launch the application.
	 */
	
	public TelaRegistrarPaciente() {
		TelaRegistrarPaciente frame = new TelaRegistrarPaciente();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximizar
		frame.setVisible(true);
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][690px,grow][]", "[44.00,grow][391px,grow][grow][28.00]"));
		
		JLabel lblNewLabel_5 = new JLabel("Cadastar Paciente");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5, "cell 2 0,alignx center");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 2 1,grow");
		panel.setLayout(new MigLayout("", "[72.00][321.00,grow]", "[][56.00][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		panel.add(lblNewLabel_4, "cell 0 1,alignx trailing");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 1 1,grow");
		
		txtNomeP = new JTextField();
		txtNomeP.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNomeP, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNomeP)
					.addGap(25))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		panel.add(lblNewLabel_3, "cell 0 2,alignx trailing");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "flowx,cell 1 2");
		
		txtcpfP = new JTextField();
		txtcpfP.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(txtcpfP, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtcpfP)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone para contato:");
		panel.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "flowx,cell 1 3");
		
		txtTelefoneP = new JTextField();
		txtTelefoneP.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTelefoneP, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTelefoneP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Sexo:");
		panel.add(lblNewLabel_1, "cell 0 4,alignx trailing");
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "flowx,cell 1 4");
		
		JComboBox cbSexo = new JComboBox();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(cbSexo, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewLabel = new JLabel("E-mail para contato:");
		panel.add(lblNewLabel, "cell 0 5,alignx trailing");
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "flowx,cell 1 5");
		
		txtEmailP = new JTextField();
		txtEmailP.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addComponent(txtEmailP, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtEmailP)
					.addGap(5))
		);
		panel_5.setLayout(gl_panel_5);
		
		JButton btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 0 2");
		
		JButton btnInserir = new JButton("Cadastrar");
		contentPane.add(btnInserir, "cell 3 2,alignx center,aligny center");
	}
}

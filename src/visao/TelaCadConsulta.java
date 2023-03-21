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
	private final JButton btnCad = new JButton("Cadastrar");
	private JTextField txtDoenca;
	private JTextField txtValor;

	public TelaCadConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,right][grow][grow]", "[grow][grow][grow][grow][grow][grow][110.00][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Consulta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center");
		
		JButton btnVolta = new JButton("Voltar");
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal frame = new TelaPrincipal();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Paciente:");
		contentPane.add(lblNewLabel_6, "cell 0 2");
		
		Choice chPaci = new Choice();
		contentPane.add(chPaci, "cell 1 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		contentPane.add(lblNewLabel_1, "cell 0 3");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 3,grow");
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow]"));
		
		JComboBox cbDia = new JComboBox();
		panel.add(cbDia, "cell 0 0,growx");
		
		JComboBox cbMes = new JComboBox();
		panel.add(cbMes, "cell 1 0,growx");
		
		JComboBox cbAno = new JComboBox();
		panel.add(cbAno, "cell 2 0,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Hora:");
		contentPane.add(lblNewLabel_2, "cell 0 4");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 4,growx");
		panel_1.setLayout(new MigLayout("", "[30px,grow,fill][grow]", "[22px,grow,fill]"));
		
		JComboBox cbHora = new JComboBox();
		panel_1.add(cbHora, "cell 0 0");
		
		JComboBox cbMin = new JComboBox();
		panel_1.add(cbMin, "cell 1 0,growx");
		
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
		
		txtDoenca = new JTextField();
		panel_2.add(txtDoenca, "cell 0 0,growx");
		txtDoenca.setColumns(10);
		
		txtValor = new JTextField();
		panel_2.add(txtValor, "cell 0 1,growx");
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Descrição:");
		contentPane.add(lblNewLabel_5, "cell 0 6,alignx right,aligny center");
		
		TextArea txaDesc = new TextArea();
		contentPane.add(txaDesc, "cell 1 6,growx,aligny center");
		contentPane.add(btnVolta, "cell 0 8,alignx center,aligny center");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnCad, "cell 2 8,alignx center,aligny center");
	}

}

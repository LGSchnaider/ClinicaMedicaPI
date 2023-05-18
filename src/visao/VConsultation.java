package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import controle.ConsultaDAO;
import controle.MedicoDAO;
import controle.PacienteDAO;
import modelTabelas.ConsultaTableModel;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class VConsultation extends JFrame {
	
	private JPanel contentPane;
	private final JButton btnCad = new VModelButton("Cadastrar");
	private JTextField txtDoenca;
	private JTextField txtValor;
	private Usuario usuarioLogado;
	private JComboBox comboPasc;
	private ArrayList<Paciente> listaPaciente;
	private ArrayList<Medico> listaMedico;
	private JComboBox comboMed;
	
	

	public VConsultation(Usuario usuarioLogado) {
		setTitle("Cadastro de Consulta");
		this.usuarioLogado = usuarioLogado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 562);
	
		
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/imagens/TelaConsulta.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contentPane = new VBackGround(bg);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,right][grow][grow]", "[grow][grow][grow][grow][grow][grow][110.00][grow][35.00,grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastrar Consulta");
		lblNewLabel.setForeground(new Color(19, 59, 93));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center");
		
		JButton btnVolta = new VModelButton("Voltar");
		btnVolta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VMainWindow frame = new VMainWindow(usuarioLogado); 
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Paciente:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6.setForeground(new Color(19, 59, 93));
		contentPane.add(lblNewLabel_6, "cell 0 2,alignx trailing,aligny center");
		
		comboPasc = new JComboBox();
		comboPasc.setForeground(new Color(19, 59, 93));
		comboPasc.addItem(null);
		
		PacienteDAO Pasc = new PacienteDAO();
		listaPaciente = Pasc.listaPaciente();
		for (Paciente paciente : listaPaciente) {	
			comboPasc.addItem(paciente);
		} 
		
		contentPane.add(comboPasc, "cell 1 2,growx,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(19, 59, 93));
		contentPane.add(lblNewLabel_1, "cell 0 3,aligny center");
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 1 3,growx,aligny center");
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow]"));
		
		JComboBox cbDia = new JComboBox();	
		cbDia.setForeground(new Color(19, 59, 93));
		panel.add(cbDia, "cell 0 0,growx,aligny center");
		cbDia.addItem("01");
		cbDia.addItem("02");
		cbDia.addItem("03");
		cbDia.addItem("04");
		cbDia.addItem("05");
		cbDia.addItem("06");
		cbDia.addItem("07");
		cbDia.addItem("08");	
		cbDia.addItem("09");
		cbDia.addItem("10");
		cbDia.addItem("11");
		cbDia.addItem("12");
		cbDia.addItem("13");
		cbDia.addItem("14");
		cbDia.addItem("15");
		cbDia.addItem("16");
		cbDia.addItem("17");
		cbDia.addItem("18");
		cbDia.addItem("19");
		cbDia.addItem("20");
		cbDia.addItem("21");
		cbDia.addItem("22");
		cbDia.addItem("23");
		cbDia.addItem("24");
		cbDia.addItem("25");
		cbDia.addItem("26");
		cbDia.addItem("27");
		cbDia.addItem("28");
		cbDia.addItem("29"); 
		cbDia.addItem("30");
		cbDia.addItem("31");
		
		
		JComboBox cbMes = new JComboBox();
		cbMes.setForeground(new Color(19, 59, 93));
		panel.add(cbMes, "cell 1 0,growx,aligny center");
		cbMes.addItem("JAN");
		cbMes.addItem("FEV");
		cbMes.addItem("MAR");
		cbMes.addItem("ABR");
		cbMes.addItem("MAI");
		cbMes.addItem("JUN");
		cbMes.addItem("JUL");
		cbMes.addItem("AGO");
		cbMes.addItem("SET");
		cbMes.addItem("OUT");
		cbMes.addItem("NOV");
		cbMes.addItem("DEZ");
		
		JComboBox cbAno = new JComboBox();
		cbAno.setForeground(new Color(19, 59, 93));
		panel.add(cbAno, "cell 2 0,growx,aligny center");
		
		cbAno.addItem("2010");
		cbAno.addItem("2011");
		cbAno.addItem("2012");
		cbAno.addItem("2013");
		cbAno.addItem("2014");
		cbAno.addItem("2015");
		cbAno.addItem("2016");
		cbAno.addItem("2017");
		cbAno.addItem("2018");
		cbAno.addItem("2019");
		cbAno.addItem("2020");
		cbAno.addItem("2021");
		cbAno.addItem("2022");
		cbAno.addItem("2023");
		cbAno.addItem("2024");
		cbAno.addItem("2025");
		cbAno.addItem("2026");
		cbAno.addItem("2027");
		cbAno.addItem("2028");
		cbAno.addItem("2029");
		cbAno.addItem("2030");
		
		JLabel lblNewLabel_2 = new JLabel("Hora:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(19, 59, 93));
		contentPane.add(lblNewLabel_2, "cell 0 4,aligny center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, "cell 1 4,growx,aligny center");
		panel_1.setLayout(new MigLayout("", "[30px,grow,fill][grow]", "[22px,grow,fill]"));
		
		JComboBox cbHora = new JComboBox();
		cbHora.setForeground(new Color(19, 59, 93));
		panel_1.add(cbHora, "cell 0 0");
		
		cbHora.addItem(null);
		cbHora.addItem("00");
		cbHora.addItem("01");
		cbHora.addItem("02");
		cbHora.addItem("03");
		cbHora.addItem("04");
		cbHora.addItem("05");
		cbHora.addItem("06");
		cbHora.addItem("07");
		cbHora.addItem("08");
		cbHora.addItem("09");
		cbHora.addItem("10");
		cbHora.addItem("11");
		cbHora.addItem("12");
		cbHora.addItem("13");
		cbHora.addItem("14");
		cbHora.addItem("15");
		cbHora.addItem("16");
		cbHora.addItem("17");
		cbHora.addItem("18");
		cbHora.addItem("19");
		cbHora.addItem("20");
		cbHora.addItem("21");
		cbHora.addItem("22");
		cbHora.addItem("23");
		
		JComboBox cbMin = new JComboBox();
		cbMin.setForeground(new Color(19, 59, 93));
		panel_1.add(cbMin, "cell 1 0,growx");
		
		cbMin.addItem(null);
		cbMin.addItem("00");
		cbMin.addItem("01");
		cbMin.addItem("02");
		cbMin.addItem("03");
		cbMin.addItem("04");
		cbMin.addItem("05");
		cbMin.addItem("06");
		cbMin.addItem("07");
		cbMin.addItem("08");
		cbMin.addItem("09");
		cbMin.addItem("10");
		cbMin.addItem("11");
		cbMin.addItem("12");
		cbMin.addItem("13");
		cbMin.addItem("14");
		cbMin.addItem("15");
		cbMin.addItem("16");
		cbMin.addItem("17");
		cbMin.addItem("18");
		cbMin.addItem("19");
		cbMin.addItem("20");
		cbMin.addItem("21");
		cbMin.addItem("22");
		cbMin.addItem("23");
		cbMin.addItem("24");
		cbMin.addItem("25");
		cbMin.addItem("26");
		cbMin.addItem("27");
		cbMin.addItem("28");
		cbMin.addItem("29");
		cbMin.addItem("30");
		cbMin.addItem("31");
		cbMin.addItem("32");
		cbMin.addItem("33");
		cbMin.addItem("34");
		cbMin.addItem("35");
		cbMin.addItem("36");
		cbMin.addItem("37");
		cbMin.addItem("38");
		cbMin.addItem("39");
		cbMin.addItem("40");
		cbMin.addItem("41");
		cbMin.addItem("42");
		cbMin.addItem("43");
		cbMin.addItem("44");
		cbMin.addItem("45");
		cbMin.addItem("46");
		cbMin.addItem("47");
		cbMin.addItem("48");
		cbMin.addItem("49");
		cbMin.addItem("50");
		cbMin.addItem("51");
		cbMin.addItem("52");
		cbMin.addItem("53");
		cbMin.addItem("54");
		cbMin.addItem("55");
		cbMin.addItem("56");
		cbMin.addItem("57");
		cbMin.addItem("58");
		cbMin.addItem("59");
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		contentPane.add(panel_3, "cell 0 5,grow");
		panel_3.setLayout(new MigLayout("", "[46px,grow]", "[grow][14px,grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("Medico:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(19, 59, 93));
		panel_3.add(lblNewLabel_3, "cell 0 0,alignx right,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("Valor:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setForeground(new Color(19, 59, 93));
		panel_3.add(lblNewLabel_4, "cell 0 1,alignx right,aligny center");
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		contentPane.add(panel_2, "cell 1 5,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		comboMed = new JComboBox();
		comboMed.setForeground(new Color(19, 59, 93));
		comboMed.addItem(null);
		panel_2.add(comboMed, "cell 0 0,growx");
		
		MedicoDAO Med = new MedicoDAO();
		listaMedico = Med.listaMedico();
		for (Medico Medico : listaMedico) {
			comboMed.addItem(Medico);
		}
		 
		
		txtValor = new JTextField();
		txtValor.setForeground(new Color(19, 59, 93));
		txtValor.setToolTipText("");
		panel_2.add(txtValor, "cell 0 1,growx,aligny center");
		txtValor.setColumns(10);
		
		
		JLabel lblNewLabel_5 = new JLabel("Observações:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setForeground(new Color(19, 59, 93));
		contentPane.add(lblNewLabel_5, "cell 0 6,alignx right,aligny top");
		
		TextArea txaObser = new TextArea();
		txaObser.setForeground(new Color(19, 59, 93));
		contentPane.add(txaObser, "cell 1 6,growx,aligny center");
		contentPane.add(btnVolta, "cell 0 8,alignx center,aligny center");
		
		
		btnCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VListPomptuary frame = new VListPomptuary(usuarioLogado);
				frame.setVisible(true);
			}
		});
		contentPane.add(btnCad, "cell 2 8,alignx center,aligny center");
	}

}
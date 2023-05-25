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
import controle.PromptuaryDAO;
import modelTabelas.ConsultaTableModel;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import modelo.Promptuary;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class VConsultation extends JFrame {
	
	private JPanel contentPane;
	private final JButton btnPront = new VModelButton("Histórico");
	private final JButton btnCad = new VModelButton("Cadastrar");
	private JTextField txtDoenca;
	private JTextField txtValor;
	private Usuario usuarioLogado;
	private ArrayList<Paciente> listaPaciente;
	private ArrayList<Medico> listaMedico;
	private JComboBox comboMed;
	
	

	public VConsultation(Usuario usuarioLogado, Consulta c) {
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
		contentPane.setLayout(new MigLayout("", "[grow,right][grow][grow]", "[grow][grow][grow][grow][110.00][grow][35.00,grow][grow]"));
		
		JLabel lblNomePac = new JLabel(c.getNamePatient());
		lblNomePac.setForeground(new Color(19, 59, 93));
		lblNomePac.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNomePac, "cell 1 0,alignx center");
		
		JButton btnVolta = new VModelButton("Voltar");
		btnVolta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VListConsultation frame = new VListConsultation(usuarioLogado); 
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(19, 59, 93));
		contentPane.add(lblNewLabel_1, "cell 0 2,aligny center");
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 1 2,growx,aligny center");
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		contentPane.add(panel_3, "cell 0 3,grow");
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
		contentPane.add(panel_2, "cell 1 3,grow");
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
		contentPane.add(lblNewLabel_5, "cell 0 4,alignx right,aligny top");
		
		TextArea txaObser = new TextArea();
		txaObser.setForeground(new Color(19, 59, 93));
		contentPane.add(txaObser, "cell 1 4,growx,aligny center");
		contentPane.add(btnVolta, "cell 0 6,alignx center,aligny center");
		
		
		btnCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validarCampoTexto = true;
				String dia = String.valueOf(cbDia.getSelectedItem());
				String mes = String.valueOf(cbMes.getSelectedItem());
				String ano = String.valueOf(cbAno.getSelectedItem());
				
				Medico medico = (Medico) comboMed.getSelectedItem();
				
				String Valor = String.valueOf(txtValor.getText());
				
				String Descricao = txaObser.getText();
				
				Promptuary promptuary = new Promptuary();
				
				//Try valor
				if(Valor !=null && !Valor.isEmpty()) {
					if(Valor.equalsIgnoreCase("R$      ,  ")) {
					JOptionPane.showMessageDialog(null, "Nada é de graça, alem do meu amor");
					txtValor.requestFocus();
					return;
				}else {
					Valor = Valor.replace("R","");
					Valor = Valor.replace("$","");
					Valor = Valor.replace(",","");
					
					String valorInt = String.valueOf(Valor);
					
					promptuary.setValor(valorInt);
				}
				}else {
					validarCampoTexto = false;
					JOptionPane.showMessageDialog(null, "Nada é de graça, alem do meu amor");
					txtValor.requestFocus();
					return;
				}
				
				//Try Data
				try {
					if(dia != null && !dia.isEmpty()) {
						if(mes != null && !mes.isEmpty()) {
							if(ano != null && !ano.isEmpty()) {
								String data = dia+"/"+mes+"/"+ano;
								promptuary.setData(data);
							}else {
								validarCampoTexto = false;
								JOptionPane.showInternalMessageDialog(null, "O campo Ano precisa ser preenchido");
								cbAno.requestFocus();
								return;
							}
						}else {
							validarCampoTexto = false;
							JOptionPane.showInternalMessageDialog(null, "O campo Mês precisa ser preenchido");
							cbMes.requestFocus();
							return;
						}
					}else {
						validarCampoTexto = false;
						JOptionPane.showInternalMessageDialog(null, "O campo Dia precisa ser preenchido");
						cbDia.requestFocus();
						return;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				//Try Medico
				try {
					if(medico != null) {
						int idm = medico.getId();
						promptuary.setIdMedico(idm);
					}else {
						validarCampoTexto = false;
						JOptionPane.showInternalMessageDialog(null, "O campo Medico precisa ser preenchido");
						comboMed.requestFocus();
						return;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				//Try Patient
				try {
					promptuary.setIdPaciente(c.getIdPaciente());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				//Try Obs.
				try {
					if (Descricao != null && !Descricao.isEmpty()) {
						promptuary.setObs(Descricao);
					}else {
						validarCampoTexto = false;
						JOptionPane.showInternalMessageDialog(null, "O campo Descrição precisa ser preenchido");
						txaObser.requestFocus();
						return;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}			
				
				//Passou pelas validações
				try {
					if (validarCampoTexto ==  true) {
						PromptuaryDAO prdao = new PromptuaryDAO();

						
						boolean validar = prdao.inserir(promptuary);
						if (validar == true) {
							// exibir uma mensagem de cadastro com sucesso
							JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						} else {
							// exibir mensagem de erro ao cadastrar
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar consulta");
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				
			}
		});
		
		btnPront.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VListPomptuary frame = new VListPomptuary(usuarioLogado, c.getIdPaciente());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		contentPane.add(btnPront, "cell 1 6,alignx center,aligny center");
		contentPane.add(btnCad, "cell 2 6,alignx center,aligny center");
		
		txtValor.setText(c.getValor());
	}
	

}

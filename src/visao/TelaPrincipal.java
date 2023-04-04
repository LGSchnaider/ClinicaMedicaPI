package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Cursor;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable visaoGeral;
	private Usuario usuarioLogado;
	private TipoUsuario tipoUsuarioLogado;

	/*
	 * Construtor da classe
	 */
	public TelaPrincipal(Usuario u) {
		this.usuarioLogado = u;
		tipoUsuarioLogado = TipoUsuario.getTipoUsuarioPorCodigo(usuarioLogado.getPerfil());

		/*
		 * Cria tela Admin
		 */
		criaTelaAdmin();

		criaTelaComum();

	}

	private void criaTelaComum() {

	}

	private void criaTelaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 542);

		BufferedImage bg = null;

		try {
			bg = ImageIO.read(new File("src/imagens/TelaPrincipal.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelDireita = new JPanel();
		contentPane.add(panelDireita, BorderLayout.WEST);
		panelDireita.setLayout(new BorderLayout(0, 0));

		JPanel Norte = new JPanel();
		Norte.setBackground(new Color(184, 180, 7));
		panelDireita.add(Norte, BorderLayout.NORTH);
		Norte.setLayout(new BorderLayout(0, 0));

		JLabel TituloVisaoGeral = new JLabel("Visão Geral");
		TituloVisaoGeral.setBackground(new Color(184, 180, 7));
		TituloVisaoGeral.setFont(new Font("Times New Roman", Font.BOLD, 50));
		Norte.add(TituloVisaoGeral);

		JPanel sul = new JPanel();
		sul.setForeground(new Color(255, 255, 255));
		sul.setBackground(new Color(255, 255, 255));
		panelDireita.add(sul, BorderLayout.SOUTH);

		JPanel lest = new JPanel();
		lest.setBackground(new Color(255, 255, 255));
		panelDireita.add(lest, BorderLayout.WEST);

		JPanel oeste = new JPanel();
		oeste.setBackground(new Color(255, 255, 255));
		panelDireita.add(oeste, BorderLayout.EAST);

		JPanel centro = new JPanel();
		panelDireita.add(centro, BorderLayout.CENTER);

		visaoGeral = new JTable();
		visaoGeral.setModel(new DefaultTableModel(new Object[][] { { "Oracio", "Jorge", "10" }, },
				new String[] { "Paciente", "M\u00E9dico", "Hora" }));

		JScrollPane scrollPane = new JScrollPane();
		centro.add(scrollPane);

		scrollPane.add(visaoGeral);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.setBackground(new Color(68, 110, 139));
		panelCentro.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Painel de controle");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		panel.add(lblNewLabel);

		JPanel panel_1 = new PanelFundo(bg);
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(64, 128, 128));
		panelCentro.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[71.00][][17.00px,grow]",
				"[][1px][15px,grow][23px][15px,grow][23px][15px,grow][23px][15px]"));

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(btnNewButton, "cell 2 0,alignx right,aligny center");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInicio frame = new TelaInicio();
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Cadastros");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_1.setInheritsPopupMenu(false);
		lblNewLabel_1.setBackground(new Color(204, 204, 204));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_1.add(lblNewLabel_1, "flowx,cell 2 2,alignx center,aligny center");

		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3, "cell 2 1,alignx center,aligny center");

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(64, 128, 128));
		panel_1.add(panel_2, "cell 2 3,grow");

		if (tipoUsuarioLogado != TipoUsuario.SEC_COMUM && tipoUsuarioLogado != TipoUsuario.MED_COMUM) {

			JButton btnNewButton_4 = new JButton("Usuário");
			btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					dispose();
					Cadastro frame = new Cadastro(usuarioLogado);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				}
			});
			panel_2.setLayout(
					new MigLayout("", "[121.00,grow][150.00px,fill][138.00px,grow][150.00][153.00px,grow]", "[33px]"));
			panel_2.add(btnNewButton_4, "cell 1 0,alignx left,aligny top");
		}

		JLabel lblNewLabel_7 = new JLabel("               ");
		panel_2.add(lblNewLabel_7, "cell 2 0,alignx left,aligny center");

		JButton btnNewButton_1 = new JButton("Paciente");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaRegistrarPaciente frame = new TelaRegistrarPaciente(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_1, "cell 3 0,growx,aligny top");

		JLabel lblNewLabel_2 = new JLabel("Consulta");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_1.add(lblNewLabel_2, "cell 2 4,alignx center,aligny center");

		JLabel lblNewLabel_4 = new JLabel("");
		panel_1.add(lblNewLabel_4, "cell 2 1,alignx center,aligny center");

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(64, 128, 128));
		panel_1.add(panel_3, "cell 2 5,grow");

		JButton btnNewButton_2 = new JButton("Registrar consultas");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadConsulta frame = new TelaCadConsulta(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);

			}
		});
		panel_3.setLayout(
				new MigLayout("", "[126.00,grow][150px,fill][97.00px,grow][150px,fill][138.00px,grow]", "[33px]"));
		panel_3.add(btnNewButton_2, "cell 1 0,growx,aligny center");

		JLabel lblNewLabel_8 = new JLabel("            ");
		panel_3.add(lblNewLabel_8, "cell 2 0,alignx left,aligny center");

		JButton btnNewButton_5 = new JButton("Listas de consultas");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaCon frame = new TelaListaCon(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		panel_3.add(btnNewButton_5, "cell 3 0,growx,aligny top");

		JLabel lblNewLabel_5 = new JLabel("Listas");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_1.add(lblNewLabel_5, "cell 2 6,alignx center,aligny center");

		JLabel lblNewLabel_6 = new JLabel("");
		panel_1.add(lblNewLabel_6, "cell 2 1,alignx center,aligny center");

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBackground(new Color(64, 128, 128));
		panel_1.add(panel_4, "cell 2 7,grow");
		panel_4.setLayout(new MigLayout("",
				"[28.00,grow][150.00,fill][150px,grow][150.00,fill][150.00,grow][150.00px,fill][30.00px,grow]",
				"[33px,grow]"));

		if (tipoUsuarioLogado != TipoUsuario.SEC_COMUM && tipoUsuarioLogado != TipoUsuario.MED_COMUM) {

			JButton btnNewButton_3 = new JButton("Listas de Médicos");
			btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					dispose();
					TelaListaMed frame = new TelaListaMed(usuarioLogado);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

				}
			});
			panel_4.add(btnNewButton_3, "cell 1 0,growx,aligny center");
		}

		JButton btnNewButton_6 = new JButton("Listas de Pacientes");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaListaPac frame = new TelaListaPac(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		panel_4.add(btnNewButton_6, "cell 3 0,growx,aligny center");

		if (tipoUsuarioLogado != TipoUsuario.MED_COMUM && tipoUsuarioLogado != TipoUsuario.SEC_COMUM) {

			JButton btnListaSec = new JButton("Lista de Secretaria");
			btnListaSec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					dispose();
					TelaListaSec frame = new TelaListaSec(usuarioLogado);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				}
			});
			btnListaSec.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_4.add(btnListaSec, "cell 5 0,growx,aligny center");
		}
	}

}

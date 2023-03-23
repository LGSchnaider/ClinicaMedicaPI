package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import controle.MedicoDAO;
import controle.SecretariaDAO;
import modelTabelas.MedicoTableModel;
import modelTabelas.SecretariaTableModel;
import modelo.Medico;
import modelo.Secretaria;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaListaSec extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Usuario usuarioLogado;

	

	public TelaListaSec(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 600);
		
		BufferedImage bg = null;
		try {
			bg = ImageIO.read(new File("src/imagens/ListagemMed.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contentPane = new PanelFundo(bg);
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[29.00][40.00][grow][][28.00]", "[102.00,grow][361.00,grow][grow][17.00]"));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 2 0,grow");

		JLabel lblNewLabel = new JLabel("Lista de Medicos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 2 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		SecretariaDAO mDAO = new SecretariaDAO();
		SecretariaTableModel model = new SecretariaTableModel(mDAO.listaSecretaria());
		table.setModel(model);
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		contentPane.add(panel_3, "flowy,cell 1 2");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal frame = new TelaPrincipal(usuarioLogado);  
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(5).addComponent(btnVoltar)));
		gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3.createSequentialGroup().addGap(5)
						.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		contentPane.add(panel_2, "cell 2 2,alignx center,aligny center");

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(contentPane, "Deseja deletar mesmo?") == 0) {
					int p = table.getSelectedRow();
					SecretariaTableModel model = (SecretariaTableModel) table.getModel();

					Secretaria a = model.getSecretaria(p);
					// JOptionPane.showInputDialog(null);
					SecretariaDAO sDAO = new SecretariaDAO();
					sDAO.deletar(a);
					model = new SecretariaTableModel(sDAO.listaSecretaria());
					table.setModel(model);
					JOptionPane.showMessageDialog(null, "Secretaria excluido com sucesso");
				}

				/*
				
				
				
				*/

			}
		});
		btnDeletar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(287)
						.addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(309)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(btnDeletar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		contentPane.add(panel_4, "flowy,cell 3 2");

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(5).addComponent(btnEditar)));
		gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4.createSequentialGroup().addGap(5)
						.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);
	}
}

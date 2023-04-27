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
import java.awt.Color;

public class VListSecretary extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Usuario usuarioLogado;

	

	public VListSecretary(Usuario usuarioLogado) {
		setTitle("Lista de Secretárias");
		this.usuarioLogado = usuarioLogado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 600);
		
		BufferedImage bg = null;
		try {
			bg = ImageIO.read(new File("src/imagens/ListagemMed.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contentPane = new VBackGround(bg);
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[29.00][40.00,grow][][grow][28.00]", "[102.00,grow][361.00,grow][grow][17.00]"));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 2 0,grow");

		JLabel lblNewLabel = new JLabel("Lista de Secretarios");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, "cell 2 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		scrollPane.getViewport().setOpaque(false);	

		table = new JTable();
		table.setOpaque(false);
		SecretariaDAO mDAO = new SecretariaDAO();
		SecretariaTableModel model = new SecretariaTableModel(mDAO.listaSecretaria());
		table.setModel(model);
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		contentPane.add(panel_3, "flowy,cell 1 2,alignx left,aligny center");

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VMainWindow frame = new VMainWindow(usuarioLogado);  
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
					
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo Deletar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					int p = table.getSelectedRow();
					MedicoTableModel model = (MedicoTableModel) table.getModel();

					Medico a = model.getMedico(p);
					// JOptionPane.showInputDialog(null);
					MedicoDAO mDAO = new MedicoDAO();
					mDAO.deletar(a);
					model = new MedicoTableModel(mDAO.listaMedico());
					table.setModel(model);
					JOptionPane.showMessageDialog(null, "Secretáio(a) excluido(a) com sucesso");
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
		contentPane.add(panel_4, "flowy,cell 3 2,alignx right,aligny center");

		JButton btnEditar = new JButton("Editar");
		btnEditar.setOpaque(false);
		btnEditar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicao = table.getSelectedRow();
				if(posicao == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma Secretaria");
					return;
				}
				SecretariaTableModel model  = (SecretariaTableModel) table.getModel();
				Secretaria s = model.getSecretaria(posicao);
				VRegisterSecretary tela = new VRegisterSecretary(usuarioLogado, null, s);
				
				JFrame janela = new JFrame();
				janela.add(tela);
				janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
				janela.setVisible(true);
				
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

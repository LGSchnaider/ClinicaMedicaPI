package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controle.ConsultaDAO;
//import controle.ConsultaDAO;
import modelTabelas.ConsultaTableModel;
import modelTabelas.MTMain;
import modelTabelas.MedicoTableModel;
import modelo.Consulta;
import modelo.Medico;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class VListConsultation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Usuario usuarioLogado;
	private JTable table_1;

	public VListConsultation(Usuario usuarioLogado) {
		setTitle("Lista de Consultas");
		this.usuarioLogado = usuarioLogado;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 697);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][][grow]", "[][419.00,grow][grow][][grow]"));

		JLabel lblNewLabel = new JLabel("Lista de Consultas");
		lblNewLabel.setForeground(new Color(19, 59, 93));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNewLabel, "cell 2 0,alignx center");

		// TODO Criar lista d Pacientes e os comandos dos botões

		JButton btnNewButton = new VModelButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VMainWindow frame = new VMainWindow(usuarioLogado);
				frame.setLocationRelativeTo(null);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}
		});

		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 2 1,grow");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(19, 59, 93));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		table = new JTable();
		table.setOpaque(false);
		ConsultaDAO cDAO = new ConsultaDAO();
		ConsultaTableModel model = new ConsultaTableModel(cDAO.listaConsulta());
		table.setModel(model);
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(68).addComponent(scrollPane).addGap(106)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(scrollPane).addGap(15)));
		panel.setLayout(gl_panel);

		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnNewButton, "cell 1 3,alignx center,aligny center");

		JButton btnNewButton_1 = new VModelButton("Deletar Consulta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int position = table.getSelectedRow();
				if(position == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma consulta");
					return;
				}
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo Deletar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					int cl = table.getSelectedRow();
					ConsultaTableModel model = (ConsultaTableModel) table.getModel();

					Consulta c = model.getConsulta(cl);
					System.out.println(cl);
					System.out.println(c);

					ConsultaDAO cDAO = new ConsultaDAO();
					cDAO.deletar(c);
					model = new ConsultaTableModel(cDAO.listaConsulta());
					table.setModel(model);
					JOptionPane.showMessageDialog(null, "Consulta excluida com sucesso");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1, "flowx,cell 2 3,alignx center");

		JButton btnNewButton_2 = new VModelButton("Editar Consulta");
		btnNewButton_2.setText("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnNewButton_2, "cell 3 3,alignx center");
		
		JButton btnObs = new VModelButton("New button");
		btnObs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = table.getSelectedRow();
				if(position == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma consulta");
					return;
				}
				ConsultaTableModel model  = (ConsultaTableModel) table.getModel();
				Consulta c = model.getConsulta(position);
				String obs = c.getObs();
				JOptionPane.showMessageDialog(null, obs);
			}
		});
		btnObs.setText("Ver observações");
		btnObs.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnObs, "cell 2 3");

	}

}

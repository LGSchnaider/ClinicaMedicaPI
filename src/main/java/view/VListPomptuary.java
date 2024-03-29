package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controll.CConsulationDAO;
import controll.CPromptuaryDAO;
import model.MConsultation;
import model.MPromptuary;
import model.MUser;
import modelTabel.MTConsultaTableModel;
import modelTabel.MTPromptuary;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class VListPomptuary extends JFrame {

	private MUser usuarioLogado;
	private JPanel contentPane;
	private JTable table;

	public VListPomptuary(MUser usuarioLogado, int idp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VListPomptuary.class.getResource("/imagens/icone.png")));
		setTitle("Cadastro de Consulta");
	 	
		this.usuarioLogado = usuarioLogado;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		setBounds(100, 100, 574, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(140, 166, 189));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Histórico medico");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(19, 59, 93));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(19, 59, 93));
		scrollPane.getViewport().setOpaque(false);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setOpaque(false);
		
		table = new JTable();
		table.setForeground(new Color(19, 59, 93));
		table.setBackground(new Color(255, 255, 255));
		table.setOpaque(false);
		CPromptuaryDAO prDAO = new CPromptuaryDAO();
		MTPromptuary model = new MTPromptuary(prDAO.listaPronptuary(idp));
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(140, 166, 189));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new VModelButton("Ver observações");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = table.getSelectedRow();
				if(position == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma consulta");
					return;
				}
				MTPromptuary model  = (MTPromptuary) table.getModel();
				MPromptuary p = model.getPromptuary(position);
				String obs = p.getObs();

				VObservation frame = new VObservation(obs);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		panel.add(btnNewButton);
		

		
	}

}

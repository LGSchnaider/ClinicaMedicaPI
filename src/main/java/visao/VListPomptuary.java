package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CConsulationDAO;
import controle.CPromptuaryDAO;
import modelTabelas.MTConsultaTableModel;
import modelTabelas.MTPromptuary;
import modelo.MUser;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;

public class VListPomptuary extends JFrame {

	private MUser usuarioLogado;
	private JPanel contentPane;
	private JTable table;

	public VListPomptuary(MUser usuarioLogado, int idp) {
		setTitle("Cadastro de Consulta");
	 	
		this.usuarioLogado = usuarioLogado;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Histórico medico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(19, 59, 93));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setOpaque(false);
		CPromptuaryDAO prDAO = new CPromptuaryDAO();
		MTPromptuary model = new MTPromptuary(prDAO.listaPronptuary(idp));
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ver observações");
		panel.add(btnNewButton);
		

		
	}

}

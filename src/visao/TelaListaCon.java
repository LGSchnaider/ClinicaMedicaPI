package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class TelaListaCon extends JFrame {

	private JPanel contentPane;
	private Usuario usuarioLogado;


	public TelaListaCon(Usuario usuarioLogado) {
		setTitle("Lista de Consultas");
		this.usuarioLogado = usuarioLogado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Lista de Consultas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center");
		
			//TODO Criar lista d Pacientes e os comandos dos botões 
			
			JButton btnNewButton = new JButton("Voltar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					TelaPrincipal frame = new TelaPrincipal(usuarioLogado);  
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				}
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			contentPane.add(btnNewButton, "cell 0 3,alignx center,aligny center");
		
		JButton btnNewButton_1 = new JButton("Deletar Consulta");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1, "cell 1 3,alignx center");
		
		JButton btnNewButton_2 = new JButton("Editar Consulta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnNewButton_2, "cell 2 3,alignx center");
	}

}

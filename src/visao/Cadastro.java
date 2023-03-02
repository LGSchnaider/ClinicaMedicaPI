package visao;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		
		JRadioButton rbtnSecretaria = new JRadioButton("Secretária");
		buttonGroup.add(rbtnSecretaria);
		panel.add(rbtnSecretaria);
		
		
		
		JRadioButton rbtnMedico = new JRadioButton("Médico");
		rbtnMedico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				TelaRegistrarMed frame = new TelaRegistrarMed();
				JPanel panel_1 = new JPanel();
				contentPane.add(panel_1, FlowLayout.CENTER);
				panel_1.setLayout(new FlowLayout());
				panel_1.add(frame);
				panel_1.revalidate();
				panel_1.repaint();
				System.out.println("hikhjhj");
			}
		});
	
		buttonGroup.add(rbtnMedico);
		panel.add(rbtnMedico);
		
	//	if(rbtnSecretaria) {
			TelaRegistrarSecretaria panel_1 = new TelaRegistrarSecretaria();
			contentPane.add(panel_1, BorderLayout.CENTER);
			
//		}
		
		
	}

}

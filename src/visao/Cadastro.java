package visao;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JButton;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Usuario usuarioLogado;

	/**
	 * Launch the application.
	 */
	private void setTema(JPanel contentPane) {
		BorderLayout layout = (BorderLayout) contentPane.getLayout();
		if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
			contentPane.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		}

		TelaRegistrarSecretaria sec = new TelaRegistrarSecretaria(usuarioLogado, this);
		sec.setOpaque(false);
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout());
		panel_1.add(sec, BorderLayout.CENTER);
		panel_1.revalidate();
		panel_1.repaint();
	}

	/**
	 * Create the frame.
	 */
	public Cadastro(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.NORTH);

		JRadioButton rbtnSecretaria = new JRadioButton("Secretária");
		rbtnSecretaria.setFont(new Font("Times New Roman", Font.BOLD, 15));

		rbtnSecretaria.setSelected(true);
		setTema(contentPane);

		rbtnSecretaria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rbtnSecretaria.isSelected()) {

					setTema(contentPane);

				}
			}
		});
		buttonGroup.add(rbtnSecretaria);
		panel.add(rbtnSecretaria);

		JRadioButton rbtnMedico = new JRadioButton("Médico");
		rbtnMedico.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Cadastro estaTela = this;
		rbtnMedico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (rbtnMedico.isSelected()) {
					BorderLayout layout = (BorderLayout) contentPane.getLayout();
					if (layout.getLayoutComponent(BorderLayout.CENTER) != null) {
						System.out.println(layout.getLayoutComponent(BorderLayout.CENTER));
						contentPane.remove(layout.getLayoutComponent(BorderLayout.CENTER));
					}
					TelaRegistrarMed med = new TelaRegistrarMed(usuarioLogado, estaTela);
 					Panel panel_1 = new Panel();
					contentPane.add(panel_1, BorderLayout.CENTER);
					panel_1.setLayout(new BorderLayout());
					panel_1.add(med, BorderLayout.CENTER);
					panel_1.revalidate();
					panel_1.repaint();
				}

			}
		});

		buttonGroup.add(rbtnMedico);
		panel.add(rbtnMedico);

//		}

	}

}

package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Secretaria;
import modelo.Usuario;

public class TelaEditarSecretaria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param usuarioLogado 
	 * @param s 
	 */
	public TelaEditarSecretaria(Usuario usuarioLogado, Secretaria s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		TelaRegistrarSecretaria tela = new TelaRegistrarSecretaria(usuarioLogado, null, s);
		setContentPane(contentPane);
	}

}

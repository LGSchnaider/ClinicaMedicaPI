package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Secretaria;
import modelo.Usuario;

public class VEditSecretary extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param usuarioLogado 
	 * @param s 
	 */
	public VEditSecretary(Usuario usuarioLogado, Secretaria s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		VRegisterSecretary tela = new VRegisterSecretary(usuarioLogado, null, s);
		setContentPane(contentPane);
	}

}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MSecretary;
import model.MUser;
import java.awt.Toolkit;

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
	public VEditSecretary(MUser usuarioLogado, MSecretary s) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VEditSecretary.class.getResource("/imagens/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//VRegisterSecretary tela = new VRegisterSecretary(usuarioLogado, this, s);
		setContentPane(contentPane);
	}

}

package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.Dimension;

public class TelaInicio extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximizar
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
	public TelaInicio() {
		setForeground(new Color(3, 152, 158));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 900);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel up = new JPanel();
		getContentPane().add(up, BorderLayout.NORTH);
		
		JPanel down = new JPanel();
		getContentPane().add(down, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Farmacos");
		down.add(lblNewLabel);
		
		JPanel center = new JPanel();
		getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new MigLayout("", "[310.00,grow][223.00,grow][330.00,grow]", "[pref!,grow][92.00,grow][40,grow][70,grow][70,grow][70,grow][38.00,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Clínica Médica");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		center.add(lblNewLabel_1, "cell 1 1,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("INICIO");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		center.add(lblNewLabel_2, "cell 1 2,alignx center");
		
		JPanel ggggg = new JPanel();
		ggggg.setLayout(new GridLayout(1, 1, 0, 0));
		JButton btnNewButton_2 = new JButton("kkk");
		ggggg.add(btnNewButton_2);
		btnNewButton_2.setMinimumSize(new Dimension(97, 23));
		btnNewButton_2.setMaximumSize(new Dimension(97, 23));
		center.add(ggggg, "cell 1 3,alignx center");
		
		JButton btnNewButton = new JButton("hjkyhjkhjkhjkl");
		center.add(btnNewButton, "cell 1 4,alignx center");
		
		JButton btnNewButton_1 = new JButton("New button");
		center.add(btnNewButton_1, "cell 1 5,alignx center");
	}
}

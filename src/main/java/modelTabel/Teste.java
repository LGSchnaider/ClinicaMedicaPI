package modelTabel;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class Teste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
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
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
		contentPane.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(184, 61, 146, 20);
		
		
		
		 DecimalFormat decimal = new DecimalFormat("#,###,###.00");
         NumberFormatter numFormatter = new NumberFormatter(decimal);
         numFormatter.setFormat(decimal);
         numFormatter.setAllowsInvalid(false);
         DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);
         
         formattedTextField.setFormatterFactory(dfFactory);
 		contentPane.add(formattedTextField);
	
	}
}

package visao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class VModelButton extends JButton
 {
	private static final long serialVersionUID = 1L;
	private Shape shape;
	  public VModelButton(String label) {
	    super(label);
	    setOpaque(false);
	    
	    setBackground(new Color(16,59,93));
	    
	    setForeground(Color.WHITE);
	  }
	  
	  protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	         super.paintComponent(g);
	    }
	  
	  protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
	    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	  }
	  
	  public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	         }
	         return shape.contains(x, y);
	    }
	}
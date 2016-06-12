import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout; //to put buttons into the grid
import java.awt.Insets; //for the stupid insets

import java.io.File; //just for the File object (using File.separator)

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon; //for image
import javax.swing.JButton; //for clickable buttons

import javax.swing.JMenu; //for the manubar menu options needing JMenu below.
import javax.swing.JMenuBar; //for the JMenuBar
import javax.swing.JMenuItem;

public class Tutorial extends JPanel implements ActionListener, KeyListener
{
	Timer tm = new Timer(5, this); //referes to the ActionListener
	int x = 0, y = 0, velX = 0, velY = 0;
	JButton b1, b2, b3, b4, b5;
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	public Tutorial()
	{
		tm.start(); //starts the timer
		addKeyListener(this); //'this' is implemented the KeyListener
		setFocusable(true);
		setFocusTraversalKeysEnabled(false); //no shift or tab key used
		
		setLayout(new GridBagLayout()); // uses the info of GridBagConstraints 
		
		gbc.insets = new Insets(5,5,5,5); //Insets spreads the buttons out //top, left, bottom, right
		
		b1 = new JButton("Button1");
		gbc.gridx = 0; //
		gbc.gridy = 0; //
		
		gbc.gridheight = 4;
		gbc.fill = GridBagConstraints.VERTICAL;
		add(b1, gbc);
		// WAS prev without grid simply just -->		add(b1);
		
		b2 = new JButton("Button2");
		gbc.gridx = 1; //
		gbc.gridy = 1; //
		
		gbc.gridheight = 1;
		add(b2, gbc);
		// add(b2);
		
		b3 = new JButton("Button3");
		gbc.gridx = 2; //
		gbc.gridy = 2; //
		add(b3, gbc);
		// add(b3);
		
		b4 = new JButton("Button4");
		gbc.gridx = 3; //
		gbc.gridy = 3; //
		add(b4, gbc);
		// add(b4);
		
		b5 = new JButton("Button5");
		gbc.gridx = 1; //
		gbc.gridy = 4; //
		
		gbc.gridwidth = 3; //(will take up 3 grid spaces in the x-axis without making the button bigger.)
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(b5, gbc);
		// add(b5);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		ImageIcon ic = new ImageIcon("." + File.separator + "man.png");
		ic.paintIcon(this, g, 70, 70); //this refereing to the location of the image. the ic
		//Above image is drawn BELOW the red box
		
		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 30);
		
		//ic.paintIcon(this, g, 90, 90); //this refereing to the location of the image. the ic
		//Above image is drawn ABOVE the red box
	}
	
	public void actionPerformed(ActionEvent e)
	{
		x = x + velX;
		y = y + velY;
		revalidate(); //needs repaint (below) //tell layout manager to recalculate the layout
		repaint(); //needs revalidate (above) //tells Swing an area of the window is dirty
	}
	
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		
		if (c == KeyEvent.VK_LEFT)
		{
			velX = -1;
			velY = 0;
		}
		
		if (c == KeyEvent.VK_UP)
		{
			velX = 0;
			velY = -1;
		}
		
		if (c == KeyEvent.VK_RIGHT)
		{
			velX = 1;
			velY = 0;
		}
		
		if (c == KeyEvent.VK_DOWN)
		{
			velX = 0;
			velY = 1;
		}
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e)
	{
		velX = 0;
		velY = 0;
	}
	
	
	public static void main(String[] args)
	{
		Tutorial t = new Tutorial();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600,400);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t); //puts the jpanel in the jframe
		
		JMenuBar jmb = new JMenuBar();
		jf.setJMenuBar(jmb); //need to add the JMenuBar to the frame
		
		//menu bar options:
		JMenu fileoption = new JMenu("File");
		jmb.add(fileoption);
		
		JMenuItem openitem = new JMenuItem("Open File...");
		fileoption.add(openitem);
		
		fileoption.addSeparator(); //to put a line between the options on the menu
		
		JMenuItem exititem = new JMenuItem("Exit");
		fileoption.add(exititem);
		
		JMenu editoption = new JMenu("Edit");
		jmb.add(editoption);
		
		jf.setVisible(true); //set this AFTER the menu bar or it won't display.
	}
}

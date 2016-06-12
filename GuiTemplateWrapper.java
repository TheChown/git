
/*above line reserved for package declaration*/

/*
** (c) C0nfuseki/The Chown/Sophie Chown 2016
** 
** Class to take:
** chosen JPanel child class
** ...for display in this Jpanel
** So that this JPanel will be displayed in a window.
** 
** KeyEvent list:
** VK_ESCAPE, VK_F1, VK_F2, VK_F3, VK_F4, VK_F5, VK_F6, VK_F7, VK_F8, VK_F9, VK_F10, VK_F11, VK_F12
** VK_BACK_QUOTE, VK_1, VK_2, VK_3, VK_4, VK_5, VK_6, VK_7, VK_8, VK_9, VK_0, VK_MINUS, VK_EQUALS
** VK_TAB, VK_Q, VK_W, VK_E, VK_R, VK_T, VK_Y, VK_U, VK_I, VK_O, VK_P, VK_BACK_SLASH
** VK_CAPS_LOCK, VK_A, VK_S, VK_D, VK_F, VK_G, VK_H, VK_J, VK_K, VK_L, VK_SEMICOLON, VK_QUOTE, VK_ENTER
** VK_SHIFT, VK_Z, VK_X, VK_C, VK_V, VK_B, VK_N, VK_M, VK_COMMA, VK_PERIOD, VK_SLASH, ...
** VK_CONTROL, VK_ALT, VK_SPACE, ...
** 
** VK_DELETE, VK_HOME, VK_END, VK_PAGE_UP, VK_PAGE_DOWN
** VK_UP, VK_RIGHT, VK_LEFT, VK_DOWN
** 
** 
** for more info see:	http://way2java.com/awt-components/java-making-button-invisible/
**						docs.oracle.com/javase/tutorial/uiswing/components/menu.html
**			del->			http://www.jguru.com/faq/view.jsp?EID=476473
*/

//import java.lang.*; //lang package(By default)--> System.out.println(String) , 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;//java.awt.Dimension--> Dimension, 

import java.awt.Font;//java.awt[.Font] (NOT: java.awt.font)
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Color;//java.awt.Color --> Color, 

public class GuiTemplateWrapper extends JPanel implements ActionListener, KeyListener
{
	//declared class variables:
	//
	final int MICROSECSUPDATERATE = 20;//IMPORTANT~! This value needs to be large enough to allow enough time for comparisons between ticks, or not all buttons (in array) have time to be reviewed before new tick makes it happen again.
	
	int theWidthOfThisPanel;
	int theHeightOfThisPanel;
	
	Timer dynamticker = new Timer(MICROSECSUPDATERATE, this);//javax.swing.Timer
	//'this' refers to how GuiTemplate implements ActionListener
	
	GridBagLayout panDisplay = new GridBagLayout();
	
	
	GridBagConstraints panArrange = new GridBagConstraints();
	
	//for testing setting up padding values for when adding panel to here.
	int test_xpad;
	int test_ypad;
	
	GuiTemplateWrapper()
	{
		//
		theWidthOfThisPanel = this.getWidth();//javax.swing.JPanel
		theHeightOfThisPanel = this.getHeight();//javax.swing.JPanel
		
		//assume that the subpanel should take up this much space.
		test_xpad = 150;//theWidthOfThisPanel/2; //if can draw, then test with calulated value. might be 0 if window of 0x0 size to start with.
		test_ypad = 150;//theHeightOfThisPanel/2;
		//this.setPreferredSize(new Dimension(500, 300));
		//this.setMinimumSize(new Dimension(500, 300));
		//this.setMaximumSize(new Dimension(500, 500));
		
		this.setFocusable(true);// //usually set to true by default
		this.setFocusTraversalKeysEnabled(false);
		Color c = new Color(127, 255, 127, 63);
		this.setBackground(c);//javax.swing.JComponent (implemented by javax.swing.JPanel), java.awt.Color
		
		this.dynamticker.start();//javax.swing.Timer //for implementing repainting on changes
		
		this.addKeyListener(this);
		//'this' refers to how GuiTemplate implements KeyListener
		
		this.setLayout(panDisplay);
		//gridbaglayout
		
		
        panArrange.insets.top = 1;
        panArrange.insets.bottom = 1;
        panArrange.insets.left = 1;
        panArrange.insets.right = 1;
		
		panArrange.weightx = 1.0;
		panArrange.weighty = 1.0;
		
		panArrange.anchor = GridBagConstraints.WEST;
		panArrange.fill = GridBagConstraints.NONE;
		
		panArrange.ipadx = test_xpad;
		panArrange.ipady = test_ypad;
		
	}
	
	
	public void insertLeftJPanel(JPanel subpanel)
	{
		//
		this.add(subpanel, panArrange);
	}
	
	
	public void actionPerformed(ActionEvent actev)
	{
		//
		//System.out.println("param string   " + actev.paramString());
		String actionType = actev.getActionCommand();
		
		if(actionType != null)
		{
			//
			
			
		}
		else
		{
			//null action triggered by the timer and nothing to report ends up here
		}
		
		
		//check to see if this JPanel has been resized
		int newWidth = this.getWidth();
		int newHeight = this.getHeight();
		if((newWidth>theWidthOfThisPanel)||(newWidth<theWidthOfThisPanel))
		{
			//
			System.out.println("width change new=" + newWidth);
			theWidthOfThisPanel = newWidth;
		}
		if((newHeight>theHeightOfThisPanel)||(newHeight<theHeightOfThisPanel))
		{
			//
			System.out.println("Height change new=" + newHeight);
			theHeightOfThisPanel = newHeight;
		}
		
	}
	
	public void keyPressed(KeyEvent keyevPr)
	{
		//
		System.out.println("keypressed");
	}
	
	public void keyTyped(KeyEvent unicodeCharSentToSystemOutput){}
	
	public void keyReleased(KeyEvent keyevRe)
	{
		//
	}
}



/*above line reserved for package declaration*/

/*
** (c) C0nfuseki/The Chown/Sophie Chown 2016
** 
** Class to take:
** chosen JPanel class
** chosen JMenu class
** ...for display in a window
** 
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

import javax.swing.JButton;
import java.awt.Font;//java.awt[.Font] (NOT: java.awt.font)
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Color;//java.awt.Color --> Color, 

public class GuiTemplate extends JPanel implements ActionListener, KeyListener
{
	//declared class variables:
	//
	final int MICROSECSUPDATERATE = 20;
	
	Timer dynamticker = new Timer(MICROSECSUPDATERATE, this);//javax.swing.Timer
	//'this' refers to how GuiTemplate implements ActionListener
	
	//JButton butSelec1, butSelec2, butSelec3, butSelec4, butSelec5, butSelec6;
	GridBagLayout butDisplay = new GridBagLayout();
	GridBagConstraints butArrange = new GridBagConstraints();
	
	//defining a particular arrangement of buttons (this can be copied to make another button arrangement group)
	int numButtons = 12;
	JButton[] buttonArray;
	Font buttfont = new Font("Monospaced", Font.BOLD, 12);// //Serif, SansSerif, Monospaced, Dialog, and DialogInput -- BOLD ITALIC PLAIN --
	String[] buttonNames = {"Button01", "Button02", "Button03", "Button04", "Button05", "Button06", "Button07", "Button08", "Button09", "Button10", "Button11", "Button12"};
	String[] buttonCommandNames = {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8" , "b9", "b10", "b11", "b12"};
	
	
	GuiTemplate()
	{
		//
		
		//this.setPreferredSize(new Dimension(400, 200));
		//this.setMinimumSize(new Dimension(400, 200));
		//this.setMaximumSize(new Dimension(500, 500));
		
		this.setFocusable(true);// //usually set to true by default
		this.setFocusTraversalKeysEnabled(false);
		Color c = new Color(255, 255, 0, 63);
		this.setBackground(c);//javax.swing.JComponent (implemented by javax.swing.JPanel), java.awt.Color
		
		this.dynamticker.start();//javax.swing.Timer //for implementing repainting on changes
		
		this.addKeyListener(this);
		//'this' refers to how GuiTemplate implements KeyListener
		
		
		
		this.setLayout(butDisplay);
		//gridbaglayout
		
        butArrange.insets.top = 1;
        butArrange.insets.bottom = 1;
        butArrange.insets.left = 1;
        butArrange.insets.right = 1;
        
		butArrange.weightx = 1.0;// //how much the buttons expand with window increase
		butArrange.weighty = 1.0;
        
		//butArrange.anchor = GridBagConstraints.WEST;
		// CENTER, NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, and NORTHWEST
		
		/**/
		
		buttonArray = new JButton[numButtons];
		for (int i=0;i<numButtons;i++)
		{
			buttonArray[i] = new JButton(buttonNames[i]);
			buttonArray[i].addActionListener(this);
			buttonArray[i].setActionCommand(buttonCommandNames[i]);
			buttonArray[i].setFont(buttfont);
			//
			buttonArray[i].setFocusable(true);// //usually set to true by default
			buttonArray[i].addKeyListener(this);// //used so keys can be pressed while focused
			
		}
		GridBagConstraints[] butsettings;
		//butsettings = ButtonScheme.VerticalStarTrek(butArrange,numButtons);
		//butsettings = ButtonScheme.VerticalBrickwork(butArrange,numButtons);
		//butsettings = ButtonScheme.VerticalPaired(butArrange,numButtons);
		//butsettings = ButtonScheme.VerticalAltBrickwork(butArrange,numButtons);
		butsettings = ButtonScheme.VerticalTlaBrickwork(butArrange,numButtons);
		for (int i=0;i<numButtons;i++)
		{
			this.add(buttonArray[i], butsettings[i]);
		}
		
		/**/
		
	}
	
	public void actionPerformed(ActionEvent actev)
	{
		//
		//System.out.println("param string   " + actev.paramString());
		String actionType = actev.getActionCommand();
		
		if(actionType != null)
		{
			for (int i=0; i<numButtons; i++)
			{
				//
				if(actionType.equals(buttonCommandNames[i]))
				{
					//buttonCommandNames[i] has been triggered. with index i.
					
					System.out.println(" " + buttonCommandNames[i]);
					
					break;
				}
			}
			
			
		}
		else
		{
			//null action triggered by the timer and nothing to report ends up here
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

class ButtonScheme
{
	//
	private static final boolean BUTTONASSIGNMENTTEST = true;//for testing the assignment of buttons
	
	
	ButtonScheme()
	{
		//constructor not needed/used
	}
	
	static GridBagConstraints[] VerticalStarTrek(GridBagConstraints sourceConfig, int numOfBut)
	{
		//
		GridBagConstraints[] result = new GridBagConstraints[numOfBut];
		
		for (int i=0; i<numOfBut; i++)
		{
			//
			result[i] = new GridBagConstraints();
			result[i].gridx = sourceConfig.gridx;
			result[i].gridy = sourceConfig.gridy;
			result[i].gridwidth = sourceConfig.gridwidth;
			result[i].gridheight = sourceConfig.gridheight;
			result[i].weightx = sourceConfig.weightx;
			result[i].weighty = sourceConfig.weighty;
			result[i].anchor = sourceConfig.anchor;
			result[i].fill = sourceConfig.fill;
			result[i].ipadx = sourceConfig.ipadx;
			result[i].ipady = sourceConfig.ipady;
			result[i].insets.top = sourceConfig.insets.top;
			result[i].insets.bottom = sourceConfig.insets.bottom;
			result[i].insets.right = sourceConfig.insets.right;
			result[i].insets.left = sourceConfig.insets.left;
			
			if((i%3)==0)
			{
				//divisible: 3*k
				result[i].gridx = 0;
				result[i].gridy = 2*(i/3);
				result[i].gridwidth = 1;
				result[i].gridheight = 2;
				result[i].fill = GridBagConstraints.VERTICAL;
				
			}
			else if(((i+2)%3)==0)
			{
				//divisible: 3*k+1
				result[i].gridx = 1;
				result[i].gridy = 2*(i/3);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+1)%3)==0)
			{
				//divisible: 3*k+2
				result[i].gridx = 1;
				result[i].gridy = 2*(i/3)+1;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else
			{
				//a calculation error occcured
			}
			
		}
		
		//for testing
		for(int i=0; i<numOfBut; i++)
		{
			if(BUTTONASSIGNMENTTEST)
			{
				System.out.println("index " + i);
				System.out.println("gridx " + result[i].gridx);
				System.out.println("gridy " + result[i].gridy);
				System.out.println("gridwidth " + result[i].gridwidth);
				System.out.println("gridheight " + result[i].gridheight);
			}
 		}
		
		return result;
	}
	
	static GridBagConstraints[] VerticalBrickwork(GridBagConstraints sourceConfig, int numOfBut)
	{
		//
		GridBagConstraints[] result = new GridBagConstraints[numOfBut];
		
		for (int i=0; i<numOfBut; i++)
		{
			//
			result[i] = new GridBagConstraints();
			result[i].gridx = sourceConfig.gridx;
			result[i].gridy = sourceConfig.gridy;
			result[i].gridwidth = sourceConfig.gridwidth;
			result[i].gridheight = sourceConfig.gridheight;
			result[i].weightx = sourceConfig.weightx;
			result[i].weighty = sourceConfig.weighty;
			result[i].anchor = sourceConfig.anchor;
			result[i].fill = sourceConfig.fill;
			result[i].ipadx = sourceConfig.ipadx;
			result[i].ipady = sourceConfig.ipady;
			result[i].insets.top = sourceConfig.insets.top;
			result[i].insets.bottom = sourceConfig.insets.bottom;
			result[i].insets.right = sourceConfig.insets.right;
			result[i].insets.left = sourceConfig.insets.left;
			
			if((i%3)==0)
			{
				//divisible: 3*k
				result[i].gridx = 0;
				result[i].gridy = 2*(i/3);
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.HORIZONTAL;
				
			}
			else if(((i+2)%3)==0)
			{
				//divisible: 3*k+1
				result[i].gridx = 0;
				result[i].gridy = 2*(i/3)+1;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+1)%3)==0)
			{
				//divisible: 3*k+2
				result[i].gridx = 1;
				result[i].gridy = 2*(i/3)+1;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else
			{
				//a calculation error occcured
			}
			
		}
		
		//for testing
		for(int i=0; i<numOfBut; i++)
		{
			if(BUTTONASSIGNMENTTEST)
			{
				System.out.println("index " + i);
				System.out.println("gridx " + result[i].gridx);
				System.out.println("gridy " + result[i].gridy);
				System.out.println("gridwidth " + result[i].gridwidth);
				System.out.println("gridheight " + result[i].gridheight);
			}
 		}
		
		return result;
	}
	
	static GridBagConstraints[] VerticalPaired(GridBagConstraints sourceConfig, int numOfBut)
	{
		//
		GridBagConstraints[] result = new GridBagConstraints[numOfBut];
		
		for (int i=0; i<numOfBut; i++)
		{
			//
			result[i] = new GridBagConstraints();
			result[i].gridx = sourceConfig.gridx;
			result[i].gridy = sourceConfig.gridy;
			result[i].gridwidth = sourceConfig.gridwidth;
			result[i].gridheight = sourceConfig.gridheight;
			result[i].weightx = sourceConfig.weightx;
			result[i].weighty = sourceConfig.weighty;
			result[i].anchor = sourceConfig.anchor;
			result[i].fill = sourceConfig.fill;
			result[i].ipadx = sourceConfig.ipadx;
			result[i].ipady = sourceConfig.ipady;
			result[i].insets.top = sourceConfig.insets.top;
			result[i].insets.bottom = sourceConfig.insets.bottom;
			result[i].insets.right = sourceConfig.insets.right;
			result[i].insets.left = sourceConfig.insets.left;
			
			if((i%2)==0)
			{
				//divisible: 2*k
				result[i].gridx = 0;
				result[i].gridy = (i/2);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+1)%2)==0)
			{
				//divisible: 2*k+1
				result[i].gridx = 1;
				result[i].gridy = (i/2);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else
			{
				//a calculation error occcured
			}
			
		}
		
		//for testing
		for(int i=0; i<numOfBut; i++)
		{
			if(BUTTONASSIGNMENTTEST)
			{
				System.out.println("index " + i);
				System.out.println("gridx " + result[i].gridx);
				System.out.println("gridy " + result[i].gridy);
				System.out.println("gridwidth " + result[i].gridwidth);
				System.out.println("gridheight " + result[i].gridheight);
			}
 		}
		
		return result;
	}
	
	static GridBagConstraints[] VerticalAltBrickwork(GridBagConstraints sourceConfig, int numOfBut)
	{
		//
		GridBagConstraints[] result = new GridBagConstraints[numOfBut];
		
		for (int i=0; i<numOfBut; i++)
		{
			//
			result[i] = new GridBagConstraints();
			result[i].gridx = sourceConfig.gridx;
			result[i].gridy = sourceConfig.gridy;
			result[i].gridwidth = sourceConfig.gridwidth;
			result[i].gridheight = sourceConfig.gridheight;
			result[i].weightx = sourceConfig.weightx;
			result[i].weighty = sourceConfig.weighty;
			result[i].anchor = sourceConfig.anchor;
			result[i].fill = sourceConfig.fill;
			result[i].ipadx = sourceConfig.ipadx;
			result[i].ipady = sourceConfig.ipady;
			result[i].insets.top = sourceConfig.insets.top;
			result[i].insets.bottom = sourceConfig.insets.bottom;
			result[i].insets.right = sourceConfig.insets.right;
			result[i].insets.left = sourceConfig.insets.left;
			
			if((i%9)==0)
			{
				//divisible: 9*k
				result[i].gridx = 0;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+8)%9)==0)
			{
				//divisible: 9*k+1
				result[i].gridx = 1;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+7)%9)==0)
			{
				//divisible: 9*k+2
				result[i].gridx = 2;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+6)%9)==0)
			{
				//divisible: 9*k+3
				result[i].gridx = 3;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+5)%9)==0)
			{
				//divisible: 9*k+4//////////////////////////////two
				result[i].gridx = 0;
				result[i].gridy = 3*(i/9)+1;
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.HORIZONTAL;
				
			}
			else if(((i+4)%9)==0)
			{
				//divisible: 9*k+5
				result[i].gridx = 2;
				result[i].gridy = 3*(i/9)+1;
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.HORIZONTAL;
				
			}
			else if(((i+3)%9)==0)
			{
				//divisible: 9*k+6
				result[i].gridx = 0;
				result[i].gridy = 3*(i/9)+2;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else if(((i+2)%9)==0)
			{
				//divisible: 9*k+7
				result[i].gridx = 1;
				result[i].gridy = 3*(i/9)+2;
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.HORIZONTAL;
				
			}
			else if(((i+1)%9)==0)
			{
				//divisible: 9*k+8
				result[i].gridx = 3;
				result[i].gridy = 3*(i/9)+2;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.NONE;
				
			}
			else
			{
				//a calculation error occcured
			}
			
		}
		
		//for testing
		for(int i=0; i<numOfBut; i++)
		{
			if(BUTTONASSIGNMENTTEST)
			{
				System.out.println("index " + i);
				System.out.println("gridx " + result[i].gridx);
				System.out.println("gridy " + result[i].gridy);
				System.out.println("gridwidth " + result[i].gridwidth);
				System.out.println("gridheight " + result[i].gridheight);
			}
 		}
		
		return result;
	}
	
	static GridBagConstraints[] VerticalTlaBrickwork(GridBagConstraints sourceConfig, int numOfBut)
	{
		//
		GridBagConstraints[] result = new GridBagConstraints[numOfBut];
		
		for (int i=0; i<numOfBut; i++)
		{
			//
			result[i] = new GridBagConstraints();
			result[i].gridx = sourceConfig.gridx;
			result[i].gridy = sourceConfig.gridy;
			result[i].gridwidth = sourceConfig.gridwidth;
			result[i].gridheight = sourceConfig.gridheight;
			result[i].weightx = sourceConfig.weightx;
			result[i].weighty = sourceConfig.weighty;
			result[i].anchor = sourceConfig.anchor;
			result[i].fill = sourceConfig.fill;
			result[i].ipadx = sourceConfig.ipadx;
			result[i].ipady = sourceConfig.ipady;
			result[i].insets.top = sourceConfig.insets.top;
			result[i].insets.bottom = sourceConfig.insets.bottom;
			result[i].insets.right = sourceConfig.insets.right;
			result[i].insets.left = sourceConfig.insets.left;
			
			if((i%9)==0)
			{
				//divisible: 9*k
				result[i].gridx = 0;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+8)%9)==0)
			{
				//divisible: 9*k+1
				result[i].gridx = 1;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+7)%9)==0)
			{
				//divisible: 9*k+2
				result[i].gridx = 2;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+6)%9)==0)
			{
				//divisible: 9*k+3
				result[i].gridx = 3;
				result[i].gridy = 3*(i/9);
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+5)%9)==0)
			{
				//divisible: 9*k+4
				result[i].gridx = 0;
				result[i].gridy = 3*(i/9)+1;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+4)%9)==0)
			{
				//divisible: 9*k+5
				result[i].gridx = 1;
				result[i].gridy = 3*(i/9)+1;
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+3)%9)==0)
			{
				//divisible: 9*k+6
				result[i].gridx = 3;
				result[i].gridy = 3*(i/9)+1;
				result[i].gridwidth = 1;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+2)%9)==0)
			{
				//divisible: 9*k+7
				result[i].gridx = 0;
				result[i].gridy = 3*(i/9)+2;
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else if(((i+1)%9)==0)
			{
				//divisible: 9*k+8
				result[i].gridx = 2;
				result[i].gridy = 3*(i/9)+2;
				result[i].gridwidth = 2;
				result[i].gridheight = 1;
				result[i].fill = GridBagConstraints.BOTH;
				
			}
			else
			{
				//a calculation error occcured
			}
			
		}
		
		//for testing
		for(int i=0; i<numOfBut; i++)
		{
			if(BUTTONASSIGNMENTTEST)
			{
				System.out.println("index " + i);
				System.out.println("gridx " + result[i].gridx);
				System.out.println("gridy " + result[i].gridy);
				System.out.println("gridwidth " + result[i].gridwidth);
				System.out.println("gridheight " + result[i].gridheight);
			}
 		}
		
		return result;
	}
	
}

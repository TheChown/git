
/*above line reserved for package declaration*/

/*
** (c) C0nfuseki/The Chown/Sophie Chown 2016
** 
** Class to take:
** chosen JPanel class
** chosen JMenu class
** ...for display in a window's menu with accessability menu shortcuts
** 
** For more info see: docs.oracle.com/javase/tutorial/uiswing/components/menu.html
*/

//import java.lang.*; //lang package(By default)--> System.out.println(String) , 
import javax.swing.JMenuBar; //JMenuBar class --> JMenuBar, add(JMenu), 
import javax.swing.JMenu; //JMenu class --> JMenu, add(JMenuItem), addSeparator(), 
import javax.swing.JMenuItem; //JMenuItem class --> JMenuItem

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GuiMenu implements ActionListener, KeyListener
{
	//declared class variables:
	//
	public enum Default { MENUSTYLE }
	public enum Single { MENUSTYLE }
	/*Note: GuiMenu constructors are to be called with GuiMenu._.MENUSTYLE*/
	//
	private JMenuBar mBar;
	
	
	//constructor
	GuiMenu()
	{
		this(Default.MENUSTYLE);
	}
	
	GuiMenu(Default unusedValue)
	{
		//MenuEntriesToKeyBindings:
		//
		//File <Alt+F>
		//File --> Open <Alt+O> defaultfileopen
		//File --> Save <Alt+S> defaultfilesave
		//File --> Print <Alt+P> defaultfileprint
		//File --> Quit <Alt+Q> defaultfilequit
		//
		//Edit <Alt+E>
		//Edit --> Copy <Alt+C> defaulteditcopy
		//Edit --> Paste <Alt+V> defaulteditpaste
		//Edit --> Delete <Alt+D> defaulteditdelete
		//
		//Help <Alt+H>
		//Help --> About <Alt+A> defaulthelpabout
		
		mBar = new JMenuBar();
		
		JMenu fileoption = new JMenu("File");
		JMenuItem openfo = new JMenuItem("Open File...");
		JMenuItem savefo = new JMenuItem("Save File");
		JMenuItem printfo = new JMenuItem("Print");
		JMenuItem quitfo = new JMenuItem("Quit");
		//
		fileoption.setMnemonic(KeyEvent.VK_F);
		openfo.setMnemonic(KeyEvent.VK_O);
		savefo.setMnemonic(KeyEvent.VK_S);
		printfo.setMnemonic(KeyEvent.VK_P);
		quitfo.setMnemonic(KeyEvent.VK_Q);
		//
		//fileoption.getAccessibleContext().setAccessibleDescription("123");
		//openfo.getAccessibleContext().setAccessibleDescription("123");
        //savefo.getAccessibleContext().setAccessibleDescription("123");
        //printfo.getAccessibleContext().setAccessibleDescription("123");
        //quitfo.getAccessibleContext().setAccessibleDescription("123");
		//
		//fileoption.addActionListener(this);
		openfo.addActionListener(this);
		savefo.addActionListener(this);
		printfo.addActionListener(this);
		quitfo.addActionListener(this);
		//'this' refers to the instance of the GuiMenu class (as it implements ActionListener)
		//
		//fileoption.setActionCommand("");
		openfo.setActionCommand("defaultfileopen");
		savefo.setActionCommand("defaultfilesave");
		printfo.setActionCommand("defaultfileprint");
		quitfo.setActionCommand("defaultfilequit");
		//
		mBar.add(fileoption);
		fileoption.add(openfo);
		fileoption.add(savefo);
		fileoption.add(printfo);
		fileoption.addSeparator();
		fileoption.add(quitfo);
		///
		
		JMenu editoption = new JMenu("Edit");
		JMenuItem copyeo = new JMenuItem("Copy");
		JMenuItem pasteeo = new JMenuItem("Paste");
		JMenuItem deleteeo = new JMenuItem("Delete");
		//
		editoption.setMnemonic(KeyEvent.VK_E);
		copyeo.setMnemonic(KeyEvent.VK_C);
		pasteeo.setMnemonic(KeyEvent.VK_P);
		deleteeo.setMnemonic(KeyEvent.VK_D);
		//
		//editoption.getAccessibleContext().setAccessibleDescription("abc");
        //copyeo.getAccessibleContext().setAccessibleDescription("abc");
        //pasteeo.getAccessibleContext().setAccessibleDescription("abc");
        //deleteeo.getAccessibleContext().setAccessibleDescription("abc");
		//
		//editoption.addActionListener(this);
		copyeo.addActionListener(this);
		pasteeo.addActionListener(this);
		deleteeo.addActionListener(this);
		//'this' refers to the instance of the GuiMenu class (as it implements ActionListener)
		//
		//editoption.setActionCommand("");
		copyeo.setActionCommand("defaulteditcopy");
		pasteeo.setActionCommand("defaulteditpaste");
		deleteeo.setActionCommand("defaulteditdelete");
		//
		mBar.add(editoption);
		editoption.add(copyeo);
		editoption.add(pasteeo);
		editoption.add(deleteeo);
		///
		
		JMenu helpoption = new JMenu("Help");
		JMenuItem aboutho = new JMenuItem("About");
		//
		helpoption.setMnemonic(KeyEvent.VK_H);
		aboutho.setMnemonic(KeyEvent.VK_A);
		//
		//helpoption.getAccessibleContext().setAccessibleDescription("xyz");
		//aboutho.getAccessibleContext().setAccessibleDescription("xyz");
        //
		//helpoption.addActionListener(this);
		aboutho.addActionListener(this);
		//'this' refers to the instance of the GuiMenu class (as it implements ActionListener)
        //
		//helpoption.setActionCommand("");
		aboutho.setActionCommand("defaulthelpabout");
        //
		mBar.add(helpoption);
		helpoption.add(aboutho);
		///
		
	}
	
	GuiMenu(Single unusedValue)
	{
		//MenuEntriesToKeyBindings:
		//
		//File <Alt+F>
		//File --> Open <Alt+O> singlefileopen
		//File --> Save <Alt+S> singlefilesave
		//File --> Print <Alt+P> singlefileprint
		//File --> Quit <Alt+Q> singlefilequit
		
		mBar = new JMenuBar();
		
		JMenu fileoption = new JMenu("File");
		JMenuItem openfo = new JMenuItem("Open File...");
		JMenuItem savefo = new JMenuItem("Save File");
		JMenuItem printfo = new JMenuItem("Print");
		JMenuItem quitfo = new JMenuItem("Quit");
		//
		fileoption.setMnemonic(KeyEvent.VK_F);
		openfo.setMnemonic(KeyEvent.VK_O);
		savefo.setMnemonic(KeyEvent.VK_S);
		printfo.setMnemonic(KeyEvent.VK_P);
		quitfo.setMnemonic(KeyEvent.VK_Q);
		//
		//fileoption.getAccessibleContext().setAccessibleDescription("123");
		//openfo.getAccessibleContext().setAccessibleDescription("123");
        //savefo.getAccessibleContext().setAccessibleDescription("123");
        //printfo.getAccessibleContext().setAccessibleDescription("123");
        //quitfo.getAccessibleContext().setAccessibleDescription("123");
		//
		//fileoption.addActionListener(this);
		openfo.addActionListener(this);
		savefo.addActionListener(this);
		printfo.addActionListener(this);
		quitfo.addActionListener(this);
		//'this' refers to the instance of the GuiMenu class (as it implements ActionListener)
		//
		//fileoption.setActionCommand("");
		openfo.setActionCommand("singlefileopen");
		savefo.setActionCommand("singlefilesave");
		printfo.setActionCommand("singlefileprint");
		quitfo.setActionCommand("singlefilequit");
		//
		mBar.add(fileoption);
		fileoption.add(openfo);
		fileoption.add(savefo);
		fileoption.add(printfo);
		fileoption.addSeparator();
		fileoption.add(quitfo);
		///
		
	}
	//endconstructor
	
	
	public void actionPerformed(ActionEvent actev)
	{
		/**/
		//testing of menu item selected
		System.out.println("Menu item selected");
		String testAction = actev.getActionCommand();
		System.out.println(testAction!=null?testAction:"null");
		/**/
		
		//ensure param doesn't need repeating calculation
		String actionValue = actev.getActionCommand();
		
		if((actionValue.equals("defaultfileopen"))||(actionValue.equals("singlefileopen"))||(actionValue.equals("fileopen")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("defaultfilesave"))||(actionValue.equals("singlefilesave"))||(actionValue.equals("filesave")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("defaultfileprint"))||(actionValue.equals("singlefileprint"))||(actionValue.equals("fileprint")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("defaultfilequit"))||(actionValue.equals("singlefilequit"))||(actionValue.equals("filequit")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("file"))||(actionValue.equals("file"))||(actionValue.equals("file")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("defaulteditcopy"))||(actionValue.equals("editcopy"))||(actionValue.equals("editcopy")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("defaulteditpaste"))||(actionValue.equals("editpaste"))||(actionValue.equals("editpaste")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("defaulteditdelete"))||(actionValue.equals("editdelete"))||(actionValue.equals("editdelete")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("edit"))||(actionValue.equals("edit"))||(actionValue.equals("edit")))
		{
			//
		}
		else if((actionValue.equals("edit"))||(actionValue.equals("edit"))||(actionValue.equals("edit")))
		{
			//
		}
		else if((actionValue.equals("defaulthelpabout"))||(actionValue.equals("helpabout"))||(actionValue.equals("helpabout")))
		{
			//
			System.out.println("x");
		}
		else if((actionValue.equals("help"))||(actionValue.equals("help"))||(actionValue.equals("help")))
		{
			//
		}
		else if((actionValue.equals("help"))||(actionValue.equals("help"))||(actionValue.equals("help")))
		{
			//
		}
		else if((actionValue.equals("help"))||(actionValue.equals("help"))||(actionValue.equals("help")))
		{
			//
		}
		else if((actionValue.equals("help"))||(actionValue.equals("help"))||(actionValue.equals("help")))
		{
			//
		}
		
	}
	
	public void keyPressed(KeyEvent keyevPr){}
	
	public void keyTyped(KeyEvent unicodeCharSentToSystemOutput){}
	
	public void keyReleased(KeyEvent keyevRe){}
	
	
	public JMenuBar getBar()
	{
		return mBar;
	}
	
	//public static void main(String[] args)
	/*No main method for testing*/
}

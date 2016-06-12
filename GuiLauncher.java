
/*above line reserved for package declaration*/

/*
** (c) C0nfuseki/The Chown/Sophie Chown 2016
** 
** Class to take:
** chosen JPanel class
** chosen JMenu class
** ...for display in a window
** 
*/

//import java.lang.*; //lang package(By default)--> System.out.println(String) , 
import javax.swing.JFrame; //JFrame class--> JFrame , setTitle(String), setSize(int,int), setDefaultCloseOperation(ENUM), setJMenuBar(JMenuBar), setLocation(int,int), 
import javax.swing.JMenuBar; //JMenuBar class --> JMenuBar,
import javax.swing.JPanel;

//import GuiMenu.MenuStyle;
import java.awt.GridBagConstraints;//??? might not need to use
import java.awt.GridBagLayout;//??? might not need to use here as GTwrapper keeps track


public class GuiLauncher
{
	//declared class variables:
	//
	private final boolean showConstructorTests = false;//for testing this class
	//
	private int defaultWindowWidth = 414;
	private int defaultWindowHeight = 256;
	private int defaultWindowXPosition = 55;
	private int defaultWindowYPosition = 55;
	//
	private String defaultWindowTitle = "test";
	//
	private JFrame guiWindow;
	private JMenuBar guiMenu;
	
	//constructor with recursive chaining
	/*Note: param order is String, int, int, JMenuBar, int, int*/
	GuiLauncher()
	{
		this(null,null);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor noparam");//java.lang.[System]
		}
	}
	
	GuiLauncher(String winTitle)
	{
		this(winTitle, null);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor Stringparam");//java.lang.[System]
			String p1 = (winTitle != null) ? winTitle.toString() : "null";
			System.out.println("String = " + p1);//java.lang.[System]
		}
	}
	
	GuiLauncher(JMenuBar winMenu)
	{
		this(null, winMenu);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor JMenuBarparam");//java.lang.[System]
			String p1 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("String = " + p1);//java.lang.[System]
		}
	}
	
	GuiLauncher(String winTitle, JMenuBar winMenu)
	{
		this(winTitle, -1, -1, winMenu, -1, -1);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor StringJMenuBarparam");//java.lang.[System]
			String p1 = (winTitle != null) ? winTitle.toString() : "null";
			String p2 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("String = " + p1 + " JMenuBar = " + p2);//java.lang.[System]
		}
	}
	
	GuiLauncher(int winWidth, int winHeight)
	{
		this(winWidth, winHeight, -1, -1);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor intintparam");//java.lang.[System]
			System.out.println("winWidth = " + winWidth + " winHeight = " + winHeight);//java.lang.[System]
		}
	}
	
	GuiLauncher(int winWidth, int winHeight, int winXPosition, int winYPosition)
	{
		this(null, winWidth, winHeight, winXPosition, winYPosition);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor intintintintparam");//java.lang.[System]
			System.out.println("winWidth = " + winWidth + " winHeight = " + winHeight + "winXPosition = " + winXPosition + "winYPosition = " + winYPosition);//java.lang.[System]
		}
	}
	
	GuiLauncher(String winTitle, int winWidth, int winHeight)
	{
		this(winTitle, winWidth, winHeight, -1, -1);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor Stringintintparam");//java.lang.[System]
			String p1 = (winTitle != null) ? winTitle.toString() : "null";
			System.out.println("String" + p1 + " winWidth = " + winWidth + " winHeight = " + winHeight);//java.lang.[System]
		}
	}
	
	GuiLauncher(String winTitle, int winWidth, int winHeight, JMenuBar winMenu)
	{
		this(winTitle, winWidth, winHeight, winMenu, -1, -1);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor StringintintJMenuBarparam");//java.lang.[System]
			String p1 = (winTitle != null) ? winTitle.toString() : "null";
			String p2 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("String" + p1 + " winWidth = " + winWidth + " winHeight = " + winHeight + "JMenuBar = " + p2);//java.lang.[System]
		}
	}
	
	GuiLauncher(String winTitle, int winWidth, int winHeight, int winXPosition, int winYPosition)
	{
		this(winTitle, winWidth, winHeight, null, winXPosition, winYPosition);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor Stringintintintintparam");//java.lang.[System]
			String p1 = (winTitle != null) ? winTitle.toString() : "null";
			System.out.println("String" + p1 + " winWidth = " + winWidth + " winHeight = " + winHeight + " winXPosition = " + winXPosition + " winYPosition = " + winYPosition);//java.lang.[System]
		}
	}
	
	GuiLauncher(int winWidth, int winHeight, JMenuBar winMenu)
	{
		this(winWidth, winHeight, winMenu, -1, -1);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor intintJMenuBarparam");//java.lang.[System]
			String p1 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("winWidth = " + winWidth + " winHeight = " + winHeight + " JMenuBar = " + p1);//java.lang.[System]
		}
	}
	
	GuiLauncher(JMenuBar winMenu, int winXPosition, int winYPosition)
	{
		this(-1, -1, winMenu, winXPosition, winYPosition);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor JMenuBarintintparam");//java.lang.[System]
			String p1 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("JMenuBar = " + p1 + " winXPosition = " + winXPosition + " winYPosition = " + winYPosition);//java.lang.[System]
		}
	}
	
	GuiLauncher(int winWidth, int winHeight, JMenuBar winMenu, int winXPosition, int winYPosition)
	{
		this(null, winWidth, winHeight, winMenu, winXPosition, winYPosition);//GuiLauncher local(this class)
		/*self-reference 'this' must be first statement in constructor*/
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher constructor intintJMenuBarintintparam");//java.lang.[System]
			String p1 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("winWidth = " + winWidth + " winHeight = " + winHeight + " JMenuBar = " + p1 + " winXPosition = " + winXPosition + " winYPosition = " + winYPosition);//java.lang.[System]
		}
	}
	
	GuiLauncher(String winTitle, int winWidth, int winHeight, JMenuBar winMenu, int winXPosition, int winYPosition)
	{
		
		//instantiate
		guiWindow = new JFrame();//javax.swing.JFrame
		
		if(winTitle != null)
		{
			guiWindow.setTitle(winTitle);//(inhereted from java.awt.Frame) javax.swing.JFrame
		}
		else
		{
			guiWindow.setTitle(defaultWindowTitle);//(inhereted from java.awt.Frame) javax.swing.JFrame
		}
		
		if((winWidth>0)&&(winHeight>0))
		{
			guiWindow.setSize(winWidth,winHeight);//(inhereted from java.awt.Window) javax.swing.JFrame
		}
		else
		{
			guiWindow.setSize(defaultWindowWidth,defaultWindowHeight);//(inhereted from java.awt.Window) javax.swing.JFrame
		}
		
		if(winMenu != null)
		{
			guiMenu = winMenu;
			
			guiWindow.setJMenuBar(guiMenu);//javax.swing.JFrame
		}
		else if(guiMenu != null)
		{
			guiWindow.setJMenuBar(guiMenu);//javax.swing.JFrame
			System.out.println("Warning. default Menu assigned during Constructor. For window named: " + guiWindow.getTitle());//java.lang.[System], java.awt.Frame
		}
		else
		{
			
			System.out.println("Warning. no Menu assigned during Constructor. For window named: " + guiWindow.getTitle());//java.lang.[System], java.awt.Frame
		}
		
		if((winXPosition>=0)&&(winYPosition>=0))
		{
			guiWindow.setLocation(winXPosition, winYPosition);//(inhereted from java.awt.Window) javax.swing.JFrame
		}
		else
		{
			guiWindow.setLocation(defaultWindowXPosition, defaultWindowYPosition);//(inhereted from java.awt.Window) javax.swing.JFrame
		}
		
		guiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//javax.swing.JFrame
		/*The above closes all JPanel instances when one of the windows closes*/
		
		//TODO: add more classess later
		
		//
		if(showConstructorTests){
			System.out.println("GuiLauncher allparams constructor triggered");//java.lang.[System]
			String p1 = (winTitle != null) ? winTitle.toString() : "null";
			String p2 = (winMenu != null) ? winMenu.toString() : "null";
			System.out.println("String = " + p1 + " winWidth = " + winWidth + " winHeight = " + winHeight + " JMenuBar = " + p2 + " winXPosition = " + winXPosition + " winYPosition = " + winYPosition);//java.lang.[System]
		}
	}
	//endconstructor
	
	public void addPanel(JPanel importedPanel)
	{
		//
		guiWindow.add(importedPanel);
	}
	
	public void setNewMenu(JMenuBar dispMenu)
	{
		if((dispMenu != null)&&(guiMenu == null))
		{
			//menu is being added, not replaced
			
			guiMenu = dispMenu;
			
			guiWindow.setJMenuBar(guiMenu);//javax.swing.JFrame
		}
		else if((dispMenu != null)&&(guiMenu != null))
		{
			//the menu is being replaced with another menu
			
			guiMenu = dispMenu;
			
			guiWindow.setJMenuBar(guiMenu);//javax.swing.JFrame
		}
		else
		{
			//no change
		}
		
		return;
	}
	
	public void makeVisible()
	{
		//This method needs to be set AFTER adding the menu bar or it won't display.
		guiWindow.setVisible(true);
		return;
	}
	
	public void shrink()
	{
		//
		guiWindow.pack();//java.awt.Window
	}
	
	public void generic01()
	{
		//
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("GuiLauncher main method triggered");//java.lang.[System]
		
		/**/
		//Testing of JFrame implementation
		int testXSpan = 300;
		int testYSpan = 300;
		int testXPos = 100;
		int testYPos = 100;
		
		//(Step 1/6) make windows
		GuiLauncher launchedWindow0 = new GuiLauncher("a");
		GuiLauncher launchedWindow1 = new GuiLauncher("b", testXSpan,testYSpan);
		GuiLauncher launchedWindow2 = new GuiLauncher("c");
		GuiLauncher launchedWindow3 = new GuiLauncher("d",testXSpan,testYSpan,testXPos,testYPos);
		GuiLauncher launchedWindow4 = new GuiLauncher(testXSpan,testYSpan,testXPos,testYPos);
		
		//(Step 2/6) make menu bars.Call different GuiMenu constructors by different GuiMenu enum type
		GuiMenu launchedMenu0 = new GuiMenu();
		GuiMenu launchedMenu1 = new GuiMenu(GuiMenu.Default.MENUSTYLE);
		GuiMenu launchedMenu2 = new GuiMenu(GuiMenu.Single.MENUSTYLE);
		GuiMenu launchedMenu3 = new GuiMenu(GuiMenu.Default.MENUSTYLE);
		GuiMenu launchedMenu4 = new GuiMenu(GuiMenu.Single.MENUSTYLE);
		
		//(Step 3/6) set menu bars to windows. Each GuiMenu must be unique
		launchedWindow0.setNewMenu(launchedMenu0.getBar());
		launchedWindow1.setNewMenu(launchedMenu1.getBar());
		launchedWindow2.setNewMenu(launchedMenu2.getBar());
		launchedWindow3.setNewMenu(launchedMenu3.getBar());
		launchedWindow4.setNewMenu(launchedMenu4.getBar());
		
		//(Step 4/6) Make panels
		GuiTemplate t = new GuiTemplate();
		GuiTemplate tt = new GuiTemplate();
		Tutorial t2 = new Tutorial();
		Tutorial t3 = new Tutorial();
		Tutorial t4 = new Tutorial();
		Tutorial t5 = new Tutorial();
		Tutorial t6 = new Tutorial();
		
		
		GuiTemplateWrapper ttt = new GuiTemplateWrapper();
		
		//
		ttt.insertLeftJPanel(tt);
		//ttt.add(tt);
		
		//(Step 5/6) set panels to windows. Each JPanel (or JPanel child) must be unique
		launchedWindow0.addPanel(t);
		launchedWindow1.addPanel(t2);
		launchedWindow2.addPanel(t3);
		launchedWindow3.addPanel(t4);
		launchedWindow4.addPanel(ttt);
		
		//(optional step) fit the window to the panels
		launchedWindow0.shrink();
		//launchedWindow1.shrink();
		
		//(Step 6/6) make windows visible
		launchedWindow0.makeVisible();
		launchedWindow1.makeVisible();
		launchedWindow2.makeVisible();
		launchedWindow3.makeVisible();
		launchedWindow4.makeVisible();
		/**/
		
	}
	
}

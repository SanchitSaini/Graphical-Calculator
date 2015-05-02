package Calculator.GUI;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JWindow;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;

import Calculator.Calculator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class GUI extends JFrame{

	private Calculator calculator;
	public CheckAndCorrectUI myCheckAndCorrectUI;
    public MemoryBasedFunctionsUI myMemoryFunctionsUI;
    public NumbersUI myNumbersUI;
    public FunctionsUI myFunctionsUI;
    public PlotUI myPlotUI;
    public Calculator myCalculator;
    private JTextField Input;
    private String expression;
    private String fileName;
    private String dir;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private String alignment;
    private String inputType;
    private double minX = -5;
	private double maxX = 5;
	private double minY = -5;
	private double maxY = 5;
	private int xAxis = 0;
	private int yAxis = 0;
	private boolean clearInput = false;
    //private ArrayList<String> expElements = new ArrayList<String>();
    //private ArrayList<String> expression = new ArrayList<String>();
    
  
    
    
    
    
    
    
    public GUI() {

    
    //Input JLabel added
    
    

    calculator = new Calculator();
    
    //Radian and Degree radio buttons
    JRadioButton rdbtnRadian = new JRadioButton("Radian");
  	buttonGroup_1.add(rdbtnRadian);
  	JRadioButton radioButton = new JRadioButton("Degree");
  	radioButton.setSelected(true);
  	buttonGroup_1.add(radioButton);
  	if(rdbtnRadian.isSelected())
    {
    	inputType = rdbtnRadian.getText(); 
    }
    if(radioButton.isSelected())
    {
    	inputType = radioButton.getText(); 
    }
  	
  	
  	//Input format from file for Statistics function
  	JRadioButton rdbtnRowwise = new JRadioButton("Rowwise");
  	buttonGroup.add(rdbtnRowwise);
  	JRadioButton rdbtnColumnwise = new JRadioButton("Columnwise");
  	buttonGroup.add(rdbtnColumnwise);
  	if(rdbtnRowwise.isSelected())
    {
    	alignment = rdbtnRowwise.getText(); 
    }
    if(rdbtnColumnwise.isSelected())
    {
    	alignment = rdbtnColumnwise.getText(); 
    }
    
    
    
    //Input given by user
    Input = new JTextField();
  	Input.setColumns(10);
  	Input.getDocument().addDocumentListener(new DocumentListener(){

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
			
			//expression to be given to character interpreter 
			//exp = Input.getText();
			//System.out.println(expression);
			//calculator.compute(expression);
//			exp = Input.getText();
//			expElements.add(exp);
//			String a = null;
//			String s1 = expElements.get(expElements.size() - 1);
//			if(expElements.size()>1)
//			{
//				String s2 = expElements.get(expElements.size() - 2);
//				a = s1.substring(s2.length());
//			
//			}
//			else
//			{
//				a = s1;
//			}	
//			System.out.println(a);
//			int asciiNew = (int)a.charAt(0);
//			String checkNum = expression.get(expression.size() - 1);
//			int asciiLast = (int)checkNum.charAt(checkNum.length() - 1);
//			boolean check1 = 48<=asciiLast && asciiLast<=57;
//			boolean check2 = 48<=asciiNew && asciiNew<=57;
//			if(check1 && check2)
//			{
//				checkNum.concat(a);
//				expression.remove(expression.size() - 1);
//				expression.add(checkNum);
//				return;
//				//expression.add();
//			}
//			expression.add(a);
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
	
		}
  		
  	});
  	
  	
  	
  	
  	//Digit Panel along with basic arithmetic buttons
  	JPanel digitPanel = new JPanel(new GridLayout(4,4));
  	digitPanel.setMinimumSize(new Dimension(80,80));
  	digitPanel.setPreferredSize(new Dimension(80,80));
  	digitPanel.setSize(new Dimension(80,80));
  	digitPanel.setLocation(20,10);
  	
  	//Variables and Other Basic Functionalities
  	JPanel staticPanel = new JPanel(new GridLayout(4,4));
  	staticPanel.setMinimumSize(new Dimension(80,80));
  	staticPanel.setPreferredSize(new Dimension(80,80));
  	staticPanel.setSize(new Dimension(80,80));
  	staticPanel.setLocation(20,10);
  	JButton[][] varGrid = new JButton[4][4];
  	for(int i=0;i<4;i++)
  	{
  		for(int j=0;j<4;j++)
  		{
  			varGrid[i][j] = new JButton();
  		}
  	}
  	varGrid[0][0].setText("x");
  	varGrid[0][0].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)arg0.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[0][1].setText("y");
  	varGrid[0][1].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[0][2].setText("a²");
  	varGrid[0][2].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			int lenInput  = Input.getText().length() - 1;
			String lastChar = Input.getText().substring(lenInput,lenInput + 1);
			System.out.println(lastChar);
			//System.out.println(lastChar=="+");
			boolean test = ((lastChar.equals("+")) || (lastChar.equals("-")) || (lastChar.equals("*")) || (lastChar.equals("/")) || (lastChar.equals("%")) || (lastChar.equals("^")));
			System.out.println(test);
			if(test)
			{
				String tempText = Input.getText().replace(lastChar,"^2");
				System.out.println(tempText);
				Input.setText(tempText);
			}
			else
			{
			Input.setText(Input.getText() + "^2");
			}
		}
  		
  	});
  	varGrid[0][3].setText("aˣ");
  	varGrid[0][3].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			int lenInput  = Input.getText().length() - 1;
			String lastChar = Input.getText().substring(lenInput,lenInput + 1);
			System.out.println(lastChar);
			//System.out.println(lastChar=="+");
			boolean test = ((lastChar.equals("+")) || (lastChar.equals("-")) || (lastChar.equals("*")) || (lastChar.equals("/")) || (lastChar.equals("%")) || (lastChar.equals("^")) || (lastChar.equals("^2")) );
			System.out.println(test);
			if(test)
			{
				String tempText = Input.getText().replace(lastChar,"^");
				System.out.println(tempText);
				Input.setText(tempText);
			}
			else
			{
				Input.setText(Input.getText() + "^");
			}	
		}
  		
  	});
  	varGrid[1][0].setText("(");
  	varGrid[1][0].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[1][1].setText(")");
  	varGrid[1][1].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[1][2].setText("<");
  	varGrid[1][2].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[1][3].setText(">");
  	varGrid[1][3].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	
  	varGrid[2][0].setText("|a|");
  	varGrid[2][1].setText(",");
  	varGrid[2][1].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[2][2].setText("<=");
  	varGrid[2][2].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[2][3].setText(">=");
  	varGrid[2][3].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	
  	varGrid[3][0].setText("√");
  	varGrid[3][0].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + "√(");
		}
  		
  	});
  	varGrid[3][1].setText("π");
  	varGrid[3][1].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[3][2].setText("e");
  	varGrid[3][2].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  	});
  	varGrid[3][3].setText("10ˣ");
  	varGrid[3][3].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)arg0.getSource();
			Input.setText(Input.getText() + "10^");
		}
  		
  	});
  	
  	for(int i=0;i<4;i++)
  	{
  		for(int j=0;j<4;j++)
  		{
  			staticPanel.add(varGrid[i][j]);
  		}
  	}
//  	groupLayout_1.setHorizontalGroup(
//  		groupLayout_1.createParallelGroup(Alignment.LEADING)
//  			.addGap(0, 796, Short.MAX_VALUE)
//  	);
//  	groupLayout_1.setVerticalGroup(
//  		groupLayout_1.createParallelGroup(Alignment.LEADING)
//  			.addGap(0, 259, Short.MAX_VALUE)
//  	);
//  	
//	graphPanel.addComponentListener(new ComponentListener(){
//
//		@Override
//		public void componentHidden(ComponentEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void componentMoved(ComponentEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void componentResized(ComponentEvent arg0) {
//			// TODO Auto-generated method stub
//			System.out.println("Gjdfk");
//			
//			JPanel a = (JPanel)arg0.getComponent();
//			//System.out.println(a.getSize());
//			a.paintComponents(getGraphics());
//			
//		}
//
//		@Override
//		public void componentShown(ComponentEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//  		
//  	});

  	
  	
   	//Adding TabbedPane having trigonomteric,misc,statistics,memory
  	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
  	TrigonometricFunctionsUI trigPanel = new TrigonometricFunctionsUI(Input);
  	tabbedPane.add("trig", trigPanel);
  	StatisticalFunctionsUI statPanel = new StatisticalFunctionsUI(calculator,Input);
  	tabbedPane.add("stats", statPanel);
  	MemoryBasedFunctionsUI memPanel = new MemoryBasedFunctionsUI();
  	tabbedPane.add("Mem", memPanel);
  	MiscFunctionsUI miscPanel = new MiscFunctionsUI(Input);
  	tabbedPane.add("Misc", miscPanel);
  	
  	//Choosing file for statistical functions
  	JButton btnChooseFile = new JButton("Choose File");
  	btnChooseFile.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			JFileChooser c = new JFileChooser();
  	      // Demonstrate "Open" dialog:
  	      int rVal = c.showOpenDialog(c);
  			if (rVal == JFileChooser.APPROVE_OPTION) {
  				//use alignment here for rowwise and columnwise
  				fileName = c.getSelectedFile().getName();
  				dir = c.getCurrentDirectory().toString();
//  				StringBuilder pathName = new StringBuilder();
  				String pathName = dir + "\\" + fileName;
  				calculator.readFromFile(pathName);
//  	        	System.out.println(fileName);
//  	      		System.out.println(dir);
  	      }
  	      if (rVal == JFileChooser.CANCEL_OPTION) {
  	        System.out.println("No File Selected!!");
  	      }
  		}
  	});
  	
  	
  	JButton btnGraph = new JButton("Graph");
  	final JPanel panel = new GraphPanel();
  	
  	
  	
  	JButton btnSaveGraph = new JButton("Save Graph");
  	btnSaveGraph.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			BufferedImage image = null;
  			try {
  				image = new Robot().createScreenCapture(new Rectangle(panel.getLocationOnScreen().x, panel.getLocationOnScreen().y, panel.getWidth(), panel.getHeight()));
  			} catch (AWTException e1) {
  				// TODO Auto-generated catch block
  				e1.printStackTrace();
  			}
  			String name = JOptionPane.showInputDialog("Enter filename");
  			File file = new File(name + ".png");
  		  	if (!file.exists()){
  		  		try {
  					file.createNewFile();
  				} catch (IOException e1) {
  					// TODO Auto-generated catch block
  					e1.printStackTrace();
  				}
  		  		try {
  					ImageIO.write(image, "png", file);
  				} catch (IOException e1) {
  					// TODO Auto-generated catch block
  					e1.printStackTrace();
  				}	
  		  	}	
  		}
  	});
  	
  	//Clear Input
  	JButton btnClear = new JButton("Clear");
  	btnClear.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			Input.setText("");
  		}
  	});
  	
  	
  	
  	GroupLayout groupLayout = new GroupLayout(getContentPane());
  	groupLayout.setHorizontalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(24)
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  					.addGroup(groupLayout.createSequentialGroup()
  						.addGap(25)
  						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  							.addGroup(groupLayout.createSequentialGroup()
  								.addComponent(digitPanel, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
  								.addPreferredGap(ComponentPlacement.UNRELATED)
  								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
  								.addGap(18)
  								.addComponent(staticPanel, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
  							.addGroup(groupLayout.createSequentialGroup()
  								.addComponent(rdbtnRadian)
  								.addGap(18)
  								.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
  								.addGap(18)
  								.addComponent(btnClear))))
  					.addGroup(groupLayout.createSequentialGroup()
  						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
  							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  							.addGroup(groupLayout.createSequentialGroup()
  								.addComponent(Input, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
  								.addGap(34)
  								.addComponent(btnChooseFile)
  								.addGap(34)
  								.addComponent(rdbtnRowwise)
  								.addGap(18)
  								.addComponent(rdbtnColumnwise)
  								.addGap(28)
  								.addComponent(btnGraph)))
  						.addGap(18)
  						.addComponent(btnSaveGraph)))
  				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
  	);
  	groupLayout.setVerticalGroup(
  		groupLayout.createParallelGroup(Alignment.TRAILING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(36)
  				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  					.addComponent(Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
  					.addComponent(btnChooseFile)
  					.addComponent(rdbtnColumnwise)
  					.addComponent(rdbtnRowwise)
  					.addComponent(btnGraph)
  					.addComponent(btnSaveGraph))
  				.addGap(31)
  				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
  				.addGap(32)
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  					.addGroup(groupLayout.createSequentialGroup()
  						.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
  						.addComponent(staticPanel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
  						.addGap(75))
  					.addGroup(groupLayout.createSequentialGroup()
  						.addGap(14)
  						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
  							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  								.addComponent(rdbtnRadian)
  								.addComponent(radioButton))
  							.addComponent(btnClear))
  						.addPreferredGap(ComponentPlacement.RELATED)
  						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
  							.addComponent(digitPanel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
  						.addGap(36))))
  	);
  	getContentPane().add(panel);
  	
  	

  	btnGraph.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			//panel = new GraphPanel();
  			((GraphPanel) panel).setEquation(Input.getText());
  			panel.repaint();
  		  	  		  	
  		}
  	});
  	
  	
  //Creating DigitPanel
  	int offset = 0;
	JButton[][] btnGrid = new JButton[5][5];
  	
	//Numbers1-9
	for(int i=0;i<3;i++)
  		//if(i==0){offset = 7;}
  		for(int j=0;j<3;j++)
  		{
  			if(i==0)
  			{
  				offset=7;
  			}
  			else if(i==1)
  			{
  				offset=4;
  			}
  			else if(i==2)
  			{
  				offset=1;
  			}
  			btnGrid[i][j] = new JButton();
  			btnGrid[i][j].setText(String.valueOf(j+offset));
  			btnGrid[i][j].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JButton temp = (JButton)arg0.getSource();
					
					if(clearInput)
					{
						//String lastChar = Input.getText().substring(Input.getText().length() - 1);
						//System.out.println(Input.getText().charAt(Input.getText().length() - 1));
						int ascii = (int)Input.getText().charAt(Input.getText().length() - 1);
						boolean asciiTest = (ascii>=48 && ascii<=57);
						if(asciiTest)
						{	
							Input.setText(temp.getText());
							clearInput = false;
						}
						else
						{
							Input.setText(Input.getText() + temp.getText());
							return;
						}
						
					}
					else
					{
						Input.setText(Input.getText() + temp.getText());
					}
				}
  				
  			});
  			
  		}
  	  	
  	//0 and +,-,.,=  	
  	btnGrid[3][0] = new JButton();
  	btnGrid[3][1] = new JButton();
  	btnGrid[3][2] = new JButton();
  	btnGrid[3][0].setText(String.valueOf(0));
  	btnGrid[3][1].setText(".");
  	btnGrid[3][2].setText("=");
  	btnGrid[3][2].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			expression = Input.getText();
			String finalOutput = calculator.compute(expression,inputType);
			Input.setText(finalOutput);
			clearInput = true;
		}
  		
  	});
  	btnGrid[3][0].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)arg0.getSource();
			Input.setText(Input.getText() + temp.getText());
		}
  		
  		
  	});
  	btnGrid[3][1].addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)arg0.getSource();
			if(clearInput)
			{
				int ascii = (int)Input.getText().charAt(Input.getText().length() - 1);
				boolean asciiTest = (ascii>=48 && ascii<=57);
				if(asciiTest)
				{	
					Input.setText(temp.getText());
					clearInput = false;
				}
				else
				{
					Input.setText(Input.getText() + temp.getText());
					return;
				}
			}
			else
			{
				Input.setText(Input.getText() + temp.getText());
			}
		}
  		
  	});
  	

  	btnGrid[0][3] = new JButton();
  	btnGrid[1][3] = new JButton();
  	btnGrid[2][3] = new JButton();
  	btnGrid[3][3] = new JButton();
  	btnGrid[0][3].setText("+");
  	btnGrid[1][3].setText("-");
  	btnGrid[2][3].setText("*");
  	btnGrid[3][3].setText("/");
  	for(int m=0;m<4;m++)
  	{
  		btnGrid[m][3].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton temp = (JButton)e.getSource();
				int lenInput  = Input.getText().length() - 1;
				String lastChar = Input.getText().substring(lenInput,lenInput + 1);
				System.out.println(lastChar);
				//System.out.println(lastChar=="+");
				boolean test = ((lastChar.equals("+")) || (lastChar.equals("-")) || (lastChar.equals("*")) || (lastChar.equals("/")) || (lastChar.equals("%")) || (lastChar.equals("^")) || (lastChar.equals("^2")) );
				System.out.println(test);
				if(test)
				{
					String tempText = Input.getText().replace(lastChar,temp.getText());
					System.out.println(tempText);
					Input.setText(tempText);
				}
				else
				{
					Input.setText(Input.getText() + temp.getText());
				}
			}
  			
  		});
  	}
  	//Adding btnGrid to digitpanel
  	for(int m=0;m<4;m++)
  	{
  		for(int n=0;n<4;n++)
  		{
  			digitPanel.add(btnGrid[m][n]);
  		}
  	}
  	
  	digitPanel.setVisible(true);
  	getContentPane().add(digitPanel,BorderLayout.EAST);
  	getContentPane().add(staticPanel,BorderLayout.EAST);
  	getContentPane().add(tabbedPane,BorderLayout.WEST);
  	
  	getContentPane().setVisible(true);
  	getContentPane().setLayout(groupLayout);
  	this.setSize(1105,767);
  	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
    
  public void clear() {
  }
}
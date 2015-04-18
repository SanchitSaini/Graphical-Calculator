package Calculator.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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



public class GUI extends JFrame{

  private Calculator calculator;

    public CheckAndCorrectUI myCheckAndCorrectUI;
    public MemoryBasedFunctionsUI myMemoryFunctionsUI;
    public NumbersUI myNumbersUI;
    public FunctionsUI myFunctionsUI;
    public PlotUI myPlotUI;
    public Calculator myCalculator;
    private JTextField Input;

  public GUI() {
  	int count = 9;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Double screenWidth = screenSize.getWidth()/2;
    Double screenHeight = screenSize.getHeight()*2/3;
  	Input = new JTextField();
  	Input.setColumns(10);
  	
  	
  	JPanel digitPanel = new JPanel(new GridLayout(4,3));
  	digitPanel.setMinimumSize(new Dimension(50,50));
  	digitPanel.setPreferredSize(new Dimension(50,50));
  	digitPanel.setSize(new Dimension(50,50));
  	digitPanel.setLocation(20,10);
  	
  	GroupLayout groupLayout = new GroupLayout(getContentPane());
  	groupLayout.setHorizontalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(32)
  				.addComponent(Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
  				.addContainerGap(328, Short.MAX_VALUE))
  			.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
  				.addGap(334)
  				.addComponent(digitPanel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
  				.addGap(26))
  	);
  	groupLayout.setVerticalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(27)
  				.addComponent(Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
  				.addGap(99)
  				.addComponent(digitPanel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
  				.addContainerGap(127, Short.MAX_VALUE))
  	);
  	
//  	GroupLayout gl_tabPanel = new GroupLayout(tabPanel);
//  	gl_tabPanel.setHorizontalGroup(
//  		gl_tabPanel.createParallelGroup(Alignment.LEADING)
//  			.addGap(0, 188, Short.MAX_VALUE)
//  	);
//  	gl_tabPanel.setVerticalGroup(
//  		gl_tabPanel.createParallelGroup(Alignment.LEADING)
//  			.addGap(0, 201, Short.MAX_VALUE)
//  	);
//  	//tabPanel.setLayout(gl_tabPanel);
  	//digitPanel.add(btnGrid);
  	
  	GroupLayout gl_digitPanel = new GroupLayout(digitPanel);
  	gl_digitPanel.setHorizontalGroup(
  		gl_digitPanel.createParallelGroup(Alignment.TRAILING)
  			.addGap(0, 129, Short.MAX_VALUE)
  	);
  	
	gl_digitPanel.setVerticalGroup(
	  		gl_digitPanel.createParallelGroup(Alignment.TRAILING)
	  			.addGap(0, 115, Short.MAX_VALUE)
	  	);
  	
  		
  	int offset = 0;
	JButton[][] btnGrid = new JButton[4][3];
  	for(int i=0;i<3;i++)
  		//if(i==0){offset = 7;}
  		for(int j=0;j<3;j++)
  		{
  			if(i==0){offset=7;}
  			if(i==1){offset=4;}
  			if(i==2){offset=1;}
  			btnGrid[i][j] = new JButton();
  			btnGrid[i][j].setText(String.valueOf(j+offset));
  			btnGrid[i][j].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JButton temp = (JButton)arg0.getSource();
					Input.setText(Input.getText() + temp.getText());
				}
  				
  			});
  			digitPanel.add(btnGrid[i][j]);
  			
  		}
  	
  	btnGrid[3][0] = new JButton();
  	btnGrid[3][1] = new JButton();
  	btnGrid[3][2] = new JButton();
  	btnGrid[3][0].setText(String.valueOf(0));
  	btnGrid[3][1].setText(".");
  	btnGrid[3][2].setText("=");
  	digitPanel.add(btnGrid[3][0]);
  	digitPanel.add(btnGrid[3][1]);
  	digitPanel.add(btnGrid[3][2]);
  	digitPanel.setVisible(true);
  	
  	JTabbedPane tabbedPane = new JTabbedPane();
  	tabbedPane.setBackground(Color.GREEN);
  	
  	JPanel panel1 = new JPanel(new GridLayout(4,3));
  	panel1.setMinimumSize(new Dimension(100,100));
  	panel1.setPreferredSize(new Dimension(100,100));
  	panel1.setSize(new Dimension(50, 50));
  	panel1.setLocation(60,70);
  	panel1.setVisible(true);
  	
	
  	JPanel panel2 = new JPanel(new GridLayout(4,3));
  	panel2.setMinimumSize(new Dimension(50,50));
  	panel2.setPreferredSize(new Dimension(50,50));
  	panel2.setSize(new Dimension(50,50));
  	panel2.setLocation(60,70);
  	panel2.setVisible(true);
  	
  	JPanel panel3 = new JPanel(new GridLayout(4,3));
  	panel3.setMinimumSize(new Dimension(50,50));
  	panel3.setPreferredSize(new Dimension(50,50));
  	panel3.setSize(new Dimension(50,50));
  	panel3.setLocation(60,70);
  	panel3.setVisible(true);
  	
  	tabbedPane.addTab("Tab1",panel1);
  	tabbedPane.addTab("Tab2",panel2);
  	tabbedPane.addTab("Tab3",panel3);
  	
  	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
  	//tabbedPane.setMinimumSize(new Dimension(75,75));
  	//tabbedPane.setPreferredSize(new Dimension(75,75));
  	tabbedPane.setSize(60,60);
  	tabbedPane.setLocation(new Point(70,70));
  	
  	getContentPane().add(digitPanel,BorderLayout.WEST);
  	//tabbedPane.setLayout(new );
  	getContentPane().add(tabbedPane,BorderLayout.WEST);
  	this.setSize(screenWidth.intValue(),screenHeight.intValue());
  	getContentPane().setVisible(true);
  	getContentPane().setLayout(groupLayout);
  }

  public void clear() {
  }
}
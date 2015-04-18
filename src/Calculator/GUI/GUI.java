package Calculator.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;

import Calculator.Calculator;



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
    Double screenWidth = screenSize.getWidth()/3;
    Double screenHeight = screenSize.getHeight()/2;
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
  				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
  					.addComponent(Input, Alignment.LEADING)
  					.addComponent(digitPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
  				.addContainerGap(95, Short.MAX_VALUE))
  	);
  	groupLayout.setVerticalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(27)
  				.addComponent(Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
  				.addGap(99)
  				.addComponent(digitPanel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
  				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
  	);
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
  	//getContentPane().setSize(new Dimension(300,300));
  	//digitPanel.setLayout(gl_digitPanel);
  	getContentPane().add(digitPanel,BorderLayout.CENTER);
  	this.setSize(screenWidth.intValue(),screenHeight.intValue());
  	
  	getContentPane().setVisible(true);
  	getContentPane().setLayout(groupLayout);
  }

  public void clear() {
  }
}
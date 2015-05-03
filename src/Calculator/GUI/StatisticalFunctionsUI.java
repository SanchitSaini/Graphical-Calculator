package Calculator.GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import Calculator.Calculator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticalFunctionsUI extends JPanel {

  
	private static final long serialVersionUID = 1L;

public StatisticalFunctionsUI(final Calculator calculator,final JTextField input) {
  	
  	JButton btnMean = new JButton("Mean");
  	btnMean.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String mean = calculator.computeMean();
			input.setText(mean);
		}
  		
  	});
  	JButton btnMedian = new JButton("Median");
  	btnMedian.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String median = calculator.computeMedian();
			input.setText(median);
		}
  		
  	});
  	
  	JButton btnMode = new JButton("Mode");
  	btnMode.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			String mode = calculator.computeMode();
			input.setText(mode);
  		}
  	});
  	GroupLayout groupLayout = new GroupLayout(this);
  	groupLayout.setHorizontalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(22)
  				.addComponent(btnMean)
  				.addGap(40)
  				.addComponent(btnMedian)
  				.addGap(45)
  				.addComponent(btnMode)
  				.addContainerGap(62, Short.MAX_VALUE))
  	);
  	groupLayout.setVerticalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(36)
  				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  					.addComponent(btnMedian)
  					.addComponent(btnMode)
  					.addComponent(btnMean))
  				.addContainerGap(189, Short.MAX_VALUE))
  	);
  	setLayout(groupLayout);
  }

}
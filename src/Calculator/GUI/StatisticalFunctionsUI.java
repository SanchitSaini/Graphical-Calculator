package Calculator.GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticalFunctionsUI extends JPanel {

  public StatisticalFunctionsUI() {
  	
  	JButton btnMean = new JButton("Mean");
  	
  	JButton btnMedian = new JButton("Median");
  	
  	JButton btnMode = new JButton("Mode");
  	btnMode.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
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
package Calculator.GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MemoryBasedFunctionsUI  extends JPanel{

  public MemoryBasedFunctionsUI() 
  {
  	
  	JButton btnM = new JButton("M+");
  	
  	JButton btnM_1 = new JButton("M-");
  	
  	JButton btnMr = new JButton("MR");
  	
  	JButton btnMs = new JButton("MS");
  	
  	JButton btnMc = new JButton("MC");
  	GroupLayout groupLayout = new GroupLayout(this);
  	groupLayout.setHorizontalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addContainerGap()
  				.addComponent(btnM)
  				.addPreferredGap(ComponentPlacement.UNRELATED)
  				.addComponent(btnM_1)
  				.addPreferredGap(ComponentPlacement.RELATED)
  				.addComponent(btnMr)
  				.addPreferredGap(ComponentPlacement.UNRELATED)
  				.addComponent(btnMs)
  				.addPreferredGap(ComponentPlacement.UNRELATED)
  				.addComponent(btnMc)
  				.addContainerGap(36, Short.MAX_VALUE))
  	);
  	groupLayout.setVerticalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(15)
  				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  					.addComponent(btnM)
  					.addComponent(btnMr)
  					.addComponent(btnMs)
  					.addComponent(btnMc)
  					.addComponent(btnM_1))
  				.addContainerGap(192, Short.MAX_VALUE))
  	);
  	setLayout(groupLayout);
	  
  }
}
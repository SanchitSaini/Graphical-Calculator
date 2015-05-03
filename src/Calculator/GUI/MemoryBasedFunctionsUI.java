package Calculator.GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Calculator.Calculator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemoryBasedFunctionsUI  extends JPanel{

  
	private static final long serialVersionUID = 1L;

public MemoryBasedFunctionsUI(Calculator calculator,final JTextField input) 
  {
  	
  	JButton btnM = new JButton("M+");
  	btnM.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			input.setText(input.getText() + "M+");
  		}
  	});
  	
  	JButton btnM_1 = new JButton("M-");
  	btnM_1.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "M-");
  		}
  	});
  	
  	
  	JButton btnMr = new JButton("MR");
  	btnMr.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "MR");
  		}
  	});
  	
  	
  	JButton btnMs = new JButton("MS");
  	btnMs.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "MS(");
  		}
  	});
  	
  	
  	JButton btnMc = new JButton("MC");
  	btnMc.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "MC");
  		}
  	});
  	
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
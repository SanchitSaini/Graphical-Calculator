package Calculator.GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrigonometricFunctionsUI extends JPanel{

	private static final long serialVersionUID = 1L;

public TrigonometricFunctionsUI(final JTextField input) {
  	
  	JButton btnSin = new JButton("cos");
  	btnSin.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent arg0) {
  			input.setText(input.getText() + "cos(");
  		}
  	});
  	
  	JButton button = new JButton("sin");
  	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			input.setText(input.getText() + "sin(");
		}
  		
  	});
  	
  	JButton btnTan = new JButton("tan");
  	btnTan.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "tan(");
  		}
  	});
  	
  	JButton btnCosecant = new JButton("cosec");
  	btnCosecant.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "cosec(");
  		}
  	});
  	
  	JButton btnSec = new JButton("sec");
  	btnSec.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "sec(");
  		}
  	});
  	
  	JButton btnCot = new JButton("cot");
  	btnCot.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "cot(");
  		}
  	});
  	
  	JButton btnSin_1 = new JButton("asin");
  	btnSin_1.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "asin(");
  		}
  	});
  	
  	JButton btnCos = new JButton("acos");
  	btnCos.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "acos(");
  		}
  	});
  	
  	JButton btnTan_1 = new JButton("atan");
  	btnTan_1.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "atan(");
  		}
  	});
  	
  	JButton btnCosec = new JButton("acosec");
  	btnCosec.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "acosec(");
  		}
  	});
  	
  	JButton btnSec_1 = new JButton("asec");
  	btnSec_1.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "asec(");
  		}
  	});
  	
  	JButton btnCot_1 = new JButton("acot");
  	btnCot_1.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent e) {
  			input.setText(input.getText() + "acot(");
  		}
  	});
  	GroupLayout groupLayout = new GroupLayout(this);
  	groupLayout.setHorizontalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addContainerGap()
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
  						.addComponent(btnCosecant, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
  					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
  						.addComponent(btnCosec, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  						.addComponent(btnSin_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
  				.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
  					.addComponent(btnSec_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  					.addComponent(btnSin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  					.addComponent(btnSec, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
  					.addComponent(btnCos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
  				.addGap(26)
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
  					.addComponent(btnTan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  					.addComponent(btnCot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  					.addComponent(btnCot_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  					.addComponent(btnTan_1, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
  				.addGap(53))
  	);
  	groupLayout.setVerticalGroup(
  		groupLayout.createParallelGroup(Alignment.LEADING)
  			.addGroup(groupLayout.createSequentialGroup()
  				.addGap(11)
  				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  					.addComponent(btnTan)
  					.addComponent(button)
  					.addComponent(btnSin))
  				.addGap(18)
  				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  					.addComponent(btnCot)
  					.addComponent(btnSec)
  					.addComponent(btnCosecant))
  				.addGap(18)
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  					.addComponent(btnTan_1)
  					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  						.addComponent(btnSin_1)
  						.addComponent(btnCos)))
  				.addGap(18)
  				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
  					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
  						.addComponent(btnCosec)
  						.addComponent(btnSec_1))
  					.addComponent(btnCot_1)))
  	);
  	setLayout(groupLayout);
  }

}
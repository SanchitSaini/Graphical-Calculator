package Calculator.GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MiscFunctionsUI extends JPanel{

	public MiscFunctionsUI(final JTextField input) {
		
		JButton btnNcr = new JButton("nCr");
		btnNcr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "C");
			}
		});
		
		JButton btnNpr = new JButton("nPr");
		btnNpr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "P");
			}
		});
		
		JButton button = new JButton("%");
		
		JButton btnLog = new JButton("log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "log(");
			}
		});
		
		
		
		JButton btnLcm = new JButton("LCM");
		btnLcm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "LCM(");
			}
		});
		
		JButton btnFloor = new JButton("Floor");
		btnFloor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "Floor(");
			}
		});
		
		JButton btnN = new JButton("n!");
		
		
		JButton btnEx = new JButton("e^x");
		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "e^");
			}
		});
		
		JButton btnCeiling = new JButton("Ceiling");
		btnCeiling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText(input.getText() + "Ceiling(");
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNcr)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNpr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLcm, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEx, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnFloor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCeiling, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNcr)
						.addComponent(btnNpr)
						.addComponent(button))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLog)
						.addComponent(btnLcm)
						.addComponent(btnFloor))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnN)
						.addComponent(btnEx)
						.addComponent(btnCeiling))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

}

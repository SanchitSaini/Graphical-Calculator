package Calculator.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import net.objecthunter.exp4j.ExpressionBuilder;

import java.awt.geom.Point2D;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Vector;


public class GraphPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double minX = -10;
	private double maxX = 10;
	private double minY = -10;
	private double maxY = 10;
	private int xAxis = 0;
	private int yAxis = 0;
	private String equation;
	private double xInterval = 0;
	private double yInterval = 0;
//	/**
//	 * Create the panel.
//	 */
	public GraphPanel() {
		//setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//super();

		//System.out.println("Ekam");

		//System.out.println("Ekam");

		
	}
	public void setEquation(String equation)
	{
		this.equation = equation;
	}

	 public  int UnitToPixelX(double x) {
			double pixelsPerUnit = this.getWidth() / (maxX - minX);
			double pos = (x - minX) * pixelsPerUnit;
			//System.out.print((int) pos + ",");
			return (int) pos;
		}
	  public  int UnitToPixelY(double y) {
			double pixelsPerUnit = this.getHeight() / (maxY - minY);
			double pos = (y - minY) * pixelsPerUnit;
			pos = -pos + this.getHeight();
			//System.out.println((int) pos);
			return (int) pos;
		}
	  
	  @Override
	  public  void paintComponent(Graphics g) {
			
		  		super.paintComponent(g);
		  		DecimalFormat df = new DecimalFormat("#.###");
		  		yAxis = UnitToPixelX(0);
			    xAxis = UnitToPixelY(0);
	 			//System.out.println("hello");
	 			
	 			//count = count + 1;
	 			//System.out.println(String.valueOf(count));
	 			//setPreferredSize(new Dimension(400,400));
	 			Graphics2D g2 = (Graphics2D)g;
	 			//super.paintComponent(g);
	 			Vector<GeneralPath> polylines = new Vector<GeneralPath>();
	 			GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, this.getWidth());
	 			polylines.add(new GeneralPath(GeneralPath.WIND_EVEN_ODD));
	 			
	 			//g.setColor(Color.WHITE);
	 			//g2.fillRect(getX(), getY(), getWidth(), getHeight());
	 			setBackground(Color.WHITE);
	 			g.setColor(Color.black);
	 			g.drawLine(0, xAxis, this.getWidth(), xAxis);
	 			g.drawLine(yAxis, 0, yAxis, this.getHeight());
	 			//g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
	 			//g2.draw(polylines.get(0));
	 			g2.setColor(Color.black);
	 			g2.drawString("0", yAxis + 2, xAxis - 1);
	 			g2.drawString(df.format(minX), 5, xAxis - 1);
	 			g2.drawString(df.format(maxX), this.getWidth()
	 					- df.format(maxX).length() * 7, xAxis - 1);
	 			g2.drawString(df.format(minY), yAxis + 2, this.getHeight() - 5);
	 			g2.drawString(df.format(maxY), yAxis + 2, 15);
	 			
				g2.setColor(Color.LIGHT_GRAY);
				xInterval = Math.pow(10, String.valueOf((int) (maxX - minX) / 4).length() - 1);
				yInterval = Math.pow(10, String.valueOf((int) (maxY - minY) / 4).length() - 1);
				
				xInterval = yInterval = Math.min(xInterval, yInterval);

				for (double i = 0 + xInterval; i <= maxX; i += xInterval) {
					g2.drawLine(UnitToPixelX(i), 0, UnitToPixelX(i), this.getHeight());
				}
				for (double i = 0 - xInterval; i >= minX; i -= xInterval) {
					g2.drawLine(UnitToPixelX(i), 0, UnitToPixelX(i), this.getHeight());
				}
				for (double i = 0 + yInterval; i <= maxY; i += yInterval) {
					g2.drawLine(0, UnitToPixelY(i), this.getWidth(), UnitToPixelY(i));
				}
				for (double i = 0 - yInterval; i >= minY; i -= yInterval) {
					g2.drawLine(0, UnitToPixelY(i), this.getWidth(), UnitToPixelY(i));
				}
	 			
	 			if(equation==null)
	 			{
	 				return;
	 			}
	 			else{
	 				g2.setColor(Color.red);
		 			double eqPrev;
		 			Double eqVal;
		 			boolean firstPoint = true;
		 			double interval,intervalFormula;
		 			ExpressionBuilder expBuilder = new ExpressionBuilder(equation);
					expBuilder.variable("x");
					net.objecthunter.exp4j.Expression equation = expBuilder.build();
					eqPrev=equation.setVariable("x", minX).evaluate();
					
					polyline.moveTo(UnitToPixelX(minX), UnitToPixelY(eqPrev));
					polylines.set(0, polyline);
					interval = intervalFormula = (maxX - minX) / (this.getWidth());
					int loop = 0;
					double[] a = new double[2];
					for (double x = minX;x<100; x += interval) {
						
						eqVal = equation.setVariable("x", x).evaluate();
						int pixValX = UnitToPixelX(x);
	
						if (eqVal.isNaN() || eqVal.isInfinite()) {
							firstPoint = true;
						} else if (firstPoint) {
							polyline.moveTo(pixValX, UnitToPixelY(eqVal));
							polylines.set(0, polyline);
							firstPoint = false;
						} else {
							polyline.lineTo(pixValX, UnitToPixelY(eqVal));
							polylines.set(0, polyline);
						}
	
					}
					
					g2.draw(polylines.get(0));
	 			}

	  }
	  
	  @Override
	  public void setPreferredSize(Dimension d)
	  {
		  //d = new Dimension(700,700);
		  super.setPreferredSize(d);
	  }
}

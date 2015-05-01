package Calculator.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;

import javax.swing.JPanel;
import java.awt.geom.Point2D;
public class GraphPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double minX = -5;
	private double maxX = 5;
	private double minY = -5;
	private double maxY = 5;
	private int xAxis = 0;
	private int yAxis = 0;
	
//	/**
//	 * Create the panel.
//	 */
	public GraphPanel() {
		//setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//super();
		System.out.println("Ekam");
		
	}

	 public  int UnitToPixelX(double x) {
			double pixelsPerUnit = this.getWidth() / (maxX - minX);
			double pos = (x - minX) * pixelsPerUnit;
			return (int) pos;
		}
	  public  int UnitToPixelY(double y) {
			double pixelsPerUnit = this.getHeight() / (maxY - minY);
			double pos = (y - minY) * pixelsPerUnit;
			pos = -pos + this.getHeight();
			return (int) pos;
		}
	  
	  @Override
	  public  void paintComponent(Graphics g) {
			
		  		super.paintComponent(g);
				yAxis = UnitToPixelX(0);
			    xAxis = UnitToPixelY(0);
	 			System.out.println("hello");
	 			//count = count + 1;
	 			//System.out.println(String.valueOf(count));
	 			//setPreferredSize(new Dimension(400,400));
	 			//Graphics2D g2 = (Graphics2D)g;
	 			//super.paintComponent(g);
	 			
	 			//g.setColor(Color.WHITE);
	 			//g2.fillRect(getX(), getY(), getWidth(), getHeight());
	 			setBackground(Color.WHITE);
	 			g.setColor(Color.red);
	 			Polygon p = new Polygon();
	 			Point2D.Double pt = new Point2D.Double(UnitToPixelX(1),UnitToPixelY(1));
	 			Point2D.Double pt1 = new Point2D.Double(UnitToPixelX(3),UnitToPixelY(3));
	 			p.addPoint(UnitToPixelX(1),UnitToPixelY(1));
	 			p.addPoint(UnitToPixelX(3),UnitToPixelY(3));
	 			System.out.println(xAxis);
	 			System.out.println(yAxis);
	 			g.drawLine(0, xAxis, this.getWidth(), xAxis);
	 			g.drawLine(yAxis, 0, yAxis, this.getHeight());
	 			g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
	 			
	  }
	  
	  @Override
	  public void setPreferredSize(Dimension d)
	  {
		  //d = new Dimension(700,700);
		  super.setPreferredSize(d);
	  }
}
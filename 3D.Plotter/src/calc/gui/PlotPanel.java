package calc.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import calc.parser.ExpTree;
import calc.parser.Expression;
import calc.parser.VarDataBase;

@SuppressWarnings("serial")
public class PlotPanel extends JPanel {
	
	public static OptionDB opdb;
	private ArrayList<Double> yValues = new ArrayList<Double>();
	private static HashMap<Double, Color> color;
	private static ExpTree exptree;
	private PlotPanelTools ppt;
	private static double xStep;
	private static double xMax;
	private  static double Ymax;
	private  static double Ymin;
	private playThread playThread;
	private static Color GRAPH_COLOR = Color.green;
    private static  Color GRAPH_POINT_COLOR = Color.gray;
    private static final Stroke GRAPH_STROKE = new BasicStroke(8f);
    private static final int GRAPH_POINT_WIDTH = 11;
    private static int Y_GRID_LINES = 20;
    private static int X_GRID_LINES = 20;
    private Integer pix1;
    public void setPix1(Integer pix1) {
		this.pix1 = pix1;
	}


	public void setPix2(Integer pix2) {
		this.pix2 = pix2;
	}




	private Integer pix2;
    
	public PlotPanel() {
		
		setCursor (Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

		setMySize();
		Border inBorders = BorderFactory.createTitledBorder("Graph");
		Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outBorder, inBorders));
		
		
	}


	public static void setOpdb(OptionDB op) {
		opdb = op;
		VarDataBase.setT(Double.parseDouble(opdb.gettMin()));
		  xStep = Double.parseDouble(opdb.getxStep());
		  xMax = Double.parseDouble(opdb.getxMax());
		  Ymax = Double.parseDouble(opdb.getyMax());
		  Ymin = Double.parseDouble(opdb.getyMin());
		  color = opdb.colors;
	}



	
	private static final int BORDER_GAP = 30;
	   public static int getBorderGap() {
		return BORDER_GAP;
	}
	
	   protected void drawGraph() {
		   exptree = new Expression(opdb.getExpression()).convert();
		   /////iterate x values and make yValues
		   yValues.clear();
		   for(double x = Double.parseDouble(opdb.getxMin());
				   x<=xMax;
				   x+=xStep)
		   {
			   VarDataBase.setX(x);
			   yValues.add( exptree.eVal());
		   }
	   
	   ///////////////////Y_HATCH_CNT set////////////////
	   Graphics2D g2 = (Graphics2D) getGraphics();
	   ////setting background
	// no it wasn't good !
		  Stroke firstStroke = g2.getStroke();

	   //Make it smooth !
	  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	//create zooms line
	  g2.setStroke(new BasicStroke(10f));
	  g2.setColor(Color.pink);
	  if(pix1!=null)
		 g2.drawLine(pix1, BORDER_GAP, pix1, this.getHeight()-BORDER_GAP);
		if(pix2!=null)
g2.drawLine(pix2, BORDER_GAP, pix2, this.getHeight()-BORDER_GAP);

	  g2.setStroke(firstStroke);
	  g2.setColor(Color.black);

	   /////setting xScale And YsCale |-----| //////
	  double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (yValues.size() - 1);
	  double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (Ymax - Ymin);
	 
	///Creating graphpoints
	  List<Point> GP = new ArrayList<Point>();
	  for (int i = 0; i < yValues.size(); i++) {
	     int x1 = (int) (i * xScale + BORDER_GAP);
	     int y1 = (int) ((Ymax - yValues.get(i)) * yScale + BORDER_GAP);
	     GP.add(new Point(x1, y1));
	  }
	  
	  // create x and y axes 
	  g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
	  g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);
	
	  // create grid lines for y axis. 
	  for (int i = 0; i < Y_GRID_LINES; i++) {
	     int x0 = BORDER_GAP;
	     int x1 = getWidth()- BORDER_GAP;
	     int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_GRID_LINES + BORDER_GAP);
	     int y1 = y0;
	     g2.drawLine(x0, y0, x1, y1);
	  }
	  
	  // create grid lines for x axis. 
	  for (int i = 0; i < X_GRID_LINES - 1; i++) {
	         int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (X_GRID_LINES - 1) + BORDER_GAP;
	         int x1 = x0;
	         int y0 = getHeight() - BORDER_GAP;
	         int y1 = BORDER_GAP;
	         g2.drawLine(x0, y0, x1, y1);
	      }
	
	  g2.setColor(GRAPH_COLOR);
	  g2.setStroke(GRAPH_STROKE);
	  for (int i = 0; i < GP.size() - 1; i++) {
	     int x1 = GP.get(i).x;
	     int y1 = GP.get(i).y;
	     int x2 = GP.get(i + 1).x;
	     int y2 = GP.get(i + 1).y;
	     g2.drawLine(x1, y1, x2, y2);         
	  }
	
	  
	  g2.setStroke(firstStroke);      
	  g2.setColor(GRAPH_POINT_COLOR);
	  for (int i = 0; i < GP.size(); i++) {
	     int x = GP.get(i).x - GRAPH_POINT_WIDTH / 2;
	     int y = GP.get(i).y - GRAPH_POINT_WIDTH / 2;;
	     int ovalW = GRAPH_POINT_WIDTH;
	     int ovalH = GRAPH_POINT_WIDTH;
	     g2.fillOval(x, y, ovalW, ovalH);
	  }
	  
	  paintComponents(g2);
	}
	

		
	

	public void setMySize() {
		Dimension dim = getPreferredSize();
		dim.height = PlotFrameHeight.height - 220;
		setPreferredSize(dim);		
	}
	
	public void playSketchGraph() throws Exception{
		playThread = new playThread();
		playThread.start();

	}
	public void pauseSketchGraph(){
		playThread.interrupt();
	}

	/////////////Sketch Graph/////////////////
	public void sketchGraphInAllColor() {
		 Graphics2D g2 = (Graphics2D) getGraphics();
		 super.paintComponent(g2);
		Iterator<Double> iterator = color.keySet().iterator();
		while (iterator.hasNext()) {
			double c = iterator.next();
			GRAPH_COLOR = color.get(c);
			VarDataBase.setC(c); 
			drawGraph();
		}
	}


	public void setPpt(PlotPanelTools ppt) {
		this.ppt = ppt;
	}
	
	class playThread extends Thread {
		@Override
		public void run() {
			double tStep = Double.parseDouble(opdb.gettStep());
	    	int tStepTime = Integer.parseInt(opdb.gettStepTime());
	    	
	    		try {
	    			for(double t = VarDataBase.getT();
	    	    			t<=Double.parseDouble(opdb.gettMax());
	    	    			t+=tStep
	    	    			){
	    	    	VarDataBase.setT(t);
					sleep(tStepTime);
					ppt.setTimeSliderVal(t);
					
					sketchGraphInAllColor();
	    	    	}
					ppt.setTimeSliderVal(-999);

				} catch (InterruptedException e) {
					///What should I DO ?!!!
				}
	    	
		}
	}

	public double getYmax() {
		return Double.parseDouble(opdb.getyMax());
	}


	public double getYmin() {
		return Double.parseDouble(opdb.getyMin());
	}


	public void drawlineToZoom(int currentXPix) {
		if(pix1==null){
			pix1 = new Integer(currentXPix);
			
		}else if(pix2==null){
			pix2= new Integer(currentXPix);
		}
		
	}
}



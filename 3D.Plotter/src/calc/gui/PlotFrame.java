package calc.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PlotFrame extends JFrame{
	   private static final int PREF_W = 650;
	   private static final int PREF_H = 800;
	   private PlotPanel plotpanel;
		public double currentXVal;
		public int currentXPix;

	   private PlotPanelTools plotpaneltools;
	   public static void setMaxX(int maxX) {
		PlotFrame.maxX = maxX;
	}
	public static void setMinX(int minX) {
		PlotFrame.minX = minX;
	}
		private static double maxX;
	   private static double minX;
	   private  static double minY;
	   private static double maxY;
		public Double x1Zoom;
		public Double x2Zoom;
		public PlotFrame()  {
	
	
		plotpanel = new PlotPanel();
		maxY = plotpanel.getYmax();
		minY = plotpanel.getYmin();
		minX = Double.parseDouble(PlotPanel.opdb.getxMin());
		maxX = Double.parseDouble(PlotPanel.opdb.getxMax());
		setTitle("Plot is Here !!");
		setLayout(new BorderLayout());
	    setVisible(true);
	    setSize(PREF_W,PREF_H);
	    
	    
	    try {
			plotpaneltools = new PlotPanelTools();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    //Passin' plot panel to plotpanel tools
	    plotpaneltools.setMyPlot(plotpanel);
	    
	

    add(plotpanel,BorderLayout.NORTH);
    plotpaneltools.setPlotframe(this);
	add(plotpaneltools,BorderLayout.SOUTH);
	plotpanel.setPpt(plotpaneltools);
	plotpanel.addMouseListener(new mouseClickedForZoom());
	plotpanel.addMouseMotionListener(new MouseMotionListener() {
	
	


	@Override
	public void mouseMoved(MouseEvent arg0) {
		wherIsMouse(arg0);
		
	}
	/////////////// Where is the mouse really ? :D//////////////
	private void wherIsMouse(MouseEvent arg0) {
		double YScale = (double)(maxY-minY)/(double)(plotpanel.getHeight() - 2*plotpanel.getBorderGap()) ;
		double yScaled = ((plotpanel.getHeight() - plotpanel.getBorderGap()
		- arg0.getY())*YScale)+minY;
		double XScale = (double)(maxX-minX)/(double)(plotpanel.getWidth() - 2*plotpanel.getBorderGap()) ;
		double XScaled = ((arg0.getX()-plotpanel.getBorderGap())*XScale)+minX;
		
        XScaled = (double) Math.round(XScaled*100)/100;
		yScaled = (double) Math.round(yScaled*100)/100;
		currentXPix = arg0.getX();
		currentXVal = XScaled;
		plotpaneltools.setMouseCurrent("Cursors position : X = "
				+XScaled +
				" & Y = "+yScaled );
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// no need :)
	}
});
	}	
	public void fitPlotPanelSize(){
		plotpanel.setMySize();
		
	}
	public class mouseClickedForZoom implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(x1Zoom==null){
				x1Zoom = new Double(currentXVal);
				plotpanel.drawlineToZoom(currentXPix);
				plotpanel.sketchGraphInAllColor();
				
				
				
			}else if(x2Zoom==null){
				x2Zoom = new Double(currentXVal);
				plotpanel.drawlineToZoom(currentXPix);
				plotpanel.sketchGraphInAllColor();

//				boolean wasItPlaying = plotpaneltools.pauseBtn.isEnabled()?true:false;
				
				plotpanel.pauseSketchGraph();
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to zoom in this range of x ?", "ZoomOption",dialogButton);
				if(dialogResult==0){
					
					OptionDB zoomopdb = new OptionDB();
					zoomopdb = plotpanel.opdb;
					if(Double.valueOf(x1Zoom)>Double.valueOf(x2Zoom))
					{
						Double temp = x1Zoom;
						x1Zoom = x2Zoom;
						x2Zoom = temp;
					}
					zoomopdb.setxMin(Double.valueOf(x1Zoom)+"");
					zoomopdb.setxMax(Double.valueOf(x2Zoom)+"");
	                PlotPanel.setOpdb(zoomopdb);
	            	x1Zoom = null;
					x2Zoom = null;

					plotpanel.setPix1(null);
					plotpanel.setPix2(null);
					try {
						plotpanel.playSketchGraph();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}	
				else{
					x1Zoom = null;
					x2Zoom = null;

					try {
						if(plotpaneltools.pauseBtn.isEnabled())
						plotpanel.playSketchGraph();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					plotpanel.setPix1(null);
					plotpanel.setPix2(null);
					plotpanel.sketchGraphInAllColor();

				}
				 
				
			}	
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
		
	}

		 
}

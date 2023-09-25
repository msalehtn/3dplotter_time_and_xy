package calc.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import calc.parser.VarDataBase;

public class PlotPanelTools extends JPanel{
	 JButton playBtn ;
	 JButton pauseBtn ;
	private JSlider timeSlider;
	private PlotFrame plotframe;
	private JLabel mouseCurStatus ;
	private PlotPanel myPlot;
	private double tmin;
	private double tmax;
	private double tstep;
	
	public PlotFrame getPlotframe() {
		return plotframe;
	}
	public void setPlotframe(PlotFrame plotframe) {
		this.plotframe = plotframe;
	}

	public void setMouseCurrent(String text){
		mouseCurStatus.setText(text);
	}
	public void setMyPlot(PlotPanel myPlot) {
		this.myPlot = myPlot;
	}
	public PlotPanelTools() throws IOException {
		
		Dimension dim = getPreferredSize();
		dim.height = (int) (200);
		setPreferredSize(dim);
		Border inBorders = BorderFactory.createTitledBorder("Plot Tools");
		Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outBorder, inBorders));
		/////////////////////Making components /////////
	    
	      playBtn = new JButton(" PLAY");
	      mouseCurStatus = new JLabel("Current Mouse Status : x=   ,y=  ");
	      pauseBtn = new JButton(" PAUSE");
	      timeSlider = new JSlider();
	     
	      ///////////Creating layouts//////////////////
	      GridBagLayout layout = new GridBagLayout();
	      setLayout(layout);
	      GridBagConstraints gbc = new GridBagConstraints();
	      gbc.fill = GridBagConstraints.NONE;
	      //////////// X = 0 ; Y = 0///////////////
	      gbc.weightx =2;
	      gbc.weighty = 2;
	      gbc.anchor = GridBagConstraints.LINE_END;
	      gbc.ipady = 20;
	      gbc.ipadx = 40;
	      gbc.gridx = 0;
	      gbc.gridy = 0;
	      
	      Image myImage = getToolkit().createImage("resources/play.png");
	      ImageIcon myIcon = new ImageIcon(myImage);
	      playBtn.setIcon(myIcon);
	      playBtn.setBorder(null);
	      playBtn.setSize(100, 100);
	      add(playBtn,gbc);
	      
	      //////////// X = 1 ; Y = 0///////////////
	      gbc.anchor = GridBagConstraints.CENTER;
	      gbc.ipady = 10;
	      gbc.ipadx = 60;
	      gbc.gridx = 1;
	      gbc.gridy = 0;
	      tmin = Double.parseDouble(myPlot.opdb.gettMin());
	      tmax = Double.parseDouble(myPlot.opdb.gettMax());
	   tstep = Double.parseDouble(myPlot.opdb.gettStep());
	   
	     int maxT = (int) ((tmax-tmin)/tstep);
	     timeSlider.setValue(0);
	      
	      timeSlider.setMaximum(maxT);
	      timeSlider.setMajorTickSpacing((int)(maxT/5));
	      timeSlider.setPaintTicks(true);

	      
	      Hashtable labelTable = new Hashtable();
	      labelTable.put( new Integer( 0 ), new JLabel(tmin+"") );
	      labelTable.put( new Integer( (int) (maxT/2)), new JLabel(((tmax+tmin)/2) + "") );
	      labelTable.put( new Integer(maxT ), new JLabel(tmax+"") );
	      timeSlider.setLabelTable( labelTable ); 
	      timeSlider.setPaintLabels(true);
	      add(timeSlider,gbc);
	      
	      
	      ////////////X = 2 ; Y = 0///////////////
	      gbc.anchor = GridBagConstraints.LINE_START;
	      gbc.ipady = 20;
	      gbc.ipadx = 40;
	      gbc.gridx = 2;
	      gbc.gridy = 0;
	      
	      myImage = getToolkit().createImage("resources/pause.png");
	      myIcon = new ImageIcon(myImage);
	      pauseBtn.setIcon(myIcon);
	      add(pauseBtn,gbc);
	      

	
	      //////////// X = 1 ; Y = 1///////////////
	      gbc.anchor = GridBagConstraints.CENTER;
	      gbc.ipady = 10;
	      gbc.gridx = 1;
	      gbc.gridy = 1;       
	      mouseCurStatus.setBorder(BorderFactory.createEtchedBorder());
	      mouseCurStatus.setFont(mouseCurStatus.getFont().deriveFont(18.0f));
	    
	      add(mouseCurStatus,gbc); 
	      ///////////Listeners /////////////////
	      timeSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
			ChangeTimeSlider cts = new ChangeTimeSlider();
			cts.run();
				
			}
		});
	      ///////PLAY listener////////////////
	      playBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					myPlot.playSketchGraph();
					timeSlider.setEnabled(false);
					pauseBtn.setEnabled(true);
					playBtn.setEnabled(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
	      
	      //////////end render listener///////////////
	      ///////pause listener////////////////
	      pauseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					myPlot.pauseSketchGraph();
					timeSlider.setEnabled(true);
					pauseBtn.setEnabled(false);
					playBtn.setEnabled(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
	      
	      //////////end render listener///////////////
	      
	      
	}
	public void setTimeSliderVal(double t) {
		if(t==-999){
			this.timeSlider.setValue(timeSlider.getMaximum());
			this.timeSlider.setEnabled(true);
			this.playBtn.setEnabled(true);
			this.pauseBtn.setEnabled(false);
		}else{
			t = t-tmin;
			t = t/tstep;
			this.timeSlider.setValue((int)t);
		}
		
	}
	public class ChangeTimeSlider extends Thread{
		@Override
		public void run() {
			double x = timeSlider.getValue()*tstep + tmin;
			VarDataBase.setT(x);
			System.out.println(" Time : "+ (double)Math.round(VarDataBase.getT()*100)/100);
			myPlot.sketchGraphInAllColor();
			super.run();
		}
	}
}

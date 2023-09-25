package calc.gui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Runner {

	public Runner() {

		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {


				PlotFrame x = new PlotFrame();
				PlotFrame.setDefaultLookAndFeelDecorated(true);

				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SwingUtilities.updateComponentTreeUI(x);
				x.addComponentListener(new cmplsner());
				x.addWindowStateListener(new WindowStateListener() {
					
					@Override
					public void windowStateChanged(WindowEvent arg0) {
						PlotFrame x = (PlotFrame) arg0.getComponent();
						PlotFrameHeight.height = x.getHeight();
						x.fitPlotPanelSize();							
					}
				});
			}
		});
		
		
		}	}
class cmplsner implements ComponentListener {

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		PlotFrame x = (PlotFrame) arg0.getComponent();
		PlotFrameHeight.height = x.getHeight();
		x.fitPlotPanelSize();		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {

		PlotFrame x = (PlotFrame) arg0.getComponent();
		PlotFrameHeight.height = x.getHeight();
		x.fitPlotPanelSize();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}
	
	
}
package calc.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
  
public class ColorIcon implements Icon  
{  
    private static int HEIGHT = 20;  
    private static int WIDTH = 20;  
  
    private Color color;  
  
    public ColorIcon(Color color)  
    {  
        this.color = color;  
    }  
  
    public int getIconHeight()  
    {  
        return HEIGHT;  
    }  
  
    public int getIconWidth()  
    {  
        return WIDTH;  
    }  
  
    public void paintIcon(Component c, Graphics g, int x, int y)  
    {  
        g.setColor(color);  
        g.fillRect(x, y, WIDTH - 1, HEIGHT - 1);  
  
        g.setColor(Color.black);  
        g.drawRect(x, y, WIDTH - 1, HEIGHT - 1);  
    }  
}
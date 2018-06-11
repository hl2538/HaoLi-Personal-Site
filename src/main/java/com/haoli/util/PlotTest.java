package com.haoli.util;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
 
//实现一个礼花绽放的界面
import javax.swing.*;

import com.haoli.controller.SocketController;
 
public class PlotTest extends JPanel{
	
	double dx;
	double dy;
	
	
	public static void main(String[] args){
		PlotTest pt = new PlotTest(1d,2d);
		Frame drawPoint2D = new Frame("Draw Point2D Example"); 
		drawPoint2D.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
			System.exit(0); 
			      } 
			    }); 
		drawPoint2D.setSize(350,250);
		drawPoint2D.add(pt); 
		drawPoint2D.setVisible(true);

		pt.repaint();
	} 
	
	public PlotTest(double dx , double dy){
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public void paint(Graphics g) { 
	    g.setColor(Color.blue); 
	    Graphics2D G2D = (Graphics2D)g; 
	    G2D.setStroke(new BasicStroke(3.0f)); 
	    Point2D P2D = new Point2D.Double(dx, dy); 
	    Line2D L2D = new Line2D.Float(P2D, P2D); 
	    G2D.draw(L2D); 
	  } 
	
 
}
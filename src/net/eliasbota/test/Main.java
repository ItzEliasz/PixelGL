/**
 * 
 * This class is a demonstration of using PixelGL. You can do whatever you want with this
 * @author Bota Elias
 * 
 */

package net.eliasbota.test;

import java.awt.Canvas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import net.eliasbota.pgl.PGL;
import net.eliasbota.pgl.PixelSurface;
import net.eliasbota.pgl.Point;
import net.eliasbota.pgl.memory.Memory;
import net.eliasbota.pgl.Pixel;

public class Main {
	
	Canvas canvas;
	
	boolean working = true;
	
	List<PixelSurface> surfaces = new ArrayList<PixelSurface>();
	
	public Main() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		canvas = new Canvas();
		canvas.setSize(800, 600);
		frame.add(canvas);
		frame.pack();
		
		frame.setVisible(true);
		
		PixelSurface.createSurface(800, 600);
		
		int pointer = 0;
		
		Point[] testPoints = new Point[1];
		testPoints[0] = new Point(10, 10, 50, 50);
		
		Memory.addPixelMemory(200, 200, 1);
		
		while(working) {
			    PGL.wireframeTriangle(10+pointer, 100, 20, -450, 70, 1, 1, 1);
			    PGL.wireframeParallelogram(70, 10+pointer, 20, -450, 80, 0, 0, 1);
			    PGL.wireframeRectangle(50, 50, 20, -450, 100, 50, 1, 1, 0);
			    PGL.fillRectangle(151, 50, 20, -450, 100, 50, 1, 1, 1);
			    PGL.polygon(testPoints, 1, 1, 0);
			    Memory.getPixelMemory(1).syncColor(1, 1, 1);
			    PGL.translate(200, 200, 1);
				PixelSurface.update();
			    render();
			    PixelSurface.cleanPixels();
			    Memory.getPixelMemory(1).cleanPixels();
			    pointer++;
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		    for(int i = 0; i < 800; i++) {
		    	for(int ii = 0; ii < 600; ii++) {
		    		Pixel pixel = PixelSurface.getPixels()[i][ii];
				if(pixel != null) {
			g.setColor(new Color(pixel.getR(), pixel.getG(), pixel.getB()));
			g.fillRect(pixel.getX(), pixel.getY(), 1, 1);
				}
			}
			}
		
		
		g.dispose();
		bs.show();
	}

}

/**
 * 
 *  Copyright (C) 2016 Bota Elias & Dennis van Giessen

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package net.eliasbota.pgl;

import net.eliasbota.pgl.memory.Memory;

public class PGL {
	
	public static void mapMemory(Pixel[][] data, int id) {
		Memory.getPixelMemory(id).setPixels(data);
	}
	
	public static void mapMemory(int sizeX, int sizeY, Pixel[][] data, int id) {
		Memory.getPixelMemory(id).setPixels(data);
		Memory.getPixelMemory(id).setSize(sizeX, sizeY);
	}
	
	public static void translate(int x, int y, int id) {
		for(Pixel[] pix : Memory.getPixelMemory(id).getPixels()) {
			for(Pixel pixel : pix) {
				PixelSurface.CoreFuncChangePixel(pixel.getX() + x, pixel.getY() + y, pixel.getR(), pixel.getG(), pixel.getB());
			}
		}
	}
	
	public static void wireframeSquare(int x, int y, int z, int zCamera, int size, int r, int g, int b) {
		if(size-z >= zCamera) {
		line(x, y, x, y - 1 + size-z, r, g, b);
		line(x, y, x + size-z, y, r, g, b);
		line(x + size-z, y, x + size-z, y-1 + size-z, r, g, b);
		line(x, y-1 + size-z, x + size-z, y + size-z-1, r, g, b);
		}
	}
	
	public static void polygon(Point[] points, int r, int g, int b) {
		for(Point point : points) {
			line(point.getMyX(), point.getMyY(), point.getTargetX(), point.getTargetY(), r, g, b);
		}
	}
	
	public static void fillSquare(int x, int y, int z, int zCamera, int size, int r, int g, int b) {
		if(z >= zCamera) {
		for(int i = x; i < x+size-z; i++) {
			for(int ii = y; ii < y+size-z; ii++) {
					if(ii > PixelSurface.getHeight() && i > PixelSurface.getWidth() || ii > PixelSurface.getHeight() || i > PixelSurface.getWidth() || ii < 0 && i < 0 || ii < 0 || i < 0 || ii > PixelSurface.getHeight() && i < 0 || ii < 0 && i > PixelSurface.getHeight() || ii > PixelSurface.getHeight() || i > PixelSurface.getWidth()) {
						
					} else {
					PixelSurface.CoreFuncChangePixel(i, ii, r, g, b);
					}
			}
		}
		}
	}
	
	public static void fillRectangle(int x, int y, int z, int zCamera, int sizeX, int sizeY, int r, int g, int b) {
		if(z >= zCamera) {
		for(int i = x; i < x+sizeX-z; i++) {
			for(int ii = y; ii < y+sizeY-z; ii++) {
				if(ii > PixelSurface.getHeight() && i > PixelSurface.getWidth() || ii > PixelSurface.getHeight() || i > PixelSurface.getWidth() || ii < 0 && i < 0 || ii < 0 || i < 0 || ii > PixelSurface.getHeight() && i < 0 || ii < 0 && i > PixelSurface.getHeight() || ii > PixelSurface.getHeight() || i > PixelSurface.getWidth()) {
					
				} else {
				PixelSurface.CoreFuncChangePixel(i, ii, r, g, b);
				}
				
			}
		}
		}
	}
	
	public static void wireframeRectangle(int x, int y, int z, int zCamera, int sizeX, int sizeY, int r, int g, int b) {
		if(z >= zCamera) {
		line(x, y, x, y-1 + sizeY-z, r, g, b);
		line(x, y, x + sizeX-z, y, r, g, b);
		line(x + sizeX-z, y, x + sizeX-z, y-1 + sizeY-z, r, g, b);
		line(x, y-1 + sizeY-z, x + sizeX-z, y-1 + sizeY-z, r, g, b);
		}
	}
	
	public static void wireframeTriangle(int x, int y, int z, int zCamera, int size, int r, int g, int b) {
		if(z >= zCamera) {
		line(x, y, x - size-z, y+size-z, r, g, b);
		line(x, y, x + size-z, y+size-z, r, g, b);
		line(x - size-z, y+size-z, x+size-z, y+size-z, r, g, b);
		}
	}
	
	public static void wireframeParallelogram(int x, int y, int z, int zCamera, int size, int r, int g, int b) {
		if(z >= zCamera) {
		line(x, y, x + size-z, y, r, g, b);
		line(x, y, x - size/2-z, y + size-z, r, g, b);
		line(x-size/2-z, y+size-z, x+size-z, y+size-z, r, g, b);
		line(x+size-z, y, x + size-z, y + size-z, r, g, b);
		}
	}
	
	public static void line(int x, int y, int x2, int y2, int r, int g, int b) {
		int w = x2 - x ;
	    int h = y2 - y ;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
	    if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
	    if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
	    if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
	    int longest = Math.abs(w) ;
	    int shortest = Math.abs(h) ;
	    if (!(longest>shortest)) {
	        longest = Math.abs(h) ;
	        shortest = Math.abs(w) ;
	        if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
	        dx2 = 0 ;            
	    }
	    int numerator = longest >> 1 ;
	    for (int i=0;i<=longest;i++) {
	    	if(y > PixelSurface.getHeight() && x > PixelSurface.getWidth() || y > PixelSurface.getHeight() || x > PixelSurface.getWidth() || y < 0 && x < 0 || x < 0 || y < 0 || y > PixelSurface.getHeight() && x < 0 || x < 0 && y > PixelSurface.getHeight() || y > PixelSurface.getHeight() || x > PixelSurface.getWidth()) {
	    		 						
	        } else {
	        PixelSurface.CoreFuncChangePixel(x, y, r, g, b);
	        }
	        numerator += shortest ;
	        if (!(numerator<longest)) {
	            numerator -= longest ;
	            x += dx1 ;
	            y += dy1 ;
	        } else {
	            x += dx2 ;
	            y += dy2 ;
	        }
	    }
	}
	
	
}

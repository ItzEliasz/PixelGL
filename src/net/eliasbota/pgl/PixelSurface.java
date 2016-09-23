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

public class PixelSurface {
	
	private static Pixel[][] pixels;
	private static Pixel[][] lastPixels;
	
	private static int widthH, heightT;
	
	public static void createSurface(int width, int height) {
		
		heightT = height;
		widthH = width;
		
		pixels = new Pixel[width][height];
		lastPixels = new Pixel[width][height];
		
		int widthIndex = 0, heightIndex = 0;
		
		for(int i = 0; i < height*width; i++) {
				pixels[widthIndex][heightIndex] = new Pixel(widthIndex, heightIndex, 0, 0, 0);
				lastPixels[widthIndex][heightIndex] = new Pixel(widthIndex, heightIndex, 0, 0, 0);
				widthIndex++;
				if(widthIndex == width) {
					heightIndex++;
					widthIndex = 0;
				}
				}
	}
	
	public static void update() {
		pixels = lastPixels;
	}
	
	public static Pixel[][] getPixels() {
		return pixels;
	}
	
	public static void cleanPixels() {
		for(int i = 0; i < widthH; i++) {
		for(int ii = 0; ii < heightT; ii++) {
			if(lastPixels[i][ii] != null) {
			lastPixels[i][ii].setR(0);
			lastPixels[i][ii].setG(0);
			lastPixels[i][ii].setB(0);
			}
		}
		}
	}
	
	public static void CoreFuncChangePixel(int x, int y, int r, int g, int b) {
		if(lastPixels[x][y] != null) {
				lastPixels[x][y].setR(r);
				lastPixels[x][y].setG(g);
				lastPixels[x][y].setB(b);
		}
	}
	public static void syncColor(int r, int g, int b) {
		for(int i = 0; i < widthH; i++) {
			for(int ii = 0; ii < heightT; ii++) {
				if(lastPixels[i][ii] != null) {
				lastPixels[i][ii].setR(r);
				lastPixels[i][ii].setG(g);
				lastPixels[i][ii].setB(b);
				}
			}
			}
	}


}

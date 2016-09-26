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

package net.eliasbota.pgl.memory;

import net.eliasbota.pgl.Pixel;

public class PixelMemory {
	
	private static Pixel[][] pixData;
	private static int sizeX = 0;
	private static int sizeY = 0;
	private static int id;
	
	public PixelMemory(int sizeXX, int sizeYY, Pixel[][] data, int idI) {
		sizeX = sizeXX;
		sizeY = sizeYY;
		pixData = data;
		id = idI;
		
		pixData = new Pixel[sizeX][sizeY];
		
		int widthIndex = 0, heightIndex = 0;
		
		for(int i = 0; i < sizeY*sizeX; i++) {
				pixData[widthIndex][heightIndex] = new Pixel(widthIndex, heightIndex, 0, 0, 0);
				widthIndex++;
				if(widthIndex == sizeX) {
					heightIndex++;
					widthIndex = 0;
				}
				}
	}
	
	public Pixel[][] getPixels() {
		return pixData;
	}
	
	public void setPixels(Pixel[][] pixelS) {
		pixData = pixelS;
	}
	
	public void setSize(int sizeXX, int sizeYY) {
		sizeX = sizeXX;
		sizeY = sizeYY;
	}
	
	public void cleanPixels() {
		for(int i = 0; i < sizeX; i++) {
		for(int ii = 0; ii < sizeY; ii++) {
			if(pixData[i][ii] != null) {
			pixData[i][ii].setR(0);
			pixData[i][ii].setG(0);
			pixData[i][ii].setB(0);
			}
		}
		}
	}
	
	public void CoreFuncChangePixel(int x, int y, int r, int g, int b) {
		if(pixData[x][y] != null) {
				pixData[x][y].setR(r);
				pixData[x][y].setG(g);
				pixData[x][y].setB(b);
		}
	}
	public void syncColor(int r, int g, int b) {
		for(int i = 0; i < sizeX; i++) {
			for(int ii = 0; ii < sizeY; ii++) {
				if(pixData[i][ii] != null) {
				pixData[i][ii].setR(r);
				pixData[i][ii].setG(g);
				pixData[i][ii].setB(b);
				}
			}
			}
	}
	
	public Integer getId() {
		return id;
	}

}

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

public class Geometry2D {
	
	public static void fillSquare(int x, int y, int z, int cameraZ, int size, int r, int g, int b) {
		if(z > cameraZ) {
		for(int i = x; i < x+size-z; i++) {
			for(int ii = y; ii < y+size-z; ii++) {
				if(ii > PixelSurface.getHeight() && i > PixelSurface.getWidth() || ii > PixelSurface.getHeight() || i > PixelSurface.getWidth()) {
					
				} else {
				PixelSurface.CoreFuncChangePixel(i, ii, r, g, b);
				}
				
			}
		}
		}
	}

}

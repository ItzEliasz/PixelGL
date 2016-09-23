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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.eliasbota.pgl.Pixel;

public class Memory {
	
	private static List<PixelMemory> memory = new CopyOnWriteArrayList<PixelMemory>();
	
	public static PixelMemory getPixelMemory(int id) {
		for(PixelMemory p : memory) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public static void addPixelMemory(int sizeX, int sizeY, Pixel[][] data, int id) {
		PixelMemory m = new PixelMemory(sizeX, sizeY, data, id);
		memory.add(m);
	}
	
	public static void removePixelMemory(int id) {
		memory.remove(getPixelMemory(id));
	}

}

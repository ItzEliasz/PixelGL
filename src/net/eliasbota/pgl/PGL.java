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
	
}

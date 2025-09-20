package com.bank;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean EXIT;

	public KeyHandler(){
		this.EXIT = false;
	}
	@Override
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_ESCAPE:
			EXIT = true;
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e){
	}
	@Override
	public void keyTyped(KeyEvent e){
	}
}

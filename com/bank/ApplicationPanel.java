package com.bank;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ApplicationPanel extends JPanel implements Runnable{
	private Thread MainThread;
	private KeyHandler keyHandler;
	private final int[] dimentions = new int[] {800, 600};
	final int FPS = 60;

	public ApplicationPanel(){
		this.keyHandler = new KeyHandler();
		this.setBackground(new Color(10, 10, 10));
		this.setPreferredSize(new Dimension(dimentions[0], dimentions[1]));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void update(){
	}
	
	public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.dispose();
  }

	public void startMainThread(){
		MainThread = new Thread(this);
		MainThread.start();
	}

	@Override
	public void run(){
		double drawInterval = 1e9 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		long timer = 0;
		int drawCount = 0;
		while (MainThread != null && !keyHandler.EXIT){
			currentTime = System.nanoTime();
			timer += (currentTime - lastTime);
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			if (delta >= 1){
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1e9){
				System.out.print("\rFPS : " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		javax.swing.SwingUtilities.invokeLater(() -> {
			java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(this);
			if (win != null) {
				win.dispose();
			}
		});
		System.out.println("\n--[ FINISHED ]--");        
	}
}

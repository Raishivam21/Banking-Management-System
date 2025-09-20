package com.bank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class ApplicationFrame extends JFrame {
	private CardLayout cardLayout;
	private JPanel cardPanel;

	public ApplicationFrame(ApplicationPanel applicationPanel){
		this.setTitle("BitBanking");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		LoginPanel loginPanel = new LoginPanel(() -> {
			cardLayout.show(cardPanel, "APP");
			applicationPanel.startMainThread();
		});

		cardPanel.add(loginPanel, "LOGIN");
		cardPanel.add(applicationPanel, "APP");

		this.add(cardPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		cardLayout.show(cardPanel, "LOGIN");
	}
}

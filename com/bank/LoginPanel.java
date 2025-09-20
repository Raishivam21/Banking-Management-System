package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private Runnable onLoginSuccess;  // callback to switch screens

	public LoginPanel(Runnable onLoginSuccess) {
		this.onLoginSuccess = onLoginSuccess;

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel userLabel = new JLabel("Username:");
		usernameField = new JTextField(15);

		JLabel passLabel = new JLabel("Password:");
		passwordField = new JPasswordField(15);

		loginButton = new JButton("Login");

		gbc.gridx = 0; gbc.gridy = 0; add(userLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 0; add(usernameField, gbc);

		gbc.gridx = 0; gbc.gridy = 1; add(passLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 1; add(passwordField, gbc);

		gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; add(loginButton, gbc);

		loginButton.addActionListener(e -> tryLogin());
	}

	private void tryLogin() {
		String user = usernameField.getText();
		String pass = new String(passwordField.getPassword());

		// for demo: accept "admin"/"123"
		if (user.equals("admin") && pass.equals("123")) {
			JOptionPane.showMessageDialog(this, "Login successful!");
			onLoginSuccess.run();
		} else {
			JOptionPane.showMessageDialog(this, "Invalid credentials");
		}
	}
}

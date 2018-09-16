package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeGUI extends JFrame
{

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public WelcomeGUI()
	{
		setTitle("Farkle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 20, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlPlay = new JPanel();
		pnlPlay.setOpaque(false);
		contentPane.add(pnlPlay, BorderLayout.SOUTH);

		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Arial Black", Font.PLAIN, 26));
		pnlPlay.add(btnPlay);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblWelcomeToFarkle = new JLabel("Welcome to Farkle!");
		lblWelcomeToFarkle.setFont(new Font("Arial Black", Font.PLAIN, 48));
		lblWelcomeToFarkle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblWelcomeToFarkle);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(WelcomeGUI.class.getResource("/Game/images/farkle.jpeg")));
		panel.add(label);

		JLabel lblAuthors = new JLabel("by Ashton Chatelain and Sam Smith");
		lblAuthors.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblAuthors.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAuthors);

		btnPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}

}

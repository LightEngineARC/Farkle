package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtRunning;
	private JTextField txtPlayer;
	private JTextField txtComputer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameGUI()
	{
		setMinimumSize(new Dimension(1000, 550));
		setTitle("Farkle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlDice = new JPanel();
		pnlDice.setOpaque(false);
		pnlDice.setBorder(new EmptyBorder(0, 20, 0, 20));
		contentPane.add(pnlDice, BorderLayout.CENTER);
		pnlDice.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblDie1 = new JLabel("");
		lblDie1.setBackground(SystemColor.window);
		lblDie1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie1.setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
		pnlDice.add(lblDie1);

		JLabel lblDie2 = new JLabel("");
		lblDie2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie2.setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
		pnlDice.add(lblDie2);

		JLabel lblDie3 = new JLabel("");
		lblDie3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie3.setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
		pnlDice.add(lblDie3);

		JLabel lblDie4 = new JLabel("");
		lblDie4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie4.setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
		pnlDice.add(lblDie4);

		JLabel lblDie5 = new JLabel("");
		lblDie5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie5.setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
		pnlDice.add(lblDie5);

		JLabel lblDie6 =  new JLabel("");
		lblDie6.setHorizontalAlignment(SwingConstants.CENTER);
		lblDie6.setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
		pnlDice.add(lblDie6);

		JPanel pnlBtm = new JPanel();
		pnlBtm.setOpaque(false);
		pnlBtm.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.add(pnlBtm, BorderLayout.SOUTH);
		pnlBtm.setLayout(new BorderLayout(0, 0));

		JPanel pnlBtmLeft = new JPanel();
		pnlBtmLeft.setOpaque(false);
		pnlBtmLeft.setBorder(new EmptyBorder(0, 20, 0, 20));
		pnlBtm.add(pnlBtmLeft, BorderLayout.WEST);
		pnlBtmLeft.setLayout(new GridLayout(0, 1, 0, 0));

		txtPlayer = new JTextField();
		txtPlayer.setEditable(false);
		txtPlayer.setFont(new Font("Arial Black", Font.PLAIN, 26));
		txtPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer.setText("0");
		pnlBtmLeft.add(txtPlayer);
		txtPlayer.setColumns(10);

		JLabel lblPlayerScore = new JLabel("Player Score");
		lblPlayerScore.setFont(new Font("Arial Black", Font.PLAIN, 28));
		lblPlayerScore.setHorizontalAlignment(SwingConstants.CENTER);
		pnlBtmLeft.add(lblPlayerScore);

		JPanel pnlBtmRight = new JPanel();
		pnlBtmRight.setOpaque(false);
		pnlBtmRight.setBorder(new EmptyBorder(0, 20, 0, 20));
		pnlBtm.add(pnlBtmRight, BorderLayout.EAST);
		pnlBtmRight.setLayout(new GridLayout(0, 1, 0, 0));

		txtComputer = new JTextField();
		txtComputer.setEditable(false);
		txtComputer.setFont(new Font("Arial Black", Font.PLAIN, 26));
		txtComputer.setHorizontalAlignment(SwingConstants.CENTER);
		txtComputer.setText("0");
		pnlBtmRight.add(txtComputer);
		txtComputer.setColumns(10);

		JLabel lblComputerScore = new JLabel("Computer Score");
		lblComputerScore.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblComputerScore.setHorizontalAlignment(SwingConstants.CENTER);
		pnlBtmRight.add(lblComputerScore);

		JPanel pnlBtmBtm = new JPanel();
		pnlBtmBtm.setOpaque(false);
		pnlBtmBtm.setBorder(new EmptyBorder(0, 350, 0, 350));
		pnlBtm.add(pnlBtmBtm, BorderLayout.SOUTH);
		pnlBtmBtm.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Arial Black", Font.PLAIN, 26));
		pnlBtmBtm.add(btnRoll);

		JButton btnBank = new JButton("Bank");
		btnBank.setFont(new Font("Arial Black", Font.PLAIN, 26));
		pnlBtmBtm.add(btnBank);

		JPanel pnlTop = new JPanel();
		pnlTop.setOpaque(false);
		pnlTop.setBorder(new EmptyBorder(20, 350, 20, 350));
		contentPane.add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new GridLayout(0, 1, 0, 0));

		txtRunning = new JTextField();
		txtRunning.setEditable(false);
		txtRunning.setFont(new Font("Arial Black", Font.PLAIN, 26));
		txtRunning.setHorizontalAlignment(SwingConstants.CENTER);
		txtRunning.setText("0");
		pnlTop.add(txtRunning);
		txtRunning.setColumns(10);

		JLabel lblRunning = new JLabel("Running Score");
		lblRunning.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblRunning.setHorizontalAlignment(SwingConstants.CENTER);
		pnlTop.add(lblRunning);
		
		Icon die1 = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png"));
		Icon die1b = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1b.png"));
		Icon die2 = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-2.png"));
		Icon die2b = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-2b.png"));
		Icon die3 = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-3.png"));
		Icon die3b = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-3b.png"));
		Icon die4 = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-4.png"));
		Icon die4b = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-4b.png"));
		Icon die5 = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-5.png"));
		Icon die5b = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-5b.png"));
		Icon die6 = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-6.png"));
		Icon die6b = new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-6b.png"));

		btnRoll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});

		btnBank.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});

		lblDie1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});

		lblDie2.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});

		lblDie3.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});

		lblDie4.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});

		lblDie5.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});

		lblDie6.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});
	}

}
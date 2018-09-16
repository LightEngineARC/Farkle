/*
 *By Ashton Chatelain and Sam Smith 
 */
package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GameGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtRunning;
	private JTextField txtPlayer;
	private JTextField txtComputer;
	private static JLabel[] dieLabels;
	public static JLabel lblComputerScore;
	public static JLabel lblPlayerScore;

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
					WelcomeGUI wFrame = new WelcomeGUI();
					wFrame.setVisible(true);
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

		/**
		 * Builds GUI
		 */
		setMinimumSize(new Dimension(1000, 660));
		setTitle("Farkle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 660);
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

		JLabel lblDie6 = new JLabel("");
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

		lblPlayerScore = new JLabel("Player Score");
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

		lblComputerScore = new JLabel("Computer Score");
		lblComputerScore.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblComputerScore.setHorizontalAlignment(SwingConstants.CENTER);
		pnlBtmRight.add(lblComputerScore);

		JPanel pnlBtmBtm = new JPanel();
		pnlBtmBtm.setOpaque(false);
		pnlBtmBtm.setBorder(new EmptyBorder(20, 350, 0, 350));
		pnlBtm.add(pnlBtmBtm, BorderLayout.SOUTH);
		pnlBtmBtm.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnRoll = new JButton("Roll");
		btnRoll.setFont(new Font("Arial Black", Font.PLAIN, 26));
		pnlBtmBtm.add(btnRoll);

		JButton btnBank = new JButton("Bank");
		btnBank.setFont(new Font("Arial Black", Font.PLAIN, 26));
		pnlBtmBtm.add(btnBank);
		
		JTextArea txtComputerSteps = new JTextArea();
		txtComputerSteps.setRows(9);
		txtComputerSteps.setBorder(new EmptyBorder(5, 20, 5, 20));
		txtComputerSteps.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtComputerSteps.setEditable(false);
		pnlBtm.add(txtComputerSteps, BorderLayout.CENTER);

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

		GameGUI.dieLabels = new JLabel[]
		{ lblDie1, lblDie2, lblDie3, lblDie4, lblDie5, lblDie6 };

		/**
		 * Start a Game state
		 */
		gameState aGame = new gameState();

		aGame.rollDice();
		setDiceIcons(aGame.getDice(), dieLabels);

		if (scoring.scoreDice(aGame.getDice()) == 0)
		{
			txtRunning.setText("Farkle!");
			System.out.println("Player Farkle!");

			aGame.setRunningScore(0);
			int[] z =
			{ 1, 2, 3, 4, 5, 6 };
			aGame.setDice(z);
			aGame.rollDice();
			aGame.setComputerTurn(true);

			int compTemp = aGame.getComputerScore();

			try
			{
				aGame.computerTurn();
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}

			if (aGame.getComputerScore() == compTemp)
			{
				lblComputerScore.setText("FARKLE!");
			}

			txtComputer.setText("" + aGame.getComputerScore());
			txtRunning.setText("0");

			winnerGUI(aGame, lblPlayerScore, lblComputerScore);

			setDiceIcons(aGame.getDice(), dieLabels);
			
			txtComputerSteps.setText(aGame.getComputerString());
		}

		// aGame.computerTurn();
		// txtComputer.setText("" + aGame.getComputerScore());
		// txtRunning.setText("0");
		//
		// setDiceIcons(aGame, dieLabels);

		/**
		 * Rolls Dice
		 */
		btnRoll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lblComputerScore.setText("Computer Score");
				lblPlayerScore.setText("Player Score");
				// rolls dice and sets icon to respective dice
				if (scoring.scoreDice(aGame.getDiceToggle()) > 0 && !aGame.isComputerTurn())
				{
					// add score of selected dice
					aGame.setRunningScore(aGame.getRunningScore() + scoring.scoreDice(aGame.getDiceToggle()));
					// super lock dice for new roll
					for (int j = 0; j < 6; j++)
					{
						if (aGame.getToggleDiceAtIndex(j) != -1)
						{
							aGame.setDiceAtIndex(j, -1);
						}
					}

					// if all dice are locked reset dice toggle and roll
					boolean full = true;
					for (int t = 0; t < 6; t++)
					{

						if (aGame.getDiceAtIndex(t) > -1)
						{
							full = false;
						}

					}
					if (full)
					{
						aGame.setDiceToggle(new int[]
						{ -1, -1, -1, -1, -1, -1 });
						aGame.setDice(new int[]
						{ 0, 0, 0, 0, 0, 0 });
					}
					aGame.rollDice();
					for (int k = 0; k < 6; k++)
					{
						if (aGame.getToggleDiceAtIndex(k) > 0)
						{
							aGame.setDiceAtIndex(k, -1);
							aGame.setToggleDiceAtIndex(k, -1);
						}
					}
					setDiceIcons(aGame.getDice(), dieLabels);

					// checking dice array score after roll.
					if (scoring.scoreDice(aGame.getDice()) == 0)
					{
						lblPlayerScore.setText("FARKLE!");
						System.out.println("Player Farkle!");
						setDiceIcons(aGame.getDice(), dieLabels);
						aGame.setRunningScore(0);
						int[] z =
						{ 1, 2, 3, 4, 5, 6 };
						aGame.setDice(z);
						aGame.rollDice();
						aGame.setComputerTurn(true);

						int compTemp = aGame.getComputerScore();

						try
						{
							aGame.computerTurn();
						} catch (InterruptedException e1)
						{
							e1.printStackTrace();
						}
						if (aGame.getComputerScore() == compTemp)
						{
							lblComputerScore.setText("FARKLE!");
						}
						txtComputer.setText("" + aGame.getComputerScore());
						txtRunning.setText("0");

						setDiceIcons(aGame.getDice(), dieLabels);

						winnerGUI(aGame, lblPlayerScore, lblComputerScore);

						txtComputerSteps.setText(aGame.getComputerString());
					}
				}
			}
		});

		/**
		 * Banks Score for Player or Computer
		 */
		btnBank.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lblComputerScore.setText("Computer Score");
				lblPlayerScore.setText("Player Score");
				if (!aGame.isComputerTurn() && aGame.getRunningScore() + scoring.scoreDice(aGame.getDiceToggle()) > 0)
				{
					if (aGame.getRunningScore() + scoring.scoreDice(aGame.getDiceToggle()) >= 500
							|| aGame.getPlayerScore() > 0)
					{
						System.out.println("Player banks: "
								+ (aGame.getRunningScore() + scoring.scoreDice(aGame.getDiceToggle())) + " points.\n");
						aGame.setPlayerScore(aGame.getPlayerScore() + aGame.getRunningScore()
								+ scoring.scoreDice(aGame.getDiceToggle()));
						txtPlayer.setText("" + aGame.getPlayerScore());
						txtRunning.setText("0");
						aGame.setRunningScore(0);
						int[] z =
						{ 1, 2, 3, 4, 5, 6 };
						aGame.setDice(z);
						aGame.rollDice();
						aGame.diceToggle = new int[]
						{ -1, -1, -1, -1, -1, -1 };
					}
					if (aGame.getPlayerScore() != 0)
					{
						aGame.setComputerTurn(true);

						int compTemp = aGame.getComputerScore();

						try
						{
							aGame.computerTurn();
						} catch (InterruptedException e1)
						{
							e1.printStackTrace();
						}

						if (aGame.getComputerScore() == compTemp)
						{
							lblComputerScore.setText("FARKLE!");
						}

						txtComputer.setText("" + aGame.getComputerScore());
						txtRunning.setText("0");

						setDiceIcons(aGame.getDice(), dieLabels);
						winnerGUI(aGame, lblPlayerScore, lblComputerScore);
						
						txtComputerSteps.setText(aGame.getComputerString());
					}
					winnerGUI(aGame, lblPlayerScore, lblComputerScore);
				}
			}

		});

		lblDie1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				lblComputerScore.setText("Computer Score");
				lblPlayerScore.setText("Player Score");
				if (!aGame.winCondition())
				{
					if (!aGame.isComputerTurn())
					{
						int index = 0;
						if (aGame.getDiceAtIndex(index) != -1)
						{
							int toggleScore = theToggler(aGame, index);
							txtRunning.setText("" + (toggleScore + aGame.getRunningScore()));

							lblDie1.setIcon(new ImageIcon(GameGUI.class.getResource(
									changeIcon(aGame.getDiceAtIndex(index), lblDie1.getIcon().toString()))));
						}
					}
				}
			}
		});

		lblDie2.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (!aGame.winCondition())
				{
					lblComputerScore.setText("Computer Score");
					lblPlayerScore.setText("Player Score");
					if (!aGame.isComputerTurn())
					{
						int index = 1;
						if (aGame.getDiceAtIndex(index) != -1)
						{
							int toggleScore = theToggler(aGame, index);
							txtRunning.setText("" + (toggleScore + aGame.getRunningScore()));

							lblDie2.setIcon(new ImageIcon(GameGUI.class.getResource(
									changeIcon(aGame.getDiceAtIndex(index), lblDie2.getIcon().toString()))));
						}
					}
				}
			}
		});

		lblDie3.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (!aGame.winCondition())
				{
					lblComputerScore.setText("Computer Score");
					lblPlayerScore.setText("Player Score");
					if (!aGame.isComputerTurn())
					{
						int index = 2;
						if (aGame.getDiceAtIndex(index) != -1)
						{
							int toggleScore = theToggler(aGame, index);
							txtRunning.setText("" + (toggleScore + aGame.getRunningScore()));

							lblDie3.setIcon(new ImageIcon(GameGUI.class.getResource(
									changeIcon(aGame.getDiceAtIndex(index), lblDie3.getIcon().toString()))));
						}
					}
				}
			}
		});

		lblDie4.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (!aGame.winCondition())
				{
					lblComputerScore.setText("Computer Score");
					lblPlayerScore.setText("Player Score");
					if (!aGame.isComputerTurn())
					{
						int index = 3;
						if (aGame.getDiceAtIndex(index) != -1)
						{
							int toggleScore = theToggler(aGame, index);
							txtRunning.setText("" + (toggleScore + aGame.getRunningScore()));

							lblDie4.setIcon(new ImageIcon(GameGUI.class.getResource(
									changeIcon(aGame.getDiceAtIndex(index), lblDie4.getIcon().toString()))));
						}
					}
				}
			}
		});

		lblDie5.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (!aGame.winCondition())
				{
					lblComputerScore.setText("Computer Score");
					lblPlayerScore.setText("Player Score");
					if (!aGame.isComputerTurn())
					{
						int index = 4;
						if (aGame.getDiceAtIndex(index) != -1)
						{
							int toggleScore = theToggler(aGame, index);
							txtRunning.setText("" + (toggleScore + aGame.getRunningScore()));

							lblDie5.setIcon(new ImageIcon(GameGUI.class.getResource(
									changeIcon(aGame.getDiceAtIndex(index), lblDie5.getIcon().toString()))));
						}
					}
				}
			}
		});

		lblDie6.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (!aGame.winCondition())
				{
					lblComputerScore.setText("Computer Score");
					lblPlayerScore.setText("Player Score");
					if (!aGame.isComputerTurn())
					{
						int index = 5;
						if (aGame.getDiceAtIndex(index) != -1)
						{
							int toggleScore = theToggler(aGame, index);
							txtRunning.setText("" + (toggleScore + aGame.getRunningScore()));

							lblDie6.setIcon(new ImageIcon(GameGUI.class.getResource(
									changeIcon(aGame.getDiceAtIndex(index), lblDie6.getIcon().toString()))));
						}
					}

				}
			}
		});
	}

	public static void computerTurn(gameState aGame) throws InterruptedException
	{
		while (aGame.computerTurn)
			aGame.computerTurn();
	}

	/**
	 * 
	 * Method : Toggler
	 *
	 * Purpose : toggles the selected die in the toggle array to the value of the
	 * die in the same index of the dice array
	 *
	 * Parameters : gameState, int
	 *
	 * Returns : the score of the dice in the toggle array
	 *
	 */
	public static int theToggler(gameState aGame, int index)
	{
		aGame.toggleDice(index);
		return scoring.scoreDice(aGame.getDiceToggle());

	}

	/**
	 * Sets the clicked die to it's respective locked or unlocked icon.
	 * 
	 * @param die
	 * @param dieString
	 * @return
	 */
	public static String changeIcon(int die, String dieString)
	{
		String ret = "";
		switch (die)
		{
		case 1:
			if (dieString.contains("1."))
			{
				ret = "/Game/images/die-red-1b.png";
			} else
			{
				ret = "/Game/images/die-red-1.png";
			}
			break;
		case 2:
			if (dieString.contains("2."))
			{
				ret = "/Game/images/die-red-2b.png";
			} else
			{
				ret = "/Game/images/die-red-2.png";
			}
			break;
		case 3:
			if (dieString.contains("3."))
			{
				ret = "/Game/images/die-red-3b.png";
			} else
			{
				ret = "/Game/images/die-red-3.png";
			}
			break;
		case 4:
			if (dieString.contains("4."))
			{
				ret = "/Game/images/die-red-4b.png";
			} else
			{
				ret = "/Game/images/die-red-4.png";
			}
			break;
		case 5:
			if (dieString.contains("5."))
			{
				ret = "/Game/images/die-red-5b.png";
			} else
			{
				ret = "/Game/images/die-red-5.png";
			}
			break;
		case 6:
			if (dieString.contains("6."))
			{
				ret = "/Game/images/die-red-6b.png";
			} else
			{
				ret = "/Game/images/die-red-6.png";
			}
			break;
		case -1:
			ret = dieString;
			break;
		default:
			break;
		}
		return ret;

	}

	/**
	 * Sets the dice labels to their proper icons.
	 * 
	 * @param aGame
	 * @param dieLabels
	 */
	public static void setDiceIcons(int[] dice, JLabel[] dieLabels)
	{
		for (int i = 0; i < 6; i++)
		{

			switch (dice[i])
			{
			case 1:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-1.png")));
				break;
			case 2:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-2.png")));
				break;
			case 3:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-3.png")));
				break;
			case 4:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-4.png")));
				break;
			case 5:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-5.png")));
				break;
			case 6:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("/Game/images/die-red-6.png")));
				break;
			case -1:
				break;
			default:
				dieLabels[i].setIcon(new ImageIcon(GameGUI.class.getResource("")));
				break;

			}

		}
	}

	public static JLabel[] getDieLabels()
	{
		return dieLabels;
	}

	public static void winnerGUI(gameState aGame, JLabel lblPlayerScore, JLabel lblComputerScore)
	{
		if (aGame.winCondition())
		{
			if (aGame.getPlayerScore() > aGame.getComputerScore())
			{
				lblPlayerScore.setText("Winner!");
				lblComputerScore.setText("Loser!");
			} else if (aGame.getPlayerScore() < aGame.getComputerScore())
			{
				lblPlayerScore.setText("Loser!");
				lblComputerScore.setText("Winner!");
			} else
			{
				lblPlayerScore.setText("Tie!");
				lblComputerScore.setText("Tie!");
			}
		}
	}
}

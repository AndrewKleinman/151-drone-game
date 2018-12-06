
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ActionListener
{
  private JPanel p;
  private JTextArea timerText;
  private JTextArea scoreText;
  private Timer timer;
  private DroneGame game;

  private JLabel gameinfo;

  public GameWindow() {
    initializeUI();
    timer = new Timer(100, this);
    timer.start();

  }

  private void initializeUI() 
  {

    gameinfo = new JLabel();
    add(gameinfo, BorderLayout.SOUTH);

    game = new DroneGame();
    game.setFocusable(true);
    add(game);
    game.start();

    p = new JPanel();
    timerText = new JTextArea(1, 5);
    scoreText = new JTextArea(2, 10);
    timerText.setText("");
    scoreText.setText("");
    timerText.append(game.scoreTimer.printTime());
    scoreText.append(game.playerScore.printScore());
    timerText.setEnabled(true);
    timerText.setOpaque(true);
    scoreText.setEnabled(true);
    scoreText.setOpaque(false);
    p.add(timerText, BorderLayout.PAGE_START);
    p.add(scoreText, BorderLayout.PAGE_START);
    add(p, BorderLayout.SOUTH);

    setTitle("Drone Game");
    setSize(800, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public JLabel getGameInfo() 
  {
    return gameinfo;
  }

  public static void main(String[] args) {

    GameWindow game = new GameWindow();

    game.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timerText.setText("");
    scoreText.setText("");
    timerText.append(game.scoreTimer.printTime());
    scoreText.append(game.playerScore.printScore());
  }
}



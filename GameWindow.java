
import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class GameWindow extends JFrame 
{

  private JLabel gameinfo;

  public GameWindow() {
    initializeUI();

  }

  private void initializeUI() 
  {

    gameinfo = new JLabel();
    add(gameinfo, BorderLayout.SOUTH);

    DroneGame droneGame = new DroneGame();
    droneGame.setFocusable(true);
    add(droneGame);
    droneGame.start();

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
}



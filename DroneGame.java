//contains the main method that starts the game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.*;
import javax.swing.Timer;


public class DroneGame extends JPanel implements ActionListener, KeyListener
{
    Drone drone = new Drone();
    Score playerScore = new Score();
    Stopwatch scoreTimer = new Stopwatch();
    ImageIcon icon = new ImageIcon("cloud_background_med.jpg");
    private Timer timer;
    private Boolean paused = false;
    private int pausedTime = 0;
    private boolean isPaused = false;
    public static ArrayList<JLabel> airplaneLabels=new ArrayList<>();
    public static ArrayList<Airplane> airplanes=new ArrayList<>();
    final JLabel background = new JLabel(icon);
    private final int delay = 10;      // Timer
    


    public DroneGame()
    {
        
        addKeyListener(this);
        timer = new Timer(delay, this);
        drone = new Drone();
        playerScore = new Score();
        setSize(800,600);
        setFocusable(true);
    }

    public Drone getDrone()
    {
        return drone;
    }
    
    public void start()
    {   
        Airplane airplane = new Airplane(-100, 100, 20);
        Airplane airplane1 = new Airplane(-100, 100, 20);
        Airplane airplane2 = new Airplane(-100, 100, 20);
        Airplane airplane3 = new Airplane(-100, 100, 20);
        Airplane airplane4 = new Airplane(-100, 100, 20);
        Airplane airplane5 = new Airplane(-100, 100, 20);
        
        
        Rectangle bounds = new Rectangle(400,300,140,50);           // Shift bounds to detect collisions and move airplane

        
        //make sure the image is in the same (src) project folder
        airplanes = new ArrayList<>();
        airplanes.add(airplane);
        airplanes.add(airplane1);
        airplanes.add(airplane2);
        airplanes.add(airplane3);
        airplanes.add(airplane4);
        airplanes.add(airplane5);
        

        airplaneLabels = new ArrayList<>();
        JLabel airplaneLabel = new JLabel(airplane);
        JLabel airplaneLabel1 = new JLabel(airplane1);
        JLabel airplaneLabel2 = new JLabel(airplane2);
        JLabel airplaneLabel3 = new JLabel(airplane3);
        JLabel airplaneLabel4 = new JLabel(airplane4);
        JLabel airplaneLabel5 = new JLabel(airplane5);
        
        airplaneLabels.add(airplaneLabel);
        airplaneLabels.add(airplaneLabel1);
        airplaneLabels.add(airplaneLabel2);
        airplaneLabels.add(airplaneLabel3);
        airplaneLabels.add(airplaneLabel4);
        airplaneLabels.add(airplaneLabel5);
        
        
        airplaneLabel.setBounds(bounds);
        airplaneLabel1.setBounds(bounds);
        airplaneLabel2.setBounds(bounds);
        airplaneLabel3.setBounds(bounds);
        airplaneLabel4.setBounds(bounds);
        airplaneLabel5.setBounds(bounds);

        

        JButton start = new JButton("Start");


        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                paused = false;
                timer.start();
                scoreTimer.startTimer();
                if (pausedTime >=0 && isPaused) {
                    scoreTimer.resetTime(pausedTime);
                    isPaused = false;
                }
            }
        });


        add(airplaneLabel);
        add(airplaneLabel1); 
        add(airplaneLabel2);
        add(airplaneLabel3);
        add(airplaneLabel4);
        add(airplaneLabel5);
        
        add(start);
        
        setVisible(true);
    }

    public void modAirPlane(Airplane a) 
    {
        JLabel label = airplaneLabels.get(airplanes.indexOf(a));
        a.xShift();
        Rectangle newBound = new Rectangle(a.getX(),a.getY(),140,50);
        label.setBounds(newBound);
        if(a.getX() <= 0-a.getIconWidth())
        {
            a.resetX();
            a.resetY();
        }
        repaint();
    }

    public void lose()
    {
        paused = true;
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Game Over.");
        scoreTimer.resetTime();
        playerScore.resetLives();
    }
    
    
    public void win() 
    {
        if (scoreTimer.getSeconds() == 0 && playerScore.getLives() > 0) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "You Win");
            scoreTimer.resetTime();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        this.requestFocus();
        if(scoreTimer.getSeconds() == 0)
        {
            win();
            playerScore.nextGame(true);
        }
        drone.update();

        if(airplanes.size() != 0 && airplanes.get(airplanes.size()-1).getX()+150>0) {
            for(Airplane a: airplanes) 
            {
                modAirPlane(a);
            }
        }
        if(drone.freeze >= 50 && drone.collisionDetection() == true) 
        {
            playerScore.decreaseLives();
            if(playerScore.getLives() <= 0)
            {
                lose();
                playerScore.nextGame(false);
            }
        }
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(icon.getImage(), 0, 0, this);
        g2.drawImage(drone.getImage(), drone.getX(), drone.getY(), this);
      
    }
    
    
    public boolean isPaused()
    {
        return paused;
    }
    
    
    public void keyPressed(KeyEvent e){
        drone.keyPressed(e);
    }
    public void keyReleased(KeyEvent e) {
        drone.keyReleased(e);
    }

    public void keyTyped(KeyEvent e) {}
}

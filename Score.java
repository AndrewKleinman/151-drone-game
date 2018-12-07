//when drone finishes flying in 1:30 with 2 collisions or less, score increases by 1
//if not, increment total games by 1
//the number of drone lives should be handled by DroneGame
public class Score 
{
	private int score;
	private int totalGames;
	private int lives;
	
	public Score() {
		score = 0;
		totalGames = 1;
		lives = 3;
	}
	
	public String printScore() 
	{
		return "Score: " + score + " out of " + totalGames + "\n"+ "Lives remaining: " + lives;
	}
	
	
	public void changeScore(boolean gameWon) 
	{
		if (gameWon) 
		{
			if (score == 0 && totalGames == 1) 
			{
				score++;
			} 
			else 
			{
				score++;
				totalGames++;
			}
		} 
		else 
		{
			totalGames++;
		}
	}
	public void nextGame(boolean gameWon) 
	{
		lives = 3;
		changeScore(gameWon);
	}
	public void resetScore(boolean gameReset) 
	{
		if (gameReset) 
		{
			score = 0;
			totalGames = 1;
		}
	}
	public void decreaseLives() 
	{
		lives--;
	}
	
	public int getLives() 
	{
		return lives;
	}
		
	public void resetLives()
	{
		lives = 3;
	}

}

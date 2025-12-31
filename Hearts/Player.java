public class Player {
  private String name;
  private int score;

  public Player(){}
  
  public Player(String n, int s) {
    this.name = n;
    this.score = s;
  }

  public void setName(String n) {
    this.name = n;
  }

  public void setScore(int s) {
    this.score = s;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void updateScore(int addToScore) {
    score += addToScore;
  }

  public String toString() {
    return name + score;
  }
}

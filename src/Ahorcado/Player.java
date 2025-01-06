
package Ahorcado;

public class Player {
    
    private String name;
    private int score;
    private int health;
    private int positionNumber;
    
    public Player(String name, int positionNumber){
        this.name = name;
        this.score = 0;
        this.health = 90;
        this.positionNumber = positionNumber;
    }
    
    public int decreaseHealthBar() {
        if (this.health != -30) {
            this.health -= 30;
        }
        return this.health;
    }
    
    public void increaseScore(){
        this.score += 100;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

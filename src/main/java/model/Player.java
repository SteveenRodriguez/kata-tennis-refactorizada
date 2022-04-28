package model;

public class Player {

    private Integer score;
    private final String playerName;

    public Player(String playerName) {
        this.score = 0;
        this.playerName = playerName;
    }

    public Integer score() {
        return score;
    }

    public void addScore(Integer score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return "model.Player{" +
                "score=" + score +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}

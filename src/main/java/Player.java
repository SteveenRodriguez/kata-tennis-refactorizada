public class Player {

    private Integer score;
    private String playerName;

    public Player() {
    }

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

    public String playerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}

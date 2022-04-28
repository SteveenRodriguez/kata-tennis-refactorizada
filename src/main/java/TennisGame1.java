import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String playerName, String playerName2) {
        this.player1 = new Player(playerName);
        this.player2 = new Player(playerName2);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.addScore(1);
            return;
        }
        player2.addScore(1);
    }

    public String getScore() {
        String score = "";

        if (Objects.equals(player1.score(), player2.score()))
        {
            score = equalValues();
        }
        else if (player1.score() >= 4 || player2.score() >= 4)
        {
            score = scoreGreaterThan4();
        }
        else
        {
            score = evaluateScores(score);
        }
        return score;
    }

    private String evaluateScores(String score) {
        Integer tempScore;
        StringBuilder scoreBuilder = new StringBuilder(score);
        for (Integer i = 1; i<3; i++)
        {
            if (i.equals(1)) tempScore = player1.score();
            else { scoreBuilder.append("-"); tempScore = player2.score();}

            switch(tempScore)
            {
                case 0 -> scoreBuilder.append("Love");
                case 1 -> scoreBuilder.append("Fifteen");
                case 2 -> scoreBuilder.append("Thirty");
                case 3 -> scoreBuilder.append("Forty");
                default -> scoreBuilder.append("");
            }
        }
        score = scoreBuilder.toString();
        return score;
    }

    private String scoreGreaterThan4() {
        String score;
        Integer minusResult = player1.score() - player2.score();
        if (minusResult.equals(1)) score ="Advantage player1";
        else if (minusResult.equals(-1)) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String equalValues() {
        return switch (player1.score()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
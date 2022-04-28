import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private Integer scorePlayer1 = 0;
    private Integer scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String Score = "";
        if (empate()) {
            Score = puntajesIguales();
        } else if (seleccionDeAvance()) {
            Integer diferenciaDePuntaje = scorePlayer1 - scorePlayer2;
            Score = avance(diferenciaDePuntaje);
        } else {
            Score = puntaje(scorePlayer1) + "-" + puntaje(scorePlayer2);
        }
        return Score;
    }

    public void wonPoint(String player) {
        Integer puntaje = (player == "player1") ? (scorePlayer1++) : (scorePlayer2++);
    }


    public boolean empate() {
        return scorePlayer1.equals(scorePlayer2);
    }


    public boolean seleccionDeAvance() {
        return ((scorePlayer1 >= 4) || (scorePlayer2 >= 4));
    }

    public String puntajesIguales() {
        List<String> puntajes = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return puntajes.get(scorePlayer1);
    }


    public String avance(Integer diferenciaDePuntaje) {
        switch (diferenciaDePuntaje) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (diferenciaDePuntaje >= 2) ? "Win for player1" : "Win for player2";
        }
    }

    public String puntaje(Integer ScorePlayer) {
        List<String> Puntajes = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return Puntajes.get(ScorePlayer);
    }
}
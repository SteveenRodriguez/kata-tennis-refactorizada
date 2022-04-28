import interfaces.TennisGame;

public class TennisGame3 implements TennisGame {

    private Integer scorePlayer1 = 0;
    private Integer scorePlayer2 = 0;
    private final String namePlayer1;
    private final String namePlayer2;

    public TennisGame3(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public String getScore() {
        if (points()) {
            return resultadoPoints();
        }
        if (empate()) {
            return "Deuce";
        }
        return evento();
    }

    public boolean points() {
        return (scorePlayer2 < 4) && (scorePlayer1 < 4) && (scorePlayer2 + scorePlayer1 != 6);
    }

    public boolean empate() {
        return (scorePlayer2.equals(scorePlayer1));
    }

    public String evento() {
        return (elevarResta() == 1) ? "Advantage " + jugadorAdelante() : "Win for " + jugadorAdelante();
    }

    public Double elevarResta() {
        return Math.pow((scorePlayer2 - scorePlayer1), 2);
    }

    public String jugadorAdelante() {
        return scorePlayer2 > scorePlayer1 ? namePlayer1 : namePlayer2;
    }

    public String resultadoPoints() {
        String[] puntaje = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (scorePlayer2.equals(scorePlayer1)) ? puntaje[scorePlayer2] + "-All" : puntaje[scorePlayer2] +
                "-" + puntaje[scorePlayer1];
    }

    public void wonPoint(String playerName) {
        if(playerName.equals("player1")){
            scorePlayer2++;
            return;
        }
        scorePlayer1++;
    }
}

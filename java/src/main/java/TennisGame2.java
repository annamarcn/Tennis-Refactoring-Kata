import java.util.Objects;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (P1point == P2point) {
            return tie(P1point);
        }
        if (Math.abs(P1point - P2point) >= 2 && Math.max(P1point, P2point) >= 4) {
            return "Win for " + winner();
        }

        if (Math.min(P1point, P2point) >= 3) {
            return "Advantage " + advantage();
        }
        return translateScore(P1point) + "-" + translateScore(P2point);
    }

    private String advantage() {
        if (P1point > P2point) {
            return player1Name;
        } else {
            return player2Name;
        }
    }

    private String winner() {
        if (P1point > P2point) {
            return player1Name;
        } else {
            return player2Name;
        }
    }


    private String tie(int score) {
        if (score == 0)
            return "Love-All";
        if (score == 1)
            return "Fifteen-All";
        if (score == 2)
            return "Thirty-All";
        else return "Deuce";
    }

    private String translateScore(int playerScore) {
        if (playerScore == 0)
            return "Love";
        if (playerScore == 1)
            return "Fifteen";
        if (playerScore == 2)
            return "Thirty";
        else return "Forty";
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, player1Name))
            P1point++;
        else
            P2point++;
    }
}
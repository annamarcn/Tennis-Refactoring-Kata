public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName){
        if (playerName.equals(player1Name))
            scorePlayer1 += 1;
        else if(playerName.equals(player2Name))
            scorePlayer2 += 1;
    }

    public String getScore() {
        if (scorePlayer1 == scorePlayer2) {
            return getTieScore(scorePlayer1);
        }
        else if (scorePlayer1 >=4 || scorePlayer2 >=4) {
            return getAdvantageOrWinScore(scorePlayer1 - scorePlayer2);
        }
        return getCurrentScore();
    }

    private String getCurrentScore() {
        return scoreTranslation(scorePlayer1) + "-" + scoreTranslation(scorePlayer2);
    }

    private static String scoreTranslation(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalStateException("Unexpected value: " + score);
        };
    }

    private String getAdvantageOrWinScore(int diff) {
        if (diff==1) return "Advantage player1";
        else if (diff ==-1) return "Advantage player2";
        else if (diff>=2) return "Win for player1";
        else return "Win for player2";
    }

    private String getTieScore(int score) {
        return switch (score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}

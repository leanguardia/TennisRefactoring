package main.java;

public class TennisGame2 implements TennisGame
{
    public int P1points = 0;            //times p1 has scored
    public int P2points = 0;            //times p2 has scored
    
    public String P1result = "";
    public String P2result = "";

    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void P1Scores(){
        P1points++;
    }

    public void P2Scores(){
        P2points++;
    }

    public void SetP1Score(int points){
        for (int i = 0; i < points; i++)
        {
            P1Scores();
        }
    }

    public void SetP2Score(int points){
        for (int i = 0; i < points; i++)
        {
            P2Scores();
        }
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Scores();
        else
            P2Scores();
    }

    public String getScore(){
                                //points are minor than 3 in both players
        setScoreIfplayersAreTied();
        setScoreIfP1hasPointsP2hasNot();
        setScoreIfP2hasPointsP1hasNot();
        setScoreIfP1isWinning();
        setScoreIfP2isWinning();
                                //points are equal or bigger than 3 in both players
        if (P1points == P2points && isFortyOrGreater(P1points))
            score = "Deuce";
        if (P1hasAdvantage())
            score = "Advantage player1";
        if (P2hasAdvantage())
            score = "Advantage player2";
        if (P1hasWon())
            score = "Win for player1";
        if (P2hasWon())
            score = "Win for player2";
        return score;
    }

    private static boolean isFortyOrGreater(int playerPoints) {
        return playerPoints >=3;
    }

    private void setScoreIfP2hasPointsP1hasNot() {
        if (P2points > 0 && P1points ==0)
        {
            if (P2points ==1)
                P2result = "Fifteen";
            if (P2points ==2)
                P2result = "Thirty";
            if (P2points ==3)
                P2result = "Forty";
            P1result = "Love";
            score = P1result + "-" + P2result;
        }
    }

    private void setScoreIfP1hasPointsP2hasNot() {
        if (P1points > 0 && P2points ==0)
        {
            if (P1points ==1)
                P1result = "Fifteen";
            if (P1points ==2)
                P1result = "Thirty";
            if (P1points ==3)
                P1result = "Forty";

            P2result = "Love";
            score = P1result + "-" + P2result;
        }
    }


    private static boolean isGreaterThanForty(int playerPoints) {
        return playerPoints >= 4;
    }

    private static boolean differenceIsTwoOrGreater(int playerPoints1, int playerPoints2) {
        return (playerPoints1 - playerPoints2) >= 2;
    }

    private boolean P2hasWon() {
        return isGreaterThanForty(P2points) && P1points >=0 && differenceIsTwoOrGreater(P2points, P1points);
    }

    private boolean P1hasWon() {
        return isGreaterThanForty(P1points) && P2points >=0 && differenceIsTwoOrGreater(P1points, P2points);
    }

    private boolean P2hasAdvantage() {
        return P2points > P1points && isFortyOrGreater(P1points);
    }

    private boolean P1hasAdvantage() {
        return P1points > P2points && isFortyOrGreater(P2points);
    }

    private void setScoreIfP1isWinning() {
        if (P1points > P2points && P1points < 4)
        {
            if (P1points ==2)
                P1result ="Thirty";
            if (P1points ==3)
                P1result ="Forty";
            if (P2points ==1)
                P2result ="Fifteen";
            if (P2points ==2)
                P2result ="Thirty";
            score = P1result + "-" + P2result;
        }
    }

    private void setScoreIfP2isWinning() {
        if (P2points > P1points && P2points < 4)
        {
            if (P2points ==2)
                P2result ="Thirty";
            if (P2points ==3)
                P2result ="Forty";
            if (P1points ==1)
                P1result ="Fifteen";
            if (P1points ==2)
                P1result ="Thirty";
            score = P1result + "-" + P2result;
        }
    }

    private void setScoreIfplayersAreTied() {
        if (P1points == P2points && P1points < 4)
        {
            if (P1points ==0)
                score = "Love";
            if (P1points ==1)
                score = "Fifteen";
            if (P1points ==2)
                score = "Thirty";
            score += "-All";
        }
    }

}
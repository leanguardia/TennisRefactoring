package main.java;

public class TennisGame2 implements TennisGame
{
    public int P1points = 0;
    public int P2points = 0;
    
    public String P1result = "";
    public String P2result = "";
    private String player1Name;
    private String player2Name;

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
        String score = "";
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
        if (P1points == P2points && P1points >=3)
            score = "Deuce";
        
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
        
        if (P1points > P2points && P2points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2points > P1points && P1points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1points >=4 && P2points >=0 && (P1points - P2points)>=2)
        {
            score = "Win for player1";
        }
        if (P2points >=4 && P1points >=0 && (P2points - P1points)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

}
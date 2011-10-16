package bowling;

public class Game {

    private int points;
    private int[] factors;

    public Game() {
        this.points = 0;
        this.factors = new int[] {1, 1};
    }

    public void roll(int pins) {
        this.points += scoreRoll(pins);

        if (pins == 10) {
            factors[0]++;
            factors[1]++;
        }
    }

    private int scoreRoll(int pins) {
        int factor = factors[0];
        factors[0] = factors[1];
        factors[1] = 1;
        return pins * factor;
    }

    public int score(){
        return points;
    }

}

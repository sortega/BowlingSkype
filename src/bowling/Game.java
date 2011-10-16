package bowling;

public class Game {

    private int points;
    private int[] factors;
    private int pinsInFrame;
    private int rollsInFrame;

    public Game() {
        this.points = 0;
        this.factors = new int[] {1, 1};
        this.pinsInFrame = 0;
        this.rollsInFrame = 0;
    }

    public void roll(int pins) {
        this.points += scoreRoll(pins);
        this.pinsInFrame += pins;
        this.rollsInFrame++;

        if (isStrike()) {
            factors[0]++;
            factors[1]++;
            newFrame();
        } else if (isSpare()) {
            factors[0]++;
            newFrame();
        } else if (rollsInFrame == 2) {
            newFrame();
        }
    }

    public void newFrame() {
        pinsInFrame = 0;
        rollsInFrame = 0;
    }

    private boolean isStrike() {
        return pinsInFrame == 10 && rollsInFrame == 1;
    }

    private boolean isSpare() {
        return pinsInFrame == 10 && rollsInFrame == 2;
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

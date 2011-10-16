package bowling;

public class Game {

    private static class Frame {
        private static final int MAX_ROUNDS = 10;

        private int pins;
        private int rolls;
        private int[] factors;
        private int round;

        public Frame() {
            this.pins = 0;
            this.rolls = 0;
            this.round = 1;
            this.factors = new int[] {1, 1};
        }

        private int scoreRoll(int pins) {
            roll(pins);
            int rollPoints = pins * popFactor();
            if (isFinished()) {
                updateFactors();
                nextFrame();
            }
            return rollPoints;
        }

        public void roll(int pins) {
            this.pins += pins;
            this.rolls++;
        }

        public void updateFactors() {
            if (isStrike()) {
                factors[0]++;
                factors[1]++;
            } else if (isSpare()) {
                factors[0]++;
            }
        }

        public int popFactor() {
            int factor = factors[0];
            factors[0] = factors[1];
            factors[1] = 1;
            return factor;
        }

        private void nextFrame() {
            pins = 0;
            rolls = 0;
            round++;
        }

        private boolean isStrike() {
            return pins == 10 && rolls == 1;
        }

        private boolean isSpare() {
            return pins == 10 && rolls == 2;
        }

        public boolean isFinished() {
            return round < MAX_ROUNDS &&
                    (isStrike() || isSpare() || rolls == 2);
        }
    }

    private int points;
    private Frame frame;

    public Game() {
        this.points = 0;
        this.frame = new Frame();
    }

    public void roll(int pins) {
        this.points += frame.scoreRoll(pins);
    }

    public int score(){
        return points;
    }
}

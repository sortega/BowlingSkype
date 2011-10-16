package bowling;

public class Game {

    private static class Frame {
        private int pinsInFrame;
        private int rollsInFrame;
        private int[] factors;

        public Frame() {
            this.pinsInFrame = 0;
            this.rollsInFrame = 0;
            this.factors = new int[] {1, 1};
        }

        private int scoreRoll(int pins) {
            int rollPoints = pins * popFactor();

            this.pinsInFrame += pins;
            this.rollsInFrame++;

            if (isFinished()) {
                updateFactors();
                nextFrame();
            }

            return rollPoints;
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
            pinsInFrame = 0;
            rollsInFrame = 0;
        }

        private boolean isStrike() {
            return pinsInFrame == 10 && rollsInFrame == 1;
        }

        private boolean isSpare() {
            return pinsInFrame == 10 && rollsInFrame == 2;
        }

        public boolean isFinished() {
            return isStrike() || isSpare() ||
                    rollsInFrame == 2;
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

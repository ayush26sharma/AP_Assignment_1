package com.company;

public class Floor {
    private final int level;
    private final long pointsRewarded;
    protected int getToLevel;
    protected String type;
    public Floor(int level, int pointsRewarded) {
        this.level = level;
        this.pointsRewarded = pointsRewarded;
        Game.getAllFloors().add(this);
    }
    protected int getLevel() {
        return level;
    }
    protected long getPointsRewarded() {
        return pointsRewarded;
    }
    protected void changePoints(Player currentPlayer){
        currentPlayer.setPoints(currentPlayer.getPoints() + this.getPointsRewarded());
        currentPlayer.setPosition(this.getToLevel);
    }
}

class EmptyFloor extends Floor{
    public EmptyFloor(int level, int pointsRewarded) {
        super(level, pointsRewarded);
        this.type = "Empty Floor";
        this.getToLevel = this.getLevel();
    }
}

class Snakes extends Floor{
    public Snakes(int level, int pointsRewarded, int k) {
        super(level, pointsRewarded);
//        this.getToLevel = k;
//        this.type = "Snake";
    }
}

class Snake extends Snakes{
    public Snake(int level, int pointsRewarded, int k) {
        super(level, pointsRewarded, k);
        this.getToLevel = k;
        this.type = "Snake";
    }
}

class KingCobra extends Snakes{
    public KingCobra(int level, int pointsRewarded, int k) {
        super(level, pointsRewarded, k);
        this.getToLevel = k;
        this.type = "King Cobra";
    }
}

class Ladders extends Floor{
    public Ladders(int level, int pointsRewarded, int k) {
        super(level, pointsRewarded);
//        this.getToLevel = k;
//        this.type = "Ladder";
    }
}

class Ladder extends Ladders{
    public Ladder(int level, int pointsRewarded, int k) {
        super(level, pointsRewarded, k);
        this.getToLevel = k;
        this.type = "Ladder";
    }
}

class Elevator extends Ladder{
    public Elevator(int level, int pointsRewarded, int k) {
        super(level, pointsRewarded, k);
        this.getToLevel = k;
        this.type = "Elevator";
    }
}


package logic;

public enum Way {
    up,
    right,
    down,
    left;

    public Way opposite(){
        System.out.println("Way.opposite meghívódott");
        switch(this) {
            case up: return down;
            case right: return left;
            case down: return up;
            case left: return right;
            default: throw new IllegalStateException("Opposite Error");
        }
    }
}

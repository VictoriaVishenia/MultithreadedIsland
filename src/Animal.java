import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

abstract class Animal implements Eatable{
    double foodNorm;
    double meal; //amount of food which just eaten by animal
    int x ; //Coordinates of location every animal
    int y;
    private final int PROBABILITY = ThreadLocalRandom.current().nextInt(1, 101);
    // Probability of eating somebody, walking to another cell of Island or reproducing
    public int getPROBABILITY(){
        return PROBABILITY;
    }
    private final ReentrantLock LOCK = new ReentrantLock();
    public ReentrantLock getLOCK(){
        return LOCK;
    }
    abstract void firstLocated();
    abstract void move();
    abstract void reproduce();
    void die() {
        if (this.eatenBySmb(true)) {
            Island.getIslandLocations()[this.x][this.y].remove(this);
        }
    }
}

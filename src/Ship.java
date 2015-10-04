
public class Ship {
    int x;
    int y;
    int length;
    boolean rotation; //True- горизнтально, False- вертикально

    public Ship(int x, int y, int length, boolean rotation) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.rotation = rotation;
//        System.out.println("X-" + this.x + " Y-" + this.y + " Length-" + length + " Rotation-" + this.rotation);

    }

}

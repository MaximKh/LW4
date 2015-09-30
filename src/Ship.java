
public class Ship {
    int x;
    int y;
    int length;
    boolean rotation;

    public Ship(int length, int size){
        this.length = length;
        this.rotation = Math.random() < 0.5;
        do{
            this.x = (int)(Math.random() * size);
        }while(this.rotation || this.x + this.length < size);
        do{
            this.y = (int)(Math.random() * size);
        }while(!this.rotation || this.y + this.length < size);



    }
}

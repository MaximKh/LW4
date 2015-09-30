
public class BFAI extends Battlefield {
    public BFAI() {
        super();
        this.ship[0] = new Ship(4, N);
        this.mark(this.ship[0]);
    }

    public void mark(Ship s){
        for(int i = 0; i < s.length; i++){
            if(s.rotation){
                this.cell[s.x + i][s.y] = 'X';
            }else {
                this.cell[s.x][s.y + i] = 'X';
            }
        }
    }
}

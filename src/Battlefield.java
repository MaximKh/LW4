
public class Battlefield {
    final int N = 8; // Размер поля
    int ship4 = 1;
    int ship3 = 2;
    int ship2 = 3;
    int ship1 = 4;
    Ship[] ship;
    char[][] cell;

    public Battlefield(){
        this.cell = new char[N][N];
        this.clean();
        int sum = this.ship1 + this.ship2 + this.ship3 + this.ship4;
        this.ship = new Ship[sum];
    }

    public void print(){
        //Печать шапки
        System.out.print(" ");
        ABC abc = new ABC();
        for(int i = 0; i < N; i++){
            System.out.print(" " + abc.abc[i]);
        }
        System.out.println();
        //Печать поля
        for(int i = 0; i < N; i++){
            if(i < 9) System.out.print("0");
            System.out.print(i + 1 + "|");
            for(int j = 0; j < N; j++){
                System.out.print(cell[j][i] + " ");
            }
            System.out.println();
        }
    }

    private void clean(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                this.cell[i][j] = '.';
            }
        }

    }
}

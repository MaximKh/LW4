
public class BFAI extends Battlefield {
    public BFAI() {
        super();
        //Раставляем корабли
        int j = 0;
        int i;
        for (i = 0; i < this.ship4; i++) {
            this.ship[i + j] = nextShip(4);
            this.mark(this.ship[i + j]);
            print();
        }
        j += i;
        for (i = 0; i < this.ship3; i++) {
            this.ship[i + j] = nextShip(3);
            this.mark(this.ship[i + j]);
            print();
        }
        j += i;
        for (i = 0; i < this.ship2; i++) {
            this.ship[i + j] = nextShip(2);
            this.mark(this.ship[i + j]);
            print();
        }
        j += i;
        for (i = 0; i < this.ship1; i++) {
            this.ship[i + j] = nextShip(1);
            this.mark(this.ship[i + j]);
            print();
        }

//        j += i;
//        System.out.println("JJJJJ=" + j);
    }

    public void mark(Ship s) {
        for (int i = 0; i < s.length; i++) {
            if (s.rotation) {
                this.cell[s.x + i][s.y] = 'X';
            } else {
                this.cell[s.x][s.y + i] = 'X';
            }
        }
    }

    public boolean checkCell(int x, int y, char marker) {
        if (this.cell[x][y] == marker) {
            return true;
        } else {
            this.cell[x][y] = '*';
            return false;
        }
    }

    public Ship nextShip(int length) {
        Ship temp;
        int rand;
//        int i = 0;
        do {
            do {
                rand = (int) (Math.random() * N * N * 2);//0-127
                temp = new Ship(rand % N, rand / N / 2, length, rand % 2 == 0);//rand < N * N);
            } while (!entryShip(rand % N, rand / N / 2, length, rand % 2 == 0, N));//rand < N * N, N));
//            i++;
        } while (!round(temp));// || i < 1000);
        //if (i < 1000) {
            return temp;
/*      } else {
            print();
            return null;
        }
*/
    }

    //Проверка на вхождение коробля в поле
    public boolean entryShip(int x, int y, int length, boolean rotation, int size) {
        if (rotation) {
            if (x + length < size && y < size) {
                return true;
            }
        } else {
            if (x < size && y + length < size) {
                return true;
            }
        }
        return false;
    }

    //Проверка на свободные клетки вокруг коробля. Как уменьшить количество условий???
    public boolean round(Ship ship) {
        if (checkCell(ship.x, ship.y, 'X')) return false; // проверка на наложение
        if (ship.rotation) { //True- горизнтально, False- вертикально
            //Проверка возле первой ячейки
            if (ship.x - 1 >= 0) {
                if (checkCell(ship.x - 1, ship.y, 'X')) return false;
                if (ship.y - 1 >= 0) {
                    if (checkCell(ship.x - 1, ship.y - 1, 'X')) return false;
                }
                if (ship.y + 1 < N) {
                    if (checkCell(ship.x - 1, ship.y + 1, 'X')) return false;
                }
            }
            //Проверка возле средних ячеек
            if (ship.y - 1 >= 0) {
                for (int i = 0; i < ship.length; i++) {
                    if (checkCell(ship.x + i, ship.y - 1, 'X')) return false;
                }
            }
            if (ship.y + 1 < N) {
                for (int i = 0; i < ship.length; i++) {
                    if (checkCell(ship.x + i, ship.y + 1, 'X')) return false;
                }
            }
            //Проверка возле последней ячейки
            if (ship.x + ship.length < N) {
                if (checkCell(ship.x + ship.length, ship.y, 'X')) return false;
                if (ship.y - 1 >= 0) {
                    if (checkCell(ship.x + ship.length, ship.y - 1, 'X')) return false;
                }
                if (ship.y + 1 < N) {
                    if (checkCell(ship.x + ship.length, ship.y + 1, 'X')) return false;
                }
            }
        } else {
            //Проверка возле первой ячейки
            if (ship.y - 1 >= 0) {
                if (checkCell(ship.x, ship.y - 1, 'X')) return false;
                if (ship.x - 1 >= 0) {
                    if (checkCell(ship.x - 1, ship.y - 1, 'X')) return false;
                    for (int i = 0; i < ship.length; i++) {
                        if (checkCell(ship.x - 1, ship.y + i, 'X')) return false;
                    }
                }
                if (ship.x + 1 < N) {
                    if (checkCell(ship.x + 1, ship.y - 1, 'X')) return false;
                    for (int i = 0; i < ship.length; i++) {
                        if (checkCell(ship.x + 1, ship.y + i, 'X')) return false;
                    }
                }
            }
            //Проверка возле средних ячеек
            if (ship.x - 1 >= 0) {
                for (int i = 0; i < ship.length; i++) {
                    if (checkCell(ship.x - 1, ship.y + i, 'X')) return false;
                }
            }
            if (ship.x + 1 < N) {
                for (int i = 0; i < ship.length; i++) {
                    if (checkCell(ship.x + 1, ship.y + i, 'X')) return false;
                }
            }
            //Проверка возле последней ячейки
            if (ship.y + ship.length < N) {
                if (checkCell(ship.x, ship.y + ship.length, 'X')) return false;
                if (ship.x - 1 >= 0) {
                    if (checkCell(ship.x - 1, ship.y + ship.length, 'X')) return false;
                }
                if (ship.x + 1 < N) {
                    if (checkCell(ship.x + 1, ship.y + ship.length, 'X')) return false;
                }
            }
        }

        return true;
    }
}

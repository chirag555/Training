import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

class Game {

    int[][] Construct_Initial_Array() {
        int[][] initialArray = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                //if(((int)(Math.random() * ((100 - 1) + 1)))%2==0 &&((int)(Math.random() * ((100 - 1) + 1)))%3==0 ){
                if (((int) (Math.random() * ((100 - 1) + 1))) % 2 == 0 && ((int) (Math.random() * ((100 - 1) + 1))) % 3 == 0 && ((int) (Math.random() * ((100 - 1) + 1))) % 4 == 0) {
                    //if(((int)(Math.random() * ((100 - 1) + 1)))%2==0){
                    initialArray[i][j] = 1;
                } else {
                    initialArray[i][j] = 0;
                }
            }
        }
        return initialArray;
    }

    int[][] Neighbour_counter(int[][] life_array) {
        int[][] neighbourCounterArray = new int[1000][1000];
        int neighbourInstances = 0;
        int maxNumberOfColumnsAndRows = 1000;
        int leastNumberOfColumnAndRow = 0;
        for (int i = leastNumberOfColumnAndRow; i < maxNumberOfColumnsAndRows; i++) {
            for (int j = leastNumberOfColumnAndRow; j < maxNumberOfColumnsAndRows; j++) {
                neighbourCounterArray[i][j] = 0;
                if (!(i == leastNumberOfColumnAndRow || j == leastNumberOfColumnAndRow || i == maxNumberOfColumnsAndRows - 1 || j == maxNumberOfColumnsAndRows - 1)) {

                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (life_array[x][y] == 1) {
                                neighbourInstances += 1;
                            }
                        }
                        neighbourCounterArray[i][j] = neighbourInstances - 1;
                    }
                    neighbourInstances = 0;
                }
                if (i == leastNumberOfColumnAndRow && j == leastNumberOfColumnAndRow) {
                    if (life_array[i][1] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[1][i] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[1][1] == 1) {
                        neighbourInstances += 1;
                    }
                    neighbourCounterArray[i][j] = neighbourInstances;
                    neighbourInstances = 0;
                }
                if (i == leastNumberOfColumnAndRow && j == maxNumberOfColumnsAndRows - 1) {
                    if (life_array[i][j - 1] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[i + 1][j - 1] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[i + 1][j] == 1) {
                        neighbourInstances += 1;
                    }
                    neighbourCounterArray[i][j] = neighbourInstances;
                    neighbourInstances = 0;
                }
                if (i == maxNumberOfColumnsAndRows - 1 && j == leastNumberOfColumnAndRow) {
                    if (life_array[i - 1][j] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[i - 1][j + 1] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[i][j + 1] == 1) {
                        neighbourInstances += 1;
                    }
                    neighbourCounterArray[i][j] = neighbourInstances;
                    neighbourInstances = 0;

                }
                if (i == maxNumberOfColumnsAndRows - 1 && j == maxNumberOfColumnsAndRows - 1) {
                    if (life_array[i - 1][j] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[i - 1][j - 1] == 1) {
                        neighbourInstances += 1;
                    }
                    if (life_array[i][j - 1] == 1) {
                        neighbourInstances += 1;
                    }
                    neighbourCounterArray[i][j] = neighbourInstances;
                    neighbourInstances = 0;
                }
                if (i == 0 && j > 0 && j < maxNumberOfColumnsAndRows - 1) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (life_array[i][y] == 1) {
                            neighbourInstances += 1;
                        }
                    }
                    neighbourCounterArray[i][j] = neighbourInstances - 1;
                    neighbourInstances = 0;
                }
                if (i == maxNumberOfColumnsAndRows - 1 && j > 0 && j < maxNumberOfColumnsAndRows - 1) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (life_array[i][y] == 1) {
                            neighbourInstances += 1;
                        }
                    }
                    neighbourCounterArray[i][j] = neighbourInstances - 1;
                    neighbourInstances = 0;
                }
            }
        }
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (neighbourCounterArray[i][j] < 2) {
                    neighbourCounterArray[i][j] = 0;
                } else if (neighbourCounterArray[i][j] >= 2 && neighbourCounterArray[i][j] <= 3) {
                    neighbourCounterArray[i][j] = 1;
                } else if (neighbourCounterArray[i][j] > 3) {
                    neighbourCounterArray[i][j] = 0;
                } else if (neighbourCounterArray[i][j] == 3) {
                    neighbourCounterArray[i][j] = 1;
                }
            }
        }
        return neighbourCounterArray;
    }
}

public class Game_Of_Life_with_1000x1000_random_01 extends JApplet {

    final int MAX = 1000;
    Game game = new Game();
    int[][] initialArray = game.Construct_Initial_Array();

    public void paint(Graphics Obj_Graphics) {

        int rowCount;
        int columnCount;
        int xCoordinate, yCoordinate;

        initialArray = game.Neighbour_counter(initialArray);
        for (rowCount = 0; rowCount < MAX; rowCount++) {
            for (columnCount = 0; columnCount < MAX; columnCount++) {
                xCoordinate = columnCount * 1;
                yCoordinate = rowCount * 1;
                if (initialArray[rowCount][columnCount] == 1) {
                    Obj_Graphics.setColor(Color.black);
                } else {
                    Obj_Graphics.setColor(Color.white);
                }
                Obj_Graphics.fillRect(xCoordinate, yCoordinate, 1, 1);
            }
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }
        repaint();

    }

}

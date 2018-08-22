
import java.util.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static public class Boat {
        int row, column;
        static int upperRow,upperColumn;
        int gridSquare[][] = new int[upperRow][upperColumn];
        Boat(int row, int column) {
            this.row = row;
            this.column =column;

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(",");

        Boat.upperRow = Integer.parseInt(s[0]);
        Boat.upperColumn = Integer.parseInt(s[1]);

        int boatsNm = Integer.parseInt(s[2]);

        LinkedHashSet<Boat> hsBoat = new LinkedHashSet<>();

        for (int i = 0; i < boatsNm; i++) {
            String s2[] = bf.readLine().split(",");
            hsBoat.add(new Boat(Integer.parseInt(s2[0]), Integer.parseInt(s2[1])));
        }

        for(Boat boat : hsBoat) {
            if(boat.column >=  Boat.upperColumn  ||  boat.row >=  Boat.upperRow ) {
                System.out.print(0);
                return;
            }
        }
        if(hsBoat.size() ==1 ) {
            System.out.print(0);
        }

        System.out.print(measureDistance(hsBoat,   Boat.upperRow ,Boat.upperColumn));
    }


    public static int measureDistance(LinkedHashSet<Boat> boats, int upperRow, int upperColumn) {
        int output = 0;
        for(int row  = 0; row < upperRow; row++) {
            for(int column = 0; column < upperColumn; column++ ) {

                for(Boat boat : boats) {
                    int weight = findWeight(row, column, boat, 0);
                    boat.gridSquare[row][column] = weight;
                }

                Boat b1 = (Boat) boats.toArray()[0];
                boolean isEqual = true;
                for(Boat boat : boats) {
                    if(b1.gridSquare[row][column] != boat.gridSquare[row][column]) {
                        isEqual = false;
                    }
                }

                if(boats.size() != 1 && isEqual) {
                    output++;
                }
            }
        }
        return output;
    }

    private static int findWeight(int row, int column, Boat boat, int count) {

        if(boat.column == column && boat.row == row) {
            return count;
        }

        if(column >= 0 && row >=0 && boat.column == column && boat.row < row) {
            return findWeight(--row, column, boat, ++count);
        }

        if(column >= 0 && row >=0 && boat.column == column && boat.row > row) {
            return findWeight(++row, column, boat, ++count);
        }

        if(column >=0 && row >=0 && boat.column < column) {
            return findWeight(row, --column, boat, ++count);
        }

        if(column <= boat.upperColumn && row <= boat.upperRow && boat.column == column) {
            return findWeight(++row, column, boat, ++count);
        }
        if(column <= boat.upperColumn && row <= boat.upperRow && boat.column > column) {
            return findWeight(row, ++column, boat, ++count);
        }
        return count;
    }


}
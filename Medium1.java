// Sample Test Case:
//
// Enter size of X: 3
// * * *
//  ***
// *****
//  ***
// * * *

import java.util.*;

class Medium1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of X: ");
        int size = input.nextInt();

        int rows = (size * 2) - 1; 
        int cols = rows;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (
                    (r == size - 1) || 
                    (c == r) ||
                    (c == cols / 2) || 
                    (rows - r - 1 == c)
                ) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        
        input.close();
    }
}
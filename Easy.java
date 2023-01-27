// Sample Test case: 
//
// Enter size of arrow: 5
// *
//   *
//     *
//       *
//         *
//       *
//     *
//   *
// *

import java.util.*;

class Easy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of arrow: ");
        int n = input.nextInt();

        int rows = (n * 2) - 1;
        int cols = rows;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (
                    (c == r * 2) ||
                    (rows * 2 - (r * 2) - 2 == c && r >= n)
                ) {
                    System.out.print("*");
                }
                
                System.out.print(" ");
            }
            System.out.println();
        }
        
        input.close();        
    }
}
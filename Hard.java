// Sample Test Case:
//
// Enter number of positive integers[0-99]: 5
// Enter integers: 1 2 3 2 3

// Least occurring integer: 1
// Most occurring integer: 3

import java.util.*;

class Hard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of positive integers[0-99]: ");
        int n = input.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.print("Enter integers: ");
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }

        // test
        // for (int i : list) {
        //     System.out.print(i);
        // }
        
        int leastCount = 100;
        int leastInt = -1;
        int mostCount = -1;
        int mostInt = -1;

        for (int i : list) {
            int currCount = getCount(i, list);
            if (currCount <= leastCount) {
                leastCount = currCount;
                leastInt = i;
            }
            if (currCount >= mostCount) {
                mostCount = currCount;
                mostInt = i;
            }
        }

        System.out.println("\nLeast occurring integer: " + leastInt);
        System.out.println("Most occurring integer: " + mostInt);
        
        input.close();
    }

    public static int getCount(int n, ArrayList<Integer> list) {
        int count = 0;
        for (int i : list) {
            if (i == n) count++;
        }
        
        return count;
    }
}
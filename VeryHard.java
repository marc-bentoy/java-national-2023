// Sample Test Case:
//
// Enter the number of rows: 4
// Enter the number of columns: 4
// Enter the map:
// DOOY
// DODD
// DODD
// CODD
// Number of steps required = 6

import java.util.*;

class VeryHard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt();
        
        System.out.println("Enter the map: ");
        ArrayList<String> listMap = new ArrayList<String>();
        for (int r = 0; r < rows; r++) {
            listMap.add(input.next());
        }

        // convert from list to char array
        char[][] map = new char[rows][cols];
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                index = r;
                map[r][c] = listMap.get(index).charAt(c);
            }
        }

        // test print
        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
        //         System.out.print(map[r][c]);
        //     }
        //     System.out.println();
        // }

        // process
        int stepsReq = 0;
        boolean hasReached = false;
        // notation
        // 0 - right
        // 1 - up
        // 2 - left
        // 3 - down
        int prevDir = -1;
        int[] currPos = new int[2];
        currPos = getStartPos(map);
        if (currPos[0] == -1 || currPos[1] == -1) {
            System.out.println("No starting point. Failed to start.");
            input.close();
            return;
        }

        int destCount = 0;
        destCount = getDestCount(map);
        if (destCount == 0) {
            System.out.println("Cody cannot find destination.");
            input.close();
            return;
        }
        else if (destCount > 1) {
            System.out.println("Too many destinations.");
            input.close();
            return;
        }
        
        while (!hasReached) {
            // System.out.println("Current steps: " + stepsReq);
            
            boolean canRight = (currPos[1] + 1 < cols) ? true : false;
            boolean canLeft = (currPos[1] - 1 >= 0) ? true : false;
            boolean canUp = (currPos[0] - 1 >= 0) ? true : false;
            boolean canDown = (currPos[0] + 1 < rows) ? true : false;
            // System.out.println("Can right: " + canRight);
            // System.out.println("Can up: " + canUp);
            // System.out.println("Can left: " + canLeft);
            // System.out.println("Can down: " + canDown);
            
            if (map[currPos[0]][currPos[1]] == 'Y') {
                hasReached = true;
                stepsReq++;
                break;
            } 

            // to right
            if (canRight && prevDir != 2) {
                char val = map[currPos[0]][currPos[1] + 1];
                if (val == 'Y') {
                    hasReached = true;
                    stepsReq++;
                    break;
                }
                if (val == 'O') {
                    currPos[1]++;
                    prevDir = 0;
                    stepsReq++;
                    // System.out.println("Entered right");
                    continue;
                }
            }

            // to up
            if (canUp && prevDir != 3) {
                char val = map[currPos[0] - 1][currPos[1]];
                if (val == 'Y') {
                    hasReached = true;
                    stepsReq++;
                    break;
                }
                if (val == 'O') {
                    currPos[0]--;
                    prevDir = 1;
                    stepsReq++;
                    // System.out.println("Entered up");
                    continue;
                }
            }

            // to left
            if (canLeft && prevDir != 0) {
                char val = map[currPos[0]][currPos[1] - 1];
                if (val == 'Y') {
                    hasReached = true;
                    stepsReq++;
                    break;
                }
                if (val == 'O') {
                    currPos[1]--;
                    prevDir = 2;
                    stepsReq++;
                    // System.out.println("Entered left");
                    continue;
                }
            }

            // to down
            if (canDown && prevDir != 1) {
                char val = map[currPos[0] + 1][currPos[1]];
                if (val == 'Y') {
                    hasReached = true;
                    stepsReq++;
                    break;
                }
                if (val == 'O') {
                    currPos[0]++;
                    prevDir = 3;
                    stepsReq++;
                    // System.out.println("Entered down");
                    continue;
                }
            }
        }

        System.out.print("Number of steps required = " + stepsReq);
        
        input.close();
    }

    public static int[] getStartPos(char[][] map) {
        int[] startPos = new int[2];

        startPos[0] = -1;
        startPos[1] = -1;

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 'C') {
                    startPos[0] = r;
                    startPos[1] = c;
                    break;
                }
            }
        }

        return startPos;
    }

    public static int getDestCount(char[][] map) {
        int destCount = 0;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == 'Y') {
                    destCount++;
                }
            }
        }

        return destCount;
    }
}
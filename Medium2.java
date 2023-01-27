// Sample Test Case
//
// Enter serial number: 3AB320S2
// Enter height of barcode: 5
// |||..|||||.||
// |||..|||||.||
// |||..|||||.||
// |||..|||||.||
// |||..|||||.||

import java.util.*;

class Medium2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter serial number: ");
        String sn = input.nextLine();

        System.out.print("Enter height of barcode: ");
        int height = input.nextInt();

        int length = getLength(sn);
        // System.out.println("Length: " + length);
        
        if (length > 13) {
            System.out.print("Invalid Serial Number.");
            input.close();
            return;
        }

        int lack = 0;
        if (length < 13) {
            lack = 13 - length;
        }

        for (int h = 0; h < height; h++) {
            for (int i = 0; i < sn.length(); i++) {
                if (!isDigit(sn.charAt(i))) {
                    System.out.print(".");
                    continue;
                }
                int currNum = sn.charAt(i) - '0';
                for (int a = 1; a <= currNum; a++) {
                    System.out.print("|");
                }
            }   
            for (int l = 1; l <= lack; l++) {
                System.out.print("|");
            }
            System.out.println();
        }
        
        input.close();
    }

    public static boolean isDigit(char c) {
        String digits = "0123456789";
        for (int i = 0; i < digits.length(); i++) {
            if (c == digits.charAt(i)) return true;
        }
        return false;
    }

    public static int getLength(String sn) {
        int length = 0;

        for (int i = 0; i < sn.length(); i++) {
            if (isDigit(sn.charAt(i))) {
                int value = sn.charAt(i) - '0';
                length += value;
            }
            else length++;
        }
        
        return length;
    }
}
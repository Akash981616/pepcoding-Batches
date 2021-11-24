import java.util.Scanner;

public class l001 {

    // nsp : no of spaces, nst = no of stars
    // csp = count of space, cst = count of star
    public static void pattern0(int n) {
        int nsp = n, nst = n;
        for (int r = 1; r <= n; r++) {
            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nsp += 0;
            nst += 0;
            System.out.println();
        }

    }

    public static void pattern1(int n) {
        int nsp = 0, nst = 1;
        for (int r = 1; r <= n; r++) {
            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nst++;
            System.out.println();
        }

    }

    public static void pattern2(int n) {
        int nsp = 0, nst = n;
        for (int r = 1; r <= n; r++) {

            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nst--;
            System.out.println();
        }

    }

    public static void pattern3(int n) {
        int nsp = n - 1, nst = 1;
        for (int r = 1; r <= n; r++) {
            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nsp--;
            nst++;
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        int nsp = 0, nst = n;
        for (int r = 1; r <= n; r++) {

            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nsp++;
            nst--;
            System.out.println();
        }
    }

    public static void extraPattern_01(int n) {
        int nsp = n - 1, nst = 1;
        for (int r = 1; r <= n; r++) {

            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nsp--;
            nst += 2;
            System.out.println();
        }
    }

    public static void extraPattern_02(int n) {
        int nsp = 0, nst = 2 * n - 1;
        for (int r = 1; r <= n; r++) {

            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            nsp++;
            nst -= 2;
            System.out.println();
        }

    }

    public static void pattern5_diamond(int n) {
        if (n % 2 == 0)
            n++;
        int nsp = n / 2, nst = 1;
        for (int r = 1; r <= n; r++) {

            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            if (r <= n / 2) {
                nsp--;
                nst += 2;
            } else {
                nsp++;
                nst -= 2;
            }
            System.out.println();
        }
    }

    public static void pattern6_HollowDiamond(int n) {
        if (n % 2 == 0)
            n++;
        int nsp = 1, nst = (n / 2 + 1);
        for (int r = 1; r <= n; r++) {

            // stars
            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            // spaces
            for (int csp = 1; csp <= nsp; csp++)
                System.out.print("\t");

            // stars
            for (int cst = 1; cst <= nst; cst++)
                System.out.print("*\t");

            if (r <= n / 2) {
                nst--;
                nsp += 2;
            } else {
                nst++;
                nsp -= 2;
            }
            System.out.println();
        }
    }

    public static void printMatrix(int rows) {
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= rows; c++) {
                System.out.print(r + "" + c + " ");
            }
            System.out.println();
        }
    }

    public static void pattern7(int rows) {
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= rows; c++) {
                if (r == c)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void pattern8(int rows) {
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= rows; c++) {
                if (r + c == rows + 1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void pattern9(int rows) {
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= rows; c++) {
                // ????
                if (r + c == rows + 1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void pattern10(int rows) {
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= rows; c++) {
                // ????
                if (r + c == rows + 1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern6_HollowDiamond(n);
    }
}
import java.util.*;

public class l004_Queen {

    // tnq : total no of queens, qpsf : queen placed so far
    public static int queenCombination1D(boolean[] boxes, int tnq, int bno, int qpsf, String psf) {
        if (qpsf == tnq) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int bidx = bno; bidx < boxes.length; bidx++) {
            count += queenCombination1D(boxes, tnq, bidx + 1, qpsf + 1, psf + "b" + bidx + "q" + qpsf + " ");
        }
        return count;
    }

    public static int queenPermutation1D(boolean[] boxes, int tnq, int qpsf, String psf) {
        if (qpsf == tnq) {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int bidx = 0; bidx < boxes.length; bidx++) {
            if (!boxes[bidx]) {
                boxes[bidx] = true;
                count += queenPermutation1D(boxes, tnq, qpsf + 1, psf + "b" + bidx + "q" + qpsf + " ");
                boxes[bidx] = false;
            }
        }
        return count;
    }

    public static int queenCombination2D(boolean[][] boxes, int tnq, int bno, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = bno; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            count += queenCombination2D(boxes, tnq - 1, bidx + 1, psf + "(" + r + "," + c + ") ");
        }
        return count;
    }

    public static int queenPermutation2D(boolean[][] boxes, int tnq, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = 0; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (!boxes[r][c]) {
                boxes[r][c] = true;
                count += queenPermutation2D(boxes, tnq - 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    // NQueen================================================================================

    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        int n = boxes.length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (boxes[x][y])
                        return false;
                } else
                    break;
            }
        }
        return true;
    }

    public static int nqueen_01(boolean[][] boxes, int tnq, int bno, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = bno; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_01(boxes, tnq - 1, bidx + 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    public static int nqueen_01_Perm(boolean[][] boxes, int tnq, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = 0; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (!boxes[r][c] && isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_01_Perm(boxes, tnq - 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    // Sudoku

    private boolean isPossibleToPlaceNumber(char[][] board, int r, int c, int num) {

        // row
        for (int i = 0; i < 9; i++) {
            if (board[i][c] - '0' == num)
                return false;
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (board[r][i] - '0' == num)
                return false;
        }

        // 3 X 3
        r = (r / 3) * 3;
        c = (c / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[r + i][c + j] - '0' == num)
                    return false;

        return true;

    }

    public boolean sudokuSolver(char[][] board, ArrayList<Integer> list, int idx) {
        if (idx == list.size())
            return true;

        int r = list.get(idx) / 9;
        int c = list.get(idx) % 9;

        for (int num = 1; num <= 9; num++) {
            if (isPossibleToPlaceNumber(board, r, c, num)) {
                board[r][c] = (char) ('0' + num);

                if (sudokuSolver(board, list, idx + 1))
                    return true;

                board[r][c] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        ArrayList<Integer> list = new ArrayList<>(); // blank places
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    list.add(i * n + j);
                }
            }
        }
    }

    // 139 : word break
    public boolean wordBreak(String str, String asf, HashSet<String> set) {
        if (str.length() == 0) {
            System.out.println(asf);
            return true;
        }
        for (int len = 1; len <= str.length(); len++) {
            String smallStr = str.substring(0, len);
            if (set.contains(smallStr)) {
                if (wordBreak(str.substring(len), asf + smallStr + " ", set))
                    return true;
            }
        }

        return false;
    }

    public boolean wordBreak(String str, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String s : wordDict)
            set.add(s);

        return wordBreak(str, "", set);
    }

    // crypto
    static String str1 = "send", str2 = "more", str3 = "money";
    static boolean[] isNumUsed = new boolean[10];
    static int[] mapping = new int[26];

    public static void crypto() {
        String str = str1 + str2 + str3;
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        str = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                str += (char) (i + 'a');
        }

        if (str.length() > 10)
            return;

        System.out.println(crypto(str, 0));
    }

    private static int stringToNumber(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            res = res * 10 + mapping[ch - 'a'];
        }

        return res;
    }

    private static boolean isValidMapping() {
        if (mapping[str1.charAt(0) - 'a'] == 0 || mapping[str2.charAt(0) - 'a'] == 0
                || mapping[str3.charAt(0) - 'a'] == 0)
            return false;

        int num1 = stringToNumber(str1);
        int num2 = stringToNumber(str2);
        int num3 = stringToNumber(str3);

        return num1 + num2 == num3;
    }

    public static int crypto(String str, int idx) {
        if (idx == str.length()) {
            if (isValidMapping()) {
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    System.out.print(ch + "=" + mapping[ch - 'a'] + ", ");
                }
                System.out.println();
                return 1;
            }

            return 0;
        }

        int count = 0;
        char ch = str.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (!isNumUsed[num]) {
                isNumUsed[num] = true;
                mapping[ch - 'a'] = num;

                count += crypto(str, idx + 1);

                mapping[ch - 'a'] = 0;
                isNumUsed[num] = false;
            }

        }

        return count;
    }

    public static void main(String... args) {
        // System.out.println(queenCombination1D(boxes, 3, 0, 0, ""));
        // System.out.println(queenPermutation1D(boxes, 3, 0, ""));
        boolean[][] boxes = new boolean[4][4];
        // System.out.println(queenCombination2D(boxes, 4, 0, ""));
        // System.out.println(queenPermutation2D(boxes, 4, ""));

        // System.out.println(nqueen_01(boxes, 4, 0, ""));
        // System.out.println(nqueen_01_Perm(boxes, 4, ""));
        crypto();
    }

}
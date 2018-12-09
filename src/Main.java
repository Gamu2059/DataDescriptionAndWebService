public class Main {

    public static void main(String[] args) {
        int[][] a = new int[][]{
            {1, 2, 0},
            {2, 3, 5},
            {0, 4, 7},
        };
        int[][] b = new int[][]{
                {3, 5, 2},
                {4, 7, 3},
                {2, 0, 4},
        };
        int[][] t = new int[][]{
                {2, 4, 1},
                {3, 7, 0},
                {1, 0, 4},
        };

        System.out.println("A SAD : " + sad(a, t));
        System.out.println("B SAD : " + sad(b, t));
        System.out.println("A SSD : " + ssd(a, t));
        System.out.println("B SSD : " + ssd(b, t));
        System.out.println("A NCC : " + ncc(a, t));
        System.out.println("B NCC : " + ncc(b, t));
    }

    private static double sad(int[][] i, int[][] t) {
        double sum = 0;
        for (int y=0;y<3;y++) {
            for (int x=0;x<3;x++) {
                sum += Math.abs(i[y][x] - t[y][x]);
            }
        }
        return sum;
    }

    private static double ssd(int[][] i, int[][] t) {
        double sum = 0;
        for (int y=0;y<3;y++) {
            for (int x=0;x<3;x++) {
                sum += Math.pow(i[y][x] - t[y][x],2f);
            }
        }
        return sum;
    }

    private static double ncc(int[][] i, int[][] t) {
        double iSum, tSum, sum;
        iSum = tSum = sum = 0;

        for (int y=0;y<3;y++) {
            for (int x=0;x<3;x++) {
                iSum += Math.pow(i[y][x],2);
                tSum += Math.pow(t[y][x],2);
                sum += i[y][x] * t[y][x];
            }
        }
        return sum / Math.sqrt(iSum * tSum);
    }
}

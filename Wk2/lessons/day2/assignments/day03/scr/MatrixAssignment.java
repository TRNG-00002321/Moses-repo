public class MatrixAssignment {

    // Print a 2D Array: Write a program to initialize and print the elements of a given 2D integer array (matrix).
    public static void printElements(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Sum of Elements: Calculate the sum of all elements in a 2D array.
    public static int sumElements(int[][] b){
        int sum = 0;
        for (int i = 0; i <b.length; i++){
            for (int j = 0; j < b[i].length; j++){
                sum += b[i][j];
            }
        }
        return sum;
    }

    // Find Maximum/Minimum: Find the maximum or minimum element within a 2D array.
    public static int minElement(int[][] b){
        int min = b[0][0];
        for(int i = 0; i<b.length; i++){
            for(int j = 0; j<b[i].length; j++){
                if (b[i][j] < min) {
                    min = b[i][j];
                }
            }
        }
        return min;
    }

    // Row/Column Sums: Calculate the sum of elements for each individual row and each individual column in a 2D array
    public static int[] rCSum(int[][] b){
        int[] r= new int[b.length];
        for(int i = 0; i<b.length; i++){
            int rSum = 0;
            for(int j = 0; j<b[i].length; j++){
                    rSum += b[i][j];
            }
            r[i] = rSum;
        }
        return r;
    }

    // Transpose Matrix: Given a matrix, find its transpose (swap rows and columns)

    // Matrix Addition: Add two matrices of the same dimensions.
    public static int[][] AddMetrix(int[][] a, int[][] b){
        int[][] result = new int[a.length][a[0].length];
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }


// Main Program

    public static void main(String[] args) {
        int[][] items = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 4, 5, 6},
                {42, 41, 3, 88, 66, 34}
            };
        printElements(items);
        System.out.println(sumElements(items));
        System.out.println(minElement(items));
        int[] result = rCSum(items);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println(minElement(items));

    }

}


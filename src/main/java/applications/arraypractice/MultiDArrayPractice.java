package applications.arraypractice;

public class MultiDArrayPractice {
    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Example I:");
        int[][] a = new int[2][5];
        printArray(a);
        System.out.println("Example II:");
        int[][] b = new int[2][];
        printArray(b);
        System.out.println("Example III:");
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
    }

    public int[] DiagonalTraverse(int [][] mat){
        // TODO: Come back and look at this later, works, but not sure i fully understand yet

        if(mat.length == 0){
            return new int[0];
        }

        int matrixLength = mat.length;
        int arrayLength = mat[0].length;
        int row = 0;
        int column = 0;
        int[] resultArray = new int[matrixLength * arrayLength];
        int resultLength = resultArray.length;

        for (int i = 0; i < resultLength; i++) {
            resultArray[i] = mat[row][column];
            // Now update the row and column based on the traversing
            if((row + column) % 2 == 0){ // Its even
                if(column == arrayLength - 1){
                    row++;
                } else if(row == 0){
                    column++;
                } else{
                    row--;
                    column++;
                }
            }else{
                if(row == matrixLength - 1){
                    column++;
                } else if(column == 0){
                    row++;
                } else{
                    row++;
                    column--;
                }
            }
        }

        return resultArray;


    }


}

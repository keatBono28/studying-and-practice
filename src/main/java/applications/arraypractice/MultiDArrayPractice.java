package applications.arraypractice;

import java.util.ArrayList;
import java.util.List;

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

    /**
     *  Just committing my first try, then the actual solution, then a third method with notes
     *  and thoughts to help explain how to find the solution
     *
     */

    public List<Integer> spiralOrder(int[][] matrix){
        /*
        *  This was my first attempt without help... it failed and was bad
        * */

        if(matrix.length == 0){
            return new ArrayList<>();
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int currentRow = 0;
        int currentColumn = 0;

        List<Integer> resultList = new ArrayList<>();

        int rowTimesColumn = columnCount * rowCount;

        for (int i = 0; i < rowTimesColumn ; i++) {
            resultList.add(matrix[currentRow][currentColumn]);
            if(currentColumn < columnCount && (rowCount - currentRow) != 0){
                currentColumn++;
            } else if(currentColumn == columnCount){
                currentRow++;
            } else if(currentRow == rowCount){
                currentColumn--;
            } else{
                break;
            }
        }

        return null;
    }

    public List<Integer> spiral(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int rowBegin = 0, columnBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && columnBegin <= columnEnd){
            for (int i = columnBegin; i <= columnEnd ; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd ; i++) {
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            if(rowBegin <= rowEnd){
                for (int i = columnEnd; i >= columnBegin ; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(columnBegin <= columnEnd){
                for (int i = rowEnd; i >= rowBegin ; i--) {
                    result.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;
        }
        return result;
    }

    public List<Integer> spiralTraversingPractice(int[][] matrix){
        // First make a list to return the result, we can't alter the existing matrix
        List<Integer> result = new ArrayList<>();

        // Now we need to make a few variables,
        // Lets find the beginning row and beginning column, we know they will be 0,0
        int rowBegin = 0, columnBegin = 0;
        // Now we need to find where the row and columns end, sort of like finding a grid system
        /* Putting this here so i can see a visual
        *
           [[ 1 , 2 , 3 , 4 ],
        *   [ 5 , 6 , 7 , 8 ],
        *   [ 9 , 5 , 1 , 3 ]]
        *
        */
        int rowEnd = matrix.length - 1;
        int columnEnd = matrix[0].length - 1;

        // Now we a while loop to start traversing
        // lets set our boundaries, we know that once these become false, then we 
        // have reached the center of the matrix spiral
        while(rowBegin <= rowEnd && columnBegin <= columnEnd){
            // Step 1 - go across the first row
            // use columnBegin and columnEnd to go across
            for (int i = columnBegin; i <= columnEnd ; i++) {
                // Now add the first row to the end result
                result.add(matrix[rowBegin][i]);
            }
            // Now we went across the first row, and we need to "eliminate" that row
            // basically meaning, increase rowBegin because we already used it, so next time we
            // get to the row, it will be on the next row
            rowBegin++;
            
            // Step 2 - Now we need to go down the last column
            // use the rowBegin and rowEnd to start
            for (int i = rowBegin; i < rowEnd ; i++) {
                // Now add the last column to the result
                result.add(matrix[i][columnEnd]);
            }
            // Now that we went down the last column, we need to "eliminate" that column
            // basically meaning, decrease the columnEnd beause we already used it, so next time we
            // get to the end boundry, we have the next column
            columnEnd--;

            // Step 3 - Now that we are at the bottom corner of the matrix, we need to iterate backwards
            // on that bottom row, back to the beginning column
            if(rowBegin <= rowEnd){
                // Now iterate backwards, using the columnEnd and move towards columnBegin
                for (int i = columnEnd; i >= columnBegin ; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            // Now that we iterated backwards through the last available row, we need to decrease the
            // value of the rowEnd
            rowEnd--;

            // Step 4 - Now that we are back at the beginning column, we need to go up
            //
            if(columnBegin <= columnEnd){
                for (int i = rowEnd; i >= rowBegin ; i--) {
                    result.add(matrix[i][columnBegin]);
                }
            }
            // Now that we went up the beginning column, we need to increase it
            columnBegin++;

            // Now we have done a full "circle", if the boundaries above are still true, we will loop back through
            // the next spiral
        }
        return result;
    }

































}

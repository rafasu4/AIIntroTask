import java.util.*;

public class Ex1 {

    //actions costs
    int move = 5;
    static int EMPTY_TILE = -1;

   static void swapArray(int[] a1, int[] a2, int j){
        int swap = a1[j];
        a1[j] = a2[j];
        a2[j] = swap;
    }

    static void copyTwoDimArray(int[][] arr, int[][] copy){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
    }

    static void swapInRow(int[] arr, int i, int j){
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }




    static void expand(Queue<int[][]> q, int[][] mat, int n, int m){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                //if an empty tile has found - insert each operation
                if(mat[i][j] == EMPTY_TILE){
                    //if not in the edges of the mat - move the empty tile up and down
                    if(i > 0 && i < n - 1){
                        //moving up
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        int[] upperRow = temp[i-1];
                        swapArray(currentRow, upperRow, j);
                        q.add(temp);
                        //moving down
                        temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        currentRow = temp[i];
                        int[] lowerRow = temp[i+1];
                        swapArray(currentRow, lowerRow, j);
                        q.add(temp);
                    }
                    //moving up
                    else if(i > 0){
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        int[] upperRow = temp[i-1];
                        swapArray(currentRow, upperRow, j);
                        q.add(temp);
                    }
                    //moving down
                    else if( i < n-1){
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        int[] lowerRow = temp[i+1];
                        swapArray(currentRow, lowerRow, j);
                        q.add(temp);
                    }
                    //if not in the edges of the mat - move the empty tile left and right
                    if(j>0 && j < n - 1){
                        //moving left
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        swapInRow(currentRow, j, j-1);
                        q.add(temp);
                        //moving right
                        temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        currentRow = temp[i];
                        swapInRow(currentRow, j, j+1);
                        q.add(temp);
                    }
                    else if(j>0){
                        //moving left
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        swapInRow(currentRow, j, j-1);
                        q.add(temp);
                    }
                    else if(j < n - 1){
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        swapInRow(currentRow, j, j+1);
                        q.add(temp);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
       int[] arr1 ={1, 2, 3};
        int[][] mat = { {-1, 2, 3 },
                        {4, 1, 6},
                        {7, 8, 9}};
        Queue<int[][]> q = new LinkedList<>();
        expand(q, mat, 3, 3);

//        Queue<int[][]> q = new LinkedList<>();
//        expand(q, mat, 1, 3);
//        for (int i = 0; i < 1; i++) {
//            System.out.println(Arrays.toString(mat[i]));
//        }
//        System.out.println('\n');
        for (int[][] arr:q) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println('\n');
        }
//    }

//    void BFS(int[][] start, int[][] goal){
//        int counter = 0; //holds the cost from start to goal
//        Queue<Vector<Integer>> toExpand = new LinkedList<>(); //holds the node to expand
//        Hashtable<Vector<Integer>, Integer> openList = new Hashtable<>();
//        Hashtable<Vector<Integer>, Integer> visited = new Hashtable<>();
//        toExpand.add(start);
//        openList.put(start, 1);
//        while(!toExpand.isEmpty()){
//            Vector<Integer> current = toExpand.poll();
//            visited.put(current, 1);
//        }
    }



}

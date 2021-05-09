import java.util.*;

public class Ex1 {

    //actions costs
    static int EMPTY_TILE = -1;

    /*Switches in the same index of two arrays.*/
   static void swapArray(int[] a1, int[] a2, int j){
        int swap = a1[j];
        a1[j] = a2[j];
        a2[j] = swap;
    }
    /*Deep copy of two arrays.*/
    static void copyTwoDimArray(int[][] arr, int[][] copy){
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, arr[0].length);
        }
    }
    /*Swaps tow indexes in given array.*/
    static void swapInRow(int[] arr, int i, int j){
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    static int cost(int x){
        return x +=5;
    }


    /*Expand current state to every possible node.*/
    static void expand(Queue<int[][]> q, Hashtable<String, Integer> openList, Hashtable<String, Integer> closeList, int[][] mat, int n, int m, int counter){
        boolean flag = false;//tells whether the tile has founded
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                //if an empty tile has found - insert each operation
                if(mat[i][j] == EMPTY_TILE){
                    //if not in the edges of the mat - move the empty tile up and down
                    if(i > 0 && i < n - 1){
                        int[][] temp = new int[n][m];
                        //moving up
                        copyTwoDimArray(mat, temp);//copy the original state
                        int[] currentRow = temp[i];//pointer to row
                        int[] upperRow = temp[i-1];//pointer to prev row
                        swapArray(currentRow, upperRow, j);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter = cost(5);
                        }
                        //moving down
                        temp = new int[n][m];
                        copyTwoDimArray(mat, temp);//copy the original state
                        currentRow = temp[i];//pointer to row
                        int[] lowerRow = temp[i+1];//pointer to the next row
                        swapArray(currentRow, lowerRow, j);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter = cost(5);
                        }
                    }
                    //moving up
                    else if(i > 0){
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];//pointer to row
                        int[] upperRow = temp[i-1];//pointer to the prev row
                        swapArray(currentRow, upperRow, j);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter = cost(5);
                        }
                    }
                    //moving down
                    else if( i < n-1){
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        int[] lowerRow = temp[i+1];
                        swapArray(currentRow, lowerRow, j);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter = cost(5);
                        }
                    }
                    //if not in the edges of the mat - move the empty tile left and right
                    if(j>0 && j < m - 1){
                        //moving left
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        swapInRow(currentRow, j, j-1);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter = cost(5);
                        }
                        //moving right
                        temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        currentRow = temp[i];
                        swapInRow(currentRow, j, j+1);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter = cost(5);
                        }
                    }
                    else if(j>0){
                        //moving left
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        swapInRow(currentRow, j, j-1);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter+=5;
                        }
                    }
                    //move right
                    else if(j < m - 1){
                        int[][] temp = new int[n][m];
                        copyTwoDimArray(mat, temp);
                        int[] currentRow = temp[i];
                        swapInRow(currentRow, j, j+1);
                        //if the new state isn't in the open list(not created yet) and not in the close list(wasn't expanded already)
                        if(!openList.containsKey(Arrays.deepToString(temp)) && !closeList.containsKey(Arrays.deepToString(temp))){
                            q.add(temp);
                            openList.put(Arrays.deepToString(temp), 1);
                            counter+=5;
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if(flag){break;}//if one tile has founded - exit function
        }
    }



        static boolean BFS(int[][] start, int[][] goal) {
            int counter = 0; //holds the cost from start to goal
            Queue<int[][]> toExpand = new LinkedList<>(); //holds the node to expand
            Hashtable<String, Integer> openList = new Hashtable<>();
            Hashtable<String, Integer> closeLeast = new Hashtable<>();
            toExpand.add(start);
            openList.put(Arrays.deepToString(start), 1);
            while (!toExpand.isEmpty()) {
                int[][] current = toExpand.poll();
                openList.remove(Arrays.deepToString(current));
                closeLeast.put(Arrays.deepToString(current), 1);
                if(Arrays.deepEquals(current, goal)){
                    return true;
                }
                expand(toExpand, openList, closeLeast, current, current.length, current[0].length, counter );
            }
            return false;

        }

    public static void main(String[] args) {
        int[][] mat ={{1,2,3,4},
                      {5,6,11,7},
                        {9,10,8,-1}};
        int[][] goal = {{1,2,3,4},
                        {5,6,7,8},
                      {9,10,11,-1}};
        long startTime = System.currentTimeMillis();

        System.out.println(BFS(mat, goal ));

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime)*0.001 + " seconds");



    }



}

package leetcode.bfs;

import java.util.*;

public class MapOfHighestPeak {
    int[] dx = {0, 0, 1, -1}; // Horizontal movement: right, left, down, up
    int[] dy = {1, -1, 0, 0}; // Vertical movement corresponding to dx
    int n, m;

    public int[][] highestPeak(int[][] a) {
        n = a.length;
        m = a[0].length;
        int[][] res = new int[n][m];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        // Add all water cells to the queue and set their height to 0
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }
        int hNextLayer = 1;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; ++i) {
                int[] currentCell = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int neighborX = currentCell[0] + dx[d];
                    int neighborY = currentCell[1] + dy[d];

                    // Check if the neighbor is valid and unprocessed
                    if (
                            isValidCell(neighborX, neighborY, n, m) &&
                                    res[neighborX][neighborY] == -1
                    ) {
                        res[neighborX][neighborY] = hNextLayer;
                        queue.add(new int[]{neighborX, neighborY});
                    }
                }            }
            hNextLayer++;
        }
        return res;
    }


    // Function to check if a cell is within the grid boundaries
    private boolean isValidCell(int x, int y, int rows, int columns) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }

    private void updateResult(int[][] a, Queue<int[]> queue, int hNextLayer) {
        int[] currentCell = queue.poll();
        // Check all four possible directions for neighboring cells
        for (int d = 0; d < 4; d++) {
            int neighborX = currentCell[0] + dx[d];
            int neighborY = currentCell[1] + dy[d];

            // Check if the neighbor is valid and unprocessed
            if (
                    isValidCell(neighborX, neighborY, n, m) &&
                            a[neighborX][neighborY] == -1
            ) {
                a[neighborX][neighborY] = hNextLayer;
                queue.add(new int[]{neighborX, neighborY});
            }
        }
    }

}

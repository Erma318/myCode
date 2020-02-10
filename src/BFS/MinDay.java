package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDay {
    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        int day = -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] ifUpdated = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                    ifUpdated[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < columns) {
                        if (ifUpdated[x][y] == 0) {
                            queue.add(new int[]{x, y});
                            ifUpdated[x][y] = 1;
                        }
                    }
                }
            }
            day++;
        }
        return day;
    }
}

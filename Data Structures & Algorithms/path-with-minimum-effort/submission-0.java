class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
                int[][] effort = new int[rows][cols];
                        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
                                effort[0][0] = 0;

                                        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
                                                heap.offer(new int[]{0, 0, 0});
                                                        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                                                                while (!heap.isEmpty()) {
                                                                            int[] current = heap.poll();
                                                                                        int r = current[0], c = current[1], e = current[2];
                                                                                                    if (r == rows - 1 && c == cols - 1) return e;
                                                                                                                if (e > effort[r][c]) continue;

                                                                                                                            for (int[] dir : directions) {
                                                                                                                                            int nr = r + dir[0], nc = c + dir[1];
                                                                                                                                                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                                                                                                                                                                                int newEffort = Math.max(e, Math.abs(heights[nr][nc] - heights[r][c]));
                                                                                                                                                                                                    if (newEffort < effort[nr][nc]) {
                                                                                                                                                                                                                            effort[nr][nc] = newEffort;
                                                                                                                                                                                                                                                    heap.offer(new int[]{nr, nc, newEffort});
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                    return 0;
    }
}
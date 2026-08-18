class Solution {
    public void islandsAndTreasure(int[][]rooms) {
        int rows = rooms.length, cols = rooms[0].length;
                Queue<int[]> queue = new LinkedList<>();

                        for (int r = 0; r < rows; r++) {
                                    for (int c = 0; c < cols; c++) {
                                                    if (rooms[r][c] == 0) queue.offer(new int[]{r, c});
                                                                }
                                                                        }

                                                                                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                                                                                        while (!queue.isEmpty()) {
                                                                                                    int[] current = queue.poll();
                                                                                                                for (int[] dir : directions) {
                                                                                                                                int nr = current[0] + dir[0], nc = current[1] + dir[1];
                                                                                                                                                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && rooms[nr][nc] == Integer.MAX_VALUE) {
                                                                                                                                                                    rooms[nr][nc] = rooms[current[0]][current[1]] + 1;
                                                                                                                                                                                        queue.offer(new int[]{nr, nc});
    }
}
                                                                                        }
    }
}
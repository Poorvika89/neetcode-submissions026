class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
                int[] parent = new int[n];
                        for (int i = 0; i < n; i++) parent[i] = i;

                                for (int[] edge : edges) {
                                            int root1 = findRoot(parent, edge[0]);
                                                        int root2 = findRoot(parent, edge[1]);
                                                                    if (root1 == root2) return false;
                                                                                parent[root1] = root2;
                                                                                        }
                                                                                                return true;
                                                                                                    }

                                                                                                        private int findRoot(int[] parent, int x) {
                                                                                                                while (parent[x] != x) {
                                                                                                                            parent[x] = parent[parent[x]];
                                                                                                                                        x = parent[x];
                                                                                                                                                }
                                                                                                                                                        return x;

    }
}

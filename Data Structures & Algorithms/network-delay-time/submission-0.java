class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
                for (int[] time : times) {
                            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
                                    }

                                            int[] dist = new int[n + 1];
                                                    Arrays.fill(dist, Integer.MAX_VALUE);
                                                            dist[k] = 0;

                                                                    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
                                                                            heap.offer(new int[]{k, 0});

                                                                                    while (!heap.isEmpty()) {
                                                                                                int[] current = heap.poll();
                                                                                                            int node = current[0], time = current[1];
                                                                                                                        if (time > dist[node]) continue;

                                                                                                                                    for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                                                                                                                                                    int next = neighbor[0], weight = neighbor[1];
                                                                                                                                                                    if (dist[node] + weight < dist[next]) {
                                                                                                                                                                                        dist[next] = dist[node] + weight;
                                                                                                                                                                                                            heap.offer(new int[]{next, dist[next]});
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                        int maxTime = 0;
                                                                                                                                                                                                                                                                for (int i = 1; i <= n; i++) {
                                                                                                                                                                                                                                                                            if (dist[i] == Integer.MAX_VALUE) return -1;
                                                                                                                                                                                                                                                                                        maxTime = Math.max(maxTime, dist[i]);
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                        return maxTime;
    }
}

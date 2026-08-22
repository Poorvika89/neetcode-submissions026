class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
                for (int i = 0; i < equations.size(); i++) {
                            String a = equations.get(i).get(0);
                                        String b = equations.get(i).get(1);
                                                    graph.putIfAbsent(a, new HashMap<>());
                                                                graph.putIfAbsent(b, new HashMap<>());
                                                                            graph.get(a).put(b, values[i]);
                                                                                        graph.get(b).put(a, 1.0 / values[i]);
                                                                                                }

                                                                                                        double[] result = new double[queries.size()];
                                                                                                                for (int i = 0; i < queries.size(); i++) {
                                                                                                                            String start = queries.get(i).get(0);
                                                                                                                                        String end = queries.get(i).get(1);
                                                                                                                                                    if (!graph.containsKey(start) || !graph.containsKey(end)) {
                                                                                                                                                                    result[i] = -1.0;
                                                                                                                                                                                } else {
                                                                                                                                                                                                Set<String> visited = new HashSet<>();
                                                                                                                                                                                                                result[i] = dfsDivision(graph, start, end, 1.0, visited);
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            return result;
                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                    private double dfsDivision(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
                                                                                                                                                                                                                                                            if (current.equals(target)) return product;
                                                                                                                                                                                                                                                                    visited.add(current);
                                                                                                                                                                                                                                                                            for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
                                                                                                                                                                                                                                                                                        if (!visited.contains(neighbor.getKey())) {
                                                                                                                                                                                                                                                                                                        double result = dfsDivision(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
                                                                                                                                                                                                                                                                                                                        if (result != -1.0) return result;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                    return -1.0;
    }
}
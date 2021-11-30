class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Connection>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Connection(succProb[i], e[1]));
            graph.get(e[1]).add(new Connection(succProb[i], e[0]));
        }
        PriorityQueue<Connection> pq = new PriorityQueue<>();
        double[] curProb = new double[n];
        curProb[start] = 1;
        pq.offer(new Connection(1, start));

        while (!pq.isEmpty()) {
            Connection c = pq.poll();
            int node = c.node;
            double prob = c.prob;

            if (prob < curProb[node]) {
                continue;
            }

            for (Connection toOther : graph.get(node)) {
                double toOtherProb = toOther.prob * prob;
                if (toOtherProb > curProb[toOther.node]) {
                    curProb[toOther.node] = toOtherProb;
                    pq.offer(new Connection(toOtherProb, toOther.node));
                }
            }
        }

        return curProb[end];
    }

    class Connection implements Comparable<Connection> {
        public double prob;
        public int node;

        public Connection(double prob, int node) {
            this.prob = prob;
            this.node = node;
        }

        @Override
        public int compareTo(Connection o) {
            if (this.prob == o.prob)
                return 0;
            return this.prob - o.prob > 0 ? -1 : 1;
        }
    }
}
class Solution {
        public long minSumSquareDiff(int[] n1, int[] n2, int k1, int k2) {
        int n = n1.length;

        Map<Long, Long> cnt = new HashMap<>();

        long total = k1 + k2;
        long ds = 0;

        for (int i = 0; i < n; i++) {
            long d = (long)Math.abs(n1[i] - n2[i]);
            cnt.put(d, cnt.getOrDefault(d, 0l) + 1);
            ds += d;
        }

        if (ds <= total)
            return 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int)(b[0] - a[0]));

        for (Map.Entry<Long, Long> kv : cnt.entrySet()) {
            pq.offer(new long[] { kv.getKey(), kv.getValue() });
        }

        while (total > 0) {
            long[] p = pq.poll();

            long d = Math.min(total, p[1]);

            if (!pq.isEmpty() && pq.peek()[0] == p[0] - 1) {
                pq.peek()[1] += d;
            } else {
                pq.offer(new long[] { p[0] - 1, d });
            }

            if (d < p[1])
                pq.offer(new long[] { p[0], p[1] - d });

            total -= d;
        }

        long result = 0;

        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            result += (long) p[1] * (long) p[0] * (long) p[0];
        }

        return result;
    }
}
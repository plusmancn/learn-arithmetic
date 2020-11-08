package cn.plusman.arithmetic.graph;

public class DFS {
    int v;
    boolean found = false;
    boolean[] visited;
    int[] prev;
    Graph graph;

    public DFS(int v, Graph graph) {
        this.v = v;
        this.visited = new boolean[this.v];
        this.graph = graph;
        this.prev = new int[this.v];

        for(int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
    }

    public void dfsByRecursive(int s, int t) {
        recurDfs(-1, s, t);
    }

    public void dfsByStack(int s, int t) {
        // Queue<Integer> stack = new LinkedList<>();
        // // 推入第一个元素
        // visited[s] = true;
        // stack.add()
        //
        // Integer cur;
        // while(cur = stack.peek()) {
        // }
    }

    private void recurDfs(int w, int s, int t) {
        System.out.print(s + " ");

        visited[s] = true;
        prev[s] = w;
        if(s == t) {
            return;
        }

        for (Integer integer : graph.adj[s]) {
            // 如果没有被访问过，则递归遍历
            if(!visited[integer]) {
                recurDfs(s, integer, t);
            }
        }
    }
}

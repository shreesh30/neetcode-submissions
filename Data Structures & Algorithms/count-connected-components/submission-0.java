class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visit = new boolean[n];

        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        int result=0;
        for(int node=0;node<n;node++){
            if(!visit[node]){
                dfs(node, adjacencyList,visit);
                result++;
            }
        }
        return result;
    }

    public void dfs(int node, List<List<Integer>> adjacencyList, boolean[] visit){
       visit[node]=true;

       for(int neighbour:adjacencyList.get(node)) {
        if(!visit[neighbour]){
            dfs(neighbour,adjacencyList,visit);
        }
       }
    }
}

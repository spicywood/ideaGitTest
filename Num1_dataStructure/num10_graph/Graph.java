package Num1_dataStructure.num10_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
    图的深度优先搜索(Depth First Search)
    深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，
    深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点，
    可以这样理解：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
    我们可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。
    显然，深度优先搜索是一个递归的过程

    图的广度优先搜索(Broad First Search) 。
    类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点

    广度优先遍历算法步骤
    1访问初始结点v并标记结点v为已访问。
    2结点v入队列
    3当队列非空时，继续执行，否则算法结束。
    4出队列，取得队头结点u。
    5查找结点u的第一个邻接结点w。
    6若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
        6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
        6.2 结点w入队列
        6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
 */
public class Graph {
    private ArrayList<String> vertexList;   //存储顶点结合
    private int[][] edges;                  //存储图对应的邻接矩阵
    private int numOfEdges;                 //表示边的数目
    //记录是否被访问过
    private boolean[] isVisited;

    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    public static void main(String[] args) {
        int n = 5;  //节点个数
        String vertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(vertexValue.length);
        for(String vertex:vertexValue){
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        //显示邻接矩阵
        graph.showGraph();

        //System.out.println("深度遍历");
        //graph.dfs();

        System.out.println("广度优先");
        graph.bfs();

    }

    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i) + "->");

        isVisited[i] = true;

        int w = getFirstNeighbor(i);

        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    //深度优先遍历，上方函数重载函数
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //广度优先
    public void bfs(boolean[] isVisited,int i){
        int u;      //表示队列的头结点对应下标
        int w;      //邻接节点w
        //队列，节点访问的顺序
        LinkedList queue = new LinkedList<>();
        //访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标w
            w = getFirstNeighbor(u);

            while(w != -1){
                //是否访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队列
                    queue.addLast(w);
                }
                //以u为前驱节点，找w后面的下一个邻节点
                w = getNextNeighbor(u,w);
            }
        }
    }

    //遍历所有的节点，都进行广度优先
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}

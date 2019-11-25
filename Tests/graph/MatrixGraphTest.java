package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatrixGraphTest {

    @Test
    void bfs() {
        MatrixGraph myGraph = new MatrixGraph(7, true);
        myGraph.insert(new Edge(0, 1));
        myGraph.insert(new Edge(0, 3));
        myGraph.insert(new Edge(1, 2));
        myGraph.insert(new Edge(1, 4));
        myGraph.insert(new Edge(3, 6));
        myGraph.insert(new Edge(6, 5));

        ArrayList<Integer> expected = new ArrayList<>();
        //0 is Visited, 1 and 3 are queued
        expected.add(0);
        //1 is Visited, 2 and 4 are queued
        expected.add(1);
        //3 is Visited, 6 is queued
        expected.add(3);
        //2 is Visited, nothing new is queued
        expected.add(2);
        //4 is Visited, nothing new is queued
        expected.add(4);
        //6 is Visited, 5 is queued
        expected.add(6);
        //5 is Visited, nothing new is queued and the bfs finishes
        expected.add(5);

        ArrayList<Integer> actual = myGraph.bfs(0);

        //both ArrayLists should contain the following : [0, 1, 3, 2, 4, 6, 5]
        assertEquals(expected, actual);
    }

    @Test
    void dfs() {
        MatrixGraph myGraph = new MatrixGraph(7, true);
        myGraph.insert(new Edge(0, 1));
        myGraph.insert(new Edge(0, 3));
        myGraph.insert(new Edge(1, 2));
        myGraph.insert(new Edge(1, 4));
        myGraph.insert(new Edge(3, 6));
        myGraph.insert(new Edge(6, 5));

        ArrayList<Integer> expected = new ArrayList<>();

        //0 is visited. 0 is preordered. recursive calls dfs(1)
        expected.add(0);
        //1 is visited. 1 is preordered. recursive calls dfs(2)
        expected.add(1);
        //2 is visited. 2 is preordered. 2 is postordered. Return to 1.
        expected.add(2);
        //4 is visited from 1. 4 is preordered. 4 is postordered. Return to 1. 1 is postordered. Return to 0. recursive calls dfs(3)
        expected.add(4);
        //3 is visited. 3 is preordered. recursive calls dfs(6)
        expected.add(3);
        //6 is visited. 6 is preordered. recursive calls dfs(5)
        expected.add(6);
        //5 is visited. 5 is preordered. 5 is postordered. return to 6. 6 is postordered. return to 3. 3 is postordered. return to 0. 0 is finally postordered.
        expected.add(5);

        ArrayList<Integer> actual = myGraph.dfs(0);

        //preorder sequence should be as follows : [0, 1, 2, 4, 3, 6, 5]
        assertEquals(expected, actual);
    }
}
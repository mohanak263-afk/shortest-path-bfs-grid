import java.util.*;

class GridShortestPath {

    static class Cell {
        int row, col;
        Cell(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static List<Cell> shortestPath(int[][] grid,
                                          int sr, int sc,
                                          int er, int ec) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[sr][sc] == 1 || grid[er][ec] == 1)
            return new ArrayList<>();

        boolean[][] visited = new boolean[rows][cols];
        Cell[][] parent = new Cell[rows][cols];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(sr, sc));
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            if (curr.row == er && curr.col == ec)
                break;

            for (int i = 0; i < 4; i++) {
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                if (nr >= 0 && nc >= 0 &&
                    nr < rows && nc < cols &&
                    grid[nr][nc] == 0 &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    parent[nr][nc] = curr;
                    queue.add(new Cell(nr, nc));
                }
            }
        }

        List<Cell> path = new ArrayList<>();
        if (!visited[er][ec])
            return path;

        Cell curr = new Cell(er, ec);
        while (curr != null) {
            path.add(curr);
            curr = parent[curr.row][curr.col];
        }

        Collections.reverse(path);
        return path;
    }

    private static void printPath(List<Cell> path) {
        if (path.isEmpty()) {
            System.out.println("No path exists");
            return;
        }

        System.out.println("Shortest path length: " + (path.size() - 1));
        System.out.print("Path: ");
        for (Cell c : path) {
            System.out.print("(" + c.row + "," + c.col + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter grid (0 = free, 1 = blocked):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter start cell (row col): ");
        int sr = sc.nextInt();
        int scCol = sc.nextInt();

        System.out.print("Enter end cell (row col): ");
        int er = sc.nextInt();
        int ec = sc.nextInt();

        List<Cell> path = shortestPath(grid, sr, scCol, er, ec);
        printPath(path);

        sc.close();
    }
}

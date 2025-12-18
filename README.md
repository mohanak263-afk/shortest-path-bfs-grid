# Shortest Path Finder using BFS (Grid)

This project finds the shortest path between two points in a 2D grid using Breadth First Search (BFS).

The grid is treated as a graph where each cell is considered a node. Movement is allowed only in four directions: up, down, left, and right.

## Problem Overview

- `0` represents a free cell  
- `1` represents a blocked cell  
- A start cell and an end cell are given  
- The goal is to find the minimum number of moves required to reach the destination  

If no path exists, the program clearly reports it.

## Approach Used

- The grid is modeled as an unweighted graph
- Since all moves have equal cost, BFS is used to guarantee the shortest path
- A queue is used for traversal
- A visited matrix avoids revisiting cells
- Parent tracking is used to reconstruct and print the actual shortest path

## Features

- Takes grid input from the user
- Handles blocked start or end cells
- Handles unreachable destinations
- Prints:
  - shortest path length
  - actual path taken

## Time and Space Complexity

- Time Complexity: `O(rows × columns)`
- Space Complexity: `O(rows × columns)`

## How to Run

1. Compile the program:
   ```bash
   javac GridShortestPath.java


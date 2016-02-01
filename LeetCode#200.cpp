//LeetCode#200: Number of Islands
//Runtime: 8ms
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int islands = 0;
        for (int i = 0; i < grid.size(); i++)
            for (int j = 0; j < grid[0].size(); j++)
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
        return islands;
    }
    
    void dfs(vector<vector<char>>& grid, int row, int col) { 
        if (row < 0 || row == grid.size() || col < 0 || col == grid[0].size() || grid[row][col] != '1')
            return;
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
};
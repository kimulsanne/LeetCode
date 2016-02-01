//LeetCode#210: Course Schedule II
//Runtime: 484ms
class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<vector <int>> graph;
        vector<int> indegrees;
        vector<int> ans;
        graph.resize(numCourses, vector<int>());
        indegrees.resize(numCourses, 0);
        
        for (auto p : prerequisites){
            indegrees[p.first]++; 
            graph[p.second].push_back(p.first);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                ans.push_back(i);
        }
        for (int i = 0; i < ans.size(); i++) {
            for (auto it = graph[ans[i]].begin(); it != graph[ans[i]].end(); it++) {
                    indegrees[*it]--;
                    if (indegrees[*it] == 0)
                        ans.push_back(*it);
            }
        }
        if (ans.size() != numCourses)
            return vector<int>();
        else
            return ans;
        
    }
};
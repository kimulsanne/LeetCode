//LeetCode#56: Merge Intervals
//Runtime: 584ms
/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    bool static compare( Interval i1,  Interval i2){
        return i1.start == i2.start ? i1.end < i2.end:i1.start < i2.start;
    }

    vector<Interval> merge(vector<Interval>& intervals) {
        if (intervals.size() < 2) 
            return intervals;
        sort(intervals.begin(), intervals.end(), compare);
        vector<Interval> result={intervals[0]};
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i].start <= result[result.size()-1].end)
                result[result.size()-1].end = intervals[i].end > result[result.size()-1].end ?intervals[i].end:result[result.size()-1].end; 
            else
                result.push_back(intervals[i]);
        }
        
        return result;
    }
};
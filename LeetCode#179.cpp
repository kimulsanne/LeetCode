//LeetCode#179: Largest Number
//Runtiome: 12ms
class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> words;
        for(auto e: nums)
            words.push_back(to_string(e));
        qsort(words, 0, words.size() - 1);
        string res;
        for (int i = 0; i < words.size(); i++) 
            res += words[i];
        while (res[0] == '0' && res.size() > 1) 
            res.erase(res.begin());
        return res;
    }

    bool isbig(string x, string y) {
        return (x + y >= y + x);
    }  
    
    void qsort(vector<string>& nums, int first, int end) {
        int i = first, j = end;  
        string temp = nums[first];
        while(i < j)  
        {  
            while(i < j && isbig(temp, nums[j])) 
                j--;  
            nums[i] = nums[j];        
            while(i < j && isbig(nums[i], temp))
                i++;          
            nums[j] = nums[i];  
        }  
        nums[i] = temp;                      
        if(first < i - 1)  
            qsort(nums, first, i - 1);  
        if(end > i + 1)        
            qsort(nums, i + 1 , end); 
    }
};
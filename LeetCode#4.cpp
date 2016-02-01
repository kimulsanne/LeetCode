//LeetCode#4: Median of Two Sorted Arrays
//Runtime: 44ms
class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    double res;
    int k = nums1.size() + nums2.size();
    if (k % 2 == 0)
            res = (Kth(nums1.begin(), nums1.size(), nums2.begin(), nums2.size(), k/2) +
                    Kth(nums1.begin(), nums1.size(), nums2.begin(), nums2.size(), k/2 + 1)
                    ) / 2;
                    
        else
            res = Kth(nums1.begin(), nums1.size(), nums2.begin(), nums2.size(), k/2 + 1);
    return res;
}


private:
  typedef vector<int>::iterator Iter;

  double  Kth(Iter start1, int size_1, Iter start2, int size_2, int kth) {
    if (size_1 > size_2) 
        return Kth(start2 , size_2, start1, size_1, kth);
    if (size_1 == 0) 
        return *(start2 + kth - 1);
    if (kth == 1) 
        return min(*start1, *start2);

    int index_1 = min(size_1, kth / 2);
    int index_2 = kth - index_1;
    if (*(start1 + index_1 - 1) < *(start2 + index_2 - 1)) 
        return Kth(start1 + index_1, size_1 - index_1, start2, index_2, kth - index_1);
    return Kth(start1, size_1 ,start2 + index_2, size_2 - index_2, kth - index_2);
}
};
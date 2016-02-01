//LeetCode#23: Merge k Sorted Lists
//Runtime: 408ms
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:

    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode merge(0);
        ListNode* p = &merge;
        while (list1 != NULL && list2 != NULL) {
            if (list2 -> val > list1 -> val) 
            {
                p -> next = list1;
                list1 = list1 -> next;
            } 
            else
            {
                p -> next = list2;
                list2 = list2 -> next;
            }
            p = p -> next;
        }
        if (list1 != NULL)
            p -> next = list1;
        else
            p -> next = list2;
        return merge.next;
    }
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty())
            return NULL;
        int leng = lists.size();
        while (leng != 1) {
            for (int i = 0; i < leng / 2; i++) 
                lists[i] = mergeTwoLists(lists[i], lists[i + leng / 2]);
                
            if (leng % 2 != 0)
                lists[leng / 2] = lists[leng - 1];
            leng = leng - leng / 2;
        }
        return lists[0];
    }
};
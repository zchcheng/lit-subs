/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* result = new ListNode();

        while (head != nullptr) {
            ListNode* tmp = head->next;
            head->next = result->next;
            result->next = head;
            head = tmp;
        }

        return result->next;
    }
};
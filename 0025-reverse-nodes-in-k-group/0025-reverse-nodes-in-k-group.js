/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    // Check if there are at least k nodes left starting from `node`
    let node = head;
    let count = 0;
    while (node !== null && count < k) {
        node = node.next;
        count++;
    }
    
    // If we don't have k nodes, leave this part as-is
    if (count < k) {
        return head;
    }
    
    // node now points to the (k+1)-th node (start of next group)
    // Reverse the first k nodes
    let prev = null;
    let curr = head;
    for (let i = 0; i < k; i++) {
        let next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    
    // curr now points to (k+1)-th node, recursively reverse the rest
    // head is now the tail of this reversed group, connect it to the rest
    head.next = reverseKGroup(curr, k);
    
    // prev is the new head of this reversed group
    return prev;
};

module.exports = reverseKGroup;
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    let slow = head;
    let fast = head;
    
    // Phase 1: Determine if a cycle exists using Floyd's Tortoise and Hare
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow === fast) {
            // Cycle detected — Phase 2: find the entry point
            let ptr1 = head;
            let ptr2 = slow;
            
            while (ptr1 !== ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            
            return ptr1;
        }
    }
    
    // No cycle found
    return null;
};

module.exports = detectCycle;
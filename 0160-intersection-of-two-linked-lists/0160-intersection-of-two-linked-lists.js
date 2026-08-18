/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    if (headA === null || headB === null) {
        return null;
    }
    
    let ptrA = headA;
    let ptrB = headB;
    
    // When ptrA reaches the end of list A, redirect it to headB
    // When ptrB reaches the end of list B, redirect it to headA
    // They will meet at the intersection node, or both become null simultaneously
    while (ptrA !== ptrB) {
        ptrA = (ptrA === null) ? headB : ptrA.next;
        ptrB = (ptrB === null) ? headA : ptrB.next;
    }
    
    return ptrA;
};

module.exports = getIntersectionNode;
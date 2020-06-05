package Linked-Lists;

public class Notes {
    // Loop Detection:
    // 1) Create two pointers, FastPointer and SlowPointer
    // 2) Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step
    // 3) When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
    // 4) Move SlowPointer and FastPointer at a rate of one step. Return the collision point.

    // Note: that when the SlowPointer is at the head of the loop (k steps from start), the fast 
    // pointer is k steps into the loop (LOOP_SIZE - k steps behind SlowPointer). We know that if the 
    // FastPointer catches up at a rate of 1 step per unit of time, then the two pointers will meet after 
    // LOOP_SIZE - k steps. At this point they will be k steps away from the head of the loop.

    public static LinkedListNode FindBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head; 
		
		// Find meeting point
		while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		slow = head; 
		while (slow != fast) { 
			slow = slow.next; 
			fast = fast.next; 
		}
		
		// Both now point to the start of the loop.
		return fast;
	}

	// Intersection of Linked Lists:
	// 1) Run through each linked list to get the lengths and tails
	// 2) Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
	// 3) Set two pointers to the start of the linked list
	// 4) On the longer list, advance its pointer by the difference in lengths.
	// 5) Now, traverse on each linked list until the pointers are the same

	public static class Result {
		public LinkedListNode tail;
		public int size;
		public Result(LinkedListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}
	
	public static Result getTailAndSize(LinkedListNode list) {
		if (list == null) return null;
		
		int size = 1;
		LinkedListNode current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}
	
	public static LinkedListNode getKthNode(LinkedListNode head, int k) {
		LinkedListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	
	public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
		if (list1 == null || list2 == null) return null;
		
		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}
		
		/* Set pointers to the start of each linked list. */
		LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
		LinkedListNode longer = result1.size < result2.size ? list2 : list1;
		
		/* Advance the pointer for the longer linked list by the difference in lengths. */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));
		
		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		
		/* Return either one. */
		return longer; 
	}

	// Reverse the linked list and check if its the same backwards:
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}
		
	public static LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data); // Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}	
		
	public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}
}

# Linked List

## Traversal

Iterating through a linked list can be done with a simple loop.

```c++
void printList(ListNode *head)
{
	ListNode *node = head;
	
	while (node != nullptr) {
		std::cout << node << std::endl;

		node = node->next;
	}
}
```

Recursion can also be used:

```c++
void printList(ListNode *head)
{
	if (head == nullptr) return;
	
	std::cout << head->val << std::endl;
	
	printList(head->next);
}
```
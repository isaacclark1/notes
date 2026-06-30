class LinkedList<T>
{
	private static class Node<T>
	{
		T data;
		Node<T> next;
		
		Node(T data)
		{
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> head = null;

	// Add node at end of the list
	public void append(T data)
	{
		if (head == null) {
			head = new Node<>(data);
			return;
		}

		Node<T> current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = new Node<>(data);
	}

	// Print the list
	public void printList()
	{
		Node<T> current = head;

		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}

		System.out.println("null");
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public int size()
	{
		int count = 0;

		Node<T> current = head;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	public void insert(T data, int position)
	{
		if (position < 0) {
			throw new IndexOutOfBoundsException("Position cannot be negative");
		}

		if (position == 0) {
			Node<T> newNode = new Node<>(data);
			newNode.next = head;
			head = newNode;
			return;
		}

		Node<T> current = head;

		// Traverse to the node before the desired position
		for (int i = 0; i < position - 1; i++) {
			if (current == null) {
				throw new IndexOutOfBoundsException("Position out of bounds");
			}

			current = current.next;
		}

		Node<T> newNode = new Node<>(data);

		newNode.next = current.next;
		current.next = newNode;
	}

	// Add node at the beginning of the list
	public void prepend(T data)
	{
		Node<T> newNode = new Node<>(data);
		newNode.next = head;
		head = newNode;
	}

	public void remove(int position)
	{
		if (position < 0) {
			throw new IndexOutOfBoundsException("Position cannot be negative");
		}

		if (head == null) {
			throw new IndexOutOfBoundsException("List is empty");
		}

		if (position == 0) {
			head = head.next;
			return;
		}

		Node<T> current = head;

		// Traverse to the node before the desired position
		for (int i = 0; i < position - 1; i++) {
			if (current == null || current.next == null) {
				throw new IndexOutOfBoundsException("Position out of bounds");
			}

			current = current.next;
		}

		current.next = current.next.next;
	}

	public void removeValue(T value)
	{
		if (head == null) return;

		if (head.data.equals(value)) {
			head = head.next;
			return;
		}

		Node<T> current = head;

		while (current.next != null) {
			if (current.next.data.equals(value)) {
				current.next = current.next.next;
				return;
			}

			current = current.next;
		}
	}

	public T get(int position)
	{
		if (position < 0) {
			throw new IndexOutOfBoundsException("Position cannot be negative");
		}

		Node<T> current = head;

		for (int i = 0; i < position; i++) {
			if (current == null) {
				throw new IndexOutOfBoundsException("Position out of bounds");
			}

			current = current.next;
		}

		if (current == null) {
			throw new IndexOutOfBoundsException("Position out of bounds");
		}

		return current.data;
	}

	public void set(int position, T data)
	{
		if (position < 0) {
			throw new IndexOutOfBoundsException("Position cannot be negative");
		}

		Node<T> current = head;

		for (int i = 0; i < position; i++) {
			if (current == null) {
				throw new IndexOutOfBoundsException("Position out of bounds");
			}

			current = current.next;
		}

		if (current == null) {
			throw new IndexOutOfBoundsException("Position out of bounds");
		}

		current.data = data;
	}

	public boolean contains(T value)
	{
		Node<T> current = head;

		while (current != null) {
			if (current.data.equals(value)) {
				return true;
			}

			current = current.next;
		}

		return false;
	}

	public void clear()
	{
		head = null;
	}

	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.printList();
	}
}
package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 *
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		if (element == null) {
			throw new NullPointerException("Cant add a null value");
		}

		LLNode<E> toAdd = new LLNode<E>(element);
		toAdd.prev = tail.prev;
		toAdd.next = toAdd.prev.next;
		toAdd.prev.next = toAdd;
		toAdd.next.prev = toAdd;
		toAdd.data = element;
		size += 1;
		return true;
	}

	/**
	 * Get the element at position index
	 *
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Your index is out of bounds!");
		}

		LLNode<E> toGet = head;
		for (int i = 0; i <= index; i++) {
			toGet = toGet.next;
		}
		return toGet.data;
	}

	public void printList() {

		LLNode<E> lTemp = head;

		while (lTemp.next != tail) {
			System.out.println(lTemp.next.data);
			lTemp = lTemp.next;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 *
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		if (element == null) {
			throw new NullPointerException("Cant add a null value");
		}

		LLNode<E> temp = new LLNode<E>();
		temp = head;
		for (int i = 0; i <= index; i++) {
			temp = temp.next;
			// System.out.println(temp.data);
		}
		LLNode<E> node = new LLNode<E>(element);
		node.next = temp;
		node.data = element;
		// System.out.println("node next element: " + node.next.data);
		node.prev = temp.prev;
		// System.out.println("node previous element: " + node.prev.data);
		// System.out.println("temp previous data: " + temp.prev.data);
		temp.prev.next = node;
		// System.out.println("temp previous next data now points to node which
		// is " + temp.prev.next.data);
		temp.prev = node;
		// System.out.println("temp previous pointer now points to node which
		// is:" + temp.prev.data);
		// System.out.println("and temp still points forward to: " +
		// temp.next.data);
		// System.out.println("which points forward to: " +
		// temp.next.next.data);
		System.out.printf(
				"so i insert %d and the previous value is %d and next value is %d with head and tail still %d %d each\n",
				node.data, node.prev.data, node.next.data, head.data, tail.data);
		printList();
		size += 1;
	}

	/** Return the size of the list */
	public int size() {
		return size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 *
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 *
	 */
	public E remove(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Your index is out of bounds!");
		}
		LLNode<E> rem = head;
		for (int i = 0; i <= index; i++) {
			rem = rem.next;
			if (i == index) {
				// System.out.println(rem.data);
				rem.next.prev = rem.prev;
				rem.prev.next = rem.next;
				size--;
				return rem.data;
			}
		}
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 *
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Your index is out of bounds!");
		}

		if (element == null) {
			throw new NullPointerException("Cant add a null value");
		}

		LLNode<E> rem = head;
		for (int i = 0; i <= index; i++) {
			rem = rem.next;
			if (i == index) {
				rem.data = element;
				// System.out.println(rem.data);
				//printList();
				return rem.data;
			}
		}
		return element;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}

}

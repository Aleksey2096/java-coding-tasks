import java.util.LinkedList;
import java.util.List;

/*
 * How do you reverse a linked list in Java?
 */
public class ReversedLinkedList {
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<>();

		ll.add(1);
		ll.add(2);
		ll.add(3);

		System.out.println(reverseLinkedList(ll));
	}

	public static <T> List<T> reverseLinkedList(List<T> list) {
//		1
//		List<T> result = new LinkedList<>();
//		((LinkedList<T>) list).descendingIterator().forEachRemaining(item -> result.add(item));
//		return result;

//		2
		return list.reversed();
	}
}

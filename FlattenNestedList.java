import java.util.ArrayList;
import java.util.List;

/*
 * Flatten a nested list structure
 */
public class FlattenNestedList {
	@SuppressWarnings("unchecked")
	public static List<Integer> flattenList(List<Object> nestedList) {
		List<Integer> flatList = new ArrayList<>();
		for (Object element : nestedList) {
			if (element instanceof List) {
				flatList.addAll(flattenList((List<Object>) element));
			} else {
				flatList.add((Integer) element);
			}
		}
		return flatList;
	}

	public static void main(String[] args) {
		List<Object> nestedList = List.of(1, List.of(2, List.of(3, 4)), 5);
		System.out.println("Flattened List: " + flattenList(nestedList));
	}
}

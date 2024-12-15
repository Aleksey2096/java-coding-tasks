import java.util.LinkedList;

/*
 * Implement a custom HashMap
 */
class CustomHashMap<K, V> {
	private static final int SIZE = 16;
	private final LinkedList<Entry<K, V>>[] buckets;

	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		buckets = new LinkedList[SIZE];
		for (int i = 0; i < SIZE; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	static class Entry<K, V> {
		final K key;
		V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private int getIndex(K key) {
		return key.hashCode() % SIZE;
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		for (Entry<K, V> entry : buckets[index]) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}
		buckets[index].add(new Entry<>(key, value));
	}

	public V get(K key) {
		int index = getIndex(key);
		for (Entry<K, V> entry : buckets[index]) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	public void remove(K key) {
		int index = getIndex(key);
		buckets[index].removeIf(entry -> entry.key.equals(key));
	}

	public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		System.out.println("Value for 'One': " + map.get("One"));
		map.remove("One");
		System.out.println("Value for 'One' after removal: " + map.get("One"));
	}
}

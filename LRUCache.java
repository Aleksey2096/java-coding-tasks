import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Implement a Least Recently Used (LRU) Cache
 */
class LRUCache<K, V> {
	private final LinkedHashMap<K, V> cache;

	public LRUCache(int capacity) {
		this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > capacity;
			}
		};
	}

	public void put(K key, V value) {
		cache.put(key, value);
	}

	public V get(K key) {
		return cache.getOrDefault(key, null);
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache = new LRUCache<>(3);
		lruCache.put(1, "A");
		lruCache.put(2, "B");
		lruCache.put(3, "C");
		System.out.println("Value for key 2: " + lruCache.get(2));
		lruCache.put(4, "D");
		System.out.println("Value for key 1 after eviction: " + lruCache.get(1));
	}
}

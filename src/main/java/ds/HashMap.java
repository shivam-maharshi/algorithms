package ds;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Standard representation of a HashMap. Should add resize method.
 * 
 * @author shivam.maharshi
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {

	int size;
	LinkedList<Entry<K, V>>[] hashArray;

	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		hashArray = new LinkedList[capacity];
	}

	public void add(K key, V value) {
		int hash = getHash(key);
		LinkedList<Entry<K, V>> list = hashArray[hash];
		if (list != null) {
			list = new LinkedList<Entry<K, V>>();
		}
		Entry<K, V> entry = new Entry<K, V>(key, value);
		list.add(entry);
	}

	public V get(K key) {
		int hash = getHash(key);
		LinkedList<Entry<K, V>> list = hashArray[hash];
		if (list != null) {
			return fetchValueFromList(key, list);
		}
		return null;
	}

	public void delete(K key) {
		int hash = getHash(key);
		LinkedList<Entry<K, V>> list = hashArray[hash];
		if (list != null) {
			deleteEntryFromList(key, list);
		}
	}

	private V fetchValueFromList(K key, LinkedList<Entry<K, V>> list) {
		Iterator<Entry<K, V>> it = list.iterator();
		while (it.hasNext()) {
			Entry<K, V> entry = it.next();
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	private void deleteEntryFromList(K key, LinkedList<Entry<K, V>> list) {
		Iterator<Entry<K, V>> it = list.iterator();
		while (it.hasNext()) {
			Entry<K, V> entry = it.next();
			if (entry.getKey().equals(key)) {
				list.remove(entry);
			}
		}
	}

	private int getHash(K key) {
		return key.hashCode();
	}

}

class Entry<K, V> {

	private K key;
	private V value;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}

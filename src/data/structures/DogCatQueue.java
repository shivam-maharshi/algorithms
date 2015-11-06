package data.structures;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DogCatQueue {

	private Queue catQueue = new Queue();
	private Queue dogQueue = new Queue();

	public void enqueue(Animal animal) {
		if (animal != null) {
			if (animal.getType() == 'C') {
				catQueue.enqueue(animal);
			} else if (animal.getType() == 'D') {
				dogQueue.enqueue(animal);
			} else {
				System.out.println("Wrong type of animal");
			}
		}
	}

	public Animal dequeueAny() {
		Animal cat = catQueue.peek();
		Animal dog = dogQueue.peek();

		if (cat != null && dog != null) {
			return cat.getTimestamp() > dog.getTimestamp() ? cat : dog;
		} else if (cat == null && dog != null) {
			return dog;
		} else if (cat != null && dog == null) {
			return cat;
		} else {
			return null;
		}

	}

	public Animal dequeueDog() {
		return dogQueue.dequeue();
	}

	public Animal dequeueCat() {
		return catQueue.dequeue();
	}

}

class Queue {
	private LinkedList<Animal> queue = new LinkedList<Animal>();

	public void enqueue(Animal animal) {
		queue.add(animal);
	}

	public Animal dequeue() {
		try {
			return queue.remove();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Animal peek() {
		try {
			Animal animal = queue.getFirst();
			return animal;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		Animal d1 = new Animal(1, 'D');
		Animal d2 = new Animal(2, 'D');
		Animal d3 = new Animal(3, 'D');
		Animal c1 = new Animal(4, 'C');
		Animal c2 = new Animal(5, 'C');
		Animal d4 = new Animal(6, 'D');
		Animal c3 = new Animal(7, 'C');

		DogCatQueue dcQueue = new DogCatQueue();

		dcQueue.enqueue(d1);
		dcQueue.enqueue(d2);
		dcQueue.enqueue(d3);
		dcQueue.enqueue(c1);
		dcQueue.enqueue(c2);
		dcQueue.enqueue(d4);
		dcQueue.enqueue(c3);
		System.out.println(dcQueue.dequeueCat());
		System.out.println(dcQueue.dequeueCat());
		System.out.println(dcQueue.dequeueCat());
		System.out.println(dcQueue.dequeueCat());
		System.out.println(dcQueue.dequeueDog());
		System.out.println(dcQueue.dequeueAny());
	}

}

class Animal {
	private int id;
	private char type;
	private long timestamp;

	@Override
	public String toString() {
		return "Animal [id=" + id + ", type=" + type + ", timestamp=" + timestamp + "]";
	}

	public Animal(int id, char type) {
		this.id = id;
		this.type = type;
		this.timestamp = System.currentTimeMillis();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
import java.util.LinkedList;

/*
 * Producer-Consumer Problem Using Threads
 */
public class ProducerConsumer {
	private final LinkedList<Integer> buffer = new LinkedList<>();
	private final int capacity = 5;

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				while (buffer.size() == capacity) {
					wait();
				}
				buffer.add(value);
				System.out.println("Produced: " + value);
				value++;
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (buffer.isEmpty()) {
					wait();
				}
				int value = buffer.removeFirst();
				System.out.println("Consumed: " + value);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();

		Thread producer = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		producer.start();
		consumer.start();
	}
}

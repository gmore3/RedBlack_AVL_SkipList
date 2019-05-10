import java.util.*;

public class SkipList {
	public SkipListEntry head; // First element of the top level
	public SkipListEntry tail; // Last element of the top level
	public int n; // number of entries in the Skip list
	public int h; // Height
	public Random r; // Coin toss

	public SkipList() // Default constructor...
	{
		SkipListEntry p1, p2;
		p1 = new SkipListEntry(SkipListEntry.negInf, null);
		p2 = new SkipListEntry(SkipListEntry.posInf, null);
		head = p1;
		tail = p2;
		p1.right = p2;
		p2.left = p1;
		n = 0;
		h = 0;
		r = new Random();
	}

	/** Returns the number of entries in the hash table. */
	public int size() {
		return n;
	}

	/** Returns whether or not the table is empty. */
	public boolean isEmpty() {
		return (n == 0);
	}

	public SkipListEntry findEntry(String k) {
		SkipListEntry p;
		p = head;
		while (true) {
			while (p.right.key != SkipListEntry.posInf && p.right.key.compareTo(k) <= 0) {
				p = p.right;
			}
			if (p.down != null) {
				p = p.down;
			} else
				break; // We reached the LOWEST level... Exit...
		}
		return (p); // p.key <= k
	}

	/** Returns the value associated with a key. */
	public Integer get(String k) {
		SkipListEntry p;
		p = findEntry(k);
		if (k.equals(p.getKey()))
			return (p.value);
		else
			return (null);
	}

	/** Put a key-value pair in the map, replacing previous one if it exists. */
	public Integer insert(String k, Integer v) {
		SkipListEntry m, w;
		int i;
		m = findEntry(k);
		if (k.equals(m.getKey())) {
			Integer old = m.value;
			m.value = v;
			return (old);
		}
		w = new SkipListEntry(k, v);
		w.left = m;
		w.right = m.right;
		m.right.left = w;
		m.right = w;
		i = 0; // Current level = 0
		while (r.nextDouble() < 0.5) {
			if (i >= h) {
				SkipListEntry m1, m2;
				h = h + 1;
				m1 = new SkipListEntry(SkipListEntry.negInf, null);
				m2 = new SkipListEntry(SkipListEntry.posInf, null);
				m1.right = m2;
				m1.down = head;
				m2.left = m1;
				m2.down = tail;
				head.up = m1;
				tail.up = m2;
				head = m1;
				tail = m2;
			}
			while (m.up == null) {
				m = m.left;
			}
			m = m.up;
			SkipListEntry e;
			e = new SkipListEntry(k, null); // Don't need the value...
			e.left = m;
			e.right = m.right;
			e.down = w;
			m.right.left = e;
			m.right = e;
			w.up = e;
			w = e; // Set q up for the next iteration
			i = i + 1; // Current level increased by 1
		}
		n = n + 1;
		return (null); // No old value
	}

	/** Removes the key-value pair with a specified key. */
	public Integer remove(String k) {
		return (null);
	}

	public void printHorizontal() {
		String str = "";
		int i;
		SkipListEntry m;
		m = head;
		while (m.down != null) {
			m = m.down;
		}
		i = 0;
		while (m != null) {
			m.pos = i++;
			m = m.right;
		}
		m = head;
		while (m != null) {
			str = getOneRow(m);
			System.out.println(str);
			m = m.down;
		}
	}

	public String getOneRow(SkipListEntry p) {
		String s;
		int a, b, i;
		a = 0;
		s = "" + p.key;
		p = p.right;
		while (p != null) {
			SkipListEntry q;
			q = p;
			while (q.down != null)
				q = q.down;
			b = q.pos;
			s = s + " <~";
			for (i = a + 1; i < b; i++)
				s = s + "~~~~~~~";
			s = s + "> " + p.key;
			a = b;
			p = p.right;
		}
		return (s);
	}

	public String getOneColumn(SkipListEntry p) {
		String s = "";
		while (p != null) {
			s = s + " " + p.key;
			p = p.up;
		}
		return (s);
	}
}
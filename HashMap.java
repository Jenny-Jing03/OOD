package OOD;

public class HashMap<K, V> {
    protected class Node<K, V> {
        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;
    private Node<K, V>[] map;
    private int capacity;
    private final double loadFactor = 0.75;

    /*
     * constructor
     */
    public HashMap() {
        this.size = 0;
        this.capacity = 16; // default capacity
        this.map = (Node<K, V>[]) (new Node[this.capacity]);
    }

    /**
     * Associates the specified value with the specified key in this map.
     * 
     * @return the previous value associated with key, or null if there was no
     *         mapping for key.
     */
    public V put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        int index = node.hashCode() % this.map.length;
        if (this.map[index] != null) {
            V pre = this.map[index].value;
            this.map[index] = node;
            return pre;
        }
        this.map[index] = node; // this.map[index] == null
        this.size++;
        if (this.loadFactor * this.capacity <= this.size)
            this.enlarge();
        return null;
    }

    /**
     * @return the value to which the specified key is mapped, or null if this map
     *         contains no mapping for the key
     */
    public V get(K key) {
        int index = key.hashCode() % this.map.length;
        if (this.map[index] != null)
            return this.map[index].value;
        return null;
    }

    /**
     * @return true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(K key) {
        return this.map[key.hashCode() % this.map.length] != null;
    }

    /**
     * @return true if this map maps one or more keys to the specified value
     */
    public boolean containsValue(V value){
        for(Node<K, V> node : this.map){
            if(node.value == value){
                return true;
            }
        }
        return false;
    }

    /**
     * @return the previous value associated with key, or null if there was no
     *         mapping for key.
     */
    public V remove(K key) {
        int index = key.hashCode() % this.map.length;
        if (this.map[index] != null) {
            Node<K, V> node = this.map[index];
            this.map[index] = null;
            return node.value;
        }
        return null;
    }

    /**
     * Replaces the entry for the specified key only if it is currently mapped to
     * some value.
     * 
     * @return the previous value associated with the specified key, or null if
     *         there was no mapping for the key.
     */
    public V replace(K key, V value) {
        int index = key.hashCode() % this.map.length;
        Node<K, V> node = this.map[index];
        this.map[index] = new Node<>(key, value);
        if(node != null) return node.value;
        return null;

    }

    private void enlarge() {
        this.capacity = this.capacity * 2;
        Node<K, V>[] newMap = (Node<K, V>[])(new Node[this.capacity]);
        for (Node<K, V> node : this.map) {
            int index = node.hashCode() % newMap.length;
            newMap[index] = node;
        }
        this.map = newMap;
    }

    /**
     * @return the number of elements in this set
     */
    public int size() {
        return this.size;
    }

    /**
     * @return true if this set contains no elements.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
     * Removes all of the elements from this set.
     */
    public void clear() {
        this.size = 0;
        this.map = new Node[this.capacity];
    }
}

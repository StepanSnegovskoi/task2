package task2.Node;

public class SimpleLinkedList {
    private Node first = null;
    private Node last = null;
    private static int size = 0;

    public Node get(int index) {
        return getNode(index);
    }

    public int getSize() {
        return size;
    }

    public void add(String str) {
        str = str.trim();
        if (size == 0) {
            first = new Node(str, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(str, null);
            secondLast.next = last;
        }
        size++;
    }

    public void add(String str, int index) {
        str = str.trim();
        checkIndex(index);
        if (index == size) {
            add(str);
            return;
        }
        if (index == 0) {
            Node secondFirst = first;
            first = new Node(str, secondFirst);
        } else {
            Node currNode = getNode(index);
            Node newNode = new Node(str, currNode);
            Node prevNode = getNode(index - 1);
            prevNode.next = newNode;
        }
        size++;
    }

    public boolean remove(String str) {
        str = str.trim();
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(str)) {
                return removeAt(i);
            }
            node = node.next;
        }
        size--;
        return false;
    }

    public boolean removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node prev = getNode(index - 1);
            Node current = prev.next;
            if(prev.next != null){
                prev.next = current.next;
            }
            if(index == size - 1){
                last = prev;
            }
        }
        size--;
        return true;
    }

    public void clear() {
        first = last = new Node(null, null);
        size = 0;
    }

    public static int getSizeStatic() {
        return size;
    }

    public static Node getNextNode(Node node) {
        return node.next;
    }

    public void showValues() {
        for (int i = 0; i < size; i++) {
                System.out.println(getNode(i).getValue());
        }
    }

    // Удаление повторяющихся элементов кроме первого (i != j)
    public void removingRepetitions() {
        while (!CheckUniqueElements()) {
            for (int i = 0; i < size; i++) {
                String currentValue = getNode(i).getValue();
                for (int j = 0; j < size; j++) {
                    if ((getNode(j).getValue()).equals(currentValue) && i != j) {
                        removeAt(j);
                    }
                }
            }
        }
    }

    // Проверка на уникальность списка, нужна потому, что если использовать только 1 раз removingRepetitions, то он удалит не все нужные элементы
    private boolean CheckUniqueElements() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((getNode(i).getValue()).equals(getNode(j).getValue())) {
                    if (i != j) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Текст для оконного интерфейса, вставляется в textAreaForResult;
    public String makeElementsToStringForGUI(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < size; i++){
            str.append(getNode(i).getValue());
            if(i < size - 1){
                str.append("   ||   ");
            }
        }
        return str.toString();
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}

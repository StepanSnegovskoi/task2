import Node.FileWork;
import Node.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("fdeg");
        simpleLinkedList.add("fdeg");
        simpleLinkedList.add("fdeg");
        simpleLinkedList.add("fdeg");
        simpleLinkedList.add("fdeg");
        simpleLinkedList.add("fdeg");
        simpleLinkedList.add("fdeg");

        simpleLinkedList.removingRepetitions();
        simpleLinkedList.showValues();
        System.out.println(simpleLinkedList.getSize());

        FileWork.addNodeInSimpleLinkedListViaMyFinishPath("NodesFromFileInCodeSLList", simpleLinkedList);
        FileWork.addFromCodeToFile(simpleLinkedList, "NodesFromCodeInFile");
    }
}
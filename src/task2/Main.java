package task2;

import task2.Node.SimpleLinkedList;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        simpleLinkedList.add("1");
        simpleLinkedList.add("2");
        simpleLinkedList.add("3");
        simpleLinkedList.add("1");
        simpleLinkedList.add("2");
        simpleLinkedList.add("3");
        simpleLinkedList.add("4");
        simpleLinkedList.add("5");
        simpleLinkedList.add("3");
        simpleLinkedList.add("4");
        simpleLinkedList.add("5");
        simpleLinkedList.add("6");
        simpleLinkedList.add("7");
        simpleLinkedList.add("7");
        simpleLinkedList.add("5");
        simpleLinkedList.add("6");
        simpleLinkedList.add("7");
        simpleLinkedList.add("7");
        simpleLinkedList.add("8");


        simpleLinkedList.removingRepetitions();
        simpleLinkedList.showValues();
        System.out.println("\n" + simpleLinkedList.getSize() + " Size\n");

        FileWork.addNodeInSimpleLinkedListThroughMyFinishPath(simpleLinkedList);
        FileWork.addFromCodeToFile(simpleLinkedList, "C:\\Users\\stepa\\IdeaProjects\\task2\\src\\nodesFromCodeInFile");

        simpleLinkedList.clear();
        simpleLinkedList.add("1");
        simpleLinkedList.add("12");
        simpleLinkedList.add("123");
        simpleLinkedList.add("1234");
        simpleLinkedList.showValues();
        System.out.println("\n" + simpleLinkedList.getSize() + " Size");
    }
}
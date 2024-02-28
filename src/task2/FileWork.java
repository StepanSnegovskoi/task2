package task2;

import task2.Node.SimpleLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWork {
    private static final File MYFILEFROMPATH = new File("C:\\Users\\stepa\\IdeaProjects\\task2\\src\\NodesFromFileInCodeSLList");
    private static File file;

    public static void addNodeInSimpleLinkedListThroughMyFinishPath(SimpleLinkedList array) {
        addElementsInSimpleLinkedList(array, MYFILEFROMPATH);
    }

    // Добавление через путь пользователя
    public static void addNodeFromFilePathInSimpleLinkedList(String pathToFile, SimpleLinkedList array) {
        file = new File(String.format("%s", pathToFile));
        addElementsInSimpleLinkedList(array, file);
    }

    // Получение value, с каждой новой строки записывается value в файл
    public static void addFromCodeToFile(SimpleLinkedList array, String pathToFile) {
        //File file = new File(String.format("C:\\Users\\stepa\\IdeaProjects\\task2\\src\\%s", fileName));
        File file = new File(String.format(pathToFile));
        PrintWriter printWriter;

        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String value = "";
        for (int i = 0; i < array.getSize(); i++) {
            try{
                value = array.get(i).getValue();
            } catch (NullPointerException e){

            }
            printWriter.printf("%s\n", value);
        }
        printWriter.close();
    }

    // Получение values из файла сканером, добавление через метод add в лист. В файле на каждой строке один элемент
    private static void addElementsInSimpleLinkedList(SimpleLinkedList array2, File file) {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            array2.add(scanner.nextLine());
        }
        scanner.close();
    }
}

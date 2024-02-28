package task2;

import task2.Node.SimpleLinkedList;

import javax.swing.*;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea textAreaForResult;
    private JButton outputToFile;
    private JButton inputFromFile;
    private JButton result;
    private JTextArea textAreaForAddElement;
    private JButton addUp;
    private JTextArea textAreaForDeleteElementByValue;
    private JButton deleteByValue;
    private JButton deleteByIndex;
    private JTextArea textAreaForDeleteByIndex;
    private JButton clearList;

    public GUI() {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

        setContentPane(mainPanel);
        setTitle("GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        textAreaForResult.setLineWrap(true);
        textAreaForResult.setEditable(false);

        // Добавление элементов из файла в список
        inputFromFile.addActionListener(e -> {
            FileWork.addNodeInSimpleLinkedListThroughMyFinishPath(simpleLinkedList);
            //FileWork.addNodeFromFilePathInSimpleLinkedList("NodesFromFileInGUI", ...);
            showElementsInGUI(simpleLinkedList);
        });

        // Вывод элементов в файл
        outputToFile.addActionListener(e -> FileWork.addFromCodeToFile(simpleLinkedList, "C:\\Users\\stepa\\IdeaProjects\\task2\\src\\NodesFromGUIInFile"));

        // Решение и вывод результата в интерфейсе
        result.addActionListener(e -> {
            checkError(simpleLinkedList, 0);
            simpleLinkedList.removingRepetitions();
            textAreaForResult.setText(simpleLinkedList.makeElementsToStringForGUI());
            showElementsInGUI(simpleLinkedList);
        });

        // Добавление в список элемента сверху
        addUp.addActionListener(e -> {
            if (!textAreaForAddElement.getText().isEmpty()) {
                simpleLinkedList.add(textAreaForAddElement.getText().trim());
            }
            showElementsInGUI(simpleLinkedList);
        });

        // Удаление по value
        deleteByValue.addActionListener(e -> {
            int currSize = simpleLinkedList.getSize();;
            for(int i = 0; i < simpleLinkedList.getSize(); i++){
                if (textAreaForDeleteElementByValue.getText().trim().equals(simpleLinkedList.get(i).getValue())){
                    simpleLinkedList.removeAt(i);
                    break;
                }
            }
            if(currSize == simpleLinkedList.getSize())
                JOptionPane.showMessageDialog(null, "Такого элемента в списке нету", "Error", JOptionPane.WARNING_MESSAGE);
            showElementsInGUI(simpleLinkedList);
        });

        // Удаление по индексу
        deleteByIndex.addActionListener(e -> {
            int index = Integer.parseInt(textAreaForDeleteByIndex.getText().trim());
            checkError(simpleLinkedList, index);
            simpleLinkedList.removeAt(index);
            showElementsInGUI(simpleLinkedList);
        });

        clearList.addActionListener(e -> {
            simpleLinkedList.clear();
            textAreaForResult.setText("");
        });
    }

    // Обновление текста с элементами списка в интерфейсе
    private void showElementsInGUI(SimpleLinkedList simpleLinkedList){
        textAreaForResult.setText(simpleLinkedList.makeElementsToStringForGUI());
    }

    private static void checkError(SimpleLinkedList simpleLinkedList, int index){
        if(simpleLinkedList.getSize() == 0 || index >= simpleLinkedList.getSize() || index < 0){
            JOptionPane.showMessageDialog(null, "Введенный индекс неверен или размер массива равен нулю", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}

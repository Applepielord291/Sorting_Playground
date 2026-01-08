import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Frame {
    public static JTextArea init = new JTextArea();
    public static JTextArea fin = new JTextArea();
    public static JTextArea selSort = new JTextArea();
    public static JTextArea selSearch = new JTextArea();
    public static JTextArea sortTimeTxt = new JTextArea();
    public static JTextArea searchTimeTxt = new JTextArea();
    public static JTextArea numberFoundTxt = new JTextArea();
    public static JTextArea numberPosTxt = new JTextArea();
    public static void displayFrame() throws Exception {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JButton bubbleBtn = new JButton("Bubble Sort");
        JButton selectBtn = new JButton("Selection Sort");
        JButton insertBtn = new JButton("Insertion Sort");
        JButton quickBtn = new JButton("Quick Sort");
        JButton shellBtn = new JButton("Shell Sort");
        JButton linearBtn = new JButton("Linear Search");
        JButton binaryBtn = new JButton("Binary Search");
        JButton noneBtn = new JButton("No searching");

        JTextArea arrSizeInput = new JTextArea();
        JTextArea numberSearchInput = new JTextArea();
        
        JScrollPane initArr = new JScrollPane(init);
        JScrollPane finalArr = new JScrollPane(fin);
        JButton makeArray = new JButton("Sort and Search!");
        JButton generateBtn = new JButton("Generate Random Numbers");

        JLabel unsortedTitle = new JLabel("Unsorted");
        JLabel sortedTitle = new JLabel("Sorted");
        JLabel sortTypeTitle = new JLabel("Sorting Type");
        JLabel searchTitleType = new JLabel("Searching Type");
        JLabel arrSizeTitle = new JLabel("Array Size");
        JLabel numberFindTitle = new JLabel("Number to Find");
        JLabel selectedSortTitle = new JLabel("Current Sorting Type");
        JLabel selectedSearchType = new JLabel("Current Search Type");
        JLabel sortingTimeLbl = new JLabel("Sorting Time (millis)");
        JLabel searchingTimeLbl = new JLabel("Searching Time (millis)");
        JLabel numberFoundLbl = new JLabel("Number Found:");
        JLabel numberPosLbl = new JLabel("Found at Position:");

        frame.setResizable(false);
        frame.setSize(900, 625);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);
        panel.setSize(900, 625);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sorting Algorithm Playground");

        init.setEditable(false);
        fin.setEditable(false);
        selSort.setEditable(false);
        selSearch.setEditable(false);
        sortTimeTxt.setEditable(false);
        searchTimeTxt.setEditable(false);
        numberFoundTxt.setEditable(false);
        numberPosTxt.setEditable(false);

        unsortedTitle.setBounds(80, 0, 200, 30);
        sortedTitle.setBounds(295, 0, 200, 30);
        sortTypeTitle.setBounds(500, 50, 200, 25);
        searchTitleType.setBounds(500, 200, 200, 25);
        arrSizeTitle.setBounds(500, 300, 200, 25);
        numberFindTitle.setBounds(650, 300, 200, 25);
        selectedSortTitle.setBounds(500, 350, 200, 25);
        selectedSearchType.setBounds(650, 350, 200, 25);
        sortingTimeLbl.setBounds(500, 475, 200, 25);
        searchingTimeLbl.setBounds(650, 475, 200, 25);
        numberFoundLbl.setBounds(500, 525, 200, 25);
        numberPosLbl.setBounds(500, 550, 200, 25);

        arrSizeInput.setBounds(500, 325, 100, 18);
        numberSearchInput.setBounds(650, 325, 100, 18);
        selSort.setBounds(500, 375, 100, 18);
        selSearch.setBounds(650, 375, 100, 18);
        sortTimeTxt.setBounds(500, 500, 100, 18);
        searchTimeTxt.setBounds(650, 500, 100, 18);
        numberFoundTxt.setBounds(590, 528, 70, 18);
        numberPosTxt.setBounds(605, 553, 70, 18);

        initArr.setBounds(10, 30, 200, 550);
        finalArr.setBounds(220, 30, 200, 550);

        bubbleBtn.setBounds(500, 75, 125, 25);
        selectBtn.setBounds(630, 75, 125, 25);
        insertBtn.setBounds(500, 105, 125, 25);
        quickBtn.setBounds(630, 105, 125, 25);
        shellBtn.setBounds(560, 135, 125, 25);

        linearBtn.setBounds(500, 225, 125, 25);
        binaryBtn.setBounds(630, 225, 125, 25);
        noneBtn.setBounds(560, 255, 125, 25);

        generateBtn.setBounds(500, 400, 200, 25);
        makeArray.setBounds(500, 430, 200, 25);

        bubbleBtn.addActionListener(e -> Main.userClickedBubble());
        selectBtn.addActionListener(e -> Main.userClickedSelect());
        insertBtn.addActionListener(e -> Main.userClickedInsert());
        quickBtn.addActionListener(e -> Main.userClickedQuick());
        shellBtn.addActionListener(e -> Main.userClickedShell());

        linearBtn.addActionListener(e -> Main.userClickedLinear());
        binaryBtn.addActionListener(e -> Main.userClickedBinary());
        noneBtn.addActionListener(e -> Main.userClickedNoSearch());
        generateBtn.addActionListener(e ->  {
            try {
                Main.generateRandom(Integer.parseInt(arrSizeInput.getText()));
            }
            catch (Exception e1) {
                errorPopUp(e1);
            }
        });
        makeArray.addActionListener(e -> {
            try {
                Main.userClickedRun(Integer.parseInt(numberSearchInput.getText()));
            } catch (Exception e1) {
                errorPopUp(e1);
            }
        });

        frame.add(panel);

        panel.add(bubbleBtn);
        panel.add(initArr);
        panel.add(finalArr);
        panel.add(unsortedTitle);
        panel.add(sortedTitle);
        panel.add(sortTypeTitle);
        panel.add(selectBtn);
        panel.add(insertBtn);
        panel.add(quickBtn);
        panel.add(shellBtn);
        panel.add(searchTitleType);
        panel.add(linearBtn);
        panel.add(binaryBtn);
        panel.add(noneBtn);
        panel.add(arrSizeTitle);
        panel.add(arrSizeInput);
        panel.add(generateBtn);
        panel.add(makeArray);
        panel.add(numberFindTitle);
        panel.add(numberSearchInput);
        panel.add(selectedSortTitle);
        panel.add(selectedSearchType);
        panel.add(selSort);
        panel.add(selSearch);
        panel.add(sortingTimeLbl);
        panel.add(searchingTimeLbl);
        panel.add(sortTimeTxt);
        panel.add(searchTimeTxt);
        panel.add(numberFoundLbl);
        panel.add(numberPosLbl);
        panel.add(numberFoundTxt);
        panel.add(numberPosTxt);

        frame.setVisible(true);

        arrSizeInput.setText("5");
        numberSearchInput.setText("5");
    }
    public static void displayInitArr(int arrSize) throws IOException
    {
        try 
        {
            init.read(new BufferedReader(new FileReader("src\\unsorted.txt")), null);
        }
        catch (Exception e)
        {
            errorPopUp(e);
        }
    }
    public static void displaySortArr()
    {
        try
        {
            fin.read(new BufferedReader(new FileReader("src\\sorted.txt")), null);
        }
        catch (Exception e)
        {
            errorPopUp(e);
        }
    }
    public static void errorPopUp(Exception e)
    {
        JOptionPane.showMessageDialog(null, new JLabel("An error has occured: " + e));
    }
    public static void reminderPopUp(String e)
    {
        JOptionPane.showMessageDialog(null, new JLabel(e));
    }
}

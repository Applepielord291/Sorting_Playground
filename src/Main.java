import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static int bubbleSort = 1;
    public static int selectSort = 2;
    public static int insertSort = 3;
    public static int quickSort = 4;
    public static int shellSort = 5;

    public static int linearSearch = 1;
    public static int binarySearch = 2;
    public static int noSearch = 3;

    public static int currentSortChoice = 0;
    public static int currentSearchChoice = 0;

    boolean arrayIsReal = false;

    public static int[] array;
    public static void main(String[] args) throws Exception 
    {
        Frame.displayFrame();
    }
    public static void userClickedBubble()
    {
        currentSortChoice = bubbleSort;
        Frame.selSort.setText("Bubble Sort");
    }
    public static void userClickedSelect()
    {
        currentSortChoice = selectSort;
        Frame.selSort.setText("Selection Sort");
    }
    public static void userClickedInsert()
    {
        currentSortChoice = insertSort;
        Frame.selSort.setText("Insertion Sort");
    }
    public static void userClickedQuick()
    {
        currentSortChoice = quickSort;
        Frame.selSort.setText("Quick Sort");
    }
    public static void userClickedShell()
    {
        currentSortChoice = shellSort;
        Frame.selSort.setText("Shell Sort");
    }
    public static void userClickedLinear()
    {
        currentSearchChoice = linearSearch;
        Frame.selSearch.setText("Linear Search");
    }
    public static void userClickedBinary()
    {
        currentSearchChoice = binarySearch;
        Frame.selSearch.setText("Binary Search");
    }
    public static void userClickedNoSearch()
    {
        currentSearchChoice = noSearch;
        Frame.selSearch.setText("No Search");
    }
    public static void generateRandom(int arrSize)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/unsorted.txt")))
        {
            array = new int[arrSize];
            for (int i = 0; i < array.length; i++)
            {
                array[i] = (int)Math.round(Math.random() * arrSize);
                bw.write(array[i] + "\n");
            }
            bw.close();
            Frame.displayInitArr(arrSize);
        }
        catch (Exception e)
        {
            Frame.errorPopUp(e);
        }
    }
    public static void userClickedRun(int key) throws IOException
    {
        if (currentSortChoice != 0)
        {
            double start = System.nanoTime() / 1000000;
            if (currentSortChoice == bubbleSort)
            {
                for (int i = 0; i < array.length-1; i++)
                {
                    for (int j = 0; j < array.length-i-1; j++)
                    {
                        if (array[j] > array[j+1] && i+1 < array.length)
                        {
                            int temp = array[j+1];
                            array[j+1] = array[j];
                            array[j] = temp;
                        }
                    }
                }
                PrintToNewFile(array);
            }

            else if (currentSortChoice == selectSort)
            {
                for (int i = 0; i < array.length - 1; i++)
                {
                    int min = array[i];
                    for (int j = i+1; j < array.length; j++)
                    {
                        if (array[j] < min)
                        {
                            min = array[j];
                            j = i;
                        }
                    }
                    for (int k = i; k < array.length + 1; k++)
                    {
                        if (array[k] == min)
                        {
                            array[k] = array[i];
                            array[i] = min;
                            break;
                        }
                    }
                }
                PrintToNewFile(array);
            }

            else if (currentSortChoice == insertSort)
            {
                for (int j = 1; j < array.length; j++)
                {
                    int i = j-1; 
                    int temp = array[j];
                    while (i >= 0 && temp < array[i])
                    {
                        int tempo = array[i + 1];
                        array[i + 1] = array[i];
                        array[i] = tempo;
                        i--;
                    }
                    array[i + 1] = temp;
                }
                PrintToNewFile(array);
            }

            else if (currentSortChoice == quickSort)
            {
                array = Quick(array, 0, array.length - 1);
                PrintToNewFile(array);
            }

            else if (currentSortChoice == shellSort)
            {
                for (int gap = array.length/2; gap > 0; gap /= 2) 
                { 
                    for (int i = gap; i < array.length; i++) 
                    { 
                        int temp = array[i];
                        int j;
                        for (j = i; j >= gap && array[j - gap] > temp; j -= gap) 
                        { 
                            array[j] = array[j - gap];
                        }
                        array[j] = temp; 
                    }
                }
                PrintToNewFile(array);
            }
            double end = System.nanoTime() / 1000000;
            Frame.sortTimeTxt.setText((end - start) + "");
        }
        else Frame.reminderPopUp("Fill in all the boxes");

        boolean found = false;
        if (currentSearchChoice != 0 || currentSearchChoice != 3)
        {
            double start = System.nanoTime() / 1000000;
            if (currentSearchChoice == 1)
            {
                for (int i = 0; i < array.length; i++)
                {
                    if (array[i] == key)
                    {
                        Frame.numberFoundTxt.setText("True");
                        Frame.numberPosTxt.setText((i+1) + "");
                        found = true;
                        break;
                    }
                }
            }
            if (currentSearchChoice == 2)
            {
                int first = 0; int mid = 0; int last = array.length-1; 
                while (first <= last) 
                {
                    if (array[mid] == key) 
                    {
                        Frame.numberFoundTxt.setText("True");
                        Frame.numberPosTxt.setText((mid+1) + "");
                        found = true;
                        break;
                    }
                    else if (array[mid] > key) last = mid-1; 
                    else if (array[mid] < key) first = mid+1;
                    mid = first + (last - first)/2;
                }
            }
            if (!found)
            {
                Frame.numberFoundTxt.setText("False");
                Frame.numberPosTxt.setText("None");
            }
            double end = System.nanoTime() / 1000000;
            Frame.searchTimeTxt.setText((end - start) + "");
        }
        else Frame.reminderPopUp("Fill in all the boxes");
    }
    public static void PrintToNewFile(int[] arr) throws IOException
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/sorted.txt")))
        {
            for (int i = 0; i < arr.length; i++)
            {
                bw.write(arr[i] + "\n");
            }
            bw.close();
        }
        catch (Exception e)
        {
            Frame.errorPopUp(e);
        }
        finally
        {
            Frame.displaySortArr();
        }
    }
    public static int[] Quick(int[] num, int lowLim, int highLim)
    {
        int i = lowLim; int j = highLim; int h;
        int x = num[(lowLim + highLim) / 2];
        do
        {
            while (num[i] < x) i++;
            while (num[j] > x) j--;
            if (i <= j)
            {
                h = num[i]; 
                num[i] = num[j]; 
                num[j] = h;
                i++; j--;
            }
        } while (i <= j);

        if (lowLim < j) Quick(num, lowLim, j);
        if (i < highLim) Quick(num, i, highLim);
        return num;
    }
}

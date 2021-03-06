import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {
    private ArrayList<Double> amounts = new ArrayList<>();
    private ArrayList<String> locations = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Integer> dates = new ArrayList<>();
    private String fileName;

    ////////////////////Constructors////////////////////

    ////////////////////File Reader////////////////////
    public void readFile() {
        for (String var : interpret(0)) {
            amounts.add(Double.parseDouble(var));
        }
        
        locations.addAll(Arrays.asList(interpret(1)));

        items.addAll(Arrays.asList(interpret(2)));

        for (String var : interpret(3)) {
            dates.add(Integer.parseInt(var));
        }
    }

    ////////////////////File Writer////////////////////
    public void writeFile(ArrayList<Double> amounts, ArrayList<String> locations, ArrayList<String> items, ArrayList<Integer> dates) {

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.flush();

            //writes each arrayList to StoredData.txt
            bufferedWriter.write(String.valueOf(amounts));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(locations));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(items));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(dates));

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }

    private String[] interpret(int lineNum) {
        String line, temp;
        String[] vars = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < lineNum; i++) {
                bufferedReader.readLine();
            }

            line = bufferedReader.readLine();
            temp = line.substring(1, line.length() - 1);
            vars = temp.split(", ");

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        return vars;
    }

    ////////////////////Getters and Setters////////////////////

    public ArrayList<Double> getAmounts() {
        return amounts;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<Integer> getDates() {
        return dates;
    }

    ////////////////////Constructors/////////////////////
    public FileHandler(String fileName) {
        this.fileName = fileName;
        readFile();
    }
}

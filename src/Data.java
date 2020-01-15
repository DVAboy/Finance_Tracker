import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

//Background functions for Finance Tracker
public class Data {
    private Clock clock = ();
    private ArrayList<Double> amounts = new ArrayList<>();
    private ArrayList<String> locations = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> dates = new ArrayList<>();

    ////////////////////Add Functions////////////////////
    public void addAmount() {
        System.out.print("enter the amount spent.");
        Scanner input = new Scanner(System.in);
        amounts.add(input.nextDouble());
    }

    public void addWhere() {
        System.out.print("enter where the transaction was held.");
        Scanner input = new Scanner(System.in);
        locations.add(input.nextLine());
    }

    public void addWhat() {
        System.out.print("enter what was purchased");
        Scanner input = new Scanner(System.in);
        items.add(input.nextLine());
    }
    
    public void addDate() {
        System.out.print("Enter the date");
        Scanner input = new Scanner(System.in);
        dates.add(input.nextLine());
    }
    
    private 

    ////////////////////Get Functions////////////////////
    public void getAmountList(int transaction) {
        Double amount = amounts.get(transaction);
        System.out.print("$" + amount + ", ");
    }

    public void getWhereList(int transaction) {
        String where = locations.get(transaction);
        System.out.print(where + ", ");
    }

    public void getWhatList(int transaction) {
        String what = items.get(transaction);
        System.out.println(what + ", ");
    }

    ////////////////////Calculator////////////////////
    public void calcTotal() {
        Double total = 0.0;
        for (int x = 0; x < amounts.size(); x++) {
            total += amounts.get(x);
        }
        System.out.printf("Your total amount spent was $%4.2f", total);
        System.out.println(" ");
    }

    ////////////////////File Reader////////////////////
    public void readFile() {
        String fileName = "StoredData.txt";
        String line = null;
        int l = 1;
        String[] vars;
        String temp;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                temp = line.substring(1, line.length() - 1);
                vars = temp.split(", ");
                switch (l++) {
                    case 1:
                        for (int o = 0; o < vars.length; o++) {
                            amounts.add(Double.parseDouble(vars[o]));
                        }
                        break;
                    case 2:
                        for (int o = 0; o < vars.length; o++) {
                            locations.add(vars[o]);
                        }
                        break;
                    case 3:
                        for (int o = 0; o < vars.length; o++) {
                            items.add(vars[o]);
                        }
                        break;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    ////////////////////File Writer////////////////////
    public void writeFile() {
        String fileName = "StoredData.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.flush();

            bufferedWriter.write(String.valueOf(amounts));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(locations));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(items));

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}

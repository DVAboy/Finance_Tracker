import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//Background functions for Finance Tracker
public class Data {
    private FileHandler file = new FileHandler("StoredData.txt");
    private Calendar calendar = new GregorianCalendar();
    private ArrayList<Double> amounts;
    private ArrayList<String> locations;
    private ArrayList<String> items;
    private ArrayList<Integer> dates;

    ////////////////////Add Functions////////////////////
    public void addAmount() {
        System.out.print("Enter the amount spent. ");
        Scanner input = new Scanner(System.in);
        amounts.add(input.nextDouble());
    }

    public void addWhere() {
        System.out.print("Enter where the transaction was held. ");
        Scanner input = new Scanner(System.in);
        locations.add(input.nextLine());
    }

    public void addWhat() {
        System.out.print("Enter what was purchased ");
        Scanner input = new Scanner(System.in);
        items.add(input.nextLine());
    }

    public void addDate() {
        dates.add(calendar.get(Calendar.MONTH));
        dates.add(calendar.get(Calendar.DATE));
        dates.add(calendar.get(Calendar.YEAR));
    }

    ////////////////////Get Functions////////////////////
    //amounts
    public Double getAmount(int transaction) {
        return amounts.get(transaction);
    }

    public ArrayList<Double> getAmountList() {
        return amounts;
    }

    //locations
    public String getWhere(int transaction) {
        return locations.get(transaction);
    }

    public ArrayList<String> getWhereList() {
        return locations;
    }

    //items
    public String getWhat(int transaction) {
        return items.get(transaction);
    }

    public ArrayList<String> getWhatList() {
        return items;
    }

    //dates
    public Integer getWhen(int transaction) {
        return dates.get(transaction);
    }

    public ArrayList<Integer> getWhenList() {
        return dates;
    }

    ////////////////////Calculator////////////////////
    public void calcTotal() {
        Double total = 0.0;
        for (Double amount : amounts) {
            total += amount;
        }
        System.out.printf("Your total amount spent was $%4.2f", total);
        System.out.println(" ");
    }

    /////////////////////Writer////////////////////
    public void writeToFile(){
        file.writeFile(getAmountList(), getWhereList(), getWhatList(), getWhenList());
    }

    ////////////////////Constructors////////////////////
    public Data () {
        this.amounts = file.getAmounts();
        this.locations = file.getLocations();
        this.items = file.getItems();
        this.dates = file.getDates();
    }
}

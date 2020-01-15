import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//Background functions for Finance Tracker
public class Data {
    private Calendar calendar = new GregorianCalendar();
    private ArrayList<Double> amounts = new ArrayList<>();
    private ArrayList<String> locations = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Integer> dates = new ArrayList<>();

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
        dates.add(calendar.get(Calendar.MONTH));
        dates.add(calendar.get(Calendar.DATE));
        dates.add(calendar.get(Calendar.YEAR));
    }

    ////////////////////Get Functions////////////////////
    //amounts
    public void getAmountList(int transaction) {
        System.out.print("$" + amounts.get(transaction) + ", ");
    }

    public ArrayList<Double> getAmountList() {
        return amounts;
    }

    //locations
    public void getWhereList(int transaction) {
        System.out.print(locations.get(transaction) + ", ");
    }

    public ArrayList<String> getWhereList() {
        return locations;
    }

    //items
    public void getWhatList(int transaction) {
        System.out.println(items.get(transaction) + ", ");
    }

    public ArrayList<String> getWhatList() {
        return items;
    }

    //dates
    public void getWhenList(int transaction) {
        System.out.println(dates.get(transaction));
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
}

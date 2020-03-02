import java.util.Scanner;

//user interface
public class Finance_Tracker {
    private Data data = new Data();

    ////////////////////User Interface////////////////////
    public void userInterface() {
        Scanner input = new Scanner(System.in);
        String response = "default";
        while (!"close".equals(response.toLowerCase())) {
            System.out.println("What would you like to do? (1 - Add Transaction, 2 - Previous Transaction, 3 - Get Total, 4 - Close)");
            response = input.nextLine();
            switch (response.toLowerCase()) {
                //add transaction responses
                case "add transaction":
                    addTransaction();
                    break;
                case "add":
                    addTransaction();
                    break;
                case "1":
                    addTransaction();
                    break;

                //previous transaction responses
                case "previous transaction":
                    getTransaction();
                    break;
                case "previous":
                    getTransaction();
                    break;
                case "2":
                    getTransaction();
                    break;

                //total calculator responses
                case "get total":
                    getTotal();
                    break;
                case "total":
                    getTotal();
                    break;
                case "3":
                    getTotal();
                    break;

                //close responses
                case "close":
                    response = "close";
                    break;  //this prevents from asking what to do again
                case "4":
                    response = "close";
                    break;  //this prevents from asking what to do again

                default:
                    System.out.println("Please enter one of the specified responses, examples: Add Transaction, Add, 1");
                    break;
            }
        }
        System.out.println("Thank you for using finance Tracker.");
        data.writeToFile();
    }

    ////////////////////Transaction Adder////////////////////
    private void addTransaction() {
        data.addAmount();
        data.addWhere();
        data.addWhat();
        data.addDate();
        System.out.println("The transaction has been added to the records");
    }

    ////////////////////Gets Previous Transaction////////////////////
    private void getTransaction() {
        int transaction = 0;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("which transaction would you like to see?");
            transaction = input.nextInt() - 1;
            System.out.print("You Spent ");
            System.out.print("$" + data.getAmount(transaction) + " on ");
            System.out.print(data.getWhat(transaction) + " at ");
            System.out.print(data.getWhere(transaction) + " on ");

            System.out.print(data.getWhen(transaction * 3) + "/");
            System.out.print(data.getWhen(transaction * 3 + 1) + "/");
            System.out.println(data.getWhen(transaction * 3 - 1) + ".");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no transaction in position " + transaction + ".");
        }
    }

    ////////////////////Total Calculator////////////////////
    private void getTotal() {
        data.calcTotal();
    }

    ////////////////////Constructors////////////////////
    public Finance_Tracker() {

    }
}

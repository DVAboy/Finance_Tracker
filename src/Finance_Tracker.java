import java.util.Scanner;

//user interface
public class Finance_Tracker {
    private Data data = new Data();
    private FileHandler file = new FileHandler();

    ///////////////////////////////User Interface///////////////////////////////
    public void userInterface() {
        Scanner input = new Scanner(System.in);
        String response = "default";
        while (!"close".equals(response.toLowerCase())) {
            file.readFile();
            System.out.println("What would you like to do? (1 - Add Transaction, 2 - Previous Transaction, 3 - Get Total, 4 - Close)");
            response = input.nextLine();
            switch (response.toLowerCase()) {
                case "add transaction":
                    addTransaction();
                    break;
                case "add":
                    addTransaction();
                    break;
                case "1":
                    addTransaction();
                    break;

                case "previous transaction":
                    getTransaction();
                    break;
                case "previous":
                    getTransaction();
                    break;
                case "2":
                    getTransaction();
                    break;

                case "get total":
                    getTotal();
                    break;
                case "total":
                    getTotal();
                    break;
                case "3":
                    getTotal();
                    break;

                case "close":
                    break;  //this prevents from asking what to do again
                case "4":
                    break;  //this prevents from asking what to do again

                default:
                    System.out.println("Please enter one of the specified responses, examples: Add Transaction, Add, 1");
                    break;
            }
        }
        System.out.println("Thank you for using finance Tracker.");
        file.writeFile(data.getAmountList(), data.getWhereList(), data.getWhatList(), data.getWhenList());
    }

    ///////////////////////////////FileHandler return///////////////////////////////
    private void receiveHistory() {

    }

    ///////////////////////////////Transaction Adder///////////////////////////////
    public void addTransaction() {
        data.addAmount();
        data.addWhere();
        data.addWhat();
        data.addDate();
        System.out.println("The transaction has been added to the records");
    }

    ///////////////////////////////Gets Previous Transaction///////////////////////////////
    public void getTransaction() {
        int transaction = 0;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("which transaction would you like to see?");
            transaction = input.nextInt();
            data.getAmountList(transaction);
            data.getWhereList(transaction);
            data.getWhatList(transaction);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no transaction in position " + transaction + ".");
        }
    }

    ///////////////////////////////Total Calculator///////////////////////////////
    public void getTotal() {
        data.calcTotal();
    }
}

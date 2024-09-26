import java.util.Scanner;
    public class Main {
    public static void Menu(){
        System.out.println("Enter 1 if you want to add a new employee");
        System.out.println("Enter 2 if you want to get an employee's details by ID");
        System.out.println("Enter 3 if you want to show all the employees");
        System.out.println("Enter 4 if you want to update an employee");
        System.out.println("Enter 5 if you want to delete an employee");
        System.out.println("Enter 0 if you want to exit");
    }
    public static void main(String[] args) {
        int id;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our Employee Management System");
        boolean exit = false;
        while(!exit){
            Empoclass empo=new Empoclass();
            Employee emp=new Employee();
            Menu();
            int option=input.nextInt();
            switch(option){
                case 1:
                   empo. addNewEmployee();
                   break;
                case 2:
                    empo.getEmployeeDetailGivenId();
                    break;
                case 3:
                    empo.showAllEmployees();
                    break;
                case 4:
                    empo.updateEmployee();
                    break;
                case 5:
                    empo.deleteEmployee();
                    break;
                case 0:
                    System.out.println("You are welcomed . Thank you for using our Employee Management System");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option ... Have a nother try");
            }
        }
    }
}
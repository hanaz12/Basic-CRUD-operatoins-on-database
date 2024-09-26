import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.*;
public class Empoclass implements EmpoInterface{
    Connection con;
    Scanner input = new Scanner(System.in);
    public Employee getData(){
        Employee emp = new Employee();
        System.out.println("Please enter employee name: ");
        String name=input.nextLine();
        emp.setName(name);
        System.out.println("Please enter employee salary: ");
        double salary=input.nextDouble();
        emp.setSalary(salary);
        return emp;
    }
    @Override
    public void addNewEmployee(){
       Employee ob=getData();

       try{
           con=DB_Connection.createDBConnection();
           String sql="INSERT INTO employeeData (name, salary) VALUES (?, ?)";
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setString(1,ob.getName());
           ps.setDouble(2,ob.getSalary());
          int cnt= ps.executeUpdate();
          if(cnt>0){
              System.out.println("New employee added sucessfully");
          }
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    @Override
    public void getEmployeeDetailGivenId(){
        System.out.println("please enter employee id: ");
        int id=input.nextInt();
        try {
            con = DB_Connection.createDBConnection();
            String sql="select * from employeeData where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                double salary=rs.getDouble("salary");
                System.out.printf("Name: %s\nSalary: %.2f\n",name,salary);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void showAllEmployees(){
    try{
        con = DB_Connection.createDBConnection();
        String sql="select * from employeeData";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        System.out.println("id\tname\tsalary");
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double salary=rs.getDouble("salary");
            System.out.printf("%d\t,%s\t,%f\t",id,name,salary);
            System.out.println();
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    @Override
    public void deleteEmployee(){
        System.out.println("please enter employee id: ");
        int id=input.nextInt();
        try {
            con = DB_Connection.createDBConnection();
            String sql="delete from employeeData where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int cnt= ps.executeUpdate();
            if(cnt>0){
                System.out.println("Employee deleted successfully");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateEmployee(){
        System.out.println("please enter employee id: ");
        int id=input.nextInt();
        try{
            con=DB_Connection.createDBConnection();
            System.out.println("Please enter new salary");
            double salary=input.nextDouble();
            String sql="update employeeData set salary=? where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,salary);
            ps.setInt(2,id);
            int cnt= ps.executeUpdate();
            if(cnt>0){
                System.out.println("Employee updated successfully");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

public class EmployeeMain {

    public static void main(String[] args) {
        System.out.println("Employee Management System");

        SalaryEmp salariedEmployee = new SalaryEmp("Alice", 101, "Engineering", 160);
        System.out.println("Salaried Employee Pay: " + salariedEmployee.pay());
        salariedEmployee.displayEmployeeDetails();
    }

}
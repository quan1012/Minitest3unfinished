package count;


import nv1.Employee;
import nv1.FullTimeEmployee;
import nv1.PartTimeEmployee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class EmployeeManager {
    private final List<Employee> employees;

    //Data saving----------------------------------------------------------------------
    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    //CRUD Employee--------------------------------------------------------------------
    public void addNewEmployee(Employee employee) {  // Thêm
        employees.add(employee);
    }

    public void displayEmployees() {  //Hiển thị danh sách
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void deleteByEmploy() {  // xóa
        if (employees.size() == 0) {
            System.out.println("Không có dữ liệu để xóa! ");
        } else {
            employees.remove(employees.size() - 1);
        }
    }

    public void editEmployee(Scanner input) {
        String newId;
        String newName;
        int newAge;
        String newPhone;
        String newEmail;
        double newBonus;
        double newFine;
        double newHardSalary;
        System.out.println("Mời bạn nhập vào id nhân viên: ");
        String id = input.nextLine();
        for (Employee e : employees) {
            if (id.equals(e.getId())) {
                if (e instanceof FullTimeEmployee) {
                    System.out.print("Mời bạn nhập mã nhân viên  : ");
                    newId = input.nextLine();
                    System.out.print("Mời bạn nhập tên nhân viên : ");
                    newName = input.nextLine();
                    System.out.print("Mời bạn nhập tuổi nhân viên : ");
                    newAge = Integer.parseInt(input.nextLine());
                    System.out.print("Mời bạn nhập sđt nhân viên : ");
                    newPhone = input.nextLine();
                    System.out.print("Mời bạn nhập email nhân viên : ");
                    newEmail = input.nextLine();
                    System.out.print("Mời bạn nhập tiền thưởng nhân viên : ");
                    newBonus = Integer.parseInt(input.nextLine());
                    System.out.print("Mời bạn nhập tiền phạt nhân viên : ");
                    newFine = Integer.parseInt(input.nextLine());
                    System.out.print("Mời bạn nhập lương cơ bản của nhân viên : ");
                    newHardSalary = Integer.parseInt(input.nextLine());
                    e.setId(newId);
                    e.setFullName(newName);
                    e.setAge(newAge);
                    e.setPhone(newPhone);
                    e.setEmail(newEmail);
                    ((FullTimeEmployee) e).setBonus(newBonus);
                    ((FullTimeEmployee) e).setFine(newFine);
                    ((FullTimeEmployee) e).setHardSalary(newHardSalary);
                } else if (e instanceof PartTimeEmployee) {
                    System.out.print("Mời bạn nhập mã nhân viên  : ");
                    newId = input.nextLine();
                    System.out.print("Mời bạn nhập tên nhân viên : ");
                    newName = input.nextLine();
                    System.out.print("Mời bạn nhập tuổi nhân viên : ");
                    newAge = Integer.parseInt(input.nextLine());
                    System.out.print("Mời bạn nhập sđt nhân viên : ");
                    newPhone = input.nextLine();
                    System.out.print("Mời bạn nhập email nhân viên : ");
                    newEmail = input.nextLine();
                    System.out.print("Mời bạn nhập số giờ làm việc : ");
                    double newWorkTime = Integer.parseInt(input.nextLine());
                    e.setId(newId);
                    e.setFullName(newName);
                    e.setAge(newAge);
                    e.setPhone(newPhone);
                    e.setEmail(newEmail);
                    ((PartTimeEmployee) e).setWorkTime(newWorkTime);
                }
            }
        }
    }
    public double totalSalaryAllEmployees() {
        double totalSalary;
        double FullTimeSalary = 0;
        double PartTimeSalary = 0;
        for (Employee nv : employees) {
            if (nv instanceof FullTimeEmployee) {
                FullTimeSalary += ((FullTimeEmployee) nv).fullTimePractice();
            }
            if (nv instanceof PartTimeEmployee) {
                PartTimeSalary += ((PartTimeEmployee) nv).partTimePractice();
            }
        }
        totalSalary = FullTimeSalary + PartTimeSalary;
        return totalSalary;
    }

    public double averageSalary() {
        return totalSalaryAllEmployees() / employees.size();
    }

}
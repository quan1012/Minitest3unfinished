package Main;

import count.EmployeeManager;
import nv1.Employee;
import nv1.FullTimeEmployee;
import nv1.PartTimeEmployee;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Employee> employees = new ArrayList<>();
    public static EmployeeManager employee = new EmployeeManager(employees);
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;

    public static void main(String[] args) {

        do {
            System.out.println("-----------------------------------Menu-------------------------------------");
            System.out.println(
                    """
                            1. Thêm nhân viên mới
                            2. Sửa thông tin nhân viên
                            3. Xóa thông tin nhân viên
                            4. Danh sách nhân viên công ty
                            5. Tổng lương của tất cả nhân viên
                            6. Trung bình lương thực lĩnh của tất cả nhân viên
                            7. Danh sách nhân viên full time có mức lương thấp hơn so với mức lương trung bình của cả công ty
                            8. Tổng lương của nhân viên làm part time
                            9. Danh sách nhân viên full time có mức lương tăng dần
                            0. thoát chương trình""");
            System.out.print("Mời bạn chọn...");
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> employee.addNewEmployee(addNewEmployee());
                case 2 -> employee.editEmployee(input);
                case 3 -> employee.deleteByEmploy();
                case 4 -> {
                    System.out.println("Danh sách nhân viên công ty");
                    employee.displayEmployees();
                }
                case 5 -> System.out.println("Tổng lương của tất cả nhân viên :" + employee.totalSalaryAllEmployees());
                case 6 ->
                        System.out.println("Trung bình lương thực lĩnh của tất cả nhân viên :" + employee.averageSalary());
                case 0 -> System.exit(checkInput);
                default -> System.out.println("Nhập sai dữ liệu!");
            }
        } while (true);
    }

    public static Employee addNewEmployee() {
        System.out.println("""
                Bạn muốn thêm nhân viên :
                1. nhân viên full time
                2. nhân viên part time
                0. thoát""");
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                System.out.print("Mời bạn nhập mã nhân viên  : ");
                String id = input.nextLine();
                System.out.print("Mời bạn nhập tên nhân viên : ");
                String name = input.nextLine();
                System.out.print("Mời bạn nhập tuổi nhân viên : ");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Mời bạn nhập sđt nhân viên : ");
                String phone = input.nextLine();
                System.out.print("Mời bạn nhập email nhân viên : ");
                String email = input.nextLine();
                System.out.print("Mời bạn nhập tiền thưởng nhân viên : ");
                double bonus = Integer.parseInt(input.nextLine());
                System.out.print("Mời bạn nhập tiền phạt nhân viên : ");
                double fine = Integer.parseInt(input.nextLine());
                System.out.print("Mời bạn nhập lương cơ bản của nhân viên : ");
                double hardSalary = Integer.parseInt(input.nextLine());
                return new FullTimeEmployee(id, name, age, phone, email, bonus, fine, hardSalary);
            }
            case 2 -> {
                System.out.print("Mời bạn nhập mã nhân viên  : ");
                String id = input.nextLine();
                System.out.print("Mời bạn nhập tên nhân viên : ");
                String name = input.nextLine();
                System.out.print("Mời bạn nhập tuổi nhân viên : ");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Mời bạn nhập sđt nhân viên : ");
                String phone = input.nextLine();
                System.out.print("Mời bạn nhập email nhân viên : ");
                String email = input.nextLine();
                System.out.print("Mời bạn nhập số giờ làm việc nhân viên : ");
                double workTime = Integer.parseInt(input.nextLine());
                return new PartTimeEmployee(id, name, age, phone, email, workTime);
            }
            case 0 -> System.exit(checkInput);
            default -> System.out.println("Nhập dữ liệu không đúng !!");
        }
        return null;
    }
}
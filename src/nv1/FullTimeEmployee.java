package nv1;

public class FullTimeEmployee extends Employee implements Comparable<FullTimeEmployee> {
    private double bonus = 0;
    private double fine = 0;
    private double hardSalary = 0;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String id, String fullName, int age, String phone, String email, double bonus, double fine, double hardSalary) {
        super(id, fullName, age, phone, email);
        this.bonus = bonus;
        this.fine = fine;
        this.hardSalary = hardSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }

    public double fullTimePractice() {
        return this.hardSalary + (this.bonus - this.fine);
    }

    @Override
    public String toString() {
        return "Nhân viên Fulltime:" +
                " Mã nhân viên=" + getId() +
                ", Họ và tên=" + getFullName() +
                ", tuổi=" + getAge() +
                ", SĐT=" + getPhone() +
                ", email=" + getEmail() +
                ", Tiền thưởng=" + bonus +
                ", Tiền phạt=" + fine +
                ", Lương cứng=" + hardSalary + "\n";
    }

    @Override
    public int compareTo(FullTimeEmployee o) {
        return Double.compare(this.hardSalary, o.hardSalary);
    }
}
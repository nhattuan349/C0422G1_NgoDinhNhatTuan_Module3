package model;

public class Employee extends Person {
    private String level;
    private String location;
    private float salary;

    public Employee() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getCode(),
                super.getFullName(),
                super.getGenDer(),
                super.getId(),
                super.getNumberPhone(),
                super.getEmail(),
                getLevel(),
                getLocation(),
                getSalary()
        );

    }

    public Employee(String virginity, String location, float salary) {
        this.level = virginity;
        this.location = location;
        this.salary = salary;
    }

    public Employee(int code, String fullName, String genDer, int id, int numberPhone, String email, String level, String location, float salary) {
        super(code, fullName, genDer, id, numberPhone, email);
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public String getLevel() {

        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee Tên là: " + getFullName() +
                " Vi tri: " + location +
                " Luong: " + salary + " Triệu VNĐ " +
                "co ma so: " + getCode() +
                " Trình độ: " + level +
                " Gioi tinh: " + getGenDer() +
                " id: " + getId() +
                " SDT: " + getNumberPhone() +
                " Email: " + getEmail();

    }
}



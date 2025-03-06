public class Employee {
    private static int counter = 0;
    private int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = ++counter;
        this.fullName = fullName;
        setDepartment(department);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 6) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5 ");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException(" Зарплата не должна быть отрицательной ");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    @Override
    public String toString() {
        return String.format("ID: %d, ФИО: %s, Отдел: %d, Зарплата: %.2f", id, fullName, department, salary);
    }
}


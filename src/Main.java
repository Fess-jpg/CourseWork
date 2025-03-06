import java.util.Arrays;

public class Main {
    private static Employee[] employees = new Employee[10]; // Массив для хранения сотрудников

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(new Employee("Сергеев Сергей Сергеевич", 6, 23_000));

        employeeBook.addEmployee(new Employee("Иванов Иван Иванович", 1, 50000));
        employeeBook.addEmployee( new Employee("Петров Пётр Петрович", 2, 60000));
        employeeBook.addEmployee( new Employee("Сидоров Сидор Сидорович", 3, 45000));
        employeeBook.addEmployee( new Employee("Алексеев Алексей Алексеевич", 4, 70000));
        employeeBook.addEmployee( new Employee("Николаев Николай Николаевич", 5, 80000));

        employeeBook.printAllEmployees();

        employeeBook.removeEmployee(1);

        System.out.println(" После удаления сотрудника id-1 ");

        printAllEmployees();

        Employee searchedEmployee = employeeBook.getEmployeeById(3);
        if (searchedEmployee != null) {
            System.out.println(" Найден сотрудник " + searchedEmployee);
        } else {
            System.out.println(" Сотрудник не найден ");}

        System.out.println("Сумма затрат на ЗП в месяц: " + calculateTotalSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат: " + calculateAverageSalary());
        printEmployeeNames();
    }

    public static void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double calculateTotalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    public static Employee findEmployeeWithMinSalary() {
        return Arrays.stream(employees)
                .filter(emp -> emp != null)
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    public static Employee findEmployeeWithMaxSalary() {
        return Arrays.stream(employees)
                .filter(emp -> emp != null)
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    public static double calculateAverageSalary() {
        double total = calculateTotalSalary();
        long count = Arrays.stream(employees).filter(emp -> emp != null).count();
        return count > 0 ? total / count : 0;
    }

    public static void printEmployeeNames() {
        System.out.println("ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }

    }
}

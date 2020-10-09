package ru.geekbrains;

public class Employee {
    private String fullName;
    private String position;
    private String eMail;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String eMail, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployeeInfo() {
        System.out.println("Employee name: " + this.fullName);
        System.out.println("Position: " + this.position);
        System.out.println("e-mail: " + this.eMail);
        System.out.println("Work phone: " + this.phone);
        System.out.println("Monthly salary: " + this.salary + " USD");
        System.out.println("Age: " + this.age);
        System.out.println();
    }

    public void printEmployeeInfoOver(int age) {
        if (this.age >= age) {
            printEmployeeInfo();
        }
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        // ******* create array of size 5 of type Employee
        int n = 5;
        Employee[] eeArray = new Employee[n];

        // ******* prepare field content for employee objects
        String[] rndName = {"Roman Coppola", "Emma Watson", "Steven Spielberg", "Sandra Bullock", "Rowan Atkinson"};
        String[] rndPosition = {"Film Producer", "Actress", "Studio Director", "Super Star", "Comic Actor"};
        String[] rndEmail = {"rom.cop@mail.ru", "emma88@gmail.com", "steven_sp@yahoo.com", "sandra4ka@yandex.ru", "eng_rowan@mail.gb"};
        String[] rndPhone = new String[n];
        for (int i = 0; i < n; i++) {
            String prefix = Integer.toString((int) (Math.random() * 1000));
            rndPhone[i] = "+(" + prefix + ")" + (int) (Math.random() * 9999999);
        }
        int[] rndSalary = {1000000, 500000, 1500000, 800000, 700000};
        int[] rndAge = {62, 32, 73, 39, 56};

        // ******* populating the employee array
        for (int i = 0; i < n; i++) {
            eeArray[i] = new Employee(rndName[i], rndPosition[i], rndEmail[i], rndPhone[i], rndSalary[i], rndAge[i]);
        }

        // ******* printing details of employees over 40 years
        for (int i = 0; i < n; i++) {
            if (eeArray[i].getAge() >= 40) {
                eeArray[i].printEmployeeInfo();
            }
        }
        // ******* another version
        for (int i = 0; i < n; i++) {
            eeArray[i].printEmployeeInfoOver(40);
        }
    }
}

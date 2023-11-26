package homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee worker1 = new Worker("Сергей", 700, 65);
        Worker worker2 = new Worker("Алексей", 500, 70);
        Employee worker3 = new Worker("Светлана", 900, 30);
        Worker worker4 = new Worker("Нина", 200, 18);

        Employee freelancer1 = new Freelancer("Иван", 40, 5);
        Freelancer freelancer2 = new Freelancer("Игорь", 50, 6);
        Employee freelancer3 = new Freelancer("Ольга", 30, 4);
        Freelancer freelancer4 = new Freelancer("Ирина", 20, 8);

        List<Employee> staff = new ArrayList<>();
        staff.add(worker1);
        staff.add(freelancer3);
        staff.add(freelancer2);
        staff.add(worker4);
        staff.add(worker3);
        staff.add(freelancer1);
        staff.add(worker2);
        staff.add(freelancer4);

        System.out.println(staff);

        Collections.sort(staff);

        System.out.println(staff);

//        System.out.printf("%.2f%n", worker1.averageMonthlySalary());
//        System.out.printf("%.2f%n",freelancer1.averageMonthlySalary());
//
//        System.out.printf("%.2f%n",worker2.averageMonthlySalary());
//        System.out.printf("%.2f%n", freelancer2.averageMonthlySalary());
//
//        System.out.printf("%.2f%n",worker3.averageMonthlySalary());
//        System.out.printf("%.2f%n", freelancer3.averageMonthlySalary());
//
//        System.out.printf("%.2f%n",worker4.averageMonthlySalary());
//        System.out.printf("%.2f%n", freelancer4.averageMonthlySalary());
//
//
        for (Employee employee: staff) {
            if (employee.averageMonthlySalary() <= 500) {
                System.out.printf("%s получает премию в размере 200 фантиков \n", employee);
            }
            if (employee.averageMonthlySalary() <= 800) {
                System.out.printf("%s получает один отгул\n", employee);
            }
            if (employee.averageMonthlySalary() > 800) {
                    System.out.printf("%s У вас и так высокая зарплата!!!\n", employee);
            }

        }

        System.out.println("------------------------------------------");

        DismissalList dismissalListlist = new DismissalList();
        dismissalListlist.addEmployee(worker2);
        dismissalListlist.addEmployee(worker1);
        dismissalListlist.addEmployee(worker4);
        dismissalListlist.addEmployee(worker3);

        dismissalListlist.addEmployee(freelancer4);
        dismissalListlist.addEmployee(freelancer1);
        dismissalListlist.addEmployee(freelancer3);
        dismissalListlist.addEmployee(freelancer2);

        for (Employee e : dismissalListlist) {
            if (e.getAge() > 60) {
                System.out.printf("%s необходимо уволить \n", e);
            } else {
                System.out.printf("%s необходимо повысить зарплату \n", e);
            }
        }
    }
}

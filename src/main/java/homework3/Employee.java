package homework3;

import java.util.Objects;

public abstract class Employee implements Comparable<Employee> {

    private String name;
    private int age;


    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double averageMonthlySalary();

    @Override
    public String toString() {
        return "Сотрудник " + name + ":\n";
    }

    @Override
    public int compareTo(Employee o) {
        if (this.averageMonthlySalary() > o.averageMonthlySalary()) {
            return 1;
        }
        if (this.averageMonthlySalary() < o.averageMonthlySalary()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

//    @Override
//    public Iterator<Employee> iterator() {
//        return new Iterator<Employee>() {
//            @Override
//            public boolean hasNext() {
//                return index < components.size();
//            }
//
//            @Override
//            public Component next() {
//                return components.get(index++);
//            }
//        };
//    }
}


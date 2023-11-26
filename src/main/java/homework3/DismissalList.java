package homework3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DismissalList implements Iterable <Employee> {
    private List<Employee> dismissal;
    int index = 0;

    public DismissalList() {
        this.dismissal = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        if (employee == null) throw new NullPointerException("Сотрудник должен быть! ;)");
        dismissal.add(employee);
    }


    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < dismissal.size();
            }
            @Override
            public Employee next() {
                return dismissal.get(index++);
            }
        };
    }
}

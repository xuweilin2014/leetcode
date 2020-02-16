package xu.bfs;

import java.util.ArrayList;
import java.util.List;

public class Problem690 {

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    private int sum = 0;

    public int getImportance(List<Employee> employees, int id) {
        List<Employee> emps = new ArrayList<>();
        Employee employee = getEmployee(employees, id);
        sum += employee.importance;
        for (int subordinate : employee.subordinates) {
            Employee emp = getEmployee(employees, subordinate);
            emps.add(emp);
        }

        while (!emps.isEmpty()){
            List<Employee> newEmps = new ArrayList<>();
            for (Employee emp : emps) {
                sum += emp.importance;
                for (int subid : emp.subordinates) {
                    newEmps.add(getEmployee(employees, subid));
                }
            }
            emps = newEmps;
        }

        return sum;
    }

    public Employee getEmployee(List<Employee> employees, int id){
        for (Employee employee : employees) {
            if (employee.id == id)
                return employee;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

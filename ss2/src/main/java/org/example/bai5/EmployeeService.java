package org.example.bai5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    public EmployeeService() {
        employees.add(new Employee("NV001", "Nguyễn Thị Lan", "Kế toán", 15000000.0, "2020-03-01", "Đang làm"));
        employees.add(new Employee("NV002", "Trần Văn Hùng", "Kỹ thuật", 25000000.0, "2019-07-15", "Đang làm"));
        employees.add(new Employee("NV003", "Lê Minh Đức", "Kinh doanh", 18500000.0, "2021-11-20", "Nghỉ phép"));
        employees.add(new Employee("NV004", "Phạm Thu Hương", "Kỹ thuật", 22000000.0, "2022-01-05", "Đang làm"));
        employees.add(new Employee("NV005", "Hoàng Văn Nam", "Kế toán", 12000000.0, "2023-06-10", "Thử việc"));
    }
    public List<Employee> getAll() { return employees; }
    public Employee getByCode(String code) {
        return employees.stream().filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public double getTotalSalaryByDept(String dept) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(dept))
                .mapToDouble(Employee::getSalary).sum();
    }
}

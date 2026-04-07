package org.example.bai5;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"loggedUser", "role"})
public class MainController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/loginbai5")
    public String loginPage() { return "loginbai5"; }
    @PostMapping("/loginbai5")
    public String doLogin(@RequestParam("username") String user, @RequestParam("password") String pass, HttpSession session, Model model) {
        if ("manager123".equals(user) && "123456".equals(pass)) {
            session.setAttribute("loggedUser", user);
            session.setAttribute("role", "manager");
            return "redirect:/employees";
        } else if ("staff123".equals(user) && "staff456".equals(pass)) {
            session.setAttribute("loggedUser", user);
            session.setAttribute("role", "staff");
            return "redirect:/employees";
        }
        model.addAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu!");
        return "loginbai5";
    }

    @GetMapping("/employees")
    public String listEmployees(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/loginbai5";

        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("techTotalSalary", employeeService.getTotalSalaryByDept("Kỹ thuật"));
        return "/list";
    }

    @GetMapping("/employees/{code}")
    public String detail(@PathVariable("code") String code, HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/loginbai5";

        Employee emp = employeeService.getByCode(code);
        if (emp == null) throw new RuntimeException("Nhân viên [" + code + "] không tồn tại trong hệ thống");

        model.addAttribute("emp", emp);
        return "/detail";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginbai5";
    }
}

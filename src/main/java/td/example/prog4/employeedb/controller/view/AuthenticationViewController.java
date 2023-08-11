package td.example.prog4.employeedb.controller.view;

import td.example.prog4.employeedb.repository.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

;

@Controller
@AllArgsConstructor
public class AuthenticationViewController {
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("credentials", User.builder().build());
        return "login";
    }
}

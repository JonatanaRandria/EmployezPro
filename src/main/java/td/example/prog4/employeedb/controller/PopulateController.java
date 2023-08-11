package td.example.prog4.employeedb.controller;


import td.example.prog4.employeedb.config.CompanyConf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PopulateController {


    @ModelAttribute("companyConf")
    private CompanyConf populateCompanyConf(){
        return new CompanyConf();
    }
}
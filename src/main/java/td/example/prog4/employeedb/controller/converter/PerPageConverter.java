package td.example.prog4.employeedb.controller.converter;

import td.example.prog4.employeedb.model.utilities.PerPage;
import org.springframework.core.convert.converter.Converter;

public class PerPageConverter implements Converter<String, PerPage> {
    @Override
    public PerPage convert(String source) {
        return new PerPage(Integer.valueOf(source));
    }
}

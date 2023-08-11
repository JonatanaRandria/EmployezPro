package td.example.prog4.employeedb.controller.converter;

import td.example.prog4.employeedb.model.utilities.Page;
import org.springframework.core.convert.converter.Converter;

public class PageConverter implements Converter<String, Page> {
    @Override
    public Page convert(String source) {
        return new Page(Integer.valueOf(source));
    }
}

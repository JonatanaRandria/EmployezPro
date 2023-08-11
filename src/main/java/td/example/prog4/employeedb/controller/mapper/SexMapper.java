package td.example.prog4.employeedb.controller.mapper;

import td.example.prog4.employeedb.repository.entity.enums.Sex;
import org.springframework.stereotype.Component;

@Component
public class SexMapper {
    public Sex toDomain(String sex){
        try {
            return Sex.valueOf(sex);
        } catch (IllegalArgumentException e){
            return null;
        }
    }
}

package td.example.prog4.employeedb.controller.mapper;

import td.example.prog4.CnapsEmployeedb.model.CnapsEmployee;
import td.example.prog4.employeedb.model.exception.BadRequestException;
import td.example.prog4.employeedb.repository.PositionRepository;
import td.example.prog4.employeedb.repository.entity.Phone;
import td.example.prog4.employeedb.repository.entity.Position;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Transactional
public class EmployeeMapper {
    private PositionRepository positionRepository;
    private PhoneMapper phoneMapper;

    public td.example.prog4.employeedb.repository.entity.Employee toDomain(td.example.prog4.employeedb.model.Employee employee) {
        try {
            List<Position> positions = new ArrayList<>();
            employee.getPositions().forEach(position -> {
                Optional<Position> position1 = positionRepository.findPositionByNameEquals(position.getName());
                if (position1.isEmpty()) {
                    positions.add(positionRepository.save(position));
                } else {
                    positions.add(position1.get());
                }
            });

            List<Phone> phones = employee.getPhones().stream().map((td.example.prog4.employeedb.model.Phone fromView) -> phoneMapper.toDomain(fromView, employee.getId())).toList();

            td.example.prog4.employeedb.repository.entity.Employee domainEmployee = td.example.prog4.employeedb.repository.entity.Employee.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .address(employee.getAddress())
                    .cin(employee.getCin())
                    .cnaps(employee.getCnaps())
                    .registrationNumber(employee.getRegistrationNumber())
                    .childrenNumber(employee.getChildrenNumber())
                    // enums
                    .csp(employee.getCsp())
                    .sex(employee.getSex())
                    // emails
                    .professionalEmail(employee.getProfessionalEmail())
                    .personalEmail(employee.getPersonalEmail())
                    // dates
                    .birthDate(employee.getBirthDate())
                    .departureDate(employee.getDepartureDate())
                    .entranceDate(employee.getEntranceDate())
                    // lists
                    .phones(phones)
                    .positions(positions)
                    .build();
            MultipartFile imageFile = employee.getImage();
            if (imageFile != null && !imageFile.isEmpty()) {
                byte[] imageBytes = imageFile.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                domainEmployee.setImage("data:image/jpeg;base64," + base64Image);
            }
            return domainEmployee;
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public td.example.prog4.employeedb.model.Employee toView(td.example.prog4.employeedb.repository.entity.Employee employee) {
        return td.example.prog4.employeedb.model.Employee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .address(employee.getAddress())
                .cin(employee.getCin())
                .cnaps(employee.getCnaps())
                .registrationNumber(employee.getRegistrationNumber())
                .childrenNumber(employee.getChildrenNumber())
                // enums
                .csp(employee.getCsp())
                .sex(employee.getSex())
                .stringImage(employee.getImage())
                // emails
                .professionalEmail(employee.getProfessionalEmail())
                .personalEmail(employee.getPersonalEmail())
                // dates
                .birthDate(employee.getBirthDate())
                .departureDate(employee.getDepartureDate())
                .entranceDate(employee.getEntranceDate())
                // lists
                .phones(employee.getPhones().stream().map(phoneMapper::toView).toList())
                .positions(employee.getPositions())
                .build();
    }


    public td.example.prog4.employeedb.repository.entity.Employee toCnapsEmployeeView(td.example.prog4.employeedb.repository.entity.Employee employee, CnapsEmployee cnapsEmployee){
        td.example.prog4.employeedb.repository.entity.Employee employee1 = employee;
        employee1.setCnaps(cnapsEmployee.getCnaps());
        return  employee1;
    }

    public CnapsEmployee toCnapsEmployeeDomain(td.example.prog4.employeedb.repository.entity.Employee employee){
        return CnapsEmployee.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .address(employee.getAddress())
                .image(employee.getImage())
                .cin(employee.getCin())
                .cnaps(employee.getCnaps())
                .registrationNumber(employee.getRegistrationNumber())
                .childrenNumber(employee.getChildrenNumber())
                // enums
                // emails
                .professionalEmail(employee.getProfessionalEmail())
                .personalEmail(employee.getPersonalEmail())
                // dates
                .birthDate(employee.getBirthDate())
                .departureDate(employee.getDepartureDate())
                .entranceDate(employee.getEntranceDate())
                // lists
                .build();
    }
}

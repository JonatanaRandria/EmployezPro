package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.controller.model.EmployeeModel;
import com.hei.project2p1.controller.model.IdentityCardModel;
import com.hei.project2p1.controller.model.View.EmployeeView;
import com.hei.project2p1.model.EmployeeEntity;
import com.hei.project2p1.model.IdentityCardEntity;
import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.service.EmployeeService;
import com.hei.project2p1.service.IdenityCardSerivce;
import com.hei.project2p1.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeMapper {
    private final IdentityCardMapper identityCardMapper;
    private final IdenityCardSerivce identityCardSerivce;
    private final PhoneService phoneService;
    private final PhoneMapper phoneMapper;
    public EmployeeEntity toDomain(EmployeeModel employee){
        IdentityCardEntity identityCard = identityCardSerivce.saveCardIdentity(employee.getCardModel());

        List<PhoneEntity> phoneEntities = new ArrayList<>();
        if(employee.getPhoneNumbers().contains(",")){
            String[] elements = employee.getPhoneNumbers().split(",");
            for (String el : elements){

             phoneEntities.add(phoneService.save(phoneMapper.toDomain(el)))  ;
            }
        }
        PhoneEntity phoneEntity = phoneService.save(phoneMapper.toDomain(employee.getPhoneNumbers()));
        EmployeeEntity domainEmployeeEntity = EmployeeEntity.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthDate(employee.getBirthDate())
                .address(employee.getAddress())
                .workMail(employee.getWorkMail())
                .personalMail(employee.getPersonalMail())
                .jobFunction(employee.getJobFunction())
                .numberOfChildren(employee.getNumberOfChildren())
                .sex(employee.getSex().toString())
                .phoneNumbers(phoneEntities.size()>0 ? phoneEntities : List.of(phoneEntity))
                .hireDate(employee.getHireDate())
                .departureDate(employee.getDepartureDate())
                .identityCard(identityCard)
                .socioProfessionalCategory(employee.getSocioProfessionalCategory())
                .cnapsNumber(employee.getCnapsNumber())
                .build();


        try {
            MultipartFile imageFile = employee.getProfileImage();
            if (imageFile != null && !imageFile.isEmpty()) {
                // Get the image file content as a byte array
                byte[] imageBytes = imageFile.getBytes();

                // Convert the byte array to a Base64 string
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                domainEmployeeEntity.setProfileImage(base64Image);
            }
            return domainEmployeeEntity;
        }
        catch (Exception e){
            throw new RuntimeException("Bad Request");
        }
    }

    public EmployeeView toView(EmployeeEntity employeeEntity){

        return EmployeeView.builder()
                .id(employeeEntity.getId())
                .cardModel(identityCardMapper.toView(employeeEntity.getIdentityCard()))
                .sex(EmployeeModel.Sex.valueOf(employeeEntity.getSex()))
                .firstName(employeeEntity.getFirstName())
                .address(employeeEntity.getAddress())
                .hireDate(employeeEntity.getHireDate())
                .ref(employeeEntity.getRef())
                .lastName(employeeEntity.getLastName())
                .sex(EmployeeModel.Sex.valueOf(employeeEntity.getSex()))
                .jobFunction(employeeEntity.getJobFunction())
                .departureDate(employeeEntity.getDepartureDate())
                .personalMail(employeeEntity.getPersonalMail())
                .workMail(employeeEntity.getWorkMail())
                .phoneNumbers(employeeEntity.getPhoneNumbers().get(0).getPhoneNumber())
                .birthDate(employeeEntity.getBirthDate())
                .cnapsNumber(employeeEntity.getCnapsNumber())
                .socioProfessionalCategory(employeeEntity.getSocioProfessionalCategory())
                .numberOfChildren(employeeEntity.getNumberOfChildren())
                .build();
    }

    public EmployeeEntity toRest(EmployeeView employeeView){
        return EmployeeEntity.builder()
                .Id(employeeView.getId())
                .firstName(employeeView.getFirstName())
                .lastName(employeeView.getLastName())
                .address(employeeView.getAddress())
                .numberOfChildren(employeeView.getNumberOfChildren())
                .identityCard(identityCardMapper.toDomain(employeeView.getCardModel()))
                .birthDate(employeeView.getBirthDate())
                .jobFunction(employeeView.getJobFunction())
                .sex(String.valueOf(employeeView.getSex()))
                .workMail(employeeView.getWorkMail())
                .personalMail(employeeView.getPersonalMail())
                .hireDate(employeeView.getHireDate())
                .departureDate(employeeView.getDepartureDate())
                .cnapsNumber(employeeView.getCnapsNumber())
                .socioProfessionalCategory(employeeView.getSocioProfessionalCategory())
                .ref(employeeView.getRef())
                .build();
    }


}

package com.hei.project2p1.model.validator;

import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.model.exceptions.BadRequestException;
import com.hei.project2p1.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@AllArgsConstructor
@Component
public class PhoneValidator {
    private PhoneRepository phoneRepository;

    public void accept(String phone){

        String[] elements = phone.split(",");
        Set<String> uniqueElements = new HashSet<>();
        if(phoneRepository.findByPhoneNumber(phone)!=null){
            throw new BadRequestException("Phone number already exist");
        }
        if(elements.length>1){
            for (String element : elements) {
                if (!uniqueElements.add(element)) {
                    throw new BadRequestException("there is any duplicate in your phone number");
                };
                if(element.length()<9){
                    throw new BadRequestException("phone number must be at length of 9");
                }

            }
        }
        if(elements[0].length() <9){
            throw new BadRequestException("phone number must be at length of 9");
        } else if(phoneRepository.findByPhoneNumber(elements[0])!=null){
            throw new BadRequestException("Phone number already exist");
        }
    }


    public void acceptExceptNumber(String phone){

        String[] elements = phone.split(",");
        Set<String> uniqueElements = new HashSet<>();
        if(elements.length>1){
            for (String element : elements) {
                if (!uniqueElements.add(element)) {
                    throw new BadRequestException("there is any duplicate in your phone number");
                }
                if(element.length()<9){
                    throw new BadRequestException("phone number must be at length of 10");
                }
            }
        }

        if(elements[0].length() <9){
            throw new BadRequestException("phone number must be at length of 9");
        }
    }


}

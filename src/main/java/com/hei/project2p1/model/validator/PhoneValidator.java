package com.hei.project2p1.model.validator;

import com.hei.project2p1.model.PhoneEntity;
import com.hei.project2p1.model.exceptions.BadRequestException;
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

    public void accept(String phone){

        String[] elements = phone.split(",");
        Set<String> uniqueElements = new HashSet<>();
        if(elements.length>1){
            for (String element : elements) {
                if (!uniqueElements.add(element)) {
                    throw new BadRequestException("there is any duplicate in your phone number");
                };
                if(element.length()<13){
                    throw new BadRequestException("phone number must be at length of 10");
                }
            }
        }
        if(elements[0].length() <13){
            throw new BadRequestException("phone number must be at length of 10");
        }
    }


}

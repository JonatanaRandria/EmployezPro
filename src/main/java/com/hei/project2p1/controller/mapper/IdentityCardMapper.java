package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.controller.model.IdentityCardModel;
import com.hei.project2p1.model.IdentityCardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class IdentityCardMapper {

    public IdentityCardEntity toDomain(IdentityCardModel model){
        return IdentityCardEntity.builder()
                .cinNumber(model.getCinNumber())
                .cinIssueDate(model.getCinIssueDate())
                .cinIssuePlace(model.getCinIssuePlace())
                .build();
    }

    public IdentityCardModel toView(IdentityCardEntity identityCard){
        return IdentityCardModel.builder()
                .cinIssuePlace(identityCard.getCinIssuePlace())
                .cinNumber(identityCard.getCinNumber())
                .cinIssueDate(identityCard.getCinIssueDate())
                .build();
    }
    public IdentityCardEntity fromView(String number, String place, LocalDate date){
        return IdentityCardEntity.builder()
                .cinIssuePlace(place)
                .cinNumber(number)
                .cinIssueDate(date)
                .build();
    }
}

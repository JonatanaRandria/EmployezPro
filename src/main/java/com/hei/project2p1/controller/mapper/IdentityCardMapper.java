package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.controller.model.IdentityCardModel;
import com.hei.project2p1.model.IdentityCardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
}

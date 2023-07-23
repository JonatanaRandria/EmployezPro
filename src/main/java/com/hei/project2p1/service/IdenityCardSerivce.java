package com.hei.project2p1.service;

import com.hei.project2p1.controller.mapper.IdentityCardMapper;
import com.hei.project2p1.controller.model.IdentityCardModel;
import com.hei.project2p1.model.IdentityCardEntity;
import com.hei.project2p1.repository.IdentityCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

    @Service
    @AllArgsConstructor
public class IdenityCardSerivce {
    private final IdentityCardRepository cardRepository;
    private final IdentityCardMapper cardMapper;
    public IdentityCardEntity saveCardIdentity(IdentityCardModel cardModel){
        return cardRepository.save(cardMapper.toDomain(cardModel));
    }
}

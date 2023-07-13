package com.hei.project2p1.controller.rest.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestEmployee {
    private String firstName;
    private String lastName;
    private String birthDate;
    private MultipartFile profileImage;
}

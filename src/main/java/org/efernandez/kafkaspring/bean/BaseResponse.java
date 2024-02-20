package org.efernandez.kafkaspring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    private String message;
    private HttpStatus status;

}

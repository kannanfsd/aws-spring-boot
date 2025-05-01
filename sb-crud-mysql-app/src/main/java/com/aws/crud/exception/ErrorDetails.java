package com.aws.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {
    private String message;
    private String details;
    private Date timestamp;
}

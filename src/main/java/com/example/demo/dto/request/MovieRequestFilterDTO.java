package com.example.demo.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class MovieRequestFilterDTO {
    Date start;
    Date end;
    String subName;
    String genre;
    Integer ranking;
}

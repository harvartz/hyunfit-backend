package com.backend.hyunfit.global.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    private long mbrSeq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp endDate;

    public static SearchDTO of(long mbrSeq, Timestamp startDate, Timestamp endDate) {
        return new SearchDTO(mbrSeq, startDate, endDate);
    }
}

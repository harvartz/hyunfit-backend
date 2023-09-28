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
    private long trnSeq;
    private String trnId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp endDate;

    public static SearchDTO of(long mbrSeq, Timestamp startDate, Timestamp endDate) {
        return new SearchDTO(mbrSeq,0, null, startDate, endDate);
    }
    public static SearchDTO ofTrainerId(String trnId, Timestamp startDate, Timestamp endDate) {
        return new SearchDTO(0,0, trnId, startDate, endDate);
    }

    public static SearchDTO ofTrainerSeq(Long trnSeq, Timestamp startDate, Timestamp endDate) {
        return new SearchDTO(0,trnSeq, null, startDate, endDate);
    }
}

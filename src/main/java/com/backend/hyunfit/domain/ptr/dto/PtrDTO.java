package com.backend.hyunfit.domain.ptr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PtrDTO {
    String mbrName;
    String ptrContent;
    String ptrStickers;
    double ptrRating;
    Timestamp ptrCreationDate;
}

package com.backend.hyunfit.global.common;

import com.backend.hyunfit.domain.adm.dto.AdminDTO;
import com.backend.hyunfit.domain.mbr.dto.MemberDTO;
import com.backend.hyunfit.domain.trn.dto.TrainerDTO;

public class Utils {
    public static void maskPassword(MemberDTO member) {
        member.setMbrPw(null);
    }
    public static void maskPassword(TrainerDTO trainer) {
        trainer.setTrnPw(null);
    }
    public static void maskPassword(AdminDTO admin) {
        admin.setAdmPw(null);
    }
}

package com.backend.hyunfit.domain.openvidu.service;

import com.backend.hyunfit.domain.openvidu.dto.OpenViduDTO;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;

public interface OpenViduService {
    OpenViduDTO createSession(OpenViduDTO ovDTO) throws OpenViduJavaClientException, OpenViduHttpException;
    OpenViduDTO createToken(OpenViduDTO ovDTO) throws OpenViduJavaClientException, OpenViduHttpException;

}

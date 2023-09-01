package com.backend.hyunfit.domain.openvidu.service;

import com.backend.hyunfit.domain.openvidu.dto.OpenViduDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import io.openvidu.java.client.*;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OpenViduServiceImpl implements OpenViduService {

    @Value("${openvidu.url}")
    private String OPENVIDU_URL;
    @Value("${openvidu.secret}")
    private String OPENVIDU_SECRET;
    private OpenVidu openvidu;
    @PostConstruct
    public void init() {
        this.openvidu = new OpenVidu(OPENVIDU_URL, OPENVIDU_SECRET);
    }
    public OpenViduDTO createSession(OpenViduDTO ovDTO) throws OpenViduJavaClientException, OpenViduHttpException {
        Map<String, Object> params = new HashMap<>();
        params.put("customSessionId",ovDTO.getPtSeq());
        SessionProperties properties = SessionProperties.fromJson(params).build();
        Session session = openvidu.createSession(properties);
        ovDTO.setSessionId(session.getSessionId());
        return ovDTO;
    }

    public OpenViduDTO createToken(OpenViduDTO ovDTO) throws OpenViduJavaClientException, OpenViduHttpException {
        Session session;
        session = openvidu.getActiveSession(ovDTO.getPtSeq());
        if(session==null){
            return ovDTO;
        } else {
            ConnectionProperties properties = ConnectionProperties.fromJson(null).build();
            Connection connection = session.createConnection(properties);
            ovDTO.setToken(connection.getToken());
            return ovDTO;
        }
    }
}

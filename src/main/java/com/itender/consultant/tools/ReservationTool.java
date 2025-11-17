package com.itender.consultant.tools;

import com.itender.consultant.pojo.Reservation;
import com.itender.consultant.service.ReservationService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author analytics
 * @date 2025/11/17 21:15
 * @description
 */
@Component
public class ReservationTool {

    @Resource
    private ReservationService reservationService;

    @Tool("预约志愿填报服务")
    public void addReservation(@P("考生姓名") String name,
                               @P("考生性别") String gender,
                               @P("考生手机号") String phone,
                               @P("预约沟通时间,格式为: yyyy-MM-dd'T'HH:mm") String communicationTime,
                               @P("考生所在省份") String province,
                               @P("考生预估分数") Integer estimatedScore) {
        reservationService.insert(new Reservation(null, name, gender, phone, LocalDateTime.parse(communicationTime), province, estimatedScore));
    }

    @Tool("根据考生手机号查询预约单")
    public Reservation findReservation(@P("考生手机号") String phone) {
        return reservationService.findByPhone(phone);
    }
}
package com.master.bdsa.reservationservice.service.vacation;

import com.master.bdsa.reservationservice.service.vacation.model.Hotel;
import com.master.bdsa.reservationservice.service.vacation.model.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Profile("!local-dev")
@Slf4j
@ConfigurationProperties(prefix = "mvs", ignoreUnknownFields = true)
@Component
public class VacationServiceRestTemplateImpl implements VacationService {

    public static final String ROOM_PATH = "/api/v2/room/";
    public static final String HOTEL_PATH = "/api/v1/hotel/";
    private final RestTemplate restTemplate;

    private String reservationServiceHost;


    public VacationServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder,
                                           @Value("${mvs.vacation-user}") String vacationUser,
                                           @Value("${mvs.vacation-password}")String vacationPassword) {
        this.restTemplate = restTemplateBuilder
                .basicAuthentication(vacationUser, vacationPassword)
                .build();
    }

    public void setReservationServiceHost(String reservationServiceHost) {
        this.reservationServiceHost = reservationServiceHost;
    }

    @Override
    public Double calculatePrice(Room room) {
        return restTemplate.getForObject(reservationServiceHost + HOTEL_PATH + room.getRoomType(), Double.class );
    }

    @Override
    public Double calculatePriceOverNight(Hotel hotel) {
        return restTemplate.getForObject(reservationServiceHost+ ROOM_PATH + hotel.getFacility(), Double.class);
    }
}

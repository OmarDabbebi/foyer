package tn.foyer.service.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import tn.foyer.entity.Reservation;
import tn.foyer.service.IReservationService;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ReservationServiceImplIntegrationTest {

    @Autowired
    IReservationService reservationService;

    @Test
    @Rollback
    @Order(1)
     void testRetrieveAllReservations() {
        List<Reservation> lisReservations = reservationService.retrieveAllReservations();
        assertNotNull(lisReservations);
    }

    @Test
    @Rollback
    @Order(2)
    void testAddReservation() {
        Reservation reservation = new Reservation("f1", new Date(), true, null);
        reservationService.addReservation(reservation);

        List<Reservation> reservations = reservationService.retrieveAllReservations();
        assertNotNull(reservations);
        Assertions.assertEquals("f1", reservations.get(0).getIdReservation());
    }

}

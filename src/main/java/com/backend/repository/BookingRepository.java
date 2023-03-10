package com.backend.repository;

import com.backend.domain.Booking;
import com.backend.domain.BookingStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();
    Optional<Booking> findById(Long id);
    List<Booking> findBookingsByDateAndStatusAndGarageId(LocalDate date, BookingStatus status, Long garageId);
    List<Booking> findBookingsByDateAndGarageId(LocalDate date, Long garageId);
    Booking findBookingByDateAndStartHourAndGarageIdAndStatus(LocalDate date, LocalTime startHour, Long garageId, BookingStatus status);
    List<Booking> findBookingsByCarServiceListUserId(Long userId);
}

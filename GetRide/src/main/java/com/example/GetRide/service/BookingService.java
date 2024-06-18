package com.example.GetRide.service;

import com.example.GetRide.dto.request.BookingRequest;
import com.example.GetRide.dto.response.BookingResponse;
import com.example.GetRide.exception.CabNotFoundException;
import com.example.GetRide.exception.CustomerNotFoundException;
import com.example.GetRide.model.Booking;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Customer;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.BookingRepo;
import com.example.GetRide.repository.CabRepository;
import com.example.GetRide.repository.CustomerRespository;
import com.example.GetRide.repository.DriverRepository;
import com.example.GetRide.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.awt.print.Book;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final CustomerRespository customerRespository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final BookingRepo bookingRepo;

//    public BookingService(CustomerRespository customerRespository,
//                          CabRepository cabRepository,
//                          DriverRepository driverRepository,
//                          BookingRepo bookingRepo) {
//        this.customerRespository = customerRespository;
//        this.cabRepository = cabRepository;
//        this.driverRepository = driverRepository;
//        this.bookingRepo = bookingRepo;
//    }

    public BookingResponse bookCab(BookingRequest bookingRequest) {
        Customer customer = customerRespository.findByEmailId(bookingRequest.getCustomerEmail());
        if(ObjectUtils.isEmpty(customer)) {
            throw new CustomerNotFoundException("Invalid email Id");
        }

        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
        if(optionalCab.isEmpty()) {
            throw new CabNotFoundException("Seems like all the drivers are busy");
        }
        Cab cab = optionalCab.get();
        Driver driver = cab.getDriver();
        cab.setBooked(true);

        // booking entity
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(driver);
        Booking savedBooking = bookingRepo.save(booking);

        // set the remaining attributes
        customer.getBookings().add(savedBooking);
        driver.getBookings().add(savedBooking);

        customerRespository.save(customer); // customer + savedBooking
        driverRepository.save(driver); // driver + savedBooking

        // prepare response dto
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }
}

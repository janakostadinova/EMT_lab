package com.example.labemt.service;

import com.example.labemt.model.Booking;
import com.example.labemt.model.Host;
import com.example.labemt.model.dto.BookingDto;
import com.example.labemt.repository.BookingRepository;
import com.example.labemt.repository.HostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService  {

    private final BookingRepository bookingRepository;
    private final HostRepository hostRepository;

    public BookingService(BookingRepository bookingRepository, HostRepository hostRepository) {
        this.bookingRepository = bookingRepository;
        this.hostRepository = hostRepository;
    }


    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking save(BookingDto bookingDto) throws Exception {
        Host host = hostRepository.findById(bookingDto.getHostId()).orElseThrow(Exception::new);
        Booking booking = new Booking(bookingDto.getName(), bookingDto.getCategory(), host, bookingDto.getNumRooms());
        return bookingRepository.save(booking);
    }

    public Booking update(Long bookingId, BookingDto bookingDto) throws Exception {
        Host host = hostRepository.findById(bookingDto.getHostId()).orElseThrow(Exception::new);
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(Exception::new);
        booking.setName(bookingDto.getName());
        booking.setCategory(bookingDto.getCategory());
        booking.setNumRooms(bookingDto.getNumRooms());
        booking.setHost(host);
        return bookingRepository.save(booking);
    }

    public Booking addReservation(Long bookingId) throws Exception {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(Exception::new);

        if(booking.isBooked()) {
            return booking;
        }

        //ako ostanala samo 1 soba
        if(booking.getNumRooms() - 1 == 0) {
            booking.setNumRooms(booking.getNumRooms() - 1);
            booking.setBooked(true);
            return bookingRepository.save(booking);
        } else { // ako ostanala povekje od 1 soba
            booking.setNumRooms(booking.getNumRooms() - 1);
            return bookingRepository.save(booking);
        }
    }

    public void delete(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

}

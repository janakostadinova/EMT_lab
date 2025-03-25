package com.example.labemt.web;

import com.example.labemt.model.Booking;
import com.example.labemt.model.dto.BookingDto;
import com.example.labemt.service.BookingService;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingRestController {

    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> findAll(){
        return ResponseEntity.ok(bookingService.findAll());
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Booking> save(@RequestBody BookingDto bookingDto) throws Exception {
        return ResponseEntity.ok(bookingService.save(bookingDto));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> update(@PathVariable Long bookingId, @RequestBody BookingDto bookingDto) throws Exception {
        return ResponseEntity.ok(bookingService.update(bookingId,bookingDto));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{bookingId}")
    public ResponseEntity<Booking> addReservation(@PathVariable Long bookingId) throws Exception {
        return ResponseEntity.ok(bookingService.addReservation(bookingId));
    }

//    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> delete(@PathVariable Long bookingId){
        bookingService.delete(bookingId);
        return ResponseEntity.noContent().build();
    }
}

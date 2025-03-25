package com.example.labemt.web;

import com.example.labemt.model.Host;
import com.example.labemt.repository.HostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HostRestController {

    private final HostRepository hostRepository;

    public HostRestController(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @GetMapping("/host")
    public ResponseEntity<List<Host>> findAll(){
        return ResponseEntity.ok(hostRepository.findAll());
    }
}

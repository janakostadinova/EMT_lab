package com.example.labemt.data;

import com.example.labemt.model.Country;
import com.example.labemt.model.Host;
import com.example.labemt.repository.CountryRepository;
import com.example.labemt.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializr {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;


    public DataInitializr(CountryRepository countryRepository, HostRepository hostRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
    }

    @PostConstruct
    public void initData(){
        Country country = new Country("Spain", "Europe");
        countryRepository.save(country);

        Host host = new Host("Jana","Kostadinova",country);
        hostRepository.save(host);
    }
}

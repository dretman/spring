package com.dataart.retman.controller;

import com.dataart.retman.domain.Spittle;
import com.dataart.retman.exception.DublicateSpittleMessageException;
import com.dataart.retman.exception.SpittleNotFoundException;
import com.dataart.retman.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = "9223372036854775807") long max,
            @RequestParam(value = "count", defaultValue = "20") int count,
            Model model
    ) throws IOException {
        List<Spittle> spittleList = spittleRepository.findSpittles(max, count);
        model.addAttribute("spittleList", spittleList);

        return spittleList;
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET, consumes = "application/json")
    public Spittle spittle(
            @PathVariable(value = "spittleId") long spittleId
    ) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException(spittleId);
        }
        return spittle;
    }

    @RequestMapping(value = "/spittle", method = RequestMethod.GET)
    public String showSpittleForm(Model model) {
        model.addAttribute("spittle", new Spittle());
        return "addSpittle";
    }

    @RequestMapping(value = "/spittle", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spittle> addSpittle(@RequestBody Spittle spittle, UriComponentsBuilder builder) throws DublicateSpittleMessageException {

        Spittle spittleRes = spittleRepository.save(spittle);
        HttpHeaders headers = new HttpHeaders();
        URI uri = URI.create("http://localhost:1717/spittles/" + spittleRes.getId());
        URI locationUri = builder.path("/spittles/").path(String.valueOf(spittle.getId())).build().toUri();
        headers.setLocation(locationUri);

        ResponseEntity<Spittle> entity = new ResponseEntity<Spittle>(spittle, headers, HttpStatus.CREATED);

        return entity;
    }

}

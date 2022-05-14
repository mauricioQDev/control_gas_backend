package com.umanizales.control_gas.infrastructure.controllers;

import com.umanizales.control_gas.aplication.RegistroSemaforoImpl;
import com.umanizales.control_gas.domain.ChangeFreqDTO;
import com.umanizales.control_gas.domain.RegistroSemaforoDTO;
import com.umanizales.control_gas.domain.WarningDTO;
import com.umanizales.control_gas.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "")
@Validated
public class RegistroSemaforoController {

    @Autowired
    private RegistroSemaforoImpl registroSemaforoImpl;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid RegistroSemaforoDTO registroSemaforoDTO) {
        return new ResponseEntity<>(new ResponseDTO("Success", registroSemaforoImpl.save(registroSemaforoDTO), null), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> list() {
        return new ResponseEntity<>(new ResponseDTO("succes", registroSemaforoImpl.list(), null), HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    private String test() {
        return "200";
    }

    @GetMapping(value = "/start")
    private String start() {
        String uri = "https://cleanlier-eland-5207.dataplicity.io/start";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/init")
    private String init() {
        String uri = "https://cleanlier-eland-5207.dataplicity.io/init";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @PostMapping(value = "/stop/{id}")
    private String stop(@PathVariable("id") String id) {
        String uri = "https://cleanlier-eland-5207.dataplicity.io/stop/" + id;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, null, String.class);
        return result;
    }

    @PostMapping(value = "/changefreq")
    private String changeFreq(@RequestBody ChangeFreqDTO changeFreqDTO) {
        String uri = "https://cleanlier-eland-5207.dataplicity.io/changefreq";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, changeFreqDTO, String.class);
        return result;
    }

    @PostMapping(value = "/warning")
    private String warning(@RequestBody WarningDTO warningDTO) {
        String uri = "https://cleanlier-eland-5207.dataplicity.io/warning";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, warningDTO, String.class);
        return result;
    }
}

package com.utad.curso.desarrollo.seguro.controller.api;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utad.curso.desarrollo.seguro.dto.DummyRequestBodyDto;
import com.utad.curso.desarrollo.seguro.dto.DummyResponseDto;

@RestController
@RequestMapping("/api/dummy")
public class DummyApiController {

    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Esto es un metodo GET demostrativa.
     * 
     * @param param1 parametro
     * @param param2 otro parametro
     * @return
     */

    @GetMapping("/dummy-get/{path-var1}/otra-cosa/{path-var2}")
    public DummyResponseDto get(
            @RequestParam(name = "param1", required = false, defaultValue = "value") String param1,
            @RequestParam(name = "param2", required = true) @Min(2) @Max(5) Long param2,
            @PathVariable(name = "path-var1", required = true) String param3,
            @PathVariable(name = "path-var2", required = true) String param4) {

        logger.info("Request: GET /api/dummy/dummy-get; param1: {}", param1);

        DummyResponseDto response = new DummyResponseDto();
        response.setSuccess(true);

        return response;

    }

    @PostMapping("/dummy-post")
    public DummyResponseDto post(
            @RequestBody(required = true) DummyRequestBodyDto body) {

        logger.info("Request: POST /api/dummy/dummy-post");

        logger.info(body.getAttribute());

        DummyResponseDto response = new DummyResponseDto();
        response.setSuccess(true);

        return response;

    }

}

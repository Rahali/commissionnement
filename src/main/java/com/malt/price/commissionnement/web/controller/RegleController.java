package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.dto.*;
import com.malt.price.commissionnement.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/regle")
public class RegleController {
    Logger logger = LoggerFactory.getLogger(RegleController.class);
    @Autowired
    private RegleService regleService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public RulesDto getRegleslit() {
        return new RulesDto();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRegle(@RequestBody RulesDto regle_) {
        logger.info(regle_.toString());
        RulesDto regle = regleService.createRegle(regle_);
        if (regle == null) {
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regle);
    }
}

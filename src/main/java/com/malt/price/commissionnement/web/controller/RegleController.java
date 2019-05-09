package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.dto.*;
import com.malt.price.commissionnement.service.*;
import io.swagger.annotations.*;
import java.util.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Api(value="Regles et les restrictions")
@RestController
@RequestMapping(value = "/regle")
public class RegleController {
    Logger logger = LoggerFactory.getLogger(RegleController.class);
    @Autowired
    private RegleService regleService;

    @ApiOperation(value = "La liste des regles", response = List.class)
    /*@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })*/

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getRegleslit() {
        return ResponseEntity.ok(regleService.getAll());

    }
    @ApiOperation(value = "Ajouter une Regle et des restrictions")
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRegle(@RequestBody RulesDto regle_) {
        logger.info(regle_.getName());
        RulesDto regle = regleService.createRegle(regle_);
        if (regle == null) {
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regle);
    }
}

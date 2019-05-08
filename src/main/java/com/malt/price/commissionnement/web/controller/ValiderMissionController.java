package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.dto.*;
import com.malt.price.commissionnement.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/demande")
public class ValiderMissionController {
    @Autowired
    private CommandService commandService;
    @RequestMapping(value = "/calculer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeesDto> validateCommand(@RequestBody CommandDto demande){
       return ResponseEntity.ok(commandService.calculFee(demande));

    }


}

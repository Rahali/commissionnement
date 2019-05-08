package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MissionController {
    @RequestMapping(value = "/Missions", method = RequestMethod.GET)
    public MissionDto getAllMissions() {
        return new MissionDto();
    }
}

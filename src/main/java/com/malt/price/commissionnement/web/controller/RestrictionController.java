package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.dto.*;
import com.malt.price.commissionnement.pojo.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestrictionController {
    @RequestMapping(value = "/restrictions", method = RequestMethod.GET)
    public RestrictionsDto getRestrictionsList(){
        return new RestrictionsDto();
    }
}

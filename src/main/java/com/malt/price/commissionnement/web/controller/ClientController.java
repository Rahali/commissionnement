package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.pojo.*;
import io.swagger.annotations.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="detail  des Clients")
@RequestMapping(value = "/clients")
public class ClientController {
    @ApiOperation(value = "La liste des Clients", response = List.class)
    @RequestMapping(value = "/getAll" ,method = RequestMethod.GET)
    public List<Client> getAllClients()
    {
        return new ArrayList<Client>();
    }
}

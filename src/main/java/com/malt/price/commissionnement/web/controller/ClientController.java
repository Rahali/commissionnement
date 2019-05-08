package com.malt.price.commissionnement.web.controller;

import com.malt.price.commissionnement.pojo.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @RequestMapping(value = "/Clients" ,method = RequestMethod.GET)
    public Client getAllClients()
    {
        return new Client();
    }
}

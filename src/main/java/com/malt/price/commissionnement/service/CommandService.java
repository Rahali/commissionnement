package com.malt.price.commissionnement.service;

import com.malt.price.commissionnement.dto.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service

public class CommandService {
    Logger logger = LoggerFactory.getLogger(CommandService.class);
   /* @Autowired
    private CommandRepository commandRepository;*/

    @Autowired
    private IpStackService ipStackService;

    @Autowired
    private RegleService regleService;


    public FeesDto calculFee(CommandDto command) {
        //get Code country from ip address
        // String codeCountryClient = ipStackService.getCodeCountry(command.getClientDto().getIp());
        //String codeCountryFreelancer = ipStackService.getCodeCountry(command.getFreelancerDto().getIp());
        String codeCountryClient = "fr";
        String codeCountryFreelancer = "fr";

        //getRule Where Client Location And Freelance Location Or Duration Mission Or Duration CommercailRelation
        FeesDto feesDto = regleService.getRulePercenFromRestriction(command, codeCountryClient, codeCountryFreelancer);

        return feesDto;
    }
}


package com.malt.price.commissionnement.service;

import com.malt.price.commissionnement.dto.*;
import com.malt.price.commissionnement.pojo.*;
import com.malt.price.commissionnement.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class RegleService {
    @Autowired
    private RegleRepository regleRepository;

    public RulesDto createRegle(RulesDto newRegle) {
        RulesDto rulesDto = new RulesDto();
        Rule rule = new Rule();
        rule.setName(newRegle.getName());
        rule = regleRepository.save(rule);
        rulesDto.setId(rule.getId());
        rulesDto.setName(rule.getName());
        rulesDto.setRateDto(getRateDtoFromRate(rule.getRate()));
        rulesDto.setRestrictionsDto(getRestrictionsDtoFromRestrictions(rule.getRestrictionsList()));
        return rulesDto;
    }

    private List<RestrictionsDto> getRestrictionsDtoFromRestrictions(List<Restrictions> restrictionsList) {
        List<RestrictionsDto> restrictionsDtoList = new ArrayList<RestrictionsDto>();

        for (Restrictions rest :restrictionsList ) {
            RestrictionsDto restrictionsDto = new RestrictionsDto();
            LocationDto locationDto =  new LocationDto();

            locationDto.setCountry(rest.getClientLocation());
            restrictionsDto.setClientLocationDto(locationDto);

            locationDto.setCountry(rest.getFreelancerLocation());
            restrictionsDto.setFreelancerLocationDto(locationDto);

            restrictionsDto.setOrDtoList(getOrDtoFromDurationMissions(rest.getDuration()));
            restrictionsDtoList.add(restrictionsDto);
        }
        return restrictionsDtoList;
    }

    private List<OrDto> getOrDtoFromDurationMissions(List<MissionDuration> durations) {
        List<OrDto> orDtos = new ArrayList<>();
        for (MissionDuration missionDuration :durations) {
          missionDuration.getGt();
        }



        return orDtos;
    }

    private RateDto getRateDtoFromRate(Rate rate) {
        RateDto  rateDto = new RateDto();
        rateDto.setPercent(rate.getPercent());
        return rateDto;
    }

    public FeesDto getRulePercenFromRestriction(CommandDto command, String clientcountry, String freelancerCountry) {
       FeesDto feesDto =  new FeesDto();
        feesDto.setFees("10");

        List<Rule> rules = regleRepository.findAll();


        for (Rule r : rules) {
            List<Restrictions> rests = r.getRestrictionsList();
            boolean trouve = false;
            for (Restrictions rest : rests) {
                List<MissionDuration> missionDurations = rest.getDuration();
                for (MissionDuration missionDuration : missionDurations) {
                    if (Integer.getInteger(missionDuration.getGt()) < Integer.getInteger(command.getMissionDto().getGt())||
                            Integer.getInteger(missionDuration.getGt()) < Integer.getInteger(command.getCommercialrelationDto().getGt())) {
                        trouve = true;
                        break;
                    }
                }
                if (rest.getFreelancerLocation().equalsIgnoreCase(freelancerCountry) && rest.getClientLocation().equalsIgnoreCase(clientcountry) && trouve) {
                    trouve = true;
                } else {
                    trouve = false;
                }

            }
            if (trouve){
                feesDto.setFees(r.getRate().getPercent());
                feesDto.setReason(r.getName());
            }
        }
     return feesDto;

    }

}

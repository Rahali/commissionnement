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
        Rule rule = getRulefromDtotuPojo(newRegle);
        rule = regleRepository.save(rule);
        rulesDto.setId(rule.getId());
        rulesDto.setName(rule.getName());
        rulesDto.setRateDto(getRateDtoFromRate(rule.getRate()));
        rulesDto.setRestrictionsDto(getRestrictionsDtoFromRestrictions(rule.getRestrictionsList()));
        return rulesDto;
    }

    private Rule getRulefromDtotuPojo(RulesDto rulesDto) {
        Rule rule = new Rule();
        rule.setName(rulesDto.getName());
        rule.setRate(rateFromDtoToPojo(rulesDto.getRateDto()));
        rule.setRestrictionsList(restrictionsFromDtoToPojo(rulesDto.getRestrictionsDto()));
        return rule;
    }

    private Restrictions restrictionsFromDtoToPojo(RestrictionsDto restrictionsDto) {
        Restrictions restrictions = new Restrictions();
        restrictions.setClientLocation(restrictionsDto.getClientLocationDto().getCountry());
        restrictions.setFreelancerLocation(restrictionsDto.getFreelancerLocationDto().getCountry());

        missionDurationFromDtoToPojo(restrictions, restrictionsDto.getOrDtoList());

        return restrictions;
    }

    private void missionDurationFromDtoToPojo(Restrictions restrictions, List<OrDto> duration) {
        List<MissionDuration> missionDurations = new ArrayList<>();
        List<CommercialrelationDuration> commercialrelationDurations = new ArrayList<>();
        if (duration != null) {
            for (OrDto duration1 : duration) {
                MissionDuration missionDuration = new MissionDuration();
                CommercialrelationDuration commercialrelationDuration = new CommercialrelationDuration();

                if (duration1.getCommercialrelationDurationDto()!=null){
                    commercialrelationDuration.setGt(duration1.getCommercialrelationDurationDto().getGt());
                    commercialrelationDurations.add(commercialrelationDuration);
                }
                if (duration1.getMissionDuration()!=null) {
                    missionDuration.setGt(duration1.getMissionDuration().getGt());
                    missionDurations.add(missionDuration);
                }
           }
            restrictions.setMissionDurationList(missionDurations);
            restrictions.setCommercialrelationDurationList(commercialrelationDurations);
        }
    }

    private Rate rateFromDtoToPojo(RateDto rateDto) {
        Rate rate = new Rate();
        rate.setPercent(rateDto.getPercent());
        return rate;
    }

    private RestrictionsDto getRestrictionsDtoFromRestrictions(Restrictions restrictionsList) {
        List<RestrictionsDto> restrictionsDtoList = new ArrayList<>();

        //   for (Restrictions rest : restrictionsList) {
        RestrictionsDto restrictionsDto = new RestrictionsDto();
        LocationDto locationDto = new LocationDto();
        if (restrictionsList != null) {
            locationDto.setCountry(restrictionsList.getClientLocation());
            restrictionsDto.setClientLocationDto(locationDto);

            locationDto.setCountry(restrictionsList.getFreelancerLocation());
            restrictionsDto.setFreelancerLocationDto(locationDto);

            restrictionsDto.setOrDtoList(getOrDtoFromDurationMissions(restrictionsList.getMissionDurationList(), restrictionsList.getCommercialrelationDurationList()));
            restrictionsDtoList.add(restrictionsDto);
        }
        return restrictionsDto;
    }

    private List<OrDto> getOrDtoFromDurationMissions(List<MissionDuration> durations, List<CommercialrelationDuration> commercialrelationDurationList) {
        List<OrDto> orDtos = new ArrayList<>();

        for (MissionDuration missionDuration : durations) {
            OrDto orDto = new OrDto();
            DurationDto durationDto = new DurationDto();
            durationDto.setGt(missionDuration.getGt());
            orDto.setMissionDuration(durationDto);
            orDtos.add(orDto);
        }
        for (CommercialrelationDuration cd : commercialrelationDurationList) {
            DurationDto durationDto = new DurationDto();
            OrDto orDto = new OrDto();
            durationDto.setGt(cd.getGt());
            orDto.setCommercialrelationDurationDto(durationDto);
            orDtos.add(orDto);
        }

        return orDtos;
    }

    private RateDto getRateDtoFromRate(Rate rate) {
        RateDto rateDto = new RateDto();
        if (rate != null) {
            rateDto.setPercent(rate.getPercent());
        }
        return rateDto;
    }

    public FeesDto getRulePercenFromRestriction(CommandDto command, String clientcountry, String freelancerCountry) {
        FeesDto feesDto = new FeesDto();
        List<FeesDto> feesDtoList=new ArrayList<>();
        feesDto.setFees("10");
        feesDto.setReason("Default");
        feesDtoList.add(feesDto);

        List<Rule> rules = regleRepository.findAll();

        for (Rule r : rules) {
            Restrictions rest = r.getRestrictionsList();
            boolean trouve = false;
            List<MissionDuration> missionDurations = rest.getMissionDurationList();
            for (MissionDuration missionDuration : missionDurations) {
                if (Integer.getInteger(missionDuration.getGt()) < Integer.getInteger(command.getMissionDto().getGt()) ||
                        Integer.getInteger(missionDuration.getGt()) < Integer.getInteger(command.getCommercialrelationDto().getGt())) {
                    trouve = true;
                    break;
                }

                if (rest.getFreelancerLocation().equalsIgnoreCase(freelancerCountry) && rest.getClientLocation().equalsIgnoreCase(clientcountry) && trouve) {
                    trouve = true;
                } else {
                    trouve = false;
                }

            }
            if (trouve) {
                feesDto.setFees(r.getRate().getPercent());
                feesDto.setReason(r.getName());
            }
        }
        return feesDto;

    }

    public List<RulesDto> getAll() {
        List<RulesDto> rulesDto = new ArrayList<>();
        List<Rule> rules = regleRepository.findAll();
        for (Rule r : rules) {
            RulesDto rulDto = new RulesDto();
            rulDto.setName(r.getName());
            rulDto.setRateDto(getRateDtoFromRate(r.getRate()));
            rulDto.setRestrictionsDto(getRestrictionsDtoFromRestrictions(r.getRestrictionsList()));
            rulesDto.add(rulDto);
        }
        return rulesDto;
    }
}

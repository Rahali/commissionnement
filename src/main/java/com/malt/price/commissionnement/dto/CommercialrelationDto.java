
package com.malt.price.commissionnement.dto;

import de.codecentric.boot.admin.server.config.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.*;
import javax.persistence.Entity;
import lombok.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.*;


@Getter
@Setter
public class CommercialrelationDto implements Serializable
{
    @JsonProperty("firstmission")
    private String firstmission;

    @JsonProperty("last_mission")
    private String lastMission;
    @JsonProperty("gt")
    private String gt;

}

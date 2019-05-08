
package com.malt.price.commissionnement.dto;

import com.fasterxml.jackson.annotation.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Entity;
import lombok.*;
import org.apache.commons.lang.builder.*;
import org.hibernate.annotations.*;


@Setter
@Getter
public class RateDto implements Serializable
{
    @JsonProperty("percent")
    private String percent;

}

package com.example.jsontodb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Global {
    @JsonProperty("NewConfirmed")
    private int newConfirmed;
    @JsonProperty("TotalConfirmed")
    private int totalConfirmed;
    @JsonProperty("NewDeaths")
    private int newDeaths;
    @JsonProperty("TotalDeaths")
    private int totalDeaths;
    @JsonProperty("NewRecovered")
    private int newRecovered;
    @JsonProperty("TotalRecovered")
    private int totalRecovered;
    @JsonProperty("Date")
    private String date;
}

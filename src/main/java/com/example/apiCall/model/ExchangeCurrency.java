
package com.example.apiCall.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "info",
    "query",
    "result",
    "success"
})

public class ExchangeCurrency {
    @JsonProperty("date")
    private String date;
    @JsonProperty("info")
    private ExchangeCurrencyInfo info;
    @JsonProperty("query")
    private ExchangeCurrencyQuery query;
    @JsonProperty("result")
    private Double result;
    @JsonProperty("success")
    private Boolean success;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("info")
    public ExchangeCurrencyInfo getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(ExchangeCurrencyInfo info) {
        this.info = info;
    }

    @JsonProperty("query")
    public ExchangeCurrencyQuery getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(ExchangeCurrencyQuery query) {
        this.query = query;
    }

    @JsonProperty("result")
    public Double getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Double result) {
        this.result = result;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

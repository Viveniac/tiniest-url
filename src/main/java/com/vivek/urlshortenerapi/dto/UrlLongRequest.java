package com.vivek.urlshortenerapi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Request object for POST method")
public class UrlLongRequest {

    @ApiModelProperty(required = true, notes = "Url to convert to short")
    private String longUrl;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

}

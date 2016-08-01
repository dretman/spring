package com.dataart.retman.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Spittle {
    private Long id;
    private String message;
    private Double latitude;
    private Double longitude;

    public Spittle() {
    }

    public Spittle(String message) {
        this(message, null, null);
    }

    public Spittle(String message, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, new String[]{"id", "time"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"id", "time"});
    }

    @Override
    public String toString() {
        return id +"|"+
                message +"|"+
                latitude +"|"+
                longitude;
    }
}

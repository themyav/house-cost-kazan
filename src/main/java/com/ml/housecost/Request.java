package com.ml.housecost;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Request {
    public Integer roomNumber;
    public Integer district;
    public Integer author_type;
    public Integer accommodation_type;
    public Integer floor;
    public Integer floors_count;
    public Integer rooms_count;
    public Integer total_meters;
    public Integer street;

    public Integer getAuthor_type() {
        return author_type;
    }

    public void setAuthor_type(Integer author_type) {
        this.author_type = author_type;
    }

    public Integer getAccommodation_type() {
        return accommodation_type;
    }

    public void setAccommodation_type(Integer accommodation_type) {
        this.accommodation_type = accommodation_type;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFloors_count() {
        return floors_count;
    }

    public void setFloors_count(Integer floors_count) {
        this.floors_count = floors_count;
    }

    public Integer getRooms_count() {
        return rooms_count;
    }

    public void setRooms_count(Integer rooms_count) {
        this.rooms_count = rooms_count;
    }

    public Integer getTotal_meters() {
        return total_meters;
    }

    public void setTotal_meters(Integer total_meters) {
        this.total_meters = total_meters;
    }

    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    public Integer getUnderground() {
        return underground;
    }

    public void setUnderground(Integer underground) {
        this.underground = underground;
    }

    public Integer getResidential_complex() {
        return residential_complex;
    }

    public void setResidential_complex(Integer residential_complex) {
        this.residential_complex = residential_complex;
    }

    public Integer underground;
    public Integer residential_complex;
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{}";
        }

    }
}

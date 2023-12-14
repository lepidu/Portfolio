package com.ca.IntegratedCA.repository;
/* INTEGRATED CA - DATA STORAGE SOLUTIONS / COMMERCIAL SOLUTIONS DESIGN
 * Xiaohui Weng - 2020387  
 * Leisly Pino 2020303 
 * Yuri Ribeiro 2020347
 * */
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ca.IntegratedCA.model.Flights;


// Flight Repository extending MongoRepository to be able to perform CRUD

public interface FlightsRepository extends MongoRepository <Flights, String> {


}


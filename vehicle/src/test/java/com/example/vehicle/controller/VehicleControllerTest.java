package com.example.vehicle.controller;

import java.util.Arrays;
import java.util.List;

import com.example.vehicle.model.Vehicle;
import com.example.vehicle.model.VehicleController;
import com.example.vehicle.model.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    VehicleRepository repository;

    Vehicle v1 = new Vehicle(1, 1998, "toyota", "corolla");
    Vehicle v2 = new Vehicle(2, 2021, "toyota", "camry");
    Vehicle v3 = new Vehicle(3, 2030, "honda", "accord");

    // UNIT TESTING the GET mapping 
    // path = /vehicles
    @Test
    public void readAllVehicle_success() throws Exception {
        List<Vehicle> allVehicle = Arrays.asList(v1,v2,v3);

        Mockito.when(repository.findAll()).thenReturn(allVehicle);

        mockMvc.perform(MockMvcRequestBuilders
            .get("/vehicles")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[2].year", is(2030)));

    }
    // path = /vehicles/{id}
    @Test
    public void readVehiclesById_success() throws Exception {
        Mockito.when(repository.findById(v1.getId())).thenReturn(java.util.Optional.of(v1));

        mockMvc.perform(MockMvcRequestBuilders
            .get("/vehicles/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", notNullValue()))
            .andExpect(jsonPath("$.year", is(1998)));

    }

    // UNIT TESTING the DELETE mapping
    @Test
    public void deleteVehicle_success() throws Exception {
        Mockito.when(repository.findById(v3.getId())).thenReturn(java.util.Optional.of(v3));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/vehicles/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  ; 
    }

    // @Test
    // public void deleteVehicle_notFound() throws Exception {
    //     Mockito.when(repository.findById(100)).thenReturn(null);
        
    //     mockMvc.perform(MockMvcRequestBuilders
    //             .delete("/vehicles/100")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isInternalServerError())  ; 
    // }
    
    // UNIT TESTING the POST mapping
    // @Test
    // public void createVehicle_success() throws Exception {
    //     // Vehicle vehicle = Vehicle.builder()
    //     //     .id(4)
    //     //     .year(2015)
    //     //     .make("ford")
    //     //     .model("bronco")
    //     //     .build();
    //     Vehicle vehicle = new Vehicle(1, 2015, "ford", "bronco");
    //     Mockito.when(repository.save(vehicle)).thenReturn(vehicle);

    //    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/vehicles")
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .accept(MediaType.APPLICATION_JSON)
    //         .content(this.mapper.writeValueAsString(vehicle));

    //     mockMvc.perform(mockRequest)
    //         .andExpect(status().isOk())
    //         .andExpect(jsonPath("$.id", is(1)))
    //         .andExpect(jsonPath("$.model", is("bronco")));
    // }

    //UNIT TESTING the PUT mapping
    // @Test
    // public void updateVehicle_success() throws Exception { 
    //     Vehicle updatedV = Vehicle.builder()
    //             .id(1)
    //             .year(1960)
    //             .make("ford")
    //             .model("mustang")
    //             .build();        

    //     Mockito.when(service.save(updatedV)).thenReturn(updatedV);
    //     String json = mapper.writeValueAsString(updatedV);
    //     System.out.println(json);
    //     mockMvc.perform(MockMvcRequestBuilders .put("/vehicles").contentType(MediaType.APPLICATION_JSON)
    //             .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
    //             .andExpect(jsonPath("$.id", is(1)))
    //             .andExpect(jsonPath("$.model", is("mustang")));
        
        
    // }



    
}

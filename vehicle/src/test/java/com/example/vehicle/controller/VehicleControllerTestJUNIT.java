// package com.example.vehicle.controller;


// import com.example.vehicle.model.Vehicle;
// import com.example.vehicle.model.VehicleController;
// import com.example.vehicle.test.VehicleService;

// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.Matchers.hasSize;
// import static org.mockito.BDDMockito.given;
// import static org.mockito.Mockito.reset;
// import static org.mockito.Mockito.verify;
// // import org.mockito.Mockito;
// // import org.mockito.internal.verification.VerificationModeFactory;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// // import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.ArrayList;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.internal.verification.VerificationModeFactory;

// @RunWith(SpringRunner.class)
// @WebMvcTest(VehicleController.class)
// public class VehicleControllerTest {
//     @Autowired
//     private MockMvc mockMvc;

//     @MockBean
//     private VehicleService service;

//     @Test
//     public void givenVehicles_getVehicles() throws Exception {
//         Vehicle v1 = new Vehicle(1, 1999, "toyota", "corolla");

//         ArrayList<Vehicle> allVehicle = new ArrayList<Vehicle>();
//         allVehicle.add(v1);

//         given(service.getAll()).willReturn(allVehicle);

//         mockMvc.perform(get("/vehicles")
//             .contentType(MediaType.APPLICATION_JSON))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$", hasSize(1)))
//             .andExpect(jsonPath("$[0].id", is(v1.getId())));
//         verify(service, VerificationModeFactory.times(1)).getAll();
//         reset(service);
//     }

    



//     // @Test
//     // public void whenPostMapping_createEmployee() throws Exception {
//     //     Vehicle v1 = new Vehicle(1, 1998, "toyota", "camry");
//     //     given(service.save(Mockito.any())).willReturn(v1);

//     //     mockMvc.perform(post("/vehicles")
//     //         .contentType(MediaType.APPLICATION_JSON)
//     //         .content(JsonUtil.toJson(v1)))
//     //         .andExpect(status().isCreated())
//     //         .andExpect(jsonPath("$.id", is(v1.getId())))
//     //         .andExpect(jsonPath("$.year", is(v1.getYear())))
//     //         .andExpect(jsonPath("$.make", is(v1.getMake())))
//     //         .andExpect(jsonPath("$.mdoel", is(v1.getModel())));
            
//     //     verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
//     //     reset(service);
//     // }

    
    
// }

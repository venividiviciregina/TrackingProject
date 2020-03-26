package de.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentsByCustomerDTO {
        Long customerId;
        Long tracking_id;
        String statusTitle;
        Long shipmentId;
        String shipmentTitle;
}
//package de.telran.dto;

        //import lombok.AllArgsConstructor;
        //import lombok.Data;

//@Data
//@AllArgsConstructor
//public class ShipmentsByCustomerDTO {
        //private String name;
        //private String title;
//}

package de.telran.controller;

import de.telran.dto.ShipmentDTO;
import de.telran.entity.Shipment;
import de.telran.service.ShipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShipmentController {
    private ShipmentService service;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @GetMapping("/api/shipments")
    List<ShipmentDTO> getAllShipments() {
        return service.getAllShipments()
                .stream()
                .map(s -> modelMapper.map(s, ShipmentDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/api/shipments")
    ShipmentDTO createShipment(@RequestBody ShipmentDTO shipment) {
        System.out.println(shipment);
        Shipment shipmentEntity = modelMapper.map(shipment, Shipment.class);
        System.out.println(shipmentEntity);
        return modelMapper.map(service.createShipment(shipmentEntity), ShipmentDTO.class);
    }
}

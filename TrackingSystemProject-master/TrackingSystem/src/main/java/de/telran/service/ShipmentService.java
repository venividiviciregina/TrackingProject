package de.telran.service;

import de.telran.entity.Customer;
import de.telran.entity.Shipment;
import de.telran.repository.CustomerRepository;
import de.telran.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository respository;

    public Shipment createShipment(Shipment shipment) {
        Shipment savedShipment = respository.save(shipment);
        return savedShipment;
    }

    public List<Shipment> getAllShipments() {
        return respository.findAll();
    }

    public Shipment getShipmentById(Long shipmentId) {
        return respository.getOne(shipmentId);
    }
}

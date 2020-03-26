package de.telran.repository;

import de.telran.dto.ShipmentsByCustomerDTO;
import de.telran.entity.Customer;
import de.telran.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Shipment s SET s.customerId = :customerId WHERE s.shipmentId = :shipmentId")
    int assignShipmentToCustomer(@Param("shipmentId") long shipmentId, @Param("customerId") long customerId);

    @Query("select new ShipmentsByCustomerDTO(c.name, s.title) from Customer as c " +
            "join Shipment s on s.customerId = c.customerId")
    List<ShipmentsByCustomerDTO> getShipmentsByCustomerId();
}

package com.project.EquipmentIdentificationSystem.repo;

import org.springframework.data.repository.CrudRepository;
import com.project.EquipmentIdentificationSystem.Models.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
}

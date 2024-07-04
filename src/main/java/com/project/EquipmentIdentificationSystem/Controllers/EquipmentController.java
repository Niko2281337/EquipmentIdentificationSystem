package com.project.EquipmentIdentificationSystem.Controllers;

import com.project.EquipmentIdentificationSystem.repo.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.EquipmentIdentificationSystem.Models.Equipment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentRepository EquipmentRepository;

    @GetMapping("/")
    public String EquipmentMain(Model model) {
        Iterable<Equipment> Equipments = EquipmentRepository.findAll();
        model.addAttribute("Equipments", Equipments);
        return "Equipment-main";
    }

    @GetMapping("/Equipment/add")
    public String EquipmentAdd(Model model) {
        return "Equipment-add";
    }

    @PostMapping("/Equipment/add")
    public String EquipmentPostAdd(@RequestParam String name,
                                   @RequestParam String category,
                                   @RequestParam String description,
                                   @RequestParam String line,
                                   @RequestParam Integer market_price,
                                   @RequestParam Integer purchase_price,
                                   @RequestParam Integer serial_number,
                                   Model model) {
        Equipment equipment = new Equipment(name, category,description,line,market_price,purchase_price,serial_number);
        EquipmentRepository.save(equipment);
        return "redirect:/";
    }

    @GetMapping("/Equipment/edit/{Id}")
    public String EquipmentEdit(@PathVariable(value = "Id") long Id, Model model) {
        if(!EquipmentRepository.existsById(Id))
        {
            return "redirect:/";
        }
        Optional<Equipment> equipment = EquipmentRepository.findById(Id);
        ArrayList<Equipment> res = new ArrayList<>();
        equipment.ifPresent(res::add);
        model.addAttribute("equipment", res);
        return "Equipment-edit";
    }
    @PostMapping("/Equipment/edit/{Id}")
    public String EquipmentPostUpd(@RequestParam String name,
                                   @RequestParam String category,
                                   @RequestParam String description,
                                   @RequestParam String line,
                                   @RequestParam Integer market_price,
                                   @RequestParam Integer purchase_price,
                                   @RequestParam Integer serial_number,
                                   @PathVariable(value = "Id") long Id,
                                   Model model) {
        Equipment equipment = EquipmentRepository.findById(Id).orElseThrow();
        equipment.setName(name);
        equipment.setCategory(category);
        equipment.setDescription(description);
        equipment.setLine(line);
        equipment.setMarketPrice(market_price);
        equipment.setPurchasePrice(purchase_price);
        equipment.setSerialNumber(serial_number);
        EquipmentRepository.save(equipment);

        return "redirect:/";
    }

    @PostMapping("/Equipment/delete/{Id}")
    public String EquipmentPostDel(@PathVariable(value = "Id") long Id, Model model) {
        Equipment equipment = EquipmentRepository.findById(Id).orElseThrow();
        EquipmentRepository.delete(equipment);

        return "redirect:/";
    }

}

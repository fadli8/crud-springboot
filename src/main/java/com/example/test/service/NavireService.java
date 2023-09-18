package com.example.test.service;

import com.example.test.entity.DTO.NavireEntityRequest;
import com.example.test.entity.NavireEntity;
import com.example.test.repository.NavireRepo;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NavireService implements NavireServiceInterface {

    final NavireRepo navireRepo;

    public NavireService(NavireRepo navireRepo) {

        this.navireRepo = navireRepo;
    }
    @Override
    public List<NavireEntity> getAllNavires() throws Exception {
        return this.navireRepo.findAll();
    }
    @Override
    public NavireEntity addNavire(String name, double tonnage){
        NavireEntity navire =  NavireEntity.builder()
                .name(name)
                .tonnage(tonnage)
                .date_demarage(LocalDateTime.now())
                .date_integration(LocalDateTime.now())
                .status("En Cours").build();

        return this.navireRepo.save(navire);

    }



    @Override
    public boolean deleteNavire(Long id){
        NavireEntity selectedNavire = this.navireRepo.findById(id).orElse(null);
        if(selectedNavire != null) {
            this.navireRepo.delete(selectedNavire);
            return true;
        }
        return false;
    }

    @Override
    public NavireEntity updateNavire(Long id, NavireEntityRequest navireEntityRequest) {

        NavireEntity navireSelectionne = this.navireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Navire not found"));

          navireSelectionne.setName(navireEntityRequest.getName());
         navireSelectionne.setTonnage(navireEntityRequest.getTonnage());
         navireSelectionne.setStatus(navireEntityRequest.getStatus());
//
//        Field[] fields = navireEntityRequest.getClass().getDeclaredFields();

//        for(Field f : fields){
//            System.out.println("======>"+f.getName() + " ");
//            navireSelectionne.se
//
//        }
//        this.navireRepo.save(navireSelectionne);
            return navireSelectionne;

//        return null;

    }

    public NavireEntity searchNavire(String name){
        return this.navireRepo.searchByName(name);
    }


    public List<NavireEntity> getAvailableNavire(){
        return this.navireRepo.findAll().stream().filter(el  -> el.getStatus() == "En Cours").toList();
    }

}

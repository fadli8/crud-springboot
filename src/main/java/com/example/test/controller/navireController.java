package com.example.test.controller;

import com.example.test.entity.DTO.NavireEntityRequest;
import com.example.test.entity.NavireEntity;
import com.example.test.service.NavireService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/navires")
@RequiredArgsConstructor
public class navireController {

    final private NavireService navireService;


    @GetMapping
    public List<NavireEntity> getNavires() throws Exception {
        return this.navireService.getAllNavires();
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public NavireEntity addNavire(@RequestParam String name, @RequestParam double tonnage){
      return this.navireService.addNavire(name, tonnage);
    }

    @PatchMapping( "/update/{id}")
    public NavireEntity updateNavire(@PathVariable Long id, @RequestBody NavireEntityRequest navireEntityRequest){
        return this.navireService.updateNavire(id, navireEntityRequest);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteNavire(@PathVariable Long id){
        return this.navireService.deleteNavire(id);
    }

    @PostMapping("/{name}")
    public NavireEntity ShearchByName(@PathVariable String name){
        return this.navireService.searchNavire(name);
    }

    @GetMapping("/test/{carachter}")
    public List<String> mapfunction(@PathVariable String carachter){
        List<Integer> number = Arrays.asList(2,3,4,5);
        List<String> names = Arrays.asList("Reflection","Collection","Stream");
        return names.stream().sorted().collect(Collectors.toList()); // sorted
        // return names.stream().filter(s -> s.startsWith(carachter)).collect(Collectors.toList()); // filter
        // return number.stream().map(x-> x * x).collect(Collectors.toList()); // map

    }

    @GetMapping("/available")
    public List<NavireEntity> navireAvailable(){
        return this.navireService.getAvailableNavire();
    }
}

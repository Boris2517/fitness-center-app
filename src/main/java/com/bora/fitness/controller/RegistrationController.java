package com.bora.fitness.controller;

import com.bora.fitness.model.Member;
import com.bora.fitness.model.dto.UserDTO;
import com.bora.fitness.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //Member registration
    @PostMapping(value = "/member",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> registerMember(@RequestBody Member member){

        Member newMember = registrationService.registerMember(member);

        ModelMapper mp = new ModelMapper();

        UserDTO newUserDto = mp.map(member,UserDTO.class);

        return new ResponseEntity<>(newUserDto, HttpStatus.ACCEPTED);
    }

    @GetMapping
    private String test(){
        return "test";
    }



    private Member userDtoToMember(UserDTO userDTO){
        return new Member(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getPhoneNumber(),
                userDTO.getEmail(),
                userDTO.getRole(),
                userDTO.getStatus()
                );
    }

    private UserDTO memberToUserDto(Member member){
        return new UserDTO(

        );
    }

}

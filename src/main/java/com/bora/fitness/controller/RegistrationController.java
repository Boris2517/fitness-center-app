package com.bora.fitness.controller;


import com.bora.fitness.model.Member;
import com.bora.fitness.model.Trainer;
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
    private ModelMapper mp = new ModelMapper();
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //Member registration
    @PostMapping(value = "/member",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> registerMember(@RequestBody Member member){

        Member newMember = registrationService.registerMember(member);

        UserDTO newUserDto = mp.map(newMember,UserDTO.class);

        return new ResponseEntity<>(newUserDto, HttpStatus.ACCEPTED);
    }

    @PostMapping("/trainer")
    public ResponseEntity<UserDTO> registerTrainer(@RequestBody Trainer trainer){
        Trainer newTrainer = registrationService.registerTrainer(trainer);

        UserDTO userDTO = mp.map(newTrainer, UserDTO.class);

        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);

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

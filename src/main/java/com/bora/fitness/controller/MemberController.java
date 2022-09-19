package com.bora.fitness.controller;

import com.bora.fitness.model.Member;
import com.bora.fitness.model.User;
import com.bora.fitness.model.dto.MemberDTO;
import com.bora.fitness.model.dto.UserDTO;
import com.bora.fitness.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    private ModelMapper mp = new ModelMapper();
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping
    public ResponseEntity<UserDTO> createMember(@RequestBody Member member){
        Member newMember = memberService.createMember(member);
        UserDTO newMemberDto = mp.map(newMember,UserDTO.class);
        return new ResponseEntity<>(newMemberDto, HttpStatus.CREATED);
    }

    //READ
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getMemberById(@PathVariable Long id){
        Member member = memberService.getMemberById(id);
        UserDTO memberDto = mp.map(member, UserDTO.class);
        return new ResponseEntity<>(memberDto,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getMembers(
            @RequestParam(value="page",defaultValue = "1") int page,
            @RequestParam(value="limit",defaultValue = "3") int limit
    ){
        List<Member> members = memberService.getAllMembers(page,limit);
        List<UserDTO> membersDto = members.stream()
                .map(member -> mp.map(member, UserDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(membersDto,HttpStatus.ACCEPTED);
    }

    //UPDATE
    @PutMapping
    public ResponseEntity<UserDTO> updateMember(@RequestBody Member member){
        Member updatedMember = memberService.updateMember(member);
        UserDTO memberDTO = mp.map(updatedMember, UserDTO.class);
        return new ResponseEntity<>(memberDTO,HttpStatus.ACCEPTED);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);

        return ResponseEntity.noContent().build();
    }
}

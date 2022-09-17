package com.bora.fitness.service;

import com.bora.fitness.model.Member;
import com.bora.fitness.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final MemberRepository memberRepository;

    public RegistrationService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(Member member){
        return memberRepository.save(member);
    }

}

package com.bora.fitness.service;

import com.bora.fitness.model.Member;
import com.bora.fitness.model.Trainer;
import com.bora.fitness.repository.MemberRepository;
import com.bora.fitness.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final MemberRepository memberRepository;
    private final TrainerRepository trainerRepository;

    public RegistrationService(MemberRepository memberRepository, TrainerRepository trainerRepository) {
        this.memberRepository = memberRepository;
        this.trainerRepository = trainerRepository;
    }

    public Member registerMember(Member member){
        return memberRepository.save(member);
    }

    public Trainer registerTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
}

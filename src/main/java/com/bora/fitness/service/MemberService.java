package com.bora.fitness.service;

import com.bora.fitness.model.Member;
import com.bora.fitness.repository.MemberRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    public Member updateMember(Member member) {
        Member exist = memberRepository.findById(member.getId()).get();
        exist.setUsername(member.getUsername());
        exist.setPassword(member.getPassword());
        exist.setFirstName(member.getFirstName());
        exist.setLastName(member.getLastName());
        exist.setEmail(member.getEmail());
        exist.setRole(member.getRole());
        exist.setStatus(member.getStatus());
        return memberRepository.save(exist);
    }

    public void deleteMember(Long id) {
        try {
            memberRepository.deleteById(id);
        }catch(Exception exception){
            throw new RuntimeException("Member does not exist!");
        }
    }

    public List<Member> getAllMembers(int page, int limit) {
        Pageable pageable = PageRequest.of(--page,limit);
        List<Member> members = memberRepository.findAll(pageable).getContent();
        return members;
    }
}

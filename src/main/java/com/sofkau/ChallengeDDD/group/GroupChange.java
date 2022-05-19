package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.ChallengeDDD.group.events.*;

import java.util.HashSet;

public class GroupChange extends EventChange {
    public GroupChange(Group group){
        apply((GroupCreated event)->{
            group.quotas= event.getQuotas();
            group.instructors=new HashSet<>();
            group.members=new HashSet<>();
        });

        apply((InstructorAssociated event)->{
            if(group.instructors.size()>3){
                throw new IllegalArgumentException("We don't need more than 3 instructors per group");
            }
            group.instructors.add(new Instructor(event.getInstructor_id(), event.getName(), event.getSpecialty()));

        });

        apply((MemberAssociated event)->{
            if(group.members.size()>25){
                throw new IllegalArgumentException("We can't have more than 25 members in a group");
            }
            group.members.add(new Member(event.getMember_id(), event.getName(), event.getMembership()));

        });

        apply((QuotasUpdated event)->{
            group.quotas= event.getQuotas();

        });

        apply((InstructorNameUpdated event)->{
            var instructor=group.getInstructorById(event.getInstructor_id()).orElseThrow(()-> new IllegalArgumentException("Instructor not found"));
            instructor.updateName(event.getName());
        });

        apply((InstructorSpecialtyChanged event)->{
            var instructor=group.getInstructorById(event.getInstructor_id()).orElseThrow(()-> new IllegalArgumentException("Instructor not found"));
            instructor.changeSpecialty(event.getSpecialty());

        });

        apply((MemberNameUpdated event)->{
            var member=group.getMemberById(event.getMember_id()).orElseThrow(()-> new IllegalArgumentException("Member not found"));
            member.updateName(event.getName());

        });

        apply((MemberMemebershipChanged event)->{
            var member=group.getMemberById(event.getMember_id()).orElseThrow(()-> new IllegalArgumentException("Member not found"));
            member.changeMembership(event.getMembership());

        });
    }
}

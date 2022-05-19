package com.sofkau.ChallengeDDD.group;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.ChallengeDDD.group.events.*;
import com.sofkau.ChallengeDDD.group.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Group extends AggregateEvent<Group_Id> {
    protected Quotas quotas;
    protected Set<Instructor> instructors;
    protected Set<Member> members;

    public Group(Group_Id entityId, Quotas quotas) {
        super(entityId);
        appendChange(new GroupCreated(quotas)).apply();
    }

    private Group(Group_Id entityId){
        super(entityId);
        subscribe(new GroupChange(this));
    }

    public static Group from(Group_Id group_id, List<DomainEvent> events){
        var group = new Group(group_id);
        events.forEach(group::applyEvent);
        return group;
    }

    public void associateInstructor(Instructor_Id entityId, Name name, Specialty specialty){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(specialty);
        appendChange(new InstructorAssociated(entityId,name,specialty)).apply();
    }

    public void associateMember(Member_Id entityId, Name name, Membership membership){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(membership);
        appendChange(new MemberAssociated(entityId,name,membership)).apply();
    }

    public void updateQuotas(Group_Id entityId, Quotas quotas){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(quotas);
        appendChange(new QuotasUpdated(entityId,quotas)).apply();
    }

    public void updateInstructorName(Instructor_Id entityId,Name name){
        appendChange(new InstructorNameUpdated(entityId,name)).apply();

    }

    public void changeInstructorSpecialty(Instructor_Id instructor_id,Specialty specialty){
        appendChange(new InstructorSpecialtyChanged(instructor_id,specialty)).apply();

    }

    public void updateMemberName(Member_Id entityId,Name name){
        appendChange(new MemberNameUpdated(entityId,name)).apply();

    }
    public void changeMemberMembership(Member_Id entityId,Membership membership){
        appendChange(new MemberMemebershipChanged(entityId,membership)).apply();

    }

    protected Optional<Instructor> getInstructorById(Instructor_Id instructor_id){
        return instructors.stream().filter(instructor-> instructor.identity().equals(instructor_id)).findFirst();
    }

    protected Optional<Member> getMemberById(Member_Id member_id){
        return members.stream().filter(member-> member.identity().equals(member_id)).findFirst();
    }

    public Quotas Quotas() {
        return quotas;
    }

    public Set<Instructor> Instructors() {
        return instructors;
    }

    public Set<Member> Members() {
        return members;
    }
}

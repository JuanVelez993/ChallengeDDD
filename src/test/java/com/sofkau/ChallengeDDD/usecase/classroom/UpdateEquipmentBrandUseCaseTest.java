package com.sofkau.ChallengeDDD.usecase.classroom;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.ChallengeDDD.classroom.commands.UpdateEquipmentBrand;
import com.sofkau.ChallengeDDD.classroom.events.ClassroomCreated;
import com.sofkau.ChallengeDDD.classroom.events.EquipmentAssociated;
import com.sofkau.ChallengeDDD.classroom.events.EquipmentBrandUpdated;
import com.sofkau.ChallengeDDD.classroom.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateEquipmentBrandUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateEquipmentBrand() {
        
        Classroom_Id classroom_id = Classroom_Id.of("classwithequipment");
        Equipment_Id equipment_id = Equipment_Id.of("equipmentwithwrongbrand");
        Brand brand = new Brand("Decathlon");

        var command = new UpdateEquipmentBrand(classroom_id, equipment_id, brand);
        var useCase = new UpdateEquipmentBrandUseCase();

        Mockito.when(repository.getEventsBy("classwithequipment")).thenReturn(List.of(
                new ClassroomCreated(
                        new Capacity(15)
                ),
                new EquipmentAssociated(Equipment_Id.of("equipmentwithwrongbrand"),
                        new Equipment_type("Dumbell"),
                        new Brand("Speedex")

        )));

        useCase.addRepository(repository);


        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("classwithequipment")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while updating the brand"))
                .getDomainEvents();


        var event = (EquipmentBrandUpdated) events.get(0);
        Assertions.assertEquals("Decathlon",event.getBrand().value());
        Mockito.verify(repository).getEventsBy("classwithequipment");
    }

}
package org.synapsis.invitation.DataFixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.synapsis.invitation.Entity.Invitation;
import org.synapsis.invitation.Repository.InvitationRepository;

import java.util.UUID;

@Component
public class InvitationDataFixture implements CommandLineRunner {

    @Autowired
    private InvitationRepository repository;

    @Override
    public void run(String... args) throws Exception {

        for (int i=0; i<10 ; i++){
            repository.save(new Invitation("invitation"+i+".@synapis.com", UUID.randomUUID()));
        }

        repository.findAll().forEach(System.out::println);
    }
}

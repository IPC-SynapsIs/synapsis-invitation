package org.synapsis.invitation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.synapsis.invitation.bean.Invitation;
import org.synapsis.invitation.dao.InvitationRepository;
import org.synapsis.invitation.service.IInvitationService;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Marvell on 27/06/2016.
 */
@Component
public class InvitationService implements IInvitationService{

    @Autowired
    InvitationRepository invitationRepository;


    @Override
    public Invitation get(Long id) {
        return invitationRepository.findOne(id);
    }

    @Override
    public Iterable<Invitation> getAll() {
        return invitationRepository.findAll();
    }

    @Override
    public Collection<Invitation> findByWhoInvited(UUID whoInvited) {
        return invitationRepository.findByWhoInvited(whoInvited);
    }

    @Override
    public void send(Invitation invitation) {
        invitationRepository.save(invitation);
    }

    @Override
    public void remove(Long id) {
        invitationRepository.delete(id);
    }
}

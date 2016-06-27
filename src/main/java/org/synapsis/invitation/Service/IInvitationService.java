package org.synapsis.invitation.service;

import org.springframework.stereotype.Component;
import org.synapsis.invitation.bean.Invitation;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Marvell on 27/06/2016.
 */
@Component
public interface IInvitationService {

    Invitation get(Long id);
    Iterable<Invitation> getAll();
    Collection<Invitation> findByWhoInvited(UUID whoInvited);
    void send(Invitation invitation);
    void remove(Long id);
}

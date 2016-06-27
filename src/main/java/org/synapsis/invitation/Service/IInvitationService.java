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

    /**
     *
     * @param id
     * @return
     */
    Invitation get(Long id);

    /**
     *
     * @return
     */
    Iterable<Invitation> getAll();

    /**
     *
     * @param whoInvited
     * @return
     */
    Collection<Invitation> findByWhoInvited(UUID whoInvited);

    /**
     *
     * @param invitation
     */
    void send(Invitation invitation);

    /**
     *
     * @param id
     */
    void remove(Long id);
}

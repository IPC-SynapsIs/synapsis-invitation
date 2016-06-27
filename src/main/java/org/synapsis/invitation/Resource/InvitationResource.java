package org.synapsis.invitation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.synapsis.invitation.Entity.Invitation;
import org.synapsis.invitation.Service.IInvitationService;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Marvell on 27/06/2016.
 */
@RestController
@RequestMapping("/invitation")
public class InvitationResource {

    @Autowired
    IInvitationService invitationService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public Invitation sendInvitation(@RequestBody Invitation invitation) {
        invitationService.send(invitation);
        return invitation;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Invitation get(@PathVariable("id") Long id) {
        return invitationService.get(id);
    }

    @RequestMapping(value = "/whoinvited/{whoinvited}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Collection<Invitation> getByWhoInvited(@PathVariable("whoinvited") UUID whoinvited) {
        return invitationService.findByWhoInvited(whoinvited);
    }
}

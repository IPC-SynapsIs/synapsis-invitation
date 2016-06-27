package org.synapsis.invitation.resource;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.synapsis.invitation.bean.Invitation;
import org.synapsis.invitation.service.IInvitationService;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Marvell on 27/06/2016.
 */
@RestController
@RequestMapping("/invitation")
@Api( value = "Invitation",description = "Bean for resource 'Invitation'")
public class InvitationResource {

    @Autowired
    IInvitationService invitationService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Send an invitation")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Invitation created", response = Invitation.class),
            @ApiResponse(code = 404, message = "Invitation not created", response = void.class)})
    public Invitation sendInvitation(@ApiParam(value = "Invitation Object", required = true) @RequestBody Invitation invitation) {
        invitationService.send(invitation);
        return invitation;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Get an invitation by his Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "The invitation is found", response = Invitation.class),
            @ApiResponse(code = 404, message = "Invitation not found", response = void.class)})
    public Invitation get(@ApiParam(value = "Invitation Id", required = true) @PathVariable("id") Long id) {
        return invitationService.get(id);
    }

    @RequestMapping(value = "/whoinvited/{whoinvited}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Get all invitations sent by a specific user")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "invitation(s) found", response = Invitation.class),
            @ApiResponse(code = 404, message = "No invitation found", response = void.class)})
    public Collection<Invitation> getByWhoInvited(@ApiParam(value = "User Id", required = true) @PathVariable("whoinvited") UUID whoinvited) {
        return invitationService.findByWhoInvited(whoinvited);
    }
}

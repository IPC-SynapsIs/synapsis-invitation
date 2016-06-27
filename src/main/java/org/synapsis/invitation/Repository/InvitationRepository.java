package org.synapsis.invitation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.synapsis.invitation.Entity.Invitation;

import java.util.Collection;
import java.util.UUID;

@RepositoryRestResource
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    @RestResource (path = "by-who-invited")
    Collection<Invitation> findByWhoInvited(@Param("whoinvited") UUID whoInvited);
}

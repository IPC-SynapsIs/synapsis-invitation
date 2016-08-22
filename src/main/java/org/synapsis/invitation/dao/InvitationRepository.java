package org.synapsis.invitation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.synapsis.invitation.bean.Invitation;

import java.util.Collection;
import java.util.UUID;

@RepositoryRestResource
public interface InvitationRepository{

}

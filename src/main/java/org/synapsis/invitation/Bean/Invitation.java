package org.synapsis.invitation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Entity
public class Invitation {

    @Id
    @GeneratedValue
    private long id;

    private String code;

    private boolean sent = false;

    private boolean accepted = false;

    private String email;

    private UUID whoInvited;

    Invitation() {
    }

    public Invitation(String email, UUID whoInvited) {
        this.email = email;
        this.whoInvited = whoInvited;
        this.code = generateInvitationCode();
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", sent=" + sent +
                ", accepted=" + accepted +
                ", email='" + email + '\'' +
                ", whoInvited=" + whoInvited +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public boolean isSent() {
        return sent;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getEmail() {
        return email;
    }

    public UUID getWhoInvited() {
        return whoInvited;
    }

    private String generateInvitationCode(){
        String code = UUID.randomUUID().toString();
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(code.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            code = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return code.substring(0, Math.min(code.length(),6));
    }
}

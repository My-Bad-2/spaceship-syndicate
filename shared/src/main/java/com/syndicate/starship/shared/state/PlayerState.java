package com.syndicate.starship.shared.state;

import com.syndicate.starship.shared.common.PlayerRole;
import java.util.UUID;

public class PlayerState {
    private String id;
    public String name;
    public PlayerRole role = PlayerRole.UNASSIGNED;
    private boolean idGenerated = false;

    public PlayerState() {}

    public String getId() {
        return id;
    }

    public void generatePlayerId() {
        if(idGenerated) {
            return;
        }

        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.idGenerated = true;
    }
}

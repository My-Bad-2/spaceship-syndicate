package com.syndicate.starship.shared.network;

import com.esotericsoftware.kryo.Kryo;
import com.syndicate.starship.shared.state.GameState;

public class NetworkRegistry {
    public static void register(Kryo kryo) {
        kryo.register(GameState.class);
    }
}

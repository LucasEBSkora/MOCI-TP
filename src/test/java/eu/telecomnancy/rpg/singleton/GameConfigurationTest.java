package eu.telecomnancy.rpg.singleton;

import org.junit.jupiter.api.Test;

import static eu.telecomnancy.rpg.singleton.GameConfiguration.getInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameConfigurationTest {

    @Test
    void getInstanceCreatesObject() {
        GameConfiguration instance = getInstance();
        assertNotNull(instance);
        assertEquals(5, instance.maxPartySize);
        instance.maxPartySize = 10;
        GameConfiguration otherInstance = getInstance();
        assertEquals(10, otherInstance.maxPartySize);
    }
}
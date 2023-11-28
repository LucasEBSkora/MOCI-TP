package eu.telecomnancy.rpg.singleton;

import eu.telecomnancy.rpg.singleton.GameConfiguration;
import org.junit.jupiter.api.Test;

import static eu.telecomnancy.rpg.singleton.GameConfiguration.*;
import static org.junit.jupiter.api.Assertions.*;

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
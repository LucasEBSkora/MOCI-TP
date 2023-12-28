package eu.telecomnancy.rpg.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Team team;
    GameCharacter character;

    @BeforeEach
    void setUp() {
        team = new Team("test");
        character = new Wizard("aaaa");
    }
    @Test
    void testCreateTeam() {
        assertEquals(0, team.size());
    }
    @Test
    void AddCharacterToTeam() throws Exception {
        team.addPlayer(character);
        assertEquals(1, team.size());
    }

    @Test
    void removeCharacter() throws Exception {
        team.removePlayer("aaaa");
        team.removePlayer(character);
        assertEquals(0, team.size());
        Warrior char2 = new Warrior("bbbb");
        team.addPlayer(character);
        team.addPlayer(char2);
        assertEquals(2, team.size());
        team.removePlayer(character);
        team.removePlayer("bbbb");
        assertEquals(0, team.size());
    }

    @Test
    void getPlayer() throws Exception {
        assertNull(team.getPlayer("aaaa"));
        team.addPlayer(character);
        assertEquals(character, team.getPlayer("aaaa"));
    }

    @Test
    void containsPlayer() throws Exception {
        assertFalse(team.containsPlayer("aaaa"));
        assertFalse(team.containsPlayer(character));
        team.addPlayer(character);
        assertTrue(team.containsPlayer(character));
        assertTrue(team.containsPlayer("aaaa"));
    }

}
package com.example.neo4jdemo;

import static org.assertj.core.api.Assertions.*;
import com.example.neo4jdemo.neo4j.matadata.Relationship.*;
import com.example.neo4jdemo.neo4j.matadata.schema.*;
import com.example.neo4jdemo.neo4j.matadata.schema.Relationship;
import com.example.neo4jdemo.neo4j.matadata.schema.RelationshipImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Frantisek Hartman
 * @author Michael J. Simons
 */
public class RelationshipImplTest {

    private NodeImpl start;
    private NodeImpl end;
    private Relationship outgoing;
    private Relationship incoming;
    private Relationship undirected;

    @Before
    public void setUp() {
        start = new NodeImpl("Person");
        end = new NodeImpl("Person");

        outgoing = new RelationshipImpl("FRIEND_OF", Direction.OUTGOING, start, end);
        incoming = new RelationshipImpl("FRIEND_OF", Direction.INCOMING, start, end);
        undirected = new RelationshipImpl("FRIEND_OF", Direction.UNDIRECTED, start, end);
    }

    @Test
    public void givenUndirectedRelationship_whenDirection_thenReturnUndirected() {
        assertThat(undirected.direction(start)).isEqualTo(Direction.UNDIRECTED);
        assertThat(undirected.direction(end)).isEqualTo(Direction.UNDIRECTED);
    }

    @Test
    public void givenOutgoingRelationship_whenDirectionStart_thenReturnOutgoing() {
        assertThat(outgoing.direction(start)).isEqualTo(Direction.OUTGOING);
    }

    @Test
    public void givenOutgoingRelationship_whenDirectionEnd_thenReturnIncoming() {
        assertThat(outgoing.direction(end)).isEqualTo(Direction.INCOMING);
    }

    @Test
    public void givenIncomingRelationship_whenDirectionStart_thenReturnIncoming() {
        assertThat(incoming.direction(start)).isEqualTo(Direction.INCOMING);
    }

    @Test
    public void givenIncomingRelationship_whenDirectionEnd_thenReturnOutgoing() {
        assertThat(incoming.direction(end)).isEqualTo(Direction.OUTGOING);
    }
}

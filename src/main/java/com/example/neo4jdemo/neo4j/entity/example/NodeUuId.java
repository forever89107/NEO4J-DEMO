package com.example.neo4jdemo.neo4j.entity.example;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import static java.util.UUID.randomUUID;

@NodeEntity
public abstract class NodeUuId {

    public NodeUuId() {
        uuid = randomUUID().toString();
    }

    @Id
    protected String uuid;

    @Labels
    protected Set<String> labels = new HashSet<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public void addLabel(Object... additionalLabels) {
        for (Object label : additionalLabels) {
            this.labels.add(label.toString());
        }
    }

    public void removeLabel(Object... labelsToRemove) {
        for (Object label : labelsToRemove) {
            this.labels.remove(label.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NodeUuId entity = (NodeUuId) o;
        return Objects.equals(uuid, entity.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}

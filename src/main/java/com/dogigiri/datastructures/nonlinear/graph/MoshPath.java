package com.dogigiri.datastructures.nonlinear.graph;

import java.util.ArrayList;
import java.util.List;

public class MoshPath {
    private List<String> nodes = new ArrayList<>();

    public void add(String node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}

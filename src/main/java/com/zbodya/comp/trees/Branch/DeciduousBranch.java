package com.zbodya.comp.trees.Branch;

import com.zbodya.comp.trees.Leave.SimpleLeave;

import java.util.ArrayList;
import java.util.List;

public class DeciduousBranch extends Branch<SimpleLeave>
{
    private List<SimpleLeave> leaves;

    public DeciduousBranch(String branch) {
        super(branch);
        this.leaves = new ArrayList<>();
    }

    public List<SimpleLeave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<SimpleLeave> leaves) {
        this.leaves = leaves;
    }

    @Override
    public void addLeave(SimpleLeave leave)
    {
        this.leaves.add((leave));
    }
}

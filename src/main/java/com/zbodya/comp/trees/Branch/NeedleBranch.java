package com.zbodya.comp.trees.Branch;

import com.zbodya.comp.trees.Leave.NeedleLeave;

import java.util.ArrayList;
import java.util.List;

public class NeedleBranch extends Branch<NeedleLeave>
{
    private List<NeedleLeave> leaves;

    public NeedleBranch(String branch) {
        super(branch);
        this.leaves = new ArrayList<>();
    }

    public List<NeedleLeave> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<NeedleLeave> leaves) {
        this.leaves = leaves;
    }

    @Override
    public void addLeave(NeedleLeave leave)
    {
        this.leaves.add(leave);
    }
}

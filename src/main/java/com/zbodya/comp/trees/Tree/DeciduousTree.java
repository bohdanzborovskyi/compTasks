package com.zbodya.comp.trees.Tree;

import com.zbodya.comp.trees.Branch.DeciduousBranch;
import com.zbodya.comp.trees.Leave.Leave;
import com.zbodya.comp.trees.Leave.SimpleLeave;

import java.util.ArrayList;
import java.util.List;

public class DeciduousTree extends Tree<DeciduousBranch>
{
    private List<DeciduousBranch>branches;

    public DeciduousTree(String tree) {
        super(tree);
        this.branches = new ArrayList<>();
    }

    public List<DeciduousBranch> getBranches() {
        return branches;
    }

    @Override
    public void addBranch(DeciduousBranch branch)
    {
        this.branches.add(branch);
    }

    @Override
    public void grow()
    {
        DeciduousBranch branch = new DeciduousBranch("Grown deciduous branch ");
        for(int i=0; i<20; i++)
        {
            SimpleLeave simpleLeave = new SimpleLeave("Grown simple leave" + i);
            branch.addLeave(simpleLeave);
        }
        this.branches.add(branch);
    }

    @Override
    public void cutDown()
    {
        for(DeciduousBranch branch : this.branches)
        {
            for(SimpleLeave leave : branch.getLeaves())
            {
                branch.getLeaves().remove(leave);
            }
            this.branches.remove(branch);
        }
        this.branches = null;
    }

    @Override
    public void dryUp()
    {
        for(DeciduousBranch branch : this.branches)
        {
            for(int i=0; i<branch.getLeaves().size(); i++)
            {
                branch.getLeaves().remove(i);
            }
        }
    }
}

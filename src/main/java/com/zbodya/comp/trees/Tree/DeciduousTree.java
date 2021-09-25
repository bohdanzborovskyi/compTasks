package com.zbodya.comp.trees.Tree;

import com.zbodya.comp.trees.Branch.DeciduousBranch;
import com.zbodya.comp.trees.Leaf.SimpleLeaf;



public class DeciduousTree extends Tree<DeciduousBranch>
{
    public DeciduousTree(String treeName) {
        super(treeName);
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
            branch.addLeaf(new SimpleLeaf("Grown simple leave" + i));
        }
        this.branches.add(branch);
    }

    @Override
    public void cutDown()
    {
        this.branches.stream().forEach(deciduousBranch -> deciduousBranch.getLeaves().clear());
        this.branches = null;
    }

    @Override
    public void dryUp()
    {
        this.branches.stream().forEach(deciduousBranch -> deciduousBranch.getLeaves().clear());
    }
}

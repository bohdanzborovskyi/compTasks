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
            SimpleLeaf simpleLeaf = new SimpleLeaf("Grown simple leave" + i);
            branch.addLeaf(simpleLeaf);
        }
        this.branches.add(branch);
    }

    @Override
    public void cutDown()
    {
        for(DeciduousBranch branch : this.branches)
        {
            for(SimpleLeaf leave : branch.getLeaves())
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

package com.zbodya.comp.trees.Tree;

import com.zbodya.comp.trees.Branch.NeedleBranch;
import com.zbodya.comp.trees.Leaf.NeedleLeaf;


public class NeedleTree extends Tree<NeedleBranch>
{
    public NeedleTree(String treeName) {
        super(treeName);
    }

    @Override
    public void addBranch(NeedleBranch branch)
    {
        this.branches.add(branch);
    }

    @Override
    public void grow()
    {
        NeedleBranch needleBranch = new NeedleBranch("Grown needle branch");
        for(int i=0; i<20; i++)
        {
            NeedleLeaf needleLeaf = new NeedleLeaf("Grown needle leave" + i);
            needleBranch.addLeaf(needleLeaf);
        }
        this.branches.add(needleBranch);
    }

    @Override
    public void cutDown()
    {
        for(NeedleBranch branch : this.branches)
        {
            for(NeedleLeaf leave : branch.getLeaves())
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
        for(NeedleBranch branch : this.branches)
        {
            for(int i=0; i<branch.getLeaves().size(); i++)
            {
                branch.getLeaves().remove(i);
            }
        }
    }
}

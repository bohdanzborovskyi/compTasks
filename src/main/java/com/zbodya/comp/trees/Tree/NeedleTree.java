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
            needleBranch.addLeaf(new NeedleLeaf("Grown needle leave" + i));
        }
        this.branches.add(needleBranch);
    }

    @Override
    public void cutDown()
    {
        this.branches.stream().forEach(needleBranch -> needleBranch.getLeaves().clear());
        this.branches = null;
    }

    @Override
    public void dryUp()
    {
        this.branches.stream().forEach(needleBranch -> needleBranch.getLeaves().clear());
    }
}

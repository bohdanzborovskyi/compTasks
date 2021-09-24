package com.zbodya.comp.trees.Branch;

import com.zbodya.comp.trees.Leaf.NeedleLeaf;


public class NeedleBranch extends Branch<NeedleLeaf>
{
    public NeedleBranch(String branch) {
        super(branch);
    }

    @Override
    public void addLeaf(NeedleLeaf leave)
    {
        this.leaves.add(leave);
    }
}

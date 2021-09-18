package com.zbodya.comp.trees.Tree;

import com.zbodya.comp.trees.Branch.NeedleBranch;
import com.zbodya.comp.trees.Leave.Leave;
import com.zbodya.comp.trees.Leave.NeedleLeave;
import com.zbodya.comp.trees.Leave.SimpleLeave;

import java.util.ArrayList;
import java.util.List;

public class NeedleTree extends Tree<NeedleBranch>
{
    private List<NeedleBranch>branches;

    public NeedleTree(String tree) {
        super(tree);
        this.branches = new ArrayList<>();
    }

    public List<NeedleBranch> getBranches() {
        return branches;
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
            NeedleLeave needleLeave = new NeedleLeave("Grown needle leave" + i);
            needleBranch.addLeave(needleLeave);
        }
        this.branches.add(needleBranch);
    }

    @Override
    public void cutDown()
    {
        for(NeedleBranch branch : this.branches)
        {
            for(NeedleLeave leave : branch.getLeaves())
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

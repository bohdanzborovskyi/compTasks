package com.zbodya.comp.trees.Branch;

import com.zbodya.comp.trees.Leaf.Leaf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract public class Branch <L extends Leaf>
{
    protected List<L> leaves;
    protected String branchName;
    public Branch(String branchName)
    {
        this.branchName = branchName;
        this.leaves = new ArrayList<>();
    }
    abstract public void addLeaf(L leaf);

}

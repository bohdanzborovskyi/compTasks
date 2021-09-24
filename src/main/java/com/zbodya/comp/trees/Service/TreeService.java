package com.zbodya.comp.trees.Service;

import com.zbodya.comp.trees.Branch.DeciduousBranch;
import com.zbodya.comp.trees.Branch.NeedleBranch;
import com.zbodya.comp.trees.Leaf.NeedleLeaf;
import com.zbodya.comp.trees.Leaf.SimpleLeaf;
import com.zbodya.comp.trees.Tree.DeciduousTree;
import com.zbodya.comp.trees.Tree.NeedleTree;
import com.zbodya.comp.trees.Trunk.Trunk;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TreeService
{
    public static void loadTreeData()
    {
        // Create trunks
        Trunk needleTrunk = new Trunk("Needle trunk");
        Trunk deciduousTrunk = new Trunk("Deciduous trunk");
        // Create trees
        DeciduousTree deciduousTree = new DeciduousTree("Deciduous tree");
        NeedleTree needleTree = new NeedleTree("Deciduous tree");
        // Setting trunks to trees
        deciduousTree.setTrunk(deciduousTrunk);
        needleTree.setTrunk(needleTrunk);
        // Creating branches with leaves and adding them to trees
        for(int i=0; i<25; i++)
        {
            DeciduousBranch decidousBranch = new DeciduousBranch("Deciduous branch" + i);
            for(int j=0; j<20; j++)
            {
                SimpleLeaf simpleLeaf = new SimpleLeaf("Simple leave" + j);
                decidousBranch.addLeaf(simpleLeaf);
            }
            NeedleBranch neddleBranch = new NeedleBranch("Needle branch" + i);
            for(int j=0; j<20; j++)
            {
                NeedleLeaf needleLeaf = new NeedleLeaf("Needle leave" + j);
                neddleBranch.addLeaf(needleLeaf);
            }
            needleTree.addBranch(neddleBranch);
            deciduousTree.addBranch(decidousBranch);
        }

        // Info about loading trees
//        log.info(needleTree.getBranches().toString());
//        for(int i=0; i<25; i++)
//        {
//            needleTree.getBranches().forEach(needleBranch -> needleBranch.getLeaves().forEach(NeedleLeaf::getType));
//            deciduousTree.getBranches().forEach(deciduousBranch -> deciduousBranch.getLeaves().forEach(SimpleLeaf::getType));
//        }
    }
}

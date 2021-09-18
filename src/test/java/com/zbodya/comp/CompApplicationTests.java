package com.zbodya.comp;

import com.zbodya.comp.trees.Branch.DeciduousBranch;
import com.zbodya.comp.trees.Branch.NeedleBranch;
import com.zbodya.comp.trees.Leave.NeedleLeave;
import com.zbodya.comp.trees.Leave.SimpleLeave;
import com.zbodya.comp.trees.Tree.DeciduousTree;
import com.zbodya.comp.trees.Tree.NeedleTree;
import com.zbodya.comp.trees.Trunk.Trunk;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CompApplicationTests
{

    @Test
    void contextLoads()
    {

    }

    @Test
    void createDeciduousTreeAndCheck()
    {
        Trunk trunk = new Trunk("Deciduous trunk");
        DeciduousTree deciduousTree = new DeciduousTree("Deciduous tree");
        deciduousTree.setTrunk(trunk);
        assertThat(deciduousTree.getTrunk()).isNotNull();
        assertThat(deciduousTree.getTrunk().getTrunk()).isEqualTo("Deciduous trunk");
        assertThat(deciduousTree.getTree()).isEqualTo("Deciduous tree");
        assertThat(deciduousTree.getBranches()).isNotNull();
        DeciduousBranch deciduousBranch = new DeciduousBranch("Deciduous branch");
        assertThat(deciduousBranch.getBranch()).isEqualTo("Deciduous branch");
        SimpleLeave simpleLeave = new SimpleLeave("Simple leave");
        assertThat(simpleLeave.getLeave()).isEqualTo("Simple leave");
        deciduousBranch.addLeave(simpleLeave);
        assertThat(deciduousBranch.getLeaves().size()).isEqualTo(1);
        assertThat(deciduousBranch.getLeaves().get(0)).isNotNull();
        deciduousTree.addBranch(deciduousBranch);
        assertThat(deciduousTree.getBranches().size()).isEqualTo(1);
        assertThat(deciduousTree.getBranches().get(0)).isNotNull();
        deciduousTree.grow();
        assertThat(deciduousTree.getBranches().size()).isEqualTo(2);
        deciduousTree.dryUp();
        assertThat(deciduousTree.getBranches().get(0).getLeaves().size()).isEqualTo(0);
        deciduousTree.cutDown();
        assertThat(deciduousTree.getBranches()).isNull();
    }

    @Test
    void createNeedleTreeAndCheck()
    {
        Trunk trunk = new Trunk("Needle trunk");
        NeedleTree needleTree = new NeedleTree("Needle tree");
        needleTree.setTrunk(trunk);
        assertThat(needleTree.getTrunk()).isNotNull();
        assertThat(needleTree.getTrunk().getTrunk()).isEqualTo("Needle trunk");
        assertThat(needleTree.getTree()).isEqualTo("Needle tree");
        assertThat(needleTree.getBranches()).isNotNull();
        NeedleBranch needleBranch = new NeedleBranch("Needle branch");
        assertThat(needleBranch.getBranch()).isEqualTo("Needle branch");
        NeedleLeave needleLeave = new NeedleLeave("Needle leave");
        assertThat(needleLeave.getLeave()).isEqualTo("Needle leave");
        needleBranch.addLeave(needleLeave);
        assertThat(needleBranch.getLeaves().size()).isEqualTo(1);
        assertThat(needleBranch.getLeaves().get(0)).isNotNull();
        needleTree.addBranch(needleBranch);
        assertThat(needleTree.getBranches().size()).isEqualTo(1);
        assertThat(needleTree.getBranches().get(0)).isNotNull();
        needleTree.grow();
        assertThat(needleTree.getBranches().size()).isEqualTo(2);
        needleTree.dryUp();
        assertThat(needleTree.getBranches().get(0).getLeaves().size()).isEqualTo(0);
        needleTree.cutDown();
        assertThat(needleTree.getBranches()).isNull();
    }

}

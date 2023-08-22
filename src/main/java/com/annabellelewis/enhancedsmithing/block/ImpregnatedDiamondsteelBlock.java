package com.annabellelewis.enhancedsmithing.block;

import com.annabellelewis.enhancedsmithing.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;

public class ImpregnatedDiamondsteelBlock extends Block implements SculkBehaviour {
    public ImpregnatedDiamondsteelBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public int attemptUseCharge(SculkSpreader.ChargeCursor chargeCursor, LevelAccessor levelAccessor, BlockPos blockPos, RandomSource randomSource, SculkSpreader sculkSpreader, boolean p_222078_) {

        BlockPos chargeCursorPos = chargeCursor.getPos();
        BlockState roughVibroniteState = Registration.ROUGH_VIBRONITE_BLOCK.get().defaultBlockState();
        levelAccessor.setBlock(chargeCursorPos, roughVibroniteState, 3);
        levelAccessor.playSound((Player)null, chargeCursorPos, roughVibroniteState.getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);

        return Math.max(0, chargeCursor.getCharge() - getDecayPenalty(sculkSpreader, chargeCursorPos, blockPos, randomSource.nextInt()));
    }

    private static int getDecayPenalty(SculkSpreader sculkSpreader, BlockPos cursorPos, BlockPos blockPos, int p_222083_) {
        int i = sculkSpreader.noGrowthRadius();
        float f = Mth.square((float)Math.sqrt(cursorPos.distSqr(blockPos)) - (float)i);
        int j = Mth.square(24 - i);
        float f1 = Math.min(1.0F, f / (float)j);
        return Math.max(1, (int)((float)p_222083_ * f1 * 0.5F));
    }



    public boolean canChangeBlockStateOnSpread() {
        return false;
    }
}

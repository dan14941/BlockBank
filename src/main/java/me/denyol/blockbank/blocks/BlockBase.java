package me.denyol.blockbank.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBase extends Block
{

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
	private boolean canSpawnInBlock;
	
	public BlockBase(ModBlocks.Blocks block)
	{
		super(block.getMaterial());
		setUnlocalizedName(block.getUnlocalizedName());
		setRegistryName(block.getRegistryName());
		setCreativeTab(block.getCreativeTabs());
		
		this.canSpawnInBlock = super.canSpawnInBlock();
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOUNDING_BOX;
	}
	
	public void setCanSpawnInBlock(boolean value)
	{
		this.canSpawnInBlock = value;
	}
	
	@Override
	public boolean canSpawnInBlock()
	{
		return this.canSpawnInBlock;
	}

}

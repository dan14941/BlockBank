package me.denyol.blockbank.integration.jei;

import me.denyol.blockbank.BlockBank;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

/**
 * Created by Daniel on 26/1/17.
 */
public class ForgeRecipeCategory extends BlankRecipeCategory<ForgeRecipeWrapper>
{

	private IDrawable background;

	public static final String ID = BlockBank.MOD_ID + ".forgeRecipeCategory";

	public ForgeRecipeCategory(IGuiHelper helper)
	{
		background = helper.createDrawable(new ResourceLocation(BlockBank.MOD_ID, "textures/gui/CoinForgeContainer.png"), 35, 16, 106, 54);
	}

	@Nonnull
	@Override
	public String getUid()
	{
		return ID;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return I18n.format("container.tile_entity_coin_forge");
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ForgeRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(0, true, 0, 0);
		guiItemStacks.init(1, true, 26, 18);
		guiItemStacks.init(2, true, 0, 36);
		guiItemStacks.init(3, false, 85, 18);

		guiItemStacks.set(0, ingredients.getInputs(ItemStack.class).get(0));
		guiItemStacks.set(1, ingredients.getInputs(ItemStack.class).get(1));

		guiItemStacks.set(3, ingredients.getOutputs(ItemStack.class).get(0));
	}

	@Override
	public void drawExtras(@Nonnull Minecraft minecraft) {
		return;
	}

	@Override
	public void drawAnimations(@Nonnull Minecraft minecraft) {
		return;
	}
}

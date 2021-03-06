/*
 * <BlockBank Minecraft Forge economy mod>
 *     Copyright (C) <2017>  <Daniel Tucker>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package me.denyol.blockbank.items;

import me.denyol.blockbank.BlockBank;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModItems
{
	
	public static Item goldCoin;

	public static Item ironCoin; //TODO add

	public static Item emeraldCoin; //TODO add
	
	public static Item unfiredCoinMold;
	public static Item coinMold;

	public static Item wallet;
	
	public static void loadItems()
	{
		goldCoin = new ItemGoldCoin(Items.GOLD_COIN);
		unfiredCoinMold = new ItemUnfiredCoinMold(Items.UNFIRED_COIN_MOLD);
		coinMold = new ItemCoinMold(Items.COIN_MOLD);
		wallet = new ItemWallet(Items.WALLET);
	}
	
	public static void registerForRendering()
	{
		registerRender(goldCoin);
		registerRender(unfiredCoinMold);
		registerRender(coinMold);
		registerRender(wallet);
	}
	
	private static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public enum Items
	{
		GOLD_COIN("gold_coin", "gold_coin"),
		IRON_COIN("iron_coin", "iron_coin"),
		UNFIRED_COIN_MOLD("unfired_coin_mold", "unfired_coin_mold"),
		COIN_MOLD("coin_mold", "coin_mold"),
		WALLET("wallet", "wallet");
		
		private String unlocalizedName;
		private String registryName; // should be unique
		private CreativeTabs creativeTabs;
		
		Items(String unlocalizedName, String registryName, CreativeTabs creativeTabs)
		{
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
			this.creativeTabs = creativeTabs;
		}
		
		Items(String unlocalizedName, String registryName)
		{
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
			this.creativeTabs = BlockBank.CREATIVE_TAB;
		}
		
		public String getUnlocalizedName()
		{
			return unlocalizedName;
		}
		
		public String getRegistryName()
		{
			return registryName;
		}
		
		public CreativeTabs getCreativeTabs()
		{
			return creativeTabs;
		}
		
	}
}

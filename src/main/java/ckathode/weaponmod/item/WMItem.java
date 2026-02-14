package ckathode.weaponmod.item;

import ckathode.weaponmod.WMCommonProxy;
import cpw.mods.fml.common.registry.GameData;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ckathode.weaponmod.BalkonsWeaponMod;

public class WMItem extends Item
{
	public WMItem(String id)
	{
		//GameRegistry.registerItem(this, id, BalkonsWeaponMod.MOD_ID);
		GameData.getItemRegistry().addObject(WMCommonProxy.itemList.get(id), id, this);
		setUnlocalizedName(id);
		setTextureName("weaponmod:" + id);
		setCreativeTab(CreativeTabs.tabCombat);
	}

}

package ckathode.weaponmod;

import net.minecraftforge.common.MinecraftForge;
import ckathode.weaponmod.network.MsgCannonFire;
import ckathode.weaponmod.network.MsgExplosion;
import ckathode.weaponmod.network.WMMessagePipeline;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WMCommonProxy
{

	public static Configuration config;
	public static Map<String, Integer> itemList = new LinkedHashMap<String, Integer>();

	public void registerEventHandlers()
	{
		MinecraftForge.EVENT_BUS.register(new WMCommonEventHandler());
	}
	
	public void registerPackets(WMMessagePipeline pipeline)
	{
		pipeline.registerPacket(MsgCannonFire.class);
		pipeline.registerPacket(MsgExplosion.class);
	}
	
	public void registerIcons()
	{
	}
	
	public void registerRenderers(WeaponModConfig config)
	{
	}

	public void initConfig() {
		WMCommonProxy.config.load();

		itemList.put("spear.wood", 0);
		itemList.put("spear.stone", 0);
		itemList.put("spear.iron", 0);
		itemList.put("spear.gold", 0);
		itemList.put("spear.diamond", 0);

		// Halberds
		itemList.put("halberd.wood", 0);
		itemList.put("halberd.stone", 0);
		itemList.put("halberd.iron", 0);
		itemList.put("halberd.gold", 0);
		itemList.put("halberd.diamond", 0);

		// Knives
		itemList.put("knife.wood", 0);
		itemList.put("knife.stone", 0);
		itemList.put("knife.iron", 0);
		itemList.put("knife.gold", 0);
		itemList.put("knife.diamond", 0);

		// Battleaxes
		itemList.put("battleaxe.wood", 0);
		itemList.put("battleaxe.stone", 0);
		itemList.put("battleaxe.iron", 0);
		itemList.put("battleaxe.gold", 0);
		itemList.put("battleaxe.diamond", 0);

		// Warhammers
		itemList.put("warhammer.wood", 0);
		itemList.put("warhammer.stone", 0);
		itemList.put("warhammer.iron", 0);
		itemList.put("warhammer.gold", 0);
		itemList.put("warhammer.diamond", 0);

		// Flails
		itemList.put("flail.wood", 0);
		itemList.put("flail.stone", 0);
		itemList.put("flail.iron", 0);
		itemList.put("flail.gold", 0);
		itemList.put("flail.diamond", 0);

		// Katanas
		itemList.put("katana.wood", 0);
		itemList.put("katana.stone", 0);
		itemList.put("katana.iron", 0);
		itemList.put("katana.gold", 0);
		itemList.put("katana.diamond", 0);

		// Boomerangs
		itemList.put("boomerang.wood", 0);
		itemList.put("boomerang.stone", 0);
		itemList.put("boomerang.iron", 0);
		itemList.put("boomerang.gold", 0);
		itemList.put("boomerang.diamond", 0);

		// Fire rod, javelin, crossbow, blowgun, musket, dynamite, cannon, dummy, etc.
		itemList.put("firerod", 0);
		itemList.put("javelin", 0);
		itemList.put("crossbow", 0);
		itemList.put("bolt", 0);
		itemList.put("blowgun", 0);
		itemList.put("dart", 0);
		itemList.put("musket", 0);
		itemList.put("musket-ironpart", 0);
		itemList.put("musketbayonet.wood", 0);
		itemList.put("musketbayonet.stone", 0);
		itemList.put("musketbayonet.iron", 0);
		itemList.put("musketbayonet.gold", 0);
		itemList.put("musketbayonet.diamond", 0);
		itemList.put("bullet", 0);
		itemList.put("blunderbuss", 0);
		itemList.put("blunder-ironpart", 0);
		itemList.put("shot", 0);
		itemList.put("flintlock", 0);
		itemList.put("dynamite", 0);
		itemList.put("cannon", 0);
		itemList.put("cannonball", 0);
		itemList.put("dummy", 0);
		itemList.put("gun-stock", 0);


		List<Integer> idList = new ArrayList();

		int idItem = 7000;
		for(Map.Entry<String, Integer> item : itemList.entrySet()) {
			item.setValue(WMCommonProxy.config.get("id.items", item.getKey(), idItem).getInt());
			idList.add(idItem);
			idItem++;
			while(idList.contains(idItem)) {
				idItem++;
			}
		}

		WMCommonProxy.config.save();
	}
}
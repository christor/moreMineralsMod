package com.coolness.epicness;

import com.coolness.epicness.client.gui.GuiHandler;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Crafting;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.proxy.CommonProxy;
import com.coolness.epicness.tileenitity.TileEntityAtomBonder;
import com.coolness.epicness.tileenitity.TileEntityBomb;
import com.coolness.epicness.tileenitity.TileEntityIronFurnace;
import com.coolness.epicness.worldgen.CoolWorldGen;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
// EntityVillager EntityRegistry
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class MoreMineralsMod {
	public static DamageSource radiation_damage = new DamageSource("radiation").setDamageBypassesArmor()
			.setMagicDamage().setDifficultyScaled().setFireDamage();
	@Instance
	public static MoreMineralsMod instance;

	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.Init();
		BlockRegistry.init();
		BlockRegistry.register();
		BlockRegistry.registerRenders();
		ArmorRegistry.init();
		ArmorRegistry.register();
		ArmorRegistry.registerRenders();
		ItemRegistry.init();
		ItemRegistry.register();
		ItemRegistry.registerRenders();
		registerModelBakeryVariants();
		Elements.registerMineralComponents();
		MinecraftForge.EVENT_BUS.register(new VanillaBlockItemDrops());
		MinecraftForge.EVENT_BUS.register(new VanillaTooltipManager());
		Crafting.register();
		registerTileEntities();
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
		GameRegistry.registerWorldGenerator(new CoolWorldGen(), 0);
	}

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void PostInit(FMLInitializationEvent event) {
	}

	public void registerModelBakeryVariants() {
		ModelBakery.registerItemVariants(BlockRegistry.concrete_item,
				new ResourceLocation(Reference.MODID, "concrete_white"),
				new ResourceLocation(Reference.MODID, "concrete_orange"),
				new ResourceLocation(Reference.MODID, "concrete_magenta"),
				new ResourceLocation(Reference.MODID, "concrete_light_blue"),
				new ResourceLocation(Reference.MODID, "concrete_yellow"),
				new ResourceLocation(Reference.MODID, "concrete_lime"),
				new ResourceLocation(Reference.MODID, "concrete_pink"),
				new ResourceLocation(Reference.MODID, "concrete_gray"),
				new ResourceLocation(Reference.MODID, "concrete_light_gray"),
				new ResourceLocation(Reference.MODID, "concrete_cyan"),
				new ResourceLocation(Reference.MODID, "concrete_purple"),
				new ResourceLocation(Reference.MODID, "concrete_blue"),
				new ResourceLocation(Reference.MODID, "concrete_brown"),
				new ResourceLocation(Reference.MODID, "concrete_green"),
				new ResourceLocation(Reference.MODID, "concrete_red"),
				new ResourceLocation(Reference.MODID, "concrete_black"));
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityIronFurnace.class, Reference.MODID + ":iron_furnace");
		GameRegistry.registerTileEntity(TileEntityBomb.class, Reference.MODID + ":bomb");
		GameRegistry.registerTileEntity(TileEntityAtomBonder.class, Reference.MODID + ":atom_bonder");
	}

	public static CreativeTabs tabMineralsCombat = new CreativeTabs("tab_minerals_combat") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.copper_sword);
		}
	};
	public static CreativeTabs tabMineralsTools = new CreativeTabs("tab_minerals_tools") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.copper_axe);
		}
	};

}

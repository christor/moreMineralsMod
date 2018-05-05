package com.coolness.epicness;

import java.util.Random;

import com.coolness.epicness.client.gui.GuiHandler;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Crafting;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.proxy.CommonProxy;
import com.coolness.epicness.radiation.RadiationManager;
import com.coolness.epicness.radiation.RadiationWorldSavedData;
import com.coolness.epicness.radiation.TileEntityRadiationEmitter;
import com.coolness.epicness.radiation.TileEntityRadiationReceiver;
import com.coolness.epicness.tileenitity.TileEntityAtomBonder;
import com.coolness.epicness.tileenitity.TileEntityBomb;
import com.coolness.epicness.tileenitity.TileEntityRadiationSender;
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
	public static int[] atomColors = new int[Elements.elements.length];

	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;

	
	public static RadiationWorldSavedData radiationWorldSavedData;
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		registerAtomColors();
		proxy.Init();
		BlockRegistry.init();
		BlockRegistry.register();
		BlockRegistry.registerRenders();
		ArmorRegistry.init();
		ArmorRegistry.register();
		ArmorRegistry.registerRenders();
		ItemRegistry.init();
		ItemRegistry.register();
		ItemRegistry.registerItemColors();
		ItemRegistry.registerRenders();
		registerModelBakeryVariants();
		Elements.registerMineralComponents();
		Crafting.register();
		registerTileEntities();
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
		GameRegistry.registerWorldGenerator(new CoolWorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new Events());
		MinecraftForge.EVENT_BUS.register(new RadiationManager());
		CoolSoundHandler.init();
		// net.minecraftforge.fml.common.Loader.isModLoaded("");
	}

	public void registerAtomColors() {
		Random random = new Random();
		random.setSeed(0);
		int brightness = 50;
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		for (int i = 0; i < Elements.elements.length; i++) {
			// 16777215
			int color = random.nextInt(8162090) + (int) Math.pow(brightness, 3);
			atomColors[i] = color;
			System.out.println("Element " + (i + 1) + " (" + Elements.elements[i].unlocalizedName + ")" + ": " + color + " (#" + Integer.toHexString(color) + ")");
		}
		System.out.println("---------------------------------------");
		System.out.println("All atom colors have been registered!");
		System.out.println("No issues!!! :DD");
		System.out.println("---------------------------------------");
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
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
		GameRegistry.registerTileEntity(TileEntityRadiationReceiver.class, Reference.MODID + ":radiation_receiver");
		GameRegistry.registerTileEntity(TileEntityRadiationEmitter.class, Reference.MODID + ":radiation_emitter");
		GameRegistry.registerTileEntity(TileEntityBomb.class, Reference.MODID + ":bomb");
		GameRegistry.registerTileEntity(TileEntityAtomBonder.class, Reference.MODID + ":atom_bonder");
		GameRegistry.registerTileEntity(TileEntityRadiationSender.class, Reference.MODID + ":radiation_sender");
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

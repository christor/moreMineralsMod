package com.coolness.epicness.radiation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.coolness.epicness.Length;
import com.coolness.epicness.Unit;
import com.coolness.epicness.blocks.BlockRadiationReceiver;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RadiationManager {

	public static List<BlockPos> sources = new ArrayList<BlockPos>();
	public static List<BlockPos> receivers = new ArrayList<BlockPos>();

	public static HashMap<BlockPos, List<BlockPos>> sourceToReceiversMap = new HashMap<BlockPos, List<BlockPos>>();
	public static HashMap<BlockPos, List<BlockPos>> receiverToSourcesMap = new HashMap<BlockPos, List<BlockPos>>();

	@SubscribeEvent
	public void placeEvent(BlockEvent.PlaceEvent event) {
		IBlockState b = event.getState();
		System.out.println("Y u place blok?");
		if (event.getWorld().getTileEntity(event.getPos()) instanceof TileEntityRadiationEmitter) {
			System.out.println("Added source mommy aren't you proud?");
			addSource(event.getPos(), event.getWorld());
		} else if (event.getWorld().getTileEntity(event.getPos()) instanceof TileEntityRadiationReceiver) {
			System.out.println("dis block iz reseevr");
			addReceiver(event.getPos(), event.getWorld());
		} else {
			System.out.println("dis blok iz notin");
		}
	}

	@SubscribeEvent
	public void breakEvent(BlockEvent.BreakEvent event) {
		IBlockState b = event.getState();
		System.out.println("Brake blok");
		if (sources.contains(event.getPos())) {
			System.out.println("Block dat brake iz sorce");
			removeSource(event.getPos(), event.getWorld());
		} else if (receivers.contains(event.getPos())) {
			System.out.println("Block dat brake iz reseevr");
			removeReceiver(event.getPos(), event.getWorld());
		} else {
			System.out.println("dat block aint importnt");
		}
	}

	/**
	 * Adds a radiation source at the specific BlockPos. Used in placeEvent();
	 * 
	 * @param world
	 * 
	 **/
	public static void addSource(BlockPos pos, World world) {
		sources.add(pos);
		List<BlockPos> affectedReceivers = findAffectedReceivers(pos);

		// update mapping
		sourceToReceiversMap.put(pos, affectedReceivers);
		affectedReceivers.stream().forEach(r -> {
			List<BlockPos> values = receiverToSourcesMap.get(r);
			if (values == null) {
				values = new ArrayList<>();
				receiverToSourcesMap.put(r, values);
			}
			values.add(pos);
		});

		// put effect into receiver blocks
		// TODO
		if (world != null) {
			affectedReceivers.stream().forEach(r -> {
				System.out.println(
						"There is a receiver getting affected at: " + r.getX() + ", " + r.getY() + ", " + r.getZ());
				long wavelength = (long) getPowerAtReceiver(r);
				((TileEntityRadiationReceiver) world.getTileEntity(r)).setWavelength(wavelength);
				//if (wavelength > 0) {
					((BlockRadiationReceiver) world.getBlockState(r).getBlock()).radiationReceived(world, r, wavelength,
							wavelength);
				//}
				System.out.println("power: " + wavelength);
				// modify block data for block at position r
			});
		}
	}

	/**
	 * Adds a radiation receiver at the specific BlockPos. Used in placeEvent();
	 * 
	 * @param world
	 * 
	 **/
	public static void addReceiver(BlockPos receiver, World world) {
		receivers.add(receiver);
		List<BlockPos> affectingSources = findAffectingSources(receiver);

		// update mapping
		receiverToSourcesMap.put(receiver, affectingSources);
		affectingSources.stream().forEach(r -> {
			List<BlockPos> values = sourceToReceiversMap.get(r);
			if (values == null) {
				values = new ArrayList<>();
				sourceToReceiversMap.put(r, values);
			}
			values.add(receiver);
		});

		// put effect into receiver blocks
		// TODO
		if (world != null) {
			System.out.println("There is a receiver getting affected at: " + receiver.getX() + ", " + receiver.getY()
					+ ", " + receiver.getZ());
			long wavelength = (long) getPowerAtReceiver(receiver);
			((TileEntityRadiationReceiver) world.getTileEntity(receiver))
					.setWavelength(wavelength);

			if (wavelength > 0) {
				((BlockRadiationReceiver) world.getBlockState(receiver).getBlock()).radiationReceived(world, receiver,
						wavelength, wavelength);
			}
			System.out.println("power: " + wavelength);
			// modify block data for block at position r
		}
	}

	/**
	 * Removes a radiation source at the specific BlockPos. Used in
	 * breakEvent();
	 * 
	 * @param world
	 * 
	 **/
	public static void removeSource(BlockPos pos, World world) {
		sources.remove(pos);

		List<BlockPos> affectedReceivers = sourceToReceiversMap.get(pos);

		// update mapping
		sourceToReceiversMap.remove(pos);
		affectedReceivers.stream().forEach(r -> {
			List<BlockPos> values = receiverToSourcesMap.get(r);
			if (values != null) {
				values.remove(pos);
			}
		});

		// put effect into receiver blocks
		// TODO
		affectedReceivers.stream().forEach(r -> {
			// System.out.println(
			// "There is a receiver getting affected at: " + r.getX() + ", " +
			// r.getY() + ", " + r.getZ());
			// double power = getPowerAtReceiver(r);
			// System.out.println("power: " + power);
			// modify block data for block at position r

			System.out.println(
					"There is a receiver getting affected at: " + r.getX() + ", " + r.getY() + ", " + r.getZ());
			long wavelength = (long) getPowerAtReceiver(r);
			((TileEntityRadiationReceiver) world.getTileEntity(r))
					.setWavelength(wavelength);

			// if (wavelength > 0) {
			((BlockRadiationReceiver) world.getBlockState(r).getBlock()).radiationReceived(world, r, wavelength,
					wavelength);
			// }
			System.out.println("power: " + wavelength);
			// modify block data for block at position r

		});
	}

	/**
	 * Removes a radiation receiver at the specific BlockPos. Used in
	 * breakEvent();
	 * 
	 * @param world
	 * 
	 **/
	public static void removeReceiver(BlockPos receiver, World world) {
		receivers.remove(receiver);

		List<BlockPos> affectingSources = receiverToSourcesMap.get(receiver);

		// update mapping
		receiverToSourcesMap.remove(receiver);
		affectingSources.stream().forEach(r -> {
			List<BlockPos> values = sourceToReceiversMap.get(r);
			if (values != null) {
				values.remove(receiver);
			}
		});
	}

	/**
	 * @return a List of BlockPos (Sources) that are affecting the specified
	 *         receiver.
	 */
	private static List<BlockPos> findAffectingSources(BlockPos receiver) {
		return sources.stream().filter(r -> {
			double power = calculatePower(receiver, r);
			return (power > 5);
		}).collect(Collectors.toList());
	}

	/**
	 * @return a List of BlockPos (Receivers) that are affected by the specified
	 *         source.
	 */
	private static List<BlockPos> findAffectedReceivers(BlockPos pos) {
		return receivers.stream().filter(r -> {
			double power = calculatePower(pos, r);
			return (power > 5);
		}).collect(Collectors.toList());
	}

	/**
	 * Calculates the amount of radiation the receiver should have, given ONLY
	 * the specified source. Don't use when trying to calculate the radiation at
	 * the block, instead use getPowerAtReceiver(BlockPos receiver);
	 */
	private static double calculatePower(BlockPos source, BlockPos receiver) {
		double distance = source.getDistance(receiver.getX(), receiver.getY(), receiver.getZ());
		double sourcePower = 100; // TODO: GET FROM SOURCE BLOCK
		double power = (sourcePower * 10) / (distance * distance);
		return power;
	}

	/**
	 * Gets the amount of radiation level this specific receiver should have.
	 * Block MUST be a receiver.
	 */
	private static double getPowerAtReceiver(BlockPos receiver) {
		return receiverToSourcesMap.get(receiver).stream().map(source -> calculatePower(receiver, source)).reduce(0.0,
				(a, b) -> a + b);
	}

	public static void readFromNBT(NBTTagCompound nbt) {
		if(nbt == null)
			return;
		
		NBTTagCompound emittersTag = nbt.getCompoundTag("Emmiters");
		for (int i = 0 ; emittersTag.hasKey(String.valueOf(i)) ; i++) {
			NBTTagCompound emitterTag = emittersTag.getCompoundTag(String.valueOf(i));
			BlockPos emitterPosition = BlockPos.fromLong(emitterTag.getLong("Pos"));
			addSource(emitterPosition, null);
		}
		NBTTagCompound receiversTag = nbt.getCompoundTag("Receivers");
		for (int i = 0 ; receiversTag.hasKey(String.valueOf(i)) ; i++) {
			NBTTagCompound receiverTag = receiversTag.getCompoundTag(String.valueOf(i));
			BlockPos receiverPosition = BlockPos.fromLong(receiverTag.getLong("Pos"));
			addSource(receiverPosition, null);
		}
	}

	public static NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		NBTTagCompound emittersTag = new NBTTagCompound();
		for (int i = 0; i < sources.size(); i++) {
			BlockPos s = sources.get(i);
			NBTTagCompound subTag = new NBTTagCompound();
			subTag.setLong("Pos", s.toLong());
			emittersTag.setTag(String.valueOf(i), subTag);
		}
		nbt.setTag("Emitters", emittersTag);
		NBTTagCompound receiversTag = new NBTTagCompound();
		for (int i = 0; i < receivers.size(); i++) {
			BlockPos s = receivers.get(i);
			NBTTagCompound subTag = new NBTTagCompound();
			subTag.setLong("Pos", s.toLong());
			receiversTag.setTag(String.valueOf(i), subTag);
		}
		nbt.setTag("Receivers", receiversTag);
		return nbt;
	}
}

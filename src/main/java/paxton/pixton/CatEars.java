package paxton.pixton;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.Event;

import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.phys.Vec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mojang.brigadier.Command;
import com.mojang.math.Axis;

import net.minecraft.server.players.PlayerList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import java.util.Random;

import java.util.List;

public class CatEars implements ModInitializer {
	public static final String MOD_ID = "pixton";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading CatEar Resources...");
		Items.initialize();
		Blocks.initialize();
		BlockEntities.initialize();
		MenuTypes.initialize();
		Songs.initialize();
		Save.initialize();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("test").executes(context -> {
				context.getSource().sendSuccess(() -> Component.literal("test successful"), false);
				return 1;
			}));
		});

		Command<CommandSourceStack> command = context -> {
				final ServerPlayer player = context.getSource().getPlayer();
				final String gotIt = player.getAttached(Save.isFurry);
				LOGGER.info(gotIt);
				if (gotIt.equals("white")) {
					player.setItemSlot(EquipmentSlot.HEAD, Items.CAT_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.CAT_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("You became a Cat again"), false);
				} else if (gotIt.equals("black")) {
					player.setItemSlot(EquipmentSlot.HEAD, Items.BLACK_CAT_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.BLACK_CAT_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("You became a Cat again"), false);
				} else if (gotIt.equals("fox")) {
					player.setItemSlot(EquipmentSlot.HEAD, Items.FOP_EARS.getDefaultInstance());
					player.setItemSlot(EquipmentSlot.LEGS, Items.FOP_TAIL.getDefaultInstance());
					context.getSource().sendSuccess(() -> Component.literal("You became a Fox again"), false);
				} else {
					context.getSource().sendSuccess(() -> Component.literal("Find an Orb you dingus"), false);
				}
				return 0;
		};

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(Commands.literal("become").executes(command));
		});

		ItemComponentTooltipProviderRegistry.addAfter(DataComponents.DAMAGE, Components.TOOLTIP);

		FabricPotionBrewingBuilder.BUILD.register(builder -> {
			builder.addMix(
			// Input potion.
			Potions.WATER,
			// Ingredient
			Items.BABY,
			// Output potion.
			Items.BECOME_POTION
			);
		});

		ServerTickEvents.START_SERVER_TICK.register((server) -> {
			PlayerList yeah = server.getPlayerList();

			List<ServerPlayer> players = yeah.getPlayers();

			for (int i = 0; i < players.size(); i++) {
  				ServerPlayer player = players.get(i);

				if (player.getKnownMovement().equals(Vec3.ZERO) == false && TrinketShit.hasEquipped(player, (x) -> x.is(Items.BELL_COLLAR))) {
					ServerLevel level = player.level();
					double playerx = player.getKnownMovement().x;
					double playery = Math.abs(player.getKnownMovement().y);
					double playerz = player.getKnownMovement().z;
					Double addedx = player.getAttachedOrCreate(Save.addedx);
					player.setAttached(Save.addedx, Math.abs(playerx) + addedx);
					Double addedz = player.getAttachedOrCreate(Save.addedz);
					player.setAttached(Save.addedz, Math.abs(playerz) + addedz);
					boolean freezey = player.getAttachedOrCreate(Save.freezey);
					if (addedx >= 1.0) {
						level.playSound(null, player.blockPosition(), SoundEvents.BELL_BLOCK, player.getSoundSource());
						player.setAttached(Save.addedx, 0.0);
					}
					if (addedz >= 1.0) {
						level.playSound(null, player.blockPosition(), SoundEvents.BELL_BLOCK, player.getSoundSource());
						player.setAttached(Save.addedz, 0.0);
					}
					if (playery > 0.0 && freezey == false) {
						level.playSound(null, player.blockPosition(), SoundEvents.BELL_BLOCK, player.getSoundSource());
						player.setAttached(Save.freezey, true);
					}
					if (playery == 0.0 && freezey == true) {
						level.playSound(null, player.blockPosition(), SoundEvents.BELL_BLOCK, player.getSoundSource());
						player.setAttached(Save.freezey, false);
					}
				}
			}
		});
		
		LOGGER.info("Loaded, enjoy your cat ears :3");
	};

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

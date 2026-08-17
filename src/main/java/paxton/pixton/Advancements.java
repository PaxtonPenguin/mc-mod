package paxton.pixton;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import java.util.function.Consumer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class Advancements extends FabricAdvancementProvider {
    protected Advancements(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, registryLookup);
	}

	@Override
	public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder eatOrb = Advancement.Builder.advancement()
		.display(
				Items.CAT_EARS, // The display icon
				Component.literal("meow :3"), // The title
				Component.literal("you're now a furry"), // The description
				Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
				AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
				true, // Show the toast when completing it
				true, // Announce it to chat
				true // Hide it in the advancement tab until it's achieved
		)
		// "got_dirt" is the name referenced by other advancements when they want to have "requirements."
		.addCriterion("eatorb", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CAT_EARS))
		// Give the advancement an id
		.save(consumer, Identifier.fromNamespaceAndPath("cat-ears", "eatorb"));
		AdvancementHolder eatDarkOrb = Advancement.Builder.advancement()
		.display(
				Items.BLACK_CAT_EARS, // The display icon
				Component.literal("mrrp :3"), // The title
				Component.literal("you're now a furry"), // The description
				Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
				AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
				true, // Show the toast when completing it
				true, // Announce it to chat
				true // Hide it in the advancement tab until it's achieved
		)
		// "got_dirt" is the name referenced by other advancements when they want to have "requirements."
		.addCriterion("eatorb", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACK_CAT_EARS))
		// Give the advancement an id
		.save(consumer, Identifier.fromNamespaceAndPath("cat-ears", "eatblackorb"));
		AdvancementHolder eatFopOrb = Advancement.Builder.advancement()
		.display(
				Items.FOP_EARS, // The display icon
				Component.literal("*insert fox noise*"), // The title
				Component.literal("you're now a furry"), // The description
				Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
				AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
				true, // Show the toast when completing it
				true, // Announce it to chat
				true // Hide it in the advancement tab until it's achieved
		)
		// "got_dirt" is the name referenced by other advancements when they want to have "requirements."
		.addCriterion("eatorb", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FOP_EARS))
		// Give the advancement an id
		.save(consumer, Identifier.fromNamespaceAndPath("cat-ears", "eatfoporb"));
	}
}

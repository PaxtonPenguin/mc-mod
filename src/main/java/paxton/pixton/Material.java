package paxton.pixton;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import java.util.Map;

public class Material {
    public static final int BASE_DURABILITY = 9999;

    public static final ResourceKey<EquipmentAsset> FUZZY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "fuzzy"));

    public static final TagKey<Item> REPAIRS_FUZZY = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "repairs_guidite_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
		BASE_DURABILITY,
		Map.of(
				ArmorType.HELMET, 3
		),
		5,
		SoundEvents.ARMOR_EQUIP_IRON,
		0.0F,
		0.0F,
		REPAIRS_FUZZY,
		FUZZY
);
}
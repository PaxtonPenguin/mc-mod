package paxton.pixton;

import eu.pb4.trinkets.api.DefaultTrinketSlots;
import eu.pb4.trinkets.api.component.TrinketDataComponents;
import eu.pb4.trinkets.api.component.TrinketEquippable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.util.Unit;

public class CollarItem extends Item{
    public CollarItem() {
        super(new Item.Properties().stacksTo(1).setId(ItemIds.COLLAR)
                .component(TrinketDataComponents.EQUIPMENT, TrinketEquippable.DEFAULT
                        .withSlots(DefaultTrinketSlots.CHEST_NECKLACE)
                        .withEquipOnInteract(true))
                .component(Components.TOOLTIP, new Tooltip("what"))
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    }
}

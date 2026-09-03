package paxton.pixton;

import eu.pb4.trinkets.api.DefaultTrinketSlots;
import eu.pb4.trinkets.api.component.TrinketDataComponents;
import eu.pb4.trinkets.api.component.TrinketEquippable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.util.Unit;

public class FopTailItem extends Item{
    public FopTailItem() {
        super(new Item.Properties().stacksTo(1).setId(ItemIds.FOP_TAIL)
                .component(TrinketDataComponents.EQUIPMENT, TrinketEquippable.DEFAULT
                        .withSlots(DefaultTrinketSlots.LEGS_BELT)
                        .withEquipOnInteract(true))
                .component(Components.TOOLTIP, new Tooltip("fun fact: you need ears to make noises"))
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    }
}

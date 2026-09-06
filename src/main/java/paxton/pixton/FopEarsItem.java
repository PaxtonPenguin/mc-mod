package paxton.pixton;

import eu.pb4.trinkets.api.DefaultTrinketSlots;
import eu.pb4.trinkets.api.component.TrinketDataComponents;
import eu.pb4.trinkets.api.component.TrinketEquippable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.util.Unit;

public class FopEarsItem extends Item{
    public FopEarsItem() {
        super(new Item.Properties().stacksTo(1).setId(ItemIds.FOP_EARS)
                .component(TrinketDataComponents.EQUIPMENT, TrinketEquippable.DEFAULT
                        .withSlots(DefaultTrinketSlots.HEAD_HAT)
                        .withEquipOnInteract(true))
                .component(Components.TOOLTIP, new Tooltip("fun fact: you can bind animal noises"))
                .component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    }
}

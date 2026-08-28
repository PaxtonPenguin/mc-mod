package paxton.pixton;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;

import eu.pb4.trinkets.api.SlotAttributes;
import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.callback.*;
import eu.pb4.trinkets.api.client.TrinketRenderer;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.client.model.*;

import paxton.pixton.models.*;

public class cat_ears extends Item implements TrinketRenderer, TrinketCallback {
		private final Holder<Attribute> hatSlotModifier;
		private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "textures/entity/trinket/cat_ears.png");
	private HumanoidModel<HumanoidRenderState> model;


	HeadedModel chaz;
    	public cat_ears(Properties properties) {
        	super(properties);
			this.hatSlotModifier = SlotAttributes.createAttributeForSlot("head/hat");
    	}

		@Override
	@Environment(EnvType.CLIENT)
	public void submit(ItemStack stack, TrinketSlotAccess slotReference, EntityModel<? extends LivingEntityRenderState> contextModel, PoseStack matrices, SubmitNodeCollector submit, int light, LivingEntityRenderState state, float limbAngle, float limbDistance) {
		if (state instanceof HumanoidRenderState bipedEntityRenderState) {
			HumanoidModel<HumanoidRenderState> model = this.getModel();
			model.setupAnim(bipedEntityRenderState);
			TrinketRenderer.followBodyRotations(contextModel, model);
			submit.submitModel(model, bipedEntityRenderState, matrices, model.renderType(TEXTURE), light, OverlayTexture.pack(OverlayTexture.u(0), OverlayTexture.v(false)), -1, null, state.outlineColor, null);
		}
	}

	@Environment(EnvType.CLIENT)
	private HumanoidModel<HumanoidRenderState> getModel() {
		if (this.model == null) {
			// Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
			this.model = new ears(ears.createBodyLayer().bakeRoot());
		}

		return this.model;
	}

	}
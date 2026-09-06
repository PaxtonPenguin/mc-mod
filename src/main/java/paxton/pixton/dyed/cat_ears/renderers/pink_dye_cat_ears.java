package paxton.pixton.dyed.cat_ears.renderers;

import net.minecraft.world.item.ItemStack;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;

import eu.pb4.trinkets.api.TrinketSlotAccess;
import eu.pb4.trinkets.api.callback.*;
import eu.pb4.trinkets.api.client.TrinketRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.client.model.*;

import paxton.pixton.models.*;
import paxton.pixton.CatEars;

public class pink_dye_cat_ears implements TrinketRenderer, TrinketCallback {
		private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(CatEars.MOD_ID, "textures/entity/trinket/pink_dyed_cat_ears.png");
	private EntityModel<EntityRenderState> model;

		@Override
	@Environment(EnvType.CLIENT)
	public void submit(ItemStack stack, TrinketSlotAccess slotReference, EntityModel<? extends LivingEntityRenderState> contextModel, PoseStack matrices, SubmitNodeCollector submit, int light, LivingEntityRenderState state, float limbAngle, float limbDistance) {
		if (state instanceof EntityRenderState bipedEntityRenderState) {
			EntityModel<EntityRenderState> model = this.getModel();
			model.setupAnim(bipedEntityRenderState);
			if (contextModel instanceof HeadedModel head) {
				TrinketRenderer.translateToHead(matrices, head);
			}
			submit.submitModel(model, bipedEntityRenderState, matrices, model.renderType(TEXTURE), light, OverlayTexture.pack(OverlayTexture.u(0), OverlayTexture.v(false)), -1, null, state.outlineColor, null);
		}
	}

	@Environment(EnvType.CLIENT)
	private EntityModel<EntityRenderState> getModel() {
		if (this.model == null) {
			// Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
			this.model = new ears(ears.createBodyLayer().bakeRoot());
		}

		return this.model;
	}

	}
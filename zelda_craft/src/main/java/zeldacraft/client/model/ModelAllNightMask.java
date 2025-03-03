package zeldacraft.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelAllNightMask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_all_night_mask"), "main");
	public final ModelPart Mask;

	public ModelAllNightMask(ModelPart root) {
		this.Mask = root.getChild("Mask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Mask = partdefinition.addOrReplaceChild("Mask", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.975F, -4.025F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Mask.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(4, 10).addBox(0.0F, -3.7F, -1.0F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.024F, -3.975F, -3.025F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r2 = Mask.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 10).mirror().addBox(0.0F, -3.7F, -1.0F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.024F, -3.975F, -3.025F, 0.0F, -3.1416F, 0.0F));
		PartDefinition cube_r3 = Mask.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-2, 8).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.025F, -3.0F, 0.0F, 3.1416F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Mask.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Mask.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Mask.xRot = headPitch / (180F / (float) Math.PI);
	}
}

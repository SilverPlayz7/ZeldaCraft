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

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelShockArrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_shock_arrow"), "main");
	public final ModelPart arrow;

	public ModelShockArrow(ModelPart root) {
		this.arrow = root.getChild("arrow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition arrow = partdefinition.addOrReplaceChild("arrow", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4072F, 7.5927F, 0.1032F, 0.0F, 1.5708F, 1.5708F));
		PartDefinition cube_r1 = arrow.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.2907F, 0.9978F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1178F, 0.432F, -5.8532F, 1.5708F, 0.7854F, 3.1416F));
		PartDefinition cube_r2 = arrow.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 0).addBox(-0.7093F, 0.9978F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1178F, 0.432F, -5.8532F, 1.5708F, -0.7854F, -3.1416F));
		PartDefinition cube_r3 = arrow.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(10, 0).addBox(0.2364F, -5.4086F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1178F, 0.432F, -5.8532F, 1.5708F, -0.2618F, -3.1416F));
		PartDefinition cube_r4 = arrow.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-4.2364F, -5.4086F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.1178F, 0.432F, -5.8532F, 1.5708F, 0.2618F, -3.1416F));
		PartDefinition cube_r5 = arrow.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(5, 8).addBox(-2.5F, -4.5F, -2.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 3.0718F, -1.5708F, 0.0F, -0.7854F));
		PartDefinition cube_r6 = arrow.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-13, 0).addBox(-2.5F, 0.0F, -6.5F, 5.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 2.0718F, 3.1416F, 0.0F, -2.3562F));
		PartDefinition cube_r7 = arrow.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-13, 0).addBox(-2.5F, 0.0F, -6.5F, 5.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 2.0718F, 3.1416F, 0.0F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		arrow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}

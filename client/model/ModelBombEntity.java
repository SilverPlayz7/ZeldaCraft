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
public class ModelBombEntity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_bomb_entity"), "main");
	public final ModelPart Shell;

	public ModelBombEntity(ModelPart root) {
		this.Shell = root.getChild("Shell");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Shell = partdefinition.addOrReplaceChild("Shell",
				CubeListBuilder.create().texOffs(0, 17).addBox(-1.25F, -3.25F, -1.25F, 2.5F, 2.0F, 2.5F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.5F, -1.25F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 18.25F, 0.0F));
		PartDefinition fuse = Shell.addOrReplaceChild("fuse",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(3, 4).addBox(1.5137F, -6.0137F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -1.25F, 0.0F));
		PartDefinition cube_r1 = fuse.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.4375F, -4.9239F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r2 = fuse.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 2).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7843F, -5.3604F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r3 = fuse.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 5).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2431F, -5.3604F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r4 = fuse.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(6, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5898F, -4.9239F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r5 = fuse.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1533F, -4.2706F, 0.0F, 0.0F, 0.0F, 0.3927F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}

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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBunnyHood<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_bunny_hood"), "main");
	public final ModelPart bipedHead;

	public ModelBunnyHood(ModelPart root) {
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = bipedHead.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-2.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0189F, -11.2983F, -1.9892F, 0.4349F, 0.0227F, -0.2162F));
		PartDefinition cube_r2 = bipedHead.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 8).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.35F, -8.2F, -1.45F, 0.1731F, 0.0227F, -0.2162F));
		PartDefinition cube_r3 = bipedHead.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 8).addBox(-1.3916F, -2.7829F, -0.3301F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.6666F, -8.1641F, -2.2449F, 0.1468F, 0.1128F, 0.2615F));
		PartDefinition cube_r4 = bipedHead.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(6, 3).addBox(0.0F, -4.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0957F, -11.2682F, -1.8343F, 0.5439F, 0.0989F, 0.3031F));
		PartDefinition cube_r5 = bipedHead.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -1.2683F, -1.0038F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(0.4F, -1.2683F, -1.0038F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.45F, -7.0595F, -2.2862F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r6 = bipedHead.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.1F, -8.3139F, -1.3272F, 0.0467F, 0.0263F, 0.0018F));
		PartDefinition cube_r7 = bipedHead.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1F, -8.3139F, -1.3272F, 0.0467F, -0.0263F, -0.0018F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bipedHead.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bipedHead.xRot = headPitch / (180F / (float) Math.PI);
	}
}

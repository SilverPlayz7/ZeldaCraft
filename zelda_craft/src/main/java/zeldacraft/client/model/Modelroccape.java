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

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelroccape<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "modelroccape"), "main");
	public final ModelPart cape;

	public Modelroccape(ModelPart root) {
		this.cape = root.getChild("cape");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition cape = partdefinition.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(14, 0).addBox(-0.5F, 0.2F, -2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = cape.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.4945F, -0.7247F, 2.1206F, 0.0379F, -0.1327F, 0.044F));
		PartDefinition cube_r2 = cape.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 19).addBox(-5.0F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7445F, -0.7247F, 2.1206F, 0.0379F, 0.1327F, -0.044F));
		PartDefinition cube_r3 = cape.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -1.0F, 6.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5663F, -0.1413F, 2.9197F, 0.4742F, -0.3062F, -0.3194F));
		PartDefinition cube_r4 = cape.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 0).addBox(-1.0F, -1.0F, -1.0F, 6.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.337F, -0.0835F, 2.8966F, 0.4754F, 0.3112F, 0.3222F));
		return LayerDefinition.create(meshdefinition, 40, 26);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cape.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}

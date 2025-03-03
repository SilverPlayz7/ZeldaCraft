package zeldacraft.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
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

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBootsofTwilight<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_bootsof_twilight"), "main");
	public final ModelPart Left;
	public final ModelPart Right;

	public ModelBootsofTwilight(ModelPart root) {
		this.Left = root.getChild("Left");
		this.Right = root.getChild("Right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Left = partdefinition.addOrReplaceChild("Left",
				CubeListBuilder.create().texOffs(42, 56).addBox(-1.75F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(48, 56).addBox(-2.1F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(52, 49)
						.addBox(-2.2F, 4.25F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(46, 49).addBox(-1.7F, 4.25F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(49, 52)
						.addBox(-1.5F, 4.0F, -2.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.05F, 6.156F, -2.3112F, 4.0F, 5.75F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.2F, 6.156F, -2.3112F, 1.0F, 5.75F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.8F, 6.156F, 1.1388F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.05F, 6.156F, 1.1388F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition bone = Left.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.7F, 0.4557F, 1.8045F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.45F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 9.5F, -4.75F, 0.3927F, 0.0F, 0.0F));
		PartDefinition bone2 = Left.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.2F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.95F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition bone3 = Left.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.7F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(1.45F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bone4 = Left.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.8F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-7.05F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 12.0F, -0.25F));
		PartDefinition Right = partdefinition.addOrReplaceChild("Right",
				CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.15F, 4.906F, -2.3112F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(42, 56).mirror()
						.addBox(-2.2F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 56).mirror().addBox(1.15F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 49).mirror()
						.addBox(-2.25F, 4.25F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 49).mirror().addBox(1.25F, 4.25F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(-1.9F, 4.906F, -2.3112F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(1.1F, 4.906F, 1.1388F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(-2.15F, 4.906F, 1.1388F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(49, 52).mirror().addBox(-1.5F, 4.0F, -2.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition bone5 = Right.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.4F, 0.4557F, 1.8045F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.65F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 9.5F, -4.75F, 0.3927F, 0.0F, 0.0F));
		PartDefinition bone6 = Right.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.9F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.15F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition bone7 = Right.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.4F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.65F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bone8 = Right.addOrReplaceChild("bone8",
				CubeListBuilder.create().texOffs(0, 0).addBox(-10.9F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-11.15F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(9.0F, 12.0F, -0.25F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Left.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Right.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}

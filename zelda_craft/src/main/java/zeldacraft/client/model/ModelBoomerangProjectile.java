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
public class ModelBoomerangProjectile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("zelda_craft", "model_boomerang_projectile"), "main");
	public final ModelPart Boomerang2;
	public final ModelPart THeRest2;
	public final ModelPart GoldTHing2;
	public final ModelPart Gem2;

	public ModelBoomerangProjectile(ModelPart root) {
		this.Boomerang2 = root.getChild("Boomerang2");
		this.THeRest2 = this.Boomerang2.getChild("THeRest2");
		this.GoldTHing2 = this.Boomerang2.getChild("GoldTHing2");
		this.Gem2 = this.Boomerang2.getChild("Gem2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Boomerang2 = partdefinition.addOrReplaceChild("Boomerang2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.75F, 0.0F, 0.0F, 1.5708F, 1.5708F));
		PartDefinition THeRest2 = Boomerang2.addOrReplaceChild("THeRest2", CubeListBuilder.create().texOffs(42, 40).addBox(-17.5537F, -3.2695F, 6.0526F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(42, 40).mirror()
				.addBox(15.5537F, -3.2695F, 6.0526F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.9193F, 0.1441F));
		PartDefinition cube_r1 = THeRest2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-0.1459F, 0.0637F, -2.9146F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -2.5732F, -1.3807F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r2 = THeRest2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.2953F, 0.1212F, -6.9375F, 19.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -2.6482F, -0.9209F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r3 = THeRest2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 44).mirror().addBox(-1.0F, -0.9F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(15.5537F, -2.3445F, 9.6384F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r4 = THeRest2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 44).addBox(-1.0F, -0.9F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.5537F, -2.3445F, 9.6384F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r5 = THeRest2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 40).addBox(-9.8541F, 0.0637F, -2.9146F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.5732F, -1.3807F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r6 = THeRest2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-17.7047F, 0.1212F, -6.9375F, 19.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.6482F, -0.9209F, 0.0F, 0.7854F, 0.0F));
		PartDefinition GoldTHing2 = Boomerang2.addOrReplaceChild("GoldTHing2",
				CubeListBuilder.create().texOffs(36, 5).addBox(-2.4582F, -3.208F, -9.6001F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(44, 35).addBox(-1.4581F, -3.208F, -3.6003F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.9193F, 0.1441F));
		PartDefinition cube_r7 = GoldTHing2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(26, 40).addBox(6.7988F, -0.975F, -8.0417F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2376F, 0.1986F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r8 = GoldTHing2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 44).addBox(-6.8F, -0.025F, 0.075F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.0226F, -3.2103F, -12.3282F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r9 = GoldTHing2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5192F, -0.9704F, -8.9104F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2376F, 0.1986F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r10 = GoldTHing2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 17).addBox(-1.4807F, -0.9727F, -8.9104F, 2.0F, 1.9999F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2376F, 0.1986F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r11 = GoldTHing2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(50, 0).addBox(-0.2F, -1.0F, -0.65F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1138F, -2.2057F, -11.799F, 0.0F, -2.3562F, 0.0F));
		PartDefinition cube_r12 = GoldTHing2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(46, 0).addBox(-1.3349F, -0.9681F, 0.4398F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1F, -2.2126F, 0.3987F, 0.0F, 0.7854F, 0.0F));
		PartDefinition Gem2 = Boomerang2.addOrReplaceChild("Gem2", CubeListBuilder.create().texOffs(0, 5).addBox(-3.6753F, -3.4626F, -10.6173F, 7.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.9193F, 0.1441F));
		PartDefinition cube_r13 = Gem2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(22, 29).addBox(-0.0736F, -1.2747F, -8.6808F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2376F, 0.1986F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r14 = Gem2.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(46, 3).addBox(-1.05F, 0.025F, -5.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 29).addBox(-1.0F, -0.025F, -5.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1779F, -3.5123F, -7.4668F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r15 = Gem2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0264F, -1.2745F, -8.6808F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2376F, 0.1986F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r16 = Gem2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(36, 14).addBox(2.491F, -1.2747F, -8.3745F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2376F, 0.1986F, 0.0F, 0.7854F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Boomerang2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Boomerang2.yRot = ageInTicks;
	}
}
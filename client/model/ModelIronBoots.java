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

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelIronBoots<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_iron_boots"), "main");
	public final ModelPart Left;
	public final ModelPart Right;

	public ModelIronBoots(ModelPart root) {
		this.Left = root.getChild("Left");
		this.Right = root.getChild("Right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Left = partdefinition.addOrReplaceChild("Left",
				CubeListBuilder.create().texOffs(42, 48).addBox(-1.75F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(48, 48).addBox(-2.1F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(52, 57)
						.addBox(-2.2F, 6.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(46, 57).addBox(-1.7F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.05F, 7.906F, -2.3112F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(1.2F, 7.906F, -2.3112F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.8F, 7.156F, 1.1388F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.05F, 7.156F, 1.1388F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition bone = Left.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.7F, 0.4557F, 1.8045F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.45F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 9.5F, -4.75F, 0.3927F, 0.0F, 0.0F));
		PartDefinition bone2 = Left.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.2F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(3, 48).addBox(4.4F, 0.8762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(3, 48)
						.addBox(4.4F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.95F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(3, 48)
						.addBox(0.75F, 0.8762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(3, 49).addBox(0.75F, 1.1262F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-0.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.9244F, 1.9329F, 0.2393F, 0.1309F, 0.6545F, 0.0F));
		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 48).addBox(-1.5F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.2256F, 1.9329F, 0.2393F, 0.1309F, -0.6545F, 0.0F));
		PartDefinition bone3 = Left.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.7F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(1.45F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(2.9848F, -0.5F, -1.3486F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.841F, 1.7671F, 1.4887F, -0.0876F, -0.0869F, 0.0076F));
		PartDefinition cube_r4 = bone3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(3, 48).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.991F, 1.7671F, 1.4887F, -0.0876F, 0.0869F, -0.0076F));
		PartDefinition bone4 = Left.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.8F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(2, 49).mirror().addBox(-7.4243F, -1.3544F, -2.0003F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(2, 49).addBox(-3.4257F, -1.3544F, -2.0003F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-7.05F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 12.0F, -0.25F));
		PartDefinition cube_r5 = bone4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-0.425F, -0.5F, -0.55F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.1832F, -1.1804F, -3.6249F, -2.2751F, -1.1343F, 2.0924F));
		PartDefinition cube_r6 = bone4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(7, 52).addBox(-0.575F, -0.5F, -0.55F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.6168F, -1.1804F, -3.6249F, -2.2751F, 1.1343F, -2.0924F));
		PartDefinition cube_r7 = bone4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(7, 52).addBox(-0.5F, -0.35F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.9168F, -1.3668F, -3.683F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r8 = bone4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(7, 52).addBox(-1.9F, -1.9F, -0.35F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.554F, -0.8987F, 1.9919F, 0.0381F, -0.1704F, 1.3494F));
		PartDefinition cube_r9 = bone4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(0.2F, -1.2F, -0.35F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.0444F, -0.7595F, 2.0165F, 0.0381F, 0.1704F, -1.3494F));
		PartDefinition cube_r10 = bone4.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(9, 52).addBox(-0.1F, -0.3F, -0.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 52).addBox(0.4F, -0.3F, -0.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0757F, -0.8544F, 1.9997F, 0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r11 = bone4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(7, 52).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.9507F, -1.4021F, 2.1118F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r12 = bone4.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(7, 52).addBox(2.5F, -0.5F, -0.35F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 52).mirror().addBox(-0.4986F, -0.5F, -0.35F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.9257F, -0.8544F, 1.9997F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r13 = bone4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(6, 51).mirror().addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.341F, -0.8544F, -2.9093F, 0.0F, -0.0873F, 0.0F));
		PartDefinition cube_r14 = bone4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(6, 51).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.509F, -0.8544F, -2.9093F, 0.0F, 0.0873F, 0.0F));
		PartDefinition Right = partdefinition.addOrReplaceChild("Right",
				CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.15F, 7.906F, -2.3112F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 57).mirror()
						.addBox(-2.25F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 57).mirror().addBox(-1.75F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(-1.9F, 7.906F, -2.3112F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(1.1F, 7.906F, 1.1388F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(-2.15F, 7.906F, 1.1388F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 48).mirror().addBox(1.1F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(42, 48)
						.mirror().addBox(-2.25F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
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
		PartDefinition bone9 = Right.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r15 = bone9.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(6, 51).mirror().addBox(-2.6061F, -0.1102F, -3.1114F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.0F, -0.0873F, 0.0F));
		PartDefinition bone10 = Right.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r16 = bone10.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(7, 52).addBox(2.2394F, 0.6734F, -0.4387F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, -2.2751F, 1.1343F, -2.0924F));
		PartDefinition bone11 = Right.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r17 = bone11.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-0.5082F, 0.6913F, -3.2093F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, -0.3927F, 0.0F, 0.0F));
		PartDefinition bone12 = Right.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r18 = bone12.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(6, 51).addBox(0.6061F, -0.1102F, -3.1114F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.0F, 0.0873F, 0.0F));
		PartDefinition bone13 = Right.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r19 = bone13.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-3.2288F, 0.6625F, -0.3911F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, -2.2751F, -1.1343F, 2.0924F));
		PartDefinition bone14 = Right.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r20 = bone14.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(3, 48).addBox(0.5778F, 0.4384F, -2.7876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.575F, 0.9995F, 3.4815F, -0.0876F, 0.0869F, -0.0076F));
		PartDefinition bone15 = Right.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r21 = bone15.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(3, 48).addBox(-1.2158F, -2.7986F, -1.7961F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.075F, 3.5469F, 1.2719F, 0.1309F, -0.6545F, 0.0F));
		PartDefinition bone16 = Right.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-1.75F, 0.8762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition bone17 = Right.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r22 = bone17.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-0.7842F, -2.7986F, -1.7961F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.075F, 3.5469F, 1.2719F, 0.1309F, 0.6545F, 0.0F));
		PartDefinition bone18 = Right.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-5.4F, 0.8762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition bone19 = Right.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r23 = bone19.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-2.5778F, 0.4384F, -2.7876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.575F, 0.9995F, 3.4815F, -0.0876F, -0.0869F, 0.0076F));
		PartDefinition bone20 = Right.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-5.4F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition bone21 = Right.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(3, 49).mirror().addBox(-1.75F, 1.1262F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));
		PartDefinition bone22 = Right.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(2, 49).addBox(6.4243F, -1.3544F, -2.0003F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition bone23 = Right.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r24 = bone23.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(7, 52).addBox(0.4993F, 0.3468F, 2.2075F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.1745F, 0.0F, 0.0F));
		PartDefinition bone24 = Right.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r25 = bone24.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-2.4993F, 0.3468F, 2.2075F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.1745F, 0.0F, 0.0F));
		PartDefinition bone25 = Right.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r26 = bone25.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-0.7467F, -1.1124F, 2.2075F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.0381F, 0.1704F, -1.3494F));
		PartDefinition bone26 = Right.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r27 = bone26.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-0.4743F, -0.5529F, 2.2461F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.2182F, 0.0F, 0.0F));
		PartDefinition bone27 = Right.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r28 = bone27.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(7, 52).addBox(-1.2533F, -1.1124F, 2.2075F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.0381F, -0.1704F, 1.3494F));
		PartDefinition bone28 = Right.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r29 = bone28.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(7, 52).mirror().addBox(-2.2493F, 0.7665F, 2.224F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.2618F, 0.0F, 0.0F));
		PartDefinition bone29 = Right.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offset(-5.0F, 12.0F, -0.25F));
		PartDefinition cube_r30 = bone29.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(9, 52).mirror().addBox(1.2507F, 0.7665F, 2.224F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.925F, -1.2443F, -0.666F, 0.2618F, 0.0F, 0.0F));
		PartDefinition bone30 = Right.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(2, 49).mirror().addBox(2.4257F, -1.3544F, -2.0003F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 12.0F, -0.25F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}

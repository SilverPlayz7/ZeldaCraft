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

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelFierceMask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("zelda_craft", "model_fierce_mask"), "main");
	public final ModelPart Mask;

	public ModelFierceMask(ModelPart root) {
		this.Mask = root.getChild("Mask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Mask = partdefinition.addOrReplaceChild(
				"Mask", CubeListBuilder.create().texOffs(20, 20).addBox(-4.0F, -7.975F, -4.025F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(4.025F, -7.975F, -4.025F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.mirror().addBox(-4.025F, -7.975F, -4.025F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-4.0F, 0.025F, -4.025F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Mask.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 14).mirror().addBox(0.0F, -0.194F, -1.4614F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.9821F, -3.9974F, -0.9575F, 0.6195F, -0.7291F, -0.1418F));
		PartDefinition cube_r2 = Mask.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(0.0F, -0.693F, -1.6528F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.9483F, -4.3647F, -1.0848F, 0.3074F, -0.7167F, -0.1976F));
		PartDefinition cube_r3 = Mask.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -0.693F, -1.6528F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.9483F, -4.3647F, -1.0848F, 0.3074F, 0.7167F, 0.1976F));
		PartDefinition cube_r4 = Mask.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(10, 17).addBox(0.0F, -0.944F, -1.4614F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 14).addBox(0.0F, -0.194F, -1.4614F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.9821F, -3.9974F, -0.9575F, 0.6195F, 0.7291F, 0.1418F));
		PartDefinition Hair = Mask.addOrReplaceChild("Hair", CubeListBuilder.create().texOffs(6, 46).addBox(-0.3608F, -9.3988F, -5.0252F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 0.0F, 0.0F));
		PartDefinition cube_r5 = Hair.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(44, 11).addBox(-3.25F, -0.75F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 20)
				.addBox(1.7783F, -0.75F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 24).addBox(-1.2217F, -1.25F, -1.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1392F, -8.4906F, -3.0748F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r6 = Hair.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(52, 48).addBox(-0.8186F, -2.7926F, 0.0504F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, -2.5373F, 0.197F, 0.0952F));
		PartDefinition cube_r7 = Hair.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(36, 9).addBox(-0.4436F, -1.171F, 1.6382F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, -1.9199F, 0.0F, 0.2182F));
		PartDefinition cube_r8 = Hair.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 33).addBox(-0.6786F, -2.1409F, 0.8029F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, -1.8427F, 0.3414F, 0.1246F));
		PartDefinition cube_r9 = Hair.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(48, 49).addBox(0.0617F, 0.1924F, -1.6547F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 1.1549F, 0.5008F, 0.6295F));
		PartDefinition cube_r10 = Hair.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 49).addBox(0.1296F, 0.1724F, -1.0301F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 1.2298F, 0.046F, 0.0211F));
		PartDefinition cube_r11 = Hair.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(29, 53).addBox(-0.7F, -1.5F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.95F, -4.5F, -5.9F, 0.1745F, -0.5236F, 0.0F));
		PartDefinition cube_r12 = Hair.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(25, 53).addBox(-1.7254F, -2.3305F, -1.4573F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 0.6911F, -0.1998F, -0.2559F));
		PartDefinition cube_r13 = Hair.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(0.015F, -2.2043F, -1.5943F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 0.6064F, 0.7299F, 0.6496F));
		PartDefinition cube_r14 = Hair.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 5).addBox(0.015F, -2.264F, -0.7055F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 0.9991F, 0.7299F, 0.6496F));
		PartDefinition cube_r15 = Hair.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(44, 46).addBox(0.0786F, -3.1071F, -0.0994F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 0.2054F, 0.0732F, -0.1374F));
		PartDefinition cube_r16 = Hair.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.2295F, -3.4467F, -3.7803F, 0.3642F, 0.0337F, 0.014F));
		PartDefinition cube_r17 = Hair.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(14, 46).addBox(0.0207F, -2.1695F, -0.703F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 0.6105F, 0.1859F, -0.0716F));
		PartDefinition cube_r18 = Hair.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(34, 3).addBox(0.0F, 0.0F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5095F, -9.6788F, -7.6844F, 1.5442F, -0.0553F, 0.4487F));
		PartDefinition cube_r19 = Hair.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.1656F, -6.1328F, -8.1164F, 1.5257F, 0.1136F, 0.286F));
		PartDefinition cube_r20 = Hair.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(52, 5).addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.3881F, -9.4468F, -7.385F, 1.0428F, 0.1134F, -0.2131F));
		PartDefinition cube_r21 = Hair.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3979F, -8.6134F, -6.4732F, 1.3104F, 1.0617F, -0.13F));
		PartDefinition cube_r22 = Hair.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(42, 51).addBox(0.3F, -0.2F, -0.7F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.989F, -8.848F, -4.1461F, 0.717F, 1.0573F, -0.13F));
		PartDefinition cube_r23 = Hair.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(52, 31).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3259F, -9.2638F, -5.9866F, 2.3749F, 1.4708F, 1.769F));
		PartDefinition cube_r24 = Hair.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(12, 41).addBox(-1.9989F, -0.5462F, 0.5642F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.2304F, -8.513F, -7.6743F, 0.6875F, 0.959F, -0.0271F));
		PartDefinition cube_r25 = Hair.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(50, 18).addBox(-1.8629F, -0.2155F, 0.0094F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.2304F, -8.513F, -7.6743F, 1.0128F, 0.8621F, -0.2349F));
		PartDefinition cube_r26 = Hair.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(12, 51).addBox(-2.0862F, -0.1084F, -0.948F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.1463F, -8.5468F, -7.9095F, 1.6177F, 0.9218F, 0.2022F));
		PartDefinition cube_r27 = Hair.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(12, 30).addBox(-2.1963F, -0.4014F, -2.5006F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.9969F, -8.4903F, -7.7752F, 1.4694F, 0.9285F, -0.094F));
		PartDefinition cube_r28 = Hair.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(18, 49).addBox(-0.6F, 0.0F, -1.95F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.8866F, -5.8684F, -8.1865F, 1.7505F, -0.2171F, -0.271F));
		PartDefinition cube_r29 = Hair.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(30, 49).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.2761F, -8.7587F, -7.9235F, 1.4389F, 0.038F, -0.1692F));
		PartDefinition cube_r30 = Hair.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(7, 41).addBox(0.0F, 0.0F, -2.85F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.2611F, -8.5905F, -7.8856F, 1.4534F, -0.195F, 0.0976F));
		PartDefinition cube_r31 = Hair.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(52, 41).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3311F, -10.261F, -7.0593F, 0.7121F, 0.2089F, -0.0771F));
		PartDefinition cube_r32 = Hair.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(20, 41).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4284F, -9.9405F, -7.0276F, 0.6397F, 0.2613F, 0.3743F));
		PartDefinition cube_r33 = Hair.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(21, 45).addBox(-1.8399F, 0.1221F, 0.0594F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5088F, -10.3264F, -7.15F, 0.0047F, -0.0582F, -0.2122F));
		PartDefinition cube_r34 = Hair.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(6, 49).addBox(-0.0004F, 0.2072F, 0.0119F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5088F, -10.3264F, -7.15F, 0.1357F, 0.0039F, 0.2054F));
		PartDefinition cube_r35 = Hair.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(17, 53).addBox(-0.4F, 0.0F, -0.95F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7866F, -5.0684F, -8.1865F, 1.7464F, 0.0453F, 0.24F));
		PartDefinition cube_r36 = Hair.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(21, 53).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7866F, -5.0684F, -8.1865F, 1.7521F, 0.0033F, 0.4719F));
		PartDefinition cube_r37 = Hair.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(32, 41).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0656F, -5.3328F, -8.1164F, 1.5257F, -0.1136F, -0.286F));
		PartDefinition cube_r38 = Hair.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(41, 15).addBox(0.0F, 0.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.1761F, -7.9587F, -7.9235F, 1.4389F, -0.038F, 0.1692F));
		PartDefinition cube_r39 = Hair.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(41, 6).addBox(-1.0F, 0.0F, -2.85F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1611F, -7.7905F, -7.8856F, 1.4534F, -0.0144F, -0.0976F));
		PartDefinition cube_r40 = Hair.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(36, 51).addBox(-0.1371F, -0.2155F, 0.0094F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1304F, -7.713F, -7.6743F, 1.0538F, -0.7343F, 0.2056F));
		PartDefinition cube_r41 = Hair.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(51, 35).addBox(-0.0011F, -0.4712F, 0.5642F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1304F, -7.713F, -7.6743F, 0.8236F, -0.8282F, 0.023F));
		PartDefinition cube_r42 = Hair.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 53).addBox(0.0862F, -0.1084F, -0.948F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0463F, -7.7468F, -7.9095F, 1.5808F, -0.8368F, -0.1745F));
		PartDefinition cube_r43 = Hair.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(14, 37).addBox(0.225F, -0.1F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1581F, -6.1869F, -7.8352F, 2.1547F, -1.0139F, -0.0439F));
		PartDefinition cube_r44 = Hair.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(52, 11).addBox(0.1963F, -0.4014F, -1.5006F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0463F, -7.7468F, -7.9095F, 1.76F, -0.8539F, 0.0653F));
		PartDefinition cube_r45 = Hair.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(52, 14).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.2881F, -8.6468F, -7.385F, 1.0428F, -0.1134F, 0.2131F));
		PartDefinition cube_r46 = Hair.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(52, 21).addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2311F, -9.461F, -7.0593F, 0.7121F, -0.2089F, 0.0771F));
		PartDefinition cube_r47 = Hair.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(33, 53).addBox(-0.0797F, -0.0108F, 0.0409F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3169F, -9.2253F, -6.15F, 0.0921F, -0.1498F, 1.2133F));
		PartDefinition cube_r48 = Hair.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(17, 37).addBox(-1.0865F, -0.7136F, -0.248F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.4805F, -6.7644F, -4.602F, 0.0F, 0.0F, 1.1345F));
		PartDefinition cube_r49 = Hair.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(45, 38).addBox(0.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.1562F, -6.8155F, -4.641F, 0.4867F, -0.342F, 1.5154F));
		PartDefinition cube_r50 = Hair.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(45, 42).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.4669F, -8.1352F, -6.1909F, 0.2239F, 0.1112F, 1.5481F));
		PartDefinition cube_r51 = Hair.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(6, 53).addBox(0.0727F, 0.2542F, 0.0323F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1751F, -9.1932F, -6.0822F, 0.0707F, 0.1481F, 1.0707F));
		PartDefinition cube_r52 = Hair.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(53, 38).addBox(-0.0797F, -0.0108F, 0.0409F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3169F, -9.2253F, -6.15F, 0.1688F, -0.0486F, 0.4744F));
		PartDefinition cube_r53 = Hair.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(38, 44).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3169F, -9.5253F, -5.15F, 0.2616F, 0.0113F, 0.2197F));
		PartDefinition cube_r54 = Hair.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(10, 39).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.3851F, -10.0429F, -3.15F, -0.5236F, 0.0F, 0.2618F));
		PartDefinition cube_r55 = Hair.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(10, 39).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2572F, -9.5656F, -2.2923F, -0.829F, 0.0F, 0.2618F));
		PartDefinition cube_r56 = Hair.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(7, 38).addBox(-1.0F, -0.3F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.2733F, -9.4943F, -4.15F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r57 = Hair.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(48, 46).addBox(-1.2909F, -1.2161F, 1.3697F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7694F, -3.2913F, -2.9986F, 0.0356F, -0.0765F, 1.6175F));
		PartDefinition cube_r58 = Hair.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(48, 3).addBox(-4.0F, 0.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.136F, -4.6936F, -0.7791F, 0.0637F, -0.3646F, 1.2489F));
		PartDefinition cube_r59 = Hair.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(49, 9).addBox(-2.0F, -0.2F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5219F, -8.2103F, -2.1737F, -0.801F, -0.3346F, 0.5483F));
		PartDefinition cube_r60 = Hair.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(49, 9).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.6681F, -8.0507F, -3.15F, 0.0193F, -0.2173F, 0.7397F));
		PartDefinition cube_r61 = Hair.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 40).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3169F, -9.5253F, -5.15F, 0.0F, 0.0F, 0.829F));
		PartDefinition cube_r62 = Hair.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(18, 6).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4716F, -9.1405F, -7.0276F, 0.6397F, -0.2613F, -0.3743F));
		PartDefinition cube_r63 = Hair.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(49, 27).addBox(0.0F, 0.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4088F, -9.8264F, -5.15F, 0.3494F, 0.0403F, -0.2015F));
		PartDefinition cube_r64 = Hair.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(41, 3).addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8768F, -6.8361F, -1.8238F, -0.7739F, 0.3352F, -0.9888F));
		PartDefinition cube_r65 = Hair.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(41, 3).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.9852F, -8.9532F, -3.6028F, -0.1995F, 0.2884F, -1.1112F));
		PartDefinition cube_r66 = Hair.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(47, -1).addBox(-2.5376F, -0.8207F, -1.2933F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.354F, -3.8295F, -1.7523F, -0.4109F, 0.7756F, -1.8258F));
		PartDefinition cube_r67 = Hair.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(46, 15).addBox(-0.2878F, 0.0656F, -0.2011F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.354F, -3.8295F, -1.7523F, 2.9351F, -1.1526F, 2.1539F));
		PartDefinition cube_r68 = Hair.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(46, 6).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.2661F, -5.2065F, -6.4325F, 3.0017F, -0.4851F, 2.0757F));
		PartDefinition cube_r69 = Hair.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(29, 46).addBox(-0.2744F, 0.1087F, -0.2011F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.354F, -3.8295F, -1.7523F, -2.9999F, -1.1576F, 1.774F));
		PartDefinition cube_r70 = Hair.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(26, 28).addBox(0.0F, -1.0F, -2.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0062F, -7.1458F, -7.5526F, -2.4532F, -0.857F, 2.1355F));
		PartDefinition cube_r71 = Hair.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(34, 32).addBox(-7.0F, -1.0F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.8677F, -2.5934F, -2.482F, -2.9473F, -0.86F, 2.1426F));
		PartDefinition cube_r72 = Hair.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(40, 29).addBox(-0.1302F, -0.1659F, -1.9471F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8871F, -3.9677F, -4.8054F, 3.0529F, -0.8849F, 2.0233F));
		PartDefinition cube_r73 = Hair.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(10, 25).addBox(0.0F, 0.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5544F, -4.8933F, -4.6296F, -2.6807F, -0.7746F, 1.7794F));
		PartDefinition cube_r74 = Hair.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(46, 32).addBox(-5.6F, 0.5F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.6521F, -2.6003F, -2.0309F, 2.9579F, -0.8297F, 2.1464F));
		PartDefinition cube_r75 = Hair.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(22, 31).addBox(-0.9357F, -0.7678F, -1.0817F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.354F, -3.8295F, -1.7523F, -0.1241F, 0.6324F, -1.5064F));
		PartDefinition cube_r76 = Hair.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(35, 0).addBox(-1.2395F, -0.79F, -0.6891F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.354F, -3.8295F, -1.7523F, -0.3977F, 0.3505F, -1.585F));
		PartDefinition cube_r77 = Hair.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(25, 32).addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3532F, -9.215F, -2.7234F, -0.4919F, 0.3477F, -0.2999F));
		PartDefinition cube_r78 = Hair.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(24, 31).addBox(0.0F, 0.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0572F, -7.5018F, -0.7033F, -0.8846F, 0.3477F, -0.2999F));
		PartDefinition cube_r79 = Hair.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(38, 42).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.3807F, -10.032F, -4.6288F, 0.0F, 0.3491F, -0.3927F));
		PartDefinition cube_r80 = Hair.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(41, 35).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.9416F, -8.9713F, -5.15F, 0.0F, 0.1745F, -1.0472F));
		PartDefinition cube_r81 = Hair.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(48, 24).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.9416F, -8.9713F, -5.15F, 0.0F, 0.0F, -0.4363F));
		PartDefinition cube_r82 = Hair.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(35, 48).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.246F, -10.502F, -5.15F, 0.0F, 0.0F, -0.3491F));
		PartDefinition cube_r83 = Hair.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(16, 42).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4912F, -9.8264F, -5.15F, 0.0F, 0.0F, 0.7418F));
		PartDefinition cube_r84 = Hair.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(17, 43).addBox(0.0F, -2.2F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.8399F, -9.4135F, -3.674F, -0.1629F, 0.4452F, 1.0322F));
		PartDefinition cube_r85 = Hair.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(16, 42).addBox(0.05F, -2.0F, -2.05F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0205F, -7.522F, -1.4852F, -0.2428F, 0.9161F, 0.9089F));
		PartDefinition cube_r86 = Hair.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(45, 27).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4088F, -9.8264F, -3.15F, -0.48F, 0.0F, -0.2182F));
		PartDefinition cube_r87 = Hair.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(45, 27).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.485F, -9.5921F, -2.263F, -0.9512F, 0.0F, -0.2182F));
		PartDefinition cube_r88 = Hair.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(44, 26).addBox(-1.0F, -0.3F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.45F, -9.75F, -4.15F, 0.0F, 0.0F, -0.2182F));
		PartDefinition bone2 = Hair.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(-3.2914F, -0.0687F, 0.8205F));
		PartDefinition cube_r89 = bone2.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(42, 11).mirror().addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2321F, -0.0282F, -1.1707F));
		PartDefinition cube_r90 = bone2.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(42, 11).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0827F, 0.0F, 0.0F, -0.2321F, 0.0282F, 1.1707F));
		PartDefinition cube_r91 = bone2.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(36, 35).addBox(0.1F, 4.0012F, -0.01F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.7086F, -6.9212F, 4.7353F, -1.3538F, 0.0226F, -0.1023F));
		PartDefinition cube_r92 = bone2.addOrReplaceChild("cube_r92",
				CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, 0.25F, -0.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 28).addBox(-3.5F, 0.25F, -0.45F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.2914F, -8.8153F, -3.0424F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r93 = bone2.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(0, 20).addBox(-4.75F, 0.25F, -0.5F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.7914F, -4.1984F, -0.954F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r94 = bone2.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(0, 12).addBox(-4.75F, 0.25F, -0.5F, 9.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.7914F, -8.6813F, -3.0705F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube_r95 = bone2.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(17, 31).addBox(-4.0F, 0.25F, 0.55F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(7, 31)
				.addBox(3.5F, 0.25F, 0.55F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(1, 6).addBox(-3.45F, 0.275F, 0.425F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.2914F, -8.916F, -3.0117F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r96 = bone2.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(22, 1).addBox(-5.0F, 0.0F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.7914F, -7.7597F, -2.0891F, 0.4366F, -0.0316F, -0.0148F));
		PartDefinition cube_r97 = bone2.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(23, 8).addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.7086F, -7.7597F, -2.0891F, 0.4366F, 0.0316F, 0.0148F));
		PartDefinition cube_r98 = bone2.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(36, 18).addBox(-1.1F, 4.0012F, -0.01F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.7914F, -6.9212F, 4.7353F, -1.3538F, -0.0226F, 0.1023F));
		PartDefinition cube_r99 = bone2.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(24, 40).addBox(1.0F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.7914F, -2.0481F, -0.1918F, 2.3125F, -0.0059F, 0.0064F));
		PartDefinition cube_r100 = bone2.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(35, 13).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.7914F, -4.1345F, -0.3986F, 0.3503F, -0.082F, -0.0299F));
		PartDefinition cube_r101 = bone2.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(27, 35).addBox(0.0F, 0.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.7086F, -4.1345F, -0.3986F, 0.3503F, 0.082F, 0.0299F));
		PartDefinition cube_r102 = bone2.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(17, 15).addBox(-5.75F, -0.5F, -3.0F, 7.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.7914F, -2.0481F, -0.1918F, 2.3125F, 0.0F, 0.0F));
		PartDefinition cube_r103 = bone2.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(24, 40).mirror().addBox(-2.0F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.2914F, -2.0481F, -0.1918F, 2.3125F, 0.0059F, -0.0064F));
		return LayerDefinition.create(meshdefinition, 64, 64);
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
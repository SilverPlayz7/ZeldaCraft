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

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelGaro_Mask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("zelda_craft", "model_garo_mask"), "main");
	public final ModelPart Mask;

	public ModelGaro_Mask(ModelPart root) {
		this.Mask = root.getChild("Mask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Mask = partdefinition.addOrReplaceChild("Mask", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Mask.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 19).addBox(-0.001F, 0.0F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.6114F, -1.2839F, 2.6513F, 0.0787F, -0.1016F, 0.3016F));
		PartDefinition cube_r2 = Mask.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 19).addBox(-0.001F, 0.0F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.9266F, -3.2146F, 2.8152F, 0.0787F, -0.1016F, 0.1707F));
		PartDefinition cube_r3 = Mask.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 15).addBox(0.2432F, 0.1874F, -0.1224F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7319F, -4.0616F, -0.1639F, 0.0787F, -0.1016F, -0.1783F));
		PartDefinition cube_r4 = Mask.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(13, 26).addBox(-2.001F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.6114F, -1.2839F, -2.9791F, -0.0787F, 0.1889F, 0.3016F));
		PartDefinition cube_r5 = Mask.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 34).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.6074F, -0.6076F, -3.5978F, -0.5896F, 1.4315F, -0.2687F));
		PartDefinition cube_r6 = Mask.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(26, 28).addBox(-0.001F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.9094F, -7.8593F, -6.1918F, -0.1123F, 0.444F, -1.3277F));
		PartDefinition cube_r7 = Mask.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 7).addBox(-0.001F, 0.0F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.9094F, -7.8593F, -6.1918F, 0.3182F, 0.646F, 0.0066F));
		PartDefinition cube_r8 = Mask.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(5, 26).addBox(-0.75F, -0.75F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.612F, -5.3355F, -5.2209F, 0.1223F, 0.052F, 0.0064F));
		PartDefinition cube_r9 = Mask.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(20, 8).addBox(-3.7F, -4.25F, -2.45F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror().addBox(0.5F, -4.25F, -2.25F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.312F, -3.8855F, -2.5959F, 0.0784F, 0.0581F, -0.1742F));
		PartDefinition cube_r10 = Mask.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 8).addBox(-6.1F, -2.6F, -0.7F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.1704F, -7.4135F, -4.5741F, -0.0197F, 0.0955F, -1.3118F));
		PartDefinition cube_r11 = Mask.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.7097F, -3.3722F, 4.6479F, -3.017F, 0.7496F, -2.9405F));
		PartDefinition cube_r12 = Mask.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(19, 7).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.7657F, -5.2636F, 5.3769F, 3.0044F, 0.7496F, 2.8366F));
		PartDefinition cube_r13 = Mask.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.4792F, -1.3939F, 4.4659F, -2.7927F, 0.6874F, -2.6017F));
		PartDefinition cube_r14 = Mask.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(33, 24).mirror().addBox(-0.4844F, -1.534F, -0.2209F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.0941F, -7.306F, 5.0577F, 1.6438F, 1.127F, 1.8822F));
		PartDefinition cube_r15 = Mask.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(24, 2).mirror().addBox(-0.1426F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.4042F, -0.2293F, 5.3329F, -1.8049F, 1.1151F, -1.8963F));
		PartDefinition cube_r16 = Mask.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(24, 2).mirror().addBox(-0.1426F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.3978F, -2.0879F, 5.9546F, -2.0825F, 1.3121F, -2.1674F));
		PartDefinition cube_r17 = Mask.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(28, 19).mirror().addBox(-0.1426F, 0.1099F, 0.394F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.5147F, -7.8298F, 5.394F, 1.9547F, 1.1084F, 1.8798F));
		PartDefinition cube_r18 = Mask.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(24, 2).mirror().addBox(-0.1426F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.4851F, -5.9817F, 6.0242F, 2.2235F, 1.3058F, 2.1513F));
		PartDefinition cube_r19 = Mask.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(24, 2).mirror().addBox(-0.1426F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.4415F, -4.0401F, 6.2063F, -2.7946F, 1.4202F, -2.8744F));
		PartDefinition cube_r20 = Mask.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.225F, -1.0F, -0.025F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.1197F, -4.3043F, 5.4435F, 3.1318F, 0.7323F, 2.9939F));
		PartDefinition cube_r21 = Mask.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-1.001F, -4.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0397F, -8.1207F, 2.8061F, 0.0197F, -0.0955F, -1.3118F));
		PartDefinition cube_r22 = Mask.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(6, 34).mirror().addBox(-0.106F, -0.8108F, -1.4611F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.2407F, -7.0423F, 4.1449F, -0.0784F, -0.0581F, -0.1742F));
		PartDefinition cube_r23 = Mask.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(29, 12).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0402F, -8.119F, 2.806F, -0.0002F, 0.0F, -1.3128F));
		PartDefinition cube_r24 = Mask.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0395F, -8.1198F, 2.806F, -0.0001F, 0.0001F, -0.1783F));
		PartDefinition cube_r25 = Mask.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(21, 31).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0402F, -8.119F, -3.206F, 0.0002F, 0.0F, -1.3128F));
		PartDefinition cube_r26 = Mask.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(23, 21).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0395F, -8.1198F, -3.206F, 0.0001F, -0.0001F, -0.1783F));
		PartDefinition cube_r27 = Mask.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.8F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.5552F, -2.3875F, -4.3718F, -0.0448F, -0.197F, -0.296F));
		PartDefinition cube_r28 = Mask.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.8F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5552F, -2.3875F, -4.3718F, -0.0448F, 0.197F, 0.296F));
		PartDefinition cube_r29 = Mask.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(15, 14).addBox(0.2432F, 0.1874F, -4.8776F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7319F, -4.0616F, -0.1639F, -0.0787F, 0.1016F, -0.1783F));
		PartDefinition cube_r30 = Mask.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(30, 0).addBox(-1.001F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.6114F, -1.2839F, -2.9791F, -0.0787F, 0.1016F, 0.3016F));
		PartDefinition cube_r31 = Mask.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(18, 0).addBox(-1.001F, 0.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.9266F, -3.2146F, -2.8152F, -0.0787F, 0.1016F, 0.1707F));
		PartDefinition cube_r32 = Mask.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(21, 23).addBox(-0.001F, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.9094F, -7.8593F, -6.1918F, 0.2529F, 0.0581F, -0.1742F));
		PartDefinition cube_r33 = Mask.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(1, 16).mirror().addBox(-4.3542F, 0.8269F, -2.6764F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.3508F, -0.714F, -0.3367F));
		PartDefinition cube_r34 = Mask.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(14, 16).addBox(2.9276F, 1.0226F, -4.0644F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.3508F, 0.714F, 0.3367F));
		PartDefinition cube_r35 = Mask.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(1, 16).addBox(3.0567F, -0.2585F, -4.6744F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.6208F, 0.7065F, 0.3731F));
		PartDefinition cube_r36 = Mask.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(16, 11).addBox(3.0632F, -0.8935F, -4.5838F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.3072F, 0.7704F, 0.1609F));
		PartDefinition cube_r37 = Mask.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(21, 31).addBox(1.0F, -2.5F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.2704F, -7.4135F, -4.5741F, -0.0197F, 0.0955F, -1.3118F));
		PartDefinition cube_r38 = Mask.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(16, 9).mirror().addBox(3.0321F, -1.1856F, -4.4823F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.0567F, 0.7835F, -0.0152F));
		PartDefinition cube_r39 = Mask.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(12, 34).mirror().addBox(-0.5F, -1.0F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.6074F, -0.6076F, -3.5978F, -0.5896F, -1.4315F, 0.2687F));
		PartDefinition cube_r40 = Mask.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(13, 26).mirror().addBox(0.001F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.6114F, -1.2839F, -2.9791F, -0.0787F, -0.1889F, -0.3016F));
		PartDefinition cube_r41 = Mask.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(8, 26).addBox(0.0F, 0.0F, -3.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0395F, -8.1198F, 2.806F, -0.0001F, -0.0001F, 0.1783F));
		PartDefinition cube_r42 = Mask.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(6, 34).addBox(-0.894F, -0.8108F, -1.4611F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.2407F, -7.0423F, 4.1449F, -0.0784F, 0.0581F, 0.1742F));
		PartDefinition cube_r43 = Mask.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.001F, -4.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.0397F, -8.1207F, 2.8061F, 0.0197F, 0.0955F, 1.3118F));
		PartDefinition cube_r44 = Mask.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(21, 31).addBox(0.0F, -4.0F, -3.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0402F, -8.119F, 2.806F, -0.0002F, 0.0F, 1.3128F));
		PartDefinition cube_r45 = Mask.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(16, 26).addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0395F, -8.1198F, -3.206F, 0.0001F, 0.0001F, 0.1783F));
		PartDefinition cube_r46 = Mask.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(21, 31).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0402F, -8.119F, -3.206F, 0.0002F, 0.0F, 1.3128F));
		PartDefinition cube_r47 = Mask.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(17, 7).mirror().addBox(0.001F, 0.0F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.4556F, -5.0062F, -5.4424F, 0.4329F, -0.5817F, -0.2053F));
		PartDefinition cube_r48 = Mask.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(17, 7).addBox(-0.001F, 0.0F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.4556F, -5.0062F, -5.4424F, 0.4329F, 0.5817F, 0.2053F));
		PartDefinition cube_r49 = Mask.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(0.001F, 0.0F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.9094F, -7.8593F, -6.1918F, 0.3182F, -0.646F, -0.0066F));
		PartDefinition cube_r50 = Mask.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(21, 23).mirror().addBox(0.001F, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.9094F, -7.8593F, -6.1918F, 0.2529F, -0.0581F, 0.1742F));
		PartDefinition cube_r51 = Mask.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(33, 24).addBox(-0.5404F, -1.4951F, -0.4034F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.0941F, -7.306F, 5.0577F, 1.6438F, -1.127F, -1.8822F));
		PartDefinition cube_r52 = Mask.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(28, 19).addBox(-0.8574F, 0.1099F, 0.394F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5147F, -7.8298F, 5.394F, 1.9547F, -1.1084F, -1.8798F));
		PartDefinition cube_r53 = Mask.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(24, 2).addBox(-0.8574F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4851F, -5.9817F, 6.0242F, 2.2235F, -1.3058F, -2.1513F));
		PartDefinition cube_r54 = Mask.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(19, 7).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.7657F, -5.2636F, 5.3769F, 3.0044F, -0.7496F, -2.8366F));
		PartDefinition cube_r55 = Mask.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.7097F, -3.3722F, 4.6479F, -3.017F, -0.7496F, 2.9405F));
		PartDefinition cube_r56 = Mask.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.4792F, -1.3939F, 4.4659F, -2.7927F, -0.6874F, 2.6017F));
		PartDefinition cube_r57 = Mask.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(19, 7).addBox(-0.225F, -1.0F, -0.025F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.1197F, -4.3043F, 5.4435F, 3.1318F, -0.7323F, -2.9939F));
		PartDefinition cube_r58 = Mask.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(24, 2).addBox(-0.8574F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4415F, -4.0401F, 6.2063F, -2.7946F, -1.4202F, 2.8744F));
		PartDefinition cube_r59 = Mask.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(24, 2).addBox(-0.8574F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.3978F, -2.0879F, 5.9546F, -2.0825F, -1.3121F, 2.1674F));
		PartDefinition cube_r60 = Mask.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(24, 2).addBox(-0.8574F, -0.8901F, 0.394F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4042F, -0.2293F, 5.3329F, -1.8049F, -1.1151F, 1.8963F));
		PartDefinition cube_r61 = Mask.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(30, 0).mirror().addBox(0.001F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.6114F, -1.2839F, -2.9791F, -0.0787F, -0.1016F, -0.3016F));
		PartDefinition cube_r62 = Mask.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(10, 19).mirror().addBox(0.001F, 0.0F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.6114F, -1.2839F, 2.6513F, 0.0787F, 0.1016F, -0.3016F));
		PartDefinition cube_r63 = Mask.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(20, 15).mirror().addBox(-0.2432F, 0.1874F, -0.1224F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.7319F, -4.0616F, -0.1639F, 0.0787F, 0.1016F, 0.1783F));
		PartDefinition cube_r64 = Mask.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(15, 14).mirror().addBox(-0.2432F, 0.1874F, -4.8776F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.7319F, -4.0616F, -0.1639F, -0.0787F, -0.1016F, 0.1783F));
		PartDefinition cube_r65 = Mask.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.001F, 0.0F, -3.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.9266F, -3.2146F, 2.8152F, 0.0787F, 0.1016F, -0.1707F));
		PartDefinition cube_r66 = Mask.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.8F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.5552F, -2.3875F, -4.3718F, -0.0758F, -0.3225F, -0.198F));
		PartDefinition cube_r67 = Mask.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(29, 29).addBox(0.001F, 0.0F, -1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.9266F, -3.2146F, -2.8152F, -0.0787F, -0.1016F, -0.1707F));
		PartDefinition cube_r68 = Mask.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(5, 26).mirror().addBox(-1.25F, -0.75F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.612F, -5.3355F, -5.2209F, 0.1223F, -0.052F, -0.0064F));
		PartDefinition cube_r69 = Mask.addOrReplaceChild("cube_r69",
				CubeListBuilder.create().texOffs(20, 8).mirror().addBox(-0.3F, -4.25F, -2.45F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 13).addBox(-0.5F, -4.25F, -2.25F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.312F, -3.8855F, -2.5959F, 0.0784F, -0.0581F, 0.1742F));
		PartDefinition cube_r70 = Mask.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 8).mirror().addBox(-0.9F, -2.6F, -0.7F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.1704F, -7.4135F, -4.5741F, -0.0197F, -0.0955F, 1.3118F));
		PartDefinition cube_r71 = Mask.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(26, 28).mirror().addBox(0.001F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.9094F, -7.8593F, -6.1918F, -0.1123F, -0.444F, 1.3277F));
		PartDefinition cube_r72 = Mask.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(23, 31).mirror().addBox(-1.0F, -2.5F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.2704F, -7.4135F, -4.5741F, -0.0197F, -0.0955F, 1.3118F));
		PartDefinition cube_r73 = Mask.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(0, 15).addBox(-3.1156F, 1.6808F, -3.5589F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.0321F, 0.7831F, -0.0326F));
		PartDefinition cube_r74 = Mask.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(1, 16).addBox(-4.4734F, -0.1482F, -3.267F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.6208F, -0.7065F, -0.3731F));
		PartDefinition cube_r75 = Mask.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.475F, -1.0F, -2.6F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0718F, -2.6402F, -3.9915F, 2.263F, 0.6067F, 2.6104F));
		PartDefinition cube_r76 = Mask.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(0, 0).addBox(-3.525F, -1.0F, -2.6F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.0718F, -2.6402F, -3.9915F, 2.263F, -0.6067F, -2.6104F));
		PartDefinition cube_r77 = Mask.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(16, 11).addBox(-4.4799F, -0.7832F, -3.1764F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.3072F, -0.7704F, -0.1609F));
		PartDefinition cube_r78 = Mask.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(16, 9).addBox(-4.4488F, -1.0752F, -3.0749F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -2.95F, -4.2F, 0.0567F, -0.7835F, 0.0152F));
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

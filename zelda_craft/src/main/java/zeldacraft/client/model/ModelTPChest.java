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
public class ModelTPChest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("zelda_craft", "model_tp_chest"), "main");
	public final ModelPart Body;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;
	public final ModelPart FLeg;
	public final ModelPart BLeg;

	public ModelTPChest(ModelPart root) {
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.FLeg = root.getChild("FLeg");
		this.BLeg = root.getChild("BLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(49, 0).addBox(-2.0517F, -0.2881F, 1.425F, 4.1F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 39).mirror().addBox(1.9983F, -0.2881F, -2.425F, 2.0F, 1.0F, 4.85F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(0, 39).addBox(-4.0233F, -0.2881F, -2.425F, 2.0F, 1.0F, 4.85F, new CubeDeformation(0.0F)).texOffs(16, 15).addBox(-4.025F, 0.675F, -2.425F, 2.0F, 11.7F, 4.85F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-2.025F, 5.0F, -2.425F, 4.05F, 7.375F, 4.85F, new CubeDeformation(0.0F)).texOffs(22, 0).addBox(-2.45F, 1.25F, -2.3F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 42)
						.addBox(-2.025F, -0.05F, -2.2F, 2.0F, 4.2F, 4.0F, new CubeDeformation(0.0F)).texOffs(11, 42).mirror().addBox(0.025F, -0.05F, -2.2F, 2.0F, 4.2F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0)
						.addBox(-2.025F, 2.0F, -2.425F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(1.025F, 2.0F, -2.425F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(0.025F, 4.0F, -2.425F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-1.025F, 4.0F, -2.425F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 15).mirror()
						.addBox(2.025F, 0.7F, -2.425F, 2.0F, 11.7F, 4.85F, new CubeDeformation(0.0F)).mirror(false).texOffs(44, 0).addBox(-1.0F, 4.0F, -2.525F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 0).mirror()
						.addBox(-0.025F, 4.0F, -2.525F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0006F, -0.4807F, 0.1922F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1126F, 0.6216F, -2.4012F, -0.0353F, 0.9083F, 1.991F));
		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 0).addBox(-0.5967F, -0.4384F, -0.4423F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1126F, 0.75F, -1.6012F, 3.1137F, 0.5244F, -2.0855F));
		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(45, 38).mirror().addBox(-0.5F, -1.5F, -0.425F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.1005F, 2.3722F, -2.1F, 0.0F, 0.0F, -1.3963F));
		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 8).mirror().addBox(-0.5F, -1.5F, -0.425F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0994F, 3.4693F, -2.1F, 0.0F, 0.0F, -0.1309F));
		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-0.5F, -1.5F, -0.425F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5714F, 3.6201F, -2.1F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, -1.5F, -0.425F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5964F, 3.6201F, -2.1F, 0.0F, 0.0F, -0.2182F));
		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(34, 8).addBox(-1.5F, -1.5F, -0.425F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.1244F, 3.4693F, -2.1F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r8 = Body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(45, 38).addBox(-2.5F, -1.5F, -0.425F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1255F, 2.3722F, -2.1F, 0.0F, 0.0F, 1.3963F));
		PartDefinition Belt1 = Body.addOrReplaceChild("Belt1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.95F, -13.9F, -2.8F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.05F, -13.9F, -2.8F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(4, 4)
						.addBox(-3.95F, -13.9F, 1.8F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 4).addBox(-4.05F, -13.9F, 1.8F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.2F, 0.0F));
		PartDefinition Pouch1 = Belt1.addOrReplaceChild("Pouch1", CubeListBuilder.create().texOffs(20, 42).mirror().addBox(-4.3F, -13.0F, 2.2F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(10, 39).mirror()
				.addBox(-4.3F, -13.5F, 2.425F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.9F, -0.5F, 0.0F));
		PartDefinition cube_r9 = Pouch1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-0.4F, -0.675F, -1.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.8F, -12.35F, 3.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition Pouch2 = Belt1.addOrReplaceChild("Pouch2", CubeListBuilder.create().texOffs(11, 52).mirror().addBox(0.8F, -13.5F, 2.2F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(16, 7).mirror()
				.addBox(0.8F, -14.5F, 2.425F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.15F, 0.0F, 0.0F));
		PartDefinition cube_r10 = Pouch2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-0.7F, -0.475F, -0.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.3F, -12.35F, 3.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition Buckle = Belt1.addOrReplaceChild("Buckle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r11 = Buckle.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(51, 21).addBox(-0.425F, -1.1F, -2.3F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.9F, -13.3F, -2.5F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r12 = Buckle.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 20).addBox(-1.1F, -0.375F, 0.075F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1F, -13.9F, -2.5F, -0.8727F, 0.0F, 0.0F));
		PartDefinition Scabbard = Body.addOrReplaceChild("Scabbard", CubeListBuilder.create(), PartPose.offset(-0.9F, 10.9F, -2.5F));
		PartDefinition MainPart = Scabbard.addOrReplaceChild("MainPart", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Strap = Scabbard.addOrReplaceChild("Strap",
				CubeListBuilder.create().texOffs(0, 80).addBox(-3.2F, -3.0F, -0.125F, 1.1F, 1.0F, 2.7F, new CubeDeformation(0.0F)).texOffs(0, 80).addBox(-3.2F, -3.0F, 2.425F, 1.1F, 1.0F, 2.7F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r13 = Strap.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(22, 85).addBox(-0.575F, -0.65F, -1.0F, 1.2F, 1.3F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.9415F, -6.6454F, 0.675F, 0.0F, 0.0F, 0.6545F));
		PartDefinition cube_r14 = Strap.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(-1, 56).addBox(-1.1F, -0.7F, -1.6375F, 2.3F, 1.4F, 2.675F, new CubeDeformation(0.0F)).texOffs(-1, 56).addBox(-1.15F, -1.0F, -1.6875F, 2.3F, 2.0F, 2.675F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.639F, -10.5534F, 4.0966F, 0.0287F, -0.0138F, -1.309F));
		PartDefinition cube_r15 = Strap.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(-1, 56).addBox(-1.1F, -0.7F, -1.0375F, 2.3F, 1.4F, 2.675F, new CubeDeformation(0.0F)).texOffs(-1, 56).addBox(-1.15F, -1.0F, -0.9875F, 2.3F, 2.0F, 2.675F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.639F, -10.5534F, 0.9034F, -0.0287F, 0.0138F, -1.309F));
		PartDefinition cube_r16 = Strap.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(1, 81).addBox(-0.5F, -0.25F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8259F, -8.6419F, 4.128F, 0.0287F, -0.0138F, -1.309F));
		PartDefinition cube_r17 = Strap.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(1, 81).addBox(-0.6F, -0.5F, -1.0F, 1.1F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.7385F, -7.7666F, 4.1225F, 0.0302F, -0.0099F, -1.0513F));
		PartDefinition cube_r18 = Strap.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(1, 63).addBox(3.5F, -0.5F, -1.0F, 1.975F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 63).addBox(3.5F, -0.5F, -4.25F, 1.975F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1353F, -2.9718F, 4.125F, 0.0F, 0.0F, -0.9163F));
		PartDefinition cube_r19 = Strap.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(1, 81).addBox(3.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(3, 81)
				.addBox(5.0F, -0.55F, -4.35F, 0.5F, 1.1F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 81).addBox(3.5F, -0.5F, -4.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4217F, -1.7269F, 4.125F, 0.0F, 0.0F, -0.829F));
		PartDefinition cube_r20 = Strap.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(1, 81).addBox(1.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 81).addBox(1.5F, -0.5F, -4.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.6911F, -2.1029F, 4.125F, 0.0F, 0.0F, -0.6981F));
		PartDefinition cube_r21 = Strap.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(1, 81).addBox(-0.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 81).addBox(-0.5F, -0.5F, -4.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.8012F, -2.6409F, 4.125F, 0.0F, 0.0F, -0.3491F));
		PartDefinition cube_r22 = Strap.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(1, 81).addBox(-0.5F, -0.25F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8259F, -8.6419F, 0.872F, -0.0287F, 0.0138F, -1.309F));
		PartDefinition cube_r23 = Strap.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(1, 81).addBox(-0.6F, -0.5F, -1.0F, 1.1F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.7385F, -7.7666F, 0.8775F, -0.0302F, 0.0099F, -1.0513F));
		PartDefinition cube_r24 = Strap.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(12, 72).addBox(1.675F, -3.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 66).addBox(1.675F, -3.4F, -4.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.7361F, -2.2333F, 4.05F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r25 = Strap.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(1, 72).addBox(-0.5F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(11, 66).addBox(-0.5F, -0.5F, -4.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.372F, -3.4534F, 4.05F, 0.0F, 0.0F, 0.3054F));
		PartDefinition cube_r26 = Strap.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(11, 57).addBox(-0.5F, -0.5F, -1.6F, 1.3F, 1.0F, 2.6F, new CubeDeformation(0.0F)).texOffs(21, 57).addBox(-0.5F, -0.5F, -4.075F, 1.3F, 1.0F, 2.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1736F, -3.0032F, 4.05F, 0.0F, 0.0F, 0.0436F));
		PartDefinition cube_r27 = Strap.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(2, 89).addBox(-0.65F, -0.6F, 0.075F, 1.2F, 1.2F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 88).addBox(-0.65F, -0.6F, -4.5F, 1.2F, 1.2F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9901F, -4.3526F, 4.125F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r28 = Strap.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(2, 93).addBox(0.325F, -0.6F, -1.025F, 0.2F, 0.2F, 0.2F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9901F, -3.6455F, 0.625F, 0.0F, 0.0F, -0.7854F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(42, 15).addBox(2.8733F, -0.6131F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(42, 15).addBox(2.8733F, -0.6131F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(39, 43)
						.addBox(0.6983F, -0.3131F, -2.5F, 3.05F, 3.2F, 2.475F, new CubeDeformation(0.0F)).texOffs(39, 43).addBox(0.6983F, -0.3131F, 0.025F, 3.05F, 3.2F, 2.475F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(0.7983F, -2.3131F, -2.5F, 2.95F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(17, 33).addBox(-1.3017F, -2.3131F, -2.5F, 2.1F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-1.3017F, -0.3131F, -2.5F, 2.0F, 3.2F, 5.0F, new CubeDeformation(0.0F)).texOffs(31, 15).addBox(0.4483F, -0.4631F, -2.3F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 46)
						.addBox(-1.2517F, 2.5369F, -2.3F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(46, 15).addBox(-1.2517F, 2.5369F, -1.7F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(38, 8)
						.addBox(0.4483F, 1.5369F, -1.7F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(21, 7).addBox(-0.2F, 1.225F, -1.825F, 3.45F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(3, 49)
						.addBox(2.25F, 1.225F, -2.175F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 46).addBox(-1.2F, 1.225F, -1.825F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 29)
						.addBox(-1.2F, 1.225F, -2.175F, 3.45F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition cube_r29 = LeftArm.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(0, 39).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 39).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.2325F, -0.1131F, 1.3988F, 0.0F, -0.3491F, 0.0F));
		PartDefinition cube_r30 = LeftArm.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(0, 39).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 39).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.2325F, -0.1131F, -1.1988F, 0.0F, 0.3491F, 0.0F));
		PartDefinition cube_r31 = LeftArm.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, 0.2F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3733F, 0.8631F, 0.4F, 0.8182F, -0.8533F, -0.7051F));
		PartDefinition cube_r32 = LeftArm.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, 0.2F, -0.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3733F, 0.8631F, -0.4F, -0.8182F, 0.8533F, -0.7051F));
		PartDefinition cube_r33 = LeftArm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 39).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1491F, 0.9803F, -0.1524F, -0.8182F, -0.8533F, 0.7051F));
		PartDefinition cube_r34 = LeftArm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, -1.2F, -0.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3733F, 2.0869F, -0.4F, 0.8182F, 0.8533F, 0.7051F));
		PartDefinition LForearm = LeftArm.addOrReplaceChild("LForearm",
				CubeListBuilder.create().texOffs(40, 24).addBox(-0.84F, 3.875F, -2.125F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 43).addBox(-0.84F, 3.725F, -2.125F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(26, 15)
						.addBox(-0.84F, 3.875F, 1.075F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(53, 31).addBox(-2.24F, 3.725F, 1.075F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(17, 33)
						.addBox(1.16F, 3.725F, 1.075F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 37).addBox(-2.24F, 3.725F, -2.125F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 49)
						.addBox(1.31F, -0.025F, -2.175F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(21, 7).addBox(-1.69F, -0.025F, -1.825F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 46)
						.addBox(-2.14F, -0.025F, -1.825F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 29).addBox(-2.14F, -0.025F, -2.175F, 3.45F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.94F, 4.25F, 0.0F));
		PartDefinition Gauntlet = LForearm.addOrReplaceChild("Gauntlet",
				CubeListBuilder.create().texOffs(0, 31).addBox(-2.34F, -1.725F, -1.775F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 31).addBox(-2.34F, -1.725F, -1.175F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 31)
						.addBox(-1.54F, -1.725F, -1.175F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 31).addBox(0.46F, -1.725F, -1.775F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(44, 52)
						.addBox(1.7921F, -1.3608F, -1.9F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(53, 55).addBox(1.7921F, -1.3608F, 0.925F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.45F, -0.525F));
		PartDefinition cube_r35 = Gauntlet.addOrReplaceChild("cube_r35",
				CubeListBuilder.create().texOffs(53, 41).addBox(-0.4F, 0.4F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 38).addBox(-0.4F, 0.4F, -2.65F, 1.0F, 1.0F, 3.65F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.4946F, -3.1928F, 0.85F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r36 = Gauntlet.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(45, 31).addBox(-0.5F, 0.0F, -2.2F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.4581F, -2.2587F, 0.2F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r37 = Gauntlet.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(45, 31).addBox(-0.5F, -0.3F, -1.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.225F, 0.775F, -0.5F, 0.0F, 0.0F, 0.3054F));
		PartDefinition cube_r38 = Gauntlet.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 54).addBox(-1.75F, -1.15F, 0.15F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.44F, -0.975F, -2.1F, -0.7854F, 0.0F, 0.0F));
		PartDefinition cube_r39 = Gauntlet.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(50, 52).addBox(0.65F, -1.6F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.24F, -0.975F, -2.1F, -0.7854F, -1.5708F, 0.0F));
		PartDefinition cube_r40 = Gauntlet.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(49, 8).addBox(-1.65F, -1.15F, 0.15F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.16F, -0.975F, 3.15F, 2.3562F, 0.0F, 3.1416F));
		PartDefinition cube_r41 = Gauntlet.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(53, 11).addBox(-1.65F, -1.15F, 0.15F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.16F, 0.775F, 3.15F, 2.3562F, 0.0F, 3.1416F));
		PartDefinition cube_r42 = Gauntlet.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(50, 52).addBox(0.65F, -1.6F, 0.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.24F, 0.775F, -2.1F, -0.7854F, -1.5708F, 0.0F));
		PartDefinition cube_r43 = Gauntlet.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(55, 14).addBox(-1.75F, -1.15F, 0.15F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.44F, 0.775F, -2.1F, -0.7854F, 0.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(42, 15).mirror().addBox(-3.8733F, -0.6131F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(42, 15).mirror()
						.addBox(-3.8733F, -0.6131F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(39, 43).mirror().addBox(-3.7483F, -0.3131F, -2.5F, 3.05F, 3.2F, 2.475F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(39, 43).mirror().addBox(-3.7483F, -0.3131F, 0.025F, 3.05F, 3.2F, 2.475F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror().addBox(-3.7483F, -2.3131F, -2.5F, 2.95F, 2.0F, 5.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(17, 33).mirror().addBox(-0.7983F, -2.3131F, -2.5F, 2.1F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 20).mirror()
						.addBox(-0.6983F, -0.3131F, -2.5F, 2.0F, 3.2F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(31, 15).mirror().addBox(-3.4483F, -0.4631F, -2.3F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(48, 46).mirror().addBox(-0.7483F, 2.5369F, -2.3F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 15).mirror().addBox(-0.7483F, 2.5369F, -1.7F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(38, 8).mirror().addBox(-3.4483F, 1.5369F, -1.7F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 8).mirror()
						.addBox(-3.25F, 1.225F, -0.225F, 3.45F, 3.0F, 2.4F, new CubeDeformation(0.0F)).mirror(false).texOffs(2, 48).mirror().addBox(-3.25F, 1.225F, -2.175F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 46)
						.mirror().addBox(0.2F, 1.225F, -1.825F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(27, 29).mirror().addBox(-2.25F, 1.225F, -2.175F, 3.45F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition cube_r44 = RightArm.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 39).mirror()
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.2325F, -0.1131F, 1.3988F, 0.0F, 0.3491F, 0.0F));
		PartDefinition cube_r45 = RightArm.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 39).mirror()
				.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.2325F, -0.1131F, -1.1988F, 0.0F, -0.3491F, 0.0F));
		PartDefinition cube_r46 = RightArm.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(0.5F, 0.2F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.3733F, 0.8631F, 0.4F, 0.8182F, 0.8533F, 0.7051F));
		PartDefinition cube_r47 = RightArm.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(0.5F, 0.2F, -0.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.3733F, 0.8631F, -0.4F, -0.8182F, -0.8533F, 0.7051F));
		PartDefinition cube_r48 = RightArm.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.1491F, 0.9803F, -0.1524F, -0.8182F, 0.8533F, -0.7051F));
		PartDefinition cube_r49 = RightArm.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(0.5F, -1.2F, -0.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.3733F, 2.0869F, -0.4F, 0.8182F, -0.8533F, -0.7051F));
		PartDefinition LForearm2 = RightArm.addOrReplaceChild("LForearm2",
				CubeListBuilder.create().texOffs(40, 24).mirror().addBox(-2.16F, 3.875F, -2.125F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 43).mirror()
						.addBox(-2.16F, 3.725F, -2.125F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(26, 15).mirror().addBox(-2.16F, 3.875F, 1.075F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(53, 31)
						.mirror().addBox(-1.76F, 3.725F, 1.075F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(17, 33).mirror().addBox(-2.16F, 3.725F, 1.075F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(32, 37).mirror().addBox(-1.76F, 3.725F, -2.125F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 50).mirror().addBox(-2.31F, -0.025F, -2.175F, 1.0F, 3.0F, 2.05F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(22, 8).mirror().addBox(-2.31F, -0.025F, -0.225F, 3.45F, 3.0F, 2.4F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 46).mirror()
						.addBox(1.14F, -0.025F, -1.825F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(27, 29).mirror().addBox(-1.31F, -0.025F, -2.175F, 3.45F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.94F, 4.25F, 0.0F));
		PartDefinition Gauntlet2 = LForearm2.addOrReplaceChild("Gauntlet2",
				CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-0.66F, -1.725F, -1.775F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 31).mirror()
						.addBox(-1.66F, -1.725F, -1.175F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(2, 33).mirror().addBox(-2.46F, -1.725F, 0.825F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(1, 32)
						.mirror().addBox(-2.46F, -1.725F, -1.775F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 2.45F, -0.525F));
		PartDefinition bone2 = RightArm.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -0.25F, -3.0F, 0.0F, 0.0F, 0.9163F));
		PartDefinition FLeg = partdefinition.addOrReplaceChild("FLeg",
				CubeListBuilder.create().texOffs(5, 126).addBox(-4.4069F, 3.3641F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 126).mirror().addBox(3.4069F, 3.3641F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(4, 125).mirror().addBox(3.4069F, 3.3641F, -2.35F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(4, 125).addBox(-4.4069F, 3.3641F, -2.35F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(5, 124).addBox(-3.8F, 3.375F, -2.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 124).addBox(-3.8F, 3.375F, -2.9F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 124)
						.addBox(-0.2F, 3.375F, -2.9F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 124).addBox(-0.2F, 3.375F, -2.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 125)
						.addBox(-3.85F, 0.1248F, -1.5272F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(9, 125).mirror().addBox(-0.15F, 0.1248F, -1.5272F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 12.375F, 0.0F));
		PartDefinition cube_r50 = FLeg.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(8, 117).addBox(-0.5461F, -0.5462F, -0.4632F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5693F, 1.0743F, 0.0337F, -1.3227F, 0.4402F, -1.2461F));
		PartDefinition cube_r51 = FLeg.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(8, 117).addBox(-0.507F, -0.4261F, -0.4903F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5693F, 1.0743F, 0.0337F, -1.9449F, 0.2536F, 0.3571F));
		PartDefinition cube_r52 = FLeg.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(8, 117).mirror().addBox(-0.493F, -0.4261F, -0.4903F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5693F, 1.0743F, 0.0337F, -1.9449F, -0.2536F, -0.3571F));
		PartDefinition cube_r53 = FLeg.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(8, 117).mirror().addBox(-0.4539F, -0.5462F, -0.4632F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5693F, 1.0743F, 0.0337F, -1.3227F, -0.4402F, 1.2461F));
		PartDefinition cube_r54 = FLeg.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(9, 101).addBox(-0.7614F, -0.2801F, -0.8229F, 1.0F, 1.025F, 0.4F, new CubeDeformation(0.0F)).texOffs(9, 96).mirror()
				.addBox(-0.7614F, -2.0665F, -2.4F, 1.0F, 1.8F, 2.375F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5993F, 1.9954F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r55 = FLeg.addOrReplaceChild(
				"cube_r55", CubeListBuilder.create().texOffs(9, 96).addBox(-0.2386F, -2.0665F, -2.4F, 1.0F, 1.8F, 2.375F, new CubeDeformation(0.0F)).texOffs(9, 101).mirror()
						.addBox(-0.2386F, -0.2801F, -0.8229F, 1.0F, 1.025F, 0.4F, new CubeDeformation(0.0F)).mirror(false).texOffs(9, 101).mirror().addBox(-0.2386F, -0.2801F, -2.3979F, 1.0F, 2.5F, 1.7F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5993F, 1.9954F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition cube_r56 = FLeg.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(9, 101).mirror().addBox(-0.2386F, -0.301F, -0.4931F, 1.0F, 2.625F, 0.4F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5993F, 1.9954F, 0.0F, -0.2618F, 0.0F, -0.1745F));
		PartDefinition cube_r57 = FLeg.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(48, 113).mirror().addBox(-3.0F, -1.05F, -1.0F, 4.0F, 4.15F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(9, 101).mirror()
				.addBox(-7.05F, -1.05F, -1.0F, 4.1F, 4.15F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.025F, 1.1835F, -1.6138F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r58 = FLeg.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(9, 101).addBox(-0.7614F, -0.351F, -0.4931F, 1.0F, 2.7F, 0.4F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5993F, 1.9954F, 0.0F, -0.2618F, 0.0F, 0.1745F));
		PartDefinition cube_r59 = FLeg.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(9, 101).addBox(-0.7614F, -0.2551F, -2.3979F, 1.0F, 2.5F, 1.7F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5973F, 1.9841F, -0.0021F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r60 = FLeg.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(5, 123).addBox(-1.0F, -2.5F, -1.025F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1866F, 2.0856F, -0.975F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r61 = FLeg.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(5, 123).mirror().addBox(0.0F, -2.5F, -1.025F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.1866F, 2.0856F, -0.975F, 0.0F, 0.0F, -0.1745F));
		PartDefinition BLeg = partdefinition.addOrReplaceChild("BLeg",
				CubeListBuilder.create().texOffs(9, 125).addBox(-3.85F, 0.0998F, 1.4272F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(9, 125).mirror().addBox(-0.15F, 0.0998F, 1.4272F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(5, 126).addBox(-4.4069F, 3.3391F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 126).mirror().addBox(3.4069F, 3.3391F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(4, 125).mirror().addBox(3.4069F, 3.3391F, 0.35F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(5, 124).addBox(-0.2F, 3.35F, 1.9F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 124)
						.addBox(-3.8F, 3.35F, 1.9F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 124).addBox(-0.2F, 3.35F, 1.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 124)
						.addBox(-3.8F, 3.35F, 1.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 125).addBox(-4.4069F, 3.3391F, 0.35F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 12.4F, 0.0F));
		PartDefinition cube_r62 = BLeg.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(8, 117).addBox(-0.5461F, -0.5462F, -0.4632F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5693F, 1.0493F, 0.0337F, -1.3227F, 0.4402F, -1.2461F));
		PartDefinition cube_r63 = BLeg.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(8, 117).addBox(-0.507F, -0.4261F, -0.4903F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5693F, 1.0493F, 0.0337F, -1.9449F, 0.2536F, 0.3571F));
		PartDefinition cube_r64 = BLeg.addOrReplaceChild(
				"cube_r64", CubeListBuilder.create().texOffs(9, 96).addBox(-0.2386F, -2.0665F, 0.025F, 1.0F, 1.8F, 2.375F, new CubeDeformation(0.0F)).texOffs(9, 101).mirror()
						.addBox(-0.2386F, -0.2801F, 0.6979F, 1.0F, 2.5F, 1.7F, new CubeDeformation(0.0F)).mirror(false).texOffs(9, 101).mirror().addBox(-0.2386F, -0.2801F, 0.4229F, 1.0F, 1.025F, 0.3F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5993F, 1.9704F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition cube_r65 = BLeg.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(8, 117).mirror().addBox(-0.4539F, -0.5462F, -0.4632F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5693F, 1.0493F, 0.0337F, -1.3227F, -0.4402F, 1.2461F));
		PartDefinition cube_r66 = BLeg.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(8, 117).mirror().addBox(-0.493F, -0.4261F, -0.4903F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5693F, 1.0493F, 0.0337F, -1.9449F, -0.2536F, -0.3571F));
		PartDefinition cube_r67 = BLeg.addOrReplaceChild("cube_r67",
				CubeListBuilder.create().texOffs(9, 106).addBox(-3.0F, -1.075F, 0.0F, 4.0F, 4.15F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 101).addBox(-7.05F, -1.075F, 0.0F, 4.1F, 4.15F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.025F, 1.1585F, 1.6138F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r68 = BLeg.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(9, 101).mirror().addBox(-0.2386F, -0.326F, 0.0931F, 1.0F, 2.65F, 0.4F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5993F, 1.9704F, 0.0F, 0.2618F, 0.0F, -0.1745F));
		PartDefinition cube_r69 = BLeg
				.addOrReplaceChild(
						"cube_r69", CubeListBuilder.create().texOffs(9, 101).addBox(-0.7614F, -0.2801F, 0.4229F, 1.0F, 1.025F, 0.3F, new CubeDeformation(0.0F)).texOffs(9, 101)
								.addBox(-0.7614F, -0.2801F, 0.6979F, 1.0F, 2.525F, 1.7F, new CubeDeformation(0.0F)).texOffs(9, 96).mirror().addBox(-0.7614F, -2.0665F, 0.025F, 1.0F, 1.8F, 2.375F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offsetAndRotation(-3.5993F, 1.9704F, 0.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r70 = BLeg.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(9, 101).addBox(-0.7614F, -0.326F, 0.0931F, 1.0F, 2.675F, 0.4F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5993F, 1.9704F, 0.0F, 0.2618F, 0.0F, 0.1745F));
		PartDefinition cube_r71 = BLeg.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(5, 123).addBox(-1.0F, -2.5F, -0.975F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1866F, 2.0606F, 0.975F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r72 = BLeg.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(5, 123).mirror().addBox(0.0F, -2.5F, -0.975F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.1866F, 2.0606F, 0.975F, 0.0F, 0.0F, -0.1745F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.BLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.FLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
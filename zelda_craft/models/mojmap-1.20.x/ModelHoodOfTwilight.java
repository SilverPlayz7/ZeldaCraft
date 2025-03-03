// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelHoodOfTwilight<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "hoodoftwilight"), "main");
	private final ModelPart HoodOfTwilight;

	public ModelHoodOfTwilight(ModelPart root) {
		this.HoodOfTwilight = root.getChild("HoodOfTwilight");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition HoodOfTwilight = partdefinition.addOrReplaceChild("HoodOfTwilight", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Hood = HoodOfTwilight.addOrReplaceChild("Hood", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Hood.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(38, 28).addBox(-1.0F, -1.0F, -4.0F, 1.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.25F, 0.0072F, 5.0242F, 2.081F, -0.1234F, 0.2165F));

		PartDefinition cube_r2 = Hood.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(17, 15).addBox(-5.75F, -0.5F, -3.0F, 7.0F, 2.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -1.8668F, 2.6288F, 2.3125F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Hood.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(35, 43).addBox(1.0F, -0.5F, -3.0F, 1.0F, 2.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -1.8668F, 2.6288F, 2.3125F, -0.0059F, 0.0064F));

		PartDefinition cube_r4 = Hood.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(28, 25).addBox(-5.0F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.25F, -7.5784F, 0.7314F, 0.4366F, -0.0316F, -0.0148F));

		PartDefinition cube_r5 = Hood.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(14, 25).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.25F, -3.9532F, 2.4219F, 0.3503F, -0.082F, -0.0299F));

		PartDefinition cube_r6 = Hood.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(42, 34).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.9014F, -1.5573F, 7.5344F, -0.3665F, -0.1835F, 0.2088F));

		PartDefinition cube_r7 = Hood.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -0.0057F, 0.0044F, 1.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8F, -3.8247F, 8.1959F, -1.5272F, -0.0025F, 0.0567F));

		PartDefinition cube_r8 = Hood.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(6, 36).addBox(-0.9151F, 0.2305F, -0.008F, 1.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1647F, -8.476F, 6.5182F, -0.9168F, -0.0266F, 0.0346F));

		PartDefinition cube_r9 = Hood.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(10, 37).addBox(-1.1F, 0.0012F, -0.01F, 1.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.25F, -6.7399F, 7.5558F, -1.3538F, -0.0226F, 0.1023F));

		PartDefinition cube_r10 = Hood.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(7, 0)
						.addBox(3.0F, 0.25F, 0.55F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, 0.275F, 0.55F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(18, 37)
						.addBox(-4.5F, 0.25F, 0.55F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.25F, -8.7347F, -0.1912F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r11 = Hood.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 23).addBox(-7.7F, 0.025F, 0.0F, 7.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.25F, -8.6834F, 4.3654F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r12 = Hood.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(46, 6).addBox(-1.0F, 0.025F, 0.0F, 1.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.25F, -8.6834F, 4.3654F, -0.1745F, 0.0F, 0.0087F));

		PartDefinition cube_r13 = Hood.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, 0.0F, -2.0F, 3.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.9014F, -1.5573F, 7.5344F, -0.3665F, 0.1835F, -0.2088F));

		PartDefinition cube_r14 = Hood.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, 0.0F, 0.0F, 3.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.25F, -3.9532F, 2.4219F, 0.3503F, 0.082F, 0.0299F));

		PartDefinition cube_r15 = Hood.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5414F, 0.1813F, 2.8205F, -0.2321F, 0.0282F, 1.1707F));

		PartDefinition cube_r16 = Hood.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5414F, 0.1813F, 2.8205F, -0.2321F, -0.0282F, -1.1707F));

		PartDefinition cube_r17 = Hood.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(20, 20).addBox(-4.75F, 0.25F, -0.5F, 9.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.25F, -4.0171F, 1.8665F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r18 = Hood.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(0, 2)
						.addBox(-4.0F, 0.25F, -0.45F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 12)
						.addBox(-3.5F, 0.25F, -0.45F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, -8.634F, -0.2219F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r19 = Hood.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(15, 44).addBox(-2.0F, -0.5F, -3.0F, 1.0F, 2.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.25F, -1.8668F, 2.6288F, 2.3125F, 0.0059F, -0.0064F));

		PartDefinition cube_r20 = Hood.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(40, 21).addBox(0.0F, -1.0F, -4.0F, 1.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.25F, 0.0072F, 5.0242F, 2.081F, 0.1234F, -0.2165F));

		PartDefinition cube_r21 = Hood.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(28, 45).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 2.6053F, 6.5242F, 1.8674F, 0.0741F, -0.2376F));

		PartDefinition cube_r22 = Hood.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(20, 44).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1F, 4.1604F, 8.0277F, -1.8719F, -0.0522F, -0.1666F));

		PartDefinition cube_r23 = Hood.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(28, 39).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.55F, 0.1756F, 8.3763F, -1.6575F, -0.0099F, -0.113F));

		PartDefinition cube_r24 = Hood.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(36, 35).addBox(0.0F, -0.0057F, 0.0044F, 1.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.8F, -3.8247F, 8.1959F, -1.5272F, 0.0025F, -0.0567F));

		PartDefinition cube_r25 = Hood.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(38, 4).addBox(0.1F, 0.0012F, -0.01F, 1.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.25F, -6.7399F, 7.5558F, -1.3538F, 0.0226F, -0.1023F));

		PartDefinition cube_r26 = Hood.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(23, 44).addBox(-1.55F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.25F, -5.6649F, 7.2808F, -1.3526F, 0.0F, 0.0F));

		PartDefinition cube_r27 = Hood.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(46, 21).addBox(-0.0849F, 0.2305F, -0.008F, 1.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.1647F, -8.476F, 6.5182F, -0.9168F, 0.0266F, -0.0346F));

		PartDefinition cube_r28 = Hood.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(34, 14).addBox(-5.75F, -0.5F, -4.0F, 7.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -0.6088F, 4.0912F, 2.0944F, 0.0F, 0.0F));

		PartDefinition cube_r29 = Hood.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(40, 45).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, 2.6053F, 6.5242F, 1.8674F, -0.0741F, 0.2376F));

		PartDefinition cube_r30 = Hood.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(35, 0).addBox(-4.85F, -0.5F, -4.0F, 5.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, 1.8019F, 5.7466F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r31 = Hood.addOrReplaceChild("cube_r31",
				CubeListBuilder.create().texOffs(44, 29).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1F, 4.1604F, 8.0277F, -1.8719F, 0.0522F, 0.1666F));

		PartDefinition cube_r32 = Hood.addOrReplaceChild("cube_r32",
				CubeListBuilder.create().texOffs(43, 4).addBox(0.0F, 0.0F, -1.0F, 5.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 6.0679F, 7.4263F, -1.7213F, 0.2668F, 1.0488F));

		PartDefinition cube_r33 = Hood.addOrReplaceChild("cube_r33",
				CubeListBuilder.create().texOffs(44, 27).addBox(-5.0F, 0.0F, -1.0F, 5.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 6.0679F, 7.4263F, -1.7213F, -0.2668F, -1.0488F));

		PartDefinition cube_r34 = Hood.addOrReplaceChild("cube_r34",
				CubeListBuilder.create().texOffs(44, 4).addBox(-0.35F, -0.475F, -0.425F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1549F, 9.6214F, 5.7816F, -1.7992F, -0.2046F, -0.7182F));

		PartDefinition cube_r35 = Hood.addOrReplaceChild("cube_r35",
				CubeListBuilder.create().texOffs(0, 7)
						.addBox(-2.75F, -0.475F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(15, 37)
						.addBox(-3.9F, -0.475F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 11)
						.addBox(-3.6F, -0.475F, 4.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, 2.1026F, 8.1522F, -1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r36 = Hood.addOrReplaceChild("cube_r36",
				CubeListBuilder.create().texOffs(39, 18).addBox(-4.75F, -0.5F, 2.0F, 5.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, 2.1026F, 8.1272F, -1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r37 = Hood.addOrReplaceChild("cube_r37",
				CubeListBuilder.create().texOffs(42, 39).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.55F, 0.1756F, 8.3763F, -1.6575F, 0.0099F, 0.113F));

		PartDefinition cube_r38 = Hood.addOrReplaceChild("cube_r38",
				CubeListBuilder.create().texOffs(0, 18).addBox(-5.15F, -0.5F, -1.0F, 6.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, 1.1283F, 7.7661F, -1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r39 = Hood.addOrReplaceChild("cube_r39",
				CubeListBuilder.create().texOffs(0, 7).addBox(-5.7F, -0.5F, -1.0F, 7.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -2.7997F, 7.7209F, -1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r40 = Hood.addOrReplaceChild("cube_r40",
				CubeListBuilder.create().texOffs(18, 7).addBox(-5.45F, -0.5F, -1.0F, 7.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -5.6649F, 7.2558F, -1.3526F, 0.0F, 0.0F));

		PartDefinition cube_r41 = Hood.addOrReplaceChild("cube_r41",
				CubeListBuilder.create().texOffs(20, 0).addBox(-5.8F, -0.475F, -1.0F, 7.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -7.2384F, 6.5471F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r42 = Hood.addOrReplaceChild("cube_r42",
				CubeListBuilder.create().texOffs(8, 47).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.25F, -8.6834F, 4.3654F, -0.1745F, 0.0F, -0.0087F));

		PartDefinition cube_r43 = Hood.addOrReplaceChild("cube_r43",
				CubeListBuilder.create().texOffs(26, 32).addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.25F, -7.5784F, 0.7314F, 0.4366F, 0.0316F, 0.0148F));

		PartDefinition cube_r44 = Hood.addOrReplaceChild("cube_r44",
				CubeListBuilder.create().texOffs(0, 12).addBox(-4.75F, 0.25F, -0.5F, 9.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.25F, -8.5F, -0.25F, 0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		HoodOfTwilight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
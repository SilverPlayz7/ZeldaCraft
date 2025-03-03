// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelPegasusBoots<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "pegasusboots"), "main");
	private final ModelPart Left;
	private final ModelPart Right;

	public ModelPegasusBoots(ModelPart root) {
		this.Left = root.getChild("Left");
		this.Right = root.getChild("Right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Left = partdefinition.addOrReplaceChild("Left",
				CubeListBuilder.create().texOffs(42, 56)
						.addBox(-1.75F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(48, 56)
						.addBox(-2.1F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(52, 57)
						.addBox(-2.2F, 6.0F, -2.5F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(46, 57)
						.addBox(-1.7F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.05F, 7.906F, -2.3112F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.2F, 7.906F, -2.3112F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.8F, 7.156F, 1.1388F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.05F, 7.156F, 1.1388F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition bone = Left.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(0.7F, 0.4557F, 1.8045F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.45F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, 9.5F, -4.75F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone2 = Left.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(1.2F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.95F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));

		PartDefinition bone3 = Left.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(1.7F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.45F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone4 = Left.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-6.8F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.05F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 12.0F, -0.25F));

		PartDefinition Wing = Left.addOrReplaceChild("Wing",
				CubeListBuilder.create().texOffs(53, 51)
						.addBox(-1.0F, -6.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(51, 51)
						.addBox(-1.0F, -5.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(52, 52)
						.addBox(-1.0F, -5.5F, 0.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 51)
						.addBox(-1.0F, -7.014F, 1.9233F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 12.0F, 0.25F));

		PartDefinition bone9 = Wing.addOrReplaceChild("bone9",
				CubeListBuilder.create().texOffs(51, 51).addBox(-0.5F, -0.4878F, -1.2303F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -6.4F, 1.25F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bone10 = Wing.addOrReplaceChild("bone10",
				CubeListBuilder.create().texOffs(50, 51).addBox(0.0F, -1.0531F, -0.608F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -5.15F, -1.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition bone11 = Wing.addOrReplaceChild("bone11",
				CubeListBuilder.create().texOffs(43, 50).addBox(-0.5F, -0.1285F, -0.2046F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -6.305F, -0.7662F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone12 = Wing.addOrReplaceChild("bone12",
				CubeListBuilder.create().texOffs(50, 51).addBox(1.0F, -0.059F, -0.2149F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -4.5181F, -1.2779F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone13 = Wing.addOrReplaceChild("bone13",
				CubeListBuilder.create().texOffs(43, 50).addBox(0.0F, -0.5309F, -0.0653F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -4.0261F, -1.0722F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone14 = Wing.addOrReplaceChild("bone14",
				CubeListBuilder.create().texOffs(50, 50).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -6.25F, 1.6F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone15 = Wing.addOrReplaceChild("bone15",
				CubeListBuilder.create().texOffs(49, 51).addBox(-0.5F, -0.7879F, -0.5015F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -4.8778F, -0.1263F, -1.0036F, 0.0F, 0.0F));

		PartDefinition bone16 = Wing.addOrReplaceChild("bone16",
				CubeListBuilder.create().texOffs(55, 51).addBox(-0.5F, -0.215F, -0.015F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -5.2286F, 0.9344F, -0.5672F, 0.0F, 0.0F));

		PartDefinition bone17 = Wing.addOrReplaceChild("bone17",
				CubeListBuilder.create().texOffs(53, 51).addBox(0.0F, -0.7554F, -0.7087F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -4.3746F, 1.1501F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone18 = Wing.addOrReplaceChild("bone18",
				CubeListBuilder.create().texOffs(44, 51).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -5.75F, 1.1F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Right = partdefinition.addOrReplaceChild("Right", CubeListBuilder.create().texOffs(0, 0).mirror()
				.addBox(-2.15F, 7.906F, -2.3112F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(42, 56).mirror().addBox(-2.2F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(48, 56).mirror()
				.addBox(1.15F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 57)
				.mirror().addBox(-2.25F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(46, 57).mirror().addBox(-1.75F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(0, 0).mirror()
				.addBox(-1.9F, 7.906F, -2.3112F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(1.1F, 7.906F, 1.1388F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(0, 0).mirror()
				.addBox(-2.15F, 7.906F, 1.1388F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition bone5 = Right.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.4F, 0.4557F, 1.8045F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.65F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 9.5F, -4.75F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone6 = Right.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.9F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.15F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 9.0F, -4.25F, 0.7418F, 0.0F, 0.0F));

		PartDefinition bone7 = Right.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.4F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.65F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 8.5F, -3.75F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone8 = Right.addOrReplaceChild("bone8",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-10.9F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-11.15F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(9.0F, 12.0F, -0.25F));

		PartDefinition Wing2 = Right.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(53, 51).mirror()
				.addBox(0.0F, -6.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(51, 51)
				.mirror().addBox(0.0F, -5.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(52, 52).mirror().addBox(0.0F, -5.5F, 0.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(55, 51).mirror()
				.addBox(0.0F, -7.014F, 1.9233F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-3.0F, 12.0F, 0.25F));

		PartDefinition bone19 = Wing2.addOrReplaceChild("bone19",
				CubeListBuilder.create().texOffs(51, 51).mirror()
						.addBox(-0.5F, -0.4878F, -1.2303F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -6.4F, 1.25F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bone20 = Wing2.addOrReplaceChild("bone20",
				CubeListBuilder.create().texOffs(50, 51).mirror()
						.addBox(-1.0F, -1.0531F, -0.608F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -5.15F, -1.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition bone21 = Wing2.addOrReplaceChild("bone21",
				CubeListBuilder.create().texOffs(43, 50).mirror()
						.addBox(-0.5F, -0.1285F, -0.2046F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -6.305F, -0.7662F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone22 = Wing2.addOrReplaceChild("bone22",
				CubeListBuilder.create().texOffs(50, 51).mirror()
						.addBox(-2.0F, -0.059F, -0.2149F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, -4.5181F, -1.2779F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone23 = Wing2.addOrReplaceChild("bone23",
				CubeListBuilder.create().texOffs(43, 50).mirror()
						.addBox(-1.0F, -0.5309F, -0.0653F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -4.0261F, -1.0722F, -0.0436F, 0.0F, 0.0F));

		PartDefinition bone24 = Wing2.addOrReplaceChild("bone24",
				CubeListBuilder.create().texOffs(50, 50).mirror()
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -6.25F, 1.6F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bone25 = Wing2.addOrReplaceChild("bone25",
				CubeListBuilder.create().texOffs(49, 51).mirror()
						.addBox(-0.5F, -0.7879F, -0.5015F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -4.8778F, -0.1263F, -1.0036F, 0.0F, 0.0F));

		PartDefinition bone26 = Wing2.addOrReplaceChild("bone26",
				CubeListBuilder.create().texOffs(55, 51).mirror()
						.addBox(-0.5F, -0.215F, -0.015F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -5.2286F, 0.9344F, -0.5672F, 0.0F, 0.0F));

		PartDefinition bone27 = Wing2.addOrReplaceChild("bone27",
				CubeListBuilder.create().texOffs(53, 51).mirror()
						.addBox(-1.0F, -0.7554F, -0.7087F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -4.3746F, 1.1501F, -1.0472F, 0.0F, 0.0F));

		PartDefinition bone28 = Wing2.addOrReplaceChild("bone28",
				CubeListBuilder.create().texOffs(44, 51).mirror()
						.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -5.75F, 1.1F, -0.6545F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Left.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Right.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
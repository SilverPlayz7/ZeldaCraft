// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelDekuMask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "dekumask"), "main");
	private final ModelPart Mask;

	public ModelDekuMask(ModelPart root) {
		this.Mask = root.getChild("Mask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Mask = partdefinition.addOrReplaceChild("Mask", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4.0F, -7.975F, -4.125F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
				.addBox(-4.0F, -0.9F, -3.925F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
				.addBox(3.075F, -7.975F, -3.925F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12).mirror()
				.addBox(-4.075F, -7.975F, -3.925F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Mask.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(14, 19).mirror()
						.addBox(-1.0F, -4.0F, -0.05F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -7.95F, -4.0F, -0.0717F, -0.0334F, -0.8722F));

		PartDefinition cube_r2 = Mask.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(14, 19).addBox(-1.0F, -4.0F, -0.05F, 2.0F, 4.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.95F, -4.0F, -0.0717F, 0.0334F, 0.8722F));

		PartDefinition cube_r3 = Mask.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(14, 19).addBox(-1.0F, -4.0F, -0.05F, 2.0F, 4.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.95F, -4.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition octagon = Mask.addOrReplaceChild("octagon", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-0.0286F, -2.7125F, -5.0065F, 0.0F, -1.5708F, 0.7854F));

		PartDefinition octagon_r1 = octagon.addOrReplaceChild("octagon_r1",
				CubeListBuilder.create().texOffs(18, 0).addBox(-2.2116F, -0.998F, -2.1074F, 3.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -0.3957F, -0.1209F, 0.0503F));

		PartDefinition octagon_r2 = octagon.addOrReplaceChild("octagon_r2",
				CubeListBuilder.create().texOffs(6, 18).addBox(-2.2128F, -1.0242F, -2.1166F, 3.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -1.1811F, -0.05F, 0.121F));

		PartDefinition octagon_r3 = octagon.addOrReplaceChild("octagon_r3",
				CubeListBuilder.create().texOffs(14, 13).addBox(-2.2132F, 1.1193F, -0.9731F, 3.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -1.1751F, -0.1209F, -0.0503F));

		PartDefinition octagon_r4 = octagon.addOrReplaceChild("octagon_r4",
				CubeListBuilder.create().texOffs(6, 12).addBox(-2.2166F, 1.1452F, -0.9639F, 3.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -0.3897F, -0.05F, -0.121F));

		PartDefinition octagon_r5 = octagon.addOrReplaceChild("octagon_r5",
				CubeListBuilder.create().texOffs(14, 16).addBox(-2.2166F, -2.1452F, -1.0361F, 3.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -0.3897F, 0.05F, 0.121F));

		PartDefinition octagon_r6 = octagon.addOrReplaceChild("octagon_r6",
				CubeListBuilder.create().texOffs(6, 15).addBox(-2.2132F, -2.1193F, -1.0269F, 3.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -1.1751F, 0.1209F, 0.0503F));

		PartDefinition octagon_r7 = octagon.addOrReplaceChild("octagon_r7",
				CubeListBuilder.create().texOffs(18, 3).addBox(-2.2116F, -1.002F, 1.1074F, 3.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -0.3957F, 0.1209F, -0.0503F));

		PartDefinition octagon_r8 = octagon.addOrReplaceChild("octagon_r8",
				CubeListBuilder.create().texOffs(18, 6).addBox(-2.2128F, -0.9758F, 1.1166F, 3.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4957F, 0.0F, 0.0F, -1.1811F, 0.05F, -0.121F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Mask.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Mask.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Mask.xRot = headPitch / (180F / (float) Math.PI);
	}
}
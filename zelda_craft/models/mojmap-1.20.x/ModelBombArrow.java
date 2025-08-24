// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBombArrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bombarrow"), "main");
	private final ModelPart arrow;

	public ModelBombArrow(ModelPart root) {
		this.arrow = root.getChild("arrow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arrow = partdefinition.addOrReplaceChild("arrow", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.4072F, 7.5927F, 0.1032F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r1 = arrow.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(5, 8).addBox(-2.5F, -2.75F, -2.5F, 5.0F, 0.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 4.8218F, -1.5708F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = arrow.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(-13, 13).addBox(-2.5F, 0.0F, -3.75F, 5.0F, 0.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 4.8218F, 3.1416F, 0.0F, -2.3562F));

		PartDefinition cube_r3 = arrow.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(10, -1).addBox(0.0F, 0.0F, -0.5F, 0.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.526F, -2.9749F, -6.5735F, 0.3093F, -0.346F, -0.2701F));

		PartDefinition cube_r4 = arrow.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(10, 0).mirror()
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0928F, 0.8073F, -5.4282F, 0.3093F, -0.346F, -0.2701F));

		PartDefinition cube_r5 = arrow.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(-13, 0).addBox(-2.5F, 0.0F, -3.75F, 5.0F, 0.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 4.8218F, 3.1416F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		arrow.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
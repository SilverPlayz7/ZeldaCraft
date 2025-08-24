// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSilverArrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "silverarrow"), "main");
	private final ModelPart arrow;

	public ModelSilverArrow(ModelPart root) {
		this.arrow = root.getChild("arrow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arrow = partdefinition.addOrReplaceChild("arrow", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.4072F, 3.5927F, 0.1032F, -1.5708F, 0.7854F, 0.0F));

		PartDefinition cube_r1 = arrow.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(5, 11).addBox(-2.5F, -4.5F, -2.5F, 5.0F, 0.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 3.0718F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = arrow.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(-16, 0).addBox(-2.5F, 0.0F, -6.5F, 5.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 2.0718F, 3.1416F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = arrow.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(-16, 0).addBox(-2.5F, 0.0F, -6.5F, 5.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0928F, 0.4073F, 2.0718F, 3.1416F, 0.0F, 0.0F));

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
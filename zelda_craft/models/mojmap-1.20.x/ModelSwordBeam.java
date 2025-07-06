// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSwordBeam<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "swordbeam"), "main");
	private final ModelPart Swordbeam;

	public ModelSwordBeam(ModelPart root) {
		this.Swordbeam = root.getChild("Swordbeam");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Swordbeam = partdefinition.addOrReplaceChild("Swordbeam", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = Swordbeam.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(-16, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Swordbeam.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
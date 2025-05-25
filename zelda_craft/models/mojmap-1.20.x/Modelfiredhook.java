// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelfiredhook<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "firedhook"), "main");
	private final ModelPart Hook;
	private final ModelPart bone;
	private final ModelPart bone2;

	public Modelfiredhook(ModelPart root) {
		this.Hook = root.getChild("Hook");
		this.bone = this.Hook.getChild("bone");
		this.bone2 = this.Hook.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hook = partdefinition.addOrReplaceChild("Hook",
				CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -4.55F, -1.0F, 2.0F, 10.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 3.0F, -7.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bone = Hook.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(-1.6F, -5.3F, 1.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-7.9542F, -16.731F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.5461F, 18.3514F, -1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(5.9542F, -16.731F, -1.0F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6539F, 18.3514F, -1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition bone2 = Hook.addOrReplaceChild("bone2", CubeListBuilder.create(),
				PartPose.offset(-1.6F, -5.3F, 1.0F));

		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.15F, 8.6736F, 6.0928F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.75F, -10.495F, -4.3098F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.15F, -16.6736F, 6.0928F, 2.0F, 8.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.75F, 18.3514F, -1.0961F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Hook.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}
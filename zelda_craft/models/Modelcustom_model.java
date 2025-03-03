// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer Left;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer Wing;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer Right;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer Wing2;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
	private final ModelRenderer bone27;
	private final ModelRenderer bone28;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		Left = new ModelRenderer(this);
		Left.setRotationPoint(2.0F, 12.0F, 0.0F);
		Left.setTextureOffset(42, 56).addBox(-1.75F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, 0.0F, false);
		Left.setTextureOffset(48, 56).addBox(-2.1F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		Left.setTextureOffset(52, 58).addBox(-2.2F, 6.0F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
		Left.setTextureOffset(46, 58).addBox(-1.7F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		Left.setTextureOffset(0, 0).addBox(-2.05F, 7.906F, -2.3112F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		Left.setTextureOffset(0, 0).addBox(1.2F, 7.906F, -2.3112F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		Left.setTextureOffset(0, 0).addBox(-1.8F, 7.156F, 1.1388F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		Left.setTextureOffset(0, 0).addBox(-2.05F, 7.156F, 1.1388F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-2.5F, 9.5F, -4.75F);
		Left.addChild(bone);
		setRotationAngle(bone, 0.3927F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(0.7F, 0.4557F, 1.8045F, 4.0F, 2.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(0.45F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-3.0F, 9.0F, -4.25F);
		Left.addChild(bone2);
		setRotationAngle(bone2, 0.7418F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 0).addBox(1.2F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(0.95F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-3.5F, 8.5F, -3.75F);
		Left.addChild(bone3);
		setRotationAngle(bone3, -0.3927F, 0.0F, 0.0F);
		bone3.setTextureOffset(0, 0).addBox(1.7F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(1.45F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(5.0F, 12.0F, -0.25F);
		Left.addChild(bone4);
		bone4.setTextureOffset(0, 0).addBox(-6.8F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(-7.05F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		Wing = new ModelRenderer(this);
		Wing.setRotationPoint(3.0F, 12.0F, 0.25F);
		Left.addChild(Wing);
		Wing.setTextureOffset(53, 51).addBox(-1.0F, -6.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Wing.setTextureOffset(51, 51).addBox(-1.0F, -5.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Wing.setTextureOffset(52, 52).addBox(-1.0F, -5.5F, 0.95F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Wing.setTextureOffset(55, 51).addBox(-1.0F, -7.014F, 1.9233F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-0.5F, -6.4F, 1.25F);
		Wing.addChild(bone9);
		setRotationAngle(bone9, 0.1745F, 0.0F, 0.0F);
		bone9.setTextureOffset(51, 51).addBox(-0.5F, -0.4878F, -1.2303F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-1.0F, -5.15F, -1.0F);
		Wing.addChild(bone10);
		setRotationAngle(bone10, -0.5236F, 0.0F, 0.0F);
		bone10.setTextureOffset(50, 51).addBox(0.0F, -1.0531F, -0.608F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-0.5F, -6.305F, -0.7662F);
		Wing.addChild(bone11);
		setRotationAngle(bone11, 0.3054F, 0.0F, 0.0F);
		bone11.setTextureOffset(43, 50).addBox(-0.5F, -0.1285F, -0.2046F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-2.0F, -4.5181F, -1.2779F);
		Wing.addChild(bone12);
		setRotationAngle(bone12, 0.3491F, 0.0F, 0.0F);
		bone12.setTextureOffset(50, 51).addBox(1.0F, -0.059F, -0.2149F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-1.0F, -4.0261F, -1.0722F);
		Wing.addChild(bone13);
		setRotationAngle(bone13, -0.0436F, 0.0F, 0.0F);
		bone13.setTextureOffset(43, 50).addBox(0.0F, -0.5309F, -0.0653F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(-0.5F, -6.25F, 1.6F);
		Wing.addChild(bone14);
		setRotationAngle(bone14, 0.3927F, 0.0F, 0.0F);
		bone14.setTextureOffset(50, 50).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(-0.5F, -4.8778F, -0.1263F);
		Wing.addChild(bone15);
		setRotationAngle(bone15, -1.0036F, 0.0F, 0.0F);
		bone15.setTextureOffset(49, 51).addBox(-0.5F, -0.7879F, -0.5015F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-0.5F, -5.2286F, 0.9344F);
		Wing.addChild(bone16);
		setRotationAngle(bone16, -0.5672F, 0.0F, 0.0F);
		bone16.setTextureOffset(55, 51).addBox(-0.5F, -0.215F, -0.015F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(-1.0F, -4.3746F, 1.1501F);
		Wing.addChild(bone17);
		setRotationAngle(bone17, -1.0472F, 0.0F, 0.0F);
		bone17.setTextureOffset(53, 51).addBox(0.0F, -0.7554F, -0.7087F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(-0.5F, -5.75F, 1.1F);
		Wing.addChild(bone18);
		setRotationAngle(bone18, -0.6545F, 0.0F, 0.0F);
		bone18.setTextureOffset(44, 51).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Right = new ModelRenderer(this);
		Right.setRotationPoint(-2.0F, 12.0F, 0.0F);
		Right.setTextureOffset(0, 0).addBox(-2.15F, 7.906F, -2.3112F, 1.0F, 4.0F, 4.0F, 0.0F, true);
		Right.setTextureOffset(42, 56).addBox(-2.2F, 11.1F, -4.5F, 4.0F, 1.0F, 7.0F, 0.0F, true);
		Right.setTextureOffset(48, 56).addBox(1.15F, 11.1F, -4.5F, 1.0F, 1.0F, 7.0F, 0.0F, true);
		Right.setTextureOffset(46, 57).addBox(-2.25F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, 0.0F, true);
		Right.setTextureOffset(46, 58).addBox(-1.75F, 6.0F, -2.5F, 4.0F, 2.0F, 5.0F, 0.0F, true);
		Right.setTextureOffset(0, 0).addBox(-1.9F, 7.906F, -2.3112F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		Right.setTextureOffset(0, 0).addBox(1.1F, 7.906F, 1.1388F, 1.0F, 4.0F, 1.0F, 0.0F, true);
		Right.setTextureOffset(0, 0).addBox(-2.15F, 7.906F, 1.1388F, 4.0F, 4.0F, 1.0F, 0.0F, true);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(1.5F, 9.5F, -4.75F);
		Right.addChild(bone5);
		setRotationAngle(bone5, 0.3927F, 0.0F, 0.0F);
		bone5.setTextureOffset(0, 0).addBox(-3.4F, 0.4557F, 1.8045F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		bone5.setTextureOffset(0, 0).addBox(-3.65F, 0.4557F, 1.8045F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(1.0F, 9.0F, -4.25F);
		Right.addChild(bone6);
		setRotationAngle(bone6, 0.7418F, 0.0F, 0.0F);
		bone6.setTextureOffset(0, 0).addBox(-2.9F, 1.0762F, -0.1666F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-3.15F, 1.0762F, -0.1666F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.5F, 8.5F, -3.75F);
		Right.addChild(bone7);
		setRotationAngle(bone7, -0.3927F, 0.0F, 0.0F);
		bone7.setTextureOffset(0, 0).addBox(-2.4F, 1.2591F, 0.6343F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone7.setTextureOffset(0, 0).addBox(-2.65F, 1.2591F, 0.6343F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(9.0F, 12.0F, -0.25F);
		Right.addChild(bone8);
		bone8.setTextureOffset(0, 0).addBox(-10.9F, -1.1701F, -3.7785F, 4.0F, 1.0F, 5.0F, 0.0F, false);
		bone8.setTextureOffset(0, 0).addBox(-11.15F, -1.1701F, -3.7785F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		Wing2 = new ModelRenderer(this);
		Wing2.setRotationPoint(-3.0F, 12.0F, 0.25F);
		Right.addChild(Wing2);
		Wing2.setTextureOffset(53, 51).addBox(0.0F, -6.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		Wing2.setTextureOffset(51, 51).addBox(0.0F, -5.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);
		Wing2.setTextureOffset(52, 52).addBox(0.0F, -5.5F, 0.95F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		Wing2.setTextureOffset(55, 51).addBox(0.0F, -7.014F, 1.9233F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.5F, -6.4F, 1.25F);
		Wing2.addChild(bone19);
		setRotationAngle(bone19, 0.1745F, 0.0F, 0.0F);
		bone19.setTextureOffset(51, 51).addBox(-0.5F, -0.4878F, -1.2303F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(1.0F, -5.15F, -1.0F);
		Wing2.addChild(bone20);
		setRotationAngle(bone20, -0.5236F, 0.0F, 0.0F);
		bone20.setTextureOffset(50, 51).addBox(-1.0F, -1.0531F, -0.608F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.5F, -6.305F, -0.7662F);
		Wing2.addChild(bone21);
		setRotationAngle(bone21, 0.3054F, 0.0F, 0.0F);
		bone21.setTextureOffset(43, 50).addBox(-0.5F, -0.1285F, -0.2046F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(2.0F, -4.5181F, -1.2779F);
		Wing2.addChild(bone22);
		setRotationAngle(bone22, 0.3491F, 0.0F, 0.0F);
		bone22.setTextureOffset(50, 51).addBox(-2.0F, -0.059F, -0.2149F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(1.0F, -4.0261F, -1.0722F);
		Wing2.addChild(bone23);
		setRotationAngle(bone23, -0.0436F, 0.0F, 0.0F);
		bone23.setTextureOffset(43, 50).addBox(-1.0F, -0.5309F, -0.0653F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.5F, -6.25F, 1.6F);
		Wing2.addChild(bone24);
		setRotationAngle(bone24, 0.3927F, 0.0F, 0.0F);
		bone24.setTextureOffset(50, 50).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.5F, -4.8778F, -0.1263F);
		Wing2.addChild(bone25);
		setRotationAngle(bone25, -1.0036F, 0.0F, 0.0F);
		bone25.setTextureOffset(49, 51).addBox(-0.5F, -0.7879F, -0.5015F, 1.0F, 1.0F, 2.0F, 0.0F, true);

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.5F, -5.2286F, 0.9344F);
		Wing2.addChild(bone26);
		setRotationAngle(bone26, -0.5672F, 0.0F, 0.0F);
		bone26.setTextureOffset(55, 51).addBox(-0.5F, -0.215F, -0.015F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(1.0F, -4.3746F, 1.1501F);
		Wing2.addChild(bone27);
		setRotationAngle(bone27, -1.0472F, 0.0F, 0.0F);
		bone27.setTextureOffset(53, 51).addBox(-1.0F, -0.7554F, -0.7087F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.5F, -5.75F, 1.1F);
		Wing2.addChild(bone28);
		setRotationAngle(bone28, -0.6545F, 0.0F, 0.0F);
		bone28.setTextureOffset(44, 51).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Left.render(matrixStack, buffer, packedLight, packedOverlay);
		Right.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
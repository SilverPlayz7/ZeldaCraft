// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelBoomerang extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;

	public ModelBoomerang() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(8.0F, 24.0F, -8.0F);
		bone.setTextureOffset(15, 16).addBox(-15.6213F, -1.0F, 1.9858F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		bone.setTextureOffset(12, 13).addBox(-1.1287F, -1.0F, 1.9858F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 12).addBox(-9.25F, -0.5F, 8.0F, 2.0F, 0.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-6.3181F, -0.5F, 11.1681F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.setTextureOffset(5, 6).addBox(-2.825F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-9.6819F, -0.5F, 11.1681F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.setTextureOffset(4, 5).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-8.2315F, 0.5F, 6.5487F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(9, 5).addBox(-0.125F, -1.5F, -0.475F, 0.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-6.7426F, -0.5F, 9.7426F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.3927F, 0.0F);
		cube_r4.setTextureOffset(3, 5).addBox(-0.5F, -0.5F, -3.25F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-9.2574F, -0.5F, 9.7426F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.3927F, 0.0F);
		cube_r5.setTextureOffset(4, 5).addBox(-0.5F, -0.5F, -3.25F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-14.9142F, -0.5F, 2.6716F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.7854F, 0.0F);
		cube_r6.setTextureOffset(12, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-1.0858F, -0.5F, 2.6716F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.7854F, 0.0F);
		cube_r7.setTextureOffset(12, 14).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-2.5F, -0.5F, 5.5F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.7854F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(-5.75F, -0.25F, -1.5F, 8.0F, 0.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-13.5F, -0.5F, 5.5F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.7854F, 0.0F);
		cube_r9.setTextureOffset(0, 2).addBox(-2.5F, -0.25F, -1.5F, 8.0F, 0.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone.rotateAngleX = f2;
	}
}
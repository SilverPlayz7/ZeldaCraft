// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelLinkHood5 extends EntityModel<Entity> {
	private final ModelRenderer Hood;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public ModelLinkHood5() {
		textureWidth = 64;
		textureHeight = 64;

		Hood = new ModelRenderer(this);
		Hood.setRotationPoint(0.0F, 0.0F, 0.0F);
		Hood.setTextureOffset(3, 16).addBox(-4.0F, -11.2569F, 0.8772F, 9.0F, 5.0F, 4.0F, 0.0F, false);
		Hood.setTextureOffset(1, 12).addBox(-4.0F, -6.2569F, 1.8772F, 9.0F, 2.0F, 3.0F, 0.0F, false);
		Hood.setTextureOffset(1, 16).addBox(-4.0F, -4.2569F, 2.8772F, 9.0F, 2.0F, 2.0F, 0.0F, false);
		Hood.setTextureOffset(7, 15).addBox(-2.425F, -5.0707F, 5.5752F, 6.0F, 3.0F, 5.0F, 0.0F, false);
		Hood.setTextureOffset(7, 16).addBox(-1.925F, -3.0707F, 5.0752F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		Hood.setTextureOffset(9, 16).addBox(-1.425F, -1.0707F, 5.8252F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Hood.setTextureOffset(5, 16).addBox(-0.925F, 0.9293F, 6.3252F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-7.0F, -1.4668F, 0.9254F);
		Hood.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(8, 15).addBox(4.1F, -2.7524F, 4.4693F, 7.0F, 4.0F, 6.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(3.0F, -9.0633F, 1.702F, 9.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-7.0F, -1.4668F, 0.9254F);
		Hood.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(5, 16).addBox(3.575F, -1.2079F, 3.7978F, 8.0F, 4.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(3.0F, -7.7222F, 4.0408F, 9.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-7.0F, -1.4668F, 0.9254F);
		Hood.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.3927F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 1).addBox(3.0F, -2.5572F, 2.9045F, 9.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 12).addBox(3.0F, -10.5572F, -0.0955F, 9.0F, 8.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Hood.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelwarmdoublet extends EntityModel<Entity> {
	private final ModelRenderer RightArm2;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r1;
	private final ModelRenderer LeftArm2;
	private final ModelRenderer bone6;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Body2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer Belt2;
	private final ModelRenderer Buckle2;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer bone8;
	private final ModelRenderer bone7;
	private final ModelRenderer Bottompartleft;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer bottompartright;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;

	public Modelwarmdoublet() {
		textureWidth = 64;
		textureHeight = 64;

		RightArm2 = new ModelRenderer(this);
		RightArm2.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm2.setTextureOffset(0, 0).addBox(-0.0063F, 0.5984F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-1.0233F, -1.3881F, -2.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-1.0233F, -2.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(0.0017F, -2.0881F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(0.0017F, -2.2881F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(0.0017F, -1.4131F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-3.7233F, -2.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-2.7233F, -2.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-3.7233F, -2.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-2.7233F, -2.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-1.0233F, -2.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 0).addBox(-2.25F, -1.25F, -2.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(48, 0).addBox(-3.25F, -0.75F, -1.725F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		RightArm2.setTextureOffset(54, 0).addBox(0.15F, -0.75F, -1.725F, 1.0F, 8.0F, 4.0F, 0.0F, false);
		RightArm2.setTextureOffset(0, 54).addBox(-3.7F, 5.3F, -2.3F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		RightArm2.setTextureOffset(48, 0).addBox(-2.9F, -0.75F, -2.275F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		RightArm2.setTextureOffset(48, 0).addBox(-3.25F, -0.75F, -2.275F, 1.0F, 8.0F, 4.0F, 0.0F, false);
		RightArm2.setTextureOffset(5, 58).addBox(-3.7F, 5.3F, -2.7F, 5.0F, 5.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(1.0F, -0.25F, -3.0F);
		RightArm2.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.9163F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(4.0F, -1.75F, 3.0F);
		bone3.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3491F);
		cube_r1.setTextureOffset(0, 0).addBox(-8.7912F, 1.1074F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		LeftArm2 = new ModelRenderer(this);
		LeftArm2.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm2.setTextureOffset(0, 0).addBox(-0.9937F, 0.5984F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-0.9767F, -1.0881F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-0.75F, -1.25F, -2.5F, 3.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(1.7483F, -2.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(0.4733F, -2.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-0.9767F, -2.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(1.7483F, -2.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-0.9767F, -2.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(0.4733F, -2.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-1.0017F, -2.0881F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-1.0017F, -2.2881F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-1.0017F, -1.4131F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 0).addBox(-0.4F, -1.35F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(0, 54).addBox(-1.3F, 5.3F, -2.3F, 5.0F, 5.0F, 5.0F, 0.0F, true);
		LeftArm2.setTextureOffset(46, 1).addBox(-0.75F, -0.75F, -1.725F, 4.0F, 8.0F, 4.0F, 0.0F, true);
		LeftArm2.setTextureOffset(54, 0).addBox(-1.2F, -0.75F, -1.725F, 1.0F, 8.0F, 4.0F, 0.0F, true);
		LeftArm2.setTextureOffset(5, 58).addBox(-1.3F, 5.3F, -2.7F, 5.0F, 5.0F, 1.0F, 0.0F, true);
		LeftArm2.setTextureOffset(54, 0).addBox(-1.1F, -0.75F, -2.275F, 4.0F, 8.0F, 4.0F, 0.0F, true);
		LeftArm2.setTextureOffset(54, 0).addBox(2.25F, -0.75F, -2.275F, 1.0F, 8.0F, 4.0F, 0.0F, true);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-1.0F, -0.25F, -3.0F);
		LeftArm2.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0F, -0.9163F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-4.0F, -1.75F, 3.0F);
		bone6.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.3491F);
		cube_r2.setTextureOffset(0, 0).addBox(3.8123F, 1.1208F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, true);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.setTextureOffset(20, 28).addBox(-1.7233F, -0.2881F, 1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(-1.2767F, -0.2881F, 1.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(1.7233F, -0.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(1.9983F, -0.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(-3.9983F, -0.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(-3.7233F, -0.0881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(1.7233F, -0.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(1.9983F, -0.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(-3.7233F, -0.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(-3.9983F, -0.2881F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(-4.0F, 0.1F, -2.5F, 2.0F, 12.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(-1.95F, 2.1F, -2.5F, 4.0F, 10.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(1.75F, 0.1F, -2.5F, 2.0F, 12.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(2.0F, 0.1F, -2.5F, 2.0F, 12.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(-2.0F, 1.1F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(1.0F, 1.1F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(-2.0F, 1.4F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(-4.0F, 0.4F, -2.5F, 2.0F, 12.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(1.75F, 0.4F, -2.5F, 2.0F, 12.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(1.0F, 1.4F, -2.5F, 1.0F, 11.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(-1.95F, 2.4F, -2.5F, 4.0F, 10.0F, 5.0F, 0.0F, false);
		Body2.setTextureOffset(20, 28).addBox(2.0F, 0.4F, -2.5F, 2.0F, 12.0F, 5.0F, 0.0F, true);
		Body2.setTextureOffset(20, 28).addBox(-0.5F, 1.65F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
		cube_r3.setTextureOffset(20, 28).addBox(-0.8248F, 1.2635F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.6545F);
		cube_r4.setTextureOffset(20, 28).addBox(0.3153F, 1.3884F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.6545F);
		cube_r5.setTextureOffset(20, 28).addBox(-1.3153F, 1.3884F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, true);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 0.8727F);
		cube_r6.setTextureOffset(20, 28).addBox(-1.1752F, 1.2635F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		Belt2 = new ModelRenderer(this);
		Belt2.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body2.addChild(Belt2);
		Belt2.setTextureOffset(27, 58).addBox(-4.0F, -14.4F, -2.8F, 8.0F, 1.0F, 5.0F, 0.0F, false);
		Belt2.setTextureOffset(27, 58).addBox(-4.0F, -14.4F, -2.2F, 8.0F, 1.0F, 5.0F, 0.0F, false);
		Belt2.setTextureOffset(27, 58).addBox(-3.5F, -15.0F, 2.2F, 3.0F, 4.0F, 1.0F, 0.0F, false);
		Belt2.setTextureOffset(27, 58).addBox(-3.5F, -15.0F, 2.425F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Buckle2 = new ModelRenderer(this);
		Buckle2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Belt2.addChild(Buckle2);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, -24.0F, 0.0F);
		Buckle2.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -1.5708F, 0.0F);
		cube_r7.setTextureOffset(38, 53).addBox(-3.0F, 9.975F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r7.setTextureOffset(38, 53).addBox(-3.0F, 9.2F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, -24.0F, 0.0F);
		Buckle2.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.8727F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(38, 53).addBox(-2.0F, 8.3527F, 6.479F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(38, 53).addBox(-2.0F, 7.2118F, 5.1192F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.setTextureOffset(38, 53).addBox(-1.0F, 7.7359F, 5.8471F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.0F, -24.0F, 0.0F);
		Buckle2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.7854F, 0.0F);
		cube_r9.setTextureOffset(38, 53).addBox(-3.8355F, 10.675F, 0.0071F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 1.75F, -3.5F);
		Body2.addChild(bone8);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 1.75F, -3.5F);
		Body2.addChild(bone7);

		Bottompartleft = new ModelRenderer(this);
		Bottompartleft.setRotationPoint(0.0F, 0.0F, 0.0F);
		Bottompartleft.setTextureOffset(0, 0).addBox(0.0F, 11.5792F, -2.5056F, 4.0F, 1.0F, 5.0F, 0.0F, true);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.5F, 14.9488F, -2.4417F);
		Bottompartleft.addChild(cube_r10);
		setRotationAngle(cube_r10, 1.3977F, 0.0227F, -0.1288F);
		cube_r10.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -3.75F, 3.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(3.1603F, 10.5172F, 0.0F);
		Bottompartleft.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 1.3963F);
		cube_r11.setTextureOffset(0, 0).addBox(2.0F, -0.5F, -2.5F, 6.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(3.5F, 12.9792F, 2.0944F);
		Bottompartleft.addChild(cube_r12);
		setRotationAngle(cube_r12, -1.3963F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(0, 0).addBox(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 6.0F, 0.0F, false);

		bottompartright = new ModelRenderer(this);
		bottompartright.setRotationPoint(-1.5F, 14.9488F, -2.4417F);
		bottompartright.setTextureOffset(0, 0).addBox(-2.5F, -3.3696F, -0.0639F, 4.0F, 1.0F, 5.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
		bottompartright.addChild(cube_r13);
		setRotationAngle(cube_r13, 1.3977F, 0.0227F, 0.1289F);
		cube_r13.setTextureOffset(0, 0).addBox(-2.5F, -0.5F, -3.75F, 3.0F, 1.0F, 7.0F, 0.0F, true);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-1.6603F, -4.4316F, 2.4417F);
		bottompartright.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -1.3963F);
		cube_r14.setTextureOffset(0, 0).addBox(-8.0F, -0.5F, -2.5F, 6.0F, 1.0F, 5.0F, 0.0F, true);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-2.0F, -1.9696F, 4.5361F);
		bottompartright.addChild(cube_r15);
		setRotationAngle(cube_r15, -1.3963F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 6.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		RightArm2.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm2.render(matrixStack, buffer, packedLight, packedOverlay);
		Body2.render(matrixStack, buffer, packedLight, packedOverlay);
		Bottompartleft.render(matrixStack, buffer, packedLight, packedOverlay);
		bottompartright.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.bottompartright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LeftArm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Bottompartleft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}
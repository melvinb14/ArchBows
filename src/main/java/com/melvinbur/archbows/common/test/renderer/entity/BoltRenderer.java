package com.melvinbur.archbows.common.test.renderer.entity;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
/**
public class BoltRenderer<T extends BoltEntity> extends ArrowRenderer<T> {
    public BoltRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public ResourceLocation getEntityTexture(T entity) {
        return entity.getTexture();
    }

    public void render(T entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.yRotO) - 90.0F));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.xRotO)));
        matrixStackIn.translate(0.20000000298023224, 0.0, 0.0);
        float f9 = (float) entityIn.shakeTime - partialTicks;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(f10));
        }

        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(45.0F));
        matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);
        matrixStackIn.translate(-4.0, 0.0, 0.0);
        VertexConsumer vertexBuilder = bufferIn.getBuffer(RenderType.entityCutout(this.getEntityTexture(entityIn)));
        PoseStack.Pose matrixEntry = matrixStackIn.last();
        Matrix4f matrix = matrixEntry.pose();
        Matrix3f normalMatrix = matrixEntry.normal();
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
        this.vertex(matrix, normalMatrix, vertexBuilder, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, packedLightIn);

        for (int j = 0; j < 4; ++j) {
            matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            this.vertex(matrix, normalMatrix, vertexBuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(matrix, normalMatrix, vertexBuilder, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(matrix, normalMatrix, vertexBuilder, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, packedLightIn);
            this.vertex(matrix, normalMatrix, vertexBuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
        }

        matrixStackIn.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {

            return new ResourceLocation("archbows", "textures/entity/projectiles/" );
        }

    }



**/
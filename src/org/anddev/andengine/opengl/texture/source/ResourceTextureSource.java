/**
 * 
 */
package org.anddev.andengine.opengl.texture.source;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author Nicolas Gramlich
 * @since 15:07:23 - 09.03.2010
 */
public class ResourceTextureSource implements ITextureSource {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final int mWidth;
	private final int mHeight;

	private final int mDrawableResourceID;
	private final Context mContext;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ResourceTextureSource(final Context pContext, final int pDrawableResourceID) {
		this.mContext = pContext;
		this.mDrawableResourceID = pDrawableResourceID;

		final BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		decodeOptions.inJustDecodeBounds = true;

		BitmapFactory.decodeResource(pContext.getResources(), pDrawableResourceID, decodeOptions);

		this.mWidth = decodeOptions.outWidth;
		this.mHeight = decodeOptions.outHeight;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public int getHeight() {
		return this.mHeight;
	}

	@Override
	public int getWidth() {
		return this.mWidth;
	}

	@Override
	public Bitmap getBitmap() {
		return BitmapFactory.decodeResource(this.mContext.getResources(), this.mDrawableResourceID);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
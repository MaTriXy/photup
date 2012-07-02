package uk.co.senab.photup.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

public abstract class PhotoUpload {

	private Uri mEditedPhotoUri;

	public abstract Uri getOriginalPhotoUri();

	public abstract Bitmap getThumbnail(Context context);

	public abstract Bitmap getOriginal(Context context);

	public String getThumbnailKey() {
		return "thumb_" + getOriginalPhotoUri();
	}

	public String getOriginalKey() {
		return "full_" + getOriginalPhotoUri();
	}

	public void setEditedPhotoUri(Uri uri) {
		mEditedPhotoUri = uri;
	}

	public Uri getEditedPhotoUri() {
		return mEditedPhotoUri;
	}

	@Override
	public int hashCode() {
		return getOriginalPhotoUri().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MediaStorePhotoUpload) {
			return getOriginalPhotoUri().equals(((MediaStorePhotoUpload) obj).getOriginalPhotoUri());
		}
		return false;
	}

}
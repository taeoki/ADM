/*
 * Copyright (C) 2009-2013 adakoda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nts.gt.adm;

import java.awt.image.BufferedImage;

public class FBImage extends BufferedImage {

	private int mRawWidth;
	private int mRawHeight;

	public FBImage(int width, int height, int imageType, int rawWidth,
			int rawHeight) {
		super(width, height, imageType);
		mRawWidth = rawWidth;
		mRawHeight = rawHeight;
	}

	public int getRawWidth() {
		return mRawWidth;
	}

	public int getRawHeight() {
		return mRawHeight;
	}
}

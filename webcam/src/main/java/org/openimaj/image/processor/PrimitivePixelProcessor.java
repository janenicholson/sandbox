package org.openimaj.image.processor;

import java.util.stream.IntStream;

import org.openimaj.image.processor.PixelProcessor;

public abstract class PrimitivePixelProcessor implements PixelProcessor<Float[]> {

	@Override
	public Float[] processPixel(Float[] pixel) {
		return box(processPixel(unbox(pixel)));
	}

	public abstract float[] processPixel(float[] pixel);

	private float[] unbox(Float[] pixel) {
		float[] result = new float[pixel.length];
		for (int i = 0; i < pixel.length; i++)
			result[i] = pixel[i];
		return result;
	}

	private Float[] box(float[] pixel) {
		return IntStream.range(0, pixel.length).mapToObj(i -> pixel[i]).toArray(Float[] :: new);
	}
}
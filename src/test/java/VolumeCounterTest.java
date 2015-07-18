import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VolumeCounterTest {

	private VolumeCounter volumeCounter = new VolumeCounter();

	@Test
	public void testGetSimpleVolume() throws Exception {
		int[] simplePool = {2, 2, 4, 4, 0, 0, 0, 1, 2, 2};

		assertEquals(7, volumeCounter.getVolume(simplePool));
	}

	@Test
	public void testGetComplicatedVolume() throws Exception {
		int[] simplePool = {4, 0, 0, 0, 1, 2, 2, 0, 0, 3, 3, 5, 5, 3, 7, 4};
		assertEquals(31, volumeCounter.getVolume(simplePool));
	}
}

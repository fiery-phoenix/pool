import java.util.ArrayList;
import java.util.List;

/**
 * @author Kseniya Panasyuk
 */
public class VolumeCounter {

	public int getVolume(int[] mainPool) {
		if (mainPool.length <= 2) {
			return 0;
		}

		List<Pool> pools = new ArrayList<>();
		Pool currentPool = new Pool(mainPool[0]);
		for (int point : mainPool) {
			if (!currentPool.addPoint(point)) {
				pools.add(currentPool);
				currentPool = new Pool(point);
			}
		}

		int overallVolume = currentPool.getVolume();
		for (Pool pool : pools) {
			overallVolume += pool.getVolume();
		}

		return overallVolume;
	}

	private class Pool {

		private int max;
		private int currentMax;
		private List<Integer> landscape = new ArrayList<>();

		public Pool(int max) {
			this.max = max;
			currentMax = 0;
		}

		public boolean addPoint(int point) {
			if (point > max) {
				if (landscape.isEmpty()) {
					max = point;
				} else {
					currentMax = max;
					return false;
				}
			} else if (point == max) {
				return true;
			} else { // point < max
				landscape.add(point);
				if (point > currentMax) {
					currentMax = point;
				}
			}
			return true;
		}

		public int getVolume() {
			if (landscape.isEmpty()) {
				return 0;
			}

			int depth = 0;
			for (int point : landscape) {
				depth += currentMax - point;
			}

			return depth;
		}
	}

}

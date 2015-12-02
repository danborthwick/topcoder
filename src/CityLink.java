import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class CityLink {
    static class City {
        public final int x;
        public final int y;

        City(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int timeTaken(int[] x, int[] y) {
        List<List<City>> clusters = new ArrayList(x.length);

        for (int i=0; i < x.length; i++) {
            List<City> cluster = new ArrayList(x.length);
            cluster.add(new City(x[i], y[i]));
            clusters.add(cluster);
        }

        int elapsed = 0;
        while (clusters.size() > 1)
        {
            int nextMergeTime = Integer.MAX_VALUE;
            List<City> firstClusterToMerge = null;
            List<City> secondClusterToMerge = null;

            for (int firstClusterId = 0; firstClusterId < clusters.size(); firstClusterId++) {
                for (int secondClusterId = firstClusterId + 1; secondClusterId < clusters.size(); secondClusterId++) {
                    int firstContactTime = firstContactTime(clusters.get(firstClusterId), clusters.get(secondClusterId));
                    if (firstContactTime < nextMergeTime) {
                        nextMergeTime = firstContactTime;
                        firstClusterToMerge = clusters.get(firstClusterId);
                        secondClusterToMerge = clusters.get(secondClusterId);
                    }
                }
            }

            merge(firstClusterToMerge, secondClusterToMerge, clusters);
            elapsed = nextMergeTime;
        }

        return elapsed;
    }

    private static void merge(List<City> to, List<City> from, List<List<City>> clusters) {
        to.addAll(from);
        clusters.remove(from);
    }

    private static int firstContactTime(List<City> cluster1, List<City> cluster2) {

        int nextContact = Integer.MAX_VALUE;

        for (City city1 : cluster1) {
            for (City city2 : cluster2) {
                int cityContactTime = getCityContactTime(city1, city2);
                nextContact = min(nextContact, cityContactTime);
            }
        }

        return nextContact;
    }

    private static int getCityContactTime(City city1, City city2) {
        int dx = abs(city1.x - city2.x);
        int dy = abs(city1.y - city2.y);

        if (dx == 0) return (dy + 1) / 2;
        else if (dy == 0) return (dx + 1) / 2;
        else return max(dx, dy);
    }
}

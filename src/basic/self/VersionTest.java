package basic.self;

public class VersionTest {
    public static void main(String[] args) {

    }

    public static int compareVersion(String version1, String version2) {
        String[] splitVersion1 = version1.split("\\.");
        String[] splitVersion2 = version2.split("\\.");

        int length = Math.max(splitVersion1.length, splitVersion2.length);

        for (int i = 0; i < length; i++) {
            int part1 = (i < splitVersion1.length) ? Integer.parseInt(splitVersion1[i]) : 0;
            int part2 = (i < splitVersion2.length) ? Integer.parseInt(splitVersion2[i]) : 0;

            if (part1 < part2) return -1;
            if (part1 > part2) return 1;

        }
        return 0;
    }
}

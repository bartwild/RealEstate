package siphash;

public final class SipHasher {
    static final int DEFAULT_C = 2;
    static final int DEFAULT_D = 4;
    static final long INITIAL_V0 = 0x736f6d6570736575L;
    static final long INITIAL_V1 = 0x646f72616e646f6dL;
    static final long INITIAL_V2 = 0x6c7967656e657261L;
    static final long INITIAL_V3 = 0x7465646279746573L;
    public static long hash(byte[] key, byte[] data) {
        return hash(key, data, DEFAULT_C, DEFAULT_D);
    }
    public static long hash(byte[] key, byte[] data, int c, int d) {
        if (key.length != 16) {
            throw new IllegalArgumentException("Key must be exactly 16 bytes!");
        }

        long k0 = bytesToLong(key, 0);
        long k1 = bytesToLong(key, 8);

        return hash(
            c, d,
            INITIAL_V0 ^ k0,
            INITIAL_V1 ^ k1,
            INITIAL_V2 ^ k0,
            INITIAL_V3 ^ k1,
            data
        );
    }
    public static String toHexString(long hash) {
        String hex = Long.toHexString(hash);
        if (hex.length() == 16) {
            return hex;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 16 - hex.length(); i < j; i++) {
            sb.append('0');
        }
        return sb.append(hex).toString();
    }
    static long bytesToLong(byte[] bytes, int offset) {
        long m = 0;
        for (int i = 0; i < 8; i++) {
            m |= ((((long) bytes[i + offset]) & 0xff) << (8 * i));
        }
        return m;
    }
    static long hash(int c, int d, long v0, long v1, long v2, long v3, byte[] data) {
        long m;
        int last = data.length / 8 * 8;
        int i = 0;
        int r;
        while (i < last) {
            m = data[i++] & 0xffL;
            for (r = 1; r < 8; r++) {
                m |= (data[i++] & 0xffL) << (r * 8);
            }

            v3 ^= m;
            for (r = 0; r < c; r++) {
                v0 += v1;
                v2 += v3;
                v1 = rotateLeft(v1, 13);
                v3 = rotateLeft(v3, 16);
                v1 ^= v0;
                v3 ^= v2;
                v0 = rotateLeft(v0, 32);
                v2 += v1;
                v0 += v3;
                v1 = rotateLeft(v1, 17);
                v3 = rotateLeft(v3, 21);
                v1 ^= v2;
                v3 ^= v0;
                v2 = rotateLeft(v2, 32);
            }
            v0 ^= m;
        }
        m = 0;
        for (i = data.length - 1; i >= last; --i) {
            m <<= 8;
            m |= (data[i] & 0xffL);
        }
        m |= (long) data.length << 56;
        v3 ^= m;
        for (r = 0; r < c; r++) {
            v0 += v1;
            v2 += v3;
            v1 = rotateLeft(v1, 13);
            v3 = rotateLeft(v3, 16);
            v1 ^= v0;
            v3 ^= v2;
            v0 = rotateLeft(v0, 32);
            v2 += v1;
            v0 += v3;
            v1 = rotateLeft(v1, 17);
            v3 = rotateLeft(v3, 21);
            v1 ^= v2;
            v3 ^= v0;
            v2 = rotateLeft(v2, 32);
        }
        v0 ^= m;
        v2 ^= 0xff;
        for (r = 0; r < d; r++) {
            v0 += v1;
            v2 += v3;
            v1 = rotateLeft(v1, 13);
            v3 = rotateLeft(v3, 16);
            v1 ^= v0;
            v3 ^= v2;
            v0 = rotateLeft(v0, 32);
            v2 += v1;
            v0 += v3;
            v1 = rotateLeft(v1, 17);
            v3 = rotateLeft(v3, 21);
            v1 ^= v2;
            v3 ^= v0;
            v2 = rotateLeft(v2, 32);
        }
        return v0 ^ v1 ^ v2 ^ v3;
    }
    static long rotateLeft(long value, int shift) {
        return (value << shift) | value >>> (64 - shift);
    }
}

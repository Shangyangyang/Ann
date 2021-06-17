package com.newheyd.base.util;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 生成一个32位的uuid，无“-”
	 * @return 32位的uuid
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	public static String generateShortUuid() {
		return generateShortUuid(8);
	}

	public static String generateShortUuid(int size) {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = getUUID();
		for (int i = 0; i < size; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	public static void main(String[] args) {
		System.out.println("generateShortUuid() = " + generateShortUuid());
	}
}

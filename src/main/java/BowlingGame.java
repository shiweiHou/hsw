public class BowlingGame {
	
    public int getBowlingScore(String bowlingCode) {
		int len = bowlingCode.length();
		int i = 0;
		int ret = 0;
		int count = 0;
		int []scores = new int [12];
		int []next = new int[12];
		while (i < len) {
			if (bowlingCode.charAt(i) == '|') {++i; continue;}
			char c = bowlingCode.charAt(i);
			if (c == 'X') {
				scores[count++] = 10;
				next[count++] = 2;
				++i;
			} else {
				char c1 = '#';
				if (i + 1 < len) c1 = bowlingCode.charAt(i+1);
				if (c1 != '#') {
					if (c1 == '-' && c == '-') {
						scores[count++] = 0;
						next[count++] = 0;
					} else if (c1 != '-' && c == '-') {
						scores[count++] = c1 - '0';
						next[count++] = 0;
					} else if (c1 == '-' && c != '-') {
						scores[count++] = c - '0';
						next[count++] = 0;
					} else if (c1 == '/') {
						scores[count++] = 5;
						next[count++] = 1;
					} else if (c1 != '-' && c != '-') {
						scores[count++] = (c - '0') + (c1 - '0');
						next[count++] = 0;
					}
					i += 2;
				}else {
					scores[count++] = c - '0';
					next[count++] = 0;
					++i;
				}
			}
			
		}
		int i = 0;
		for (; i < 10; ++i) {
			if (next[i] == 2) {
				ret += 10 + scores[i+1] + scores[i+2];
			} else if (next[i] == 1) {
				ret += 10 + scores[i+1];
			}else ret += scores[i];
		}
		return ret;

    }
}

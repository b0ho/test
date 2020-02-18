package solution;

// 새로운 객체로 만들어 사용하면 편함!
class Trie {
    Trie node[] = new Trie[26];
    int count = 0;
}

class 가사검색 {

    public static void main(String args[]) {
        가사검색 s = new 가사검색();
        String[] str1 = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
        String[] str2 = { "fro??", "????o", "fr???", "fro???", "pro?" };
        s.solution(str1, str2);
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[] tries_pre = new Trie[10001];
        Trie[] tries_rev = new Trie[10001];

        for (String word : words) {
            if (tries_pre[word.length()] == null) {
                tries_pre[word.length()] = new Trie();
            }
            update(word, tries_pre[word.length()]);
            tries_pre[word.length()].count++;

            if (tries_rev[word.length()] == null) {
                tries_rev[word.length()] = new Trie();
            }
            String word_rev = new StringBuffer(word).reverse().toString();
            update(word_rev, tries_rev[word.length()]);
            tries_rev[word.length()].count++;
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i].charAt(0) == '?') {
                String queries_rev = new StringBuffer(queries[i]).reverse().toString();
                answer[i] = find(queries_rev, tries_rev[queries[i].length()]);
            } else {
                answer[i] = find(queries[i], tries_pre[queries[i].length()]);
            }
            // System.out.println(answer[i]);
        }
        return answer;
    }

    public void update(String word, Trie trie) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 97;

            // System.out.print(word.charAt(i));
            // System.out.print(" " + idx + " ");

            if (trie.node[idx] == null) {
                trie.node[idx] = new Trie();
            }
            trie.node[idx].count++;
            trie = trie.node[idx];
        }
        // System.out.println();
    }

    public int find(String query, Trie trie) {
        if (trie == null)
            return 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != '?') {
                if (trie.node[query.charAt(i) - 97] == null)
                    return 0;
                trie = trie.node[query.charAt(i) - 97];
            } else
                break;
        }
        return trie.count;
    }

}
